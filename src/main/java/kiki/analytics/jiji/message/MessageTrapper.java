package kiki.analytics.jiji.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import kiki.analytics.jiji.tracking.TrackingData;

@Component
public class MessageTrapper {

    @RabbitListener(queues="jiji")
    public void receiveMessage(TrackingData message) {
        System.out.println("Received <" + message.toString() + ">");
    }
}