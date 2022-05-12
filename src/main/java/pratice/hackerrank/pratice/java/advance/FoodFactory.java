// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaFactoryPattern.java

package pratice.hackerrank.pratice.java.advance;


// Referenced classes of package pratice.hackerrank.pratice.java.advance:
//            Pizza, Cake, Food

class FoodFactory
{

    FoodFactory()
    {
    }

    public Food getFood(String order)
    {
        String s = order.toLowerCase();
        byte byte0 = -1;
        switch(s.hashCode())
        {
        case 106683528: 
            if(s.equals("pizza"))
                byte0 = 0;
            break;

        case 3045944: 
            if(s.equals("cake"))
                byte0 = 1;
            break;
        }
        switch(byte0)
        {
        case 0: // '\0'
            return new Pizza();

        case 1: // '\001'
            return new Cake();
        }
        return null;
    }
}
