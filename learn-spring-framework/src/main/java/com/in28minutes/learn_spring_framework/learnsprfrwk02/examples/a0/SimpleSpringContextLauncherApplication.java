package com.in28minutes.learn_spring_framework.learnsprfrwk02.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {
    // whenever we want to launch a new Spring context, we can start with this!
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }
}
