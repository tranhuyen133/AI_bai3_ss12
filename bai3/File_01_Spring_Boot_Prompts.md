# FILE 01: CHUỒI PROMPT SINH MÃ NGUỒN SPRING BOOT (eKYC API)

Tài liệu này chứa chuỗi Prompt đã được thiết kế và sử dụng để định hướng Antigravity đóng vai trò Senior Backend Developer, xây dựng thành công API eKYC trong Spring Boot theo đúng mô hình 3 lớp chuẩn nghiệp vụ.

---

## CHIẾN LƯỢC THIẾT KẾ CHUỒI PROMPT
Việc viết mã nguồn có cấu trúc tốt yêu cầu sự chia tách trách nhiệm rõ ràng (Separation of Concerns). Do đó, chuỗi Prompt được chia nhỏ như sau:
1. **Prompt 1 (Thiết lập vai trò & Khởi tạo cấu trúc dữ liệu):** Định nghĩa vai trò Senior Backend Developer, cung cấp đặc tả Input/Output của API từ SRS và tạo lớp Entity cùng DTOs (Request/Response) có validate dữ liệu đầu vào.
2. **Prompt 2 (Xây dựng tầng xử lý nghiệp vụ & Điều phối - Service & Controller):** Xây dựng tầng Service Interface/Impl (mô phỏng logic kiểm tra OCR/Liveness) và REST Controller để tiếp nhận request.
3. **Prompt 3 (Xử lý lỗi tập trung - Exception Handler):** Bổ sung bộ xử lý lỗi Global Exception Handler nhằm trả về các thông báo lỗi xác thực trực quan (Bad Request).
4. **Prompt 4 (Vẽ sơ đồ kiến trúc luồng dữ liệu):** Thiết kế sơ đồ kiến trúc ứng dụng (Architecture Diagram) bằng mã Mermaid mô tả luồng đi của dữ liệu từ Client qua các lớp đến Database.

---

## CHI TIẾT CÁC PROMPT ĐÃ SỬ DỤNG

### PROMPT 1: THIẾT LẬP VAI TRÒ & SINH CẤU TRÚC LỚP DỮ LIỆU (ENTITY, DTO, REPOSITORY)

*   **Mục đích:** Khởi tạo lớp Entity liên kết DB (sử dụng JPA), các lớp truyền tải dữ liệu DTO có khai báo kiểm tra tính hợp lệ (Data Validation).
*   **Nội dung Prompt:**

```text
Hãy đóng vai là một Senior Backend Developer có 10 năm kinh nghiệm phát triển các hệ thống tài chính lớn bằng Java / Spring Boot. 
Dựa trên tài liệu SRS eKYC của ABC Bank, bạn hãy khởi dựng mã nguồn cho API "Đăng ký mở tài khoản cơ bản".

Đặc tả API:
- HTTP Method: POST
- Endpoint: /api/v1/ekyc/register
- Request Body (JSON):
  + fullName (Họ và tên - không được để trống)
  + phone (Số điện thoại - định dạng SĐT Việt Nam)
  + email (Địa chỉ email - định dạng email hợp lệ)
  + citizenId (Số CCCD - bắt buộc đúng 12 chữ số)
- Response Body (JSON):
  + accountId (Mã định danh tài khoản - UUID)
  + accountNumber (Số tài khoản tự động sinh)
  + status (PENDING / ACTIVE)
  + message (Thông báo phản hồi)

Nhiệm vụ 1: 
Hãy sinh mã nguồn cho các thành phần sau:
1. Entity: Lớp `Customer` ánh xạ cơ sở dữ liệu (sử dụng JPA Hibernate), bao gồm các trường dữ liệu trên và các trường tự động tạo như id, createdAt.
2. DTOs: Lớp `RegisterRequest` (có các annotation validate dữ liệu: @NotBlank, @Email, @Pattern cho citizenId và phone) và lớp `RegisterResponse`.
3. Repository: Interface `CustomerRepository` kế thừa `JpaRepository`.

Yêu cầu kỹ thuật:
- Có JavaDoc giải thích các lớp và comment tiếng Việt trong code.
- Sử dụng Lombok (@Data, @NoArgsConstructor, @AllArgsConstructor, @Builder) để code ngắn gọn.
```

