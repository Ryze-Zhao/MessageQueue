# 各类消息队列结合SpringBoot学习
1.  RabbitMQ



#### 项目介绍
主要是学习 消息队列
以下是学习汇总文章

#### 软件架构
软件架构说明


#### 安装教程

1. 根据git-url进行Clone
2. 导入对应模块

#### 使用说明
MessageQueue父模块
暂无专门测试模块


1. rabbitmq-consumer
    消费者模块，用于获取队列中的数据，
    NormalConsumer用于rabbitmq-normal模块，普通模式
     NormalConsumer、WorkConsumer用于rabbitmq-normal模块，工作模式
2. rabbitmq-normal
    普通模式与工作模式共用，普通的发送与接收
3. rabbitmq-fanout
    订阅模式/发布模式/，所有绑定到对应Exchange的Queue都会收到所有消息，所有绑定这些Queue的消费者，都会收到所有信息
4. rabbitmq-direct
    直接交换模式，绑定到Exchange的Queue有对应的Key，如果消息不能完全匹配上对应的Queue和Key，Queue就不会接收该消息，订阅这个Queue的消费者就更加不可能接收到该消息，因为该消费已被废弃。
               

#### 参与贡献

1. RyzeZhao

#### MessageQueue消息队列博客汇总
http://heaven.hehaozhao.xin/front/articlePage/ubb40p25om