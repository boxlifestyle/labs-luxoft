package com.bykov;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "customstarter.enabled", havingValue = "true")
public class CustomStarterService {

    public void helloStarter() {
        System.out.println("HELLO CUSTOM STARTER");
    }
}
