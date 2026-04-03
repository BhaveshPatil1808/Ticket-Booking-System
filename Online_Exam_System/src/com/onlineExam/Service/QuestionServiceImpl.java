package com.onlineExam.Service;

import java.util.List;

import com.onlineExam.DAO.QuestionDAO;
import com.onlineExam.Entity.Questions;

public class QuestionServiceImpl implements QuestionService{

	private QuestionDAO dao = new QuestionDAO();
	@Override
	public boolean addQuestion(Questions question) {
		
		return dao.addQuestion(question);
	}

	@Override
	public List<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		return dao.getAllQuestions();
	}

}
