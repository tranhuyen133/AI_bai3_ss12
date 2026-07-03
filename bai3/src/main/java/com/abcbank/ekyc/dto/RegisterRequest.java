package com.abcbank.ekyc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>RegisterRequest DTO</h1>
 * Tiếp nhận thông tin đăng ký eKYC từ Client và thực thi kiểm tra hợp lệ dữ liệu.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Họ và tên không được để trống")
    private String fullName;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0|\\+84)[3|5|7|8|9][0-9]{8}$", 
             message = "Số điện thoại không đúng định dạng Việt Nam (ví dụ: 0912345678)")
    private String phone;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Địa chỉ email không đúng định dạng")
    private String email;

    @NotBlank(message = "Số CCCD không được để trống")
    @Pattern(regexp = "^[0-9]{12}$", 
             message = "Số CCCD phải bao gồm chính xác 12 chữ số")
    private String citizenId;
}
