package com.googlecodejam.sevensegmentdisplay;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SevenSegmentDisplay {
	
	public static void main(String args[]) throws Exception {
			
			File file = new File("/Users/morabiafamily/Documents/workspace1/GoogleCodeJam/src/com/googlecodejam/sevensegmentdisplay/A-small-practice.in");
			  try {
				    Scanner scanner = new Scanner(file);
				    Integer testCases = Integer.parseInt(scanner.nextLine());
		            for(int i=0; i<testCases;i++) {
		            	
		                String line = scanner.nextLine();
		                String splitString[] = line.split(" ");
		                System.out.println("Case #"+i+1+": "+ findNextString(splitString));
		            }
			  } catch (Exception e) {
				  e.printStackTrace();
			  }
	}
	
	private static String findNextString(String[] inputString) {
		String output = null;     
		List<String> numberArrayList = new ArrayList<String>(Arrays.asList("0110000","1101101","1111001","0010011","1011011","1011111","1110000","1111111","1111011"));
		Integer[] numberValue = new Integer[Integer.parseInt(inputString[0])];
		
//		for() {
//			for(int i=0; i< Integer.parseInt(inputString[0]);i++) {
//				if(numberArrayList.contains(inputString[i+1])) {
//					numberValue[i]=numberArrayList.indexOf(inputString[i+1])+1;
//				} else {
//					numberValue = new Integer[Integer.parseInt(inputString[0])];
//					break;
//				}
//			}
//		}
		int number= getNextValue(numberValue);
		if(number > 0) {
			output=numberArrayList.get(number+1);
		} else {
			return "Error!";
		}
		return output;
	}
	
	private static Integer getNextValue(Integer[] numberValue) {
		int lastValue=0;
		for(int i=0;i<=numberValue.length-1;i++) {
			if(!(numberValue[i] == (numberValue[i+1] + 1))) {
				return 0;
			}
			lastValue=numberValue[i];
		}
		return lastValue-2;
	}

}