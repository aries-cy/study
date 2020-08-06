package com.cy.study.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;

/**
 * 消息生产者
 *
 * @author cy
 */
public class Producer {

    /**
     * Producer端发送同步消息
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("producer");
        // 设置NameServer的地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动Producer实例
        producer.start();
        try{


            for (int i = 0; i < 100; i++) {
                // 创建消息，并指定Topic，Tag和消息体
                Message msg = new Message("CY",
                        "TagCY" ,
                        /* Message body */
                        ("Hello RocketMQ cy" + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
                );
                // 发送消息到一个Broker
                SendResult sendResult = producer.send(msg);
                // 通过sendResult返回消息是否成功送达
                System.out.printf("%s%n", sendResult);
            }

        }catch (Exception e){
            e.printStackTrace();
            Thread.sleep(1000);
        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }

    @Test
    public void test2() throws Exception {
        /*
         * Instantiate with a producer group name.
         */
        DefaultMQProducer producer = new DefaultMQProducer("producer_cy");
        producer.setNamesrvAddr("localhost:9876");

        producer.start();

        for (int i = 0; i < 1000; i++) {
            try {

                /*
                 * Create a message instance, specifying topic, tag and message body.
                 */
                /*Message msg = new Message("TopicTest" *//* Topic *//*,
                        "TagA" *//* Tag *//*,
                        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) *//* Message body *//*
                );*/

                // 创建消息，并指定Topic，Tag和消息体
                Message msg = new Message("CY",
                        "TagCY" ,
                        /* Message body */
                        ("Hello RocketMQ cy" + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
                );

                /*
                 * Call send message to deliver message to one of brokers.
                 */
                SendResult sendResult = producer.send(msg);

                System.out.printf("%s%n", sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        /*
         * Shut down once the producer instance is not longer in use.
         */
        producer.shutdown();
    }
}
