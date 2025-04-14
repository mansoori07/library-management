package com.example.library.mocking;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mock-config")
public class MockConfiguration {

    boolean mock;
    String shelfPath;

}
