import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class WinMemberSearch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String strPhone;
	String Members[][] = new String[100][5];
	
	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public WinMemberSearch(String strPhone) throws Exception {
		this.strPhone = strPhone;
		initGUI();
		
	}

	private void initGUI() throws Exception {
		// TODO Auto-generated method stub
		setTitle("회원조회");
		setBounds(100, 100, 415, 307);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPanel.add(tabbedPane);
		
		int count = SearchMember();
		Member member[] = new Member[count];
		for(int i=0; i<count; i++) {
			member[i] = new Member(Members[i][0], Members[i][1], Members[i][2], Members[i][3], Members[i][4]);
			tabbedPane.addTab(Members[i][1], member[i]);
			
		}
	}

	private int SearchMember() throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String strCon = "jdbc:mysql://localhost/cafedb?user=root&password=123qwe";
		Connection con = DriverManager.getConnection(strCon);
		Statement stmt = con.createStatement();
		// 4가지 경우 if~else if~else if~else
		String sql = null;
		if(strPhone.trim().length()==0) {
			sql = "select * from membertbl";
		}
		else{
			sql = "select * from membertbl where phone='" + strPhone + "'";
		}
		
		ResultSet rs = stmt.executeQuery(sql);
		int count = 0;
		while(rs.next()) {
			Members[count][0] = rs.getString("id");
			Members[count][1] = rs.getString("name");
			Members[count][2] = rs.getString("phone");
			Members[count][3] = rs.getString("Date");
			Members[count][4] = rs.getString("Point");
			count++;
			
		}
		return count;
	}
}
