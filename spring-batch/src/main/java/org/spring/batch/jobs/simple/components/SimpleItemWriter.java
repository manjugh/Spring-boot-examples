package org.spring.batch.jobs.simple.components;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class SimpleItemWriter implements ItemWriter<SimpleItem>{

	public void write(List<? extends SimpleItem> items) throws Exception {
		System.out.println("Item received "+items.get(0).getAge()+" name "+items.get(0).getName());
	}

}
