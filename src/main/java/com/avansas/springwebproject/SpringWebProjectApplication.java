package com.avansas.springwebproject;

import com.avansas.springwebproject.entities.XUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Getter
@Setter
public class SpringWebProjectApplication {
    @Autowired
    static XUser xUser;
    public static void main(String[] args) {
        xUser=new XUser();
        SpringApplication.run(SpringWebProjectApplication.class, args);
    }

}
