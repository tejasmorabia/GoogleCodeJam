package dynamicProgramming;


public class LongestSubSequence {
	char[] firstSeq;
	char[] secondSeq;
	public LongestSubSequence(char[] first, char[] second) {
		this.firstSeq = first;
		this.secondSeq = second;
	} 
	
	public String getLongest() {
		int[][] dyanmic = createDyanmic(firstSeq,secondSeq);
		return findLongest(dyanmic);
	}
	
	public String findLongest(int[][] dynamic) {
		String result ="";
		int i=dynamic.length-1;
		int j=dynamic[0].length-1;
		while(dynamic[i][j] !=0) {

			if(dynamic[i][j] > dynamic[i-1][j] && dynamic[i][j] > dynamic[i][j-1]) {
				result = firstSeq[i-1]+result;
				i--;
				j--;
			} else if(dynamic[i-1][j] > dynamic[i][j-1]){
				i--;
			} else {
				j--;
			}
		}
		return result;
	}

	public int[][] createDyanmic(char[] first, char[] second) {
		int[][] dynamic = new int[first.length+1][second.length+1];
		
		//initialize first row and column as 0
		for(int i=0;i<first.length;i++) {
			dynamic[i][0] = 0;
		}
		
		for(int j=0;j<second.length;j++) {
			dynamic[0][j] = 0;
		}

		for(int j=1;j<dynamic[0].length;j++) {
			for (int i=1;i<dynamic.length;i++) {
				System.out.println("CurrentFirst:"+i+":"+first[i-1]);
				System.out.println("CurrentSecond:"+j+":"+second[j-1]);
				if(first[i-1] == second[j-1]) {
					dynamic[i][j] = dynamic[i-1][j-1] +1;
				} else {
					dynamic[i][j] = dynamic[i][j-1] >= dynamic[i-1][j] ? dynamic[i][j-1]:dynamic[i-1][j];  
				}
				print(dynamic);
			}
		}
		
		return dynamic;
	}

	private void print(int[][] dynamic) {
		for(int j=0;j<dynamic[0].length;j++) {
			String row="";
			for (int i=0;i<dynamic[0].length;i++) {
				 row = row+" "+dynamic[i][j];
			}
			System.out.println(row);
		}
		
		System.out.println("");
	}

	public static void main (String[] args) {
		String firstSeq="ABCDGH";
		String secondSeq="AEDFHR";
		LongestSubSequence l1 = new LongestSubSequence(firstSeq.toCharArray(), secondSeq.toCharArray());
		System.out.println(l1.getLongest());
	}

}
