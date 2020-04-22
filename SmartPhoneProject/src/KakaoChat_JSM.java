import javax.swing.*;
import javax.swing.text.View;

import java.awt.*;
import java.awt.event.*;
public class KakaoChat_JSM extends JDialog implements ActionListener,KeyListener{
	KakaoView1_JSM view;
	
	JPanel chatTop; //�гλ��Ʋ
	JPanel chatCenter;
	JPanel chatCenter_Top;
	JPanel chatCenter_Center;
	JButton chatCenter_Search;
	JButton chatCenter_Menu;
	JPanel chatBottom;//�г� �ϴ�Ʋ
	JPanel chatPanel; //ä�ë������� �������� ���� �г�
	JScrollPane scroll;
	JLabel chatFriendName; //ģ���̸�
	JButton chatOut; //ä��â������
	JButton chatSearch; //�гλ�ܰ˻�
	JButton chatAddImage;//�̹����߰�
	JButton chatSend;//ä��â ������
	JButton chatTalk;//ä�� �����
	
	JTextField chatContent;//��ȭ����
	Color mycolor =new Color(178,199,218); //ä��â ��
	Color mycolor1 =new Color(255,241,28); //ä���� ��
	Font chat_font1 =new Font("���� ���",Font.BOLD,15);
	KakaoChat_JSM(JPanel panel){
		//super("īī���� ä�ù�");
		this.setModal(true);
		this.setUndecorated(true);
		setSize(378, 674);
		setLocationRelativeTo(panel);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//getContentPane().setBackground(mycolor);
		//ä��â���
		chatTop =new JPanel(new GridLayout(0,6));
		JPanel emp1 =new JPanel();//���г��� �־��ش� grid�� 5����⶧����
		JPanel emp2 =new JPanel();
		emp1.setBackground(mycolor);
		emp2.setBackground(mycolor);
		chatOut =new JButton(new ImageIcon("images/chat/exit1.png"));
		chatCenter_Search =new JButton(new ImageIcon("images/chat/search.png"));
		chatCenter_Menu =new JButton(new ImageIcon("images/chat/menu.png"));
		chatCenter_Search.setBorderPainted(false);
		chatCenter_Search.setFocusPainted(false);
		chatCenter_Search.setContentAreaFilled(false);
		chatCenter_Menu.setBorderPainted(false);
		chatCenter_Menu.setFocusPainted(false);
		chatCenter_Menu.setContentAreaFilled(false);
		chatOut.setBorderPainted(false);
		chatOut.setFocusPainted(false);
		chatOut.setContentAreaFilled(false);
		//chatOut.setPreferredSize(new Dimension(100,100));
		chatTop.setBackground(mycolor);
		chatOut.addActionListener(this);
		chatFriendName =new JLabel();
		chatFriendName.setFont(chat_font1);
		//chatFriendName.setHorizontalAlignment(chatFriendName.LEFT);
		chatFriendName.setAlignmentX(LEFT_ALIGNMENT);
		chatTop.add(chatOut);
		chatTop.add(chatFriendName);
		chatTop.add(emp1);
		chatTop.add(emp2);
		chatTop.add(chatCenter_Search);
		chatTop.add(chatCenter_Menu);
		add(chatTop,"North");
		//ä��â�߾�
		chatCenter =new JPanel(new BorderLayout());
		chatCenter_Top =new JPanel(new FlowLayout(FlowLayout.LEFT));
		chatCenter_Top.setBackground(mycolor);
		chatCenter_Center =new JPanel();
		chatCenter_Center.setBackground(mycolor);
	
		chatCenter.add(chatCenter_Top,"North");
		
		
		//view.message[1];
		chatCenter_Center.setLayout(new BoxLayout(chatCenter_Center,BoxLayout.Y_AXIS));
		chatCenter.setBackground(mycolor);
		chatCenter.add(chatCenter_Center);
		add(chatCenter,"Center");
		
		
		//ä��â�ϴ�
		chatBottom =new JPanel(new BorderLayout());
		//chatBottom.setBackground(mycolor1);
		chatBottom.setPreferredSize(new Dimension(100,50));
		chatBottom.setBackground(Color.WHITE);
		chatAddImage =new JButton(new ImageIcon("images/chat/addImage.png"));
		chatAddImage.setPreferredSize(new Dimension(40,30));
		chatAddImage.setFocusPainted(false);
		chatAddImage.setContentAreaFilled(false);
		chatAddImage.setBorderPainted(false);
		chatAddImage.addActionListener(this);
		chatSend =new JButton(new ImageIcon("images/chat/send.png"));
		chatSend.setPreferredSize(new Dimension(40,40));
		chatSend.setBorderPainted(false);
		chatSend.setFocusPainted(false);
		chatSend.setContentAreaFilled(false);
		chatSend.addActionListener(this);
		chatContent =new JTextField(20);
		chatContent.addKeyListener(this);//����Ű�������� ���������ؼ�
		
		//chatBottom.setBackground(mycolor);
		chatBottom.add(chatAddImage,"West");
		chatBottom.add(chatContent,"Center");
		chatBottom.add(chatSend,"East");
		add(chatBottom,"South");
		
		setVisible(false);
		}
	@Override
	public void actionPerformed(ActionEvent e){
		
		//ä��â������ ���
		if(e.getSource()==chatOut){
			this.setVisible(false);
		}
		//ä��â������ ���
		
		if(e.getSource()==chatSend){
			
		
			chatTalk =new JButton();
			chatTalk.setText(chatContent.getText());
			chatTalk.setFont(chat_font1);
			chatTalk.setBackground(mycolor1);
			chatTalk.setForeground(Color.BLACK);
			chatTalk.setPreferredSize(new Dimension(20,3));
			chatTalk.setAlignmentX(RIGHT_ALIGNMENT);//��ư ����������
			chatCenter_Center.add(chatTalk);
			chatContent.setText("");
			//chatCenter.add(chatCenter_Center,"Center");
			chatCenter.revalidate();
			chatCenter.repaint();
			
			
			
		}
		//�̹����߰���ư ��� // ������������Ȱ��ȭ�� �ߴ�
		if(e.getSource()==chatAddImage){
			
		}
	
	
	}
	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			chatTalk =new JButton();
			chatTalk.setText(chatContent.getText());
			chatTalk.setFont(chat_font1);
			chatTalk.setBackground(mycolor1);
			chatTalk.setForeground(Color.BLACK);
			chatTalk.setPreferredSize(new Dimension(20,3));
			chatTalk.setAlignmentX(RIGHT_ALIGNMENT);//��ư ����������
			chatCenter_Center.add(chatTalk);
			chatContent.setText("");
			chatCenter.revalidate();
			chatCenter.repaint();
			chatCenter.add(chatCenter_Center,"Center");
		}


	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	


}
