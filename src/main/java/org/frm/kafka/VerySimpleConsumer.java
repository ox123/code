package org.frm.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class VerySimpleConsumer {
    public static void main(String[] args) {
        // Set consumer configuration properties
        final Properties consumerProps = new Properties();
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constant.KAFKA_ADDRESS);
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "very-simple-consumer");

        // Create a new consumer
        try (final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps)) {
            // Subscribe to the topic
            consumer.subscribe(Collections.singleton(Constant.SIMPLE_TOPIC));

            // Continuously read records from the topic
            while (true) {
                final ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("Received: " + record);
                }
            }
        }
    }
}

