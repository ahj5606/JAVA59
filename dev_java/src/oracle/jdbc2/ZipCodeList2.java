package oracle.jdbc2;

import java.util.Vector;

public class ZipCodeList2 {
	public static void main(String[] args) {
		/*
		Vector<String> v1 = new Vector<>();
		System.out.println("v.size() : "+v.size());
		ZipCodeVO zcVO = new ZipCodeVO();
		zcVO.setAddress("서울시 마포구 공덕동");
		zcVO.setZipcode(21545);
		v1.add(0,"파인애플");//넌 틀렸어!. 타입 맞지 않아
		v.add(zcVO);
		System.out.println(v1.get(0));//파인애플
		System.out.println("주소 : "+v.get(0).getAddress()+"\t우편번호 : "+zcVO.getZipcode());
		ZipCodeVO zVO=v.get(0);
		int zipcode = zVO.getZipcode();
		System.out.println(zipcode);
		*/
		Vector<ZipCodeVO> v = new Vector<ZipCodeVO>();//아직 데이터는 들어가지 않음
		ZipCodeVO zcVO = null;
		ZipCodeVO zcVOS[] = null;
		int i =0;
		while(i<3) {
			zcVO = new ZipCodeVO();
			System.out.println("zcVO주소번지 바뀐다"+zcVO);
			v.add(zcVO);
			i++;
		}
		for(int x=0;x<v.size();x++) {
			ZipCodeVO zVO = v.get(x);
			System.out.println(zVO);
		}
		zcVOS = new ZipCodeVO[v.size()];//v와크기 같은 ZipCodeVO배열
		System.out.println("배열의 크기는"+zcVOS.length);
		//zcVOS가 가리키는 객체 배열에 들어가있는 정보를 출력해 보세요
		//insert here
		//zcVOS.length는 배열의 방크기(갯수)- 3개 있다.
		for(int y=0;y<zcVOS.length;y++) {
			System.out.println(zcVOS[y]); //null null null
		}
		//저 배열의 세개  방안에 ZipCodeVO가 초기화 될 수 있도록 코드를 작성해 보세요.
		for(int x=0;x<zcVOS.length;x++) { 
			zcVOS[x]=v.get(x); //v[x]의 주소값을 zcVOS[x]로 대입
		}
		//리턴타입이 void이지만 값을 유지하게 할 수 있다.
		//파라미터로 넘긴 주소번지에 v에 저장되어 잇는 주소번지를 복제해주는 메소드.
		v.copyInto(zcVOS);//v값에있는걸 순서대로 복사.
		for(ZipCodeVO z:zcVOS) {
			System.out.println(z);
		}
	}
}
