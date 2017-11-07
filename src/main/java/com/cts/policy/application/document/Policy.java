package com.cts.policy.application.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Policy {

	@Id
	String policyNumber;
	String policyName;
	String policyDetails;
	/**
	 * @return the policyNumber
	 */
	public String getPolicyNumber() {
		return policyNumber;
	}
	/**
	 * @param policyNumber the policyNumber to set
	 */
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	/**
	 * @return the policyName
	 */
	public String getPolicyName() {
		return policyName;
	}
	/**
	 * @param policyName the policyName to set
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	/**
	 * @return the policyDetails
	 */
	public String getPolicyDetails() {
		return policyDetails;
	}
	/**
	 * @param policyDetails the policyDetails to set
	 */
	public void setPolicyDetails(String policyDetails) {
		this.policyDetails = policyDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Policy [policyNumber=").append(policyNumber).append(", policyName=").append(policyName)
				.append(", policyDetails=").append(policyDetails).append("]");
		return builder.toString();
	}
}
