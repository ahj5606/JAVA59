package book.chap08;

import java.util.ArrayList;

public class Room {
	String r_title = null;
	int t_inwon = 0;
//	peopleList c_people[] = null;
	int c_inwon = 0;
	ArrayList<String> tnameList = null;
	ArrayList<String> cnameList = null;
	
	public Room(String r_title, int t_inwon,int c_inwon){
		
		this.r_title = r_title;
		this.t_inwon = t_inwon;
		this.c_inwon = c_inwon;
	}
	
}
