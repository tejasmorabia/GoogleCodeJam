package com.googlecodejam.rationalnumbertree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RationalNumberTree {
	
	public static void main(String args[]) throws Exception {
		
		File file = new File("/Users/morabiafamily/Documents/workspace1/GoogleCodeJam/src/com/googlecodejam/A-small-practice.in");
		  try {
			    Scanner scanner = new Scanner(file);
			    Integer testCases = Integer.parseInt(scanner.nextLine());
	            for(int i=0; i<testCases;i++) {
	                String line = scanner.nextLine();
	                String splitString[] = line.split(" ");
	                String output="";
	                if(splitString[0]=="1") {
	                	output=solveProblemType1(Integer.parseInt(splitString[1]));
	                } else {
	                	output=solveProblemType2(Integer.parseInt(splitString[1]),Integer.parseInt(splitString[2]));	                	
	                }
	                System.out.println("Case #"+(i+1)+": "+output.trim());
	            }
		  }	catch (FileNotFoundException e) {
	            e.printStackTrace();
		  }
	}

	private static String solveProblemType2(int parseInt, int parseInt2) {
		Node n1 = new Node();
		n1.p = parseInt;
		n1.q = parseInt2;
		int index = computeArray().indexOf(n1);
		return ""+index;
	}

	private static String solveProblemType1(int parseInt) {
		Node currentNode = computeArray().get(parseInt);
		return currentNode.p+" "+currentNode.q;
	}
	
	public static List<Node> computeArray() {
		List<Node> computerValue = new ArrayList<Node>();
		double totalCount = Math.pow(2, 64+1)-1;
		for(double i=0;i<64;i++) {
			
		}
		return computerValue;
	}
	
	public static class Node {
		int p;
		int q;
		
	}
	
}
