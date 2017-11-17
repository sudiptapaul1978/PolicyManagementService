package com.cts.policy.application.startup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.cts.policy.application.document.Policy;
import com.cts.policy.application.service.PolicyService;

@Component
public class PolicyApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	PolicyService policyService;

	/**
	 * This event is executed as late as conceivably possible to indicate that the
	 * application is ready to service requests.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		System.out.println("[StartUP Log]Inside onApplicationEvent() ... ");
		try{
			System.out.println("[StartUP Log]Going to create Dummy Policies ... ");
			List<Policy> dummyPolicyList = new ArrayList<Policy>();
			for (int arry = 1; arry <= 10; arry++) {
				if(policyService.getPolicy("dummyid " + arry) == null){
					policyService.addOrUpdate("dummyid " + arry, "Dummy Policy " + arry, "Dummy Details " + arry);
				}
				dummyPolicyList.add(policyService.getPolicy("dummyid " + arry));
			}
			System.out.println("\n#################################################################################################################\n");
			System.out.println("[StartUP Log]The Dummy Policy List is > " + dummyPolicyList);
			System.out.println("\n#################################################################################################################\n");
		}catch(Exception exception){
			System.out.println("Exception occured during Dummy Policy creation during Start up ... Please ignore...");
		}

		return;
	}

}
