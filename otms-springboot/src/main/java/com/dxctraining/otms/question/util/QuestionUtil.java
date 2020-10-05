package com.dxctraining.otms.question.util;

import org.springframework.stereotype.Component;

import com.dxctraining.otms.question.entities.Question;
import com.dxctraining.otms.question.dto.*;

@Component
public class QuestionUtil 
{
	public QuestionDto questionDto(Question question) {
		QuestionDto dto = new QuestionDto(question.getQuestionId(),
				question.getQuestionOptions(),question.getQuestionTitle(),
				question.getQuestionAnswer(),question.getQuestionMarks(),
				question.getChosenAnswer(),question.getMarksScored());
		return dto;
	}
}
