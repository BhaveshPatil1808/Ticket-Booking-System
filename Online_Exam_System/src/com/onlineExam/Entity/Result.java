package com.onlineExam.Entity;

import java.sql.Date;

public class Result {

	private int id;
    private int userId;
    private int score;
    private int totalQuestions;
    private Date examDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public Result(int id, int userId, int score, int totalQuestions, Date examDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.score = score;
		this.totalQuestions = totalQuestions;
		this.examDate = examDate;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public void display() {
        System.out.println("User ID: " + userId +
                " Score: " + score + "/" + totalQuestions +
                " Date: " + examDate);
    }
    
}
