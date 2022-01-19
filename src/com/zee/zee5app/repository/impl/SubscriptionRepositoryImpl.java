package com.zee.zee5app.repository.impl;

import java.util.Arrays;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	private SubscriptionRepositoryImpl() {

	}

	private static SubscriptionRepositoryImpl subscriptionRepository = null;
	private Subscription[] subscriptions = new Subscription[10];
	private static int counter = 0;

	public static SubscriptionRepositoryImpl getInstance() {
		if (subscriptionRepository == null)
			subscriptionRepository = new SubscriptionRepositoryImpl();
		return subscriptionRepository;
	}

	@Override
	public String addSubscription(Subscription subscription) {
		if (counter == subscriptions.length) {
			Subscription temp[] = new Subscription[2 * subscriptions.length];
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
		}
		subscriptions[counter++] = subscription;
		return "success";
	}

	@Override
	public String deleteSubscriptionById(String id) {
		boolean found = false;
		for (int i = 1; i <= this.counter; i++) {
			if (subscriptions[i - 1] == null)
				break;
			if (subscriptions[i - 1].getId().equals(id)) {
				found = true;
			}
			if (found) {
				if (i != this.counter)
					subscriptions[i - 1] = subscriptions[i];
			}
		}
		if (found) {
			subscriptions[--this.counter] = null;
			return "success";
		}
		return "failed! No objects found";
	}

	@Override
	public String updateSubscriptionById(String id, Subscription subscription) {
		for (int i = 0; i < this.counter; i++) {
			if (subscriptions[i].getId().equals(id)) {
				subscriptions[i] = subscription;
				return "success";
			}
		}
		return "failed";
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		for (Subscription subscription : subscriptions) {
			if (subscription == null)
				return null;
			if (subscription.getId().equals(id))
				return subscription;
		}
		return null;
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		return Arrays.copyOf(subscriptions, this.counter);
	}

}
