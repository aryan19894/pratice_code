package companyOA.hackerrank.GoldmanSache;

public class BthdayPartyReturnGift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDamageToy(5, 2, 1));
	}

	private static int findDamageToy(int n, int t, int d) {
		int ans = (d - 1 + t) % n;
		return ans == 0 ? n : ans;
	}

}
