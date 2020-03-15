package com.project.adneom.messages;

import com.google.gson.Gson;
import com.project.adneom.exceptions.CustomMessageException;
import com.project.adneom.services.ListService;
import com.project.adneom.wrappers.ArrayWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.JmsResponse;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class ListMessage {

    @Autowired
    private ListService listService;

    @Autowired
    private Gson gson;

    @JmsListener(destination = "partition", containerFactory = "myFactory")
    public JmsResponse getPartition(Message message) throws JMSException {
        final ArrayWrapper arrayWrapper = arrayWrapperConverter(((TextMessage) message).getText());
        try{
            validateArrayWrapper(arrayWrapper);
        }catch (CustomMessageException ex){
            ex.printStackTrace();
            return null;
        }
        return JmsResponse.forQueue(listService.partitionWrapper(arrayWrapper), "partitionQueueOut");
    }

    private ArrayWrapper arrayWrapperConverter(final String msgBody){
        return gson.fromJson(msgBody, ArrayWrapper.class);
    }

    private void validateArrayWrapper(final ArrayWrapper arrayWrapper){
        if(arrayWrapper == null){
            throw new CustomMessageException("Parameters of ArrayWrapper are not invalid");
        }
    }

}
