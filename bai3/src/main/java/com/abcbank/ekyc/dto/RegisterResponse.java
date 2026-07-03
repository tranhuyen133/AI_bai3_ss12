package com.abcbank.ekyc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * <h1>RegisterResponse DTO</h1>
 * Trả về kết quả sau khi đăng ký và định danh eKYC thành công.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponse {
    private UUID accountId;
    private String accountNumber;
    private String status;
    private String message;
}
