package com.googlecodejam.readphonenumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PhoneNumberReader {
	
	public static void main(String args[]) throws Exception {
		
		File file = new File("/Users/morabiafamily/Documents/workspace1/GoogleCodeJam/src/com/googlecodejam/A-small-practice.in");
		  try {
			    Scanner scanner = new Scanner(file);
			    Integer testCases = Integer.parseInt(scanner.nextLine());
	            for(int i=0; i<testCases;i++) {
	                String line = scanner.nextLine();
	                String splitString[] = line.split(" ");
	                String formatCode[] = splitString[1].split("-");
	                Integer formatCodeInt[] = convertToIntegerArray(formatCode);
	                System.out.println("Case #"+(i+1)+": "+speakNumber(splitString[0],formatCodeInt).trim());
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	}
	
	private static Integer[] convertToIntegerArray(String[] formatCode) {
		Integer[] returnVal = new Integer[formatCode.length];
		for(int i=0;i<formatCode.length; i++) {
			returnVal[i] = Integer.parseInt(formatCode[i]);
		}
		return returnVal;
	}
	
	public static Integer[] toCharacterArrayToInt( String s ) {

		   if ( s == null ) {
		     return null;
		   }

		   int len = s.length();
		   Integer[] array = new Integer[len];
		   for (int i = 0; i < len ; i++) {
		      array[i] = Integer.parseInt(""+s.charAt(i));
		   }
		   return array;
		}

	public static String speakNumber(String number, Integer[] formatCodeInt) {
		int currentStartPosition = 0;
		String finalPrint="";
		for(int codeForm: formatCodeInt) {
			String eachDiv = number.substring(currentStartPosition, currentStartPosition+codeForm);
			currentStartPosition = currentStartPosition+codeForm;
			Integer[] eachNumber = toCharacterArrayToInt(eachDiv);
			finalPrint = finalPrint+ convertNumberToString(eachNumber);
		}
		return finalPrint;
	}

	private static String convertNumberToString(Integer[] eachNumber) {
		String returnVal="";
		int repeatCounter=0;
		Integer currentDigit = null;
		for(int i=0; i< eachNumber.length; i++) {
			currentDigit = eachNumber[i];
			if(i == eachNumber.length-1) {
				returnVal = returnVal + speakEachNumber(repeatCounter, currentDigit);
			} else {
				if(eachNumber[i] == eachNumber[i+1]) {
					repeatCounter++;
				} else {
					returnVal = returnVal + speakEachNumber(repeatCounter, currentDigit);
					repeatCounter=0;
				}
			}
		}
		return returnVal;
	}
	
	private static String speakEachNumber(int repeatCounter, Integer number) {
		String [] digit = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		String [] repeat = {null,"double","triple","quadruple","quintuple","sextuple","septuple","octuple","nonuple","decuple"};

		if(repeatCounter==0) {
			return digit[number]+" ";
		} if(repeatCounter>=10) {
			String returnVal="";
			for(int i=0; i>repeatCounter;i++) {
				returnVal = returnVal+digit[number]+" ";	
			}
			return returnVal;
		} else {
			return repeat[repeatCounter]+" "+digit[number]+" ";
		}
	}
}
