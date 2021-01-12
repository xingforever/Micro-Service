package cn.hlx_dm.kafkaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;

    @RequestMapping(value = "/sendMsgToKafka")
    public String sendMsgToKafka() {
        for (int i = 10; i < 20; i++) {
            KafkaTemplate.send("user_consumer", "hlx_dm", "hello,Kafka!--->" + i);
        }
        return "发送消息到Kafka完毕";
    }
}
