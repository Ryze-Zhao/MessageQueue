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


1. rabbitmq-consumer        (MessageQueue:RabbitMQ)
    RabbitMQ消费者模块，用于获取队列中的数据,不同的目录对应不同模块的消费者

     
2. rabbitmq-normal          (MessageQueue:RabbitMQ)
    普通模式与工作模式共用，普通的发送与接收；
    
3. rabbitmq-fanout          (MessageQueue:RabbitMQ)
    订阅模式/发布模式/，所有绑定到对应Exchange的Queue都会收到所有消息，所有绑定这些Queue的消费者，都会收到所有信息；
    
4. rabbitmq-direct          (MessageQueue:RabbitMQ)
    直接交换模式，绑定到Exchange的Queue有对应的Key，如果消息不能完全匹配上对应的Queue和Key，Queue就不会接收该消息，订阅这个Queue的消费者就更加不可能接收到该消息，因为该消费已被废弃；
    
5. rabbitmq-dlx-ttl         (MessageQueue:RabbitMQ)
    延迟模式之死信，将消息设置生命周期（过期时间）并放入死信Queue，过期会自动转发到其他的Queue，然后就发送；
    
6. rabbitmq-delay-plugin    (MessageQueue:RabbitMQ)
    延迟模式之插件，使用插件需要RabbitMQ版本在3.5.8+，设置延期的Exchange，时间到期再推送到指定的Queue，无法匹配的Queue将被废弃；
    
7. activemq-consumer        (MessageQueue:ActiveMQ)
    ActiveMQ消费者模块，用于获取队列中的数据
    
8. activermq-normal         (MessageQueue:ActiveMQ)    
    普通模式，即点对点的进行发送，生产者发送到Queue，消费者到Queue中获取；
    
    
    
    
    
#### 参与贡献

1. RyzeZhao

#### MessageQueue消息队列博客汇总
http://heaven.hehaozhao.xin/front/articlePage/ubb40p25om