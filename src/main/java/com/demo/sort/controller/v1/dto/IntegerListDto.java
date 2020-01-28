package com.demo.sort.controller.v1.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A Dto defining a list of integers.
 * 
 * @author RuN
 *
 */
@Getter
@Setter
@ToString
public class IntegerListDto {

    @NotNull
    @Size(min = 1, max = 1000)
    @JsonProperty("values")
    private List<Integer> values;
}
