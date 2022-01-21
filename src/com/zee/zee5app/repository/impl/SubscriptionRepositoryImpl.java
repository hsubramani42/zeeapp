package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	private SubscriptionRepositoryImpl() {

	}

	private static SubscriptionRepositoryImpl subscriptionRepository = null;
	private ArrayList<Subscription> subscriptions = new ArrayList<>();

	public static SubscriptionRepositoryImpl getInstance() {
		if (subscriptionRepository == null)
			subscriptionRepository = new SubscriptionRepositoryImpl();
		return subscriptionRepository;
	}

	@Override
	public String addSubscription(Subscription subscription) {
		return (subscriptions.add(subscription))?"Success! Object added":"Failed! Object not added.";
	}

	@Override
	public String deleteSubscriptionById(String id) {
		for(int i=0;i<subscriptions.size();i++)
			if(subscriptions.get(i).getId().equals(id)) {
				subscriptions.remove(i);
				return "Success! Deleted.";
			}
		return "Failed! No objects found.";
	}

	@Override
	public String updateSubscriptionById(String id, Subscription subscription) {
		for(int i=0;i<subscriptions.size();i++)
			if(subscriptions.get(i).getId().equals(id)) {
				subscriptions.set(i, subscription);
				return "Success! Updated.";
			}
		return "Failed! No objects found.";
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) {
		for(Subscription subscription:subscriptions)
			if(subscription.getId().equals(id))
				return Optional.of(subscription);
		return Optional.empty();
	}

	@Override
	public ArrayList<Subscription> getAllSubscriptions() {
		return subscriptions;
	}

}
