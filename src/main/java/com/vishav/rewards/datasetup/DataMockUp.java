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

	@Value("classpath:static/transactions.json")
	Resource resourceFile;

	private Transaction[] txnArray;

	@EventListener(ApplicationReadyEvent.class)
	public void setTxnArray() {

		ObjectMapper mapper = new ObjectMapper();

		try {
			File file = resourceFile.getFile();

			txnArray = mapper.readValue(file, Transaction[].class);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Transaction[] getTxnArray() {
		return txnArray;
	}

}
