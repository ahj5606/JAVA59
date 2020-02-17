package study.sungjuk;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

import oracle.jdbc2.ZipCodeVO;

public class SungJukEvent implements ActionListener {
	SungJukVO sjvos[] =null;
	
	SungJukView sjv = null;
	int rowNum;
	SungJukEvent(SungJukView sjv){
		this.sjv =sjv; 
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==sjv.jtf_inwon) {///////////////////////////START jbtn_inwn
			String inwon = sjv.jtf_inwon.getText();
			sjv.sjl.rowNum = Integer.parseInt(inwon);
			this.rowNum=sjv.sjl.rowNum;
			System.out.println(sjv.sjl.rowNum);
			sjv.jsp_sungjuk.setVisible(true);
			sjv.dtm_sungjuk.setRowCount(0);
			sjv.dtm_sungjuk.setRowCount(sjv.sjl.rowNum);
			sjv.jt_sungjuk.setModel(sjv.dtm_sungjuk);
			sjv.jf_sungjuk.pack();
			Dimension di = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			Dimension di2 = sjv.jf_sungjuk.getSize();
			
			sjv.jf_sungjuk.setLocation((int)(di.getWidth()/2-di2.getWidth()/2), (int)(di.getHeight()/2-di2.getHeight()/2));
			sjv.jtf_inwon.setText("");
		}else if(obj==sjv.jbtn_account) {/////////////////////////////START jbtn_account
			
			sjv.sungjuk=new String[sjv.sjl.rowNum][4];
			for(int i =0;i<sjv.sungjuk.length;i++) {
				for(int j=0;j<sjv.sungjuk[i].length;j++) {
					sjv.sungjuk[i][j] = (String) sjv.dtm_sungjuk.getValueAt(i,j);
					if(sjv.sungjuk[i][j]==null) {
						JOptionPane.showMessageDialog(sjv.jf_sungjuk, "모든 값을 입력해 주세요."+i+","+j);
						return;
					}
					
				}
			}
			int total[] = sjv.sjl.total(sjv.sungjuk);
			double avg[] = sjv.sjl.average(total);
			int rank[] = sjv.sjl.ranking(avg);
			for(int i=0;i<sjv.sungjuk.length;i++) {
				sjv.dtm_sungjuk.setValueAt(total[i], i,4);
				sjv.dtm_sungjuk.setValueAt(avg[i], i, 5);
				sjv.dtm_sungjuk.setValueAt(rank[i], i, 6);
			}
		}else if(obj==sjv.jbtn_exit) {//////////////////////////////START jbtn_exit
			System.exit(0);
		}else if(obj==sjv.jbtn_data) {//////////////////////START jbtn_data
			if(sjv.sjl.rowNum!=sjv.sjl.strData.length) {
				JOptionPane.showMessageDialog(sjv.jf_sungjuk, "저장되어 있는 값의 크기는"+sjv.sjl.strData.length+"입니다");
				return;
			}
			for(int i=0;i<sjv.sjl.strData.length;i++) {
				for(int j=0;j<sjv.sjl.strData[i].length;j++) {
					sjv.dtm_sungjuk.setValueAt(sjv.sjl.strData[i][j], i, j);
				}
				
			}
		}else if(obj == sjv.jbtn_ran) {///////////////////////////START jbtn_ran
			if(sjv.sjl.rowNum==0) {
				JOptionPane.showMessageDialog(sjv.jf_sungjuk, "크기를 지정해주세요");
				return;
			}
			sjv.sungjuk=new String[sjv.sjl.rowNum][4];
			Random rd = new Random();
			for(int i=0;i<sjv.sungjuk.length;i++) {
				for(int j=1;j<sjv.sungjuk[i].length;j++) {
					sjv.sungjuk[i][0]=new RandomName().name;
					sjv.sungjuk[i][j]=Integer.toString(rd.nextInt(100));
				}
			}
			for(int i=0;i<sjv.sungjuk.length;i++) {
				for(int j=0;j<sjv.sungjuk[i].length;j++) {
					sjv.dtm_sungjuk.setValueAt(sjv.sungjuk[i][j], i, j);
				}
			}
		}else if(obj==sjv.jbtn_oracle) {//////////////////////////START jbtn_oracle
				SungJukDB sjdb = new SungJukDB();
				Vector<SungJukVO> v = new Vector<>();
				for(int i=0;i<sjv.sjl.rowNum;i++) {
					SungJukVO sjvo=new SungJukVO();
					System.out.println(sjv.dtm_sungjuk.getValueAt(i, 0));
					System.out.println(sjv.dtm_sungjuk.getValueAt(i, 1));
					System.out.println(sjv.dtm_sungjuk.getValueAt(i, 2));
					System.out.println(sjv.dtm_sungjuk.getValueAt(i, 3));
					System.out.println(sjv.dtm_sungjuk.getValueAt(i, 5));
					System.out.println(sjv.dtm_sungjuk.getValueAt(i, 6));
					sjvo.setName((String)sjv.dtm_sungjuk.getValueAt(i, 0));
					sjvo.setKor((String)sjv.dtm_sungjuk.getValueAt(i, 1));
					sjvo.setEng((String)sjv.dtm_sungjuk.getValueAt(i, 2));
					sjvo.setMath((String)sjv.dtm_sungjuk.getValueAt(i, 3));
					sjvo.setTotal((String)sjv.dtm_sungjuk.getValueAt(i, 4));
					sjvo.setAvg((String)sjv.dtm_sungjuk.getValueAt(i, 5));
					sjvo.setRank((String)sjv.dtm_sungjuk.getValueAt(i, 6));
					v.add(sjvo);
				}
				/*sjvos = new SungJukVO[v.size()];
				v.copyInto(sjvos);
				sjdb.insertSungJuk(sjvos);*/
			}
	}

}
