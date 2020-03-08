package org.easywheelsoft.ribbon.rule.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@FeignClient(name = "service-provider")
public interface EchoService {

	@GetMapping("/echo/{str}")
	String echo(@PathVariable("str") String str);

}
