import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double userInputAnswer = 0.0;
		int problemChoice = 0;
		
		
		System.out.println(
			"Choose problem type:" + "\n" +  
			"1. Basic Algebra Problem" + "\n"
				);
		
		problemChoice = scanner.nextInt();
		// TODO error handling
		
		
		
		switch(problemChoice){
			case 1: {
				int difficultyChoice = 0;
				
				System.out.println("Choose diffculty level (1 to 5): ");
				
				difficultyChoice = scanner.nextInt();
				// TODO error handling
				
				BasicAlgebraProblem problem = new BasicAlgebraProblem(difficultyChoice);
				
				System.out.println("Find x:" + "\n");
				System.out.printf("%dx + %d = %d\n", problem.getMultiplicationFactor(), problem.getAddOrSubFactor(), problem.getSolutionInt());
				System.out.println("x = ");
				
				userInputAnswer = scanner.nextDouble();
				
				problem.setCorrect((int) userInputAnswer == problem.getAnswer());
				
				System.out.printf(
					"Your answer: %f" + "\n" + 
					"Correct answer: %f",
					
						userInputAnswer, problem.getAnswer());
				
				break;
			}
			default: {
				break;
			}
		}
	}
}
