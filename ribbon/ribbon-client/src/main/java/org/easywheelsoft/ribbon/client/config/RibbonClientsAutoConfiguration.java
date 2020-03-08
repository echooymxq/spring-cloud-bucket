package org.easywheelsoft.ribbon.client.config;

import org.easywheelsoft.ribbon.client.custom.CustomClientsConfiguration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@Configuration(proxyBeanMethods = false)
@RibbonClient(name = "echo-service", configuration = CustomClientsConfiguration.class)
public class RibbonClientsAutoConfiguration {

}
