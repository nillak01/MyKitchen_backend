package com.samsung;


import com.samsung.repository.ProductsForRecipeRepository;
import com.samsung.service.MyKitchenDemo;
import com.samsung.service.MyKitchenDemoSout;
import com.samsung.service.ProductsForRecipeServiceimpl;
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

       /* MyKitchenDemoSout myKitchenDemoSout = context.getBean(MyKitchenDemoSout.class);
        myKitchenDemoSout.productsForRecipeDemo();

        context.close();*/

        /*ProductsForRecipeServiceimpl productsForRecipeServiceimpl = context.getBean(ProductsForRecipeServiceimpl.class);
        System.out.println(productsForRecipeServiceimpl.getAll());*/

           try {
                Console.main(args);
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
