package com.ampel.drugsearch.download;

import java.util.ArrayList;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.ampel.drugsearch.model.Drug;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@ComponentScan(value="com.ampel.drugsearch")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class,JndiConnectionFactoryAutoConfiguration.class})

public class App 
{
	
	
	public static ArrayList<Drug> queryList = new ArrayList<>(); 
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    
}
