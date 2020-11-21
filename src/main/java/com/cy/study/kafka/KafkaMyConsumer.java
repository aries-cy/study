package com.cy.study.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消费者
 *
 * @author cy
 */
@Component
public class KafkaMyConsumer {

    private static Logger log = LoggerFactory.getLogger(KafkaMyProducer.class);

    /**
     * 配置topic和分区,可以配置多个
     * topic为队列名称
     * partitions表示值的的分区，这里指定了0和2分区
     * partitionOffsets表示详细的指定分区，partition表示那个分区，initialOffset表示Offset的初始位置
     */
    @KafkaListener(topicPartitions =
            { @TopicPartition(topic = "testTopic",
                    partitions = { "0" },
                    partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "0"))
            })
    public void consumer(ConsumerRecord consumerRecord){
        Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
        if(kafkaMassage.isPresent()){
            Object o = kafkaMassage.get();
            System.out.println("接收到的消息是："+o);
        }
    }

    @KafkaListener(topics = KafkaMyProducer.TOPIC_TEST, groupId = KafkaMyProducer.TOPIC_GROUP1)
    public void topic_test(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("topic_test 消费了： Topic:" + topic + ",Message:" + msg);
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = KafkaMyProducer.TOPIC_TEST, groupId = KafkaMyProducer.TOPIC_GROUP2)
    public void topic_test1(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("topic_test1 消费了： Topic:" + topic + ",Message:" + msg);
            ack.acknowledge();
        }
    }
}
