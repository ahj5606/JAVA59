package book.cahp06;

public class Company {
	private static Company instance = new Company();
	private Company() {}
	public static Company getInstance() { 
		if(instance == null) { //인스턴스화를 하지 않았을때
			instance = new Company();	//다시
		}
		return instance;
	}
	
}
