package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public Address address(){
        return new Address("Baker Street", "London");
    }
    @Bean (name = "address3")
    public Address address3(){
        return new Address("Montinagar", "Hyderabad");
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
}
