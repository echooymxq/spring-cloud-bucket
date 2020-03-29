package org.easywheelsoft.seata.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
@FeignClient(name = "account-service", url = "127.0.0.1:8083")
public interface UserFeignClient {

	@GetMapping("/reduce")
	Boolean reduce(@RequestParam("userId") String userId,
			@RequestParam("money") int money);
}
