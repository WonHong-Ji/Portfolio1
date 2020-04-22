import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

import javax.swing.*;


public class HomeMainPanel_KHJ extends JPanel implements ActionListener{
	//버튼(아이콘)/레이블
	JButton callBtn, messageBtn, calculatorBtn, galleryBtn;
	JButton kakakoBtn, movieBtn, deliveryBtn;
	
	JLabel callLabel, messageLabel, calculatorLabel, galleryLabel;
	JLabel kakakoLabel, movieLabel, deliveryLabel;

	JPanel appPanel, centerAppPanel, southAppPanel;
	
	//현재 실행중인 앱. 1: 메인  | 2: 배달  | 3: 카카오톡  | 4: 영화관  | 5: 전화  | 6: 문자  | 7: 계산기  | 8: 갤러리
	int nowApp = 0;
	
	//======================================================================
	// 패널클래스 선언
	//======================================================================
	CallHome_KHJ callHome;
	DeliveryHome_KHJ delivery;
	HomeManager homeManager;
	static MessageClass_JWH message;
	CalculatorPanel_KDI calculator;
	MovieClass_JWH movie;
	KaKaoLogin_JSM kakao;
	Gallery_KDI gallery;
	static KakaoView1_JSM kakao_View1;
	
	HomeMainPanel_KHJ(HomeManager m){
		
		//메인화면 실행
		nowApp = 1;
		
		homeManager = m;
		delivery = new DeliveryHome_KHJ(this);
		callHome = new CallHome_KHJ(this);
		message = new MessageClass_JWH(this);
		calculator = new CalculatorPanel_KDI(this);
		movie = new MovieClass_JWH(this);
		kakao = new KaKaoLogin_JSM(this);
		gallery = new Gallery_KDI(this);
		kakao_View1 = new KakaoView1_JSM(); // 추가
		
		message.receiveMessage("김이름", "김이름님이 보낸 첫번째 메시지입니다.");
		message.receiveMessage("김이름", "김이름님이 보낸 두번째 메시지입니다.");
		message.receiveMessage("이이름", "이이름님이 보낸 첫번째 메시지입니다.");
		message.receiveMessage("나이름", "나이름님이 보낸 첫번째 메시지입니다.");
		message.receiveMessage("나이름", "나이름님이 보낸 두번째 메시지입니다.");
		message.receiveMessage("나이름", "나이름님이 보낸 세번째 메시지입니다.");
		message.receiveMessage("박이름", "박이름님이 보낸 첫번째 메시지입니다.");
		message.receiveMessage("이곳에 이름을 입력", "이곳에 내용을 입력");
		
		appPanel = new JPanel();
		centerAppPanel = new JPanel();
		southAppPanel = new JPanel();
		this.setLayout(null);
		centerAppPanel.setLayout(null);
		southAppPanel.setLayout(null);
		
		//======================================================================
		// 어플 버튼 선언
		//======================================================================
		deliveryBtn = new JButton(new ImageIcon("homeImage/appicon/delivery.png"));
		kakakoBtn = new JButton(new ImageIcon("homeImage/appicon/kakao.png"));
		movieBtn = new JButton(new ImageIcon("homeImage/appicon/movie.png"));
		
		callBtn = new JButton(new ImageIcon("homeImage/appicon/call.png"));
		messageBtn = new JButton(new ImageIcon("homeImage/appicon/message.png"));
		calculatorBtn = new JButton(new ImageIcon("homeImage/appicon/cal.png"));
		galleryBtn = new JButton(new ImageIcon("homeImage/appicon/gallery.png"));
		
		deliveryBtn.setBorderPainted(false);
		kakakoBtn.setBorderPainted(false);
		movieBtn.setBorderPainted(false);
		callBtn.setBorderPainted(false);
		messageBtn.setBorderPainted(false);
		calculatorBtn.setBorderPainted(false);
		galleryBtn.setBorderPainted(false);
		
		deliveryBtn.setContentAreaFilled(false);
		kakakoBtn.setContentAreaFilled(false);
		movieBtn.setContentAreaFilled(false);
		callBtn.setContentAreaFilled(false);
		messageBtn.setContentAreaFilled(false);
		calculatorBtn.setContentAreaFilled(false);
		galleryBtn.setContentAreaFilled(false);
		
		deliveryBtn.setFocusPainted(false);
		kakakoBtn.setFocusPainted(false);
		movieBtn.setFocusPainted(false);
		callBtn.setFocusPainted(false);
		messageBtn.setFocusPainted(false);
		calculatorBtn.setFocusPainted(false);
		galleryBtn.setFocusPainted(false);

		//======================================================================
		// 어플 이름 label 선언
		//======================================================================
		
		Font appFont = new Font("함초롬돋움", Font.PLAIN, 15);
		
		deliveryLabel = new JLabel("배달");	
		deliveryLabel.setFont(appFont);
		deliveryLabel.setForeground(Color.WHITE);
		kakakoLabel = new JLabel("카카오톡");
		kakakoLabel.setFont(appFont);
		kakakoLabel.setForeground(Color.WHITE);
		movieLabel = new JLabel("영화관");
		movieLabel.setFont(appFont);
		movieLabel.setForeground(Color.WHITE);
		
		callLabel = new JLabel("전화");
		callLabel.setFont(appFont);
		callLabel.setForeground(Color.WHITE);
		messageLabel = new JLabel("문자");
		messageLabel.setFont(appFont);
		messageLabel.setForeground(Color.WHITE);
		calculatorLabel = new JLabel("계산기");
		calculatorLabel.setFont(appFont);
		calculatorLabel.setForeground(Color.WHITE);
		galleryLabel = new JLabel("갤러리");
		galleryLabel.setFont(appFont);
		galleryLabel.setForeground(Color.WHITE);
		
		//======================================================================
		// 위치/사이즈 설정
		//======================================================================
	
		deliveryLabel.setBounds(45,110,70,70);
		kakakoLabel.setBounds(120,110,70,70);
		movieLabel.setBounds(213,110,70,70);
		
		deliveryBtn.setBounds(30,60,70,70);
		kakakoBtn.setBounds(115,60,70,70);
		movieBtn.setBounds(200,60,70,70);
		
		callLabel.setBounds(45,600,70,70);
		messageLabel.setBounds(135,600,70,70);
		calculatorLabel.setBounds(213,600,70,70);
		galleryLabel.setBounds(300,600,70,70);
		
		callBtn.setBounds(30,550,70,70);
		messageBtn.setBounds(115,550,70,70);
		calculatorBtn.setBounds(200,550,70,70);
		galleryBtn.setBounds(285,550,70,70);

		//======================================================================
		// panel 추가
		//======================================================================
		centerAppPanel.add(deliveryBtn);
		centerAppPanel.add(kakakoBtn);
		centerAppPanel.add(movieBtn);

		centerAppPanel.add(deliveryLabel);
		centerAppPanel.add(kakakoLabel);
		centerAppPanel.add(movieLabel);
		
		southAppPanel.add(callBtn);
		southAppPanel.add(messageBtn);
		southAppPanel.add(calculatorBtn);
		southAppPanel.add(galleryBtn);
		
		southAppPanel.add(callLabel);
		southAppPanel.add(messageLabel);
		southAppPanel.add(calculatorLabel);
		southAppPanel.add(galleryLabel);
		
		add(southAppPanel);
		add(centerAppPanel);
		
		this.southAppPanel.setBounds(0, 0, 378, 674);
		this.centerAppPanel.setBounds(0, 0, 378, 674);
		
		//======================================================================
		// panel 투명화
		//======================================================================
		southAppPanel.setBackground(new Color(0, 0, 0, 0));
		centerAppPanel.setBackground(new Color(0, 0, 0, 0));
		this.setBackground(new Color(0, 0, 0, 0));
		
		//======================================================================
		// 버튼액션
		//======================================================================
		
		callBtn.addActionListener(this);
		messageBtn.addActionListener(this);
		calculatorBtn.addActionListener(this);
		galleryBtn.addActionListener(this);

		kakakoBtn.addActionListener(this);
		movieBtn.addActionListener(this);
		deliveryBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deliveryBtn){
			//배달어플 실행
			nowApp = 2;
			add(delivery);
			delivery.setVisible(true);
			this.delivery.setBounds(0, 0, 378, 674);
			setOffHome();
			delivery.loading();
		}
		else if(e.getSource() == kakakoBtn){
			//카카오톡어플 실행
			nowApp = 3;
			add(kakao);
			kakao.setVisible(true);
			this.kakao.setBounds(0, 0, 378, 674);
			setOffHome();
			kakao.loading();
		}
		else if(e.getSource() == movieBtn){
			//영화관어플 실행
			nowApp = 4;
			add(movie);
			movie.setVisible(true);
			this.movie.setBounds(0, 0, 378, 674);
			setOffHome();
		}
		
