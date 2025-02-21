package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        // 1: Launch a Spring context -
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2: Configure the thing that we want Spring to manage - @Configuration

        // HelloWorldConfiguration - @Configuration
        // name - @Bean

        // 3: Retrieving Beans managed by Spring
        // can use name of the bean or type of the bean to retrieve back!
        System.out.println(context.getBean("name")); // >> Ranga
        System.out.println(context.getBean("age")); // >> 15
        System.out.println(context.getBean("person")); // >> Person[name=Ravi, age=20, address=Address[firstLine=Main Street, city=Utrecht]]
        System.out.println(context.getBean("person2MethodCall")); // >> Person[name=Ranga, age=15, address=Address[firstLine=Baker Street, city=London]]
        System.out.println(context.getBean("person3Parameters")); // >> Person[name=Ranga, age=15, address=Address[firstLine=Montinagar, city=Hyderabad]]
        System.out.println(context.getBean("address2")); // >> Address[firstLine=Baker Street, city=London]
        //System.out.println(context.getBean(Address.class)); // >> Address[firstLine=Baker Street, city=London]
    }
}
