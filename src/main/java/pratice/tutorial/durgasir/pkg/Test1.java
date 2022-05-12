package pratice.tutorial.durgasir.pkg;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("ab");
		String s2 = new String("cd");
		System.out.println(s1 == s2);

		String s3 = "abcd";
		System.out.println(s1 == s3);

		String s4 = "abcd";
		System.out.println(s3 == s4);

		String s5 = "ab" + "cd";
		System.out.println(s3 == s5);

		String s6 = "ab";
		String s7 = s6 + "cd";
		System.out.println(s3 == s7);

		final String s8 = "ab";
		String s9 = s8 + "cd";
		System.out.println(s3 == s9);
		System.out.println(s6 == s8);

		String s10 = "ab";
		final String s11 = "cd";
		String s12 = s10 + s11;
		System.out.println(s3 == s12);

		String s13 = "ab";
		String s14 = "cd";
		String s15 = s13 + s14;
		System.out.println(s3 == s15);

		final String s16 = "ab";
		final String s17 = "cd";
		String s18 = s16 + s17;
		System.out.println(s3 == s18);

	}

}
