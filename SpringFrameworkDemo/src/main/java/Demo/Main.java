package Demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualification("MBBS");
        System.out.println(doctor);
       // System.out.println(staff.getQualification());

        Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor1);

    }
}
