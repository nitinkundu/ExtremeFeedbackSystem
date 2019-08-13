package com.example.demo.xfs;

import com.twilio.exception.TwilioException;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsController {
	
	private static final Logger logger = LoggerFactory.getLogger(SmsController.class);
    private final TwilioRestClient client;

    public SmsController(TwilioRestClient client) {
        this.client = client;
    }

    public void create(String to, String from, String body, String mediaUrl) {
        MessageCreator messageCreator = new MessageCreator(
                new PhoneNumber("+918260098391"),
                new PhoneNumber("+19167401802"),
                body);
        messageCreator.setMediaUrl(mediaUrl);
        try {
            messageCreator.create(this.client);
        } catch (TwilioException e) {
            logger.error(
                    "An exception occurred trying to send a message to {}, exception: {}",
                    to,
                    e.getMessage());
        }
    }
}
