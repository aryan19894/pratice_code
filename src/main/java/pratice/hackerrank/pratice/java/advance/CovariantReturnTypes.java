// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CovariantReturnTypes.java

package pratice.hackerrank.pratice.java.advance;

import java.io.*;

// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            WestBengal, AndhraPradesh, Region, Flower

public class CovariantReturnTypes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        byte var5 = -1;
        switch (s.hashCode()) {
            case -1663963882:
                if (s.equals("WestBengal")) {
                    var5 = 0;
                }
                break;
            case -141439467:
                if (s.equals("AndhraPradesh")) {
                    var5 = 1;
                }
        }

        switch (var5) {
            case 0:
                region = new WestBengal();
                break;
            case 1:
                region = new AndhraPradesh();
        }

        Flower flower = ((Region) region).yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}
