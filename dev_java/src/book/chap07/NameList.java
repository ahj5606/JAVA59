package book.chap07;

public class NameList {
	public static void main(String[] args) {
		SungJuk2 sj = new SungJuk2();
		for(String name: sj.names) {
			System.out.println(name);
		}
		sj.main(args);
		int k_tot = sj.korTotal;
		System.out.println("\nnamelist     : " +k_tot);
	}
}
