package com.dxctraining.otms.question.dto;

import java.util.List;

public class QuestionDto 
{
	private long questionId;
	private List<String> questionOptions;
	private String questionTitle;
	private int questionAnswer;
	private double questionMarks=0.0;
	private int chosenAnswer;
	private double marksScored=0.0;
	
	public QuestionDto()
	{
		
	}
	public QuestionDto(long questionId, List<String> questionOptions,String questionTitle, int questionAnswer,
			double questionMarks, int chosenAnswer, double marksScored) 
	{
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public List<String> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<String> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public int getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public double getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(double questionMarks) {
		this.questionMarks = questionMarks;
	}

	public int getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public double getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}
	
}
