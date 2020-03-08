# 使用编程方式自定义Ribbon Client

* 为某个服务Client特定配置

在代码示例中，我们定义了一个服务接口:

```java
@FeignClient(name = "echo-service")
public interface EchoService {
  @GetMapping("/echo/{str}")
  String echo(String str);
}
```

我们单独为这个client定义配置，如下所示：

```java
@Configuration(proxyBeanMethods = false)
@RibbonClient(name = "echo-service", configuration = CustomClientsConfiguration.class)
public class RibbonClientsAutoConfiguration {
}

@Configuration(proxyBeanMethods = false)
public class CustomClientsConfiguration {

  // 指定路由规则
	@Bean
	public IRule ribbonRule() {
		return new BestAvailableRule();
	}
}
```

此`Client`会使用我们指定的配置，并和`RibbonClientConfiguration`中定义的配置结合使用。

> The `CustomClientsConfiguration` class must be a `@Configuration` class, but take care that it is not in a `@ComponentScan` for the main application context. Otherwise, it is shared by all the `@RibbonClients`. If you use `@ComponentScan` (or `@SpringBootApplication`), you need to take steps to avoid it being included (for instance, you can put it in a separate, non-overlapping package or specify the packages to scan explicitly in the `@ComponentScan`).

**注意：** `CustomClientsConfiguration`不应该在主应用上下文的包扫描范围内，什么意思呢？就是该配置类是`echo-service`的特定配置，如果被主应用上下文包扫描到，那么所有的Ribbon Client都会应用该配置。所以像我们示例代码中的一样，应该在应用上下文中排出它，如下所示：

```java
@ComponentScan(basePackages = "org.easywheelsoft.ribbon.client.config")
@SpringBootApplication
public class RibbonClientApplication {
...
}
```

* 为所有服务Client定义配置

和指定Client配置的区别就在于`@RibbonClient` 和`@RibbonClients`，一个用于局部，一个用于全局。我们定义全局Client如示例所示：

```java
@Configuration(proxyBeanMethods = false)
@RibbonClients(defaultConfiguration = RibbonAllClientsAutoConfiguration.DefaultAllClientsConfiguration.class)
public class RibbonAllClientsAutoConfiguration {

	static class DefaultAllClientsConfiguration {
		// 全局指定路由规则
    @Bean
		public IRule ribbonRule() {
			return new AvailabilityFilteringRule();
		}
	}
}
```

