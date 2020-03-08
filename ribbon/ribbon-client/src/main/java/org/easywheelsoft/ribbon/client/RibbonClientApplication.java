package org.easywheelsoft.ribbon.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@EnableFeignClients
@ComponentScan(basePackages = "org.easywheelsoft.ribbon.client.config")
@SpringBootApplication
public class RibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}

	@Autowired
	private EchoService echoService;

	@Autowired
	private MessageService messageService;

	@Bean
	CommandLineRunner echoRunner() {
		return args -> echoService.echo("hello");
	}

	@Bean
	CommandLineRunner messageRunner() {
		return args -> messageService.send("msg");
	}

	@FeignClient(name = "echo-service")
	public interface EchoService {

		@GetMapping("/echo/{str}")
		String echo(String str);

	}

	@FeignClient(name = "message-service")
	public interface MessageService {

		@GetMapping("/msg/")
		String send(@RequestAttribute("param") String str);
	}

}
