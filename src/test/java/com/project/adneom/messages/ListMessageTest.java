package com.project.adneom.messages;

import com.project.adneom.wrappers.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration tests
 * Before testing launch apache-activemq server
 * with default credentials
 * login = admin & password = admin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListMessageTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void testGetPartition() {
        //given
        final ArrayWrapper arrayWrapper = new ArrayWrapper(new int[]{1, 2, 3, 4, 5}, 2);

        //when
        jmsTemplate.convertAndSend("partition", arrayWrapper);
        jmsTemplate.setReceiveTimeout(10_000);

        //then
        Assert.assertEquals("{\"itemsList\":[[1,2],[3,4],[5]]}", this.jmsTemplate.receiveAndConvert("partitionQueueOut"));
    }

    @Test
    public void testGetPartitionBis() {
        //given
        final ArrayWrapper arrayWrapper = new ArrayWrapper(new int[]{1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,9,9}, 3);

        //when
        jmsTemplate.convertAndSend("partition", arrayWrapper);
        jmsTemplate.setReceiveTimeout(10_000);

        //then
        Assert.assertEquals("{\"itemsList\":[[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[1,2,3],[9,9]]}", this.jmsTemplate.receiveAndConvert("partitionQueueOut"));
    }

    @Test
    public void testGetPartitionThrowExceptionWhenArrayWrapperSizeIsNegativeShouldReturnNull() {
        //given
        final ArrayWrapper arrayWrapper = new ArrayWrapper(new int[]{1, 2, 3, 4, 5}, -2);

        //when
        jmsTemplate.convertAndSend("partition", arrayWrapper);
        jmsTemplate.setReceiveTimeout(10_000);

        //then
        Assert.assertNull("return null", this.jmsTemplate.receiveAndConvert("partitionQueueOut"));
    }

    @Test
    public void testGetPartitionThrowExceptionWhenArrayWrapperSizeIsEqualToZeroShouldReturnNull() {
        //given
        final ArrayWrapper arrayWrapper = new ArrayWrapper(new int[]{1, 2, 3, 4, 5}, 0);

        //when
        jmsTemplate.convertAndSend("partition", arrayWrapper);
        jmsTemplate.setReceiveTimeout(10_000);

        //then
        Assert.assertNull("return null", this.jmsTemplate.receiveAndConvert("partitionQueueOut"));
    }

    @Test
    public void testGetPartitionThrowExceptionWhenArrayWrapperIntsIsNullShouldReturnNull() {
        //given
        final int[] ints = new int[0];
        final ArrayWrapper arrayWrapper = new ArrayWrapper(ints, 3);

        //when
        jmsTemplate.convertAndSend("partition", arrayWrapper);
        jmsTemplate.setReceiveTimeout(10_000);

        //then
        Assert.assertNull("return null", this.jmsTemplate.receiveAndConvert("partitionQueueOut"));
    }

}