package com.in28minutes.learn_spring_framework.learnsprfrwk02.examples.c1;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinuessCalculationService {
    private DataService dataService;

    public BusinuessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
