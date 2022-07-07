package bot;

import java.util.Scanner;

public class ArrayConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Enter the string: ");
            String str = in.nextLine().trim();
            if(str.length() != 0){
                str = str.replaceAll("\\[", "{");
                str = str.replaceAll("]", "}");
                str = str.replaceAll("\"", "\'");
                System.out.println(str);
            }
        }
    }
}
