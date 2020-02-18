package oracle.jdbc2;


public class DeptDaoTest {
	DeptDao dDao = new DeptDao();
	int result =0; //입력결과|수정결과|삭제결과 를 담을 변수
	//조회하기 테스트
	public void selectTest(DeptVO dVO) {
		System.out.println("SelectTest 호출성공");
		DeptVO dVOS[]=dDao.deptList(dVO.getDeptno());
		if(dVOS.length!=0) {
			for(DeptVO rdVO : dVOS) {
				System.out.println(rdVO.getDeptno() +"  / "+rdVO.getDname() + "  / "+rdVO.getLoc() );
			}
		}else {
			System.out.println("조회결과 없음");
		}
	}
	//등록하기 테스트
	public void insertTest(DeptVO dVO) {
		result =0;
		System.out.println("insertTest 호출성공");
		result=dDao.deptInsert(dVO.getDeptno(), dVO.getDname(), dVO.getLoc());
		System.out.println("입력 결과 : "+result);
	}
	//수정하기 테스트
	public void updateTest(DeptVO dVO) {
		result =0;
		System.out.println("updateTest 호출성공");
		result=dDao.deptUpdate(dVO.getDeptno(), dVO.getDname(), dVO.getLoc());
		System.out.println("수정 결과 : "+result);
	}
	//삭제하기 테스트
	public void deleteTest(DeptVO dVO) {
		result =0;
		System.out.println("deleteTest 호출성공");
		result=dDao.deptDelete(dVO.getDeptno());
		System.out.println("삭제 결과 : "+result);
		
	}
	public static void main(String[] args) {
		DeptDaoTest ddt = new DeptDaoTest();
		//화면이 아직 완성되지 않았으므로 통합테스트는 불가하다.
		//하지만 단위테스트는 언제나 가능
		
		DeptVO dVO = new DeptVO();
		
		dVO.setDeptno(61);
		dVO.setDname("품질관리팀");
		dVO.setLoc("인천");
		ddt.insertTest(dVO);

		dVO = null; //기존의 연결괴를 끊는다.
		dVO = new DeptVO();//새로운 객체를 조립시작
		dVO.setDeptno(61);
		ddt.selectTest(dVO);
		
		dVO = null;
		dVO = new DeptVO();
		dVO.setDeptno(61);
		dVO.setDname("품질관리팀2");
		dVO.setLoc("인천2");
		ddt.updateTest(dVO);
		
		dVO = null; //기존의 연결괴를 끊는다.
		dVO = new DeptVO();//새로운 객체를 조립시작
		dVO.setDeptno(61);
		ddt.selectTest(dVO);
		
		dVO = null;
		dVO = new DeptVO();
		dVO.setDeptno(61);
		ddt.deleteTest(dVO);
		
		dVO = null; //기존의 연결괴를 끊는다.
		dVO = new DeptVO();//새로운 객체를 조립시작
		dVO.setDeptno(61);
		ddt.selectTest(dVO);
		
		
	}
}
