package com.example.nhom221;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class CSRFToken {
    private static final Map<String, Long> tokenMap = new HashMap<>();
    private static final long TOKEN_EXPIRATION_TIME = 600000; // Thời gian sống của token (miligiây), ví dụ: 10 phút

    public static String generateToken() {
        String token = UUID.randomUUID().toString();
        // Lưu token và thời gian tạo vào map
        tokenMap.put(token, System.currentTimeMillis());
        return token;
    }

    public static boolean isValidToken(String token) {
        if (token == null || !tokenMap.containsKey(token)) {
            // Token không tồn tại trong map
            return false;
        }
        // Lấy thời gian tạo của token
        long tokenTime = tokenMap.get(token);
        // Kiểm tra xem token đã hết hạn chưa
        if (System.currentTimeMillis() - tokenTime > TOKEN_EXPIRATION_TIME) {
            // Token đã hết hạn
            tokenMap.remove(token); // Xóa token khỏi map
            return false;
        }
        // Token hợp lệ
        return true;
    }
}
