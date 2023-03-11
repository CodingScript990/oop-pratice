package org.example.calculator.operator;

// 다른 방식의 OOP 해결과정
public interface NewArithmeticOperator {
    // boolean Type Variable (operator 유효성 검사)
    boolean supports(String operator);
    // int Type Variable (operand1, operand2 유형성 검사)
    int calculate(int operand1, int operand2);
}
