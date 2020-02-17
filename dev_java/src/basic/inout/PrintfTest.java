package basic.inout;

import java.util.Scanner;

public class PrintfTest {

	public static void main(String[] args) {
		int valaue = 123;
		
		System.out.printf("상품의 가격:%d원\n",valaue);
		System.out.printf("상품의 가격:%6d원\n",valaue);
		System.out.printf("상품의 가격:%-6d원\n",valaue);
		System.out.printf("상품의 가격:%06d원\n",valaue);
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n",1,name,job);
		
	}
}
