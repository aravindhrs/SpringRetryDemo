package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringRetryMain.class)
public class RetryTest {

    @Autowired
    private RetryService retryService;

    @Autowired
    private RetryAndRecoverService retryAndRecoverService;

	@Test(expected=SampleException.class)
	public void simpleRetry() {
        retryService.simpleRetry();
	}

    @Test
    public void retryWithException() {
        retryAndRecoverService.retryWithException();
    }

	@Test
	public void withTemplate() {
        retryService.withTemplate();
	}
}
