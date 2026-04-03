package com.onlineExam.Utility;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.onlineExam.Entity.Questions;
import com.onlineExam.Entity.Result;
import com.onlineExam.Entity.Users;
import com.onlineExam.Service.*;

public class Utility {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static UserService userService = new UserServiceImpl();
    static QuestionService questionService = new QuestionServiceImpl();
    static ResultService resultService = new ResultServiceImpl();
    static ExamService examService = new ExamServiceImpl();

    public  void menu() {

        while (true) {
            try {
                System.out.println("\n===== ONLINE EXAM SYSTEM =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.out.println("Thank you!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 🔐 REGISTER
    static void register() throws Exception {
        System.out.print("Enter Username: ");
        String username = br.readLine();

        System.out.print("Enter Password: ");
        String password = br.readLine();

        System.out.print("Enter Role (ADMIN/TEACHER/STUDENT): ");
        String role = br.readLine().toUpperCase();

        Users user = new Users(0, username, password, role);

        boolean status = userService.register(user);

        if (status) {
            System.out.println("✅ Registered Successfully!");
        } else {
            System.out.println("❌ Registration Failed!");
        }
    }

    // 🔐 LOGIN
    static void login() throws Exception {
        System.out.print("Enter Username: ");
        String username = br.readLine();

        System.out.print("Enter Password: ");
        String password = br.readLine();

        Users user = userService.login(username, password);

        if (user == null) {
            System.out.println("❌ Invalid Credentials!");
            return;
        }

        System.out.println("✅ Login Successful! Role: " + user.getRole());

        switch (user.getRole()) {
            case "ADMIN":
                adminMenu();
                break;
            case "TEACHER":
                teacherMenu();
                break;
            case "STUDENT":
                studentMenu(user.getId());
                break;
        }
    }

    // 👨‍💻 ADMIN MENU
    static void adminMenu() throws Exception {
        while (true) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. View All Questions");
            System.out.println("2. View All Results");
            System.out.println("3. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    List<Questions> qList = questionService.getAllQuestions();
                    for (Questions q : qList) {
                        q.displayFull();
                    }
                    break;

                case 2:
                    List<Result> rList = resultService.getAllResults();
                    for (Result r : rList) {
                        r.display();
                    }
                    break;

                case 3:
                    return;
            }
        }
    }

    // 👨‍🏫 TEACHER MENU
    static void teacherMenu() throws Exception {
        while (true) {
            System.out.println("\n===== TEACHER MENU =====");
            System.out.println("1. Add Question");
            System.out.println("2. View All Questions");
            System.out.println("3. View Results");
            System.out.println("4. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    addQuestion();
                    break;

                case 2:
                    List<Questions> list = questionService.getAllQuestions();
                    for (Questions q : list) {
                        q.displayFull();
                    }
                    break;

                case 3:
                    List<Result> results = resultService.getAllResults();
                    for (Result r : results) {
                        r.display();
                    }
                    break;

                case 4:
                    return;
            }
        }
    }

    // ➕ ADD QUESTION
    static void addQuestion() throws Exception {

        System.out.print("Enter Question: ");
        String ques = br.readLine();

        System.out.print("Option 1: ");
        String op1 = br.readLine();

        System.out.print("Option 2: ");
        String op2 = br.readLine();

        System.out.print("Option 3: ");
        String op3 = br.readLine();

        System.out.print("Option 4: ");
        String op4 = br.readLine();

        System.out.print("Correct Option (1-4): ");
        int correct = Integer.parseInt(br.readLine());

        Questions q = new Questions(0, ques, op1, op2, op3, op4, correct);

        boolean status = questionService.addQuestion(q);

        if (status) {
            System.out.println("✅ Question Added!");
        } else {
            System.out.println("❌ Failed!");
        }
    }

    // 👤 STUDENT MENU
    static void studentMenu(int userId) throws Exception {
        while (true) {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Take Exam");
            System.out.println("2. View My Results");
            System.out.println("3. Logout");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    examService.startExam(userId);
                    break;

                case 2:
                    List<Result> list = resultService.getResultsByUserId(userId);
                    for (Result r : list) {
                        r.display();
                    }
                    break;

                case 3:
                    return;
            }
        }
    }
}
