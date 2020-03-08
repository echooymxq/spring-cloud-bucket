# 通过属性设置自定义Ribbon Client

支持以下属性：

* `<clientName>.ribbon.NFLoadBalancerClassName`: 实现 `ILoadBalancer`的类
* `<clientName>.ribbon.NFLoadBalancerRuleClassName`: 实现`IRule`的类
* `<clientName>.ribbon.NFLoadBalancerPingClassName`：实现 `IPing`的类
* `<clientName>.ribbon.NIWSServerListClassName`: 实现 `ServerList`的类
* `<clientName>.ribbon.NIWSServerListClassName`:实现 `ServerListFilter`的类

**注意:** 通过此配置的优先级高于`@RibbonClients`和默认配置。

在示例中，我们指定name为`service-provider`的属性配置为

```yaml
service-provider:
  ribbon:
    # retry 1 default when error. DefaultClientConfigImpl#DEFAULT_MAX_AUTO_RETRIES_NEXT_SERVER
    MaxAutoRetriesNextServer: 0
    NFLoadBalancerRuleClassName: org.easywheelsoft.ribbon.rule.CustomRule
```

在使用`EchoService`调用外部服务时会使用我们指定的自定义Rule进行服务的选择。自定义Rule的使用场景通常用于具体业务场景需要指定服务方，或者灰度发布等场景（在我们的示例代码中，就根据请求头传入的实际IP选择具体的服务）。