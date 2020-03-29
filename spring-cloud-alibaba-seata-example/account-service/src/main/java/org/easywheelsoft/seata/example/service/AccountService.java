package org.easywheelsoft.seata.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@Service
public class AccountService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void reduce(String userId, int money) {
		jdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?",
				money, userId);
	}
}
