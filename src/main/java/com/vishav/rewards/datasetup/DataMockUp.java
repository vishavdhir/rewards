package com.vishav.rewards.datasetup;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishav.rewards.domain.Transaction;

@Component
public class DataMockUp {

	// @Autowired
	// private ResourceLoader resourceLoader;

	@Value("classpath:static/transactions.json")
	Resource resourceFile;

	Transaction[] txnArray;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		System.out.println("Vishav, I am running........");

		// Transaction txn = new Transaction();
		//
		// txn.setCustomerId(1001);
		// txn.setTransactionAmount(234.34);
		// txn.setTransactionDate("10/14/2022");
		//
		// Transaction txn1 = new Transaction();
		//
		// txn1.setCustomerId(1002);
		// txn1.setTransactionAmount(23.34);
		// txn1.setTransactionDate("11/14/2022");
		//
		// List<Transaction> txnList = new ArrayList<>();
		// txnList.add(txn1);
		// txnList.add(txn);
		//
		//
		//
		// ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		//
		// try {
		// String json = ow.writeValueAsString(txnList);
		//
		// System.out.println("json is: "+json);
		// } catch (JsonProcessingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		ObjectMapper mapper = new ObjectMapper();

		try {
			File file = resourceFile.getFile();

			txnArray = mapper.readValue(file, Transaction[].class);
			System.out.println(txnArray);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
