package org.easywheelsoft.seata.example.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.easywheelsoft.seata.example.feign.OrderFeignClient;
import org.easywheelsoft.seata.example.feign.StorageFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import io.seata.spring.annotation.GlobalTransactional;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@Service
public class BusinessService {

	@Autowired
	private StorageFeignClient storageFeignClient;
	@Autowired
	private OrderFeignClient orderFeignClient;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 减库存，下订单
	 *
	 * @param userId
	 * @param commodityCode
	 * @param orderCount
	 */
	@GlobalTransactional
	public void purchase(String userId, String commodityCode, int orderCount) {
		storageFeignClient.deduct(commodityCode, orderCount);

		orderFeignClient.create(userId, commodityCode, orderCount);

		if (!validData()) {
			throw new RuntimeException("账户或库存不足,执行回滚");
		}
	}

	@PostConstruct
	public void initData() {
		jdbcTemplate.update("delete from account_tbl");
		jdbcTemplate.update("delete from order_tbl");
		jdbcTemplate.update("delete from storage_tbl");
		jdbcTemplate.update(
				"insert into account_tbl(user_id,money) values('U100000','10000') ");
		jdbcTemplate.update(
				"insert into storage_tbl(commodity_code,count) values('C100000','200') ");
	}

	public boolean validData() {
		Map accountMap = jdbcTemplate
				.queryForMap("select * from account_tbl where user_id='U100000'");
		if (Integer.parseInt(accountMap.get("money").toString()) < 0) {
			return false;
		}
		Map storageMap = jdbcTemplate
				.queryForMap("select * from storage_tbl where commodity_code='C100000'");
		if (Integer.parseInt(storageMap.get("count").toString()) < 0) {
			return false;
		}
		return true;
	}
}
