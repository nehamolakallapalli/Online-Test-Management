package com.dxctraining.otms.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.otms.question.dao.*;
import com.dxctraining.otms.question.entities.Question;
import com.dxctraining.otms.question.exceptions.*;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class QuestionServiceImpl implements IQuestionService
{
	@Autowired
	private IQuestionDao dao;
	
	@Override
	public Question findQuestionById(long questionId) {
		Optional<Question> optional= dao.findById(questionId);
		boolean exist = optional.isPresent();
		if(!exist) 
		{
			throw new QuestionNotFoundException("The question id "+questionId+ "is Not Found"); 
		}
		Question question=optional.get();
		return question;
	}
	
	@Override
	public Question addQuestion(Question question) {
		System.out.println(question);
		validate(question);
		question = dao.save(question);
		return question;
	}
	private void validate(Question question) {
		if(question == null) {
			throw new InvalidArgumentException("Question Already Exists");
		}
	}
	
	@Override
	public void deleteQuestion(long questionId) {
		findQuestionById(questionId);
		dao.deleteById(questionId);
		
	}
	
	@Override
	public Question updateQuestion(Question question) {
		dao.save(question);
		return question;
	}
	
	@Override
	public List<Question> listOfQuestions() {
		List<Question> listOfQuestions= dao.findAll();
		return listOfQuestions;
	}
}
