import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinPlace extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinPlace dialog = new WinPlace();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinPlace() {
		setTitle("장소 선택");
		setBounds(100, 100, 350, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblHere = new JLabel(""); // 매장 식사
		lblHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); 
				WinJoin dlg = new WinJoin();
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		});
		lblHere.setIcon(new ImageIcon(WinPlace.class.getResource("/img/A.png")));
		lblHere.setBounds(40, 50, 100, 140);
		contentPanel.add(lblHere);
		
		JLabel lblTogo = new JLabel(""); // 테이크 아웃
		lblTogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); 
				WinJoin dlg = new WinJoin();
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		});
		lblTogo.setIcon(new ImageIcon(WinPlace.class.getResource("/img/B.png")));
		lblTogo.setBounds(200, 50, 100, 140);
		contentPanel.add(lblTogo);
		
		JLabel lblNewLabel_2 = new JLabel("식사하실 장소를 선택해 주세요");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(30, 21, 280, 20);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblHere2 = new JLabel("매장 식사");
		lblHere2.setEnabled(false);
		lblHere2.setFont(new Font("굴림", Font.BOLD, 12));
		lblHere2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHere2.setBounds(40, 190, 100, 20);
		contentPanel.add(lblHere2);
		
		JLabel lblHere2_1 = new JLabel("테이크 아웃");
		lblHere2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHere2_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblHere2_1.setEnabled(false);
		lblHere2_1.setBounds(200, 190, 100, 20);
		contentPanel.add(lblHere2_1);
		
		JButton btnBack = new JButton("돌아가기");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WinMain dlg = new WinMain();
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		});
		btnBack.setBounds(203, 228, 97, 23);
		contentPanel.add(btnBack);
	}
}
