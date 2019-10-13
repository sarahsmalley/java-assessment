package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String grownWord = "";
		
		for (int i = 0; i < input.length(); i++) {
			grownWord += input.charAt(i);
			grownWord += input.charAt(i);
			grownWord += input.charAt(i);
		}
		
		return grownWord;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		int numberOfBerts = 0;
		int firstBert = -1;
		int secondBert = -1;
		
		for (int i = 0; i < input.length() - 3; i++) {
			if (input.substring(i, i + 4).equalsIgnoreCase("bert")) {
				numberOfBerts++;
				
				if (numberOfBerts == 1) {
					firstBert = i + 4;
				}
				if (numberOfBerts == 2) {
					secondBert = i;
				}
				
			}
		}
		
		if (numberOfBerts == 2) {
			String middleBit = input.substring(firstBert, secondBert);
			String reversedMiddle = "";
			
			for (int i = middleBit.length() - 1; i > -1; i--) {
				reversedMiddle += middleBit.charAt(i);
			}
			
			return reversedMiddle;
		} else {
			return "";
		}
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int[] numbers = new int[3];
		
		numbers[0] = a;
		
		if (b < a) {
			numbers[1] = a;
			numbers[0] = b;
		} else {
			numbers[1] = b;
		}
		
		if (c > numbers[1]) {
			numbers[2] = c;
		} else if (c > numbers[0]) {
			numbers[2] = numbers[1];
			numbers[1] = c;
		} else {
			numbers[2] = numbers[1];
			numbers[1] = numbers[0];
			numbers[0] = c;
		}
		
		if ((numbers[2] - numbers[1]) == (numbers[1] - numbers[0])) {
			return true;
		} else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		int remainingLetters = input.length() - a;
		int halfWord = remainingLetters / 2;
		
		String finalWord = "";
		
		finalWord += input.substring(0, halfWord);
		finalWord += input.substring(halfWord + a, input.length());
		
		return finalWord;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int block = 0;
		
		if (!input.equals("")) {
			block = 1;
			int currentBlock = 1;
			
			for(int i = 1; i < input.length(); i++) {
				if (input.charAt(i) == input.charAt(i - 1)) {
					currentBlock++;
				} else {
					if (currentBlock > block) {
						block = currentBlock;
					}
					currentBlock = 1;
				}
			}
			
			if (currentBlock > block) {
				block = currentBlock;
			}
		}
		
		return block;
	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	// " " NOT ""
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		int count = 0;
		
		for (int i = 0; i < arg1.length() - 1; i++) {
			if (arg1.substring(i, i + 2).equalsIgnoreCase("am")) {
				if (i == 0) {
					if (arg1.charAt(i + 2) == ' ') {
						count++;
					}
				} else if (i == arg1.length() - 2) {
					if (arg1.charAt(i - 1) == ' ') {
						count++;
					}
				} else {
					if ((arg1.charAt(i - 1) == ' ') && (arg1.charAt(i + 2) == ' ')) {
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String word ="";
		
		if (arg1 % 3 == 0) {
			word+="fizz";
		}
		if (arg1 % 5 == 0) {
			word+="buzz";
		}
		
		return word;
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest value
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		int largestValue = 0;
		
		String[] terms = arg1.split(" ");
		
		for (int i = 0; i < terms.length; i++) {
			int runningTotal = 0;
			
			for (int j = 0; j < terms[i].length(); j++) {
				int value = Character.getNumericValue(terms[i].charAt(j));
				runningTotal += value;
			}
			
			if (runningTotal > largestValue) {
				largestValue = runningTotal;
			}
		}
		
		return largestValue;
	}
}
