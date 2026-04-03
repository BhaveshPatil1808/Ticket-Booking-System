package com.onlineExam.Service;

import java.util.List;

import com.onlineExam.Entity.Result;

public interface ResultService {

	boolean saveResult(Result result);

    List<Result> getAllResults();

    List<Result> getResultsByUserId(int userId);
}
