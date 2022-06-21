import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinOrderMember22222 extends JDialog {

//	private JLabel lblTotal = new JLabel();
	private JLabel lblTotalPrice;
	private JLabel lblTotalAmount;
	
	private JLabel lblPoint2;
	private JLabel FP;
	private JLabel MemPoint;

	private JLabel HCAmount;
	private JLabel HCPrice;
	private JLabel ICAmount;
	private JLabel ICPrice;
	private JLabel SHAmount;
	private JLabel SHPrice;
	private JLabel DRAmount;
	private JLabel DRPrice;
	private JLabel CAAmount;
	private JLabel CAPrice;
	
	private String Sname;
	private String Sphone;
	private String Spoint;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinOrderMember22222 dialog = new WinOrderMember22222(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinOrderMember22222(String name, String phone, String point) {
		Sname = name;
		Sphone = phone;
		Spoint = point;
		setTitle("커피 메뉴 선택");
		setBounds(100, 100, 848, 582);
		getContentPane().setLayout(null);
		
		
		JLabel lblHotCoffee = new JLabel("");
		lblHotCoffee.setIcon(new ImageIcon(WinOrderMember22222.class.getResource("/img/hotcoffee.png")));
		lblHotCoffee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					String amount = JOptionPane.showInputDialog("따뜻한 커피 갯수 입력 : ");
					String price = "3000";
					String total = Integer.toString(Integer.parseInt(price) * Integer.parseInt(amount));

					HCAmount.setText(amount + "개");
					HCPrice.setText(total + "원"); 
//					lblHotCoffee.setText("가격은");
				}
			}
		});
		
		lblHotCoffee.setBounds(20, 20, 100, 100);
		getContentPane().add(lblHotCoffee);
		
		JLabel lblIecCoffee = new JLabel("");
		lblIecCoffee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					String amount = JOptionPane.showInputDialog("아이스 커피 갯수 입력 : ");
					String price = "4000";
					String total = Integer.toString(Integer.parseInt(price) * Integer.parseInt(amount));
					
					ICAmount.setText(amount + "개");
					ICPrice.setText(total + "원");  
				}
			}
		});
		lblIecCoffee.setIcon(new ImageIcon(WinOrderMember22222.class.getResource("/img/icecoffee.png")));
		lblIecCoffee.setBounds(170, 20, 100, 100);
		getContentPane().add(lblIecCoffee);
		
		JLabel lblShake = new JLabel("");
		lblShake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					String amount = JOptionPane.showInputDialog("쉐이크 음료 갯수 입력 : ", 0);
					String price = "5000";
					String total = Integer.toString(Integer.parseInt(price) * Integer.parseInt(amount));

					SHAmount.setText(amount + "개");
					SHPrice.setText(total + "원"); 
				}
			}
		});
		lblShake.setIcon(new ImageIcon(WinOrderMember22222.class.getResource("/img/shake.png")));
		lblShake.setBounds(320, 20, 100, 100);
		getContentPane().add(lblShake);
		
		JButton btnCheck = new JButton("수량 및 가격 확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblTotalAmount.setText(
						Integer.parseInt(HCAmount.getText().replaceAll("개", ""))
						+ Integer.parseInt(ICAmount.getText().replaceAll("개", ""))
						+ Integer.parseInt(SHAmount.getText().replaceAll("개", ""))
						+ Integer.parseInt(DRAmount.getText().replaceAll("개", ""))
						+ Integer.parseInt(CAAmount.getText().replaceAll("개", "")) 
						+ "개");
				
