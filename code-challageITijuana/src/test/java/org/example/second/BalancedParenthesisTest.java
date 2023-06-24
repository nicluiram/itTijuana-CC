package org.example.second;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedParenthesisTest {

    private BalancedParenthesis balancedParenthesis;
    @Before
    public void setUp() throws Exception {
        balancedParenthesis = new BalancedParenthesis();
    }

    @Test
    public void isValidParenthesesBalanced() {
        System.out.println(balancedParenthesis.isValidParenthesesBalanced("((({{{[[[]]]}}})))"));
        System.out.println(balancedParenthesis.isValidParenthesesBalanced("{{{[][][]}}}"));
        System.out.println(balancedParenthesis.isValidParenthesesBalanced("()(){{{}}}[][]"));
        System.out.println(balancedParenthesis.isValidParenthesesBalanced("()()()()"));


        System.out.println(balancedParenthesis.isValidParenthesesBalanced("(((())})"));
        System.out.println(balancedParenthesis.isValidParenthesesBalanced(")((()))()()"));
        System.out.println(balancedParenthesis.isValidParenthesesBalanced("((()()()))(()"));

    }
}