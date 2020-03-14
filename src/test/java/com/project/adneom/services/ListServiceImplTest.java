package com.project.adneom.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ListServiceImplTest {

    @InjectMocks
    private ListServiceImpl listService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    //partition([1,2,3,4,5], 2) retourne: [ [1,2], [3,4], [5] ]
    @Test
    public void partitionShouldReturnExample1() {
        //given
        final List<Integer> integers = Arrays.asList(1,2,3,4,5);

        //when
        final List<List<Integer>> results = listService.partition(integers, 2);

        //then
        final List<Integer> l1 = Arrays.asList(1, 2);
        final List<Integer> l2 = Arrays.asList(3, 4);
        final List<Integer> l3 = Collections.singletonList(5);
        Assert.assertEquals(Arrays.asList(l1, l2, l3), results);
    }

    @Test
    public void partitionShouldReturnExample1Bis() {
        //given
        final List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        //when
        final List<List<Integer>> results = listService.partition(integers, 2);

        //then
        final List<Integer> l1 = Arrays.asList(1, 2);
        final List<Integer> l2 = Arrays.asList(3, 4);
        final List<Integer> l3 = Arrays.asList(5, 6);
        final List<Integer> l4 = Arrays.asList(7, 8);
        final List<Integer> l5 = Collections.singletonList(9);
        Assert.assertEquals(Arrays.asList(l1, l2, l3, l4, l5), results);
    }

    //partition([1,2,3,4,5], 3) retourne: [ [1,2,3], [4,5] ]
    @Test
    public void partitionShouldReturnExample2() {
        //given
        final List<Integer> integers = Arrays.asList(1,2,3,4,5);

        //when
        final List<List<Integer>> results = listService.partition(integers, 3);

        //then
        final List<Integer> l1 = Arrays.asList(1, 2, 3);
        final List<Integer> l2 = Arrays.asList(4, 5);
        Assert.assertEquals(Arrays.asList(l1, l2), results);
    }

    //partition([1,2,3,4,5], 1) retourne: [ [1], [2], [3], [4], [5] ]
    @Test
    public void partitionShouldReturnExample3() {
        //given
        final List<Integer> integers = Arrays.asList(1,2,3,4,5);

        //when
        final List<List<Integer>> results = listService.partition(integers, 1);

        //then
        final List<Integer> l1 = Collections.singletonList(1);
        final List<Integer> l2 = Collections.singletonList(2);
        final List<Integer> l3 = Collections.singletonList(3);
        final List<Integer> l4 = Collections.singletonList(4);
        final List<Integer> l5 = Collections.singletonList(5);
        Assert.assertEquals(Arrays.asList(l1, l2, l3, l4, l5), results);
    }

    //([1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3], 3)
    //retourne [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3]
    @Test
    public void partitionShouldReturnTest4() {
        //given
        final List<Integer> integers = Arrays.asList(1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3);

        //when
        final List<List<Integer>> results = listService.partition(integers, 3);

        //then
        final List<Integer> l1 = Arrays.asList(1, 2, 3);
        final List<Integer> l2 = Arrays.asList(1, 2, 3);
        final List<Integer> l3 = Arrays.asList(1, 2, 3);
        final List<Integer> l4 = Arrays.asList(1, 2, 3);
        final List<Integer> l5 = Arrays.asList(1, 2, 3);
        final List<Integer> l6 = Arrays.asList(1, 2, 3);
        final List<Integer> l7 = Arrays.asList(1, 2, 3);
        final List<Integer> l8 = Arrays.asList(1, 2, 3);
        final List<Integer> l9 = Arrays.asList(1, 2, 3);
        final List<Integer> l10 = Arrays.asList(1, 2, 3);
        Assert.assertEquals(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10), results);
    }

    //([1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,9,9], 3)
    //retourne [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [9,9]
    @Test
    public void partitionShouldReturnTest5() {
        //given
        final List<Integer> integers = Arrays.asList(1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,9,9);

        //when
        final List<List<Integer>> results = listService.partition(integers, 3);

        //then
        final List<Integer> l1 = Arrays.asList(1, 2, 3);
        final List<Integer> l2 = Arrays.asList(1, 2, 3);
        final List<Integer> l3 = Arrays.asList(1, 2, 3);
        final List<Integer> l4 = Arrays.asList(1, 2, 3);
        final List<Integer> l5 = Arrays.asList(1, 2, 3);
        final List<Integer> l6 = Arrays.asList(1, 2, 3);
        final List<Integer> l7 = Arrays.asList(1, 2, 3);
        final List<Integer> l8 = Arrays.asList(1, 2, 3);
        final List<Integer> l9 = Arrays.asList(1, 2, 3);
        final List<Integer> l10 = Arrays.asList(1, 2, 3);
        final List<Integer> l11 = Arrays.asList(9, 9);
        Assert.assertEquals(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11), results);
    }

    //([1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,9,9], 3)
    //retourne [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [1,2,3], [9,9]
    @Test
    public void partitionShouldReturnTest6() {
        //given
        final List<Integer> integers = Arrays.asList(1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,9);

        //when
        final List<List<Integer>> results = listService.partition(integers, 3);

        //then
        final List<Integer> l1 = Arrays.asList(1, 2, 3);
        final List<Integer> l2 = Arrays.asList(1, 2, 3);
        final List<Integer> l3 = Arrays.asList(1, 2, 3);
        final List<Integer> l4 = Arrays.asList(1, 2, 3);
        final List<Integer> l5 = Arrays.asList(1, 2, 3);
        final List<Integer> l6 = Arrays.asList(1, 2, 3);
        final List<Integer> l7 = Arrays.asList(1, 2, 3);
        final List<Integer> l8 = Arrays.asList(1, 2, 3);
        final List<Integer> l9 = Arrays.asList(1, 2, 3);
        final List<Integer> l10 = Arrays.asList(1, 2, 3);
        final List<Integer> l11 = Arrays.asList(9);
        Assert.assertEquals(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11), results);
    }
}