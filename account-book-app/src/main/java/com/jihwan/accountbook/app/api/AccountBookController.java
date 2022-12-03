package com.jihwan.accountbook.app.api;


import com.jihwan.accountbook.app.message.ApiResponse;
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
