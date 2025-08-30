package com.github.ciotobe.mainapplication.controller;

import com.github.ciotobe.common.CommonResponse;
import com.github.ciotobe.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    private final CommonService commonService;

    @Autowired
    public MainController(CommonService commonService) {
        this.commonService = commonService;
    }

    @PostMapping("/process")
    public CommonResponse<String> processText(@RequestParam String text) {
        try {
            String result = commonService.processText(text);
            return CommonResponse.success(result);
        } catch (IllegalArgumentException e) {
            return CommonResponse.error(e.getMessage());
        }
    }

    @GetMapping("/validate-email")
    public CommonResponse<Boolean> validateEmail(@RequestParam String email) {
        boolean isValid = commonService.isValidEmail(email);
        return CommonResponse.success(isValid);
    }
}
