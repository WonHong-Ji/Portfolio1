import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

import javax.swing.*;


public class HomeMainPanel_KHJ extends JPanel implements ActionListener{
	//��ư(������)/���̺�
	JButton callBtn, messageBtn, calculatorBtn, galleryBtn;
	JButton kakakoBtn, movieBtn, deliveryBtn;
	
	JLabel callLabel, messageLabel, calculatorLabel, galleryLabel;
	JLabel kakakoLabel, movieLabel, deliveryLabel;

	JPanel appPanel, centerAppPanel, southAppPanel;
	
	//���� �������� ��. 1: ����  | 2: ���  | 3: īī����  | 4: ��ȭ��  | 5: ��ȭ  | 6: ����  | 7: ����  | 8: ������
	int nowApp = 0;
	
	//======================================================================
	// �г�Ŭ���� ����
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
		
		//����ȭ�� ����
		nowApp = 1;
		
		homeManager = m;
		delivery = new DeliveryHome_KHJ(this);
		callHome = new CallHome_KHJ(this);
		message = new MessageClass_JWH(this);
		calculator = new CalculatorPanel_KDI(this);
		movie = new MovieClass_JWH(this);
		kakao = new KaKaoLogin_JSM(this);
		gallery = new Gallery_KDI(this);
		kakao_View1 = new KakaoView1_JSM(); // �߰�
		
		message.receiveMessage("���̸�", "���̸����� ���� ù��° �޽����Դϴ�.");
		message.receiveMessage("���̸�", "���̸����� ���� �ι�° �޽����Դϴ�.");
		message.receiveMessage("���̸�", "���̸����� ���� ù��° �޽����Դϴ�.");
		message.receiveMessage("���̸�", "���̸����� ���� ù��° �޽����Դϴ�.");
		message.receiveMessage("���̸�", "���̸����� ���� �ι�° �޽����Դϴ�.");
		message.receiveMessage("���̸�", "���̸����� ���� ����° �޽����Դϴ�.");
		message.receiveMessage("���̸�", "���̸����� ���� ù��° �޽����Դϴ�.");
		message.receiveMessage("�̰��� �̸��� �Է�", "�̰��� ������ �Է�");
		
		appPanel = new JPanel();
		centerAppPanel = new JPanel();
		southAppPanel = new JPanel();
		this.setLayout(null);
		centerAppPanel.setLayout(null);
		southAppPanel.setLayout(null);
		
		//======================================================================
		// ���� ��ư ����
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
		// ���� �̸� label ����
		//======================================================================
		
		Font appFont = new Font("���ʷҵ���", Font.PLAIN, 15);
		
		deliveryLabel = new JLabel("���");	
		deliveryLabel.setFont(appFont);
		deliveryLabel.setForeground(Color.WHITE);
		kakakoLabel = new JLabel("īī����");
		kakakoLabel.setFont(appFont);
		kakakoLabel.setForeground(Color.WHITE);
		movieLabel = new JLabel("��ȭ��");
		movieLabel.setFont(appFont);
		movieLabel.setForeground(Color.WHITE);
		
		callLabel = new JLabel("��ȭ");
		callLabel.setFont(appFont);
		callLabel.setForeground(Color.WHITE);
		messageLabel = new JLabel("����");
		messageLabel.setFont(appFont);
		messageLabel.setForeground(Color.WHITE);
		calculatorLabel = new JLabel("����");
		calculatorLabel.setFont(appFont);
		calculatorLabel.setForeground(Color.WHITE);
		galleryLabel = new JLabel("������");
		galleryLabel.setFont(appFont);
		galleryLabel.setForeground(Color.WHITE);
		
		//======================================================================
		// ��ġ/������ ����
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
		// panel �߰�
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
		// panel ����ȭ
		//======================================================================
		southAppPanel.setBackground(new Color(0, 0, 0, 0));
		centerAppPanel.setBackground(new Color(0, 0, 0, 0));
		this.setBackground(new Color(0, 0, 0, 0));
		
		//======================================================================
		// ��ư�׼�
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
			//��޾��� ����
			nowApp = 2;
			add(delivery);
			delivery.setVisible(true);
			this.delivery.setBounds(0, 0, 378, 674);
			setOffHome();
			delivery.loading();
		}
		else if(e.getSource() == kakakoBtn){
			//īī������� ����
			nowApp = 3;
			add(kakao);
			kakao.setVisible(true);
			this.kakao.setBounds(0, 0, 378, 674);
			setOffHome();
			kakao.loading();
		}
		else if(e.getSource() == movieBtn){
			//��ȭ������ ����
			nowApp = 4;
			add(movie);
			movie.setVisible(true);
			this.movie.setBounds(0, 0, 378, 674);
			setOffHome();
		}
		
		else if(e.getSource() == callBtn){
			//��ȭ���� ����
			nowApp = 5;
			add(callHome);
			callHome.setVisible(true);
			this.callHome.setBounds(0, 0, 378, 674);
			setOffHome();
		}
		else if(e.getSource() == messageBtn){
			//�޼������� ����
			nowApp = 6;
			add(message);
			message.setVisible(true);
			this.message.setBounds(0, 0, 378, 674);
			setOffHome();
		}
		else if(e.getSource() == calculatorBtn){
			//������� ����
			nowApp = 7;
			add(calculator);
			calculator.setVisible(true);
			this.calculator.setBounds(0, 0, 378, 674);
			setOffHome();
		}
		else if(e.getSource() == galleryBtn){
			//���������� ����
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
