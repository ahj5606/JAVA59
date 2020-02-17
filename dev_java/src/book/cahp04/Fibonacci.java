package book.cahp04;

public class Fibonacci {
	public void fibonacci() {
		int arr[] = new int[20];
		for(int i =0;i<arr.length;i++) {
			if(i==0 || i==1) {
				arr[i]=1;
			}else {
				arr[i]=arr[i-1]+arr[i-2];
			}
		}
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}
}
