package oracle.jdbc2;

public class ZipCodeVOsimulation {
	void methodA() {
		ZipCodeVO zcVOS[] = new ZipCodeVO[2];//컬렉션과 제네릭 공부
		ZipCodeVO zcVO = new ZipCodeVO(); 
		//삼각형 안에 zipcode변수에 값 넣기
		zcVO.setZipcode(21548);//우편번호를 [각각6번,인스턴스화] 담았다
		zcVOS[0]=zcVO;//사각형의 삼각형 넣기
		zcVO= new ZipCodeVO();
		zcVO.setZipcode(23988);//우편번호를 [각각9번,인스턴스화] 담았다
		zcVOS[1]=zcVO;//사각형의 삼각형 넣기
		//메소드 호출
		printZcVOS(zcVOS);//메소드 파리미터로 주소번지[] 넘겨주기
	}
	void printZcVOS(ZipCodeVO zcVOS[]) {
		for(ZipCodeVO zcVO:zcVOS) {
			System.out.println(zcVO.getZipcode());
		}
	}
	public static void main(String[] args) {
		ZipCodeVO zcVO = new ZipCodeVO();
//		zcVO.uid_no=10; //private -왜? 웹이나 앱에서 동시사용자가 많을때 변조되면 안됨.
		zcVO.setUid_no(10);//쓰기 -> 10
		zcVO.setUid_no(30);//10 -> 30 오버라이팅
		int uid_no =zcVO.getUid_no();
		System.out.println("?"+uid_no);//10
		zcVO.setAddress("서울시 금천구 가산동");
		String address =zcVO.getAddress();
		System.out.println(address);
		zcVO.setZipcode(123456);
		int zipcode = zcVO.getZipcode();
		System.out.println(zipcode);
		ZipCodeVOsimulation Z = new ZipCodeVOsimulation();
		Z.methodA();
		
	}
}
