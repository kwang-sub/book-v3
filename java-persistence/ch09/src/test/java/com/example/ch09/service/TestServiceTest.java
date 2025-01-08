package com.example.ch09.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestServiceTest {
    @Autowired
    private TestService testService;

    @Test
    void test() {
        testService.storeLoadEntities();
    }

}