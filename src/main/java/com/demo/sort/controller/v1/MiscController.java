package com.demo.sort.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sort.controller.v1.dto.IntegerListDto;
import com.demo.sort.controller.v1.dto.SortedIntegerListResultDto;
import com.demo.sort.service.SortingService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Controller for miscellaneous resources and actions.
 * 
 * @author RuN
 *
 */
@Slf4j
@RestController
@RequestMapping(ApiConstants.API_V1 + "/misc")
public class MiscController {

    @Autowired
    private SortingService numberSortingService;

    @PostMapping("/sort-and-sum-numbers")
    public Mono<SortedIntegerListResultDto> sortAndSumNumbers(
            @Valid @RequestBody IntegerListDto request) throws InterruptedException {

        log.info("Received request to sort and sum numbers - {}", request);

        return Mono.just(numberSortingService.sortAndSum(request));
    }
}