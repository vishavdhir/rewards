/**
 * 
 */
package com.vishav.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishav.rewards.domain.Rewards;
import com.vishav.rewards.service.RewardsService;

/**
 * @author vishav.dhir
 *
 */

@RestController
@RequestMapping("/rewards")
public class RewardsController {

	@Autowired
	RewardsService rewardsService;

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Rewards> getRewardsByCustomer(@PathVariable(value = "customerId") long customerId) {

		Rewards rewards = rewardsService.getRewardsByCustomer(customerId);

		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}

}
