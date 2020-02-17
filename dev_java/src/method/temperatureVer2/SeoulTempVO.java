package method.temperatureVer2;

public class SeoulTempVO {
			
	    private String sdate =null;
	    private int loc =0;
	    private double atemp =0.0;
	    private double mitemp = 0.0;
	    private double matemp =0.0; 
	    //실제 테입르에 존재하는 컬럼은 아니지만  프로그램에 필요한 변수도 선언 가능함
	    private String nYear = null; //콤보박스에서 사용자가 선택한 연도
	    private String mMonth = null; //콤보박스에서 사용자가 선택한 달
		public String getSdate() {
			return sdate;
		}
		public void setSdate(String sdate) {
			this.sdate = sdate;
		}
		public int getLoc() {
			return loc;
		}
		public void setLoc(int loc) {
			this.loc = loc;
		}
		public double getAtemp() {
			return atemp;
		}
		public void setAtemp(double atemp) {
			this.atemp = atemp;
		}
		public double getMitemp() {
			return mitemp;
		}
		public void setMitemp(double mitemp) {
			this.mitemp = mitemp;
		}
		public double getMatemp() {
			return matemp;
		}
		public void setMatemp(double matemp) {
			this.matemp = matemp;
		}
		public String getnYear() {
			return nYear;
		}
		public void setnYear(String nYear) {
			this.nYear = nYear;
		}
		public String getmMonth() {
			return mMonth;
		}
		public void setmMonth(String mMonth) {
			this.mMonth = mMonth;
		}
	
	
}
