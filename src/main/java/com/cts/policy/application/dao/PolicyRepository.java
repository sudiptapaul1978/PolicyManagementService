package com.cts.policy.application.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.policy.application.document.Policy;

@Transactional
public interface PolicyRepository extends MongoRepository<Policy, String> {

	public Policy findByPolicyName(String policyName);

}
