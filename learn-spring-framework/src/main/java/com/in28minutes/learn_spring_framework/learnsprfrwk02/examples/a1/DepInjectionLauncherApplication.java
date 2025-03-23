package com.in28minutes.learn_spring_framework.learnsprfrwk02.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass{

    // 1. Field Injection
    // 1. @Autowired
    Dependency1 dependency1;
    // 1.@Autowired
    Dependency2 dependency2;

    // 2. Setter Injection
    // 2. @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - setDependency1"); // debug
        this.dependency1 = dependency1;
    }

    // 2. @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - setDependency2"); // debug
        this.dependency2 = dependency2;
    }

    // 3. Constructor Injection
    // 3. @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor Injection - YourBusinessClass"); // debug
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}
@Component
class Dependency1{

}

@Component
class Dependency2{

}

@Configuration
@ComponentScan // default scan : current package
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class)); // >> Using null and null -> Not being Autowired! (Need @Autowired)
            // Using com.in28minutes.learn_spring_framework.learnsprfrwk02.examples.a1.Dependency1@be35cd9 and com.in28minutes.learn_spring_framework.learnsprfrwk02.examples.a1.Dependency2@4944252c
        }

    }
}
