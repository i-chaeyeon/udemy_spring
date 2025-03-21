package com.in28minutes.learn_spring_framework.learnsprfrwk01.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Ranga";
    }

    @Bean
    public int age(){
        return 15;
    }

    // can bean manage a custom class?
    @Bean
    public Person person(){
        return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
    }

    @Bean (name = "address2") // can set custom name for beans (Default is the name of bean)
    @Primary
    public Address address(){
        return new Address("Baker Street", "London");
    }

    @Bean (name = "address3")
    @Qualifier("address3qualifier")
    public Address address3(){
        return new Address("Montinagar", "Hyderabad");
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address){
        return new Person(name, age, address);
    }

    // What if there are relations between these objects?
    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address()); // existing name, age -> create new bean
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3){ // address2 -- custom name
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address){ // there is no bean with name 'address'
        return new Person(name, age, address);
    }
}