		else if(e.getSource() == callBtn){
			//전화어플 실행
			nowApp = 5;
			add(callHome);
			callHome.setVisible(true);
			this.callHome.setBounds(0, 0, 378, 674);
			setOffHome();
		}
		else if(e.getSource() == messageBtn){
			//메세지어플 실행
			nowApp = 6;
			add(message);
			message.setVisible(true);
			this.message.setBounds(0, 0, 378, 674);
			setOffHome();
		}
		else if(e.getSource() == calculatorBtn){
			//계산기어플 실행
			nowApp = 7;
			add(calculator);
			calculator.setVisible(true);
			this.calculator.setBounds(0, 0, 378, 674);
			setOffHome();
		}
		else if(e.getSource() == galleryBtn){
			//갤러리어플 실행
			nowApp = 8;
			add(gallery);
			gallery.setVisible(true);
			this.gallery.setBounds(0, 0, 378, 674);
			setOffHome();
		}
	}
	
	public void setOnHome(){
		southAppPanel.setVisible(true);
		centerAppPanel.setVisible(true);
		homeManager.samplePanel.setVisible(true);
	}
	
	public void setOffHome(){
		southAppPanel.setVisible(false);
		centerAppPanel.setVisible(false);
		homeManager.samplePanel.setVisible(false);
	}

}
