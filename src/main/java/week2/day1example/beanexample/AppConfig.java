package week2.day1example.beanexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Trong Phu on 14/08/2024 20:28:00
 *
 * @author Trong Phu
 */
@Configuration
public class AppConfig {

    @Bean(destroyMethod = "cleanup")
    public MyBean myBean() {
        return new MyBean();
    }

    public void checkAppConfig(){
        System.out.println("Check");
    }

}
