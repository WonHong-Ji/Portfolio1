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

//������ȣâ �θ�Ŭ����
//�̸��տ� Ŭ�����̸�����
class KaKaoLogin2_JSM extends JDialog implements ActionListener {
	JPanel login2_top; //���
	JPanel login2_center;//�ߴ�
	JPanel login2_center_center; //������ ���� �г�
	JPanel login2_bottom;//�ϴ�
	JLabel login2_toplabel;//
	JLabel login2_ment; //30�г��Ҵٴ¸�
	JTextField login2_confirm ;//������ȣâ
	JButton login2_ok;//Ȯ�� ��ư
	JButton login2_ipin; //������
	JButton login2_send; //����
	JButton message; //������ȣ
	JButton message2;
	Font login2_font1= new Font("�������",Font.BOLD,15);
	KakaoView1_JSM view;
	JPanel login2_top_top;//����� ����â�� �г�
	Color login2_kakaotalk =new Color(250,235,51); //����
	Color login2_background =new Color(250,250,250); 
	JPanel loginPanel;


	KaKaoLogin2_JSM(JPanel panel, String t){
		//super(frame,t);
		this.setModal(true);
		this.setUndecorated(true);
		setSize(378,674);
		setLocationRelativeTo(panel);
		loginPanel = panel;
		//���
		
		login2_top =new JPanel(new BorderLayout());
		
		login2_top_top =new JPanel();//����� ����â�� �г�
		login2_top_top.setLayout(new BoxLayout(login2_top_top,BoxLayout.Y_AXIS));
		
		login2_toplabel =new JLabel(new ImageIcon("images/logo.png")); //�ΰ�
		login2_top.setBackground(login2_kakaotalk);
		//login2_top.add(login2_top_top,"North");
		login2_top.add(login2_toplabel,"Center");
		add(login2_top,"North");
		
		//����
		login2_center =new JPanel();
		login2_center.setBorder(BorderFactory.createEmptyBorder(0 , 30 , 0 , 30));
		login2_center.setLayout(new GridLayout(15,1));
		login2_center.setBackground(login2_kakaotalk);
		login2_center_center=new JPanel(new GridLayout(0,2)); //��ư�Ѱ��� ����������
		login2_confirm =new JTextField(); //������ȣ �Է�â
		login2_ment =new JLabel("��Ȱ�� �̿��� ���� ���������� �Ϸ����ּ���");
		login2_ment.setHorizontalAlignment(login2_ment.CENTER);
		
		login2_ment.setForeground(Color.GRAY);
		login2_ok =new JButton("Ȯ��");
		login2_ok.setFont(login2_font1);
		login2_ok.setEnabled(false);
		login2_send =new JButton("���ڸ޽����� ã��");
		login2_send.setFont(login2_font1);
		login2_send.addActionListener(this);
	
		login2_ipin =new JButton("����������ã��");
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
		//�ϴ�
		
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
			message2.setBorderPainted(false);  //�α��ι�ư ����� ��������ؼ�
			message2.setFocusPainted(false);
			message2.setContentAreaFilled(false);
			message.setBorderPainted(false);  //�α��ι�ư ����� ��������ؼ�
			message.setFocusPainted(false);
			message.setContentAreaFilled(false);
		}else if(e.getSource() ==message){
			login2_confirm.setText("684224");
			login2_ok.setEnabled(true);
			login2_top_top.setVisible(false);
		}else if(e.getSource() == login2_ok){			
			//���� ���� �� ��� â�� �ݾ��ش�
			loginPanel.removeAll();
			this.dispose();
			
			loginPanel.add(HomeMainPanel_KHJ.kakao_View1);
			loginPanel.revalidate();
			loginPanel.repaint();
		}	
	}
}
	





