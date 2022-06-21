import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinMemberSelect extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPhone;
	private JButton btnSearch;
	private JLabel lblPhone;
	private JButton btnCancel;
	/**
	 * Create the dialog.
	 */
	public WinMemberSelect() {
		initGUI();
	}
		private void initGUI() {
		// TODO Auto-generated method stub
			setTitle("회원검색");
			setBounds(100, 100, 395, 142);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			
			lblPhone = new JLabel("전화번호:");
			lblPhone.setBounds(12, 10, 57, 15);
			contentPanel.add(lblPhone);
			
			txtPhone = new JTextField();
			txtPhone.setColumns(10);
			txtPhone.setBounds(81, 7, 116, 21);
			contentPanel.add(txtPhone);
			
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String strPhone = txtPhone.getText().trim();
					
					WinMemberSearch dlg;
					try {
						dlg = new WinMemberSearch(strPhone);
						dlg.setModal(true);
						dlg.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnSearch.setBounds(12, 38, 95, 23);
			contentPanel.add(btnSearch);
			
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false); 
					WinMain dlg = new WinMain();
					dlg.setModal(true);
					dlg.setVisible(true);
				}
			});
			btnCancel.setBounds(117, 38, 95, 23);
			contentPanel.add(btnCancel);
		
	}
}

