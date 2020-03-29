package org.easywheelsoft.seata.example.controller;

import org.easywheelsoft.seata.example.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@RestController
public class BusinessController {

	private static final Logger log = LoggerFactory.getLogger(BusinessController.class);

	@Autowired
	private BusinessService businessService;

	/**
	 * 购买下单，模拟全局事务提交
	 *
	 */
	@RequestMapping(value = "/purchase/commit", produces = "application/json")
	public String purchaseCommit() {
		try {
			businessService.purchase("U100000", "C100000", 30);
		}
		catch (Exception exx) {
			return exx.getMessage();
		}
		return "全局事务提交";
	}

	/**
	 * 购买下单，模拟全局事务回滚 账户或库存不足
	 *
	 */
	@Scheduled(fixedRate = 3000L)
	@RequestMapping("/purchase/rollback")
	public String purchaseRollback() {
		try {
			businessService.purchase("U100000", "C100000", 99999);
		}
		catch (Exception exx) {
			log.warn(exx.getMessage());
			return exx.getMessage();
		}
		return "全局事务提交";
	}
}
