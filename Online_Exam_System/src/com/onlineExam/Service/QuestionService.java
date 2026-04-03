package com.onlineExam.Service;

import java.util.List;

import com.onlineExam.Entity.Questions;

public interface QuestionService {

	boolean addQuestion(Questions question);

    List<Questions> getAllQuestions();
}
