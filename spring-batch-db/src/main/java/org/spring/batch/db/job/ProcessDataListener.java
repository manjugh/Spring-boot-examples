package org.spring.batch.db.job;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.batch.core.annotation.OnSkipInWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ProcessDataListener {

	@Autowired
	private JmsTemplate jmsTemplate;

	@OnSkipInWrite
	public void onWriteError(SimpleItem item, Throwable t) {
		System.out.println("Inside onWriteError Listner");
		jmsTemplate.send("TESTQUEUE11", new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("hello world test by11 client");
			}
		});
	}
}
