package book.cahp04;

public class FizzBuzz {
	public void ifTest() {
		for(int i=1;i<=100;i++) { //1~100까지 센다
			
			if((i%5==0)&&(i%7==0)){ //5와 7로 나누면 0 
				System.out.println(i+" FizzBuzz");
			}else if(i%5==0) { //5로 나누면 0
				System.out.println(i+" Fizz");
			}else if(i%7==0) {// 7로 나누면 0
				System.out.println(i+" Buzz");
			}else {//다아닐때 숫자 출력
				System.out.println(i);
			}
		}
	}
	public void switchTest() {
		for(int i=1;i<=100;i++) { //1~100까지 센다
			
			switch(i%(5*7)) {
				case 0: System.out.println(i+" FizzBuzz"); 
						break;
				default:	
					
					switch(i%5) {
						case 0: System.out.println(i+" Fizz");
								break;
						default:
							
							switch(i%7) {
								case 0: System.out.println(i+" Buzz"); 
										break;
								default: System.out.println(i); 
										break;
					}
				}
				
			}
		
			
		}
	}
	public void switchTest2() {
		for(int i=1;i<=100;i++) {
			int num=i%5;
			System.out.print(i+" ");
			switch(num) {
				case 0: System.out.print("Fizz");
						break;
			}
			num =i%7;
			switch(num) {
				case 0: System.out.print("Buzz"); 
						break;
			}
			System.out.println();
			
		}
	}
	public void switchTest3() {
		int i=1;
		while(i<=100) {
			switch(i%(5*7)) {
			case 0:	//1가지
				System.out.println("FizzBuzz");
				break;
			case 5: case 10: case 15: case 20: case 25 : case 30: //2가지
				System.out.println("Fizz");
				break;
			case 7: case 14: case 21: case 28: //3가지
				System.out.println("Buzz");
				break;
			default:
				System.out.println(i);
				break;
				
			}//end of switch
			i++;
		}//end of while
	}//end of switchTest3

}//end of class
