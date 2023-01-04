/*Q1. You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.*/

import java.util.*;
import java.io.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        String operators = "+-*/";
        for(String s : tokens)
        {
            if(operators.contains(s) && !stack.isEmpty()){
              int operator1 = stack.pop();
              int operator2 = stack.pop();
              int result = calculator(operator2,s,operator1);
              stack.push(result);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }
    public int calculator(int operator2,String s,int operator1)
    {
        if(s.equals("+")){
          return operator2+operator1;
        }
        else if(s.equals("-")){
          return operator2-operator1;
        }
        else if(s.equals("/") && operator1 != 0){
          return operator2/operator1;
        }
        return operator2*operator1;
    }
}
