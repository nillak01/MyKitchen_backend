package com.samsung;


import com.samsung.service.MyKitchenDemo;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);


            try {
                Console.main(args);
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
