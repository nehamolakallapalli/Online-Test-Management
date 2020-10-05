package com.dxctraining.otms.question.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.otms.question.entities.Question;

public interface IQuestionDao extends JpaRepository<Question,Long>
{

}
