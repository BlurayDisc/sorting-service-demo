package com.demo.sort.controller.v1.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

/**
 * A result dto containing information of a sorted list of integers.
 * <p>
 * In addition the sum of all the numbers in the list is also included.
 * 
 * @author RuN
 *
 */
@Getter
@Builder
public class SortedIntegerListResultDto {

    @JsonProperty("results")
    private final List<Integer> results;

    @JsonProperty("sum")
    private final long sum;
}
