package book.chap07;

import java.util.Scanner;

public class qwe {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String user=scan.nextLine();
		int userInt=Integer.parseInt(user);
		int user1 = userInt%1000;
		int user2 = userInt%100;
		int user3 = userInt%10;
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
	}
}