//����̸��� �պκп� Ŭ�����̸�_�� �ٴ´�.
public class KaKaoLogin_JSM extends JPanel implements ActionListener, FocusListener{
	KaKaoLogin2_JSM dialog;//login2 �� ��������
	Color kakaotalk =new Color(250,235,51);//īī���� �����
	JPanel homePanel;
	JPanel login_top;//��ܷΰ���� ��
	JPanel login_center; //���̵�� ��й�ȣ ���ϰ�
	JPanel login_bottom;// ������������������s
	JButton login_login;//login ��ư
	JLabel login_logo; //�ΰ�
	ImageIcon logo =new ImageIcon("images/logo.png");//������ �ΰ�
	ImageIcon explain =new ImageIcon("images/set.png"); //�Ʒ��κ� 
	TextField login_id ; //���̵�â
	TextField login_password;// �н�����â
	JCheckBox login_secretmode; // ��ݸ��� �Ұ����� üũ�ڽ�
	JLabel login_emp ; //�����
	Font login_font1= new Font("�������",Font.BOLD,15); //���̵�� ��й�ȣâ ��Ʈ
	Font login_font2= new Font("�������",Font.BOLD,15); //�������� ���������
	
	HomeMainPanel_KHJ mainHome;
	
	//�ε�ȭ��
	JPanel loadingPanel;
	JLabel loadingView;
	KaKaoLogin_JSM(JPanel mainHomePanel){
		
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		//super("�α���â");
		setSize(378,674);
		//setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		homePanel = new JPanel(new BorderLayout()); //����г��� ���� ū�г�
		//���
		 login_top =new JPanel();
		 login_logo =new JLabel(logo);
		 login_logo.addFocusListener(this);
		 login_top.setBackground(kakaotalk);
		 login_top.add(login_logo);
	
		 homePanel.add(login_top,"North");
		 
		 //�ߴ�
		 login_center =new JPanel(new BorderLayout());
		 JPanel login_center_center =new JPanel(new GridLayout(11,2));
		 login_center_center.setBorder(BorderFactory.createEmptyBorder(0 , 30 , 0 , 30)); //�����ֱ�

				 
		 JPanel login_center_emp1 =new JPanel();
		 JPanel login_center_emp2 =new JPanel();
		 JLabel login_center_explain =new JLabel(explain);
		 //login_center.setLayout(new BoxLayout(login_center,BoxLayout.Y_AXIS));
		
		 login_center.setBackground(kakaotalk);
		 login_center_center.setBackground(kakaotalk);
		// login_center_emp1.setBackground(kakaotalk);
		// login_center_emp2.setBackground(kakaotalk);
		 login_center.setPreferredSize(new Dimension(378,100));
		 login_id =new TextField("īī������(�̸��϶Ǵ� ��ȭ��ȣ)",3);
		 login_id.setFont(login_font1);
		 
		 login_id.addFocusListener(this);
		 login_id.setForeground(Color.GRAY);
		// login_id.addActionListener(this);  �߰��� ���� �������� ����Ұ�!!
		 login_password =new TextField("��й�ȣ",3);
		 login_password.setFont(login_font1);
		 login_password.addFocusListener(this);
		 login_password.setForeground(Color.GRAY);
		 //login_password.addActionListener(this);�߰��� ���� �������� ����Ұ�!!
		// login_password.setEchoChar('*');
		
		 login_secretmode=new JCheckBox("��ݸ��� �ڵ��α���");
		 login_secretmode.addFocusListener(this);
		 login_secretmode.requestFocus();
		 login_secretmode.setFont(login_font2);
		 login_secretmode.setBackground(kakaotalk);
		 login_login =new JButton(new ImageIcon("images/login2.png"));
		// login_login.setBorderPainted(false);  �α��ι�ư ����� ��������ؼ�
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
		 //�ϴ�
		 login_bottom =new JPanel(new FlowLayout(FlowLayout.LEFT));
		 login_emp =new JLabel("version0.00");   //�ϴ��� ����ǥ��
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
				//1���Ŀ�����
				Thread.sleep(1500);
				loadDestory();
			}catch(InterruptedException e) {
				e.printStackTrace();
				
			}
		}
	}
	//�г��߿� 
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
		//login_id.setText("īī������(�̸��϶Ǵ� ��ȭ��ȣ)");
		//login_password.setText("��й�ȣ");
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==login_login){      //�α��ι�ư������
			new KaKaoLogin2_JSM(this, "��������â");
			
		}
	}
	
	public void End(){
		this.setVisible(false);
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}
	


}




//�߰��� ���� �������� ����Ұ�!!



