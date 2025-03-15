package com.in28minutes.learn_spring_framework.learnsprfrwk02.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component // when getBean, same bean retrieved (same hashcode)
class NormalClass {

}
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // prototype class -> when getBean, different bean retrieved (new instance)
@Component
class PrototypeClass {

}



@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

        }

    }
}
