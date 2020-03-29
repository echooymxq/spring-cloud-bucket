package org.easywheelsoft.seata.example.controller;

import org.easywheelsoft.seata.example.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@RestController
public class StorageController {

	@Autowired
	private StorageService storageService;

	@RequestMapping(value = "/deduct", produces = "application/json")
	public Boolean deduct(String commodityCode, Integer count) {
		storageService.deduct(commodityCode, count);
		return true;
	}
}
