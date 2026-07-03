package com.abcbank.ekyc.controller;

import com.abcbank.ekyc.dto.RegisterRequest;
import com.abcbank.ekyc.dto.RegisterResponse;
import com.abcbank.ekyc.service.EkycService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>EkycController</h1>
 * REST Controller tiếp nhận và định tuyến các luồng API liên quan đến eKYC.
 */
@RestController
@RequestMapping("/api/v1/ekyc")
@RequiredArgsConstructor
public class EkycController {

    private final EkycService ekycService;

    /**
     * Endpoint đăng ký tài khoản eKYC tự động.
     * Sử dụng @Valid để kích hoạt kiểm tra dữ liệu đầu vào.
     */
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerCustomer(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse response = ekycService.registerCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
