package org.nacos.server.one.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuyQueueCfg {
	
	{
		System.out.println("配置消息队列");
	}
	
	private static final String BUYEQUEUE_NAME = "BuyQueue";
	
	private static final String BUYEQUEUE_EXC_NAME = "BuyExc";
	
	private static final String BUYEQUEUE_EXC_ROUTTING = "BuyExcRoutting";
	
	@Bean
	public Queue instanceQueue() {
		return new Queue(BUYEQUEUE_NAME, true, false, false);
	}
	
	@Bean
	public DirectExchange instanceExc() {
		return new DirectExchange(BUYEQUEUE_EXC_NAME, true, false);
	}
	
	@Bean
	public Binding instanceBind() {
		return BindingBuilder.bind(instanceQueue()).to(instanceExc()).with(BUYEQUEUE_EXC_ROUTTING);
	}
	
}
