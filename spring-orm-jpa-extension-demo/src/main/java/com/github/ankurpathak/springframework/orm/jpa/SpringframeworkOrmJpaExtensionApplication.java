package com.github.ankurpathak.springframework.orm.jpa;
import com.github.ankurpathak.springframework.orm.jpa.domain.model.User;
import com.github.ankurpathak.springframework.orm.jpa.domain.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringframeworkOrmJpaExtensionApplication {


    public static void main(String[] args) {

        SpringApplication.run(SpringframeworkOrmJpaExtensionApplication.class, args);
        System.out.println();
    }
}


@Component
class ApplicationRunnerImpl implements ApplicationRunner{

    public static Logger log = LoggerFactory.getLogger(ApplicationRunnerImpl.class);


    @Autowired
    private IUserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
       try{
           userRepository.save(new User().email("ankurpathak@live.in").name("Ankur Pathak"));
           userRepository.save(new User().email("ankurpathak@live.in").name("Ankur Pathak"));

       }catch (Exception ex){
            log.error("Exception: {}", ex.getClass().getName());
           log.error("Exception Message: {}", ex.getMessage());
           log.error("Exception Cause: {}", ex.getCause());

       }

    }
}
