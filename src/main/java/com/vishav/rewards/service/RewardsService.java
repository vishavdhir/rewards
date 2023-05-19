/**
 * 
 */
package com.vishav.rewards.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishav.rewards.datasetup.DataMockUp;
import com.vishav.rewards.domain.Rewards;
import com.vishav.rewards.domain.Transaction;

/**
 * @author vishav.dhir
 *
 */
@Service
public class RewardsService {

	@Autowired
	DataMockUp mockedData;

	public Rewards getRewardsByCustomer(long customerId) {

		Rewards customerRewards = new Rewards();

		List<Transaction> allTransactionList = new ArrayList<>(); // Arrays.asList(mockedData.getTxnArray());
		Collections.addAll(allTransactionList, mockedData.getTxnArray());

		List<Transaction> customerTransactions = allTransactionList.stream()
				.filter(transaction -> transaction.getCustomerId() == customerId).collect(Collectors.toList());

		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -30);
		Date last30thDay = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -30);
		Date last60thDay = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -30);
		Date last90thDay = cal.getTime();

		customerRewards.setCustomerId(customerId);
		customerRewards.setLastMonthRewards(getLastMonthRewards(customerTransactions, last30thDay));
		customerRewards
				.setSecondLastMonthRewards(getSecondLastMonthRewards(customerTransactions, last30thDay, last60thDay));
		customerRewards
				.setThirdLastMonthRewards(getThirdLastMonthRewards(customerTransactions, last60thDay, last90thDay));
		customerRewards.setTotalRewards(customerRewards.getLastMonthRewards()
				+ customerRewards.getSecondLastMonthRewards() + customerRewards.getThirdLastMonthRewards());

		return customerRewards;

	}

	public long getLastMonthRewards(List<Transaction> customerTransactions, Date last30thDay) {

		List<Transaction> last30DayTransactions = new ArrayList<>();

		for (Transaction transaction : customerTransactions) {

			try {
				Date transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(transaction.getTransactionDate());

				if (transactionDate.compareTo(last30thDay) > 0 || transactionDate.compareTo(last30thDay) == 0) {

					last30DayTransactions.add(transaction);

				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return getRewardsOfTheMonth(last30DayTransactions);

	}

	public long getSecondLastMonthRewards(List<Transaction> customerTransactions, Date last30thDay, Date last60thDay) {

		List<Transaction> secondLastMonthTransactions = new ArrayList<>();

		for (Transaction transaction : customerTransactions) {

			try {
				Date transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(transaction.getTransactionDate());

				if ((transactionDate.compareTo(last60thDay) > 0 || transactionDate.compareTo(last60thDay) == 0)
						&& transactionDate.compareTo(last30thDay) < 0) {

					secondLastMonthTransactions.add(transaction);

				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return getRewardsOfTheMonth(secondLastMonthTransactions);

	}

	public long getThirdLastMonthRewards(List<Transaction> customerTransactions, Date last60thDay, Date last90thDay) {

		List<Transaction> thirdLastMonthTransactions = new ArrayList<>();

		for (Transaction transaction : customerTransactions) {

			try {
				Date transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(transaction.getTransactionDate());

				if ((transactionDate.compareTo(last90thDay) > 0 || transactionDate.compareTo(last90thDay) == 0)
						&& transactionDate.compareTo(last60thDay) < 0) {

					thirdLastMonthTransactions.add(transaction);

				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return getRewardsOfTheMonth(thirdLastMonthTransactions);

	}

	private Long getRewardsOfTheMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewards(transaction))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculateRewards(Transaction t) {
		if (t.getTransactionAmount() > 50 && t.getTransactionAmount() <= 100) {
			return Math.round(t.getTransactionAmount() - 50);
		} else if (t.getTransactionAmount() > 100) {
			return Math.round(t.getTransactionAmount() - 100) * 2 + 50;
		} else
			return 0l;
	}

}
