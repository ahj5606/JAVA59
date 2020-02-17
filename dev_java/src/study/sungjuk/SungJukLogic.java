package study.sungjuk;

public class SungJukLogic {
	int rowNum=0;
	String strData[][] = {
			{"김유신","80","61","70"}
			,{"이성계","60","67","62"}
			,{"이순신","70","87","90"}
			,{"홍길동","82","65","83"}
			,{"강감찬","82","52","87"}
	};
	public int[] total(String sungjuk[][]) {
		int[] total = new int[rowNum];
		int sum = 0;
		for(int i = 0 ; i <sungjuk.length;i++) {
			sum=0;
			for(int j = 1; j<sungjuk[i].length ;j++) {
				sum += Integer.parseInt(sungjuk[i][j]);
			}
			total[i]=sum;
		}
		return total;
	}
	public double[] average(int total[]) {
		double avg[] = new double[rowNum];
		for(int i=0;i<avg.length;i++) {
			avg[i]=total[i]/3.0;
		}
		return avg;
	}
	public int[] ranking(double avg[]) {
		int rank[] = new int[rowNum];
		for(int i =0;i<rank.length;i++) {	// 0등이 아니라 1등부터 이므로 ,모든 순위를 1로 초기화
			rank[i]=1;
		}
		
		for(int i=0;i<rank.length;i++) {	//순위를 주기위한 반복
			for(int j=0;j<rank.length;j++) {
				if(avg[i]<avg[j]) {//자기 자신보다 높은 점수가 있으면 
					rank[i]+=1;			//순위가 1씩 밀려난다
				}
			}
		}
		return rank;
	}
}
