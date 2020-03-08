package org.easywheelsoft.ribbon.client.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@Configuration(proxyBeanMethods = false)
public class CustomClientsConfiguration {

	@Bean
	public IRule ribbonRule() {
		return new BestAvailableRule();
	}

}
