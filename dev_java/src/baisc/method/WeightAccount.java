package baisc.method;

import java.util.*;
public class WeightAccount {
	/****************************************************
	 * 
	 * @param d_eWeight -지구의 몸무게
	 * @return - 달의 몸무게
	 *****************************************************/
	double moonWeight(double d_eWeight) {
		double m_Weight = 0;
		m_Weight = (d_eWeight*17)/100.0;
		return m_Weight;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WeightAccount wa = new WeightAccount();
		System.out.print("당신의 몸무게를 입력하세요 : ");
		double d_eWeight=0; //지구의 몸무게
		d_eWeight=scan.nextDouble();
		double d_mWeight= 0;
		d_mWeight = wa.moonWeight(d_eWeight);
		System.out.println("달에서의 몸무게는 : "+d_mWeight);
		
		
	}
}
