// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaFactoryPattern.java

package com.hackerrank.pratice.java.advance;

import java.security.Permission;

class Do_Not_Terminate
{
    public static class ExitTrappedException extends SecurityException
    {

        private static final long serialVersionUID = 1L;

        public ExitTrappedException()
        {
        }
    }


    Do_Not_Terminate()
    {
    }

    public static void forbidExit()
    {
        SecurityManager securityManager = new SecurityManager() {

            public void checkPermission(Permission permission)
            {
                if(permission.getName().contains("exitVM"))
                    throw new ExitTrappedException();
                else
                    return;
            }

        }
;
        System.setSecurityManager(securityManager);
    }
}
