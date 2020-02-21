package test0219;
/*
 * 2. 1부터 1000까지 숫자중 2의 배수 이거나 5의 배수인 숫자의 합을 구하는 
   소스코드와 결과화면 스크린 샷을 제출하시오
    [요구사항] 
   가. 단, 2와 5의 공배수인 경우 제외
   나, while문 버전과  for문 버전으로 두가지 소스코드를 작성하시오
 */
public class Q2 {
	
	public static void main(String[] args) {
		int num = 1;
		int result = 0;
		for(num = 1 ; num<=1000 ; num ++) {
			if(num%2==0&&num%5==0) {}
			else if(num%2==0 || num%5==0) {
				result +=num;
			}
		}
		System.out.println("for 문의 결과 : "+result);
	
		num = 1;
		result = 0;
		while(num<=1000) {
			if(num%2==0&&num%5==0) {}
			else if(num%2==0 || num%5==0) {
					result +=num;
			}
			num++;
			if(num==1000) {
				break;
			}
		}
		System.out.println("while 문의 결과 : "+result);
	}
	
}
