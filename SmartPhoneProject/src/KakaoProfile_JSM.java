import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class KakaoProfile_JSM extends JDialog{
	KakaoView1_JSM view; //view1.java불러오기
	JPanel profile_Center; //센터와 남쪽으로 나눈다
	JPanel profile_South;
	int userNum = 20;
	//center
	ImageIcon icon;
	JButton profile_profileimage;
	JLabel profile_Name;
	JButton[] profile_PhoneNum; //휴대폰번호
	JPanel[] profile_user ;
	
	//south
	JButton profile_btn1; //1:1채팅
	JButton profile_btn2; // 무료통화(카카오톡 통화)
	JButton profile_btn3; // 카카오스토리
	
	public KakaoProfile_JSM(KakaoView1_JSM view, int userNum){
	setSize(378,674);
	getContentPane().setBackground(Color.white);
	setLocationRelativeTo(null);
	setLayout(new BorderLayout());
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.view = view;		
	this.userNum =userNum;
	
	
	//Center
	profile_Center = new JPanel() {
		ImageIcon backGround = new ImageIcon("images/backGround/background1.jpg");
		Image backGround1 = backGround.getImage();
		Image backGround2 = backGround1.getScaledInstance(378, 400,
				Image.SCALE_SMOOTH);
		ImageIcon backGround3 = new ImageIcon(backGround2);
		
		public void paintComponent(Graphics g) {
			g.drawImage(backGround3.getImage(), 0, 0, null);
			profile_Center.setOpaque(false);
			super.paintComponent(g);
		}
	};
	
	profile_Center.setLayout(null);

	profile_Center.setBounds(0,0,800,800);
	profile_PhoneNum = new JButton[userNum];
	profile_user =new JPanel[userNum];
	profileMake();
	add(profile_Center,"Center");
	//하단
	profile_South =new JPanel(new FlowLayout(FlowLayout.CENTER));
	profile_btn1 =new JButton( new ImageIcon("images/Profile/btn1.PNG"));
	profile_btn2 =new JButton( new ImageIcon("images/Profile/btn2.PNG"));
	profile_btn3 =new JButton( new ImageIcon("images/Profile/btn3.PNG"));
	profile_South.setBackground(Color.WHITE);
	profile_South.add(profile_btn1);
	profile_South.add(profile_btn2);
	profile_South.add(profile_btn3);
	profile_btn1.setFocusPainted(false);
	profile_btn1.setContentAreaFilled(false);
	profile_btn1.setBorderPainted(false);
	profile_btn2.setFocusPainted(false);
	profile_btn2.setContentAreaFilled(false);
	profile_btn2.setBorderPainted(false);
	profile_btn3.setFocusPainted(false);
	profile_btn3.setContentAreaFilled(false);
	profile_btn3.setBorderPainted(false);
	add(profile_South,"South");
	setVisible(true);
	
	 
	}
   
	public void profileMake() {
		for (int i = 0; i < 9; i++) {
			profile_PhoneNum[i] =new JButton();
			profile_PhoneNum[i].setText(view.phoneNum[i].getText());
			profile_PhoneNum[i].setFocusPainted(false);
			profile_PhoneNum[i].setContentAreaFilled(false);
			profile_PhoneNum[i].setBackground(Color.WHITE);
			profile_PhoneNum[i].setBorderPainted(false);
			profile_user[i] =new JPanel();
			profile_user[i].setBounds(0,350,378,600);
			profile_user[i].setOpaque(false);
			//profile_user[i].setBackground(new Color(0,0,0,0));
			profile_user[i].setLayout(new FlowLayout(FlowLayout.CENTER));
			profile_user[i].add(view.profileimageC[i]);
			profile_user[i].add(view.userState[i]);
			//view.userState[i].setBounds(400, 300, 200, 200);
			//profile_PhoneNum[i].setBounds(20, 160, 150, 30);
			view.userName[i].setPreferredSize(new Dimension(378,50));
			view.userName[i].setHorizontalAlignment(view.userName[i].CENTER);
			profile_PhoneNum[i].setPreferredSize(new Dimension(378,20));
			//view.profileimageC[i].setBounds(0,0,102,172);
			view.profileimageC[i].setPreferredSize(new Dimension(378,100));
			view.profileimageC[i].setFocusPainted(false);
			view.profileimageC[i].setBorderPainted(false);
			view.profileimageC[i].setContentAreaFilled(false);
			view.userName[i].setForeground(Color.BLACK);
			profile_user[i].add(view.userName[i]);
			//view.userName[i].setBounds(30,100,4,400);
			
			profile_user[i].add(view.userName[i]);
			profile_user[i].add(profile_PhoneNum[i]);
			//profile_user[i].add(view.userState[i]);
		
		}
	}
	
	public void  profileChange(){
		
	}
	
	
}