---

### PROMPT 2: XÂY DỰNG TẦNG SERVICE VÀ REST CONTROLLER

*   **Mục đích:** Xây dựng logic nghiệp vụ (kiểm tra trùng lặp thông tin, tạo CIF/Số tài khoản ngẫu nhiên) và mở cổng REST API nhận request.
*   **Nội dung Prompt:**

```text
Tiếp tục phát triển hệ thống eKYC Spring Boot với vai trò Senior Backend Developer.
Hãy sinh mã nguồn cho:
1. Service: Interface `EkycService` và lớp triển khai `EkycServiceImpl`. Lớp này xử lý logic nghiệp vụ:
   - Kiểm tra xem Số điện thoại hoặc Số CCCD đã tồn tại trong CSDL chưa (thông qua JpaRepository). Nếu trùng, ném ra một Custom Exception `DuplicateResourceException`.
   - Giả định hệ thống chạy kiểm tra tự động OCR/Face Match (luôn giả lập thành công để trả về trạng thái ACTIVE, hoặc PENDING nếu điểm giả lập nằm trong diện cần duyệt thủ công).
   - Tự động sinh số tài khoản ngẫu nhiên gồm 10 chữ số bắt đầu bằng "999".
   - Lưu thông tin Customer vào cơ sở dữ liệu và trả về DTO Response.
2. Controller: Lớp `EkycController` tại endpoint `/api/v1/ekyc/register`. Sử dụng `@Valid` để kích hoạt validation tự động cho Request Body.

Yêu cầu kỹ thuật:
- Đảm bảo viết JavaDoc chi tiết cho từng method của Service và Controller.
- Sử dụng các annotation của Spring Boot như @RestController, @RequestMapping, @PostMapping, @RequiredArgsConstructor.
```

---

### PROMPT 3: VIẾT BỘ XỬ LÝ LỖI TOÀN CỤC (GLOBAL EXCEPTION HANDLER)

*   **Mục đích:** Bắt các lỗi xác thực dữ liệu đầu vào (MethodArgumentNotValidException) và trả về JSON chứa chi tiết lỗi rõ ràng cho client.
*   **Nội dung Prompt:**

```text
Để API eKYC hoàn thiện hơn và dễ dàng tích hợp với Mobile App, hãy viết một lớp xử lý ngoại lệ toàn cục (Global Exception Handler) bằng Spring Boot.
Lớp này phải:
1. Bắt ngoại lệ `MethodArgumentNotValidException` (lỗi do validate không thành công các trường như citizenId, email...) và trả về HTTP Status 400 (Bad Request) với danh sách chi tiết các trường bị lỗi và thông báo lỗi tương ứng dưới dạng Map/JSON.
2. Bắt ngoại lệ `DuplicateResourceException` (lỗi trùng thông tin SĐT/CCCD) và trả về HTTP Status 409 (Conflict).
3. Bắt các ngoại lệ chung khác và trả về HTTP Status 500 (Internal Server Error).

Hãy sử dụng `@RestControllerAdvice` và `@ExceptionHandler` để hiện thực hóa yêu cầu này. Đảm bảo có JavaDoc và comment đầy đủ.
```

---

### PROMPT 4: BẢN VẼ KIẾN TRÚC DỮ LIỆU (ARCHITECTURE DIAGRAM - MERMAID)

*   **Mục đích:** Yêu cầu AI trực quan hóa cấu trúc dự án từ Client qua các phân lớp của Spring Boot tới Database bằng mã Mermaid.
*   **Nội dung Prompt:**

```text
Hãy vẽ một sơ đồ kiến trúc hệ thống mô tả luồng đi của dữ liệu từ thiết bị di động khách hàng (Mobile Client) qua các lớp Controller, Service, Repository, Database và Global Exception Handler của hệ thống Spring Boot eKYC API.
Yêu cầu:
- Sử dụng mã Mermaid dưới dạng sơ đồ khối rõ ràng.
- Ghi rõ luồng gửi dữ liệu (Happy Path) và luồng xử lý lỗi khi validation thất bại (Exception Path quay ngược lại Client).
- Sử dụng tiếng Việt trong sơ đồ để làm tài liệu bàn giao.
```
