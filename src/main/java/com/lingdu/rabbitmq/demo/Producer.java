package com.lingdu.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建 ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/lingdu");


        // 通过 ConnectionFactory 获取 Connection
        Connection connection = connectionFactory.newConnection();

        // 通过 Connection 获取 Channel
        Channel channel = connection.createChannel();
        //声明交换器，类型为direct
        channel.exchangeDeclare("direct_exchange", "direct");

        // 通过 Channel 发送数据
        String msg = "rabbitmq test";
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("direct_exchange", "test", null, msg.getBytes());
        }

        // 关键相关连接
        channel.close();
        connection.close();
    }
}
