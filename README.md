# kafka-test-client

This java client publishes and consumes message published to kafka broker's topic whith timestamp.

## QuickStart

### Consume Topic
This consumes specific topic of broker.
~~~
java -jar kafkaConsume/target/kafkaConsumer-jar-with-dependencies.jar <kafka brokers> <consumer group> <topic>
~~~

### Publish message
This publishes 100 messages (message-input-0...99) to specific topic of broker.
~~~
java -jar kafkaProducer/target/kafkaProducer-jar-with-dependencies.jar <kafka brokers> <topic>
~~~

### The consume result
The result of consume is there.
The timestamp of published and consumed are displayed.
~~~
[INFO offset = 901, key = 0, value = message-input-0, publishedTime = 1603606612721, consumedTime = 1603606613492
[INFO offset = 1706, key = 1, value = message-input-1, publishedTime = 1603606613293, consumedTime = 1603606613951
・
・
・
[INFO offset = 1750, key = 99, value = message-input-99, publishedTime = 1603606662508, consumedTime = 1603606662687
~~~