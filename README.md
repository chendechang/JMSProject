## JMS项目
### 1 让你了解JMS的概念，实现；
### 2 实验的结果让你更直观的感受概念，深入的了解原理

总结如下：JMS “ 一个中心，两种模式，三步实现”

1 以 消息服务器为中心
消息生产者 通过客户端发消息给消息服务器； 消息消费者通过消息服务器接收消息；
2 两种消息发送模型
两种消息发送模型规范：点对点、发布订阅 ；
3 实现方法分为三步
3.1、 统一消息服务器，建立连接Connections ；
3.2 、通过连接建立队列会话session；
3.3 、准备就绪后，执行 生产者 发消息和消费者 接消息（异步）。

### ps：运行环境
1 eclipse；
2 jdk 1.8.0；
3 apache-tomcat-7.0.77；
4 apache-activemq-5.15.6
