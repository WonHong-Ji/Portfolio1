import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

import javax.swing.*;

public class DeliveryHome_KHJ extends JPanel implements ActionListener{
	
	//�ϴ� �� ��ư
	JButton homeBtn, orderBtn, myBtn, exitBtn; 
	
	//�ε��г�
	JPanel loadingPanel;
	JLabel loadingLabel;
	
	//Ȩ�� ���� �г�
	JPanel homePanel, homeCenterPanel, tabPanel, eventPanel, selectPanel, searchPanel, noticePanel;
	
	//�̺�Ʈ ��� ���� ���̺�
	JLabel eventLabel;
	//�������� ��� ������ ��ư
	JButton delIconBtn[] = new JButton[16];
	
	//����, �������� ���̺�
	JLabel noticeLabel, noticeContentsLabel;
	
	HomeMainPanel_KHJ mainHome;
	
	public DeliveryHome_KHJ(JPanel mainHomePanel){
		
		//�������� �Ű������� �޾ƿ� HomeMainPanel_KHJ�� ���� (�����)
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		//�ش� ���̾�α��� ���̾ƿ� ����
		this.setLayout(new BorderLayout());
		
		//����� ���� �г� ����
		homePanel = new JPanel();
		selectPanel = new JPanel();
		tabPanel = new JPanel();
		eventPanel = new JPanel();
		selectPanel = new JPanel();
		noticePanel = new JPanel();
		homeCenterPanel = new JPanel();
		
		//�г� ���̾ƿ� ����
		homePanel.setLayout(new BorderLayout());
		tabPanel.setLayout(new GridLayout(0, 4));
		eventPanel.setLayout(new BorderLayout());
		selectPanel.setLayout(new GridLayout(0, 4));
		homeCenterPanel.setLayout(new BorderLayout());
		
		//�г� ���� ����
		this.setBackground(Color.WHITE);
		selectPanel.setBackground(Color.WHITE);
		tabPanel.setBackground(new Color(245,245,245));
		
		//======================================================================
		// ���г�
		//======================================================================

		//�ϴ� �ǹ�ư ����
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
		// Ȩ�г�
		//======================================================================
		
		eventLabel = new JLabel (new ImageIcon("homeImage/deliveryImg/Event_1.png"));
		eventPanel.add(eventLabel);
		
		//�������� ��ư �̹������ �� �߰�
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
		
		noticeLabel = new JLabel("����");
		JLabel empthyLabel = new JLabel(" | ");
		noticeContentsLabel = new JLabel("������ �ý��� ���� (AM05:00 ~ AM05:40)");
		
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
	
	//�ε�ȭ���� ���� ������ ����Ŭ����
	class MyThread extends Thread{
		@Override
		public void run() {
			//�����忡 ������ �ε�ȭ���� �׸���
			loadDraw();
				try {
					//2�� ��
					Thread.sleep(1000);
					//�׷ȴ� �г��� �����Ѵ�
					loadDestroy();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	//�ε��߿� �׸� �гθ޼ҵ�
	public void loadDraw(){
		loadingPanel = new JPanel();
		loadingPanel.setLayout(new BorderLayout());
		loadingLabel = new JLabel(new ImageIcon("homeImage/deliveryImg/loading.png"));
		loadingPanel.add(loadingLabel);
		this.add(loadingPanel);
		revalidate();
		repaint();
	}
	//�ε��Ŀ� ���� �г� �޼ҵ�
	public void loadDestroy(){
		this.remove(loadingPanel);
		this.add(homePanel);
		revalidate();
		repaint();
	}
	//�ε��� �����ϸ� ����Ŭ������ �����Ͽ� �������ش�
	public void loading(){
		new MyThread().start();		
	}
	
	//��ư�� �⺻ �׵θ��� �⺻ ����� �����ϴ� �޼ҵ� 
	public void btnUIRemove(JButton btn){
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}
	
	//����ÿ� ȣ���ϴ� �޼�
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