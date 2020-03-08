package org.easywheelsoft.ribbon.rule;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

/**
 *
 * @author <a href="mailto:echooy.mxq@gmail.com">echooymxq</a>
 **/
public class CustomRule extends AbstractLoadBalancerRule {

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// do nothing
	}

	@Override
	public Server choose(Object key) {

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();

		HttpServletRequest request = Objects.requireNonNull(requestAttributes)
				.getRequest();

		List<Server> servers = this.getLoadBalancer().getAllServers();

		String ipAddr = request.getHeader("ip");

		return servers.stream().filter(server -> server.getHost().equals(ipAddr))
				.findFirst().orElse(null);
	}

}