//				lblTotalPrice.setText(
//						Integer.parseInt(HCPrice.getText().replaceAll("원", ""))
//						+ Integer.parseInt(ICPrice.getText().replaceAll("원", ""))
//						+ Integer.parseInt(SHPrice.getText().replaceAll("원", ""))
//						+ Integer.parseInt(DRPrice.getText().replaceAll("원", ""))
//						+ Integer.parseInt(CAPrice.getText().replaceAll("원", "")) 
//						+ "원");
				
				String TP = (
						Integer.parseInt(HCPrice.getText().replaceAll("원", ""))
						+ Integer.parseInt(ICPrice.getText().replaceAll("원", ""))
						+ Integer.parseInt(SHPrice.getText().replaceAll("원", ""))
						+ Integer.parseInt(DRPrice.getText().replaceAll("원", ""))
						+ Integer.parseInt(CAPrice.getText().replaceAll("원", "")) 
						+ "원");
				
				lblTotalPrice.setText(TP);
				FP.setText(TP);
				
			}
		});
		
		btnCheck.setBounds(651, 195, 159, 23);
		getContentPane().add(btnCheck);
		
		lblTotalPrice = new JLabel("0원");
		lblTotalPrice.setFont(new Font("굴림", Font.BOLD, 14));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setBounds(639, 258, 170, 20);
		
