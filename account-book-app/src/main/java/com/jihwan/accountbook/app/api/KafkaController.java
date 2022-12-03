package com.jihwan.accountbook.app.api;


import com.jihwan.accountbook.app.message.ApiResponse;
import com.jihwan.accountbook.service.kafka.KafkaPublishDto;
import com.jihwan.accountbook.service.kafka.KafkaPublishService;
import com.jihwan.accountbook.service.kafka.KafkaPublishTopic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaPublishService kafkaPublishService;

    @PostMapping(value = "/kafka/publish/test/sync")
    @ResponseBody
    public ApiResponse publishSync(@RequestParam String key, @RequestParam String value) {
        kafkaPublishService.send(KafkaPublishTopic.ACCOUNT_BOOK_TRANSACTION_LOG,
                KafkaPublishDto.builder().key(key).value(value).build(), true);
        return ApiResponse.success();
    }

    @PostMapping(value = "/kafka/publish/test/async")
    @ResponseBody
    public ApiResponse publishAsync(@RequestParam String key, @RequestParam String value) {
        kafkaPublishService.send(KafkaPublishTopic.ACCOUNT_BOOK_TRANSACTION_LOG,
                KafkaPublishDto.builder().key(key).value(value).build(), false);
        return ApiResponse.success();
    }

}
