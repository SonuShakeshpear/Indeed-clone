package Demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = "prototype")
public class Doctor implements Staff, BeanNameAware {
    //bean factory and application context to load all the beans for configuration
    //bean factory extends application conext. so, there are lot of properties added to bean factory.


    public String getQualification() {
        return qualification;
    }

    /*
    public Doctor(String qualification) {
        this.qualification = qualification;
    }

     */

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    private String qualification;



    public void assist(){
        System.out.println("Doctor is assissting");
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Set Bean name method is called");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Post construct method called");
    }
}
