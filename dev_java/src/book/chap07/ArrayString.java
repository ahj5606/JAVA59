package book.chap07;

public class ArrayString {

	
	public static void main(String[] args) {
		String nameList[] = {"이정훈","김혜인","전진완","이진아"};
		String nameList2[][] = {
				{"이정훈","김혜인","전진완","이진아"},
				{"25","26","27","28"}
				
		};
		String nameList3[][] = {
				{"이정훈","김혜인","전진완","이진아"}
				,{"25","26","27","28"}
				,{"바둑","웨이크보드","당구","사이클"}
				
		};
		for(int i=0 ; i<nameList3[2].length;i++) {
			System.out.print(nameList3[2][i]+"\t");
		}
		System.out.println("\n=========================================");
		for(int i=0 ; i<nameList3.length;i++) {
			for(int j=0; j<nameList3[i].length;j++) {
				if(i==2) { //친구들의 취미니?
					System.out.print(nameList3[i][j]+"\t");
					
				}
				
			}
		}
		
	}

}
