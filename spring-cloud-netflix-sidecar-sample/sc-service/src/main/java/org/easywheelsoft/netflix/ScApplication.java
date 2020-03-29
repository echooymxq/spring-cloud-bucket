package org.easywheelsoft.netflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class ScApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Component
	class SidecarExampleRunner implements CommandLineRunner {

		@Autowired
		RestTemplate restTemplate;

		@Override
		public void run(String... args) {
			call();
		}

		@Scheduled(fixedDelay = 2 * 1000L)
		private void call() {
			String result = restTemplate
					.getForObject("http://sidecar-svc/echo?user=admin", String.class);
			System.out.println(result);
		}

	}

	@RestController
	public class TestController {

		@GetMapping("/test")
		public String test() {
			return "test";
		}

	}

}
