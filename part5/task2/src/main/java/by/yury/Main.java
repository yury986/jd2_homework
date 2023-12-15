package by.yury;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring.cfg.xml");
        Person person = context.getBean("person", Person.class);

        System.out.println("name is: " + person.getName());

        context.close();
    }

}
