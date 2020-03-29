package org.easywheelsoft.seata.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@Service
public class StorageService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void deduct(String commodityCode, int count) {
		jdbcTemplate.update(
				"update storage_tbl set count = count - ? where commodity_code = ?",
				count, commodityCode);
	}
}
