package org.example.calculator.operator;

// 뺄셈 연산자 -> NewArithmeticOperator Interface 를 상속 받음!(구현체)
public class SubtractionOperator implements NewArithmeticOperator {
    // Subtraction Operator 에 해당되면 실행!

    // Override -> boolean supports method(operator 유효성 Test)
    @Override
    public boolean supports(String operator) {
        // "-" 가 operator 값과 비교할때 일치하면 True 값을 반환해줘라!
        return "-".equals(operator);
    }

    // Override -> int supports method(operand1,2 유효성 Test)
    @Override
    public int calculate(int operand1, int operand2) {
        // operand1,2 가 addition operator 가 되도록 설정해주고 값을 반환해줌
        return operand1 - operand2;
    }
}
