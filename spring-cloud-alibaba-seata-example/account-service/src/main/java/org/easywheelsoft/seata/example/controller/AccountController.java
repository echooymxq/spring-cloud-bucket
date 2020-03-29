package org.easywheelsoft.seata.example.controller;

import org.easywheelsoft.seata.example.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/reduce", produces = "application/json")
	public Boolean debit(String userId, int money) {
		accountService.reduce(userId, money);
		return true;
	}
}
