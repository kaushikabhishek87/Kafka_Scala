import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.Properties

object ProducerExample extends App {
    
    var TOPIC ="test"

    val props:Properties = new Properties()

    props.put("bootstrap.servers","localhost:9092")
    props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")
    props.put("acks","all")

    val producer = new KafkaProducer[String, String](props)

    var message = 0

    while (message < 5){
        val record = ProducerRecord[String, String](TOPIC, message.toString())
        println( producer.send(record).get() )
        message = message+1
    }

   
}
