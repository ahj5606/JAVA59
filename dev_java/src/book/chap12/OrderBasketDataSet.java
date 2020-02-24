package book.chap12;

import java.util.ArrayList;

public class OrderBasketDataSet {
//main 메소드를 직접 컨트롤 할 수 없다 - JVM
	public ArrayList<OrderBasketVO> getList(){
		ArrayList<OrderBasketVO> al = new ArrayList<>();
		OrderBasketVO obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-19");
		obVO.setT_qty(150);
		obVO.setT_price(560000);
		al.add(obVO);
		
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-20");
		obVO.setT_qty(105);
		obVO.setT_price(360000);
		al.add(obVO);
		
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("총계");
		obVO.setT_qty(255);
		obVO.setT_price(920000);
		al.add(obVO);
		
		for(OrderBasketVO ov : al) {
			System.out.print("날짜 :"+ov.getIndate_vc());
			System.out.print("\t수량 :"+ov.getT_qty());
			System.out.print("\t가격 :"+ov.getT_price() +"\n");
		}
		
		return al;
		
	}
	public static void main(String[] args) {
		ArrayList<OrderBasketVO> al = new ArrayList<>();
		OrderBasketVO obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-19");
		obVO.setT_qty(150);
		obVO.setT_price(560000);
		al.add(obVO);
		
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-20");
		obVO.setT_qty(105);
		obVO.setT_price(360000);
		al.add(obVO);
		
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("총계");
		obVO.setT_qty(255);
		obVO.setT_price(920000);
		al.add(obVO);
		
		for(OrderBasketVO ov : al) {
			System.out.print("날짜 :"+ov.getIndate_vc());
			System.out.print("\t수량 :"+ov.getT_qty());
			System.out.print("\t가격 :"+ov.getT_price() +"\n");
		}
		
	}
}