//		lblTotalPrice.setText(total);
		
		getContentPane().add(lblTotalPrice);
		
		JLabel HotCoffee = new JLabel("3000원");
		HotCoffee.setHorizontalAlignment(SwingConstants.CENTER);
		HotCoffee.setFont(new Font("굴림", Font.BOLD, 14));
		HotCoffee.setBounds(20, 130, 100, 20);
		getContentPane().add(HotCoffee);
		
		JLabel IceCoffee = new JLabel("4000원");
		IceCoffee.setHorizontalAlignment(SwingConstants.CENTER);
		IceCoffee.setFont(new Font("굴림", Font.BOLD, 14));
		IceCoffee.setBounds(170, 130, 100, 20);
		getContentPane().add(IceCoffee);
		
		JLabel Shake = new JLabel("5000원");
		Shake.setHorizontalAlignment(SwingConstants.CENTER);
		Shake.setFont(new Font("굴림", Font.BOLD, 14));
		Shake.setBounds(320, 130, 100, 20);
		getContentPane().add(Shake);
		
		JLabel lblDrink = new JLabel("");
		lblDrink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					String amount = JOptionPane.showInputDialog("음료 갯수 입력 : ");
					String price = "2000";
					String total = Integer.toString(Integer.parseInt(price) * Integer.parseInt(amount));

					DRAmount.setText(amount + "개");
					DRPrice.setText(total + "원"); 
				}
			}
		});
		lblDrink.setIcon(new ImageIcon(WinOrderMember22222.class.getResource("/img/Drinks.png")));
		lblDrink.setBounds(20, 180, 100, 100);
		getContentPane().add(lblDrink);
		
		JLabel Drink = new JLabel("2000원");
		Drink.setHorizontalAlignment(SwingConstants.CENTER);
		Drink.setFont(new Font("굴림", Font.BOLD, 14));
		Drink.setBounds(20, 290, 100, 20);
		getContentPane().add(Drink);
		
		JLabel lblCake = new JLabel("");
		lblCake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					String amount = JOptionPane.showInputDialog("케이크 갯수 입력 : ");
					String price = "6000";
					String total = Integer.toString(Integer.parseInt(price) * Integer.parseInt(amount));

					CAAmount.setText(amount + "개");
					CAPrice.setText(total + "원"); 
				}
			}
		});
		lblCake.setIcon(new ImageIcon(WinOrderMember22222.class.getResource("/img/cheesecake.png")));
		lblCake.setBounds(170, 180, 100, 100);
		getContentPane().add(lblCake);
		
		JLabel Cake = new JLabel("6000원");
		Cake.setHorizontalAlignment(SwingConstants.CENTER);
		Cake.setFont(new Font("굴림", Font.BOLD, 14));
		Cake.setBounds(170, 290, 100, 20);
		getContentPane().add(Cake);
		
		JLabel lblCPrice_1_1_1 = new JLabel("전체초기화");
		lblCPrice_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPrice_1_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblCPrice_1_1_1.setBounds(320, 290, 100, 20);
		getContentPane().add(lblCPrice_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("초기화");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					HCAmount.setText(0 + "개");
					HCPrice.setText(0 + "원"); 
					ICAmount.setText(0 + "개");
					ICPrice.setText(0 + "원"); 
					SHAmount.setText(0 + "개");
					SHPrice.setText(0 + "원");					
					DRAmount.setText(0 + "개");
					DRPrice.setText(0 + "원");
					CAAmount.setText(0 + "개");
					CAPrice.setText(0 + "원"); 
					lblTotalAmount.setText(0 + "개");
					lblTotalPrice.setText(0 + "원");
				}
			}
		});
		lblNewLabel_1_1_1.setBounds(320, 180, 100, 100);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel Price = new JLabel("주문가격 : ");
		Price.setBounds(537, 258, 60, 20);
		getContentPane().add(Price);
		
		JLabel Amount = new JLabel("주문수량 : ");
		Amount.setBounds(537, 228, 60, 20);
		getContentPane().add(Amount);
		
		lblTotalAmount = new JLabel("0개");
		lblTotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAmount.setFont(new Font("굴림", Font.BOLD, 14));
		lblTotalAmount.setBounds(640, 228, 170, 20);
		
		
		
		getContentPane().add(lblTotalAmount);
		
		JLabel HC = new JLabel("뜨거운 커피 :");
		HC.setBounds(478, 20, 100, 20);
		getContentPane().add(HC);
		
		HCAmount = new JLabel("0개");
		HCAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		HCAmount.setFont(new Font("굴림", Font.BOLD, 14));
		HCAmount.setBounds(590, 20, 100, 20);
		getContentPane().add(HCAmount);
		
		HCPrice = new JLabel("0원");
		HCPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		HCPrice.setFont(new Font("굴림", Font.BOLD, 14));
		HCPrice.setBounds(710, 20, 100, 20);
		getContentPane().add(HCPrice);
		
		JLabel IC = new JLabel("아이스 커피 :");
		IC.setBounds(478, 50, 100, 20);
		getContentPane().add(IC);
		
		ICAmount = new JLabel("0개");
		ICAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		ICAmount.setFont(new Font("굴림", Font.BOLD, 14));
		ICAmount.setBounds(590, 50, 100, 20);
		getContentPane().add(ICAmount);
		
		ICPrice = new JLabel("0원");
		ICPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		ICPrice.setFont(new Font("굴림", Font.BOLD, 14));
		ICPrice.setBounds(710, 50, 100, 20);
		getContentPane().add(ICPrice);
		
		JLabel SH = new JLabel("쉐이크 :");
		SH.setBounds(478, 80, 100, 20);
		getContentPane().add(SH);
		
		SHAmount = new JLabel("0개");
		SHAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		SHAmount.setFont(new Font("굴림", Font.BOLD, 14));
		SHAmount.setBounds(590, 80, 100, 20);
		getContentPane().add(SHAmount);
		
		SHPrice = new JLabel("0원");
		SHPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		SHPrice.setFont(new Font("굴림", Font.BOLD, 14));
		SHPrice.setBounds(710, 80, 100, 20);
		getContentPane().add(SHPrice);
		
		JLabel DR = new JLabel("음료 :");
		DR.setBounds(478, 115, 100, 20);
		getContentPane().add(DR);
		
		DRAmount = new JLabel("0개");
		DRAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		DRAmount.setFont(new Font("굴림", Font.BOLD, 14));
		DRAmount.setBounds(590, 115, 100, 20);
		getContentPane().add(DRAmount);
		
		DRPrice = new JLabel("0원");
		DRPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		DRPrice.setFont(new Font("굴림", Font.BOLD, 14));
		DRPrice.setBounds(710, 115, 100, 20);
		getContentPane().add(DRPrice);
		
		JLabel CA = new JLabel("케이크 :");
		CA.setBounds(478, 148, 100, 20);
		getContentPane().add(CA);
		
		CAAmount = new JLabel("0개");
		CAAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		CAAmount.setFont(new Font("굴림", Font.BOLD, 14));
		CAAmount.setBounds(590, 148, 100, 20);
		getContentPane().add(CAAmount);
		
		CAPrice = new JLabel("0원");
		CAPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		CAPrice.setFont(new Font("굴림", Font.BOLD, 14));
		CAPrice.setBounds(710, 148, 100, 20);
		getContentPane().add(CAPrice);
		
		JButton btnCard = new JButton("카드결제");
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(HCAmount.getText().equals("0개") && ICAmount.getText().equals("0개") && SHAmount.getText().equals("0개") 
							&& DRAmount.getText().equals("0개") && CAAmount.getText().equals("0개")) {
						;
						JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요");
					}
					else if(lblTotalPrice.getText().equals("0원")) {
						;
						JOptionPane.showMessageDialog(null, "수량과 가격을 확인해주세요");
					}
					else
						Card();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			private void Card() throws ClassNotFoundException, SQLException {
				// TODO Auto-generated method stub
				Class.forName("com.mysql.cj.jdbc.Driver");
				String temp = "jdbc:mysql://localhost/cafedb?user=root&password=123qwe";
				Connection con = DriverManager.getConnection(temp);
				Statement stmt = con.createStatement();
//				int HotCoffee, IceCoffee, Shake, Drink, Cake, Price = 0;
				
				String sql = "INSERT INTO orderhistory VALUES(NULL, '";
				sql = sql + HCAmount.getText().trim() + "','" + ICAmount.getText().trim() + "','" + SHAmount.getText().trim() + "','";
				sql = sql + DRAmount.getText().trim() + "','" + CAAmount.getText().trim() + "','" + FP.getText().trim() +  "'," + "'카드'" + ",sysdate()" +  ")";
//						System.out.println(sql);
				if(stmt.executeUpdate(sql) > 0)
					JOptionPane.showMessageDialog(null, "결제 성공");
				else
					JOptionPane.showMessageDialog(null, "결제 실패");
				
				String sql2 = "update membertbl set point='" + (int)(Integer.parseInt(Spoint) + (Integer.parseInt(FP.getText().replaceAll("원", ""))*0.1));
				sql2 = sql2 + "' where phone='" + Sphone + "'";
				System.out.println(sql2);
				if(stmt.executeUpdate(sql2)>0)
					JOptionPane.showMessageDialog(null, "포인트 적립 성공");
			}
		});
		btnCard.setBounds(613, 510, 97, 23);
		getContentPane().add(btnCard);
		
		JButton btnback = new JButton("돌아가기");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				WinPlace dlg = new WinPlace();
				dlg.setModal(true);
				dlg.setVisible(true);
				

			}
		});
		btnback.setBounds(723, 510, 97, 23);
		getContentPane().add(btnback);
		
		JButton btnCash = new JButton("현금결제");
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(HCAmount.getText().equals("0개") && ICAmount.getText().equals("0개") && SHAmount.getText().equals("0개") 
							&& DRAmount.getText().equals("0개") && CAAmount.getText().equals("0개")) {
						;
						JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요");
					}
					else if(lblTotalPrice.getText().equals("0원")) {
						;
						JOptionPane.showMessageDialog(null, "수량과 가격을 확인해주세요");
					}
					else
						Cash();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			private void Cash() throws ClassNotFoundException, SQLException {
				// TODO Auto-generated method stub
				Class.forName("com.mysql.cj.jdbc.Driver");
				String temp = "jdbc:mysql://localhost/cafedb?user=root&password=123qwe";
				Connection con = DriverManager.getConnection(temp);
				Statement stmt = con.createStatement();
//				int HotCoffee, IceCoffee, Shake, Drink, Cake, Price = 0;
				
				String sql = "INSERT INTO orderhistory VALUES(NULL, '";
				sql = sql + HCAmount.getText().trim() + "','" + ICAmount.getText().trim() + "','" + SHAmount.getText().trim() + "','";
				sql = sql + DRAmount.getText().trim() + "','" + CAAmount.getText().trim() + "','" + FP.getText().trim() +  "'," + "'현금'" + ",sysdate()" + ")";
				
				if(stmt.executeUpdate(sql) > 0)
					JOptionPane.showMessageDialog(null, "결제 성공");
				else
					JOptionPane.showMessageDialog(null, "결제 실패");
				
				String sql2 = "update membertbl set point='" + (int)(Integer.parseInt(Spoint) + (Integer.parseInt(FP.getText().replaceAll("원", ""))*0.1));
				sql2 = sql2 + "' where phone='" + Sphone + "'";
				System.out.println(sql2);
				if(stmt.executeUpdate(sql2)>0)
					JOptionPane.showMessageDialog(null, "포인트 적립 성공");
			}
		});
		btnCash.setBounds(500, 510, 97, 23);
		getContentPane().add(btnCash);
		
		JLabel MemName = new JLabel(Sname);
		MemName.setEnabled(false);
		MemName.setFont(new Font("굴림", Font.BOLD, 14));
		MemName.setHorizontalAlignment(SwingConstants.CENTER);
		MemName.setBounds(628, 290, 92, 20);
		getContentPane().add(MemName);
		
		JLabel lblPoint = new JLabel("보유하신 포인트 :");
		lblPoint.setBounds(638, 320, 100, 15);
		getContentPane().add(lblPoint);
		
		MemPoint = new JLabel(Spoint);
		MemPoint.setBounds(738, 320, 74, 15);
		getContentPane().add(MemPoint);
		
		JButton btnNewButton = new JButton("포인트 사용");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String p = JOptionPane.showInputDialog("사용하실 포인트 입력 : ");
				lblPoint2.setText(p);
				if(Integer.parseInt(Spoint) > Integer.parseInt(p)) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						String strCon = "jdbc:mysql://localhost/cafedb?user=root&password=123qwe";
						Connection con = DriverManager.getConnection(strCon);
						Statement stmt = con.createStatement();
						String sql = "UPDATE membertbl SET point = '" + Integer.toString(Integer.parseInt(Spoint) - Integer.parseInt(p));
						sql = sql + "' where phone='" + Sphone + "'";
						System.out.println(sql);
						
						if(stmt.executeUpdate(sql)>0)
							JOptionPane.showMessageDialog(null, "포인트 사용 완료");
						else {
							JOptionPane.showMessageDialog(null, "포인트를 확인해주세요");
						}
							
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(Integer.parseInt(Spoint) < Integer.parseInt(p)) {
					JOptionPane.showMessageDialog(null, "보유하신 포인트가 부족합니다");
				}
				else
					JOptionPane.showMessageDialog(null, "무슨 오류지");
				

				// 주문 가격
				String TotalPrice = (Integer.parseInt(HCPrice.getText().replaceAll("원", "")) + Integer.parseInt(ICPrice.getText().replaceAll("원", ""))
						+ Integer.parseInt(SHPrice.getText().replaceAll("원", "")) + Integer.parseInt(DRPrice.getText().replaceAll("원", ""))
						+ Integer.parseInt(CAPrice.getText().replaceAll("원", "")) + "");
				// 최종 가격
				String fp = Integer.toString(Integer.parseInt(TotalPrice) - Integer.parseInt(p));
				FP.setText(fp + "원");
				
			}
		});
		btnNewButton.setBounds(710, 345, 100, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("님 환영합니다.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(710, 290, 100, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel Point2 = new JLabel("사용할 포인트 : ");
		Point2.setBounds(537, 386, 92, 20);
		getContentPane().add(Point2);
		
		lblPoint2 = new JLabel("0원");
		lblPoint2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoint2.setFont(new Font("굴림", Font.BOLD, 14));
		lblPoint2.setBounds(639, 386, 170, 20);
		getContentPane().add(lblPoint2);
		
		FP = new JLabel("0원");
		FP.setHorizontalAlignment(SwingConstants.RIGHT);
		FP.setFont(new Font("굴림", Font.BOLD, 14));
		FP.setBounds(640, 416, 170, 20);
		getContentPane().add(FP);
		
		JLabel FinalPrice = new JLabel("최종가격 : ");
		FinalPrice.setBounds(537, 416, 60, 20);
		getContentPane().add(FinalPrice);
		
	}
}
