package org.example.credit_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * - 평균학점 계산 방법 = (학점수 X 교과목 평점)의 합계/수강신청 총학점 수
 * - 일급 컬렉션 사용
 */

// 학점계산기 Test
public class GradeCalculatorTest {
    // 1. 학점계산기 도메인 : 이수한 과목(객체지향프로그래밍, 자료구조, 중국어회화), 학점 계산기
    // 2. 객체지향프로그래밍, 자료구조, 중국어회화 --> 과목(코스) 클래스[3. 추상화 모델링]
    /**
     * 4번이 핵심이니 잘체크 할 것 -> 협력 설계를 한다는 의미!
     * */
    // 4. 이수한 과목을 전달하여 평균학점 계산 요청 --> 학점 계산기 --> 4-1. (학점수 X 교과목 평점)의 합계 --> 과목(코스)
    //                                                      --> 4-2. 수강신청 총학점 수            --> 과목(코스)

    // 구현 및 설계과정 -> 객체 지향적인 프로그램이 탄생!

    // 평균 학점계산기 Test Code
    // Test 과정부터 하는 이유는 빠르게 로직을 짜기전 환경설정을 한다고 생각하면 됨!
    // 즉, 미리 우리가 java 란 프로그래밍 언어를 배우기 위해서 Tool 을 사용해야하고 사용할려면 다운로드를 하여 java 를 사용할 수 있도록 환경을 갖추고 진행을 해야지 문제없이 학습할 수 있기 때문에 이런 작업을 하는 것도 그런 이유다!
    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGrandeTest() {
        // 과목이 여러 개 이기에, List 형태로 Course 를 받아오고, course 변수를 설정하고
        List<Course> courses =
                // List.of 메소드를 사용하여 new Course 생성자를 이용하여 values 들을 넣어줌 -> course 들을 설정해줌
                List.of(new Course("OOP", 3, "A+"),
                        new Course("자료구조", 3, "A+"));

        // Course 가 생성되면 이수한 과목들에게 값을 전달해줌
        GradeCalculator gradeCalculator = new GradeCalculator(courses);

        // Double Type gradeResult variable 로  전달받은 이수한 과목들을 가지고 성적을 계산해줌
        double gradeResult = gradeCalculator.calculateGrade();

        // gradeResult 결과값과 비교하여 값이 올바른지 Test
        // 1. 에러가 남! -> calculateGrade 에서 return 값이 0으로만 계속 받아주고 있기 때문임!
        assertThat(gradeResult).isEqualTo(4.5);
    }
}
