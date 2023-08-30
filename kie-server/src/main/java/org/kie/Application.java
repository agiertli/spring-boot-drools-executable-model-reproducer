package org.kie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {



        System.out.println("Setting bypass to true");
        System.setProperty("org.kie.server.bypass.auth.user", "true");
     //   System.setProperty("org.jbpm.ht.admin.user", "kieserver");
       // System.setProperty("org.jbpm.ht.admin.group", "Administrators");
        SpringApplication.run(Application.class, args);
    }

}