package com.vishav.rewards.domain;

public class Rewards {
	
    private long customerId;
    
	private long lastMonthRewards;
	
    private long secondLastMonthRewards;
    
    private long thirdLastMonthRewards;
    
    private long totalRewards;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getLastMonthRewards() {
		return lastMonthRewards;
	}

	public void setLastMonthRewards(long lastMonthRewards) {
		this.lastMonthRewards = lastMonthRewards;
	}

	public long getSecondLastMonthRewards() {
		return secondLastMonthRewards;
	}

	public void setSecondLastMonthRewards(long secondLastMonthRewards) {
		this.secondLastMonthRewards = secondLastMonthRewards;
	}

	public long getThirdLastMonthRewards() {
		return thirdLastMonthRewards;
	}

	public void setThirdLastMonthRewards(long thirdLastMonthRewards) {
		this.thirdLastMonthRewards = thirdLastMonthRewards;
	}

	public long getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(long totalRewards) {
		this.totalRewards = totalRewards;
	}

}
