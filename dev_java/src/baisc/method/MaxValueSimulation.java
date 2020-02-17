package baisc.method;

import java.util.Scanner;

public class MaxValueSimulation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MaxValue mv = new MaxValue();
		
		for(int i = 1 ; i <=10 ; i++) {
			System.out.print("첫번째 숫자를 입력해주세요 : ");
			double d_num1 = scan.nextDouble();
			System.out.print("두번째 숫자를 입력해주세요 : ");
			double d_num2 = scan.nextDouble();
			double d_maxNum = mv.max(d_num1, d_num2);
			System.out.println("숫자 : "+d_num1+" "+d_num2);
			System.out.println("최대값 : "+d_maxNum);
		}
	}

}
