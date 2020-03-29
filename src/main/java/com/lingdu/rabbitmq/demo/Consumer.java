package com.lingdu.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

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
        String queueName = "test001";
        channel.queueDeclare(queueName, false, false, false, null);

        //创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //设置 channel
        channel.basicConsume(queueName, true, queueingConsumer);

        //获取消息
        QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();


        String msg = new String(delivery.getBody());
        System.out.println("获取 mq 内容：" + msg);


    }
}
