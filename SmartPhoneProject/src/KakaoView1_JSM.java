import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class KakaoView1_JSM extends JPanel implements ActionListener { //첫번째화면
	//공통변수
	KakaoProfile_JSM profile;
	KakaoChat_JSM ch; //채팅창 래퍼런스변수
	int userNum=20;
	int cnt;
	JPanel main ;// 카드레이아웃을 집어넣을곳
	CardLayout card; //카드레이아웃
	JButton[] profileimageA =new JButton[userNum];
	JButton[] profileimageB =new JButton[userNum];
	JButton[] profileimageC =new JButton[userNum];
	String[] userName_ =new String[userNum]; //사람이름
	String[] userState_ =new String[userNum];	//상태명
	String[] phoneNum_=new String[userNum];	//폰번호
	String[] message_ =new String[userNum];		//채팅내용
	JPanel[] user =new JPanel[userNum];		//사람수만큼의 패널
	
	JLabel[] userName =new JLabel[userNum]; //String으로 받아와서 대입하는 사람이름
	JLabel[] phoneNum =new JLabel[userNum];//String으로 받아와서 대입하는 폰번호
	JLabel[] userState =new JLabel[userNum];//String으로 받아와서 대입하는 상태명
	JLabel[] message =new JLabel[userNum];//String으로 받아와서 대입하는 메세지
	JLabel toplabel  =new JLabel("  친구"); //상단의 글자
	Font font1 = new Font("휴먼옛체",Font.BOLD, 20); //폰트1
	Font font2= new Font("Rix오늘의만화",Font.BOLD,30);//폰트2
	Font font3 =new Font("Rix오늘의만화",Font.BOLD,14); //폰트3
	Font font4 =new Font("맑은 고딕",Font.BOLD,20);
	Font font5 =new Font("맑은 고딕",Font.BOLD,20);
	Font font6 =new Font("맑은 고딕",Font.PLAIN,17);
	Color view1_Background =new Color(249,249,249); //배경색 //화이트라기보단 약간 밝은회색에 가까워서
	
	
	//view1
	JPanel view1;
	JPanel view1_Top;	//상단
	JPanel view1_Center;	//중단
	JPanel[] view1_Center_Center =new JPanel[userNum]; //중단의 유저이름과 상태명합치기 
	JPanel view1_Bottom;	//하단
	JScrollPane view1_Scroll; //view1의 스크롤페인

	JButton search;//상단의 찾기
	JButton add; //상단의 추가
	JButton set; //상단의 환경설정
	JButton button1;//하단의 사람모양 버튼
	JButton button2;//하단의 채팅버튼
	JButton button3;//하단의 세번째버튼
	JButton button4;//하단의 4번째버튼

	//두번째 패널
	JPanel view2;
	JPanel view2_Top; //상단
	JPanel view2_Center; //중단
	JPanel[] view2_user =new JPanel[userNum]; //두번째 사람수만큼의 패널
	JButton readbtn =new JButton(new ImageIcon("images/chat/1.png"));
	JButton[] view2_chat =new JButton[userNum]; //채팅창의 유저버튼
	
	JLabel[] view2_userName = new JLabel[userNum];  // userName 불러오기
	JLabel[] view2_chatContent= new JLabel[userNum]; //채팅 내용
	JScrollPane view2_Scroll;
	 //메서드에서 사용

	
	//세번째패널
	JPanel view3;
	JLabel top;
	JLabel bottom;
	JScrollPane view3_Scroll;

	//네번째패널
	JPanel view4;
	JPanel view4_panel;
	JPanel view4_First_Top;
	JPanel view4_Main; // 카드레이아웃
	JPanel view4_first;
	JPanel view4_second;
	JPanel view4_Center; //첫번째
	JPanel view4_Second_Top;
	JPanel view4_Second_Center; //두번째
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
		//super("메인화면1");
		setSize(378,674);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		//this.setLayout(new BorderLayout());
		//this.setFocusable(true);
		main =new JPanel(); //카드레이아웃을 할건데 이패널에 다넣을것이다.
		main.setPreferredSize(new Dimension(378,674));
		card =new CardLayout();//카드레이아웃선언
		main.setLayout(card);
		//첫번째패널 상단
		view1 =new JPanel(new BorderLayout());
		view1_Top =new JPanel(new BorderLayout());
		JPanel view1_Top_Top =new JPanel();
		 search =new JButton(new ImageIcon("images/main/search.png"));//상단의 찾기
		add =new JButton(new ImageIcon("images/main/add2.png")); //상단의 추가
		set =new JButton(new ImageIcon("images/main/set.png")); //상단의 환경설정 
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
		toplabel.setFont(font4);//친구의폰트
		toplabel.setHorizontalAlignment(toplabel.LEADING); //친구 글자 위치
		view1_Top.add(toplabel,"West");
		view1_Top_Top.setBackground(Color.WHITE);
		view1_Top_Top.add(search);
		view1_Top_Top.add(add);
		view1_Top_Top.add(set);
		view1_Top.add(view1_Top_Top,"East");//상단의 찾기버튼
		view1.add(view1_Top,"North");
		
		
		
		//첫번째패널 중단
		view1_Center =new JPanel(new GridLayout(15,1));
		view1_Scroll =new JScrollPane(view1_Center); //view1_
		
		view1_Scroll.setPreferredSize(new Dimension(100,3000));
		
		view1.add(view1_Scroll,"Center");
		//view1_Center.setLayout();
		user("<html> <br> <html>상문","","01095047540","오늘몇시에와요?");
		user("현주누나","지금은두번째시간","01055932609","프로젝트 어디까지했어요");
		user("다일","지금은세번째시간","01055465465","ㅇㅇ");
		user("원홍","지금은네번째시간","01071636644","ㄴㄴ");
		user("<html> <br> <html>승욱","현타온다","01071636644","난상문이 따까리");
		user("<html> <br> <html>세민","담타ㄱㄱ","01071636644","어디고");
		user("그린컴퓨터아카데미","출석100%","01071636644","오늘 지각하셨습니다");
		user("배달의 민족","신속배달","01071636644","숙제하시오");
		user("사람","지금은네번째시간","01071636644","저는 사람입니다.");
		
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
		
		//첫번째패널 하단
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
	
	
		//두번째 패널 
		view2 =new JPanel(new BorderLayout());
		view2_Center =new JPanel();
		 view2_Center.setBackground(Color.BLACK);
		 view2_Scroll =new JScrollPane(view2_Center);
		 view2_Scroll.setPreferredSize(new Dimension(100,3000));
		 view2_Center.setLayout(new BoxLayout( view2_Center,BoxLayout.Y_AXIS));
		
		 userMake(2);
		 
		 view2.add( view2_Scroll,"Center");
		 main.add(view2,"view2");
		
		
		
		//세번째패널
		
		view3 =new JPanel(new BorderLayout());
		
		top =new JLabel(new ImageIcon("images/chat/arttop.png"));
		bottom =new JLabel(new ImageIcon("images/chat/art.png"));
		view3_Scroll =new JScrollPane(bottom);
		this.setBackground(Color.YELLOW);
		view3.add(top,"North");
		view3.add(view3_Scroll,"Center");
		main.add(view3,"view3");
		
		
		
		//네번째패널
		view4 =new JPanel(new BorderLayout()); //카드레이아웃
		view4_panel =new JPanel(new BorderLayout());// 패널들을 넣을곳
		//카드레이아웃사용
		view4_Main =new JPanel(); // 카드레이아웃을 사용해서 나눠준다.
		view4_Main.setLayout(card);
		
		//첫번째
		view4_first =new JPanel(new BorderLayout());
		view4_First_Top =new JPanel(new FlowLayout(FlowLayout.LEFT));
		view4_First_Top.setBackground(Color.white); //배경색
		myProfile =new JButton(new ImageIcon("images/main/profilechange.png")); //색상
		myProfile.addActionListener(this);
		myProfile.setPreferredSize(new Dimension(103,100));
		myProfile.setFocusPainted(false);
		myProfile.setBorderPainted(false);
		myProfile.setContentAreaFilled(false);
		view4_First_Top.add(myProfile);
		
		view4_First_Top_gather =new JPanel();//Top의 이름과 이메일 모음집
		view4_First_Top_gather.setLayout(new BoxLayout(view4_First_Top_gather,BoxLayout.Y_AXIS));
		view4_First_Top_up =new JPanel(new FlowLayout(FlowLayout.LEFT));//이름
		view4_First_Top_down =new JPanel(new FlowLayout(FlowLayout.LEFT));//이메일
		view4_First_Top_up.setBackground(Color.white);
		view4_First_Top_down.setBackground(Color.white);
		JLabel myName =new JLabel("상문");
		myName.setFont(font5);
		JLabel myNameEmail =new JLabel("wjsdbwjd45@naver.com");
		myNameEmail.setFont(font6);
		myNameEmail.setForeground(Color.GRAY);
		view4_First_Top_up.add(myName);

		view4_First_Top_down.add(myNameEmail);
		view4_First_Top_gather.add(view4_First_Top_up);
		view4_First_Top_gather.add(view4_First_Top_down);
		view4_First_Top.add(view4_First_Top_gather);
		view4_first.add(view4_First_Top,"North");//위에 프로필과 이름과 이메일
		
		//첫번째 카드레이아웃 -센터
		view4_Center = new JPanel(new GridLayout(9,0)); //첫번쟤 카드레이아웃
		JScrollPane view4_scroll =new JScrollPane(view4_Center);//스크롤바
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
		view4_Main.add(view4_first,"1");//main에 담아준다
		
		///두번째카드레이아웃
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
		//두번째카드레이아웃 -탑
		
		JLabel gallery =new JLabel("앨범");
		
		gallery.setHorizontalAlignment(gallery.CENTER);
		gallery.setFont(font4);
		gallery.setForeground(Color.WHITE);
		
		view4_second.add(gallery,"North");
		//두번째카드레이아웃 -센터
		
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
	
		view4_Second_Center.setPreferredSize(new Dimension(50,574)); //스크롤크기
		JScrollPane view4_scroll2 =new JScrollPane(view4_Second_Center); //두번째스크롤
		view4_image =new JButton[15];
		for(int i =0; i<15;i++){
			view4_image[i] = new JButton(new ImageIcon("images/profile/image"+(i+1)+".png"));
			view4_image[i].setPreferredSize(new Dimension(107,100));
			view4_Second_Center.add(view4_image[i]);
			view4_image[i].addActionListener(this);
		}
		JLabel rest =new JLabel("15장의사진,0개비디오");
		view4_Second_Center.add(rest);
		view4_galleryOut =new JButton(new ImageIcon("images/Profile/out.png"));
		view4_galleryOut.setBorderPainted(false);
		view4_galleryOut.setContentAreaFilled(false);
		view4_galleryOut.setFocusPainted(false);
		view4_second.add(view4_galleryOut,"South");
		view4_second.add(view4_scroll2,"Center");
		view4_Main.add(view4_second,"2");//main에 담아준다
		 // 여러가지버튼 위치
		view4.add(view4_Main,"Center"); //전체의 카드레이아웃
		
	
		main.add(view4,"view4");
		add(main);
		setVisible(true);

		
	}	
	public void actionPerformed(ActionEvent e){
		//하단버튼
		if(e.getSource()==button1){
			toplabel.setText("  친구");
			card.show(main,"view1");
			view1.add(view1_Top,"North");
			view1.add(view1_Bottom,"South");
		
		}
		else if(e.getSource()==button2){
			toplabel.setText("  채팅");
			view2.add(view1_Top,"North");
			view2.add(view1_Bottom,"South");
			
			card.show(main,"view2");
			
		}
		else if(e.getSource()==button3){
			toplabel.setText("  더보기");
			view3.add(view1_Bottom,"South");
			card.show(main,"view3");			
		}
		else if(e.getSource()==button4){
			toplabel.setText("  더보기");
			view4.add(view1_Top,"North");
			view4.add(view1_Bottom,"South");
			card.show(main,"view4");
		}
		//두번째패널의 채팅창
		for(int i=0;i<userNum;i++){
			if(e.getSource()== view2_chat[i]){
				ch = new KakaoChat_JSM( this );
				JButton chattalk =new JButton(message_[i]);
				chattalk.setFont(font4);
				readbtn.setVisible(false);
				chattalk.setBackground(Color.WHITE);
				chattalk.setForeground(Color.BLACK);
				//chattalk.setPreferredSize(new Dimension(0,30));
				chattalk.setAlignmentX(LEFT_ALIGNMENT);//버튼 오른쪽정렬
				ch.chatFriendName.setText(userName_[i]);
				ch.chatCenter_Top.add(chattalk);				
				//체크
				ch.setVisible(true);
			}
		}
		//첫번째 프로필형성
		for(int i=0 ; i<userNum ; i++){
			if(e.getSource()==profileimageA[i]){
				profile = new KakaoProfile_JSM(this,userNum);	
				profile.profile_Center.add(profile.profile_user[i]);
				userState[i].setBounds(20, 150, 200, 200);
				userState[i].setForeground(Color.WHITE);
				userState[i].setFont(new Font("맑은고딕",Font.BOLD , 20));
				profile.profile_Center.setBackground(Color.white);
				profile.profile_Center.add(userState[i]);
			
			}
		}
		//네번째패널의 프로필사진눌럿을경우
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
				String message = "프로필사진을  변경하시겠습니까?";
				int answer = JOptionPane.showConfirmDialog(null,message , "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (answer == JOptionPane.YES_OPTION) {
				 
					 myProfile.setIcon(new ImageIcon("images/profile/image"+(i+1)+".png")); //색상
					 profileimageA[0].setIcon(new ImageIcon("images/profile/image"+(i+1)+".png")); //첫번째창 이미지
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
				userName[i] =new JLabel(userName_[i]);//String 타입으로 받은 userName을 Label로 변환
				userState[i] =new JLabel(userState_[i]);//String 타입으로 받은 userState를Label로 변환
				message[i] =new JLabel(message_[i]);//String 타입으로 받은 message_[i]를 Label로 변환
				
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
			view2_user[i]=new JPanel(new BorderLayout()); //2번째패널
			view2_userName[i] =new JLabel(userName_[i]); //String userName을 불러오기
			 view2_user[i].setBackground(Color.WHITE);
			 view2_chat[i] =new JButton();
			 view2_userName[i].setFont(font1);
			 view2_chat[i].setLayout(new GridLayout(2,0)); //채팅창
			 view2_chat[i].add(view2_userName[i]); //채팅창의 위에이름
			 view2_chat[i].add(message[i]);  //채팅창의 밑에 메세지
			 view2_chat[i].addActionListener(this);
			 message[i].setFont(font3);
			 message[i].setForeground(Color.GRAY);
			 view2_chat[i].setBackground(Color.WHITE);
			 view2_chat[i].setBorderPainted(false);
				//view1의 유저이름 불러오기
			 view2_user[i].add(  view2_chat[i],"Center");

			 if(pnlNum==2){
					view2_user[i].add(profileimageB[i],"West");
					view2_Center.add(view2_user[i]);	
			}
				
		}
		
		view2_user[1].add(readbtn,"East");
		JLabel line1=new JLabel("       즐겨찾기 ----------------------------------------------------------------");
		JLabel line2=new JLabel("       생일인친구 1 -----------------------------------------------------------");
		JLabel line3=new JLabel("       친구 5 ------------------------------------------------------------------");
		
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
