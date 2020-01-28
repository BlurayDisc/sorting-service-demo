package com.demo.sort.service;

import static java.util.stream.Collectors.summingLong;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.sort.controller.v1.dto.IntegerListDto;
import com.demo.sort.controller.v1.dto.SortedIntegerListResultDto;
import com.demo.sort.util.QuickSort;

import lombok.extern.slf4j.Slf4j;

/**
 * A service providing functionalities for sorting numbers.
 * 
 * @author RuN
 *
 */
@Slf4j
@Service
public class SortingService {

    /**
     * Sorts the numbers in the incoming {@link IntegerListDto} request then calculate its' sum.
     * 
     * @param request a {@link IntegerListDto} request.
     * @return a {@link SortedIntegerListResultDto} containing information of the sorted list and the sum of the result.
     */
    public SortedIntegerListResultDto sortAndSum(IntegerListDto request) {

        List<Integer> unsorted = request.getValues();
        List<Integer> sorted = QuickSort.sort(unsorted);

        log.info("Finished performing quick sort on list {}", sorted);

        long sum = sorted.stream()
                .collect(summingLong(Integer::longValue));

        log.info("Finished calculating sum for the list, result is {}", sum);

        return SortedIntegerListResultDto.builder()
                .results(sorted)
                .sum(sum)
                .build();
    }
}
