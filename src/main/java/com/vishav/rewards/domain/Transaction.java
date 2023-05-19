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
	
	private int customerId;
	
	private double transactionAmount;
	
	private String transactionDate;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
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
