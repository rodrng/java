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
import java.time.LocalTime;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class WinMemberInsert extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtDate;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinMemberInsert dialog = new WinMemberInsert();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinMemberInsert() {
		setTitle("신규회원");
		setBounds(100, 100, 339, 211);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("이름:");
		lblName.setBounds(34, 41, 40, 15);
		contentPanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(79, 38, 116, 21);
		txtName.setColumns(10);
		contentPanel.add(txtName);
		
		JLabel lblPhone = new JLabel("전화번호:");
		lblPhone.setBounds(12, 71, 52, 15);
		contentPanel.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(80, 68, 116, 21);
		txtPhone.setColumns(10);
		contentPanel.add(txtPhone);
		
		JButton btnCheck = new JButton("중복확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CheckMember(txtPhone.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			private void CheckMember(String phone) throws Exception {
				// TODO Auto-generated method stub
				Class.forName("com.mysql.cj.jdbc.Driver");
				String temp = "jdbc:mysql://localhost/cafedb?user=root&password=123qwe";
				Connection con = DriverManager.getConnection(temp);
				Statement stmt = con.createStatement();
				String sql = "select * from membertbl where phone='" + phone + "'";
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "이미 존재함");
					txtPhone.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "등록 해도됨");
				}
			}
		});
		btnCheck.setBounds(208, 67, 99, 23);
		contentPanel.add(btnCheck);
		
		JLabel lblmDate = new JLabel("가입일:");
		lblmDate.setBounds(22, 100, 40, 15);
		contentPanel.add(lblmDate);
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setBounds(79, 97, 116, 21);
		txtDate.setColumns(10);
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		
//		LocalTime now1 = LocalTime.now();
//		int hour = now1.getHour();
//		int minute = now1.getMinute();
//		int second = now1.getSecond();

		
//		txtDate.setText( year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
		txtDate.setText( year + "-" + month + "-" + day);
		
		
		contentPanel.add(txtDate);
		
		JButton btnMemberInsert = new JButton("회원등록");
		btnMemberInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						MemberInsert();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			private void MemberInsert() throws SQLException, ClassNotFoundException {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String temp = "jdbc:mysql://localhost/cafedb?user=root&password=123qwe";
				Connection con = DriverManager.getConnection(temp);
				Statement stmt = con.createStatement();
				String sql = "INSERT INTO membertbl VALUES(null, '";
				sql = sql + txtName.getText() + "','" + txtPhone.getText() + "',sysdate(),'1000')" ;
				
				if(stmt.executeUpdate(sql) > 0) {
					JOptionPane.showMessageDialog(null, "회원등록 완료");
					setVisible(false); 
					WinMain dlg = new WinMain();
					dlg.setModal(true);
					dlg.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "회원등록 실패");
			}
		});
		btnMemberInsert.setBounds(63, 139, 99, 23);
		contentPanel.add(btnMemberInsert);
		
		JLabel lblID = new JLabel("회원번호:");
		lblID.setBounds(12, 13, 62, 15);
		contentPanel.add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(79, 10, 116, 21);
		contentPanel.add(txtID);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				WinMain dlg = new WinMain();
				dlg.setModal(true);
				dlg.setVisible(true);
				
			}
		});
		btnCancel.setBounds(174, 139, 99, 23);
		contentPanel.add(btnCancel);
	}
}
