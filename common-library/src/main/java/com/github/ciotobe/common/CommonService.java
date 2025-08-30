package com.github.ciotobe.common;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CommonService {

    public String processText(String text) {
        if (!StringUtils.hasText(text)) {
            throw new IllegalArgumentException("Text cannot be empty");
        }
        return "Processed: " + text.toUpperCase();
    }

    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}