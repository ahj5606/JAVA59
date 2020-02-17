package basic.inout;

import java.io.IOException;


public class ContinueKeyCode {
	public static void main(String[] args) throws IOException{
		int KeyCode;
		while(true) {
			KeyCode = System.in.read();
			System.out.println("KeyCode : "+KeyCode);
			if(KeyCode==113||KeyCode==81) {
				break; //if문 탈출이 아닌 while문에 대한탈출.
			}
		}
		System.out.print("종료");
	}
	
}
