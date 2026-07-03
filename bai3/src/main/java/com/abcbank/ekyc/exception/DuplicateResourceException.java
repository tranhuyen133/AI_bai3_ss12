package com.abcbank.ekyc.exception;

/**
 * <h1>DuplicateResourceException</h1>
 * Ngoại lệ ném ra khi phát hiện trùng lặp tài nguyên (SĐT hoặc CCCD).
 */
public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
        super(message);
    }
}
