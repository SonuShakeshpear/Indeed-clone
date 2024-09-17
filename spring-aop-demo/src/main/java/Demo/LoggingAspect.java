package Demo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* Demo.ShoppingCart.checkout(..))")
        public void beforelogger(JoinPoint jp){
        String args= jp.getArgs()[0].toString();
        System.out.println(jp.getSignature());
        System.out.println("Before Loggers");
        System.out.println("arguments : " + args);
        }

        @After("execution(* *.*.checkout(..))")
    public void afterlogger(){

        System.out.println("After Loggers");
    }

    @Pointcut("execution(* Demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut(){

    }

    public void afterReturning(){
        System.out.println("After Returning");
    }
}
