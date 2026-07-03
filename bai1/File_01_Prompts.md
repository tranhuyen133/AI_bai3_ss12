# FILE 01: CHUỒI PROMPT PHÂN TÍCH NGHIỆP VỤ eKYC (ABC BANK)

Tài liệu này chứa toàn bộ chuỗi Prompt được thiết kế theo phương pháp **Iterative Prompting (Gợi ý lặp)** và **Role-playing (Đóng vai)** nhằm tối ưu hóa khả năng của Antigravity trong vai trò Senior FinTech Business Analyst (BA).

---

## CHIẾN LƯỢC THIẾT KẾ CHUỖI PROMPT
Để trích xuất yêu cầu một cách chuyên nghiệp và có chiều sâu, chuỗi Prompt được chia làm 3 bước chính:
1. **Prompt 1 (Thiết lập vai trò & Ngữ cảnh):** Khởi tạo AI dưới vai trò một chuyên gia BA FinTech, cung cấp bối cảnh tổng quát của dự án và mục tiêu cốt lõi của ngân hàng (Zero Manual Operation).
2. **Prompt 2 (Phân tích Yêu cầu Nghiệp vụ Chi tiết):** Yêu cầu AI bóc tách chi tiết các thành phần kỹ thuật-nghiệp vụ bao gồm: Actors, Business Flow, Functional Requirements (FR), Non-Functional Requirements (NFR), Assumptions & Business Rules.
3. **Prompt 3 (Sinh tài liệu Artifacts chuyên nghiệp):** Chuyển đổi các kết quả phân tích thành User Stories chuẩn Agile (kèm Acceptance Criteria) và Danh sách Use Case chi tiết.

---

## CHI TIẾT CÁC PROMPT ĐÃ SỬ DỤNG

### PROMPT 1: THIẾT LẬP VAI TRÒ & NGỮ CẢNH (ROLE-PLAYING & CONTEXT SETTING)

*   **Mục đích:** Định hướng AI tư duy như một Senior BA có kinh nghiệm sâu sắc về ngân hàng số, quy trình bảo mật nghiệp vụ và trải nghiệm người dùng, tránh các câu trả lời chung chung.
*   **Nội dung Prompt:**

```text
Hãy đóng vai là một Senior Business Analyst (BA) có 10 năm kinh nghiệm trong lĩnh vực FinTech và Ngân hàng số (Digital Banking). Bạn đã từng triển khai nhiều dự án eKYC và số hóa quy trình mở tài khoản (Digital Onboarding) thành công cho các ngân hàng lớn.

Ngữ cảnh dự án: 
Ngân hàng số ABC Bank đang triển khai dự án "Số hóa hoàn toàn quy trình mở tài khoản trực tuyến (eKYC)" trên ứng dụng di động (Mobile App). 
Mục tiêu cốt lõi: Đạt trạng thái "Zero manual operation" – tự động hóa 100% quy trình đối chiếu và duyệt thông tin, giảm thiểu tối đa sự can thiệp của giao dịch viên hoặc bộ phận Back-Office.

Luồng đi cơ bản (Happy Path):
1. Khách hàng tải app ABC Bank về điện thoại.
2. Khách hàng đăng ký thông tin cơ bản ban đầu (SĐT, Email).
3. Khách hàng thực hiện chụp ảnh 2 mặt Căn cước công dân (CCCD) gắn chip.
4. Khách hàng quét khuôn mặt thực tế (Liveness check/Face Match).
5. Hệ thống thực hiện đối chiếu dữ liệu OCR từ CCCD, ảnh chân dung tự chụp và dữ liệu dân cư/hệ thống quản lý.
6. Cấp số tài khoản tự động (Auto-generation) ngay lập tức nếu dữ liệu hợp lệ.

Nhiệm vụ của bạn:
Xác nhận rằng bạn đã hiểu rõ vai trò và ngữ cảnh này. Hãy phản hồi ngắn gọn bằng cách nêu ra 3 thách thức lớn nhất về mặt nghiệp vụ/kỹ thuật khi ngân hàng muốn đạt mục tiêu "Zero manual operation" cho quy trình eKYC này.
```

---

### PROMPT 2: PHÂN TÍCH HỆ THỐNG CHI TIẾT (SYSTEM ANALYSIS & REQUIREMENTS EXTRACTION)

