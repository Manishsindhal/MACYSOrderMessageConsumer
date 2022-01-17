package com.macys.macysordermessageconsumer.service;


import com.macys.macysordermessageconsumer.dto.json.OrderJsonMessage;
import com.macys.macysordermessageconsumer.dto.xml.FulfillmentOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MACYSConsumerService {
    ResponseEntity<List<FulfillmentOrder>> getXmlMessage();

    ResponseEntity<List<OrderJsonMessage>> getJsonMessage();
}
