package com.macys.macysordermessageconsumer;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.macys.macysordermessageconsumer.dto.json.OrderJsonMessage;
import com.macys.macysordermessageconsumer.dto.xml.FulfillmentOrder;
import com.macys.macysordermessageconsumer.service.MACYSConsumerService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class MACYSConsumerControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	MACYSConsumerService messageService;

	@Test
	void testGetJsonMessage() throws Exception {
		//OrderJsonMessage orderJsonMessage = new OrderJsonMessage();

		when(messageService.getJsonMessage()).thenReturn(new ResponseEntity<List<OrderJsonMessage>>(HttpStatus.OK));

		MvcResult getJsonMessage = mockMvc.perform(get("/macys/consumer/json").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print()).andReturn();
		
		Assertions.assertNotNull(getJsonMessage.getResponse());
	}

	@Test
	void testGetXMLMessage() throws Exception {

		when(messageService.getXmlMessage()).thenReturn(new ResponseEntity<List<FulfillmentOrder>>(HttpStatus.OK));

		MvcResult getXMLMessage = mockMvc.perform(get("/macys/consumer/xml").contentType(MediaType.APPLICATION_XML_VALUE)
				.accept(MediaType.APPLICATION_XML_VALUE)).andExpect(status().isOk()).andDo(print()).andReturn();
		
		Assertions.assertNotNull(getXMLMessage.getResponse());
	}

}
