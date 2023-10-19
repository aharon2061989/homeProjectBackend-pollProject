package com.PollSystem.controller;

import com.PollSystem.model.AnswerOption;
import com.PollSystem.service.AnswerOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer-options")
public class AnswerOptionController {
    @Autowired
    AnswerOptionService answerOptionService;

    @PostMapping("/create")
    public ResponseEntity<String> createAnswerOption(@RequestBody AnswerOption answerOption, @RequestParam Long questionId) {
        answerOptionService.createAnswerOption(answerOption, questionId);
        return ResponseEntity.ok("Answer option created successfully.");
    }

    @DeleteMapping("/delete")
    public void deleteAnswerOption(Long id){
        answerOptionService.deleteAnswerOption(id);
    }

    @GetMapping("/getAnswerOptions/{questionId}")
    public ResponseEntity<AnswerOption> getAnswerOptionsById(@PathVariable Long questionId) {
        AnswerOption answerOption = answerOptionService.getAnswerOptionsByQuestionId(questionId);
        if (answerOption != null) {
            return ResponseEntity.ok(answerOption);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}