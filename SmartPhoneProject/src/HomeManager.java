import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

public class HomeManager extends JFrame implements ActionListener{

	//�ڵ��� ������
	JPanel phoneFramePanel;
	JLabel phoneFrameLabel;
	ImageIcon phoneFrameImage;
	
	//�г� ����  - �� �гο� ���缭 �۾��Ͻø� �˴ϴ�.
	JPanel samplePanel;
	JLabel sampleLabel;
	ImageIcon sampleImage;
	
	JButton homeBtn;

	//Ȧ���г�
	private JPanel homeHoldPanel_KHJ;
	private JPanel darkPanel;
	private JLabel darkLabel;
	private ImageIcon darkImage;
	
	
	private JPanel clockPanel;
	private JLabel clockLabel;
	private JLabel dateLabel;
	
	Calendar calendar; 
    int hour; 
    int min; 
    
    int year; 
	int month; 
	int date; 
	int week; 
	String dayOfWeek = "";
	
    javax.swing.Timer timer; 
    
    boolean isDrag = false;
    int dragStack = 0;
    
	//����ȭ���г�
	HomeMainPanel_KHJ mainPanel;
	
	public HomeManager(){
		this.setTitle("SmartPhone Project");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize (450, 930);
		this.setLayout(null);
		//������¡ ����
		this.setResizable(false);
		this. setLocationRelativeTo(this);
		
		//������ �ʵ� �ʱ�ȭ
		phoneFramePanel = new JPanel();
		phoneFrameImage = new ImageIcon("homeImage/phoneFrame.png");
		phoneFrameLabel = new JLabel(phoneFrameImage);	
		
		//���� �ʵ� �ʱ�ȭ
		samplePanel = new JPanel();
		samplePanel.setLayout(new BorderLayout());
		sampleImage = new ImageIcon("homeImage/panelSample.png");
		sampleLabel = new JLabel(sampleImage);
		
		//Ȩ��ư ����
		homeBtn = new JButton(" ");
		//Ȩ��ư �׷��� ����
		homeBtn.setBorderPainted(false);
		homeBtn.setContentAreaFilled(false);
		homeBtn.setFocusPainted(false);
		homeBtn.addActionListener(this);
		
		//Ȧ�� �ʵ� �ʱ�ȭ
		homeHoldPanel_KHJ = new JPanel();
		//Ȧ���ʵ� ������
		mainPanel = new HomeMainPanel_KHJ(this);
		
		homeHoldPanel_KHJ.setLayout(null);
		//�������̹��� ����
			darkPanel = new JPanel();
			darkImage = new ImageIcon("homeImage/holdScreen.png");
			darkLabel = new JLabel(darkImage);
			darkPanel.setLayout(new BorderLayout());
			darkPanel.setBackground(new Color(0, 0, 0, 50));
	
			//�ð� UI
			clockPanel = new JPanel();	
			clockPanel.setBackground(new Color(0, 0, 0, 0));
			clockPanel.setLayout(new BoxLayout(clockPanel, BoxLayout.Y_AXIS));
			
			clockLabel = new JLabel(String.format("%02d:%02d", hour, min));
			Font timerFont = new Font("���ʷҵ���", Font.PLAIN, 80);
			clockLabel.setFont(timerFont);
			clockLabel.setForeground(Color.WHITE);
	
			
			//��¥ UI
			dateLabel = new JLabel(year + "�� " + month + "�� " + date + "�� "+ dayOfWeek + "����");
			Font dateFont = new Font("���ʷҵ���", Font.PLAIN, 15);
			dateLabel.setFont(dateFont);
			dateLabel.setForeground(Color.WHITE);
			
			darkPanel.add(darkLabel);
			clockPanel.add(clockLabel);
			clockPanel.add(dateLabel);
			
			darkPanel.setBounds(0, 0, 378, 674);
			clockPanel.setBounds(100, 50, 378, 674);
			
			homeHoldPanel_KHJ.add(clockPanel);
			homeHoldPanel_KHJ.add(darkPanel);
			
			getNowDate();
			
			timer = new javax.swing.Timer(1000, this);
			timer.setInitialDelay(0);
			timer.start();
			
			//���콺 �̺�Ʈ
			homeHoldPanel_KHJ.addMouseMotionListener(new MouseMotionListener() {
						
			@Override
			public void mouseMoved(MouseEvent arg0) {	}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				dragStack ++;
					if(dragStack >= 35){
						isDrag = true;
						dragStack = 0;
						mainPanel.setVisible(false);
					}
				}
			});
			
