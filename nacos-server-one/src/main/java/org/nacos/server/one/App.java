package org.nacos.server.one;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;

@SpringBootApplication
@EnableDiscoveryClient
public class App 
{
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@NacosInjected
	private NamingService nsamingService;
	
    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;
    
    @PostConstruct
    public void registerInstance() throws NacosException {
    	nsamingService.registerInstance(applicationName, "127.0.0.1", serverPort);
	}
	
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
}
