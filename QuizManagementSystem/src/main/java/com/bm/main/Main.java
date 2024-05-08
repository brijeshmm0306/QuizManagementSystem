package com.bm.main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.bm.exception.AdminAlreadyExistsException;

import com.bm.exception.EmptyQuestionException;

import com.bm.exception.UserAlreadyExistsException;

import com.bm.model.QuestionLibrary;
import com.bm.model.QuizLibrary;
import com.bm.service.AdminServiceImpl;

import com.bm.service.QuestionsServiceImpl;
import com.bm.service.QuizServiceImpl;
import com.bm.service.UserServiceImpl;

public class Main {

	private static boolean isAdminRegistered = false;

	private static boolean isUserRegistered = false;

	private static Scanner sc = new Scanner(System.in);

	private static AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

	private static UserServiceImpl userServiceImpl = new UserServiceImpl();

	private static QuestionsServiceImpl questionsServiceImpl = new QuestionsServiceImpl();

	private static QuizServiceImpl quizServiceImpl = new QuizServiceImpl();

	public static void main(String[] args) throws UserAlreadyExistsException, AdminAlreadyExistsException,EmptyQuestionException {
		displayMainMenu();
	}

	private static void displayMainMenu()
			throws UserAlreadyExistsException, AdminAlreadyExistsException, EmptyQuestionException {

		while (true) {
			System.out.println("1. Admin");

			System.out.println("2. User");

			System.out.println("3. Exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				adminMenu();

				break;

			case 2:
				userMenu();

				break;

			case 3:
				System.out.println("Exiting...");

				sc.close();

				System.exit(0);

				break;

			default:

				System.out.println("Invalid choice. Please enter 1, 2, or 3.");

				break;
			}
		}
	}

//	private static void adminMenu() throws UserAlreadyExistsException, AdminAlreadyExistsException,
//	EmptyQuestionException, EmptyOptionsException 

