package com.PollSystem.controller;

import com.PollSystem.model.UserAnswer;
import com.PollSystem.model.UserAnswerRequest;
import com.PollSystem.model.UserAnswerResponse;
import com.PollSystem.service.UserAnswerService;
import com.PollSystem.userProject.UserProjectResponse;
import com.PollSystem.userProject.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userAnswer")
public class UserAnswerController {

    @Autowired
    UserAnswerService userAnswerService;
    @Autowired
    UserProjectService userProjectService;

    @PostMapping("/create")
    public ResponseEntity<?> createUserAnswer(@RequestBody UserAnswerRequest userAnswerRequest ){
       return userAnswerService.createUserAnswer(userAnswerRequest);
    }

    @PutMapping("/update")
    public void updateUserAnswer(@RequestBody UserAnswer userAnswer){
        userAnswerService.updateUserAnswer(userAnswer);
    }

    @DeleteMapping("/delete")
    public void deleteUserAnswerById(@PathVariable Long id){
        userAnswerService.deleteUserAnswerById(id);
    }

    @GetMapping("/{answerId}")
    public UserAnswer getUserAnswerById(@PathVariable Long answerId){
        return userAnswerService.getUserAnswerById(answerId);
    }

    @GetMapping("/all/{userId}")
    public List<UserAnswer> getAllUserAnswersByUserId(@PathVariable Long userId){
        return userAnswerService.getAllUserAnswersByUserId(userId);
    }

    @GetMapping("/getUser/{userId}")
    public UserProjectResponse getUser(@PathVariable Long userId) {
        return userProjectService.getUser(userId);
    }

    @GetMapping("/checkRegistration/{userId}")
    public Boolean checkUserRegistration(@PathVariable Long userId) {
        return userProjectService.checkUserRegistration(userId);
    }
}
