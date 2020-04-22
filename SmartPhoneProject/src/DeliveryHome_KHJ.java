import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

import javax.swing.*;

public class DeliveryHome_KHJ extends JPanel implements ActionListener{
	
	//하단 탭 버튼
	JButton homeBtn, orderBtn, myBtn, exitBtn; 
	
	//로딩패널
	JPanel loadingPanel;
	JLabel loadingLabel;
	
	//홈에 들어가는 패널
	JPanel homePanel, homeCenterPanel, tabPanel, eventPanel, selectPanel, searchPanel, noticePanel;
	
	//이벤트 배너 담을 레이블
	JLabel eventLabel;
	//가게종류 담는 아이콘 버튼
	JButton delIconBtn[] = new JButton[16];
	
	//공지, 공지내용 레이블
	JLabel noticeLabel, noticeContentsLabel;
	
	HomeMainPanel_KHJ mainHome;
	
	public DeliveryHome_KHJ(JPanel mainHomePanel){
		
		//생성자의 매개변수로 받아온 HomeMainPanel_KHJ을 저장 (종료용)
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		//해당 다이얼로그의 레이아웃 설정
		this.setLayout(new BorderLayout());
		
		//사용할 각종 패널 생성
		homePanel = new JPanel();
		selectPanel = new JPanel();
		tabPanel = new JPanel();
		eventPanel = new JPanel();
		selectPanel = new JPanel();
		noticePanel = new JPanel();
		homeCenterPanel = new JPanel();
		
		//패널 레이아웃 설정
		homePanel.setLayout(new BorderLayout());
		tabPanel.setLayout(new GridLayout(0, 4));
		eventPanel.setLayout(new BorderLayout());
		selectPanel.setLayout(new GridLayout(0, 4));
		homeCenterPanel.setLayout(new BorderLayout());
		
		//패널 색상 변경
		this.setBackground(Color.WHITE);
		selectPanel.setBackground(Color.WHITE);
		tabPanel.setBackground(new Color(245,245,245));
		
		//======================================================================
		// 탭패널
		//======================================================================

		//하단 탭버튼 생성
		homeBtn = new JButton(new ImageIcon("homeImage/deliveryImg/homeTabIcon.png"));
		orderBtn = new JButton(new ImageIcon("homeImage/deliveryImg/orderTabIcon.png"));
		myBtn = new JButton(new ImageIcon("homeImage/deliveryImg/myTabIcon.png"));
		exitBtn = new JButton(new ImageIcon("homeImage/deliveryImg/exitTabIcon.png"));
		
		// 
		btnUIRemove(homeBtn);
		btnUIRemove(orderBtn);
		btnUIRemove(myBtn);
		btnUIRemove(exitBtn);

		tabPanel.add(homeBtn);
		tabPanel.add(orderBtn);
		tabPanel.add(myBtn);
		tabPanel.add(exitBtn);
		
		//======================================================================
		// 홈패널
		//======================================================================
		
		eventLabel = new JLabel (new ImageIcon("homeImage/deliveryImg/Event_1.png"));
		eventPanel.add(eventLabel);
		
		//음식종류 버튼 이미지배당 후 추가
		delIconBtn[0] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/koreanFood.png"));
		delIconBtn[1] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/cafeFood.png"));
		delIconBtn[2] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/snackFood.png"));
		delIconBtn[3] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		
		delIconBtn[4] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[5] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[6] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[7] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		
		delIconBtn[8] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[9] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[10] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[11] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		
		delIconBtn[12] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[13] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[14] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));
		delIconBtn[15] = new JButton(new ImageIcon("homeImage/deliveryImg/DelIcon/emptyFood.png"));

		for(int i = 0; i < delIconBtn.length; i++){
			selectPanel.add(delIconBtn[i]);
			btnUIRemove(delIconBtn[i]);
			delIconBtn[i].addActionListener(this);
		}
		
		noticeLabel = new JLabel("공지");
		JLabel empthyLabel = new JLabel(" | ");
		noticeContentsLabel = new JLabel("고객센터 시스템 점검 (AM05:00 ~ AM05:40)");
		
		noticePanel.setLayout(new FlowLayout((FlowLayout.LEADING)));
		
		noticePanel.add(noticeLabel);
		noticePanel.add(empthyLabel);
		noticePanel.add(noticeContentsLabel);
		
		homeCenterPanel.add(selectPanel, "North");
		homeCenterPanel.add(noticePanel,"South");
		
		homePanel.add(eventPanel,"North");
		homePanel.add(homeCenterPanel,"Center");
		homePanel.add(tabPanel,"South");
		
		exitBtn.addActionListener(this);
		orderBtn.addActionListener(this);
		myBtn.addActionListener(this);
		
	}
	
	//로딩화면을 위한 스레드 내부클래스
	class MyThread extends Thread{
		@Override
		public void run() {
			//스레드에 들어오면 로딩화면을 그린다
			loadDraw();
				try {
					//2초 후
					Thread.sleep(1000);
					//그렸던 패널을 삭제한다
					loadDestroy();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	//로딩중에 그릴 패널메소드
	public void loadDraw(){
		loadingPanel = new JPanel();
		loadingPanel.setLayout(new BorderLayout());
		loadingLabel = new JLabel(new ImageIcon("homeImage/deliveryImg/loading.png"));
		loadingPanel.add(loadingLabel);
		this.add(loadingPanel);
		revalidate();
		repaint();
	}
	//로딩후에 지울 패널 메소드
	public void loadDestroy(){
		this.remove(loadingPanel);
		this.add(homePanel);
		revalidate();
		repaint();
	}
	//로딩을 시작하면 내부클래스를 생성하여 시작해준다
	public void loading(){
		new MyThread().start();		
	}
	
	//버튼의 기본 테두리나 기본 배경을 삭제하는 메소드 
	public void btnUIRemove(JButton btn){
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}
	
	//종료시에 호출하는 메소
	public void End(){
		this.remove(homePanel);
		this.setVisible(false);
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitBtn){
			End();
		}
		else if(e.getSource() == orderBtn){
			new DeliveryBasket_KHJ(this);
		}
		else if(e.getSource() == myBtn){
			new DeliveryOrderHistory_KHJ(this);
		}
		
		else{
			for(int i = 0; i < delIconBtn.length; i++){
				if(e.getSource() == delIconBtn[i]){
					if(i == 0){
						DeliveryOrder_KHJ del = new DeliveryOrder_KHJ(this,0);
					}
					else if(i == 1){
						DeliveryOrder_KHJ del = new DeliveryOrder_KHJ(this,1);
					}
					else if(i == 2){
						DeliveryOrder_KHJ del = new DeliveryOrder_KHJ(this,2);
					}
					
				}
			}
		}
	}
}