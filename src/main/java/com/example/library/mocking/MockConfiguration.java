package com.example.library.mocking;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Data
@ConfigurationProperties(prefix = "mock-config")
public class MockConfiguration {

    boolean mock;
    String shelfPath;

}
