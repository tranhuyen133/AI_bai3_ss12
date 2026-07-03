package com.abcbank.ekyc.service;

import com.abcbank.ekyc.dto.RegisterRequest;
import com.abcbank.ekyc.dto.RegisterResponse;

/**
 * <h1>EkycService Interface</h1>
 * Định nghĩa các nghiệp vụ cốt lõi của quy trình eKYC.
 */
public interface EkycService {
    /**
     * Thực hiện kiểm tra nghiệp vụ và đăng ký tài khoản khách hàng mới.
     * @param request dữ liệu đăng ký đầu vào
     * @return kết quả thông tin tài khoản được cấp tự động
     */
    RegisterResponse registerCustomer(RegisterRequest request);
}
