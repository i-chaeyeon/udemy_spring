package com.in28minutes.learn_spring_framework.learnsprfrwk02.examples.h1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

//@Configuration //indicates that we are using a Java Configuration
//@ComponentScan
public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); //name, age
            System.out.println(context.getBean("name")); //Ranga
            System.out.println(context.getBean("age")); //35
        }

    }
}
