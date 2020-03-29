package org.easywheelsoft.alibaba.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@EnableEurekaServer
@SpringBootApplication
public class SidecarEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SidecarEurekaApplication.class, args);
	}

}
