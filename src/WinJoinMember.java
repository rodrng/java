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
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class WinJoinMember extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPhone;
	private String point;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinJoinMember dialog = new WinJoinMember();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinJoinMember() {
		setTitle("회원 로그인");
		setBounds(100, 100, 283, 149);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("이름:");
		lblName.setBounds(34, 13, 40, 15);
		contentPanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(79, 10, 143, 21);
		txtName.setColumns(10);
		contentPanel.add(txtName);
		
		JLabel lblPhone = new JLabel("전화번호:");
		lblPhone.setBounds(12, 43, 52, 15);
		contentPanel.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(80, 40, 142, 21);
		txtPhone.setColumns(10);
		contentPanel.add(txtPhone);
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						JoinMember(txtName.getText(), txtPhone.getText());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			

			private void JoinMember(String name, String phone) throws SQLException, ClassNotFoundException {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String temp = "jdbc:mysql://localhost/cafedb?user=root&password=123qwe";
				Connection con = DriverManager.getConnection(temp);
				Statement stmt = con.createStatement();
				String sql = "SELECT * FROM membertbl WHERE name = '" + name + "' and phone ='" + phone + "'" ;
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					point = rs.getString("point");
					
					JOptionPane.showMessageDialog(null, "로그인 성공");
					setVisible(false);
					WinOrderMember dlg = new WinOrderMember(name, phone, point);
					dlg.setModal(true);
					dlg.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
					JOptionPane.showMessageDialog(null, "이름과 전화번호를 확인해주세요");
					txtName.setText(null);
					txtPhone.setText(null);
					txtName.requestFocus();
				}
			}
		});
		btnLogin.setBounds(12, 71, 99, 23);
		contentPanel.add(btnLogin);
		
		JButton btnCancel = new JButton("돌아가기");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				WinMain dlg = new WinMain();
				dlg.setModal(true);
				dlg.setVisible(true);
				
			}
		});
		btnCancel.setBounds(123, 71, 99, 23);
		contentPanel.add(btnCancel);
	}
}
