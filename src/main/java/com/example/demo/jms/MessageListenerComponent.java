package com.example.demo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerComponent implements ApplicationRunner {


	@Autowired
	private JmsTemplate jmsTemplate;


	@JmsListener(destination = "queue.sample")
	public void onReceiverQueue(String str) {
		System.out.println( str );
	}

	@JmsListener(destination = "topic.sample", containerFactory = "jmsFactoryTopic")
	public void onReceiverTopic(String str) {
		System.out.println( str );
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
//		jmsTemplate.convertAndSend("queue.sample", "{user: 'wolmir', usando: 'fila'}");
	}

}
