package com.striver.DSAExperience.T12Tree.common;

public class TestNode extends GlobalNode{
    public int val;

    public TestNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TestNode{" +
                "left=" + left +
                ", right=" + right +
                ", val=" + val +
                '}';
    }
}
