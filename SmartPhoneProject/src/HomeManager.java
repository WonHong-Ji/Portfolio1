import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

public class HomeManager extends JFrame implements ActionListener{

	//핸드폰 프레임
	JPanel phoneFramePanel;
	JLabel phoneFrameLabel;
	ImageIcon phoneFrameImage;
	
	//패널 샘플  - 이 패널에 맞춰서 작업하시면 됩니다.
	JPanel samplePanel;
	JLabel sampleLabel;
	ImageIcon sampleImage;
	
	JButton homeBtn;

	//홀드패널
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
    
	//메인화면패널
	HomeMainPanel_KHJ mainPanel;
	
	public HomeManager(){
		this.setTitle("SmartPhone Project");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize (450, 930);
		this.setLayout(null);
		//리사이징 금지
		this.setResizable(false);
		this. setLocationRelativeTo(this);
		
		//프레임 필드 초기화
		phoneFramePanel = new JPanel();
		phoneFrameImage = new ImageIcon("homeImage/phoneFrame.png");
		phoneFrameLabel = new JLabel(phoneFrameImage);	
		
		//샘플 필드 초기화
		samplePanel = new JPanel();
		samplePanel.setLayout(new BorderLayout());
		sampleImage = new ImageIcon("homeImage/panelSample.png");
		sampleLabel = new JLabel(sampleImage);
		
		//홈버튼 선언
		homeBtn = new JButton(" ");
		//홈버튼 그래픽 제거
		homeBtn.setBorderPainted(false);
		homeBtn.setContentAreaFilled(false);
		homeBtn.setFocusPainted(false);
		homeBtn.addActionListener(this);
		
		//홀드 필드 초기화
		homeHoldPanel_KHJ = new JPanel();
		//홀드필드 불투명
		mainPanel = new HomeMainPanel_KHJ(this);
		
		homeHoldPanel_KHJ.setLayout(null);
		//반투명이미지 셋팅
			darkPanel = new JPanel();
			darkImage = new ImageIcon("homeImage/holdScreen.png");
			darkLabel = new JLabel(darkImage);
			darkPanel.setLayout(new BorderLayout());
			darkPanel.setBackground(new Color(0, 0, 0, 50));
	
			//시계 UI
			clockPanel = new JPanel();	
			clockPanel.setBackground(new Color(0, 0, 0, 0));
			clockPanel.setLayout(new BoxLayout(clockPanel, BoxLayout.Y_AXIS));
			
			clockLabel = new JLabel(String.format("%02d:%02d", hour, min));
			Font timerFont = new Font("함초롬돋움", Font.PLAIN, 80);
			clockLabel.setFont(timerFont);
			clockLabel.setForeground(Color.WHITE);
	
			
			//날짜 UI
			dateLabel = new JLabel(year + "년 " + month + "월 " + date + "일 "+ dayOfWeek + "요일");
			Font dateFont = new Font("함초롬돋움", Font.PLAIN, 15);
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
			
			//마우스 이벤트
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

		
		//생성한 컴포넌트들을 컨테이너에 추가
		phoneFramePanel.add(phoneFrameLabel);		
		samplePanel.add(sampleLabel);
		
		this.add(homeBtn);
		this.add(homeHoldPanel_KHJ);
		this.add(mainPanel);
		this.add(samplePanel);
		this.add(phoneFramePanel);
		
		//this에 추가한 패널의 위치, 사이즈 조정 
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
			case 1: dayOfWeek = "일"; break;
			case 2: dayOfWeek = "월"; break;
			case 3: dayOfWeek = "화"; break;
			case 4: dayOfWeek = "수"; break;
			case 5: dayOfWeek = "목"; break;
			case 6: dayOfWeek = "금"; break;
			case 7: dayOfWeek = "토"; break;
		}
		
		dateLabel.setText(year + "년 " + (month + 1) + "월 " + date + "일 "+ dayOfWeek + "요일");
		
	}
	
	public static void main(String[] args) {
		new HomeManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getNowDate();		
		clockLabel.setText(String.format("%02d:%02d", hour, min));
		this.repaint();
		
		//홀드화면
		if(mainPanel.nowApp == 1 && !isDrag)
			mainPanel.nowApp = 0;
		//홀드화면이 아닐때 (메인화면)
		else if(mainPanel.nowApp == 0 && isDrag)
			mainPanel.nowApp = 1;
		
		
		if(e.getSource() == homeBtn){
			
			switch(mainPanel.nowApp){
			//홀드
			case 0:
				break;
			//메인
			case 1:
				isDrag = true;
				homeHoldPanel_KHJ.setVisible(true);
				mainPanel.setVisible(false);
				break;
			//배달
			case 2:
				mainPanel.setVisible(true);
				mainPanel.delivery.End();
				break;
			//카톡
			case 3:
				mainPanel.setVisible(true);
				mainPanel.kakao.End();
				break;
			//영화관
			case 4:
				mainPanel.setVisible(true);
				mainPanel.movie.End();
				break;
			//전화
			case 5:
				mainPanel.setVisible(true);
				mainPanel.callHome.End();
				break;
			//문자
			case 6:
				mainPanel.setVisible(true);
				mainPanel.message.End();
				break;
			//계산기
			case 7:
				mainPanel.setVisible(true);
				mainPanel.calculator.End();
				break;
			//갤러리
			case 8:
				mainPanel.setVisible(true);
				mainPanel.gallery.End();
				break;
			}
		}
		
	}	
}
