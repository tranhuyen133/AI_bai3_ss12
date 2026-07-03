# FILE 01: CHUỒI PROMPT XÂY DỰNG TÀI LIỆU ĐẶC TẢ PHẦN MỀM (SRS) - eKYC

Tài liệu này chứa chuỗi Prompt chuyên nghiệp được thiết kế theo phương pháp **Structured Breakdown (Chia nhỏ cấu trúc)** để tạo ra một tài liệu Đặc tả phần mềm (Software Requirements Specification - SRS) chuẩn **IEEE 830** cho tính năng eKYC của ABC Bank.

---

## CHIẾN LƯỢC THIẾT KẾ CHUỒI PROMPT
Viết một tài liệu SRS chuẩn IEEE đòi hỏi lượng thông tin rất lớn và tính chặt chẽ cao. Nếu yêu cầu AI sinh toàn bộ tài liệu trong một Prompt duy nhất, nội dung sẽ bị tóm tắt ngắn gọn và thiếu chi tiết kỹ thuật.
Do đó, chuỗi Prompt được thiết kế gồm các bước sau:
1. **Prompt 1 (Thiết lập vai trò & Cấu trúc tài liệu):** Định nghĩa vai trò Senior Business Analyst kiêm Technical Architect và thiết lập cấu trúc tổng quát của tài liệu SRS theo chuẩn IEEE.
2. **Prompt 2 (Chi tiết hóa Phần 1 & Phần 2):** Tập trung sinh nội dung giới thiệu chung (Purpose, Scope, Definitions) và mô tả tổng quan hệ thống (Product Perspective, Constraints).
3. **Prompt 3 (Chi tiết hóa Yêu cầu Kỹ thuật và Phi Chức năng - Phần 3 & 4):** Phân tích sâu các module kỹ thuật (OCR, Liveness, Activation) và các chỉ số phi chức năng định lượng (Security, Latency, TPS).
4. **Prompt 4 (Thiết kế Sơ đồ Use Case - Phần 5):** Yêu cầu AI sinh mã Mermaid UML để mô tả trực quan các tương tác giữa User và các hệ thống (System Actors).

---

## CHI TIẾT CÁC PROMPT ĐÃ SỬ DỤNG

### PROMPT 1: THIẾT LẬP VAI TRÒ & KHUNG CẤU TRÚC SRS (STANDARD IEEE 830)

*   **Mục đích:** Kích hoạt vai trò chuyên gia phân tích kỹ thuật và định hình khung tài liệu SRS chuẩn để chuẩn bị cho các bước phân tích chi tiết.
*   **Nội dung Prompt:**

```text
Hãy đóng vai là một Senior Business Analyst kiêm Technical Architect có kinh nghiệm sâu sắc trong việc viết tài liệu đặc tả phần mềm (SRS). Nhiệm vụ của bạn là cùng tôi xây dựng một tài liệu Đặc tả phần mềm (Software Requirements Specification - SRS) hoàn chỉnh theo tiêu chuẩn IEEE 830 cho tính năng "Mở tài khoản trực tuyến eKYC" của ngân hàng số ABC Bank.

Khung cấu trúc bắt buộc của tài liệu SRS bao gồm:
- Phần 1: Introduction (Mục đích, Phạm vi hệ thống, Định nghĩa thuật ngữ).
- Phần 2: Overall Description (Góc nhìn sản phẩm, Đặc điểm người dùng, Giới hạn hệ thống).
- Phần 3: Specific Functional Requirements (Mô tả chi tiết 4 Module: Đăng ký thông tin, Đọc CCCD/OCR, Xác thực khuôn mặt/Liveness, Kích hoạt tài khoản/Core integration).
- Phần 4: Non-Functional Requirements (Bảo mật dữ liệu, Hiệu năng xử lý, Tính sẵn sàng).
- Phần 5: Visual Diagram (Sơ đồ Use Case Diagram bằng mã Mermaid).

Hãy phản hồi ngắn gọn xác nhận bạn đã nắm rõ khung cấu trúc này và sẵn sàng đi vào chi tiết từng phần.
```

---

### PROMPT 2: HOÀN THIỆN PHẦN 1 & PHẦN 2 (INTRODUCTION & OVERALL DESCRIPTION)

*   **Mục đích:** Tập trung viết sâu sắc các phần giới thiệu, định nghĩa thuật ngữ chính xác trong ngành FinTech và chỉ rõ các ràng buộc kỹ thuật/luật pháp.
*   **Nội dung Prompt:**

