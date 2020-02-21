package method.temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class SeoulTempEvent2 implements ActionListener, FocusListener , ItemListener {
	SeoulTempView2 stv = null;
	SeoulTempLogic2 stl = new SeoulTempLogic2(this);
	
	SeoulTempEvent2(SeoulTempView2 stv){
		this.stv = stv;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj==stv.jcb_month) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				stv.month = (String) stv.jcb_month.getSelectedItem();
			}
		}
		
		if(obj==stv.jcb_year) {
			
			stv.jcb_month.removeAllItems();
			
			if(e.getStateChange() == ItemEvent.SELECTED ) {
				stv.year = (String)stv.jcb_year.getSelectedItem();
				stv.months = stl.getMonth(stv.year);
				for(int i = 0;i<stv.months.length;i++) {
					
					stv.jcb_month.addItem(stv.months[i]);
				
				}
			}
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		Object obj = e.getSource();
		if(obj == stv.jtf_date) {
			stv.jtf_date.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		Object obj = e.getSource();
		if(obj == stv.jtf_date) {
			stv.jtf_date.setText(stv.textField);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == stv.jtf_date || obj == stv.jbtn_search) {
			String getText = stv.jtf_date.getText();
			System.out.println(stv.year+"/"+stv.month);
			System.out.println(stv.jtf_date.getText());
			
			if(getText.equals(stv.textField) || getText.equals("")) {
				if(stv.year==null||stv.month==null) {
					JOptionPane.showMessageDialog(stv.jf_temp, "값을 선택해주세요");
				}else {
					stl.reData(stv.year,stv.month);
				}
			}else
			{
				stl.reData(getText, null);
			}
		}
	}

}
