package com.isga.customerservice;

import com.isga.customerservice.dtos.CustomerRequestDTO;
import com.isga.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService){
        return args->{
            List<String> names= List.of("Mohamed", "Imane", "Yassin", "Aya");
            names.forEach(name->{
                customerService.saveCustomer(CustomerRequestDTO.builder()
                                .name(name)
                                .email(name+"@gmail.com")
                                .build());
            });
        };
    }

}
