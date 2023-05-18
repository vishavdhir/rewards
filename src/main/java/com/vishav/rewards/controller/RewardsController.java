/**
 * 
 */
package com.vishav.rewards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vishav.dhir
 *
 */

@RestController
@RequestMapping("/Rewards")
public class RewardsController {

	
	@GetMapping("/customer")
	public String getRewards() {
		return "Hello World";
	}

	
}
