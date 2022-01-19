package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5app.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	private SubscriptionServiceImpl() {

	}

	private SubscriptionRepositoryImpl subscriptionRepository = SubscriptionRepositoryImpl.getInstance();
	private static SubscriptionServiceImpl subscriptionService = null;

	public static SubscriptionServiceImpl getInstance() {
		if (subscriptionService == null)
			subscriptionService = new SubscriptionServiceImpl();
		return subscriptionService;
	}

	@Override
	public String addSubscription(Subscription subscription) {
		return this.subscriptionRepository.addSubscription(subscription);
	}

	@Override
	public String updateSubscriptionById(String id, Subscription subscription) {
		return this.subscriptionRepository.updateSubscriptionById(id, subscription);
	}

	@Override
	public String deleteSubscriptionById(String id) {
		return this.subscriptionRepository.deleteSubscriptionById(id);
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		return this.subscriptionRepository.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		return this.subscriptionRepository.getAllSubscriptions();
	}
}
