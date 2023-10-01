package com.PollSystem.controller;

import com.PollSystem.model.PollQuestion;
import com.PollSystem.service.PollQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pollQuestion")
public class PollQuestionController {

    @Autowired
    PollQuestionService pollQuestionService;


    @PostMapping("/create")
    public ResponseEntity<String> createPollQuestion(@RequestBody PollQuestion pollQuestion){
        pollQuestionService.createPollQuestion(pollQuestion);
        return ResponseEntity.ok("poll question created successfully");
    }

    @PutMapping("/update")
    public void updatePollQuestion(PollQuestion pollQuestion){
        pollQuestionService.updatePollQuestion(pollQuestion);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePollQuestionById(@PathVariable Long id){
        pollQuestionService.deletePollQuestionById(id);
    }

    @GetMapping("/getPollQuestion/{questionId}")
    public PollQuestion getPollQuestion(@PathVariable Long questionId){
        return pollQuestionService.getPollQuestion(questionId);
    }

    @GetMapping("/question/{questionId}/answerCount")
    public ResponseEntity<Integer> countHowManyUserAnsweredByQuestionId(@PathVariable Long questionId) {
        int answerCount = pollQuestionService.countHowManyUserAnsweredByQuestionId(questionId);
        return ResponseEntity.ok(answerCount);
    }
}
