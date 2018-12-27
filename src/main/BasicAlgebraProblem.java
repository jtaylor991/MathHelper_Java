package main;

import java.util.Random;

public class BasicAlgebraProblem extends main.Problem {
	
	/*
	 * Example problem: 4x - 5 = 15
	 * multiplicationFactor = 4
	 * addOrSubFactor = 5
	 * solutionInt = 15
	 * answerInt = x
	 */
	
	private int min;
	private int max;
	private int multiplicationFactor;
	private int addOrSubFactor;
	private boolean includeNegatives;
	private int solutionInt;
	
	public BasicAlgebraProblem(int difficulty){
		if(difficulty == 1){
			this.includeNegatives = false; // whether min and max integers can be negative or not in the problem
			this.min = 1;
			this.max = 5;
		}
		if(difficulty == 2){
			this.includeNegatives = true;
			this.min = 5;
			this.max = 15;
		}
		if(difficulty == 3){
			this.includeNegatives = true;
			this.min = 10;
			this.max = 30;
		}
		if(difficulty == 4){
			this.includeNegatives = true;
			this.min = 25;
			this.max = 75;
		}
		if(difficulty == 5){
			this.includeNegatives = true;
			this.min = 50;
			this.max = 150;
		}
		if((difficulty < 1) || (difficulty > 5)){
			throw new IllegalArgumentException("Invalid difficulty level for BasicAlgebraProblem");
		}
		
		this.multiplicationFactor = randInt(min, max, includeNegatives);
		this.multiplicationFactor = randInt(min, max, includeNegatives);
		this.addOrSubFactor = randInt(min, max, includeNegatives);
		this.solutionInt = randInt(min, max, includeNegatives);
		this.answer = ((solutionInt - addOrSubFactor) / multiplicationFactor);
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public boolean isIncludeNegatives() {
		return includeNegatives;
	}

	public void setIncludeNegatives(boolean includeNegatives) {
		this.includeNegatives = includeNegatives;
	}

	public int getSolutionInt() {
		return solutionInt;
	}

	public void setSolutionInt(int solutionInt) {
		this.solutionInt = solutionInt;
	}

	public int getMultiplicationFactor() {
		return multiplicationFactor;
	}

	public void setMultiplicationFactor(int multiplicationFactor) {
		this.multiplicationFactor = multiplicationFactor;
	}

	public int getAddOrSubFactor() {
		return addOrSubFactor;
	}

	public void setAddOrSubFactor(int addOrSubFactor) {
		this.addOrSubFactor = addOrSubFactor;
	}

	public boolean isIncludeNegativesInRandInts() {
		return includeNegatives;
	}

	public void setIncludeNegativesInRandInts(boolean includeNegatives) {
		this.includeNegatives = includeNegatives;
	}

	private Boolean coinFlip()
	{
		Random rand = new Random(); // instance of Random

		// if "heads"
		if(rand.nextInt(2) == 1)
		{
			return true;
		}
		// if "tails"
		else
		{
			return false;
		}
	}
	
	private Integer randInt(int min, int max, boolean includeNegatives) {
		Random rand = new Random(); // instance of Random
		
        try
        {
        	if(min >= max)
        	{
        		throw new IllegalArgumentException(String.format("Could not generate randInt: min must be smaller than max.\nmin: %d\nmax: %d", min, max));
        	}
        	else if ((min < 0) | (max < 0))
        	{
				throw new IllegalArgumentException(String.format("Could not generate randInt: min and max must be greater than 0.\nmin: %d\nmax: %d", min, max));
			}
        	
        	int random = (rand.nextInt((max - min) + 1) + min);
        	// method nextInt of java.util.Random returns a random integer between 0 and the argument n (excluding n)
            // here, the argument being passed is the difference between the top and bottom of the range (+1 to include the top value)
            // and the bottom of the range is added to that value, returning a value between 0 plus the bottom of the range (i.e. the bottom of the range obviously)
            // and a value no larger than the difference between the top and bottom values of the range, which gets added to the bottom/min value, 
            // always returning a value within the specified range
			// for example: rand.nextInt((10 - 5) + 1) + 5) = 11

			// randomly choose if the random integer returned will be negative
			// but ONLY if negatives are set to be included and the coin flip returns true
			if (includeNegatives & coinFlip())
			{
				return (-1 * random);
			}
        	else
        	{
                return random;
        	}
        }
        catch(Exception e)
        {
            System.out.printf("Could not generate randInt\n%s", e);
            // TODO proper error logger

			return (Integer) null;
        }
	}
}
