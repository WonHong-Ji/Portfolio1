import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//인증번호창 부모클래스
//이름앞에 클래스이름붙임
class KaKaoLogin2_JSM extends JDialog implements ActionListener {
	JPanel login2_top; //상단
	JPanel login2_center;//중단
	JPanel login2_center_center; //센터의 센터 패널
	JPanel login2_bottom;//하단
	JLabel login2_toplabel;//
	JLabel login2_ment; //30분남았다는말
	JTextField login2_confirm ;//인증번호창
	JButton login2_ok;//확인 버튼
	JButton login2_ipin; //아이핀
	JButton login2_send; //전송
	JButton message; //인증번호
	JButton message2;
	Font login2_font1= new Font("나눔고딕",Font.BOLD,15);
	KakaoView1_JSM view;
	JPanel login2_top_top;//상단의 인증창의 패널
	Color login2_kakaotalk =new Color(250,235,51); //색상
	Color login2_background =new Color(250,250,250); 
	JPanel loginPanel;


	KaKaoLogin2_JSM(JPanel panel, String t){
		//super(frame,t);
		this.setModal(true);
		this.setUndecorated(true);
		setSize(378,674);
		setLocationRelativeTo(panel);
		loginPanel = panel;
		//상단
		
		login2_top =new JPanel(new BorderLayout());
		
		login2_top_top =new JPanel();//상단의 인증창의 패널
		login2_top_top.setLayout(new BoxLayout(login2_top_top,BoxLayout.Y_AXIS));
		
		login2_toplabel =new JLabel(new ImageIcon("images/logo.png")); //로고
		login2_top.setBackground(login2_kakaotalk);
		//login2_top.add(login2_top_top,"North");
		login2_top.add(login2_toplabel,"Center");
		add(login2_top,"North");
		
		//센터
		login2_center =new JPanel();
		login2_center.setBorder(BorderFactory.createEmptyBorder(0 , 30 , 0 , 30));
		login2_center.setLayout(new GridLayout(15,1));
		login2_center.setBackground(login2_kakaotalk);
		login2_center_center=new JPanel(new GridLayout(0,2)); //버튼한곳에 모으기위해
		login2_confirm =new JTextField(); //인증번호 입력창
		login2_ment =new JLabel("원활한 이용을 위해 본인인증을 완료해주세요");
		login2_ment.setHorizontalAlignment(login2_ment.CENTER);
		
		login2_ment.setForeground(Color.GRAY);
		login2_ok =new JButton("확인");
		login2_ok.setFont(login2_font1);
		login2_ok.setEnabled(false);
		login2_send =new JButton("문자메시지로 찾기");
		login2_send.setFont(login2_font1);
		login2_send.addActionListener(this);
	
		login2_ipin =new JButton("아이핀으로찾기");
		login2_ipin.setFont(login2_font1);
		login2_ok.setBackground(login2_kakaotalk);
		//login2_ok.setFocusPainted(false);
		//login2_ok.setContentAreaFilled(false);
		login2_ok.addActionListener(this);
		login2_ok.setBorderPainted(false);
		login2_send.setBorderPainted(false);
		login2_ipin.setBorderPainted(false);
		login2_send.setBackground(login2_kakaotalk);
		login2_ipin.setBackground(login2_kakaotalk);
		login2_center_center.add(login2_send);
		login2_center_center.add(login2_ipin);
		login2_center.add(login2_ment);
		login2_center.add(login2_confirm);
		login2_center.add(login2_center_center);
		login2_center.add(login2_ok);
		add(login2_center,"Center");
		//하단
		
		 login2_bottom = new JPanel();
		 login2_bottom.setBackground(login2_kakaotalk);
		 add(login2_bottom,"South");
		 setVisible(true);
	
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login2_send){
			login2_top_top.setLayout(new BoxLayout(login2_top_top,BoxLayout.Y_AXIS));
			login2_top_top.setBackground(login2_background);
			message =new JButton(new ImageIcon("images/message1.png"));
			message2 =new JButton(new ImageIcon("images/message4.png"));
			message.addActionListener(this);
			login2_top_top.add(message);
			login2_top_top.add(message2);
			login2_top.add(login2_top_top,"North");
			message.setBackground(login2_kakaotalk);
			message.addActionListener(this);
			message2.setBorderPainted(false);  //로그인버튼 모양을 남기기위해서
			message2.setFocusPainted(false);
			message2.setContentAreaFilled(false);
			message.setBorderPainted(false);  //로그인버튼 모양을 남기기위해서
			message.setFocusPainted(false);
			message.setContentAreaFilled(false);
		}else if(e.getSource() ==message){
			login2_confirm.setText("684224");
			login2_ok.setEnabled(true);
			login2_top_top.setVisible(false);
		}else if(e.getSource() == login2_ok){			
			//인증 종료 후 모든 창을 닫아준다
			loginPanel.removeAll();
			this.dispose();
			
			loginPanel.add(HomeMainPanel_KHJ.kakao_View1);
			loginPanel.revalidate();
			loginPanel.repaint();
		}	
	}
}
	





//모든이름의 앞부분엔 클래스이름_이 붙는다.
public class KaKaoLogin_JSM extends JPanel implements ActionListener, FocusListener{
	KaKaoLogin2_JSM dialog;//login2 의 변수생성
	Color kakaotalk =new Color(250,235,51);//카카오톡 노란색
	JPanel homePanel;
	JPanel login_top;//상단로고붙일 곳
	JPanel login_center; //아이디랑 비밀번호 붙일곳
	JPanel login_bottom;// 빈공간여백을위한장소s
	JButton login_login;//login 버튼
	JLabel login_logo; //로고
	ImageIcon logo =new ImageIcon("images/logo.png");//맨위의 로고
	ImageIcon explain =new ImageIcon("images/set.png"); //아랫부분 
	TextField login_id ; //아이디창
	TextField login_password;// 패스워드창
	JCheckBox login_secretmode; // 잠금모드로 할것인지 체크박스
	JLabel login_emp ; //빈공간
	Font login_font1= new Font("나눔고딕",Font.BOLD,15); //아이디와 비밀번호창 폰트
	Font login_font2= new Font("나눔고딕",Font.BOLD,15); //여러가지 작은설명글
	
