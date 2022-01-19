package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;

public class SubscriptionService {
	private SubscriptionService() {
		
	}
	private SubscriptionRepository subscriptionRepository = SubscriptionRepository.getInstance();
	private static SubscriptionService subscriptionService = null;
	
	public static SubscriptionService getInstance() {
		if(subscriptionService==null)
			subscriptionService = new SubscriptionService();
		return subscriptionService;
	}
	
	public String addsubscription(Subscription subscription) {
		return this.subscriptionRepository.addSubscription(subscription);
	}
	
	public String modifyMovie(String id, Subscription subscription) {
		return this.subscriptionRepository.modifySubscription(id, subscription);
	}
	
	public String deleteMovie(String id) {
		return this.subscriptionRepository.deleteSubscription(id);
	}
	
	public Subscription getMovieById(String id) {
		return this.subscriptionRepository.getSubscriptionById(id);
	}
	public Subscription[] getAllMovies() {
		return this.subscriptionRepository.getAllSubscriptions();
	}
}
