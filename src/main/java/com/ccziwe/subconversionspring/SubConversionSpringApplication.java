package com.ccziwe.subconversionspring;

import com.ccziwe.tool.JTextArea;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication(scanBasePackages="com.ccziwe.controller")
public class SubConversionSpringApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SubConversionSpringApplication.class, args);
        System.setProperty("java.awt.headless", "false");
        new JTextArea();
    }

}
