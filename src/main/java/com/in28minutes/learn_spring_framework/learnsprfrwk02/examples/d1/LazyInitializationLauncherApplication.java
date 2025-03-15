package com.in28minutes.learn_spring_framework.learnsprfrwk02.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}

@Component
@Lazy // prevents auto initialization when launch of spring context - happens when bean is used
class ClassB{
    private ClassA classA;

    public ClassB(ClassA classA){
        // a lot of other logics
        System.out.println("Some Initialization Logic"); //executed at the launch of spring context - automatically called
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("Do Something"); // sout << Initialization of context is complete \n Some Initialization Logic \n Do Something

    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
            System.out.println("Initialization of context is completed");

            context.getBean(ClassB.class).doSomething();
        }

    }
}
