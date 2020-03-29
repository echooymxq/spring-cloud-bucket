package org.easywheelsoft.seata.example.service;

import org.easywheelsoft.seata.example.feign.UserFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@Service
public class OrderService {

	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(String userId, String commodityCode, Integer count) {

		int orderMoney = count * 100;
		jdbcTemplate.update(
				"insert order_tbl(user_id,commodity_code,count,money) values(?,?,?,?)",
				userId, commodityCode, count, orderMoney);

		userFeignClient.reduce(userId, orderMoney);

	}
}