```text
Hãy soạn thảo chi tiết Phần 1 (Introduction) và Phần 2 (Overall Description) của tài liệu SRS dựa trên thông tin nghiệp vụ eKYC của ABC Bank:

Phần 1: Giới thiệu chung (Introduction)
- Purpose: Xác định rõ đối tượng đọc tài liệu (Dev, QA, PM, Risk Team) và mục đích sử dụng.
- Scope: Mô tả phạm vi ứng dụng mobile app eKYC và các hệ thống liên kết.
- Definitions, Acronyms, and Abbreviations: Định nghĩa rõ các từ viết tắt: eKYC, OCR, Liveness Check, Face Match, CIF, PEP, AML, OTP, SDK.

Phần 2: Mô tả tổng quan (Overall Description)
- Product Perspective: Đặt hệ thống eKYC trong mối quan hệ với Mobile App Client, eKYC Gateway, Core Banking và CSDL Dân cư Quốc gia.
- User Classes and Characteristics: Phân loại đối tượng người dùng (Khách hàng cá nhân mở thẻ, Kiểm soát viên duyệt hồ sơ Back-Office) và đặc điểm của họ.
- Constraints: Ràng buộc về pháp lý (Nghị định 13/2023/NĐ-CP về bảo vệ dữ liệu cá nhân, thông tư NHNN về eKYC), ràng buộc về công nghệ (thiết bị di động có camera, kết nối Internet).

Hãy viết bằng tiếng Việt, ngôn từ chuẩn mực kỹ thuật phần mềm.
```

---

### PROMPT 3: CHI TIẾT HÓA YÊU CẦU CHỨC NĂNG & PHI CHỨC NĂNG (SPECIFIC & NON-FUNCTIONAL REQUIREMENTS)

*   **Mục đích:** Đặc tả chi tiết đặc tính kỹ thuật đầu vào, đầu ra, và các yêu cầu phi chức năng có thể đo lường được (quantifiable metrics).
*   **Nội dung Prompt:**

```text
Hãy viết chi tiết Phần 3 (Specific Functional Requirements) và Phần 4 (Non-Functional Requirements) cho tài liệu SRS:

Phần 3: Yêu cầu chức năng chi tiết (Đặc tả rõ Input, Process, Output cho từng module):
1. Module 1: Đăng ký tài khoản ban đầu (Nhập SĐT, Email, Xác thực OTP).
2. Module 2: Upload & Đọc CCCD (Chụp ảnh mặt trước/sau, kiểm tra chất lượng ảnh, chạy OCR trích xuất văn bản, kiểm tra tính hợp lệ của CCCD).
3. Module 3: Xác thực khuôn mặt (Liveness Check phát hiện thực thể sống qua video selfie, Face Match so sánh ảnh chân dung với ảnh CCCD).
4. Module 4: Kích hoạt tài khoản (Kết nối đối chiếu CSDL dân cư, kiểm tra AML/Blacklist, tạo CIF và Tài khoản thanh toán tự động trên Core Banking).

Phần 4: Yêu cầu phi chức năng (Non-Functional Requirements)
- Security (Bảo mật dữ liệu cá nhân khách hàng theo chuẩn AES-256, mã hóa đường truyền HTTPS/TLS 1.3, lưu vết log thao tác không thể sửa xóa).
- Performance (Thời gian phản hồi API OCR < 2s, Face Match < 3s, Core provisioning < 5s, hỗ trợ concurrency tối thiểu 200 TPS).
- Availability (Tính sẵn sàng của hệ thống đạt 99.9%, cơ chế tự động chuyển đổi sang Site DR).

Hãy trình bày dưới dạng bảng hoặc danh mục số rõ ràng để Dev/QA dễ dàng bóc tách viết Test Case.
```

---

### PROMPT 4: THIẾT KẾ SƠ ĐỒ USE CASE BẰNG MERMAID (VISUAL DIAGRAM)

*   **Mục đích:** Yêu cầu AI thiết kế sơ đồ Use Case bằng mã Mermaid mô tả trực quan các tác nhân (User, Ops, Core System) tương tác với hệ thống eKYC.
*   **Nội dung Prompt:**

```text
Hãy hoàn thiện Phần 5 (Visual Diagram) của tài liệu SRS bằng cách viết mã Mermaid để vẽ Use Case Diagram.
Sơ đồ Use Case cần thể hiện rõ:
- Tác nhân (Actors): Khách hàng (Customer), Kiểm soát viên (Ops Officer), Hệ thống eKYC Gateway, Hệ thống Core Banking, Dịch vụ OCR/Face Match (Third-party API).
- Các Use Case chính: Đăng ký OTP, Chụp ảnh & OCR CCCD, Xác thực khuôn mặt (Liveness), Tra cứu CSDL dân cư & AML, Tạo CIF & cấp tài khoản tự động, Phê duyệt thủ công hồ sơ nghi vấn.
- Thể hiện rõ các mối quan hệ (Association, Include, Extend). Ví dụ: Mở tài khoản eKYC bao gồm (include) chụp ảnh CCCD, xác thực khuôn mặt, kiểm tra AML. Phê duyệt thủ công mở rộng (extend) từ luồng định danh tự động khi điểm khớp khuôn mặt nằm trong vùng nghi vấn.

Hãy cung cấp mã nguồn Mermaid sạch, chuẩn cú pháp, không sử dụng các ký tự đặc biệt gây lỗi biên dịch đồ họa.
```
