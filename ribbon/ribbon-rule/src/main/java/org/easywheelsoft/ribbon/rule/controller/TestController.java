package org.easywheelsoft.ribbon.rule.controller;

import org.easywheelsoft.ribbon.rule.service.EchoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@RestController
public class TestController {

	@Autowired
	private EchoService echoService;

	@GetMapping("/echo/{str}")
	public void echo(@PathVariable String str) {
		System.out.println(echoService.echo(str));
	}

}
