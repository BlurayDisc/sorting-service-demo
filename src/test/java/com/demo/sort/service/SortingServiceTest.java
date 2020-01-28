package com.demo.sort.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.demo.sort.controller.v1.dto.IntegerListDto;
import com.demo.sort.controller.v1.dto.SortedIntegerListResultDto;
import com.google.common.collect.ImmutableList;

public class SortingServiceTest {

    private SortingService sut = new SortingService(); // service under test

    @Test
    public void testSortAndSumWithEmptyList() {

        IntegerListDto request = new IntegerListDto();
        request.setValues(Collections.emptyList());

        SortedIntegerListResultDto result = sut.sortAndSum(request);

        assertEquals(Collections.emptyList(), result.getResults());
        assertEquals(0, result.getSum());
    }

    @Test
    public void testSortAndSumWithUnsortedList() {

        IntegerListDto request = new IntegerListDto();
        request.setValues(ImmutableList.of(6, 0, 4, 1, 3));

        SortedIntegerListResultDto result = sut.sortAndSum(request);

        assertEquals(ImmutableList.of(0, 1, 3, 4, 6), result.getResults());
        assertEquals(14, result.getSum());
    }

    @Test
    public void testSortAndSumWithUnsortedListContainingNegative() {

        IntegerListDto request = new IntegerListDto();
        request.setValues(ImmutableList.of(-5, 0, -4, 1, 3));

        SortedIntegerListResultDto result = sut.sortAndSum(request);

        assertEquals(ImmutableList.of(-5, -4, 0, 1, 3), result.getResults());
        assertEquals(-5, result.getSum());
    }
}
