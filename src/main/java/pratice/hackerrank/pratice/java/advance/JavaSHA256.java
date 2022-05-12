// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaSHA256.java

package pratice.hackerrank.pratice.java.advance;

import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaSHA256
{

    public JavaSHA256()
    {
    }

    public static void main(String args[])
        throws NoSuchAlgorithmException
    {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes());
        byte digest[] = md.digest();
        byte abyte0[] = digest;
        int i = abyte0.length;
        for(int j = 0; j < i; j++)
        {
            byte b = abyte0[j];
            System.out.format("%02x", new Object[] {
                Byte.valueOf(b)
            });
        }

    }
}
