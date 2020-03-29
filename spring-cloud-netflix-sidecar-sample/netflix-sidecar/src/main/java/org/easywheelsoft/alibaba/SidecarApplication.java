package org.easywheelsoft.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@EnableSidecar
@SpringBootApplication
public class SidecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SidecarApplication.class, args);
	}

}
