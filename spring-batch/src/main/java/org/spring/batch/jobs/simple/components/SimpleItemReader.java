package org.spring.batch.jobs.simple.components;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class SimpleItemReader implements ItemReader<SimpleItem> {

	public SimpleItem read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		SimpleItem simpleItem = new SimpleItem();
		simpleItem.setName("Norway");
		simpleItem.setAge("30000");
		return simpleItem;
	}

}
