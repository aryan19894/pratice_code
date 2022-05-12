// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaMap.java

package pratice.hackerrank.pratice.java.DataStructure;

import java.io.*;
import java.util.HashMap;

public class JavaMap
{

    public JavaMap()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap map = new HashMap();
        while(n-- > 0) 
        {
            String name = br.readLine();
            int phone = Integer.parseInt(br.readLine());
            map.put(name, Integer.valueOf(phone));
        }
        String s;
        while((s = br.readLine()) != null) 
            if(map.containsKey(s))
                System.out.println((new StringBuilder()).append(s).append("=").append(map.get(s)).toString());
            else
                System.out.println("Not found");
        br.close();
    }
}
