import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;

public class WinMain extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			WinMain dialog = new WinMain();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public WinMain() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(WinMain.class.getResource("/img/A.png")));
		setTitle("커피가게");
		setBounds(100, 100, 490, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblWelcome = new JLabel("");
		
//		ImageIcon icon = new ImageIcon("/img/welcome.jpg");			        
//		Image img = icon.getImage();
//		Image updateImg = img.getScaledInstance(474, 90, Image.SCALE_SMOOTH);
//		ImageIcon updateIcon = new ImageIcon(updateImg);
//		lblWelcome.setIcon(updateIcon);
		
		lblWelcome.setIcon(new ImageIcon(WinMain.class.getResource("/img/welcome.jpg")));
		
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(0, 0, 474, 90);
		contentPanel.add(lblWelcome);
		
		
		
		// ========================================
		
		JButton btnOrder = new JButton("");
		btnOrder.setIcon(new ImageIcon(WinMain.class.getResource("/img/Order.png")));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WinPlace dlg = new WinPlace();
				dlg.setModal(true);
				dlg.setVisible(true);
				
				
			}
		});
		btnOrder.setBounds(40, 135, 100, 100);
		contentPanel.add(btnOrder);
		
		JButton btnPacking = new JButton("");
		btnPacking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				WinMemberSelect dlg = new WinMemberSelect();
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		});
		btnPacking.setIcon(new ImageIcon(WinMain.class.getResource("/img/MemberSearch.png")));
		btnPacking.setBounds(190, 135, 100, 100);
		contentPanel.add(btnPacking);
		
		JButton btnMember = new JButton("");
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				WinMemberInsert dlg = new WinMemberInsert();
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		});
		btnMember.setIcon(new ImageIcon(WinMain.class.getResource("/img/MemberInsert.png")));
		btnMember.setBounds(340, 135, 100, 100);
		contentPanel.add(btnMember);
		
		JLabel lblbtnOrder = new JLabel("주문하기");
		lblbtnOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblbtnOrder.setBounds(40, 245, 100, 15);
		contentPanel.add(lblbtnOrder);
		
		JLabel lblPacking = new JLabel("회원조회");
		lblPacking.setHorizontalAlignment(SwingConstants.CENTER);
		lblPacking.setBounds(190, 245, 100, 15);
		contentPanel.add(lblPacking);
		
		JLabel lblMember = new JLabel("신규가입");
		lblMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember.setBounds(340, 245, 100, 15);
		contentPanel.add(lblMember);
	}
}
