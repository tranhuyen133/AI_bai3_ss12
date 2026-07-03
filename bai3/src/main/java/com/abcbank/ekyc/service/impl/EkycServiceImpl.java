package com.abcbank.ekyc.service.impl;

import com.abcbank.ekyc.dto.RegisterRequest;
import com.abcbank.ekyc.dto.RegisterResponse;
import com.abcbank.ekyc.exception.DuplicateResourceException;
import com.abcbank.ekyc.model.Customer;
import com.abcbank.ekyc.repository.CustomerRepository;
import com.abcbank.ekyc.service.EkycService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Random;

/**
 * <h1>EkycServiceImpl</h1>
 * Triển khai các quy tắc nghiệp vụ định danh và tích hợp Core Banking cấp số tài khoản.
 */
@Service
@RequiredArgsConstructor
public class EkycServiceImpl implements EkycService {

    private final CustomerRepository customerRepository;

    @Override
    public RegisterResponse registerCustomer(RegisterRequest request) {
        // Quy tắc 1: Kiểm tra trùng số điện thoại
        if (customerRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateResourceException("Số điện thoại này đã được sử dụng trên hệ thống");
        }

        // Quy tắc 2: Kiểm tra trùng số CCCD
        if (customerRepository.existsByCitizenId(request.getCitizenId())) {
            throw new DuplicateResourceException("Số Căn cước công dân này đã được đăng ký tài khoản");
        }

        // Mô phỏng tích hợp hệ thống Core: sinh tự động Số tài khoản thanh toán
        // Quy tắc sinh: Bắt đầu bằng 999 và tiếp theo là 7 số ngẫu nhiên
        String generatedAccountNumber = generateAccountNumber();

        // Khởi tạo đối tượng Customer để lưu xuống Database
        // Luồng mặc định eKYC thành công tự động được đặt trạng thái ACTIVE
        Customer customer = Customer.builder()
                .fullName(request.getFullName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .citizenId(request.getCitizenId())
                .accountNumber(generatedAccountNumber)
                .status("ACTIVE")
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        // Trả về DTO chứa thông tin kết quả
        return RegisterResponse.builder()
                .accountId(savedCustomer.getId())
                .accountNumber(savedCustomer.getAccountNumber())
                .status(savedCustomer.getStatus())
                .message("Định danh eKYC và mở tài khoản trực tuyến thành công")
                .build();
    }

    /**
     * Hàm sinh số tài khoản ngẫu nhiên.
     */
    private String generateAccountNumber() {
        Random random = new Random();
        int suffix = 1000000 + random.nextInt(9000000); // 7 chữ số ngẫu nhiên
        return "999" + suffix;
    }
}
