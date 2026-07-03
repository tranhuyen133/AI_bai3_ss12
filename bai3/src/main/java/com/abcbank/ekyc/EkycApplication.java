package com.abcbank.ekyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>EkycApplication</h1>
 * Lớp khởi chạy ứng dụng eKYC API của ngân hàng số ABC Bank.
 */
@SpringBootApplication
public class EkycApplication {
    public static void main(String[] args) {
        SpringApplication.run(EkycApplication.class, args);
    }
}
