package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;
@EnableRetry
@SpringBootApplication
@Import(value=RetryExampleApplication.class)
public class SpringRetryMain implements CommandLineRunner{
	@Autowired
    private RetryService retryService;
    @Autowired
    private  RetryAndRecoverService retryAndRecoverService;
    
    public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringRetryMain.class, args);
	}

    public void retryWithException() {
        retryAndRecoverService.retryWithException();
    }

	@Override
	public void run(String... arg0) throws Exception {
		//retryAndRecoverService.retryWithException();
		//retryService.simpleRetry();
		retryService.withTemplate();
	}

}
