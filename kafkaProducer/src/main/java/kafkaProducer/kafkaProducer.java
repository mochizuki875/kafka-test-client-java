package kafkaProducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class kafkaProducer {
	public static void main(String[] args) {
		 Properties props = new Properties();
		// kafka brokerを指定
		 props.put("bootstrap.servers", "kafka.cluster.local:31090");
		 props.put("acks", "all");
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		 KafkaProducer<String, String> producer = new KafkaProducer<>(props);

		 // 指定したtopicに対して100回メッセージを送信
		 for (int i = 0; i < 100; i++) {
//			 Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			 try {
	            Thread.sleep(500);
			 } catch(InterruptedException e){
				e.printStackTrace();
			 }

			 // 宛先topicと送信するメッセージを指定してpublishする（タイムスタンプ付与）
		     producer.send(new ProducerRecord<String, String>("input", Integer.toString(i), "message-input-" + Integer.toString(i) + ", publishedTime = " + System.currentTimeMillis()));
		 }
		 producer.close();
	}
}
