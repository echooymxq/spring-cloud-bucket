package org.easywheelsoft.ribbon.rule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class RibbonRuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonRuleApplication.class, args);
	}

}
