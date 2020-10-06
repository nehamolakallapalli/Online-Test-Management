package com.dxctraining.otms.question.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dxctraining.otms.question.service.*;
import com.dxctraining.otms.question.entities.Question;
import com.dxctraining.otms.question.dto.*;
import com.dxctraining.otms.question.util.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/questions")
public class QuestionController 
{
	@Autowired
	private IQuestionService questionService;
	
	@Autowired
	private QuestionUtil questionUtil;
	
	@GetMapping("/getquestion/{questionId}")
	@ResponseStatus(HttpStatus.OK)
	public QuestionDto findQuestionById(@PathVariable("questionId") long questionId) 
	{
		Question question = questionService.findQuestionById(questionId);
		QuestionDto response = questionUtil.questionDto(question);
		return response;
	}
	
	@PostMapping("/addquestion")
	@ResponseStatus(HttpStatus.CREATED)
	public QuestionDto addQuestion(@RequestBody CreateQuestionRequest requestData) {
		Question question=new Question(requestData.getQuestionId(),
				requestData.getQuestionOptions(),requestData.getQuestionTitle(),
				requestData.getQuestionAnswer(),requestData.getQuestionMarks(),
				requestData.getChosenAnswer(),requestData.getMarksScored());
		question = questionService.addQuestion(question);
		QuestionDto response = questionUtil.questionDto(question);
		return response;
	}
	@PutMapping("/updatequestion")
	@ResponseStatus(HttpStatus.OK)
	public QuestionDto updateQuestion(@RequestBody UpdateQuestionRequest requestData)
	{
		Question question=new Question(requestData.getQuestionId(),
				requestData.getQuestionOptions(),requestData.getQuestionTitle(),
				requestData.getQuestionAnswer(),requestData.getQuestionMarks(),
				requestData.getChosenAnswer(),requestData.getMarksScored());
				question = questionService.updateQuestion(question);
				QuestionDto response = questionUtil.questionDto(question);
				return response;
	}
	
	@DeleteMapping("/deletequestion/{questionId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteQuestion(@PathVariable("questionId") long questionId) 
	{
		questionService.deleteQuestion(questionId);
		
	}
	
	@GetMapping("/allQuestions")
	@ResponseStatus(HttpStatus.OK)
	public List<QuestionDto> fetchAll(){
		List<Question>list=questionService.listOfQuestions();
		List<QuestionDto> response=new ArrayList<>();
		for(Question question:list) {
			QuestionDto dto=questionUtil.questionDto(question);
			response.add(dto);
		}
		return response;
	}
}
