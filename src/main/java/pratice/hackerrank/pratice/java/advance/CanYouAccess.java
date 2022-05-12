// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CanYouAccess.java

package pratice.hackerrank.pratice.java.advance;

import java.io.*;

// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            DoNotTerminate

public class CanYouAccess {
    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o = new CanYouAccess.Inner().new Private();
            System.out.println(num + " is " + ((CanYouAccess.Inner.Private) o).powerof2(num));
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
        } catch (DoNotTerminate.ExitTrappedException var4) {
            System.out.println("Unsuccessful Termination!!");
        }

    }

    static class Inner {
        Inner() {
        }

        private class Private {
            private Private() {
            }

            private String powerof2(int num) {
                return (num & num - 1) == 0 ? "power of 2" : "not a power of 2";
            }
        }
    }
}
