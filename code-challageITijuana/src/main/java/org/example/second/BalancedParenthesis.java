package org.example.second;

import java.util.Stack;

public class BalancedParenthesis {

     public boolean isValidParenthesesBalanced(String input){
         Stack<Character> stack = new Stack<>();

         for (char c : input.toCharArray()) {
             if (c == '(' || c == '[' || c == '{') {
                 stack.push(c);
             } else if (c == ')' || c == ']' || c == '}') {
                 if (stack.isEmpty()) {
                     return false;
                 }
                 char top = stack.pop();
                 if ((c == ')' && top != '(')
                     || (c == ']' && top != '[')
                     || (c == '}' && top != '{')) {
                     return false;
                 }
             }
         }

         return stack.isEmpty();

     }



}
