package org.spring.boot.jooq.database;

import org.jooq.Batch;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baeldung.jooq.introduction.db.public_.tables.Author;

@Component
public class JooqDaoImpl {

	@Autowired
	private DSLContext dslContext;
	
	@Autowired
	private DSL dsl;
	
	public void readbook() {
		int execute = dslContext.insertInto(Author.AUTHOR).set(Author.AUTHOR.FIRST_NAME, "first")
										    .set(Author.AUTHOR.LAST_NAME, "sdfsdaf")
										    .set(Author.AUTHOR.ID,100000)
										    .execute();
		
		//dslContext.batchInsert(Author.AUTHOR.newRecord()).execute();
		System.out.println("inserted "+execute);
	}
	
	public void createBook() {
		Batch batchInsert = dslContext.batchInsert(Author.AUTHOR.newRecord());
		int[] execute = batchInsert.execute();
	}
}
