package com.rajesh.tdd;

/**
 * Hello world!
 *
 */
public class StringCalculator 
{
	static int count=0;
	public int getCalledCount() {
		return count;
	}
	
	public int add(String input) {
		count++;
		String[] numbers;
		if(input.startsWith("//"))
			input=input.substring(2);
		
		numbers = input.split("[/|;|\n|,|*|%|[|]]+");

        if (input.isEmpty()) {
            return 0;
        } else if (numbers.length > 1) {
            return getSum(numbers);
        }
        return stringToInt(input);
    }

    private int getSum(String[] numbers) {
        int sum = 0;
        for (String currentNumber:numbers) {
            if (stringToInt(currentNumber) > 1000) {
                continue;
            }
            sum += stringToInt(currentNumber);
        }
        return sum;
    }

    private int stringToInt(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
        	count++;
            throw new IllegalArgumentException("Negatives not allowed-"+num);
        } else {
            return num;
        }
    }

}
