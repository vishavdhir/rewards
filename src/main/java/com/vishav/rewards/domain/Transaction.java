/**
 * 
 */
package com.vishav.rewards.domain;

import java.util.Date;

/**
 * @author vishav.dhir
 *
 */
public class Transaction {
	
	private long customerId;
	
	private double transactionAmount;
	
	private String transactionDate;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

}
