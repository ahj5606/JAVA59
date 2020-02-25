package book.chap12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListNMapTest {
	
	public List<Map<String,Object>> getDeptList() {
		List<Map<String,Object>> deptList = new ArrayList<Map<String,Object>>();
		Map<String,Object> pMap = new HashMap<String,Object>();
		pMap.put("deptno", 10);
		pMap.put("dname", "ACCOUNTING");
		pMap.put("loc","NEW YORK");
		deptList.add(pMap);
		pMap = null;
		pMap = new HashMap<String,Object>();
		pMap.put("deptno", 20);
		pMap.put("dname", "RESEARCH");
		pMap.put("loc","DALLAS");
		deptList.add(pMap);
		pMap = null;
		pMap = new HashMap<String,Object>();
		pMap.put("deptno", 30);
		pMap.put("dname", "SALES");
		pMap.put("loc","CHICAGO");
		deptList.add(pMap);
		return deptList;
	}
	
	public static void main(String[] args) {
		ListNMapTest lnm = new ListNMapTest();
		
		List<Map<String,Object>> deptList =lnm.getDeptList();
		
		for(int i=0;i<deptList.size();i++) {
			Object keys[] =deptList.get(i).keySet().toArray();
			for(int j=0;j<keys.length;j++) {
				String key = keys[j].toString();
				System.out.println(key+" -> "+deptList.get(i).get(key));
			}
			System.out.println("=============================");
		}
		
		System.out.println("****************Iterator****************");
		for(int i=0;i<deptList.size();i++) {
			Iterator ir = deptList.get(i).keySet().iterator();
			while(ir.hasNext()) {
				Object key = ir.next();
				System.out.println(key + " -> " + deptList.get(i).get(key));
			}
			System.out.println("=============================");
		}
		
		
	}
}
