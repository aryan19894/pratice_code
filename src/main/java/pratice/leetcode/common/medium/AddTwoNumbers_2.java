// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddTwoNumbers_2.java

package pratice.leetcode.common.medium;


// Referenced classes of package pratice.leetcode.common.medium:
//            ListNode

class AddTwoNumbers_2
{

    AddTwoNumbers_2()
    {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        return addRecursively(l1, l2, 0);
    }

    public static ListNode addRecursively(ListNode l1, ListNode l2, int carry)
    {
        ListNode result = new ListNode();
        if(l1 == null && l2 == null)
            if(carry > 0)
            {
                result.val = carry;
                result.next = null;
                return result;
            } else
            {
                return null;
            }
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        if(sum > 9)
        {
            carry = 1;
            sum %= 10;
        } else
        {
            carry = 0;
        }
        result.val = sum;
        result.next = addRecursively(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return result;
    }
}
