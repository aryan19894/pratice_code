package companyOA.hackerrank.publicisSapient;

import java.util.Optional;

public class Java8Optional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional got = Optional.of("Game Of throne");
		String[] str = new String[10];
		Optional strOpt = Optional.ofNullable(str[9]);
		
		System.out.println(strOpt.isPresent());
		System.out.println(got.isPresent());
		
	}

}
