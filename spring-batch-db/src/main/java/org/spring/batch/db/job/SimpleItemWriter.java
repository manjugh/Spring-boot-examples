package org.spring.batch.db.job;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleItemWriter implements ItemWriter<SimpleItem>{

	@Autowired
	private DataSource dataSource;
	
	
	
	public void write(List<? extends SimpleItem> items) throws Exception {
		System.out.println("Item received "+items.get(0).getAge()+" name "+items.get(0).getName());
		
		try(Connection connection = dataSource.getConnection();) {
			for (int i = 0; i <items.size(); i++) {
				SimpleItem simpleItem = items.get(i);
				if(simpleItem.getCount()==2) {
					throw new RuntimeException();
				}
				String sql = "INSERT INTO CUSTOMER VALUES(1,'FIRST NAME')";
				Statement createStatement = connection.createStatement();
				createStatement.execute(sql);
			}
		}
	}

}
