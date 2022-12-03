package com.jihwan.accountbook.api;


import com.jihwan.accountbook.message.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AccountBookController {

    @PostMapping(value = "/test")
    @ResponseBody
    public ApiResponse test() {
        return ApiResponse.success();
    }

}
