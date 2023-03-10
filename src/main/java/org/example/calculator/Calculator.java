package org.example.calculator;

// 코드의 재활용성! -> Calculator Public Class
public class Calculator {
    // 덧셈 연산자를 사용 할 수 있게 calculate method 를 생성해줌
    // operand1, operand2 -> 피연산자!
    // operator -> 연산자!
    // operand1 +(operator) operand2 -> 이런식으로 사용하겠다는 것을 보여줌
    public static int calculate(int operand1, String operator, int operand2) {
        // 2. if 조건문에서 연산자가 해당되면, 결과물을 실행하라 -> 리팩토링 잘됨!
        // + 연산자 일때
        if ("+".equals(operator)) {
            // 피연산자 1,2 반환해줌
            return operand1 + operand2;
        } // - 연산자 일때
        else if ("-".equals(operator)) {
            // 피연산자 1,2 반환해줌
            return operand1 - operand2;
        } // * 연산자 일때
        else if ("*".equals(operator)) {
            // 피연산자 1,2 반환해줌
            return operand1 * operand2;
        } // / 연산자 일때
        else if ("/".equals(operator)) {
            // 피연산자 1,2 반환해줌
            return operand1 / operand2;
        }
        // return 으로 default value 설정
        return 0;
        // 1. 피연산자만으로 연산자 없이 Calculator 하기 -> 리팩토링 잘됨!
//        return operand1 + operand2;
    }
}
