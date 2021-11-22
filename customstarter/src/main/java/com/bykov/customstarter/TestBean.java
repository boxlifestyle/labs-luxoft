package com.bykov.customstarter;

import com.bykov.CustomStarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
    @Autowired
    private CustomStarterService starterService;

    public void testHelloStarter() {
        starterService.helloStarter();
    }
}
