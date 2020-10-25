package kafkaConsume;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class kafkaConsume {
	// メソッド実行の引数としてkafka brokerとconsume先のtopicおよびグループIDを指定
	public static void main(String[] args) {

	     Properties props = new Properties();
	     // kafka brokerを指定
	     props.setProperty("bootstrap.servers", args[0]);
//	     props.setProperty("bootstrap.servers", "kafka.cluster.local:31090");
	     // consumeグループを指定
//	     props.setProperty("group.id", groupId);
	     props.setProperty("group.id", args[1]);

	     props.setProperty("enable.auto.commit", "true");
	     props.setProperty("auto.commit.interval.ms", "1000");
	     props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

	     KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

	     // consumeするtopicを指定
//	     consumer.subscribe(Arrays.asList(topicName));
	     consumer.subscribe(Arrays.asList(args[2]));


	     System.out.println("★★Consume開始★★");
	     while (true) {
	    	 // ポーリングを開始
	    	 // トピックからメッセージを取得する際のタイムアウト値を指定（ms）
	    	 ConsumerRecords<String, String> records = consumer.poll(500);

//	    	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	         for (ConsumerRecord<String, String> record : records)
	        	 // topicに存在した値を表示（タイムスタンプ付与）
	        	 System.out.printf("[INFO offset = %d, key = %s, value = %s, consumedTime = %s%n", record.offset(), record.key(), record.value(), System.currentTimeMillis());
	     }

	  }
}