*   **Mục đích:** Yêu cầu AI bóc tách toàn bộ yêu cầu nghiệp vụ của hệ thống dưới góc nhìn kỹ thuật và vận hành của một BA chuyên nghiệp.
*   **Nội dung Prompt:**

```text
Với tư cách là Senior BA của dự án, hãy thực hiện phân tích chi tiết yêu cầu nghiệp vụ của quy trình eKYC cho ABC Bank. Hãy lập tài liệu phân tích nghiệp vụ gồm các phần sau:

1. Actors (Tác nhân tham gia hệ thống): Liệt kê và định nghĩa rõ ràng vai trò của tất cả các tác nhân (bao gồm cả con người, hệ thống nội bộ và các dịch vụ của bên thứ ba - Third-party API).
2. Business Flow (Luồng nghiệp vụ từng bước): Mô tả chi tiết luồng xử lý từ lúc khách hàng mở app cho đến khi tài khoản được kích hoạt thành công. Chia rõ luồng Happy Path (điều kiện lý tưởng) và các Exception Paths (luồng ngoại lệ như lỗi OCR không đọc được, liveness check thất bại, trùng thông tin, nằm trong danh sách đen/AML blacklist).
3. Functional Requirements (Yêu cầu chức năng): Bóc tách các chức năng chính cần xây dựng cho hệ thống (ví dụ: Module OCR, Module Liveness Detection, Module Fraud Check, Module Core Banking Integration...).
4. Non-Functional Requirements (Yêu cầu phi chức năng): Tập trung sâu vào các yếu tố: Security & Compliance (Bảo mật & Tuân thủ pháp luật/Ngân hàng nhà nước), Performance & Latency (Hiệu năng xử lý thời gian thực), Availability (Tính sẵn sàng), và Usability (Trải nghiệm người dùng).
5. Assumptions & Business Rules (Giả định & Quy tắc nghiệp vụ):
   - Quy tắc về ngưỡng chính xác (Confidence Score Threshold) của OCR và Face Match.
   - Quy tắc kiểm tra danh sách đen (Blacklist/PEP/AML check).
   - Giới hạn hạn mức giao dịch (Transaction Limit) đối với tài khoản eKYC tự động.
   - Các giả định về hạ tầng kỹ thuật (kết nối cơ sở dữ liệu quốc gia về dân cư).

Hãy viết tài liệu này một cách chi tiết, chuyên nghiệp, sử dụng bảng biểu (nếu cần) để thông tin rõ ràng và mạch lạc.
```

---

### PROMPT 3: SINH ARTIFACTS DỰ ÁN (USER STORIES & USE CASES)

*   **Mục đích:** Chuyển đổi các phân tích yêu cầu ở Prompt 2 thành các sản phẩm bàn giao (Artifacts) thực tế dùng cho đội ngũ thiết kế UX/UI và Lập trình (Developers).
*   **Nội dung Prompt:**

```text
Dựa trên tài liệu phân tích nghiệp vụ chi tiết đã lập ở bước trước, hãy thiết kế các tài liệu bàn giao dự án sau:

1. Danh sách User Stories (Tối thiểu 6 User Stories chính bao quát toàn bộ luồng eKYC). Mỗi User Story phải tuân thủ định dạng chuẩn Agile:
   - "As a [Role], I want to [Action] so that [Benefit]."
   - Kèm theo Điều kiện nghiệm thu (Acceptance Criteria) viết dưới định dạng Given-When-Then để Tester/Developer có thể kiểm thử.

2. Danh sách Use Cases (Tối thiểu 4 Use Case chính). Mỗi Use Case cần được mô tả cấu trúc gồm:
   - Use Case Name (Tên Use Case).
   - Brief Description (Mô tả ngắn gọn).
   - Primary Actor (Tác nhân chính).
   - Pre-conditions (Điều kiện tiên quyết).
   - Post-conditions (Kết quả sau khi thực hiện).
   - Happy Path (Luồng xử lý chính).
   - Alternative/Exception Flows (Luồng rẽ nhánh/ngoại lệ).

Hãy trình bày rõ ràng bằng định dạng Markdown, sử dụng bảng biểu và các ký hiệu chuyên nghiệp để dễ dàng đọc và chuyển giao cho đội phát triển.
```
