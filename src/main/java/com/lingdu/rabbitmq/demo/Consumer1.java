package com.lingdu.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Consumer1 {

    public static void main(String[] args) throws Exception {
        // 创建 ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/lingdu");


        // 通过 ConnectionFactory 获取 Connection
        Connection connection = connectionFactory.newConnection();

        // 通过 Connection 获取 Channel
        Channel channel = connection.createChannel();

        //声明一个队列
        String queueName = "test002";
        //声明交换器，类型为direct
        channel.exchangeDeclare("direct_exchange", "direct");
        channel.queueDeclare(queueName, false, false, false, null);

        //绑定队列到交换机，指定路由key为test
        channel.queueBind(queueName, "direct_exchange", "test");

        //创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //设置 channel
        channel.basicConsume(queueName, true, queueingConsumer);

        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("获取 mq 内容：" + message + "'");
        }


    }
}
