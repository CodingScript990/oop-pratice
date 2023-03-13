package org.example.credit_calculator;

import java.util.List;

public class GradeCalculator {
    // 일급 컬렉션을 사용하기 위해 Courses variable 초기화 값 add
    /**
     * 일급컬렉션(First Class Collection)
     * - Collection 을 Wrapping 하면서 그 외의 다른 Member Variable 가 없는 상태를 말함
     * - 소트윅스 앤솔로지의 객체지향 생활체조 파트의 규칙 8에서 언급이 되었음
     
     * 일급컬렉션 이점?
     * - 비지니스에 종속적인 자료구조이고
     * - Collection 의 불변성을 보장하고
     * - 상태와 행위를 한 곳에서 관리하고
     * - 이름이 있는 컬렉션임
     * */
    private final Courses courses;

    // List Type method add -> Course Variable1(courses variable) - 이수과목
    public GradeCalculator(List<Course> courses) {
        // 일급 컬렉션에 있는 List<Course> courses variable 받아오기! -> Courses 1번 과정!(대입)
        this.courses = new Courses(courses);
    }

    /**
     * 4번이 핵심이니 잘체크 할 것
     * */
    // 4. 이수한 과목을 전달하여 평균학점 계산 요청 --> 학점 계산기 --> 4-1. (학점수 X 교과목 평점)의 합계 --> 과목(코스) : 일급 컬렉션
    //                                                      --> 4-2. 수강신청 총학점 수            --> 과목(코스) : 일급 컬렉션

    // Double Type calculateGrade method add -> Course Variable2(courses variable) - 학점
    public double calculateGrade() {
        // 1. return 총 학점 수가 4.5 점을 받겠다는 의미 -> 미리 환경 Test
        // 2. 정상 작동하면 이제 코드를 작성함!

        // 학점수 X 교과목 평점 의 합계를 구하기 위한 과정
        // 학점수 X 교과목 평점 의 합계를 구해주는 Method 를 Call 함! -> Courses 2번 과정!(합침)
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();

        // 수강신청 총학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        // 4. 평균학점 계산하기!
        // 4-1. (학점수 X 교과목 평점)의 합계를 가지고
        // 4-2. 수강신청 총학점 수로 평균 학점을 계산 해줌!
        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit; // 1번
    }
}
