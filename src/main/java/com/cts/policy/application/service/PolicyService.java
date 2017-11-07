package com.cts.policy.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cts.policy.application.commons.Utils;
import com.cts.policy.application.dao.PolicyRepository;
import com.cts.policy.application.document.Policy;

@Service
public class PolicyService {

	@Autowired
	public PolicyRepository policyRepository;

	/**
	 * This method creates or updates the policy
	 * @param policyNumber
	 * @param policyName
	 * @param policyDetails
	 * @return
	 */
	public boolean addOrUpdate(String policyNumber, String policyName, String policyDetails) {
		boolean success = false;

		if (StringUtils.isEmpty(policyNumber)) {
			policyNumber = String.valueOf(Utils.generatePolicyNumber());
			Policy policy = new Policy();
			policy.setPolicyNumber(policyNumber);
			policy.setPolicyDetails(policyDetails);
			policy.setPolicyName(policyName);

			policyRepository.insert(policy);
			success = true;
		} else {
			Policy policy = new Policy();
			policy.setPolicyNumber(policyNumber);
			policy.setPolicyDetails(policyDetails);
			policy.setPolicyName(policyName);

			policyRepository.save(policy);
			success = true;
		}
		return success;
	}

	/**
	 * This method retrieves all the Policies
	 * @return
	 */
	public List<Policy> getAllPolicies() {
		List<Policy> policies = policyRepository.findAll();
		return policies;
	}

	/**
	 * This method get the policy details for a given policy number
	 * @param policyNumber
	 * @return
	 */
	public Policy getPolicy(String policyNumber) {
		Policy policy = policyRepository.findOne(policyNumber);
		return policy;
	}

	/**
	 * This method deletes a given Policy
	 * @param policyNumber
	 * @return
	 */
	public boolean delete(String policyNumber) {
		boolean success = false;

		policyRepository.delete(policyNumber);
		success = true;
		return success;
	}

	/**
	 * This method deletes all the Policies
	 * @return
	 */
	public boolean deleteAll() {
		boolean success = false;

		policyRepository.deleteAll();
		success = true;
		return success;
	}
}
