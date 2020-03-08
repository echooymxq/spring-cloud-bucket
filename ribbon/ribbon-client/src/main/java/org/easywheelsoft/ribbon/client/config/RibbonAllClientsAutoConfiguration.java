package org.easywheelsoft.ribbon.client.config;

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@Configuration(proxyBeanMethods = false)
@RibbonClients(defaultConfiguration = RibbonAllClientsAutoConfiguration.DefaultAllClientsConfiguration.class)
public class RibbonAllClientsAutoConfiguration {

	static class DefaultAllClientsConfiguration {

		@Bean
		public IRule ribbonRule() {
			return new AvailabilityFilteringRule();
		}

	}

}
