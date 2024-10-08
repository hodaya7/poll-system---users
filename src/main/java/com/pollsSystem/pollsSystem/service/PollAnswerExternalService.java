package com.pollsSystem.pollsSystem.service;

import com.pollsSystem.pollsSystem.model.PollAnswerFromPollAnswerService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "PollAnswerExternalService",
        url = "${pollAnswerExternalService.url}"
)
public interface PollAnswerExternalService {
    @GetMapping("/pollAnswer/all/{userId}")
     List<PollAnswerFromPollAnswerService> getPollAnswersByUserId(@PathVariable Long userId);

    @DeleteMapping("/pollAnswer/delete/{answerNumber}")
    void deletePollAnswerById(@PathVariable Long answerNumber);
}
