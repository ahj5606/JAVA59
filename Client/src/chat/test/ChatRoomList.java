package chat.test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ChatRoomList extends JFrame implements ActionListener,MouseListener{
	String u_id =null;
	LoginForm lf =null;
	String cols[] = {"채팅방 제목","총 인원"};
	String data[][]=new String[0][3];
	DefaultTableModel dtm_list = new DefaultTableModel(data,cols) {public boolean isCellEditable(int i, int c){ return false; }};
	JTable jt_list = new JTable(dtm_list);
	JScrollPane jsp_list = new JScrollPane(jt_list);
	JButton jbtn_in = new JButton("들어가기");
	JButton jbtn_exit =new JButton("종료");
	

	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	String c_title ="서버 채팅방";
	String c_people ="?명";
	String title ="";
	int row =0;
	public ChatRoomList(String u_id,LoginForm lf){
		lf.dispose();
		this.u_id=u_id;
		dtm_list.addRow(new Object[]{c_title,c_people});
		jp_center.add(jsp_list);
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_south.add(jbtn_in);
		jp_south.add(jbtn_exit);
		this.add("South",jp_south);
		this.add("Center",jp_center);
		addAction();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("채팅방 목록");
		this.setSize(500,600);
		Dimension di = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension di2 = this.getSize();
		this.setLocation((int)(di.getWidth()/2-di2.getWidth()/2), (int)(di.getHeight()/2-di2.getHeight()/2));
		this.setVisible(true);
		JOptionPane.showMessageDialog(this,"환영합니다."+u_id+"님.");
	}
	public void addAction() {
		jt_list.addMouseListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_in.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_exit) {
			System.exit(0);
			return;
		}else if(obj==jbtn_in) {
			InetAddress ip = null;
			try {
				ip = InetAddress.getLocalHost();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			if(ip==null) {
				JOptionPane.showMessageDialog(this, "연결에 실패하였습니다.");
				return;
			}else if(ip!=null) {
				new ChatForm(u_id, title,this,ip);
			}
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		row = jt_list.getSelectedRow();
		title = (String)dtm_list.getValueAt(row, 0);
		System.out.println(dtm_list.getValueAt(row, 0));
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
