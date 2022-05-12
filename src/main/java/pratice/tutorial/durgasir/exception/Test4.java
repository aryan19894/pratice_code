package pratice.tutorial.durgasir.exception;

class TooYoungException extends RuntimeException {
	TooYoungException(String s) {
		//super(s);
	}
}
class TooOldException extends RuntimeException {
	TooOldException(String s) {
		//super(s);
	}
}

class Test4 {
	public static void main(String args[]) {
		int age = Integer.parseInt(args[0]);
		if(age > 60)
			throw new TooOldException("you are too old");
		else if(age < 18)
			throw new TooYoungException("you are too young");
		else 
			System.out.println("You are perfect for marriage");
		
	}
}