package com.zee.zee5app.repository;

import java.util.Arrays;

import com.zee.zee5app.dto.Subscription;

public class SubscriptionRepository {

	private SubscriptionRepository() {
		
	}
	
	private static SubscriptionRepository subscriptionRepository = null;
	private Subscription[] subscriptions = new Subscription[10];
	private static int counter = 0;
	
	
	public static SubscriptionRepository getInstance() {
		if (subscriptionRepository==null)
			subscriptionRepository=new SubscriptionRepository();
		return subscriptionRepository;
	}
	
	public String addSubscription(Subscription subscription) {
		if(counter==subscriptions.length) {
			Subscription temp[]=new Subscription[2*subscriptions.length];
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
		}
		subscriptions[counter++] = subscription;
		return "success";
	}
	
	public String deleteSubscription(String id) {
		boolean found=false;
		for(int i=1;i<=this.counter;i++) {
			if(subscriptions[i-1]==null)
				break;
			if(subscriptions[i-1].getId().equals(id)) {
				found=true;
			}
			if(found) {
				if(i!=this.counter)
					subscriptions[i-1]=subscriptions[i];
			}
		}
		if(found) {
			subscriptions[--this.counter] = null;
			return "success";
		}
		return "failed! No objects found";
	}
	
	public String modifySubscription(String id, Subscription subscription) {
		for(int i=0;i<this.counter;i++) {
			if(subscriptions[i].getId().equals(id)) {
				subscriptions[i]=subscription;
				return "success";
			}
		}
		return "failed";
	}
	
	public Subscription getSubscriptionById(String id) {
		for(Subscription subscription:subscriptions) {
			if(subscription==null)
				return null;
			if(subscription.getId().equals(id))
				return subscription;
		}
		return null;
	}
	
	public Subscription[] getAllSubscriptions() {
		return Arrays.copyOf(subscriptions, this.counter);
	}
	
}
