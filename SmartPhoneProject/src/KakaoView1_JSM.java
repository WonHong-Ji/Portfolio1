import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class KakaoView1_JSM extends JPanel implements ActionListener { //ù��°ȭ��
	//���뺯��
	KakaoProfile_JSM profile;
	KakaoChat_JSM ch; //ä��â ���۷�������
	int userNum=20;
	int cnt;
	JPanel main ;// ī�巹�̾ƿ��� ���������
	CardLayout card; //ī�巹�̾ƿ�
	JButton[] profileimageA =new JButton[userNum];
	JButton[] profileimageB =new JButton[userNum];
	JButton[] profileimageC =new JButton[userNum];
	String[] userName_ =new String[userNum]; //����̸�
	String[] userState_ =new String[userNum];	//���¸�
	String[] phoneNum_=new String[userNum];	//����ȣ
	String[] message_ =new String[userNum];		//ä�ó���
	JPanel[] user =new JPanel[userNum];		//�������ŭ�� �г�
	
	JLabel[] userName =new JLabel[userNum]; //String���� �޾ƿͼ� �����ϴ� ����̸�
	JLabel[] phoneNum =new JLabel[userNum];//String���� �޾ƿͼ� �����ϴ� ����ȣ
	JLabel[] userState =new JLabel[userNum];//String���� �޾ƿͼ� �����ϴ� ���¸�
	JLabel[] message =new JLabel[userNum];//String���� �޾ƿͼ� �����ϴ� �޼���
	JLabel toplabel  =new JLabel("  ģ��"); //����� ����
	Font font1 = new Font("�޸տ�ü",Font.BOLD, 20); //��Ʈ1
	Font font2= new Font("Rix�����Ǹ�ȭ",Font.BOLD,30);//��Ʈ2
	Font font3 =new Font("Rix�����Ǹ�ȭ",Font.BOLD,14); //��Ʈ3
	Font font4 =new Font("���� ���",Font.BOLD,20);
	Font font5 =new Font("���� ���",Font.BOLD,20);
	Font font6 =new Font("���� ���",Font.PLAIN,17);
	Color view1_Background =new Color(249,249,249); //���� //ȭ��Ʈ��⺸�� �ణ ����ȸ���� �������
	
	
	//view1
	JPanel view1;
	JPanel view1_Top;	//���
	JPanel view1_Center;	//�ߴ�
	JPanel[] view1_Center_Center =new JPanel[userNum]; //�ߴ��� �����̸��� ���¸���ġ�� 
	JPanel view1_Bottom;	//�ϴ�
	JScrollPane view1_Scroll; //view1�� ��ũ������

	JButton search;//����� ã��
	JButton add; //����� �߰�
	JButton set; //����� ȯ�漳��
	JButton button1;//�ϴ��� ������ ��ư
	JButton button2;//�ϴ��� ä�ù�ư
	JButton button3;//�ϴ��� ����°��ư
	JButton button4;//�ϴ��� 4��°��ư

	//�ι�° �г�
	JPanel view2;
	JPanel view2_Top; //���
	JPanel view2_Center; //�ߴ�
	JPanel[] view2_user =new JPanel[userNum]; //�ι�° �������ŭ�� �г�
	JButton readbtn =new JButton(new ImageIcon("images/chat/1.png"));
	JButton[] view2_chat =new JButton[userNum]; //ä��â�� ������ư
	
	JLabel[] view2_userName = new JLabel[userNum];  // userName �ҷ�����
	JLabel[] view2_chatContent= new JLabel[userNum]; //ä�� ����
	JScrollPane view2_Scroll;
	 //�޼��忡�� ���

	
	//����°�г�
	JPanel view3;
	JLabel top;
	JLabel bottom;
	JScrollPane view3_Scroll;

	//�׹�°�г�
	JPanel view4;
	JPanel view4_panel;
	JPanel view4_First_Top;
	JPanel view4_Main; // ī�巹�̾ƿ�
	JPanel view4_first;
	JPanel view4_second;
	JPanel view4_Center; //ù��°
	JPanel view4_Second_Top;
	JPanel view4_Second_Center; //�ι�°
	JPanel[] view4_variety;
	JButton myProfile;
	JButton myProfileChange;
	JButton[] view4_btn;
	JButton[] view4_image;
	JPanel view4_First_Top_gather;
	JPanel view4_First_Top_up;
	JPanel view4_First_Top_down;
	JButton view4_galleryOut;

	
	KakaoView1_JSM(){

		this.setBackground(Color.black);
		//super("����ȭ��1");
		setSize(378,674);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		//this.setLayout(new BorderLayout());
		//this.setFocusable(true);
		main =new JPanel(); //ī�巹�̾ƿ��� �Ұǵ� ���гο� �ٳ������̴�.
		main.setPreferredSize(new Dimension(378,674));
		card =new CardLayout();//ī�巹�̾ƿ�����
		main.setLayout(card);
		//ù��°�г� ���
		view1 =new JPanel(new BorderLayout());
		view1_Top =new JPanel(new BorderLayout());
		JPanel view1_Top_Top =new JPanel();
		 search =new JButton(new ImageIcon("images/main/search.png"));//����� ã��
		add =new JButton(new ImageIcon("images/main/add2.png")); //����� �߰�
		set =new JButton(new ImageIcon("images/main/set.png")); //����� ȯ�漳�� 
		add.setBorderPainted(false);
		//add.setFocusPainted(false);
		add.setContentAreaFilled(false);
		set.setBorderPainted(false);
		//set.setFocusPainted(false);
		set.setContentAreaFilled(false);
		search.setBorderPainted(false);
	//	search.setFocusPainted(false);
		search.setContentAreaFilled(false);
		
		view1_Top.setBackground(Color.WHITE);
		toplabel.setFont(font4);//ģ������Ʈ
		toplabel.setHorizontalAlignment(toplabel.LEADING); //ģ�� ���� ��ġ
		view1_Top.add(toplabel,"West");
		view1_Top_Top.setBackground(Color.WHITE);
		view1_Top_Top.add(search);
		view1_Top_Top.add(add);
		view1_Top_Top.add(set);
		view1_Top.add(view1_Top_Top,"East");//����� ã���ư
		view1.add(view1_Top,"North");
		
		
		
		//ù��°�г� �ߴ�
		view1_Center =new JPanel(new GridLayout(15,1));
		view1_Scroll =new JScrollPane(view1_Center); //view1_
		
		view1_Scroll.setPreferredSize(new Dimension(100,3000));
		
		view1.add(view1_Scroll,"Center");
		//view1_Center.setLayout();
		user("<html> <br> <html>��","","01095047540","���ø�ÿ��Ϳ�?");
		user("���ִ���","�������ι�°�ð�","01055932609","������Ʈ �������߾��");
		user("����","����������°�ð�","01055465465","����");
		user("��ȫ","�������׹�°�ð�","01071636644","����");
		user("<html> <br> <html>�¿�","��Ÿ�´�","01071636644","������ ���");
		user("<html> <br> <html>����","��Ÿ����","01071636644","����");
		user("�׸���ǻ�;�ī����","�⼮100%","01071636644","���� �����ϼ̽��ϴ�");
		user("����� ����","�żӹ��","01071636644","�����Ͻÿ�");
		user("���","�������׹�°�ð�","01071636644","���� ����Դϴ�.");
		
		for(int i=0;i<userNum;i++){
			this.profileimageA[i] = new JButton(new ImageIcon("images/main/man.png"));
			this.profileimageA[i].addActionListener(this);
			this.profileimageB[i] = new JButton(new ImageIcon("images/main/man.png"));
			this.profileimageB[i].addActionListener(this);
			this.profileimageC[i] = new JButton(new ImageIcon("images/main/bigman.png"));
			this.profileimageC[i].addActionListener(this);
		}
		userMake(1);
		//add(view1_Center,"Center");
		
		//ù��°�г� �ϴ�
		view1_Bottom = new JPanel(new GridLayout(0,4));
		view1_Bottom.setPreferredSize(new Dimension(40,60));
		view1_Bottom.setBackground(view1_Background);
		button1 =new JButton(new ImageIcon("images/main/button1.png"));
		button2 =new JButton(new ImageIcon("images/main/button2.png"));
		button3 =new JButton(new ImageIcon("images/main/button3.png"));
		button4 =new JButton(new ImageIcon("images/main/button4.png"));
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setFocusPainted(false);
		button3.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		button4.setFocusPainted(false);
		button4.setContentAreaFilled(false);
		view1_Bottom.add(button1);
		view1_Bottom.add(button2);
		view1_Bottom.add(button3);
		view1_Bottom.add(button4);
		view1.add(view1_Bottom,"South");
		main.add(view1,"view1");
	
	
		//�ι�° �г� 
		view2 =new JPanel(new BorderLayout());
		view2_Center =new JPanel();
		 view2_Center.setBackground(Color.BLACK);
		 view2_Scroll =new JScrollPane(view2_Center);
		 view2_Scroll.setPreferredSize(new Dimension(100,3000));
		 view2_Center.setLayout(new BoxLayout( view2_Center,BoxLayout.Y_AXIS));
		
		 userMake(2);
		 
		 view2.add( view2_Scroll,"Center");
		 main.add(view2,"view2");
		
		
		
		//����°�г�
		
		view3 =new JPanel(new BorderLayout());
		
		top =new JLabel(new ImageIcon("images/chat/arttop.png"));
		bottom =new JLabel(new ImageIcon("images/chat/art.png"));
		view3_Scroll =new JScrollPane(bottom);
		this.setBackground(Color.YELLOW);
		view3.add(top,"North");
		view3.add(view3_Scroll,"Center");
		main.add(view3,"view3");
		
		
		
		//�׹�°�г�
		view4 =new JPanel(new BorderLayout()); //ī�巹�̾ƿ�
		view4_panel =new JPanel(new BorderLayout());// �гε��� ������
		//ī�巹�̾ƿ����
		view4_Main =new JPanel(); // ī�巹�̾ƿ��� ����ؼ� �����ش�.
		view4_Main.setLayout(card);
		
		//ù��°
		view4_first =new JPanel(new BorderLayout());
		view4_First_Top =new JPanel(new FlowLayout(FlowLayout.LEFT));
		view4_First_Top.setBackground(Color.white); //����
		myProfile =new JButton(new ImageIcon("images/main/profilechange.png")); //����
		myProfile.addActionListener(this);
		myProfile.setPreferredSize(new Dimension(103,100));
		myProfile.setFocusPainted(false);
		myProfile.setBorderPainted(false);
		myProfile.setContentAreaFilled(false);
		view4_First_Top.add(myProfile);
		
		view4_First_Top_gather =new JPanel();//Top�� �̸��� �̸��� ������
		view4_First_Top_gather.setLayout(new BoxLayout(view4_First_Top_gather,BoxLayout.Y_AXIS));
		view4_First_Top_up =new JPanel(new FlowLayout(FlowLayout.LEFT));//�̸�
		view4_First_Top_down =new JPanel(new FlowLayout(FlowLayout.LEFT));//�̸���
		view4_First_Top_up.setBackground(Color.white);
		view4_First_Top_down.setBackground(Color.white);
		JLabel myName =new JLabel("��");
		myName.setFont(font5);
		JLabel myNameEmail =new JLabel("wjsdbwjd45@naver.com");
		myNameEmail.setFont(font6);
		myNameEmail.setForeground(Color.GRAY);
		view4_First_Top_up.add(myName);

		view4_First_Top_down.add(myNameEmail);
		view4_First_Top_gather.add(view4_First_Top_up);
		view4_First_Top_gather.add(view4_First_Top_down);
		view4_First_Top.add(view4_First_Top_gather);
		view4_first.add(view4_First_Top,"North");//���� �����ʰ� �̸��� �̸���
		
		//ù��° ī�巹�̾ƿ� -����
		view4_Center = new JPanel(new GridLayout(9,0)); //ù���� ī�巹�̾ƿ�
		JScrollPane view4_scroll =new JScrollPane(view4_Center);//��ũ�ѹ�
		view4_scroll.setPreferredSize(new Dimension(200,500));
		view4_variety =new JPanel[9];
		view4_btn =new JButton[9];
		
		for(int i=0; i<9;i++){
			view4_btn[i]=new JButton(new ImageIcon("images/Profile/infobtn/[" + (i+1) + "].png"));
			view4_btn[i].setBorderPainted(false);
			view4_btn[i].setContentAreaFilled(false);
			view4_variety[i] =new JPanel(new FlowLayout(FlowLayout.LEFT));
			view4_variety[i].setBackground(Color.WHITE);
			view4_variety[i].add(view4_btn[i]);
			view4_Center.add(view4_variety[i]);
		
		}
		
		view4_first.add(view4_scroll,"Center");
		view4_Main.add(view4_first,"1");//main�� ����ش�
		
		///�ι�°ī�巹�̾ƿ�
		view4_second =new JPanel(new BorderLayout()){
			ImageIcon backGround = new ImageIcon("images/background/back.png");
			Image backGround1 = backGround.getImage();
			Image backGround2 = backGround1.getScaledInstance(378, 700,
					Image.SCALE_SMOOTH);
			ImageIcon backGround3 = new ImageIcon(backGround2);
			
		public void paintComponent(Graphics g) {
			g.drawImage(backGround3.getImage(), 0, 0, null);
			view4_second.setOpaque(false);
			super.paintComponent(g);
			
			
			}
		};
		//�ι�°ī�巹�̾ƿ� -ž
		
		JLabel gallery =new JLabel("�ٹ�");
		
		gallery.setHorizontalAlignment(gallery.CENTER);
		gallery.setFont(font4);
		gallery.setForeground(Color.WHITE);
		
		view4_second.add(gallery,"North");
		//�ι�°ī�巹�̾ƿ� -����
		
		view4_Second_Center =new JPanel(){
			
			ImageIcon backGround = new ImageIcon("images/background/back.png");
			Image backGround1 = backGround.getImage();
			Image backGround2 = backGround1.getScaledInstance(378, 700,
					Image.SCALE_SMOOTH);
			ImageIcon backGround3 = new ImageIcon(backGround2);
			
		public void paintComponent(Graphics g) {
			g.drawImage(backGround3.getImage(), 0, 0, null);
			view4_Second_Center.setOpaque(false);
			super.paintComponent(g);
			
			
			}
		};
	
		view4_Second_Center.setPreferredSize(new Dimension(50,574)); //��ũ��ũ��
		JScrollPane view4_scroll2 =new JScrollPane(view4_Second_Center); //�ι�°��ũ��
		view4_image =new JButton[15];
		for(int i =0; i<15;i++){
			view4_image[i] = new JButton(new ImageIcon("images/profile/image"+(i+1)+".png"));
			view4_image[i].setPreferredSize(new Dimension(107,100));
			view4_Second_Center.add(view4_image[i]);
			view4_image[i].addActionListener(this);
		}
		JLabel rest =new JLabel("15���ǻ���,0������");
		view4_Second_Center.add(rest);
		view4_galleryOut =new JButton(new ImageIcon("images/Profile/out.png"));
		view4_galleryOut.setBorderPainted(false);
		view4_galleryOut.setContentAreaFilled(false);
		view4_galleryOut.setFocusPainted(false);
		view4_second.add(view4_galleryOut,"South");
		view4_second.add(view4_scroll2,"Center");
		view4_Main.add(view4_second,"2");//main�� ����ش�
		 // ����������ư ��ġ
		view4.add(view4_Main,"Center"); //��ü�� ī�巹�̾ƿ�
		
	
		main.add(view4,"view4");
		add(main);
		setVisible(true);

		
	}	
	public void actionPerformed(ActionEvent e){
		//�ϴܹ�ư
		if(e.getSource()==button1){
			toplabel.setText("  ģ��");
			card.show(main,"view1");
			view1.add(view1_Top,"North");
			view1.add(view1_Bottom,"South");
		
		}
		else if(e.getSource()==button2){
			toplabel.setText("  ä��");
			view2.add(view1_Top,"North");
			view2.add(view1_Bottom,"South");
			
			card.show(main,"view2");
			
		}
		else if(e.getSource()==button3){
			toplabel.setText("  ������");
			view3.add(view1_Bottom,"South");
			card.show(main,"view3");			
		}
		else if(e.getSource()==button4){
			toplabel.setText("  ������");
			view4.add(view1_Top,"North");
			view4.add(view1_Bottom,"South");
			card.show(main,"view4");
		}
		//�ι�°�г��� ä��â
		for(int i=0;i<userNum;i++){
			if(e.getSource()== view2_chat[i]){
				ch = new KakaoChat_JSM( this );
				JButton chattalk =new JButton(message_[i]);
				chattalk.setFont(font4);
				readbtn.setVisible(false);
				chattalk.setBackground(Color.WHITE);
				chattalk.setForeground(Color.BLACK);
				//chattalk.setPreferredSize(new Dimension(0,30));
				chattalk.setAlignmentX(LEFT_ALIGNMENT);//��ư ����������
				ch.chatFriendName.setText(userName_[i]);
				ch.chatCenter_Top.add(chattalk);				
				//üũ
				ch.setVisible(true);
			}
		}
		//ù��° ����������
		for(int i=0 ; i<userNum ; i++){
			if(e.getSource()==profileimageA[i]){
				profile = new KakaoProfile_JSM(this,userNum);	
				profile.profile_Center.add(profile.profile_user[i]);
				userState[i].setBounds(20, 150, 200, 200);
				userState[i].setForeground(Color.WHITE);
				userState[i].setFont(new Font("�������",Font.BOLD , 20));
				profile.profile_Center.setBackground(Color.white);
				profile.profile_Center.add(userState[i]);
			
			}
		}
		//�׹�°�г��� �����ʻ������������
		if(e.getSource()==myProfile){
			//view4_First_Top.setBorder(new EmptyBorder(5,5,5,5));
			
			view4_First_Top.setBackground(new Color(0,0,0,122));
			//view4_First_Top.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);

			
			card.show(view4_Main, "2");
			view4.revalidate();
			view4.repaint();
		}
		for(int i =0; i<15;i++){
		if(e.getSource()==view4_image[i]){
			
				view4_image[i].setEnabled(false);
				String message = "�����ʻ�����  �����Ͻðڽ��ϱ�?";
				int answer = JOptionPane.showConfirmDialog(null,message , "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (answer == JOptionPane.YES_OPTION) {
				 
					 myProfile.setIcon(new ImageIcon("images/profile/image"+(i+1)+".png")); //����
					 profileimageA[0].setIcon(new ImageIcon("images/profile/image"+(i+1)+".png")); //ù��°â �̹���
					 profileimageA[0].setPreferredSize(new Dimension(70,30));
					 profileimageC[0].setIcon(new ImageIcon("images/profile/image"+(i+1)+".png"));
					 view4_First_Top.setBackground(Color.white);
					 view4_image[i].setEnabled(true);	
					 view4_first.revalidate();
					 view4_first.repaint();
					 card.show(view4_Main,"1"); // User clicked YES.
				}
				 else if (answer == JOptionPane.NO_OPTION) {
					 view4_image[i].setEnabled(true);
				}
			}
		}
	}
	
	public void profileImagesA(){
		for(int i =0 ;i<userNum;i++){
			profileimageA[i].setFocusPainted(false);
			this.profileimageA[i].setBorderPainted(false);
			this.profileimageA[i].setContentAreaFilled(false);
			this.profileimageA[i].setPreferredSize(new Dimension(70,20));
			
		}
	}
	
	public void profileImagesB(){
		for(int i =0 ;i<userNum;i++){
		profileimageB[i].setFocusPainted(false);
		profileimageB[i].setBorderPainted(false);
		profileimageB[i].setContentAreaFilled(false);
		profileimageB[i].setPreferredSize(new Dimension(100,20));
		}
	}
	
	public void profileImagesC(){
		for(int i =0 ;i<userNum;i++){
		profileimageC[i].setFocusPainted(false);
		profileimageC[i].setBorderPainted(false);
		profileimageC[i].setContentAreaFilled(false);
		profileimageC[i].setBorder(null);
		profileimageC[i].setPreferredSize(new Dimension(300,200));
		}
	}		
	
	
	public void user(String userName,String userState,String phoneNum,String message){
		if(cnt<=userNum){
			this.userName_[cnt] =userName;
			this.userState_[cnt] =userState;
			this.phoneNum_[cnt] =phoneNum;
			this.message_[cnt] =message;
			
			cnt++;
		}
	}
	public void userMake(int pnlNum){
		for(int i=0;i<userName_.length;i++){
			if(userName_[i] != null){
				user[i]=new JPanel(new BorderLayout());
				view1_Center_Center[i] =new JPanel();
				view1_Center_Center[i].setLayout(new BoxLayout(view1_Center_Center[i], BoxLayout.Y_AXIS));
				userName[i] =new JLabel(userName_[i]);//String Ÿ������ ���� userName�� Label�� ��ȯ
				userState[i] =new JLabel(userState_[i]);//String Ÿ������ ���� userState��Label�� ��ȯ
				message[i] =new JLabel(message_[i]);//String Ÿ������ ���� message_[i]�� Label�� ��ȯ
				
				message[i].setFont(font4);
				userState[i].setHorizontalAlignment(userState[i].LEFT);
				phoneNum[i] =new JLabel(phoneNum_[i]);
				view1_Center_Center[i].setBackground(Color.WHITE);
				user[i].setBackground(Color.WHITE);
				userName[i].setFont(font1);
				userState[i].setFont(font3);
				userState[i].setForeground(Color.GRAY);
				profileImagesA();	
				profileImagesB();	
				view1_Center_Center[i].add(userName[i]);
				view1_Center_Center[i].add(userState[i]);
				if(pnlNum==1){
					user[i].add(view1_Center_Center[i]);
					user[i].add(profileimageA[i],"West");
					view1_Center.add(user[i]);	
				}
			}
			
		}
		for(int i=1;i<cnt;i++){
			view2_user[i]=new JPanel(new BorderLayout()); //2��°�г�
			view2_userName[i] =new JLabel(userName_[i]); //String userName�� �ҷ�����
			 view2_user[i].setBackground(Color.WHITE);
			 view2_chat[i] =new JButton();
			 view2_userName[i].setFont(font1);
			 view2_chat[i].setLayout(new GridLayout(2,0)); //ä��â
			 view2_chat[i].add(view2_userName[i]); //ä��â�� �����̸�
			 view2_chat[i].add(message[i]);  //ä��â�� �ؿ� �޼���
			 view2_chat[i].addActionListener(this);
			 message[i].setFont(font3);
			 message[i].setForeground(Color.GRAY);
			 view2_chat[i].setBackground(Color.WHITE);
			 view2_chat[i].setBorderPainted(false);
				//view1�� �����̸� �ҷ�����
			 view2_user[i].add(  view2_chat[i],"Center");

			 if(pnlNum==2){
					view2_user[i].add(profileimageB[i],"West");
					view2_Center.add(view2_user[i]);	
			}
				
		}
		
		view2_user[1].add(readbtn,"East");
		JLabel line1=new JLabel("       ���ã�� ----------------------------------------------------------------");
		JLabel line2=new JLabel("       ������ģ�� 1 -----------------------------------------------------------");
		JLabel line3=new JLabel("       ģ�� 5 ------------------------------------------------------------------");
		
		//JLabel line1=new JLabel(new ImageIcon("images/main/line2.png"));
		line1.setHorizontalAlignment(line1.LEFT);
		user[1].add(line1 ,"North");
		//user[2].add(line2 ,"South");
		user[3].add(line3,"South");
		readbtn.setBorderPainted(false);
		//readbtn.setFocusPainted(false);
		readbtn.setContentAreaFilled(false);
		
		readbtn.setPreferredSize(new Dimension(30,20));
	
	}
}
