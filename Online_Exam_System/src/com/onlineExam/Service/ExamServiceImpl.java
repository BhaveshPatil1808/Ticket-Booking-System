package com.onlineExam.Service;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

import com.onlineExam.DAO.QuestionDAO;
import com.onlineExam.DAO.ResultDAO;
import com.onlineExam.Entity.Questions;
import com.onlineExam.Entity.Result;

public class ExamServiceImpl implements ExamService {

    private QuestionDAO questionDAO = new QuestionDAO();
    private ResultDAO resultDAO = new ResultDAO();

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void startExam(int userId) {

        try {
            List<Questions> questions = questionDAO.getAllQuestions();

            if (questions.isEmpty()) {
                System.out.println("❌ No questions available!");
                return;
            }

            int score = 0;

            System.out.println("\n===== EXAM STARTED =====");

            for (Questions q : questions) {

                // Display question
                System.out.println("\nQ: " + q.getQuestion());
                System.out.println("1. " + q.getOption1());
                System.out.println("2. " + q.getOption2());
                System.out.println("3. " + q.getOption3());
                System.out.println("4. " + q.getOption4());

                System.out.print("Enter your answer (1-4): ");
                int ans = Integer.parseInt(br.readLine());

                // Check answer
                if (ans == q.getCorrectAns()) {
                    score++;
                }
            }

            // Final Result
            System.out.println("\n===== EXAM COMPLETED =====");
            System.out.println("Your Score: " + score + "/" + questions.size());

            // Save result
            Result result = new Result(
                    0,
                    userId,
                    score,
                    questions.size(),
                    new Date(System.currentTimeMillis())
            );

            resultDAO.saveResult(result);

            System.out.println("✅ Result Saved Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}