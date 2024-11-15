package org.example.gather_back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
public class GatherBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatherBackEndApplication.class, args);
    }

}
