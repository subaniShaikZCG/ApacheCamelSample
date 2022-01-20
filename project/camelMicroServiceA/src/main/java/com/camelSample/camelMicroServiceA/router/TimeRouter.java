package com.camelSample.camelMicroServiceA.router;

import java.time.LocalDate;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TimeRouter extends RouteBuilder {
	
	

	@Autowired
	private getBean getBean;
	
	@Autowired
	private loggers loggers;

	@Override
	public void configure() throws Exception {
		//queue
		//transformation
		//database
		from("timer:first-timer")
		.log("${body}")
		.transform().constant("my message")
//		.transform().constant("time now is"+ LocalDateTime.now())
//		.bean("getBean")
		
		//transform
		//process
		
		.log("${body}")
		.bean(getBean,"getTime")
		.log("${body}")
		.bean(loggers)
		.log("${body}")
		.process(new simpleLoggingProcessor())
		.to("log:first-timer");
	}

}

@Component
class getBean{
	public String getTime() {
		return "time now is"+LocalDate.now();
	}
}

@Component
class loggers{
	private org.slf4j.Logger logger = LoggerFactory.getLogger(loggers.class);
	public void  process(String message) {
		logger.info("loggers {}",message);
	}
}

 class simpleLoggingProcessor implements Processor {
	 
	 private org.slf4j.Logger logger = LoggerFactory.getLogger(loggers.class);
	 
	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("simpleLoggingProcessor {}",exchange.getMessage().getBody());

	}

}
