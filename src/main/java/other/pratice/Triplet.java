package other.pratice;

public class Triplet {
	int min, max;
	private boolean[][] memo;

	public Triplet(int i, int j) {
		// TODO Auto-generated constructor stub
		this.min = i;
		this.max = j;
		memo = new boolean[j+1][j+1];
	}

	public void findTriplet() {
		// TODO Auto-generated method stub
		for (int i = min; i <= max; i++) {
			for (int j = min; j <= max; j++) {
				if (!(memo[i][j] || memo[j][i])) {
					isPerfectSquare(i, j);
				} else {
					System.out.println("a = " + i + ", b = " + j + ", c = " + (int)Math.sqrt(i * i + j * j));
				}
				//isPerfectSquare(i, j);
			}
		}
	}

	private void isPerfectSquare(int i, int j) {
		int k = i * i + j * j;
		if (checkPerfectSquare(k)) {
			this.memo[i][j] = (Math.sqrt(k) >= this.min && Math.sqrt(k) <= this.max) ? true : false;
		}
	}

	private boolean checkPerfectSquare(double x) {
		double sq = Math.sqrt(x);
		return ((sq - Math.floor(sq)) == 0);
	}

}