			homeHoldPanel_KHJ.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(dragStack >= 15){
					isDrag = true;
					homeHoldPanel_KHJ.setVisible(false);
					mainPanel.setVisible(true);
				}
				dragStack = 0;
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});

		
		//������ ������Ʈ���� �����̳ʿ� �߰�
		phoneFramePanel.add(phoneFrameLabel);		
		samplePanel.add(sampleLabel);
		
		this.add(homeBtn);
		this.add(homeHoldPanel_KHJ);
		this.add(mainPanel);
		this.add(samplePanel);
		this.add(phoneFramePanel);
		
		//this�� �߰��� �г��� ��ġ, ������ ���� 
		this.phoneFramePanel.setBounds(5, 0, 437, 932);
		this.samplePanel.setBounds(34, 114, 378, 674);
		this.homeHoldPanel_KHJ.setBounds(34, 114, 378, 674);
		this.mainPanel.setBounds(34, 114, 378, 674);
		this.homeBtn.setBounds(195, 810, 60, 60);
		
		
		mainPanel.setVisible(false);
		this.setVisible(true);
	}
	
	public void getNowDate(){
		
		calendar = Calendar.getInstance();
		
		hour = calendar.get(Calendar.HOUR_OF_DAY); 
		min = calendar.get(Calendar.MINUTE);
		year = calendar.get(Calendar.YEAR); 
		month = calendar.get(Calendar.MONTH); 
		date = calendar.get(Calendar.DATE); 
		week = calendar.get(Calendar.DAY_OF_WEEK); 
		
		switch(week){
			case 1: dayOfWeek = "��"; break;
			case 2: dayOfWeek = "��"; break;
			case 3: dayOfWeek = "ȭ"; break;
			case 4: dayOfWeek = "��"; break;
			case 5: dayOfWeek = "��"; break;
			case 6: dayOfWeek = "��"; break;
			case 7: dayOfWeek = "��"; break;
		}
		
		dateLabel.setText(year + "�� " + (month + 1) + "�� " + date + "�� "+ dayOfWeek + "����");
		
	}
	
	public static void main(String[] args) {
		new HomeManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getNowDate();		
		clockLabel.setText(String.format("%02d:%02d", hour, min));
		this.repaint();
		
		//Ȧ��ȭ��
		if(mainPanel.nowApp == 1 && !isDrag)
			mainPanel.nowApp = 0;
		//Ȧ��ȭ���� �ƴҶ� (����ȭ��)
		else if(mainPanel.nowApp == 0 && isDrag)
			mainPanel.nowApp = 1;
		
		
		if(e.getSource() == homeBtn){
			
			switch(mainPanel.nowApp){
			//Ȧ��
			case 0:
				break;
			//����
			case 1:
				isDrag = true;
				homeHoldPanel_KHJ.setVisible(true);
				mainPanel.setVisible(false);
				break;
			//���
			case 2:
				mainPanel.setVisible(true);
				mainPanel.delivery.End();
				break;
			//ī��
			case 3:
				mainPanel.setVisible(true);
				mainPanel.kakao.End();
				break;
			//��ȭ��
			case 4:
				mainPanel.setVisible(true);
				mainPanel.movie.End();
				break;
			//��ȭ
			case 5:
				mainPanel.setVisible(true);
				mainPanel.callHome.End();
				break;
			//����
			case 6:
				mainPanel.setVisible(true);
				mainPanel.message.End();
				break;
			//����
			case 7:
				mainPanel.setVisible(true);
				mainPanel.calculator.End();
				break;
			//������
			case 8:
				mainPanel.setVisible(true);
				mainPanel.gallery.End();
				break;
			}
		}
		
	}	
}