	private static void adminMenu() throws AdminAlreadyExistsException {
		while (true) {
			System.out.println("Enter your choice: ");

			System.out.println("1. SignUp");

			System.out.println("2. LogIn");

			System.out.println("3. Go To Question Library");

			System.out.println("4. Create a quiz");

			System.out.println("5. Go back");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				adminSignUp();

				break;

			case 2:

				adminLogin();

				break;

			case 3:

				if (!isAdminRegistered) {
					System.out.println("Please log in to go to the Question Library.");

					break;
				}

				
					questionLibraryMenu();
				

				break;

			case 4:
				if (!isAdminRegistered) {
					System.out.println("Please log in to create the Quiz Library.");

					break;
				}
				quizLibraryMenu();

				break;

			case 5:

				return;
			default:

				System.out.println("Invalid choice. Please enter a number between 1 and 5.");

				break;
			}
		}
	}

	private static void userMenu() {
		while (true) {
			System.out.println("Enter your choice: ");

			System.out.println("1. SignUp");

			System.out.println("2. LogIn");

			System.out.println("3. Attempt Quiz");

			System.out.println("4. Go back");

			int choice3 = sc.nextInt();

			switch (choice3) {
			case 1:

				try {
					userSignUp();
				} catch (UserAlreadyExistsException e) {
					e.printStackTrace();
				}

				break;

			case 2:
				userLogin();

				break;

			case 3:

				if (!isUserRegistered) {
					System.out.println("Please log in to create the Quiz Library.");

					break;
				}
				displayQuiz();

				break;

			case 4:
				return;

			default:

				System.out.println("Invalid choice. Please enter a number between 1 and 4.");

				break;

			}
		}
	}

	private static void displayQuiz() {
		List<QuizLibrary> allQuizzes = quizServiceImpl.getAllQuiz();

		System.out.println("Available quizzes:");

		for (int i = 0; i < allQuizzes.size(); i++) {
			System.out.println((i + 1) + ". " + allQuizzes.get(i).getQuizTitle());
		}

		System.out.println("Enter number of the quiz you would like to take:");

		int quizNumber = sc.nextInt();

		int totalScore = 0;

		if (quizNumber > 0 && quizNumber <= allQuizzes.size()) {
			QuizLibrary chosenQuiz = allQuizzes.get(quizNumber - 1);

			for (QuestionLibrary question : chosenQuiz.getQuestions()) {
				System.out.println(question.getQuestion());

				System.out.println(Arrays.toString(question.getOptions()));

				System.out.println("Enter the option number of your answer: ");

				int userAnswer = sc.nextInt();

				if (userAnswer == question.getCorrectAnswer()) {
					System.out.println("Correct");
				}

				else {
					System.out.println("Wrong");

					System.out.println(" The correct answer was: " + question.getCorrectAnswer());
				}

				if (userAnswer == question.getCorrectAnswer()) {
					totalScore = totalScore + question.getMarks();
				}

				System.out.println("Your total score is: " + totalScore);

			}

		} else {
			System.out.println("Invalid choice. Please enter a valid quiz number.");
		}
	}

	private static void userLogin() {

		System.out.println("Enter username: ");

		String username = sc.next();

		System.out.println("Enter password: ");

		String password = sc.next();

		if (userServiceImpl.userLoginIn(username, password)) {
			isUserRegistered = true;
		} else {
			System.out.println("Incorrect username or password");
		}

	}

	private static void userSignUp() throws UserAlreadyExistsException {

		System.out.println("Enter username: ");

		String username = sc.next();

		System.out.println("Enter password: ");

		String password = sc.next();

		userServiceImpl.userSignUp(username, password);

	}

	private static void adminSignUp() {

		System.out.println("Enter username: ");

		String username = sc.next();

		System.out.println("Enter password: ");

		String password = sc.next();

		adminServiceImpl.adminSignUp(username, password);
	}

	private static void adminLogin() {

		System.out.println("Enter username: ");

		String username = sc.next();

		System.out.println("Enter password: ");

		String password = sc.next();

		if (adminServiceImpl.adminLoginIn(username, password)) {
			isAdminRegistered = true;
		} else {
			System.out.println("Incorrect username or password");
		}
	}

	private static void questionLibraryMenu()  {
		while (true) {

			System.out.println("Question Library Menu:");

			System.out.println("1. Add Question");

			System.out.println("2. Delete Question");

			System.out.println("3. Update Question");

			System.out.println("4. See All Questions");

			System.out.println("5. Go back");

			System.out.println("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				addQuestion();

				break;
			case 2:

				deleteQuestion();

				break;
			case 3:

				updateQuestion();

				break;
			case 4:
				displayAllQuestions();

				break;
			case 5:

				return;
			default:

				System.out.println("Invalid choice. Please enter a number between 1 and 5.");

				break;
			}
		}
	}

	private static void addQuestion() {
		QuestionLibrary newQuestion = new QuestionLibrary();

		sc.nextLine();

		System.out.println("Enter the question: ");

		String questionText = sc.nextLine();

		newQuestion.setQuestion(questionText);

		System.out.println("Enter option 1:");

		String option1 = sc.nextLine();

		System.out.println("Enter option 2:");

		String option2 = sc.nextLine();

		System.out.println("Enter option 3:");

		String option3 = sc.nextLine();

		System.out.println("Enter option 4:");

		String option4 = sc.nextLine();

		String[] options = { option1, option2, option3, option4 };

		newQuestion.setOptions(options);

		System.out.println("Which option number is the correct answer?");

		int correctOption = sc.nextInt();

		newQuestion.setCorrectAnswer(correctOption);

		sc.nextLine();

		System.out.println("Enter difficulty level");

		String difficultyLevel = sc.nextLine();

		newQuestion.setDifficultyLevel(difficultyLevel);

		System.out.println("Enter the topic tag: ");

		String topicTag = sc.nextLine();

		newQuestion.setTopicTag(topicTag);

		questionsServiceImpl.addQuestion(newQuestion);

		System.out.println("Enter the marks for the question:");

		int marks = sc.nextInt();

		newQuestion.setMarks(marks);

		System.out.println("Question added successfully!");

	}

	private static void deleteQuestion() {
		System.out.println("Enter the ID of the question you want to delete:");

		int id = sc.nextInt();

		questionsServiceImpl.deleteQuestion(id);
	}

	private static void updateQuestion() {

	}

	private static void displayAllQuestions() {
		List<QuestionLibrary> allQuestions = questionsServiceImpl.seeAllQuestions();

		for (QuestionLibrary qq : allQuestions) {
			System.out.println(qq.toString());
		}
	}

	private static void quizLibraryMenu() {

		while (true) {
			System.out.println("Quiz Library Menu");

			System.out.println("1. Create a quiz");

			System.out.println("2. See all quiz");

			System.out.println("3. Update quiz");

			System.out.println("4. Delete quiz");

			System.out.println("5. Back");

			System.out.println("Enter your choice: ");

			int choice1 = sc.nextInt();

			switch (choice1) {
			case 1:
				createQuiz();

				break;

			case 2:
				seeAllQuiz();

				break;

			case 3:
				updateQuiz(quizServiceImpl);
				break;

			case 4:
				deleteQuiz();
				break;

			case 5:
				return;
			}
		}

	}

	private static void deleteQuiz() {

		System.out.println("Enter the ID of the Quiz you want to delete:");
		int quizId = sc.nextInt();

		quizServiceImpl.deleteQuiz(quizId);

		System.out.println("Quiz deleted successfully");

	}

	public static void updateQuiz(QuizServiceImpl quizServiceImpl) {

		System.out.print("Enter the ID of the Quiz you want to update: ");
		int quizId = sc.nextInt();

		System.out.print("Enter the new Quiz title: ");
		String newTitle = sc.next();

		quizServiceImpl.updateQuiz(quizId, newTitle);

		System.out.println("Quiz updated successfully.");
	}

	private static void seeAllQuiz() {
		List<QuizLibrary> allQuiz = quizServiceImpl.getAllQuiz();

		for (QuizLibrary qq1 : allQuiz) {
			System.out.println(qq1.toString());
		}
	}

	private static void createQuiz() {
		System.out.println("Enter quiz ID:");

		int id = sc.nextInt();

		System.out.println("Enter quiz title:");

		sc.nextLine();

		String title = sc.nextLine();

		QuizLibrary quiz = new QuizLibrary();

		quiz.setQuizId(id);

		quiz.setQuizTitle(title);

		System.out.println("Do you want to add all questions from the library to the quiz? (yes/no): ");

		String adminResponse = sc.next();

		if ("yes".equalsIgnoreCase(adminResponse)) {

			List<QuestionLibrary> allQuestions = questionsServiceImpl.seeAllQuestions();

			for (QuestionLibrary question : allQuestions) {
				quiz.addQuestion(question);
			}

			System.out.println("All questions from library have been added to the quiz.");
		}

		else {
			System.out.println("Not adding questions to the quiz.");
		}

		quizServiceImpl.saveQuiz(quiz);

		System.out.println("Quiz created successfully!");
	}

}
