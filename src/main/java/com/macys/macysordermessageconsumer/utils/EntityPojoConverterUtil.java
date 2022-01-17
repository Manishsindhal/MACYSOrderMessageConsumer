package com.macys.macysordermessageconsumer.utils;

import com.macys.macysordermessageconsumer.dto.json.OrderJsonMessage;
import com.macys.macysordermessageconsumer.dto.xml.FulfillmentOrder;
import com.macys.macysordermessageconsumer.entity.json.OrderJsonMessageEntity;
import com.macys.macysordermessageconsumer.entity.xml.FulfillmentOrderEntity;
import com.macys.macysordermessageconsumer.entity.xml.Source;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class EntityPojoConverterUtil {

    public static OrderJsonMessage jsonEntityToPojo(ModelMapper modelMapper, OrderJsonMessageEntity orderMessageJsonEntity) {
        return modelMapper.map(orderMessageJsonEntity, OrderJsonMessage.class);
    }

    public static OrderJsonMessageEntity jsonPojoToEntity(ModelMapper modelMapper, OrderJsonMessage orderMessageJson) {
        return modelMapper.map(orderMessageJson, OrderJsonMessageEntity.class);
    }

    public static FulfillmentOrderEntity xmlPojoToEntity(ModelMapper modelMapper, FulfillmentOrder fulfillmentOrder) {
        return modelMapper.map(fulfillmentOrder, FulfillmentOrderEntity.class);
    }

    public static FulfillmentOrder xmlEntityToPojo(ModelMapper modelMapper, FulfillmentOrderEntity fulfillmentOrderEntity) {
        return modelMapper.map(fulfillmentOrderEntity, FulfillmentOrder.class);
    }
}
