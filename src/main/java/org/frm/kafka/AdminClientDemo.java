package org.frm.kafka;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.sql.Time;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AdminClientDemo {
    public static void main(String[] args) {
        String newTopicName = "test-topic";
        String groupID = "test-group";
        Properties props = new Properties();

        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-host:port");
        props.put("request.timeout.ms", 600000);

        try (AdminClient client = AdminClient.create(props)) {

            // 执行你要做的操作……
            NewTopic newTopic = new NewTopic(newTopicName, 10, (short) 3);

            CreateTopicsResult topicsResult = client.createTopics(Arrays.asList(newTopic));
            try {
                topicsResult.all().get(10, TimeUnit.SECONDS);
                ListConsumerGroupOffsetsResult result = client.listConsumerGroupOffsets(groupID);
                Map<TopicPartition, OffsetAndMetadata> offsets =
                        result.partitionsToOffsetAndMetadata().get(10, TimeUnit.SECONDS);
                System.out.println(offsets);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        }
    }
}
