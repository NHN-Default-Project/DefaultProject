package com.nhnacademy.yunhwa.exercise10_7;

/* 10 - 7
 * 하위 섹션 10.4.1 의 샘플 프로그램 SimpleInterpreter.java 확장판 만들기
 * ====================================================================
 * let variable = expression / print expression 형식의 명령을 수행 가능
 * [변수, 숫자, 연산자, 괄호] 가 포함된 expression 처리 가능
 * sin, cos, tan, abs, sqrt, log 가 처리 가능한 프로그램 으로 확장
 * ====================================================================
 * x, y 값이 주어졌다는 가정 하에, sin(3*x-7)+log(sqrt(y)) 같은 표현식 계산 (0.2211082209)
 * sin(3*2-7) : -0.01745240644
 * log(sqrt(3)) : 0.2385606274
 * 함수 이름 뒤에는 괄호로 묶인 expression 이 와야함.
 *
 * 심볼 테이블 : Map<String, Double> 유형의 객체
 * Key : (String) 변수 이름 / Value : (Double) 해당 변수의 값
 * ====================================================================
 * 예시 : 사용자가 아래와 같은 명령을 입력한다고 가정해보자
 *
 * let x = 3 + 12
 * print 2 + 2
 * print 10*x + 17
 * let rate = 0.06
 * print 1000*(1+rate)
 * =====================================================================
 * 프로그램은 간단한 언어에 대한 통역사 역할
 * 프로그램이 이해하는 명령 : print, let
 * print : 표현식을 계산 후 출력
 * 표현식에 변수가 포함되어 있으면, 심볼 테이블에서 해당 변수의 값을 찾아야 함.
 * let : 표현식을 계산 후 변수에 값 할당,  컴퓨터는 변수의 값을 심볼 테이블에 저장해야 함.
 * run time 에 사용자로부터 입력을 받아야만 변수 이름을 알 수 있게됨.
 * ======================================================================
 * HashMap 을 심볼 테이블로 사용. -> HashMap<String, Double> 유형의 symbolTable
 * symbolTable = new HashMap<>(); ( 처음  키/ 값 이 비어있는 맵 생성 )
 * let -> symbolTable.put(String variableName, double value); 값을 키와 연결
 * SimpleInterpreter.java 의 doLetCommand() 에서 put() 메서드를 찾을 수 있음.
 * ======================================================================
 * symbolTable.put("pi", Math.PI);
 * symbolTable.put("e", Math.E);
 * ======================================================================
 * 프로그램이 표현식을 계산하는 동안, 변수를 발견하면
 * 심볼 테이블의 get() 메서드를 사용하여 해당 값을 검색
 * symbolTable.get(String variableName); return double 값 or null
 * null 인지 아닌지를 확인하는 것이 중요함.
 * 사용자가 정의하지 않은 변수를 사용하려고 하는 것이기에 오류!
 * (값이 할당되기 전에 변수를 표현식에 사용하는 경우 오류 발생)
 * ======================================================================
 * 이를 처리하려면 아래와 같이 처리 가능
 * ---------------------------------------------
 * Double value = symbolTable.get(variableName);
 * if (value == null) {
 *   throw new UndifinedVariableException();
 * }
 * ---------------------------------------------
 * 위의 코드는 SimpleInterpreter.java 의 PrimaryValue() 메서드에서 찾을 수 있음.
 * */
public class Exercise10_7 {

    public static void main(String[] args) {
        SimpleInterpreter.run();



        // ============== 테스트 할 때 활용할 수 있는 코드 ================
        // let x = 2
        // let y = 3
        // print sin(3*x-7)+log(sqrt(y))

        // print sin(3*2-7)+log(sqrt(3))
//        System.out.println(Math.sin(-1) + Math.log(Math.sqrt(3))); // -0.2921648404738417

        // print sin(-1)
//        System.out.println(Math.sin(-1)); // -0.8414709848078965

        // print sin(3*2-7)
//        System.out.println(Math.sin(3 * 2 - 7)); // -0.8414709848078965
//
        // print log(3)
//        System.out.println(Math.log(3)); // 1.0986122886681096

        // print sqrt(3)
//        System.out.println(Math.sqrt(3)); // 1.7320508075688772

        // print log(sqrt(3))
//        System.out.println(Math.log(Math.sqrt(3))); // 0.5493061443340548

    }
}
