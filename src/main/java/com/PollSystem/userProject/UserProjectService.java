package com.PollSystem.userProject;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "UserProjectService",
        url = "${UserProjectService.url}"
)
public interface UserProjectService {
    @GetMapping("/user/getUser/{userId}")
    public UserProjectResponse getUser(@PathVariable Long userId);

    @GetMapping("/user/checkRegistration/{userId}")
    public Boolean checkUserRegistration(@PathVariable Long userId);
}
