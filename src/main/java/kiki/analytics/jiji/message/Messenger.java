package kiki.analytics.jiji.message;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import kiki.analytics.jiji.tracking.TrackingData;

@Component
public class Messenger {
    @Value("${jiji.tracking.channel}")
    private String channel;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public boolean validate(String apiKey) {
        return apiKey.length() > 0;
    }

    public boolean publishTracking(TrackingData trackingData) {
        if (this.validate(trackingData.getApiKey())) {
            try {
                amqpTemplate.convertAndSend(channel, trackingData);
                return true;
            } catch (AmqpException e) {
                return false;
            }
        } else {
            return false;
        }
    }
}