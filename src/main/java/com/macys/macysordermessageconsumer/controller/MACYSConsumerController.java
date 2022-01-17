package com.macys.macysordermessageconsumer.controller;

import com.macys.macysordermessageconsumer.dto.json.OrderJsonMessage;
import com.macys.macysordermessageconsumer.dto.xml.FulfillmentOrder;
import com.macys.macysordermessageconsumer.service.MACYSConsumerService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/macys/consumer")
public class MACYSConsumerController {

    @Autowired
    MACYSConsumerService messageService;
    
    @GetMapping(value = "/json",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Consume message is JSON fromate")
    ResponseEntity<List<OrderJsonMessage>> getJsonMessage() {
        return messageService.getJsonMessage();
    }

    @GetMapping(value = "/xml",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Consume message is XML fromate")
    ResponseEntity<List<FulfillmentOrder>> getXmlMessage() {
        return messageService.getXmlMessage();
    }
    
}
