package book.chap07;
/* 내가 짠 코드
 * 1차배열,2차배열 - 초기화하기,꺼내서 사용하기
 * 배열에 담긴 정보를 꺼낼 수 있다.(반복문과 조건문 활용)
 * 개선된 for문 연습 - 컬렉션 프레임워크
 * 객체배열 따로 정리하기
 * 
 * 성적처리 방법
 * jumsu[i][j]
 * 번수i는 row수 - 사람구분
 * 변수j는 column수 - 과목구분
 * 총점 구하기
 * for문 한개로 가능하다|아니다.
 * 만일 아니다 2개일 것이다.
 * 만일 강호동의 총점을 구한다면 i가 고정된 상태에서 j가 변해야 한다. |아니다.|
 * 
 * 메소드를 사용할 것인가/
 * 
 * 1단계-main메소드 안에서만 코딩한다.
 * 2단계 - 메소드로 꺼내어 보기 : 재사용성과 이식성 높이는 코드르 작성하기
 * 
 * 총점과 평균 구하기에 배열을 사용할 것인가?
 */
public class SungJuk {
	String jumsu[][] = {//5명에 대한 이름,국어점수,영어점수,수학점수
			{"강호동","100","80","90"},
			{"유재석","60","70","90"},
			{"강감찬","80","70","70"},
			{"김유신","90","90","90"},
			{"이성계","80","80","80"},
			{"이성계","60","75","62"},
			{"가","80","90","90"}
	};
	int totalArr[] = new int[jumsu.length];	//String jums[]의 크기(입력 인원의 수)와 같은 크기로 선언, 더많은 사람이 들어와도 계산
	double avgArr[] = new double[jumsu.length];
	int totalSub[] = new int[3];
	int rankArr[] = new int[jumsu.length];
	
	void total(String jumsu[][],int row,int totalArr[]) {	//2차원 배열과 총점을 구하는 행 는 메소드
		int total=0;//총점을 저장할 변수
		for(int i=1;i<jumsu[row].length;i++) {//총점을 구하기위한 반복 jumsu[][0]번째는 이름이 들어가기때문에 1번부터 시작
			total+=Integer.parseInt(jumsu[row][i]); //더하기를 사용하기 위해 String 형태의 배열을 int형으로 변환하여 저장
		}
		totalArr[row]=total;
		
	}//end of total
	
	void avg(int totalArr[],int row,double avgArr[]) {	//총점배열을 받아 평균배열에 저장해주는 메소드
		
		double avg = totalArr[row]/3.0;	//3과목 평균 double형으로 하기위해 3.0으로 나눔
		avgArr[row] = avg;
	}//end of avg
	
	void totalSubject(String jumsu[][],int totalSub[]) {
		for(int j = 1;j<jumsu[j].length;j++) {		//1부터시작 0에는 이름들이 저장되는곳.
			int total =0;	//총점을 저장할 변수
			for(int i=0;i<jumsu.length;i++) { //각 영역별 총점을 구하기 위해 j를 고정한 후 i를 변화
						total += Integer.parseInt(jumsu[i][j]); //더하기를 사용하기 위해 String형을 int형으로 변환
				
			}//end of for inner
			totalSub[j-1]=total;
		}//end of for outter
	}//end of totalSubject
	
	void rank(int totalArr[],int rankArr[]) {	//순위를 구하는 메소드 총점과 순위가 들어갈 배열을 파라미터로 받는다

		for(int i =0;i<rankArr.length;i++) {	// 0등이 아니라 1등부터 이므로 ,모든 순위를 1로 초기화
			rankArr[i]=1;
		}
		
		for(int i=0;i<rankArr.length;i++) {	//순위를 주기위한 반복
			for(int j=0;j<rankArr.length;j++) {
				if(totalArr[i]<totalArr[j]) {//자기 자신보다 높은 점수가 있으면 
					rankArr[i]+=1;			//순위가 1씩 밀려난다
				}
			}
		}
	}//end of rank
	
	public static void main(String[] args) {
		SungJuk sj = new SungJuk();

		for(int i =0;i<sj.jumsu.length;i++) { //사람별총점,평균,과목별총점 메소드를 호출하기 위한 반복	
			sj.total(sj.jumsu, i, sj.totalArr); //총점을 계산해서 totalArr에 순서대로 저장해주는 메소드
			sj.avg(sj.totalArr, i, sj.avgArr); //평균을 계산해서 avgArr에 순서대로 저장해주는 메소드
			sj.totalSubject(sj.jumsu, sj.totalSub);
		}
		sj.rank(sj.totalArr, sj.rankArr);	//순위 구하기 메소드 호출
		
		System.out.println("이름\tkor\teng\tmath\ttotal\tavg\trank");
		System.out.println("===========================================================");	//출력문 정리
		
		
		for(int i=0;i<sj.jumsu.length;i++) {		//출력문
			for(int j=0;j<sj.jumsu[i].length;j++) {
				System.out.print(sj.jumsu[i][j]+"\t");
			}
			System.out.printf("%d\t%.2f\t%d\n",sj.totalArr[i],sj.avgArr[i],sj.rankArr[i]);
		}
		
		System.out.println("==========================================================");
		System.out.print("과목별총점");
		for(int i = 0;i<sj.totalSub.length;i++) {		//과목별 총점 출력 
			System.out.print("\t"+sj.totalSub[i]);
		}
		
		
		
		
	}
}
