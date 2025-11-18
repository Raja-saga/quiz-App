package com.raja.quiz_service.dao;

import com.raja.quiz_service.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
