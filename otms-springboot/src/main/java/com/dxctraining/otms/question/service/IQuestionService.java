package com.dxctraining.otms.question.service;

import com.dxctraining.otms.question.entities.Question;
import java.util.List;

public interface IQuestionService 
{
	Question findQuestionById(long questionId);
	Question addQuestion(Question question);
	Question updateQuestion(Question question);
	void deleteQuestion(long questionId);
	List<Question> listOfQuestions();
	
}
