package calc;

public class AddCalculator {
	private int cnt;
	
	public int add(int n1, int n2) {
		cnt++;
		return n1 + n2;
	}
	
	public int getCnt() {
		return cnt;
	}
}
