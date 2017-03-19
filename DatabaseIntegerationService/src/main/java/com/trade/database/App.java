package com.trade.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
//        Role role = new Role();
//        role.setRolename("Admin");
//        role.setCreatedby("1");
//        role.setCreateddate(new Date());
        //RoleHome home = new RoleHome();
        //home.persist(role);
    }
}