	HomeMainPanel_KHJ mainHome;
	
	//로딩화면
	JPanel loadingPanel;
	JLabel loadingView;
	KaKaoLogin_JSM(JPanel mainHomePanel){
		
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		//super("로그인창");
		setSize(378,674);
		//setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		homePanel = new JPanel(new BorderLayout()); //모든패널을 담을 큰패널
		//상단
		 login_top =new JPanel();
		 login_logo =new JLabel(logo);
		 login_logo.addFocusListener(this);
		 login_top.setBackground(kakaotalk);
		 login_top.add(login_logo);
	
		 homePanel.add(login_top,"North");
		 
		 //중단
		 login_center =new JPanel(new BorderLayout());
		 JPanel login_center_center =new JPanel(new GridLayout(11,2));
		 login_center_center.setBorder(BorderFactory.createEmptyBorder(0 , 30 , 0 , 30)); //공백주기

				 
		 JPanel login_center_emp1 =new JPanel();
		 JPanel login_center_emp2 =new JPanel();
		 JLabel login_center_explain =new JLabel(explain);
		 //login_center.setLayout(new BoxLayout(login_center,BoxLayout.Y_AXIS));
		
		 login_center.setBackground(kakaotalk);
		 login_center_center.setBackground(kakaotalk);
		// login_center_emp1.setBackground(kakaotalk);
		// login_center_emp2.setBackground(kakaotalk);
		 login_center.setPreferredSize(new Dimension(378,100));
		 login_id =new TextField("카카오계정(이메일또는 전화번호)",3);
		 login_id.setFont(login_font1);
		 
		 login_id.addFocusListener(this);
		 login_id.setForeground(Color.GRAY);
		// login_id.addActionListener(this);  추가로 글자 지워지기 기능할것!!
		 login_password =new TextField("비밀번호",3);
		 login_password.setFont(login_font1);
		 login_password.addFocusListener(this);
		 login_password.setForeground(Color.GRAY);
		 //login_password.addActionListener(this);추가로 글자 지워지기 기능할것!!
		// login_password.setEchoChar('*');
		
		 login_secretmode=new JCheckBox("잠금모드로 자동로그인");
		 login_secretmode.addFocusListener(this);
		 login_secretmode.requestFocus();
		 login_secretmode.setFont(login_font2);
		 login_secretmode.setBackground(kakaotalk);
		 login_login =new JButton(new ImageIcon("images/login2.png"));
		// login_login.setBorderPainted(false);  로그인버튼 모양을 남기기위해서
		 login_login.setFocusPainted(false);
		 login_login.setContentAreaFilled(false);
		 login_login.addActionListener(this);
		
		 login_center_center.add(login_id);
		 login_center_center.add(login_password);
		 login_center_center.add(login_login);
		 login_center_center.add(login_secretmode);
		// login_center_center.add(login_center_explain);
		 login_center.add( login_center_center,"Center");
		 login_center.add(login_center_explain,"South");
		 loadDraw();
		 
		 homePanel.add(login_center,"Center");
		 //하단
		 login_bottom =new JPanel(new FlowLayout(FlowLayout.LEFT));
		 login_emp =new JLabel("version0.00");   //하단의 버젼표시
		 login_bottom.setBackground(kakaotalk);
		 login_bottom.add(login_emp);
		 homePanel.add(login_bottom,"South");
		 this.setFocusable(true);
		 add(homePanel);
		 homePanel.setVisible(false);
		 setVisible(true);
	}
	class MyThread extends Thread{
		@Override
		public void run(){
			
			loadDraw();
			try{
				//1초후에시작
				Thread.sleep(1500);
				loadDestory();
			}catch(InterruptedException e) {
				e.printStackTrace();
				
			}
		}
	}
	//패널중에 
	public void loadDraw(){
		loadingPanel =new JPanel();
		loadingPanel.setLayout(new BorderLayout());
		loadingView =new JLabel(new ImageIcon("images/logo8.PNG"));
		loadingPanel.add(loadingView);
		this.add(loadingPanel);
		revalidate();
		repaint();
	
	}
	public void loadDestory(){
		System.out.println("?");
		this.remove(loadingPanel);
		add(homePanel);
		homePanel.setVisible(true);
		loadingPanel.revalidate();
		loadingPanel.repaint();
		
		homePanel.revalidate();
		homePanel.repaint();
	
		this.revalidate();
		this.repaint();
	}
	public void loading(){
		new MyThread().start();		
	}
	

	@Override
	public void focusGained(FocusEvent f) {
	if(f.getSource()==login_logo){
	}
	
	else if(f.getSource()== login_id){
		login_id.setText("");
		login_id.setForeground(Color.BLACK);
	}else if(f.getSource()==login_password){
		login_password.setText("");
		login_password.setEchoChar('*');
		login_password.setForeground(Color.BLACK);
	}
		
	}
	@Override
	public void focusLost(FocusEvent f) {
		//login_id.setText("카카오계정(이메일또는 전화번호)");
		//login_password.setText("비밀번호");
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==login_login){      //로그인버튼누름ㄴ
			new KaKaoLogin2_JSM(this, "본인인증창");
			
		}
	}
	
	public void End(){
		this.setVisible(false);
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}
	


}




//추가로 글자 지워지기 기능할것!!



