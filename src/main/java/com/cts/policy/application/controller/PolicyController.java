package com.cts.policy.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.policy.application.commons.ApplicationConstants;
import com.cts.policy.application.document.Policy;
import com.cts.policy.application.service.PolicyService;

@RestController
@RequestMapping("/policies")
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	@CrossOrigin
	@PostMapping("/addOrUpdate")
	public Map<String, Object> createOrUpdatePolicy(@RequestBody Policy policy) {
		
		boolean isPolicyUpdated = policyService.addOrUpdate(policy.getPolicyNumber(),
				policy.getPolicyName(), policy.getPolicyDetails());

		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(isPolicyUpdated) {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Policy updated successfully");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.SUCCESS);
		}else {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Policy not updated");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.ERROR);
		}
		return dataMap;
	}

	@CrossOrigin
	@RequestMapping("/getAllPolicies")
	public Map<String, Object> getAllPolicies() {
		List<Policy> policies = policyService.getAllPolicies();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(policies != null) {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Policies found successfully");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.SUCCESS);
		}else {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Policy not updated");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.ERROR);
		}
		dataMap.put(ApplicationConstants.RESPONSE_OBJECT_ALLPOLICY, policies);
		return dataMap;
	}

	@CrossOrigin
	@RequestMapping("/getPolicy")
	public Map<String, Object> getPolicyById(@RequestParam String policyId) {
		Policy policy = policyService.getPolicy(policyId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(policy != null) {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Policy found successfully");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.SUCCESS);
		}else {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Policy not found");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.ERROR);
		}
		dataMap.put(ApplicationConstants.RESPONSE_OBJECT_POLICY, policy);
		return dataMap;
	}
	
	@CrossOrigin
	@RequestMapping("/deletePolicy")
	public Map<String, Object> deletetPolicyById(@RequestParam String policyId) {
		boolean success = policyService.delete(policyId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(success) {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Policy deleted successfully");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.SUCCESS);
		}else {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Policy not found/ not deleted");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.ERROR);
		}
		return dataMap;
	}
	
	@CrossOrigin
	@RequestMapping("/deleteAll")
	public Map<String, Object> deletetAll() {
		boolean success = policyService.deleteAll();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(success) {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "All Policies deleted successfully");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.SUCCESS);
		}else {
			dataMap.put(ApplicationConstants.RESPONSE_MESSAGE, "Not deleted");
			dataMap.put(ApplicationConstants.RESPONSE_STATUS, ApplicationConstants.ERROR);
		}
		return dataMap;
	}
}
