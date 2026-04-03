package com.onlineExam.Service;

import java.util.List;

import com.onlineExam.DAO.ResultDAO;
import com.onlineExam.Entity.Result;

public class ResultServiceImpl implements ResultService{

	private ResultDAO rDao = new ResultDAO();
	
	@Override
	public boolean saveResult(Result result) {
		// TODO Auto-generated method stub
		return rDao.saveResult(result);
	}

	@Override
	public List<Result> getAllResults() {
		// TODO Auto-generated method stub
		return rDao.getAllResults();
	}

	@Override
	public List<Result> getResultsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
