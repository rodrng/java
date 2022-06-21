import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Member extends JPanel {
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtDate;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblDate;
	private JTextField txtPoint;

	
	public Member(String id, String name, String phone, String mDate, String Point) {
		setLayout(null);
		initGUI();
		
		txtID.setText(id);
		txtName.setText(name);
		txtPhone.setText(phone);
		txtDate.setEditable(false);
		txtDate.setText(mDate);
		
		txtPoint = new JTextField();
		txtPoint.setText(Point);
		txtPoint.setEditable(false);
		txtPoint.setColumns(10);
		txtPoint.setBounds(80, 129, 116, 21);
		add(txtPoint);
		
		JLabel lblPoint = new JLabel("포인트");
		lblPoint.setBounds(12, 132, 57, 15);
		add(lblPoint);
	}
		
		private void initGUI() {
		
		lblID = new JLabel("ID:");
		lblID.setBounds(12, 13, 57, 15); 
		add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(80, 10, 116, 21);
		add(txtID);
		
		lblName = new JLabel("이름:");
		lblName.setBounds(12, 41, 57, 15);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(80, 38, 116, 21);
		add(txtName);
		
		lblPhone = new JLabel("전화번호:");
		lblPhone.setToolTipText("");
		lblPhone.setBounds(12, 71, 57, 15);
		add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setToolTipText("");
		txtPhone.setColumns(10);
		txtPhone.setBounds(80, 68, 116, 21);
		add(txtPhone);
		
		lblDate = new JLabel("가입일:");
		lblDate.setBounds(12, 99, 57, 15);
		add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(80, 96, 116, 21);
		add(txtDate);
		
		

		JButton btnUpdate = new JButton("변경");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String strCon = "jdbc:mysql://localhost/cafedb?user=root&password=123qwe";
					Connection con = DriverManager.getConnection(strCon);
					Statement stmt = con.createStatement();
					String sql = "update membertbl set name='" + txtName.getText();
					sql = sql + "', phone='" + txtPhone.getText();
					sql = sql + "' where id=" + txtID.getText().trim();
					if(stmt.executeUpdate(sql)>0)
						JOptionPane.showMessageDialog(null, "변경완료!!!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(208, 13, 93, 48);
		add(btnUpdate);
	}
}
