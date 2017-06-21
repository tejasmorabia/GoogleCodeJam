package dynamicProgramming;

public class MinEdits {
	public MinEdits(){};
	
	public int editDistance(String first, String second, int m, int n) {
		if(m==0) return n;
		if(n ==0) return m;
		if(first.charAt(m-1) == second.charAt(n-1)) {
			return editDistance(first, second, m-1,n-1);
		}
		return 1 + min (editDistance(first, second, m, n-1),
						editDistance(first, second, m-1, n),
						editDistance(first, second, m-1, n-1));
	}
	
	private int min(int editDistance, int editDistance2, int editDistance3) {
		if(editDistance < editDistance2 && editDistance < editDistance3) return editDistance;
		if(editDistance2 < editDistance && editDistance2 < editDistance3) return editDistance2;
		return editDistance3;
	}

	public static void main(String[] args) {
		String first = "Tet";
		String second = "TestABC";
		MinEdits m1 = new MinEdits();
		System.out.println("Result:"+m1.editDistance(first, second, first.length(), second.length()));
	}
}
