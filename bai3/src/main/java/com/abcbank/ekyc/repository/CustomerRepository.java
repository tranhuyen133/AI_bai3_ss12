package com.abcbank.ekyc.repository;

import com.abcbank.ekyc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

/**
 * <h1>CustomerRepository</h1>
 * Giao tiếp với Cơ sở dữ liệu để thực thi truy vấn thông tin Customer.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    
    // Kiểm tra số điện thoại đã tồn tại chưa
    boolean existsByPhone(String phone);

    // Kiểm tra số CCCD đã tồn tại chưa
    boolean existsByCitizenId(String citizenId);
}
