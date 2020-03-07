# spring cloud bucket examples and events

> ## [Spring Cloud Roadmap and Hoxton and Greenwich Maintenance and EOL Announcements](https://spring.io/blog/2019/12/23/spring-cloud-roadmap-and-hoxton-and-greenwich-maintenance-and-eol-announcements)

[Spring Cloud Roadmap]: https://spring.io/blog/2019/12/23/spring-cloud-roadmap-and-hoxton-and-greenwich-maintenance-and-eol-announcements

19年底`Spring`官方发布了`Spring Cloud`接下来的发展蓝图，得到如下信息：

* `Spring Cloud Greenwich`版在2020年1月将进入维护模式。

* `Hoxton`版会支持到2021年6月，之后会进入维护期，只解决BUG和安全修复直到2021年12月，并计划在2020年的第2季度期间发布基于`Spring Boot 2.3.x`的`Hoxton`版本。
* 继`Finchley`版之后的第一个重大版本`Ilford`版将于2020年的第4季度的某个时候发布，`Ilford`基于`Spring Framework 5.3`和`Spring Boot 2.4`。此版本会移除一些进入维护模式的模块（包括hystrix，ribbon和zuul等），并对此进行重构，新的`LoadBalancer`和`CircuitBreaker`API抽象。

------

就我了解到的情况而言，国内大多数使用SpringCloud停留在G版，而使用H版的一般多为Sample项目或试点项目。此Project会基于H版上传一些使用SpringCloud全家桶组件的样例代码，并更新一些SpringCloud的事件。