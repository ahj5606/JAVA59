package baisc.method;

import java.util.Scanner;

//메소드를 설계할 수 있다.
//리턴타임은 뭘로 하지? - 실수영역 double  /
//파라미터는 몇 개로 할까? -두 개중에   -double 2개 
//파라미터의 타입은 어떡하지?- 실수영역
//메소드의 이름은 무엇으로 할까?  max
/*
 * 정수 두개를 입력받아 
 * 최대값을 출력해주는 메소드
 */
public class MaxValue {
	double max(double d_num1,double d_num2) {
		//둘중에 누가 더 크니
		double d_maxNum=0;
		if(d_num1>d_num2) { //if문 표현 
			d_maxNum = d_num1;
		}
		else if(d_num1<d_num2){
			d_maxNum = d_num2;
		}
		else {
			d_maxNum =0;
		}
		//d_maxNum = d_num1>d_num2 ? d_num1 : d_num2;  삼항연산자 표현
		return d_maxNum;
	}//end of max
	
}
