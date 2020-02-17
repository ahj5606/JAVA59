package ocjp.basic;

 public class Test {
	 public static void replaceJ(String text) {//리턴타입x
		 text.replace('j', 'l');
	 }
	 public static String replaceJ2(String text) {//리턴타입o
		 String imsi = null;
		 imsi = text.replace('j', 'l');
		 return imsi;
	 }
	 public static void main(String args[]) {
		String text = new String("java");
	 	replaceJ(text);
	 	System.out.println(text);
	 	System.out.println("===================================");
	 	String text2 = null;
	 	text2=replaceJ2(text);
	 	System.out.println(text2);
	 }
 }