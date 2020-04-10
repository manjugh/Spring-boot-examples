package org.spring.batch.db.job;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class SimpleItemReader implements ItemReader<SimpleItem> {

	private static int count = 1;
	public SimpleItem read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		
		if (count==2) {
			return null;
		}
		count++;
		SimpleItem simpleItem = new SimpleItem();
		simpleItem.setName("Norway");
		simpleItem.setAge("30000");
		simpleItem.setCount(count);
		return simpleItem;
	}

}
