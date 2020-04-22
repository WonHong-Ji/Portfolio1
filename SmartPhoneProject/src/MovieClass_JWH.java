import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;


public class MovieClass_JWH extends JPanel implements ActionListener {
	
	/* Tickets라는 이름의 폴더가 있어야 티켓 텍스트 문서가 생성됨 */
	
	/* 컴포넌트 선언과 어디에 쓰이는지에 대한 설명 */
	/* 실행시 제일 처음 보이는 메인 화면에서 사용할 컴포넌트 선언 */ 
	Container container_JWH;
	CardLayout card_JWH; // 화면 전환은 cardLayout을 사용함 .
	
	JPanel mainPanel_JWH, // 메인화면을 구성하는 패널, BorderLayout으로 설정됨.
		   logoPanel_JWH, // mainPanel의 North에 위치. "오늘 뭐볼래?" 레이블이 배치됨. image로 background 이미지 설정.
		   contentPanel_JWH, // mainPanel의 Center에 위치. 영화 이미지와 설명이 배치됨.
		   buttonPanel_JWH, // mainPanel의 South에 위치. 영화예매, 예매확인 버튼이 배치됨.
		   content1_JWH, // 겨울왕국에 대한 정보를 가진 컴포넌트들이 들어갈 패널.
		   content2_JWH, // 천문 패널에 대한 정보를 가진 컴포넌트들이 들어갈 패널.
		   content3_JWH, //	포드V페라리 패널에 대한 정보를 가진 컴포넌트들이 들어갈 패널.
		   moviePnl1_JWH, // 겨울왕국 포스터.
		   moviePnl2_JWH, // 천문 포스터.
		   moviePnl3_JWH; // 포드V페라리 포스터.
	JButton reserveBtn_JWH, // 영화예매 버튼.
			checkBtn_JWH, // 예매확인 버튼.
			leftBtn_JWH, // 영화를 왼쪽 방향으로 바꾸는 화살표 버튼 .
			rightBtn_JWH; // 영화를 오른쪽 방향으로 바꾸는 화살표 버튼.
	JLabel logoLbl_JWH; // "오늘 뭐볼래?"로 텍스트가 설정되는 레이블.
	String select_JWH = "winter"; // 선택된 영화의 초기값은 겨울왕국으로 설정됨.
	/* 메인화면 컴포넌트 선언 end */
	
	/* 시간선택 화면에서 사용할 컴포넌트 선언 */
	JPanel timePanel_JWH, // 시간선택 화면을 구성하는 패널, BorderLayout으로 설정됨.
		   titlePanel2_JWH, // timePanel의 North에 위치. 뒤로가기(<) 버튼과 "시간선택"레이블이 배치됨.
		   timeSelectPanel_JWH; // timePanel의 Center에 위치. 시간 버튼들이 배치됨.
	JButton backBtn2_JWH, // 뒤로가기(<) 버튼. 시간선택->메인화면으로 전환되는 기능을 가짐.
			winter1610, // 겨울왕국 16:10 버튼. timeM 변수에 "16:10"을 저장하고 좌석선택 화면으로 전환되는 기능을 가짐.
			winter1840, // 겨울왕국 18:40 버튼. timeM 변수에 "18:40"을 저장하고 좌석선택 화면으로 전환되는 기능을 가짐.
			chun1250, // 천문 12:50 버튼. timeM 변수에 "12:50"을 저장하고 좌석선택 화면으로 전환되는 기능을 가짐.
			chun2030, // 천문 20:30 버튼. timeM 변수에 "20:30"을 저장하고 좌석선택 화면으로 전환되는 기능을 가짐.
			ff1515, // 포드V페라리 15:15 버튼. timeM 변수에 "15:15"을 저장하고 좌석선택 화면으로 전환되는 기능을 가짐.
			ff2100; // 포드V페라리 21:00 버튼. timeM 변수에 "15:15"을 저장하고 좌석선택 화면으로 전환되는 기능을 가짐.
	JLabel titleLbl2_JWH, // "시간선택"으로 텍스트가 설정되는 레이블.
		   g1_winter, // "1관 겨울왕국"으로 텍스트가 설정되는 레이블.
		   g2_chun, // "2관 천문"으로 텍스트가 설정되는 레이블.
		   g3_ff; // "3관 포드V페라리"로 텍스트가 설정되는 레이블. 
	String timeM_JWH = ""; // 시간버튼의 텍스트를 getText로 저장하는 변수.
	/* 시간선택 화면 컴포넌트 선언 end */
	
	/* 좌석선택 화면에서 사용할 컴포넌트 선언 */
	JPanel seatPanel_JWH, // 좌석선택 화면을 구성하는 패널, BorderLayout으로 설정됨.
		   titlePanel3_JWH, // seatPanel의 North에 위치. 뒤로가기(<)버튼과 "좌석선택"레이블이 배치됨.
		   seatSelectPanel_JWH, // seatPanel의 Center에 위치. line패널과 line에 해당하는 좌석 버튼들이 배치됨.
		   informPanel_JWH, // seatPanel의 South에 위치. 선택한 영화의 정보들을 가진 컴포넌트들과 결제진행 버튼이 배치됨.
		   lineScreen_JWH, // "Screen"레이블이 배치되는 패널. 
		   line0_JWH, // lineScreen패널과 lineA패널 사이에 간격을 만들기 위한 빈 패널. 
		   lineA_JWH, // A~버튼들이 배치되는 패널 
		   lineB_JWH, // B~버튼들이 배치되는 패널
		   lineC_JWH, // C~버튼들이 배치되는 패널
		   lineD_JWH, // D~버튼들이 배치되는 패널
		   lineE_JWH, // E~버튼들이 배치되는 패널
		   lineF_JWH, // F~버튼들이 배치되는 패널
		   lineG_JWH, // G~버튼들이 배치되는 패널
		   moviePnl4_JWH, // 겨울왕국 포스터, informPanel에 배치됨.
		   moviePnl5_JWH, // 천문 포스터, informPanel에 배치됨.
		   moviePnl6_JWH; // 포드V페라리 포스터, informPanel에 배치됨.
	JButton backBtn3_JWH, // 뒤로가기(<) 버튼. 좌석선택->시간선택으로 전환되는 기능을 가짐.
			goPay_JWH; // 결제진행(>) 버튼. 좌석선택이 완료되면 setEnable(true)로 바뀌며 활성화됨. 좌석선택->결제진행으로 전환되는 기능을 가짐.
	JLabel titleLbl3_JWH, // "좌석선택"으로 텍스트가 설정되는 레이블.
		   movieNameLbl_JWH, // "영화제목(xx이용가)"로 텍스트가 설정되는 레이블.
		   cinemaLbl_JWH, // "극장 : 서면점"으로 텍스트가 설정되는 레이블.
		   dayLbl_JWH, // "관람일 : xxxx.xx.xx"으로 텍스트가 설정되는 레이블. 
		   startTimeLbl_JWH, // "관람시간 : xx:xx"으로 텍스트가 설정되는 레이블.
		   sangyoungLbl_JWH, // "상영관 : x"으로 텍스트가 설정되는 레이블.
		   seatLbl_JWH; // "좌석 : xx"으로 텍스트가 설정되는 레이블.
	JButton[][] seatsBtn_JWH = new JButton[8][12]; // 좌석버튼들이 저장되는 배열. [A~G][1~12].
	String selectSeat_JWH = ""; // 선택한 좌석버튼(seatsBtn)의 텍스트를 getText로 저장하는 변수.
	String st_JWH = ""; // xxxx.xx.xx형식으로 오늘의 날짜를 저장하는 변수.
	/* 좌석선택 화면 컴포넌트 선언 end */
	
	/* 결제진행 화면에서 사용할 컴포넌트 선언 */
	JPanel payPanel_JWH, // 결제진행 화면을 구성하는 패널, BorderLayout으로 설정됨.
		   titlePanel4_JWH, // payPanel의 North에 위치. 뒤로가기(<)버튼과 "결제진행"레이블이 배치됨.
		   payContentPanel_JWH, // payPanel의 Center에 위치. 영화와 금액, 이름, 주민번호, 휴대폰 번호, 인증번호 입력 관련 컴포넌트들이 배치됨.
		   simpleInfoPanel_JWH, // "영화이름(좌석)", "일반 1인", "결제금액 8,000원"레이블들이 배치되는 간략한 정보 패널.
		   msPanel_JWH; // 인증번호전송 버튼, 확인 버튼에 대한 반응들을 보여주는 패널. setVisible(false)가 기본값이며 버튼을 눌렀을 때 true로 변경됨.
	JButton backBtn4_JWH, // 뒤로가기(<)버튼. 결제진행->좌석선택으로 전환되는 기능을 가짐.
			numTransBtn_JWH, // 인증번호전송 버튼. 버튼을 누르면 이름 길이, 주민등록번호 길이, 휴대폰 번호 길이를 판단하고 그에 대한 반응을 msPanel에서 보여줌.
							 // 모든 조건이 충족되면 콘솔창에 인증번호를 출력함 
			confirmBtn_JWH, // 확인 버튼. 버튼을 누르면 출력된 인증번호와 입력된 인증번호가 같은지 비교함. 같으면 결제하기 버튼 활성화.  
			progressBtn_JWH, // 결제하기 버튼. 결제진행->결제완료로 전환되는 기능을 가짐.
			msBtn_JWH; // msPanel의 확인 버튼. 버튼을 누르면 msPanel이 setVisible(false)됨.
	JLabel titleLbl4_JWH, // "결제진행"으로 텍스트가 설정되는 레이블.
		   simpleLbl1_JWH, // "영화제목(좌석)"으로 텍스트가 설정되는 레이블.
		   simpleLbl2_JWH, // "일반 1인"으로 텍스트가 설정되는 레이블.
		   simpleLbl3_JWH, // "결제금액 8,000원"으로 텍스트가 설정되는 레이블.
		   warningLbl_JWH, // "본 어플은 테스트 버전으로 결제 수단이 제한됩니다."로 텍스트가 설정되는 레이블.
		   payName_JWH, // "이름"으로 텍스트가 설정되는 레이블.
		   payResiNum_JWH, // "주민등록번호"로 텍스트가 설정되는 레이블.
		   payPhoneNum_JWH, // "휴대폰 번호"로 텍스트가 설정되는 레이블.
		   payInputNum_JWH, // "인증번호입력"으로 텍스트가 설정되는 레이블.
		   msLbl1_JWH; // msPanel의 반응 정보를 텍스트로 표시하기 위한 레이블.
	JTextField nameTF_JWH, // 이름을 입력하는 텍스트필드.
			   resiNumTF1_JWH, // 주민등록번호 앞자리를 입력하는 텍스트필드.
			   resiNumTF2_JWH, // 주민등록번호 뒷자리 하나를 입력하는 텍스트필드.
			   phoneNumTF_JWH, // 휴대폰번호를 입력하는 텍스트필드.
			   payInputTF_JWH; // 인증번호를 입력하는 텍스트 필드.
	int num1_JWH = 0; // 인증번호 첫번째 숫자.
	int num2_JWH = 0; // 인증번호 두번째 숫자.
	int num3_JWH = 0; // 인증번호 세번째 숫자.
	int num4_JWH = 0; // 인증번호 네번째 숫자.
	int num5_JWH = 0; // 인증번호 다섯번째 숫자.
	int num6_JWH = 0; // 인증번호 여섯번째 숫자.
	int certNum1_JWH = 0; // 바로 아래 certNum2 문자 변수를 다시 숫자로 변환하여 저장하는 변수. (왜인지 문자끼리 서로 비교하니까 안되서 숫자끼리 비교로 바꿈)
	int certNumInput1_JWH = 0; // 바로 아래 certNumInput2 문자 변수를 다시 숫자로 변환하여 저장하는 변수.
	String certNum2_JWH = ""; // num1~6의 여섯자리 인증번호를 문자로 저장하는 변수. 
	String certNumInput2_JWH = ""; // payInputTF에 입력한 인증번호를 문자로 저장하는 변수.
	/* 결제진행 화면 컴포넌트 선언 end */
	
	/* 결제완료 화면에서 사용할 컴포넌트 */
	JPanel sucPanel_JWH, // 결제완료화면을 구성하는 패널. BorderLayout으로 설정됨.
		   titlePanel5_JWH, // sucPanel의 North에 위치. "결제완료"레이블이 배치됨.
		   sucContentPanel_JWH; // sucPanel의 Center에 위치. 결제완료 관련 레이블과 확인 버튼이 배치됨.
	JButton okBtn_JWH; // 확인버튼. 버튼을 누르면 결제완료->메인화면으로 전환되는 기능을 가짐.
	JLabel titleLbl5_JWH, // "결제완료"로 텍스트가 설정되는 레이블.
		   simpleLbl4_JWH, // "결제가 완료되었습니다."로 텍스트가 설정되는 레이블.
		   simpleLbl5_JWH; // "예매표는 [예매확인]에서 확인할 수 있습니다."로 텍스트가 설정되는 레이블.
	/* 결제완료 화면 컴포넌트 선언 end */
	
	/* 예매확인 화면과 예매된 좌석버튼을 disable 시킬 때 사용할 컴포넌트 선언 */
	int ticketCount_JWH = 0; // 티켓 발급 순번을 나타내는 변수. 0부터 시작되고 결제완료가 되면 예매확인 화면에 티켓 발급 후 +1됨.
	boolean[] addTicket_JWH = new boolean[100]; // 예매확인화면에 n번째 티켓이 발급되면 true로 알려주기 위한 변수 배열. 
	JPanel checkPanel_JWH, // 예매확인화면을 구성하는 패널. BorderLayout으로 설정됨.
		   titlePanel6_JWH, // checkPanel의 North에 위치. "예매확인"레이블이 배치됨.
		   checkContentPanel_JWH; // checkPanel의 Center에 위치. 티켓들이 생성됨.
	JButton backBtn6_JWH; // 뒤로가기(<)버튼. 버튼을 누르면 예매확인->메인화면으로 전환되는 기능을 가짐.
	JLabel titleLbl6_JWH; // "예매확인"로 텍스트가 설정되는 레이블.
	JPanel[] tickets_JWH = new JPanel[100]; // n번째 티켓 구성요소들을 모두 담는 패널
	JLabel[] tNameLbl_JWH = new JLabel[100]; // n번째 티켓의 "영화이름(좌석)"으로 텍스트가 설정되는 레이블. 
	JLabel[] tCinemaLbl_JWH = new JLabel[100]; // n번째 티켓의 "서면점 x관"으로 텍스트가 설정되는 레이블.
	JLabel[] tDayLbl_JWH = new JLabel[100]; // n번째 티켓의 "xxxx.xx.xx"(날짜)로 텍스트가 설정되는 레이블.
	JLabel[] tTimeLbl_JWH = new JLabel[100]; // n번째 티켓의 "xx:xx"(시간)로 텍스트가 설정되는 레이블.
	JLabel[] tMentLbl_JWH = new JLabel[100]; // n번째 티켓의 "이 문구가 있다면 정상 결제된 예매표입니다."로 텍스트가 설정되는 레이블.
	String[] ticketsSaveMName = new String[100]; // n번째 티켓의 영화를 저장하는 변수 
//	String[] ticketsMName_JWH = new String[100];
	String[] ticketsSaveSeat_JWH = new String[100]; // n번째 티켓의 좌석 이름을 저장하는 변수
	String[] ticketsMDay_JWH = new String[100]; // n번째 티켓의 날짜를 저장하는 변수
	String[] ticketsMTime_Hour_JWH = new String[100]; // n번째 티켓의 시간에서 시만 저장하는 변수
	String[] ticketsMTime_Minute_JWH = new String[100]; // n번째 티켓의 시간에서 분만 저장하는 변수
	String[] ticketsMTime_JWH = new String[100]; // n번째 티켓의 시간을 모두 저장하는 변수
	String[] ticketsMment_JWH = new String[100]; // "이 문구가 있다면 정상 결제된 예매표입니다."
	JButton[] checkBtns = new JButton[100]; // 선택한 좌석 버튼을 저장하는 버튼 배열.
	/* 예매확인 컴포넌트 선언 end */
	
	boolean addCheck_JWH;
	
	HomeMainPanel_KHJ mainHome;
	
	public MovieClass_JWH(JPanel mainHomePanel) {
		
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		this.setSize(378, 674);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//container_JWH = getContentPane();
		card_JWH = new CardLayout(0,0);
		this.setLayout(card_JWH);
		
		////////////////////////////////////////////////////////
		//////////////////// 메인화면 구성 start ////////////////////
		
		/* 메인 화면의 베이스 패널 설정 */
		mainPanel_JWH = new JPanel();
		mainPanel_JWH.setBackground(Color.WHITE);
		mainPanel_JWH.setLayout(new BorderLayout());
		/* end */
		
		/* 로고가 들어갈 North 패널 설정 */
		logoPanel_JWH = new JPanel(){
			ImageIcon logoBackground_JWH = new ImageIcon("Img/titleBackground.jpg");
			Image logoImg_JWH = logoBackground_JWH.getImage();
			Image change1_JWH = logoImg_JWH.getScaledInstance(378, 200, Image.SCALE_SMOOTH);
			ImageIcon title = new ImageIcon(change1_JWH);
			
			public void paintComponent(Graphics g){
				g.drawImage(title.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		logoPanel_JWH.setLayout(null);
		logoPanel_JWH.setPreferredSize(new Dimension(378, 200));		
		/* end */
		
		/* 영화 목록이 보여질 Center 패널 설정 */
		contentPanel_JWH = new JPanel();
		contentPanel_JWH.setLayout(null);
		contentPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* 영화예매, 예매확인 버튼이 배치될 South 패널 설정 */ 
		buttonPanel_JWH = new JPanel();
		buttonPanel_JWH.setLayout(new GridLayout());
		buttonPanel_JWH.setBackground(new Color(2, 23, 71));
		buttonPanel_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
				
		/* 로고 레이블 설정 */	
		logoLbl_JWH = new JLabel("오늘 뭐볼래?");
		logoLbl_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 55));
		logoLbl_JWH.setBounds(98, 85, 200, 50);
		logoLbl_JWH.setForeground(Color.WHITE);
		logoPanel_JWH.add(logoLbl_JWH);
		/* end */
		
		/* 첫번째 컨텐츠 패널(content1) 구현 */
		content1_JWH = new JPanel(); // content1 : 겨울왕국
		content1_JWH.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
		content1_JWH.setPreferredSize(new Dimension(320, 350));
		content1_JWH.setBackground(Color.WHITE);
		content1_JWH.setBounds(20, 10, 320, 350);
		
		moviePnl1_JWH = new JPanel(){
			ImageIcon movieBackground1_JWH = new ImageIcon("Img/winter.jpg");
			Image movieImg1_JWH = movieBackground1_JWH.getImage();
			Image change2_JWH = movieImg1_JWH.getScaledInstance(320, 170, Image.SCALE_SMOOTH);
			ImageIcon mc1_JWH = new ImageIcon(change2_JWH);
			
			public void paintComponent(Graphics g){
				g.drawImage(mc1_JWH.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		moviePnl1_JWH.setPreferredSize(new Dimension(320, 170));
		
		JLabel titleText1_JWH = new JLabel("겨울왕국2");
		titleText1_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 40));
		titleText1_JWH.setForeground(new Color(2, 23, 71));
		JLabel subText1_JWH = new JLabel("<html>내 마법의 힘은 어디서 왔을까?"
										+ "<br>나를 부르는 저 목소리는 누구지?"
										+ "<br>"
										+ "<br>어느 날 부턴가 의문의 목소리가 엘사를 부르고, "
										+ "<br>평화로운 아렌델 왕국을 위협한다.</html>");
		subText1_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		subText1_JWH.setForeground(new Color(33, 33, 33));
		
		content1_JWH.add(moviePnl1_JWH);
		content1_JWH.add(titleText1_JWH);
		content1_JWH.add(subText1_JWH);
		/* end */
		
		/* 두번째 컨텐츠 패널(content2) 구현  */
		content2_JWH = new JPanel(); // content2 : 천문
		content2_JWH.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
		content2_JWH.setPreferredSize(new Dimension(320, 350));
		content2_JWH.setBackground(Color.WHITE);
		content2_JWH.setBounds(20, 10, 320, 350);
		
		moviePnl2_JWH = new JPanel(){
			ImageIcon movieBackground2_JWH = new ImageIcon("Img/chun.jpg");
			Image movieImg2_JWH = movieBackground2_JWH.getImage();
			Image change2_JWH = movieImg2_JWH.getScaledInstance(320, 170, Image.SCALE_SMOOTH);
			ImageIcon mc2_JWH = new ImageIcon(change2_JWH);
			
			public void paintComponent(Graphics g){
				g.drawImage(mc2_JWH.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		moviePnl2_JWH.setPreferredSize(new Dimension(320, 170));
		
		JLabel titleText2_JWH = new JLabel("천문");
		titleText2_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 40));
		titleText2_JWH.setForeground(new Color(2, 23, 71));
		JLabel subText2_JWH = new JLabel("<html>역사상 가장 위대한 왕 세종"
										+ "<br>관노로 태어나 종3품 대호군이 된 천재 과학자 장영실"
										+ "<br>"
										+ "<br>조선의 시간과 하늘을 만들고자 했던 세종과 장영실!"
										+ "<br>그들의 숨겨진 이야기가 밝혀진다!</html>");
		subText2_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		subText2_JWH.setForeground(new Color(33, 33, 33));
		
		content2_JWH.add(moviePnl2_JWH);
		content2_JWH.add(titleText2_JWH);
		content2_JWH.add(subText2_JWH);
		contentPanel_JWH.add(content2_JWH);
		content2_JWH.setVisible(false);
		/* end */
		
		/* 세번째 컨텐츠 패널(content3) 구현  */
		content3_JWH = new JPanel(); // content3 : 포드V페라리
		content3_JWH.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
		content3_JWH.setPreferredSize(new Dimension(320, 350));
		content3_JWH.setBackground(Color.WHITE);
		content3_JWH.setBounds(20, 10, 320, 350);
		
		moviePnl3_JWH = new JPanel(){
			ImageIcon movieBackground3_JWH = new ImageIcon("Img/fp.jpg");
			Image movieImg3_JWH = movieBackground3_JWH.getImage();
			Image change3_JWH = movieImg3_JWH.getScaledInstance(320, 170, Image.SCALE_SMOOTH);
			ImageIcon mc3_JWH = new ImageIcon(change3_JWH);
			
			public void paintComponent(Graphics g){
				g.drawImage(mc3_JWH.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		moviePnl3_JWH.setPreferredSize(new Dimension(320, 170));
		
		JLabel titleText3_JWH = new JLabel("포드V페라리 ");
		titleText3_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 40));
		titleText3_JWH.setForeground(new Color(2, 23, 71));
		JLabel subText3_JWH = new JLabel("<html>포드의 경영진은 제 멋대로인"
										+ "<br>‘켄 마일스’를 눈엣가시처럼 여기며"
										+ "<br>자신들의 입맛에 맞춘 레이스를 펼치기를 강요하지만"
										+ "<br>두 사람은 어떤 간섭에도 굴하지 않고"
										+ "<br>불가능을 뛰어넘기 위한 질주를 시작하는데…</html>");
		subText3_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		subText3_JWH.setForeground(new Color(33, 33, 33));
		
		content3_JWH.add(moviePnl3_JWH);
		content3_JWH.add(titleText3_JWH);
		content3_JWH.add(subText3_JWH);
		contentPanel_JWH.add(content3_JWH);
		content3_JWH.setVisible(false);
		/* end */
		
		/* 화살표  버튼 구현 */	
		leftBtn_JWH = new JButton("<");
		leftBtn_JWH.addActionListener(this);
		leftBtn_JWH.setContentAreaFilled(false);
		leftBtn_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 30));
		leftBtn_JWH.setForeground(new Color(2, 23, 71));
		leftBtn_JWH.setBorderPainted(false);
		leftBtn_JWH.setBounds(-15, 90, 50, 50);
	
		rightBtn_JWH = new JButton(">");
		rightBtn_JWH.addActionListener(this);
		rightBtn_JWH.setContentAreaFilled(false);
		rightBtn_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 30));
		rightBtn_JWH.setForeground(new Color(2, 23, 71));
		rightBtn_JWH.setBorderPainted(false);
		rightBtn_JWH.setBounds(325, 90, 50, 50);
		
		contentPanel_JWH.add(leftBtn_JWH);
		contentPanel_JWH.add(rightBtn_JWH);	
		/* end */
		
		/* 영화예매, 예매확인 버튼 구현 */
		reserveBtn_JWH = new JButton("영화 예매");
		reserveBtn_JWH.setBackground(new Color(2, 23, 71));
		reserveBtn_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		reserveBtn_JWH.setForeground(Color.WHITE);
		reserveBtn_JWH.setBorderPainted(false);
		reserveBtn_JWH.addActionListener(this);
				
		checkBtn_JWH = new JButton("예매 확인");
		checkBtn_JWH.addActionListener(this);
		checkBtn_JWH.setBackground(new Color(2, 23, 71));
		checkBtn_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		checkBtn_JWH.setForeground(Color.WHITE);
		checkBtn_JWH.setBorderPainted(false);
				
		buttonPanel_JWH.add(reserveBtn_JWH);
		buttonPanel_JWH.add(checkBtn_JWH);
		/* end */

		contentPanel_JWH.add(content1_JWH);
		mainPanel_JWH.add(logoPanel_JWH, "North");
		mainPanel_JWH.add(contentPanel_JWH, "Center");
		mainPanel_JWH.add(buttonPanel_JWH, "South");
		
		//////////////////// 메인화면 end ////////////////////
		//////////////////////////////////////////////////
		
		
		
		
		
		//////////////////////////////////////////////////
		///////////////// 시간선택 화면 구성 Start ///////////////
		
		/* 시간선택 화면 베이스 패널 설정 */
		timePanel_JWH = new JPanel();
		timePanel_JWH.setLayout(new BorderLayout());
		timePanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "시간선택" 레이블이 들어갈 North 패널 설정 */
		titlePanel2_JWH = new JPanel();
		titlePanel2_JWH.setLayout(null);
		titlePanel2_JWH.setBackground(new Color(2, 23, 71));
		titlePanel2_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* 영화 별 시간 버튼이 들어갈 Center 패널 설정 */
		timeSelectPanel_JWH = new JPanel();
		timeSelectPanel_JWH.setLayout(null);
		timeSelectPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* 뒤로가기 버튼 구현 */
		backBtn2_JWH = new JButton("<");
		backBtn2_JWH.addActionListener(this);
		backBtn2_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 40));
		backBtn2_JWH.setForeground(Color.WHITE);
		backBtn2_JWH.setBounds(3, 5, 50, 50);
		backBtn2_JWH.setContentAreaFilled(false);
		backBtn2_JWH.setBorderPainted(false);
		titlePanel2_JWH.add(backBtn2_JWH);
		/* end */
		
		/* "시간선택" 레이블 구현 */
		titleLbl2_JWH = new JLabel("시간선택");
		titleLbl2_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		titleLbl2_JWH.setForeground(Color.WHITE);
		titleLbl2_JWH.setBounds(140, 6, 100, 50);
		titlePanel2_JWH.add(titleLbl2_JWH);
		/* end */
		
		/* "1관 겨울왕국" 레이블 구현 */
		g1_winter = new JLabel("1관 겨울왕국");
		g1_winter.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		g1_winter.setForeground(new Color(33, 33, 33));
		g1_winter.setBounds(20, 50, 200, 50);
		timeSelectPanel_JWH.add(g1_winter);
		/* end */
		
		/* 겨울왕국 16:10 버튼 구현 */
		winter1610 = new JButton("16:10");
		winter1610.addActionListener(this);
		winter1610.setFont(new Font("휴먼아미체", Font.PLAIN, 18));
		winter1610.setBackground(new Color(2, 23, 71));
		winter1610.setForeground(Color.WHITE);
		winter1610.setBorderPainted(false);
		winter1610.setBorder(null);
		winter1610.setBounds(20, 100, 60, 30);
		timeSelectPanel_JWH.add(winter1610);
		/* end */
		
		/* 겨울왕국 18:40 버튼 구현 */
		winter1840 = new JButton("18:40");
		winter1840.addActionListener(this);
		winter1840.setFont(new Font("휴먼아미체", Font.PLAIN, 18));
		winter1840.setBackground(new Color(2, 23, 71));
		winter1840.setForeground(Color.WHITE);
		winter1840.setBorderPainted(false);
		winter1840.setBorder(null);
		winter1840.setBounds(90, 100, 60, 30);
		timeSelectPanel_JWH.add(winter1840);
		/* end */
		
		/* "2관 천문" 레이블 구현 */
		g2_chun = new JLabel("2관 천문");
		g2_chun.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		g2_chun.setForeground(new Color(33, 33, 33));
		g2_chun.setBounds(20, 180, 200, 50);
		timeSelectPanel_JWH.add(g2_chun);
		/* end */
		
		/* 천문 12:50 버튼 구현 */
		chun1250 = new JButton("12:50");
		chun1250.addActionListener(this);
		chun1250.setFont(new Font("휴먼아미체", Font.PLAIN, 18));
		chun1250.setBackground(new Color(2, 23, 71));
		chun1250.setForeground(Color.WHITE);
		chun1250.setBorderPainted(false);
		chun1250.setBorder(null);
		chun1250.setBounds(20, 230, 60, 30);
		timeSelectPanel_JWH.add(chun1250);
		/* end */
		
		/* 천문 20:30 버튼 구현 */
		chun2030 = new JButton("20:30");
		chun2030.addActionListener(this);
		chun2030.setFont(new Font("휴먼아미체", Font.PLAIN, 18));
		chun2030.setBackground(new Color(2, 23, 71));
		chun2030.setForeground(Color.WHITE);
		chun2030.setBorderPainted(false);
		chun2030.setBorder(null);
		chun2030.setBounds(90, 230, 60, 30);
		timeSelectPanel_JWH.add(chun2030);
		/* end */
		
		/* "3관 포드V페라리" 레이블 구현 */
		g3_ff = new JLabel("3관 포드V페라리");
		g3_ff.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		g3_ff.setForeground(new Color(33, 33, 33));
		g3_ff.setBounds(20, 310, 200, 50);
		timeSelectPanel_JWH.add(g3_ff);
		/* end */
		
		/* 포드V페라리 15:15 버튼 구현 */
		ff1515 = new JButton("15:15");
		ff1515.addActionListener(this);
		ff1515.setFont(new Font("휴먼아미체", Font.PLAIN, 18));
		ff1515.setBackground(new Color(2, 23, 71));
		ff1515.setForeground(Color.WHITE);
		ff1515.setBorderPainted(false);
		ff1515.setBorder(null);
		ff1515.setBounds(20, 360, 60, 30);
		timeSelectPanel_JWH.add(ff1515);
		/* end */
		
		/* 포드V페라리 21:00 버튼 구현 */
		ff2100 = new JButton("21:00");
		ff2100.addActionListener(this);
		ff2100.setFont(new Font("휴먼아미체", Font.PLAIN, 18));
		ff2100.setBackground(new Color(2, 23, 71));
		ff2100.setForeground(Color.WHITE);
		ff2100.setBorderPainted(false);
		ff2100.setBorder(null);
		ff2100.setBounds(90, 360, 60, 30);
		timeSelectPanel_JWH.add(ff2100);
		/* end */

		timePanel_JWH.add(titlePanel2_JWH, "North");
		timePanel_JWH.add(timeSelectPanel_JWH, "Center");		
		///////////////// 시간선택 화면 end  ///////////////////
		//////////////////////////////////////////////////
		
		
		
		
		
		//////////////////////////////////////////////////
		///////////////// 좌석선택 화면 구성  ////////////////////
		
		/* 좌석선택 화면 베이스 패널 설정 */
		seatPanel_JWH = new JPanel();
		seatPanel_JWH.setBackground(Color.WHITE);
		seatPanel_JWH.setLayout(new BorderLayout());
		/* end */
		
		/* "좌석선택" 레이블이 들어갈 North 패널 설정 */
		titlePanel3_JWH = new JPanel();
		titlePanel3_JWH.setLayout(null);
		titlePanel3_JWH.setBackground(new Color(2, 23, 71));
		titlePanel3_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* 좌석 버튼들이 들어갈 Center 패널 설정 */
		seatSelectPanel_JWH = new JPanel();
		seatSelectPanel_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		seatSelectPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* 선택한 정보가 표시될 South 패널 설정 */
		informPanel_JWH = new JPanel();
		informPanel_JWH.setLayout(null);
		informPanel_JWH.setBackground(new Color(2, 23, 71));
		informPanel_JWH.setPreferredSize(new Dimension(378, 150));
		/* end */
		
		/* 뒤로가기 버튼 구현 */
		backBtn3_JWH = new JButton("<");
		backBtn3_JWH.addActionListener(this);
		backBtn3_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 40));
		backBtn3_JWH.setForeground(Color.WHITE);
		backBtn3_JWH.setBounds(3, 5, 50, 50);
		backBtn3_JWH.setContentAreaFilled(false);
		backBtn3_JWH.setBorderPainted(false);
		titlePanel3_JWH.add(backBtn3_JWH);
		/* end */
		
		/* "좌석선택" 레이블 구현 */
		titleLbl3_JWH = new JLabel("좌석선택");
		titleLbl3_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		titleLbl3_JWH.setForeground(Color.WHITE);
		titleLbl3_JWH.setBounds(140, 6, 100, 50);
		titlePanel3_JWH.add(titleLbl3_JWH);
		/* end */
		
		/* "Screen" 레이블이 들어갈 패널 설정 */ 
		lineScreen_JWH = new JPanel();
		lineScreen_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineScreen_JWH.setPreferredSize(new Dimension(320, 40));
		lineScreen_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineScreen_JWH);
		
		/* 빈칸으로 놔둘 패널 */
		line0_JWH = new JPanel();
		line0_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		line0_JWH.setPreferredSize(new Dimension(320, 20));
		line0_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(line0_JWH);
		/* end */
		
		/* 좌석 버튼을 넣을 라인 패널 생성 후 위에서부터 순서대로 배치 */
		lineA_JWH = new JPanel();
		lineA_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineA_JWH.setPreferredSize(new Dimension(320, 40));
		lineA_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineA_JWH);
		
		lineB_JWH = new JPanel();
		lineB_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineB_JWH.setPreferredSize(new Dimension(320, 40));
		lineB_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineB_JWH);
		
		lineC_JWH = new JPanel();
		lineC_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineC_JWH.setPreferredSize(new Dimension(320, 40));
		lineC_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineC_JWH);
		
		lineD_JWH = new JPanel();
		lineD_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineD_JWH.setPreferredSize(new Dimension(320, 40));
		lineD_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineD_JWH);
		
		lineE_JWH = new JPanel();
		lineE_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineE_JWH.setPreferredSize(new Dimension(320, 40));
		lineE_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineE_JWH);
		
		lineF_JWH = new JPanel();
		lineF_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineF_JWH.setPreferredSize(new Dimension(320, 40));
		lineF_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineF_JWH);
		
		lineG_JWH = new JPanel();
		lineG_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineG_JWH.setPreferredSize(new Dimension(320, 40));
		lineG_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineG_JWH);
		/* end */
		
		/* 좌석 버튼들을 생성하고 각 라인 패널에 붙임 */
		JLabel screen_JWH = new JLabel("Screen");
		screen_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 30));
		screen_JWH.setForeground(new Color(2, 23, 71));
		lineScreen_JWH.add(screen_JWH);
		
		for(int i=0; i<=7; i++){
			seatsBtn_JWH[0][i] = new JButton("A"+(i+1));
			seatsBtn_JWH[0][i].addActionListener(this);
			seatsBtn_JWH[0][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[0][i].setFont(new Font("휴먼아미체", Font.PLAIN, 28));
			seatsBtn_JWH[0][i].setForeground(Color.WHITE);
			seatsBtn_JWH[0][i].setBorder(null);
			seatsBtn_JWH[0][i].setBorderPainted(false);			
			lineA_JWH.add(seatsBtn_JWH[0][i]);
			
			seatsBtn_JWH[1][i] = new JButton("B"+(i+1));
			seatsBtn_JWH[1][i].addActionListener(this);
			seatsBtn_JWH[1][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[1][i].setFont(new Font("휴먼아미체", Font.PLAIN, 28));
			seatsBtn_JWH[1][i].setForeground(Color.WHITE);
			seatsBtn_JWH[1][i].setBorder(null);
			seatsBtn_JWH[1][i].setBorderPainted(false);
			lineB_JWH.add(seatsBtn_JWH[1][i]);
		}
		
		for(int i=0; i<12; i++){
			seatsBtn_JWH[2][i] = new JButton("C"+(i+1));
			seatsBtn_JWH[2][i].addActionListener(this);
			seatsBtn_JWH[2][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[2][i].setFont(new Font("휴먼아미체", Font.PLAIN, 28));
			seatsBtn_JWH[2][i].setForeground(Color.WHITE);
			seatsBtn_JWH[2][i].setBorder(null);
			seatsBtn_JWH[2][i].setBorderPainted(false);
			lineC_JWH.add(seatsBtn_JWH[2][i]);
			
			seatsBtn_JWH[3][i] = new JButton("D"+(i+1));
			seatsBtn_JWH[3][i].addActionListener(this);
			seatsBtn_JWH[3][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[3][i].setFont(new Font("휴먼아미체", Font.PLAIN, 28));
			seatsBtn_JWH[3][i].setForeground(Color.WHITE);
			seatsBtn_JWH[3][i].setBorder(null);
			seatsBtn_JWH[3][i].setBorderPainted(false);
			lineD_JWH.add(seatsBtn_JWH[3][i]);
			
			seatsBtn_JWH[4][i] = new JButton("E"+(i+1));
			seatsBtn_JWH[4][i].addActionListener(this);
			seatsBtn_JWH[4][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[4][i].setFont(new Font("휴먼아미체", Font.PLAIN, 28));
			seatsBtn_JWH[4][i].setForeground(Color.WHITE);
			seatsBtn_JWH[4][i].setBorder(null);
			seatsBtn_JWH[4][i].setBorderPainted(false);
			lineE_JWH.add(seatsBtn_JWH[4][i]);
			
			seatsBtn_JWH[5][i] = new JButton("F"+(i+1));
			seatsBtn_JWH[5][i].addActionListener(this);
			seatsBtn_JWH[5][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[5][i].setFont(new Font("휴먼아미체", Font.PLAIN, 28));
			seatsBtn_JWH[5][i].setForeground(Color.WHITE);
			seatsBtn_JWH[5][i].setBorder(null);
			seatsBtn_JWH[5][i].setBorderPainted(false);
			lineF_JWH.add(seatsBtn_JWH[5][i]);
			
			seatsBtn_JWH[6][i] = new JButton("G"+(i+1));
			seatsBtn_JWH[6][i].addActionListener(this);
			seatsBtn_JWH[6][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[6][i].setFont(new Font("휴먼아미체", Font.PLAIN, 28));
			seatsBtn_JWH[6][i].setForeground(Color.WHITE);
			seatsBtn_JWH[6][i].setBorder(null);
			seatsBtn_JWH[6][i].setBorderPainted(false);
			lineG_JWH.add(seatsBtn_JWH[6][i]);		
		}
		/* end */
		
		/* 선택한 영화에 따라 setText로 영화이름으로 바뀔 레이블 구현 */
		movieNameLbl_JWH = new JLabel("");
		movieNameLbl_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 30));
		movieNameLbl_JWH.setForeground(Color.ORANGE);
		movieNameLbl_JWH.setBounds(108, 5, 300, 50);
		informPanel_JWH.add(movieNameLbl_JWH);
		/* end */
		
		/* "극장 : 서면점" 레이블 구현 */
		cinemaLbl_JWH = new JLabel("극장 : 서면점");
		cinemaLbl_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 19));
		cinemaLbl_JWH.setForeground(Color.WHITE);
		cinemaLbl_JWH.setBounds(110, 35, 100, 50);
		informPanel_JWH.add(cinemaLbl_JWH);
		/* end */
		
		/* st_JWH에 오늘 날짜를 저장 후 다시 +1일을 시킨 날짜를 저장 */
		/* 이 날짜를 관람일으로하여 informPanel에 setBounds로 붙임 */
		Calendar c_JWH = Calendar.getInstance();;
		SimpleDateFormat dateFormat_JWH = new SimpleDateFormat("yyyy.MM.dd");	
		st_JWH = dateFormat_JWH.format(c_JWH.getTime());
		try {
			c_JWH.setTime(dateFormat_JWH.parse(st_JWH));
			c_JWH.add(Calendar.DATE, 1);
			st_JWH = dateFormat_JWH.format(c_JWH.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		dayLbl_JWH = new JLabel("관람일 : " + st_JWH);
		dayLbl_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 19));
		dayLbl_JWH.setForeground(Color.WHITE);
		dayLbl_JWH.setBounds(220, 35, 150, 50);
		informPanel_JWH.add(dayLbl_JWH);
		/* end */
		
		/* 선택한 영화에 따라 시간이 바뀔 "관람 시간" 레이블 구현 */
		startTimeLbl_JWH = new JLabel("");
		startTimeLbl_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 19));
		startTimeLbl_JWH.setForeground(Color.WHITE);
		startTimeLbl_JWH.setBounds(110, 65, 170, 50);
		informPanel_JWH.add(startTimeLbl_JWH);
		/* end */
		
		/* 상영관 레이블 구현. winter : 1관, chun : 2관, ff : 3관 */
		sangyoungLbl_JWH = new JLabel("상영관 : ");
		sangyoungLbl_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 19));
		sangyoungLbl_JWH.setForeground(Color.WHITE);
		sangyoungLbl_JWH.setBounds(220, 65, 170, 50);
		informPanel_JWH.add(sangyoungLbl_JWH);
		/* end */
		
		/* 선택한 좌석을 보여줄 "좌석 : " 레이블 구현 */
		seatLbl_JWH = new JLabel("좌석 : ");
		seatLbl_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 19));
		seatLbl_JWH.setForeground(Color.WHITE);
		seatLbl_JWH.setBounds(110, 95, 170, 50);
		informPanel_JWH.add(seatLbl_JWH);
		/* end */
		
		/* 결제진행 버튼 구현 */
		goPay_JWH = new JButton("결제진행 >");
		goPay_JWH.addActionListener(this);
		goPay_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 26));
		goPay_JWH.setForeground(Color.WHITE);
		goPay_JWH.setBorder(null);
		goPay_JWH.setBorderPainted(false);
		goPay_JWH.setContentAreaFilled(false);
		goPay_JWH.setBounds(230, 105, 150, 50);
		goPay_JWH.setEnabled(false);
		informPanel_JWH.add(goPay_JWH);
		/* end */
		
		seatPanel_JWH.add(titlePanel3_JWH, "North");
		seatPanel_JWH.add(seatSelectPanel_JWH, "Center");
		seatPanel_JWH.add(informPanel_JWH, "South");
		
		////////////////// 좌석선택 화면 end ///////////////////
		//////////////////////////////////////////////////
		
		
		
		
		//////////////////////////////////////////////////
		///////////////// 결제진행 화면 구성  ////////////////////
		
		/* 결제진행 화면 베이스 패널 구현 */
		payPanel_JWH = new JPanel();
		payPanel_JWH.setLayout(new BorderLayout());
		payPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "결제진행" 레이블이 들어갈 North 패널 설정 */
		titlePanel4_JWH = new JPanel();
		titlePanel4_JWH.setLayout(null);
		titlePanel4_JWH.setBackground(new Color(2, 23, 71));
		titlePanel4_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* 결제 관련 컴포넌트들이 들어갈 Center 패널 설정 */ 
		payContentPanel_JWH = new JPanel();
		payContentPanel_JWH.setLayout(null);
		payContentPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* 뒤로가기 버튼 구현 */
		backBtn4_JWH = new JButton("<");
		backBtn4_JWH.addActionListener(this);
		backBtn4_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 40));
		backBtn4_JWH.setForeground(Color.WHITE);
		backBtn4_JWH.setBounds(3, 5, 50, 50);
		backBtn4_JWH.setContentAreaFilled(false);
		backBtn4_JWH.setBorderPainted(false);
		titlePanel4_JWH.add(backBtn4_JWH);
		/* end */
		
		/* "결제진행" 레이블 구현 */
		titleLbl4_JWH = new JLabel("결제진행");
		titleLbl4_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		titleLbl4_JWH.setForeground(Color.WHITE);
		titleLbl4_JWH.setBounds(140, 6, 100, 50);
		titlePanel4_JWH.add(titleLbl4_JWH);
		/* end */
		
		/* 영화이름, 금액이 간단하게 표시될 패널 설정 */
		simpleInfoPanel_JWH = new JPanel();
		simpleInfoPanel_JWH.setLayout(null);
		simpleInfoPanel_JWH.setBackground(new Color(2, 23, 71));
		simpleInfoPanel_JWH.setBounds(22, 80, 320, 160);
		payContentPanel_JWH.add(simpleInfoPanel_JWH);
		/* end */
		
		/* 제한 알림 레이블 구현 */
		warningLbl_JWH = new JLabel("본 어플은 테스트 버전으로 결제 수단이 제한됩니다.");
		warningLbl_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		warningLbl_JWH.setForeground(Color.RED);
		warningLbl_JWH.setBounds(23, 240, 320, 30);
		payContentPanel_JWH.add(warningLbl_JWH);
		/* end */
		
		/* "영화제목" 레이블 구현 */
		simpleLbl1_JWH = new JLabel("영화제목");
		simpleLbl1_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 48));
		simpleLbl1_JWH.setForeground(Color.WHITE);
		simpleLbl1_JWH.setBounds(7, -10, 300, 100);
		simpleInfoPanel_JWH.add(simpleLbl1_JWH);
		/* end */
		
		/* "일반 1인" 레이블 구현 */
		simpleLbl2_JWH = new JLabel("일반 1인");
		simpleLbl2_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		simpleLbl2_JWH.setForeground(Color.WHITE);
		simpleLbl2_JWH.setBounds(230, 40, 250, 100);
		simpleInfoPanel_JWH.add(simpleLbl2_JWH);
		/* end */
		
		/* "결제금액 8,000원" 레이블 구현 */
		simpleLbl3_JWH = new JLabel("결제금액 8,000원");
		simpleLbl3_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		simpleLbl3_JWH.setForeground(Color.WHITE);
		simpleLbl3_JWH.setBounds(142, 82, 250, 100);
		simpleInfoPanel_JWH.add(simpleLbl3_JWH);
		/* end */
		
		/* "이름" 레이블 구현 */
		payName_JWH = new JLabel("이름");
		payName_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 25));
		payName_JWH.setForeground(new Color(25, 25, 25));
		payName_JWH.setBounds(82, 300, 50, 30);
		payContentPanel_JWH.add(payName_JWH);
		/* end */
		
		/* 이름 텍스트필드 구현 */
		nameTF_JWH = new JTextField(10);
		nameTF_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		nameTF_JWH.setBounds(125, 300, 80, 30);
		payContentPanel_JWH.add(nameTF_JWH);
		/* end */
		
		/* 주민등록번호 레이블 구현 */
		payResiNum_JWH = new JLabel("주민등록번호");
		payResiNum_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 25));
		payResiNum_JWH.setForeground(new Color(25, 25, 25));
		payResiNum_JWH.setBounds(35, 340, 150, 30);
		payContentPanel_JWH.add(payResiNum_JWH);
		/* end */
		
		/* 주민등록번호 앞자리 텍스트필드 구현 */
		resiNumTF1_JWH = new JTextField();
		resiNumTF1_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		resiNumTF1_JWH.setBounds(125, 340, 80, 30);
		payContentPanel_JWH.add(resiNumTF1_JWH);
		/* end */
		
		/* "-" 레이블 구현(xxxxxx - x) */
		JLabel minusLbl_JWH = new JLabel("-");
		minusLbl_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 25));
		minusLbl_JWH.setForeground(new Color(25, 25, 25));
		minusLbl_JWH.setBounds(210, 342, 20, 20);
		payContentPanel_JWH.add(minusLbl_JWH);
		/* end */
		
		/* 주민등록번호 뒷자리 텍스트필드 구현 */
		resiNumTF2_JWH = new JTextField();
		resiNumTF2_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		resiNumTF2_JWH.setBounds(227, 340, 20, 30);
		payContentPanel_JWH.add(resiNumTF2_JWH);
		/* end */
		
		/* "******" 레이블 구현 */
		JLabel resiNumStar_JWH = new JLabel("******");
		resiNumStar_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 25));
		resiNumStar_JWH.setForeground(new Color(25, 25, 25));
		resiNumStar_JWH.setBounds(250, 340, 150, 20);
		payContentPanel_JWH.add(resiNumStar_JWH);
		/* end */
		
		/* "휴대폰 번호" 레이블 */
		payPhoneNum_JWH = new JLabel("휴대폰 번호");
		payPhoneNum_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 25));
		payPhoneNum_JWH.setForeground(new Color(25, 25, 25));
		payPhoneNum_JWH.setBounds(33, 380, 150, 30);
		payContentPanel_JWH.add(payPhoneNum_JWH);
		/* end */
		
		/* 휴대폰 번호 텍스트필드 구현 */
		phoneNumTF_JWH = new JTextField();
		phoneNumTF_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		phoneNumTF_JWH.setBounds(125, 380, 110, 30);
		payContentPanel_JWH.add(phoneNumTF_JWH);
		/* end */
		
		/* 인증번호전송 버튼 구현 */
		numTransBtn_JWH = new JButton("인증번호전송");
		numTransBtn_JWH.addActionListener(this);
		numTransBtn_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 22));
		numTransBtn_JWH.setForeground(new Color(2, 23, 71));
		numTransBtn_JWH.setBorder(null);
		numTransBtn_JWH.setBorderPainted(false);
		numTransBtn_JWH.setContentAreaFilled(false);
		numTransBtn_JWH.setBounds(200, 380, 150, 30);
		payContentPanel_JWH.add(numTransBtn_JWH);
		/* end */
		
		/* "인증번호입력" 레이블 구현 */
		payInputNum_JWH = new JLabel("인증번호입력");
		payInputNum_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 25));
		payInputNum_JWH.setForeground(new Color(25, 25, 25));
		payInputNum_JWH.setBounds(31, 420, 150, 30);
		payContentPanel_JWH.add(payInputNum_JWH);
		/* end */
		
		/* 인증번호입력 텍스트필드 구현 */
		payInputTF_JWH = new JTextField();
		payInputTF_JWH.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		payInputTF_JWH.setBounds(125, 420, 110, 30);
		payContentPanel_JWH.add(payInputTF_JWH);
		/* end */
		
		/* 확인 버튼 구현 */
		confirmBtn_JWH = new JButton("확인");
		confirmBtn_JWH.addActionListener(this);
		confirmBtn_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 22));
		confirmBtn_JWH.setForeground(new Color(2, 23, 71));
		confirmBtn_JWH.setBorder(null);
		confirmBtn_JWH.setBorderPainted(false);
		confirmBtn_JWH.setContentAreaFilled(false);
		confirmBtn_JWH.setBounds(180, 420, 150, 30);
		payContentPanel_JWH.add(confirmBtn_JWH);
		/* end */
		
		/* 결제하기 버튼 구현 */
		progressBtn_JWH = new JButton("결제하기");
		progressBtn_JWH.addActionListener(this);
		progressBtn_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 27));
		progressBtn_JWH.setBackground(new Color(2, 23, 71));
		progressBtn_JWH.setForeground(Color.WHITE);
		progressBtn_JWH.setBorder(null);
		progressBtn_JWH.setBorderPainted(false);
		progressBtn_JWH.setBounds(41, 480, 280, 33);
		progressBtn_JWH.setEnabled(false);
		payContentPanel_JWH.add(progressBtn_JWH);
		/* end */
		
		/* 인증번호전송 버튼을 눌렀을 때 반응을 보여줄 메시지 패널 설정 */
		msPanel_JWH = new JPanel();
		msPanel_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		msPanel_JWH.setBackground(Color.WHITE);
		TitledBorder msPanelBorder_JWH = new TitledBorder(new LineBorder(new Color(40, 40, 40)));
		msPanel_JWH.setBorder(msPanelBorder_JWH);
		msPanel_JWH.setBounds(55, 270, 250, 70);
		payPanel_JWH.add(msPanel_JWH);
		msPanel_JWH.setVisible(false);
		
		/* 메시지 내용을 보여줄 레이블 구현 */
		msLbl1_JWH = new JLabel();
		msLbl1_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 20));
		msLbl1_JWH.setForeground(new Color(25, 25, 25));
		msPanel_JWH.add(msLbl1_JWH);
		/* end */
		
		/* msPanel을 닫을 때 필요한 확인 버튼 구현 */
		msBtn_JWH = new JButton("확인");
		msBtn_JWH.addActionListener(this);
		msBtn_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 20));
		msBtn_JWH.setBackground(new Color(2, 23, 71));
		msBtn_JWH.setForeground(Color.WHITE);
		msBtn_JWH.setPreferredSize(new Dimension(100, 30));
		msBtn_JWH.setBorder(null);
		msBtn_JWH.setBorderPainted(false);
		msPanel_JWH.add(msBtn_JWH);
		/* end */
					
		payPanel_JWH.add(titlePanel4_JWH, "North");
		payPanel_JWH.add(payContentPanel_JWH, "Center");
		
		///////////////// 결제진행 화면 end  ///////////////////
		//////////////////////////////////////////////////
		
		
		
		
		
		//////////////////////////////////////////////////
		//////////////////// 결제완료 화면 /////////////////////
		
		/* 결제완료 화면 베이스 패널 설정 */
		sucPanel_JWH = new JPanel();
		sucPanel_JWH.setLayout(new BorderLayout());
		sucPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "결제완료" 레이블이 들어갈 North 패널 설정 */
		titlePanel5_JWH = new JPanel();
		titlePanel5_JWH.setLayout(null);
		titlePanel5_JWH.setBackground(new Color(2, 23, 71));
		titlePanel5_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* "결제완료" 레이블 구현 */
		titleLbl5_JWH = new JLabel("결제완료");
		titleLbl5_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		titleLbl5_JWH.setForeground(Color.WHITE);
		titleLbl5_JWH.setBounds(140, 6, 100, 50);
		titlePanel5_JWH.add(titleLbl5_JWH);
		/* end */
		
		/* 결제완료를 알려줄 컴포넌트들이 들어갈 Center 패널 설정 */
		sucContentPanel_JWH = new JPanel();
		sucContentPanel_JWH.setLayout(null);
		sucContentPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "결제가 완료되었습니다." 레이블 구현 */
		simpleLbl4_JWH = new JLabel("결제가 완료되었습니다.");
		simpleLbl4_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		simpleLbl4_JWH.setForeground(new Color(2, 23, 71));
		simpleLbl4_JWH.setBounds(79, 160, 250, 50);
		sucContentPanel_JWH.add(simpleLbl4_JWH);
		/* end */
		
		/* "예매표는 [예매확인]에서 확인할 수 있습니다." 레이블 구현 */
		simpleLbl5_JWH = new JLabel("예매표는 [예매확인]에서 확인할 수 있습니다.");
		simpleLbl5_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 22));
		simpleLbl5_JWH.setForeground(new Color(25, 25, 25));
		simpleLbl5_JWH.setBounds(38, 200, 300, 50);
		sucContentPanel_JWH.add(simpleLbl5_JWH);
		/* end */
		
		/* 확인 버튼 구현 */
		okBtn_JWH = new JButton("확인");
		okBtn_JWH.addActionListener(this);
		okBtn_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 27));
		okBtn_JWH.setBackground(new Color(2, 23, 71));
		okBtn_JWH.setForeground(Color.WHITE);
		okBtn_JWH.setBorder(null);
		okBtn_JWH.setBorderPainted(false);
		okBtn_JWH.setBounds(41, 260, 280, 33);
		sucContentPanel_JWH.add(okBtn_JWH);
		/* end */		
		
		sucPanel_JWH.add(titlePanel5_JWH, "North");
		sucPanel_JWH.add(sucContentPanel_JWH, "Center");
		
		/////////////////// 결제완료 end /////////////////////
		//////////////////////////////////////////////////
		
		
		
		
		//////////////////////////////////////////////////
		////////////////////// 예매확인 //////////////////////
		
		/* 예매확인 화면 베이스 패널 설정 */
		checkPanel_JWH = new JPanel();
		checkPanel_JWH.setLayout(new BorderLayout());
		checkPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "예매확인" 레이블이 들어갈 North 패널 설정 */
		titlePanel6_JWH = new JPanel();
		titlePanel6_JWH.setLayout(null);
		titlePanel6_JWH.setBackground(new Color(2, 23, 71));
		titlePanel6_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* 티켓들이 생성될 Center 패널 설정 */
		checkContentPanel_JWH = new JPanel();
		checkContentPanel_JWH.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		checkContentPanel_JWH.setBackground(Color.WHITE);
		checkContentPanel_JWH.setPreferredSize(new Dimension(350, 1200));
		JScrollPane checkSP_JWH = new JScrollPane();
		checkSP_JWH.setViewportView(checkContentPanel_JWH);
		/* end */
		
		/* 뒤로가기 버튼 구현 */
		backBtn6_JWH = new JButton("<");
		backBtn6_JWH.addActionListener(this);
		backBtn6_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 40));
		backBtn6_JWH.setForeground(Color.WHITE);
		backBtn6_JWH.setBounds(3, 5, 50, 50);
		backBtn6_JWH.setContentAreaFilled(false);
		backBtn6_JWH.setBorderPainted(false);
		titlePanel6_JWH.add(backBtn6_JWH);
		/* end */
		
		/* "예매확인" 레이블 구현 */
		titleLbl6_JWH = new JLabel("예매확인");
		titleLbl6_JWH.setFont(new Font("휴먼아미체", Font.PLAIN, 32));
		titleLbl6_JWH.setForeground(Color.WHITE);
		titleLbl6_JWH.setBounds(140, 6, 100, 50);
		titlePanel6_JWH.add(titleLbl6_JWH);
		/* end */
		
		checkPanel_JWH.add(titlePanel6_JWH, "North");
		checkPanel_JWH.add(checkSP_JWH, "Center");
	
		/* 카드 레이아웃에 붙이고 메인화면을 가장 먼저 보여줌 */
		this.add("main", mainPanel_JWH);
		this.add("time", timePanel_JWH);
		this.add("seat", seatPanel_JWH);
		this.add("pay", payPanel_JWH);
		this.add("suc", sucPanel_JWH);
		this.add("check", checkPanel_JWH);
		card_JWH.show(this, "main");
		/* end */
		
		//this.setVisible(true);
		//this.setResizable(false); // 프레임 크기 설정 불가능
		
		
	}

	public void line_view(){
	
		HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1] = new JPanel(new BorderLayout());
		HomeMainPanel_KHJ.kakao_View1.view2_userName[HomeMainPanel_KHJ.kakao_View1.cnt-1] =new JLabel(HomeMainPanel_KHJ.kakao_View1.userName_[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		HomeMainPanel_KHJ.kakao_View1.view2_userName[HomeMainPanel_KHJ.kakao_View1.cnt-1].setFont(new Font("휴먼옛체",Font.BOLD, 20));
		HomeMainPanel_KHJ.kakao_View1.message[HomeMainPanel_KHJ.kakao_View1.cnt-1] = new JLabel(HomeMainPanel_KHJ.kakao_View1.message_[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBackground(Color.WHITE);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1] = new JButton();
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].setLayout(new GridLayout(2,0));
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].add(HomeMainPanel_KHJ.kakao_View1.view2_userName[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].add(HomeMainPanel_KHJ.kakao_View1.message[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].addActionListener(HomeMainPanel_KHJ.kakao_View1);
		HomeMainPanel_KHJ.kakao_View1.message[HomeMainPanel_KHJ.kakao_View1.cnt-1].setFont(HomeMainPanel_KHJ.kakao_View1.font3);
		HomeMainPanel_KHJ.kakao_View1.message[HomeMainPanel_KHJ.kakao_View1.cnt-1].setForeground(Color.GRAY);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBackground(Color.WHITE);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBorderPainted(false);
		HomeMainPanel_KHJ.kakao_View1.profileimageB[HomeMainPanel_KHJ.kakao_View1.cnt-1] = new JButton(new ImageIcon("homeImage/appicon/movie2.png"));
		HomeMainPanel_KHJ.kakao_View1.profileimageB[HomeMainPanel_KHJ.kakao_View1.cnt-1].setContentAreaFilled(false);
		//HomeMainPanel_KHJ.kakao_View1.profilImage[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBorder(null);
		HomeMainPanel_KHJ.kakao_View1.profileimageB[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBorderPainted(false);
		HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1].add(HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1], "Center");	
		HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1].add(HomeMainPanel_KHJ.kakao_View1.profileimageB[HomeMainPanel_KHJ.kakao_View1.cnt-1],"West");
		HomeMainPanel_KHJ.kakao_View1.view2_Center.add(HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		
		}

	
	
	/* 액션 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/* 메인화면에서 왼쪽 화살표를 눌렀을 때 영화가 바뀌는 것을 처리함 */
		if(e.getSource() == leftBtn_JWH){
			if(select_JWH == "ff"){
				content3_JWH.setVisible(false);
				content1_JWH.setVisible(true);
				select_JWH = "winter";
				revalidate();
				repaint();
			} else if(select_JWH == "winter"){
				content1_JWH.setVisible(false);
				content2_JWH.setVisible(true);
				select_JWH = "chun";
				revalidate();
				repaint();
			} else if(select_JWH == "chun"){
				content2_JWH.setVisible(false);	
				content3_JWH.setVisible(true);
				select_JWH = "ff";
				revalidate();
				repaint();
			}
		/* end */
			
		/* 메인화면에서 오른쪽 화살표를 눌렀을 때 영화가 바뀌는 것을 처리함 */
		} else if(e.getSource() == rightBtn_JWH){
			if(select_JWH == "ff"){
				content2_JWH.setVisible(true);
				content3_JWH.setVisible(false);
				select_JWH = "chun";
			} else if(select_JWH == "winter"){
				content3_JWH.setVisible(true);
				content1_JWH.setVisible(false);
				select_JWH = "ff";
			} else if(select_JWH == "chun") {
				content1_JWH.setVisible(true);
				content2_JWH.setVisible(false);
				select_JWH = "winter";
			}
		}
		/* end */
		
		/* 메인화면에서 영화예매 버튼을 눌렀을 때 선택한 영화를 제외한 나머지 시간대를 비활성화하고 시간선택 화면으로 넘어감 */
		if(e.getSource() == reserveBtn_JWH){
			if(select_JWH == "winter"){ // 겨울왕국2을 선택했을 때 포스터 설정
				moviePnl4_JWH = new JPanel(){
				 	ImageIcon movieBackground4_JWH = new ImageIcon("Img/winter3.jpg");
					Image movieImg4_JWH = movieBackground4_JWH.getImage();
					Image change4_JWH = movieImg4_JWH.getScaledInstance(90, 140, Image.SCALE_SMOOTH);
					ImageIcon mc4_JWH = new ImageIcon(change4_JWH);
						
					public void paintComponent(Graphics g){
						g.drawImage(mc4_JWH.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
					}
				};
				
				moviePnl4_JWH.setBounds(10, 5, 90, 140);
				informPanel_JWH.add(moviePnl4_JWH);		
				
				movieNameLbl_JWH.setText("겨울왕국2(전체이용가)");	
				
				chun1250.setEnabled(false);
				chun2030.setEnabled(false);
				ff1515.setEnabled(false);
				ff2100.setEnabled(false);
				
				card_JWH.show(this, "time");
			} else if(select_JWH == "chun"){ // 천문을 선택했을 때 포스터 설정
				moviePnl5_JWH = new JPanel(){
				 	ImageIcon movieBackground5_JWH = new ImageIcon("Img/chun3.jpg");
					Image movieImg5_JWH = movieBackground5_JWH.getImage();
					Image change5_JWH = movieImg5_JWH.getScaledInstance(90, 140, Image.SCALE_SMOOTH);
					ImageIcon mc5_JWH = new ImageIcon(change5_JWH);
						
					public void paintComponent(Graphics g){
						g.drawImage(mc5_JWH.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
				}
			};
			
				moviePnl5_JWH.setBounds(10, 5, 90, 140);
				informPanel_JWH.add(moviePnl5_JWH);		
				
				movieNameLbl_JWH.setText("천문(12세이용가)");	
				
				winter1610.setEnabled(false);
				winter1840.setEnabled(false);
				ff1515.setEnabled(false);
				ff2100.setEnabled(false);
				
				card_JWH.show(this, "time");
				
			} else if(select_JWH == "ff"){				
				moviePnl6_JWH = new JPanel(){ // 포드V페라리를 선택했을 때 포스터 설정
				 	ImageIcon movieBackground6_JWH = new ImageIcon("Img/ff3.jpg");
					Image movieImg6_JWH = movieBackground6_JWH.getImage();
					Image change6_JWH = movieImg6_JWH.getScaledInstance(90, 140, Image.SCALE_SMOOTH);
					ImageIcon mc6_JWH = new ImageIcon(change6_JWH);
						
					public void paintComponent(Graphics g){
						g.drawImage(mc6_JWH.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
				}					
			};
				moviePnl6_JWH.setBounds(10, 5, 90, 140);
				informPanel_JWH.add(moviePnl6_JWH);
			
				movieNameLbl_JWH.setText("포드V페라리(12세이용가)");
				
				winter1610.setEnabled(false);
				winter1840.setEnabled(false);
				chun1250.setEnabled(false);
				chun2030.setEnabled(false);
				
				card_JWH.show(this, "time");
			}		
		}		
		/* end */
		
		/* 시간선택 화면에서 뒤로가기 버튼(<)을 누르면 비활성화된 버튼을 다시 활성화하고 화면에 보이는 패널을 메인화면으로 교체 */
		if(e.getSource() == backBtn2_JWH){
			if(select_JWH == "winter"){
				informPanel_JWH.remove(moviePnl4_JWH);
			} else if(select_JWH == "chun"){
				informPanel_JWH.remove(moviePnl5_JWH);
			} else if(select_JWH == "ff"){
				informPanel_JWH.remove(moviePnl6_JWH);
			}
			
			winter1610.setEnabled(true);
			winter1840.setEnabled(true);
			chun1250.setEnabled(true);
			chun2030.setEnabled(true);
			ff1515.setEnabled(true);
			ff2100.setEnabled(true);
			
			card_JWH.show(this, "main");
		}
		/* end */
		
		/* 시간선택 화면에서 시간을 눌렀을 때 시간을 time 변수에 저장하고 좌석선택 화면으로 넘어감 */
		if(e.getSource() == winter1610){
			timeM_JWH = winter1610.getText();
			startTimeLbl_JWH.setText("관람시간 : " + timeM_JWH);
			sangyoungLbl_JWH.setText("상영관 : 1관");
			
			/* 선택한 영화, 시간대의 좌석 비활성화 */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == winter1840){
			timeM_JWH = winter1840.getText();
			startTimeLbl_JWH.setText("관람시간 : " + timeM_JWH);
			sangyoungLbl_JWH.setText("상영관 : 1관");
			
			/* 선택한 영화, 시간대의 좌석 비활성화 */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == chun1250){
			timeM_JWH = chun1250.getText();
			startTimeLbl_JWH.setText("관람시간 : " + timeM_JWH);
			sangyoungLbl_JWH.setText("상영관 : 2관");
			
			/* 선택한 영화, 시간대의 좌석 비활성화 */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == chun2030){
			timeM_JWH = chun2030.getText();
			startTimeLbl_JWH.setText("관람시간 : " + timeM_JWH);
			sangyoungLbl_JWH.setText("상영관 : 2관");
			
			/* 선택한 영화, 시간대의 좌석 비활성화 */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == ff1515){
			timeM_JWH = ff1515.getText();
			startTimeLbl_JWH.setText("관람시간 : " + timeM_JWH);
			sangyoungLbl_JWH.setText("상영관 : 3관");
			
			/* 선택한 영화, 시간대의 좌석 비활성화 */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == ff2100){
			timeM_JWH = ff2100.getText();
			startTimeLbl_JWH.setText("관람시간 : " + timeM_JWH);
			sangyoungLbl_JWH.setText("상영관 : 3관");
			
			/* 선택한 영화, 시간대의 좌석 비활성화 */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		}
		/* end */
		
		/* 좌석선택 화면에서 뒤로가기 버튼(<)을 누르면 time 변수를 초기화하고 시간선택 화면으로 되돌아감 */
		if(e.getSource() == backBtn3_JWH){
			timeM_JWH = "";
			startTimeLbl_JWH.setText("관람시간 : " + timeM_JWH);
			seatLbl_JWH.setText("좌석 : ");
			goPay_JWH.setEnabled(false);
			card_JWH.show(this, "time");
			
			for(int i=0; i<8; i++){
				seatsBtn_JWH[0][i].setEnabled(true);
				seatsBtn_JWH[1][i].setEnabled(true);
			}
			for(int i=0; i<12; i++){
				seatsBtn_JWH[2][i].setEnabled(true);
				seatsBtn_JWH[3][i].setEnabled(true);
				seatsBtn_JWH[4][i].setEnabled(true);
				seatsBtn_JWH[5][i].setEnabled(true);
				seatsBtn_JWH[6][i].setEnabled(true);
			}
		}
		/* end */
		
		/* 좌석선택 화면에서 좌석을 선택했을 때 해당 좌석 버튼을 저장 후 선택한 좌석을 텍스트로 표시  */
		for(int i=0; i<12; i++){
			if(e.getSource() == seatsBtn_JWH[0][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[0][i];
				selectSeat_JWH = seatsBtn_JWH[0][i].getText();
				seatLbl_JWH.setText("좌석 : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[1][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[1][i];
				selectSeat_JWH = seatsBtn_JWH[1][i].getText();
				seatLbl_JWH.setText("좌석 : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[2][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[2][i];
				selectSeat_JWH = seatsBtn_JWH[2][i].getText();
				seatLbl_JWH.setText("좌석 : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[3][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[3][i];
				selectSeat_JWH = seatsBtn_JWH[3][i].getText();
				seatLbl_JWH.setText("좌석 : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[4][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[4][i];
				selectSeat_JWH = seatsBtn_JWH[4][i].getText();
				seatLbl_JWH.setText("좌석 : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[5][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[5][i];
				selectSeat_JWH = seatsBtn_JWH[5][i].getText();
				seatLbl_JWH.setText("좌석 : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[6][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[6][i];
				selectSeat_JWH = seatsBtn_JWH[6][i].getText();
				seatLbl_JWH.setText("좌석 : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			}
		}
		/* end */
		
		/* 결제하기 버튼을 눌렀을 때 결제진행 화면으로 넘어감 */
		if(e.getSource() == goPay_JWH){
			if(select_JWH == "winter"){
				simpleLbl1_JWH.setText("겨울왕국2(" + selectSeat_JWH + ")");
			} else if(select_JWH == "chun"){
				simpleLbl1_JWH.setText("천문(" + selectSeat_JWH + ")");
			} else if(select_JWH == "ff"){
				simpleLbl1_JWH.setText("포드V페라리(" + selectSeat_JWH + ")");
			}
			card_JWH.show(this, "pay");
		}
		/* end */
		
		/* 결제하기 화면에서 뒤로가기 버튼(<)을 누르면 좌석선택 화면으로 넘어감 */
		if(e.getSource() == backBtn4_JWH){
			card_JWH.show(this, "seat");	
			
			numTransBtn_JWH.setEnabled(true);
			confirmBtn_JWH.setEnabled(true);
			nameTF_JWH.setEnabled(true);
			nameTF_JWH.setText(null);
			resiNumTF1_JWH.setEnabled(true);
			resiNumTF1_JWH.setText(null);
			resiNumTF2_JWH.setEnabled(true);
			resiNumTF2_JWH.setText(null);
			phoneNumTF_JWH.setEnabled(true);
			phoneNumTF_JWH.setText(null);
			payInputTF_JWH.setEditable(true);
			payInputTF_JWH.setText(null);
			progressBtn_JWH.setEnabled(false);
		}
		/* end */
		
		/* 결제하기 화면에서 인증번호전송 버튼을 누르면 0~9까지 랜덤한 숫자가 num1~num6에 입력됨 */
		/* 인증번호는 콘솔창에 출력됨 */
		if(e.getSource() == numTransBtn_JWH){
			
			String nameCheck_JWH = nameTF_JWH.getText();
			String resi1Check_JWH = resiNumTF1_JWH.getText();
			String resi2Check_JWH = resiNumTF2_JWH.getText();
			String pnTFLength_JWH = phoneNumTF_JWH.getText();
			if(nameCheck_JWH.length() >= 2){
				if(resi1Check_JWH.length() == 6){
					if(resi2Check_JWH.length() == 1){
						if(pnTFLength_JWH.length() == 11){
							for(int i=0; i<100; i++){
								double dv_JWH = Math.random();
								num1_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num2_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num3_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num4_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num5_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num6_JWH = (int)(dv_JWH * 10);
							}
							msLbl1_JWH.setText(phoneNumTF_JWH.getText() + " 로 인증번호를 전송했습니다.");
							msPanel_JWH.setVisible(true);
							certNum2_JWH = "" + num1_JWH + num2_JWH + num3_JWH + num4_JWH + num5_JWH + num6_JWH;
							certNum1_JWH = Integer.parseInt(certNum2_JWH);
							System.out.println("귀하의 인증번호는 [" + certNum1_JWH + "] 입니다.");
							HomeMainPanel_KHJ.message.receiveMessage("오늘 뭐볼래?", "귀하의 인증번호는 [" + certNum1_JWH + "] 입니다.");
							HomeMainPanel_KHJ.message.listBtn_JWH[HomeMainPanel_KHJ.message.Mcount_JWH-1].setText(
									"<html>" + "오늘 뭐볼래?" + "<br/>" + "\r" + "<html>" + "귀하의 인증번호는 [" + certNum1_JWH + "] 입니다." + "<br/>");
						} else {
							msLbl1_JWH.setText("휴대폰 번호를 정확하게 입력해주세요.");
							msPanel_JWH.setVisible(true);
						}
					} else {
						msLbl1_JWH.setText("주민등록번호를 정확하게 입력해주세요.");
						msPanel_JWH.setVisible(true);
					}
				} else {
					msLbl1_JWH.setText("주민등록번호를 정확하게 입력해주세요.");
					msPanel_JWH.setVisible(true);
				}		
			} else {
				msLbl1_JWH.setText("이름을 정확하게 입력해주세요.");
				msPanel_JWH.setVisible(true);
			}
		}
		/* end */
		
		if(e.getSource() == msBtn_JWH){
			msPanel_JWH.setVisible(false);
		}
		
		/* 인증번호입력 TextField에 인증번호와 동일한 숫자면  결제하기 버튼 활성화 */
		if(e.getSource() == confirmBtn_JWH){
			try{
				certNumInput2_JWH = payInputTF_JWH.getText();
				certNumInput1_JWH = Integer.parseInt(certNumInput2_JWH);
				if(certNum1_JWH == certNumInput1_JWH){
					numTransBtn_JWH.setEnabled(false);
					confirmBtn_JWH.setEnabled(false);
					nameTF_JWH.setEnabled(false);
					resiNumTF1_JWH.setEnabled(false);
					resiNumTF2_JWH.setEnabled(false);
					phoneNumTF_JWH.setEnabled(false);
					payInputTF_JWH.setEditable(false);
					progressBtn_JWH.setEnabled(true);
				} 
			} catch(NumberFormatException Ne){
				msLbl1_JWH.setText("인증번호를 정확하게 입력해주세요.");
				msPanel_JWH.setVisible(true);
			}
			
		}
		/* end */	
		
		/* 결제하기 버튼을 누르면 결제완료 화면으로 넘어감 */
		if(e.getSource() == progressBtn_JWH){
			card_JWH.show(this, "suc");
		}
		/* end */
		
		/* 결제완료 화면에서 확인을 누르면 티켓 생성 후 처음화면으로 되돌아가고 결제하기 화면 초기화 */
		if(e.getSource() == okBtn_JWH){
			
			/* 예매확인에 티켓을 추가 */
			addTicket_JWH[ticketCount_JWH] = true;
			ticketsSaveMName[ticketCount_JWH] = select_JWH;
			ticketsSaveSeat_JWH[ticketCount_JWH] = selectSeat_JWH;
			ticketsMDay_JWH[ticketCount_JWH] = st_JWH;
			ticketsMTime_Hour_JWH[ticketCount_JWH] = timeM_JWH.substring(0, 2);
			ticketsMTime_Minute_JWH[ticketCount_JWH] = timeM_JWH.substring(3, 5);
			ticketsMTime_JWH[ticketCount_JWH] = timeM_JWH;
			ticketsMment_JWH[ticketCount_JWH] = "이 문구가 있다면 결제가 정상 완료된 예매표입니다.";
			
			tickets_JWH[ticketCount_JWH] = new JPanel();
			tickets_JWH[ticketCount_JWH].setLayout(null);
			tickets_JWH[ticketCount_JWH].setBackground(new Color(2, 23, 71));
			tickets_JWH[ticketCount_JWH].setPreferredSize(new Dimension(300, 160));
			
			if(ticketsSaveMName[ticketCount_JWH] == "winter"){
				tNameLbl_JWH[ticketCount_JWH] = new JLabel("겨울왕국2(" + ticketsSaveSeat_JWH[ticketCount_JWH] +")");
				tNameLbl_JWH[ticketCount_JWH].setFont(new Font("휴먼아미체", Font.PLAIN, 32));
				tNameLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tNameLbl_JWH[ticketCount_JWH].setBounds(90, 6, 200, 50);
				
				tCinemaLbl_JWH[ticketCount_JWH] = new JLabel("서면점 1관");
				tCinemaLbl_JWH[ticketCount_JWH].setFont(new Font("휴먼아미체", Font.PLAIN, 15));
				tCinemaLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tCinemaLbl_JWH[ticketCount_JWH].setBounds(250, -5, 200, 50);
				tickets_JWH[ticketCount_JWH].add(tCinemaLbl_JWH[ticketCount_JWH]);
				
				informPanel_JWH.remove(moviePnl4_JWH);
			} else if(ticketsSaveMName[ticketCount_JWH] == "chun"){
				tNameLbl_JWH[ticketCount_JWH] = new JLabel("천문(" + ticketsSaveSeat_JWH[ticketCount_JWH] +")");
				tNameLbl_JWH[ticketCount_JWH].setFont(new Font("휴먼아미체", Font.PLAIN, 32));
				tNameLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tNameLbl_JWH[ticketCount_JWH].setBounds(110, 6, 200, 50);
				
				tCinemaLbl_JWH[ticketCount_JWH] = new JLabel("서면점 2관");
				tCinemaLbl_JWH[ticketCount_JWH].setFont(new Font("휴먼아미체", Font.PLAIN, 15));
				tCinemaLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tCinemaLbl_JWH[ticketCount_JWH].setBounds(250, -5, 200, 50);
				tickets_JWH[ticketCount_JWH].add(tCinemaLbl_JWH[ticketCount_JWH]);
				
				informPanel_JWH.remove(moviePnl5_JWH);
			} else if(ticketsSaveMName[ticketCount_JWH] == "ff"){
				tNameLbl_JWH[ticketCount_JWH] = new JLabel("포드V페라리(" + ticketsSaveSeat_JWH[ticketCount_JWH] +")");
				tNameLbl_JWH[ticketCount_JWH].setFont(new Font("휴먼아미체", Font.PLAIN, 32));
				tNameLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tNameLbl_JWH[ticketCount_JWH].setBounds(80, 6, 200, 50);
				
				tCinemaLbl_JWH[ticketCount_JWH] = new JLabel("서면점 3관");
				tCinemaLbl_JWH[ticketCount_JWH].setFont(new Font("휴먼아미체", Font.PLAIN, 15));
				tCinemaLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tCinemaLbl_JWH[ticketCount_JWH].setBounds(250, -5, 200, 50);
				tickets_JWH[ticketCount_JWH].add(tCinemaLbl_JWH[ticketCount_JWH]);
				
				informPanel_JWH.remove(moviePnl6_JWH);
			}
			
			tickets_JWH[ticketCount_JWH].add(tNameLbl_JWH[ticketCount_JWH]);
			checkContentPanel_JWH.add(tickets_JWH[ticketCount_JWH]);
			
			tDayLbl_JWH[ticketCount_JWH] = new JLabel(ticketsMDay_JWH[ticketCount_JWH]);
			tDayLbl_JWH[ticketCount_JWH].setFont(new Font("휴먼아미체", Font.PLAIN, 20));
			tDayLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
			tDayLbl_JWH[ticketCount_JWH].setBounds(112, 30, 100, 50);
			tickets_JWH[ticketCount_JWH].add(tDayLbl_JWH[ticketCount_JWH]);
			
			tTimeLbl_JWH[ticketCount_JWH] = new JLabel(ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH]);
			tTimeLbl_JWH[ticketCount_JWH].setFont(new Font("휴먼아미체", Font.PLAIN, 90));
			tTimeLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
			tTimeLbl_JWH[ticketCount_JWH].setBounds(85, 60, 200, 70);
			tickets_JWH[ticketCount_JWH].add(tTimeLbl_JWH[ticketCount_JWH]);
			
			tMentLbl_JWH[ticketCount_JWH] = new JLabel("이 문구가 있다면 정상 결제된 예매표입니다.");
			tMentLbl_JWH[ticketCount_JWH].setFont(new Font("나눔바른고딕", Font.PLAIN, 10));
			tMentLbl_JWH[ticketCount_JWH].setForeground(Color.ORANGE);
			tMentLbl_JWH[ticketCount_JWH].setBounds(63, 110, 250, 70);
			tickets_JWH[ticketCount_JWH].add(tMentLbl_JWH[ticketCount_JWH]);
			
			/* Tickets 폴더에 ticket숫자.txt 형식으로 생성 */
			try{
				OutputStream tkOut_JWH = new FileOutputStream("Tickets/ticket" + ticketCount_JWH + ".txt");
				String tkContent_JWH = "";
				if(ticketsSaveMName[ticketCount_JWH] == "winter"){
							tkContent_JWH = "예매가 완료되었습니다.\n" 
							+ "영화 제목 : 겨울왕국2\n"
							+ "금액 : 8,000원\n"
							+ "영화관 : 서면점 1관\n"
							+ "좌석 : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "\n"
							+ "관람일 : " + ticketsMDay_JWH[ticketCount_JWH] + "\n"
							+ "관람 시작 시간 : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH];
				} else if(ticketsSaveMName[ticketCount_JWH] == "chun"){
							tkContent_JWH = "예매가 완료되었습니다.\n" 
							+ "영화제목 : 천문\n"
							+ "금액 : 8,000원\n"
							+ "영화관 : 서면점 2관\n"
							+ "좌석 : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "\n"
							+ "관람일 : " + ticketsMDay_JWH[ticketCount_JWH] + "\n"
							+ "관람 시작 시간 : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH];
				} else if(ticketsSaveMName[ticketCount_JWH] == "ff"){
							tkContent_JWH = "예매가 완료되었습니다.\n" 
							+ "영화제목 : 포드V페라리\n"
							+ "금액 : 8,000원\n"
							+ "영화관 : 서면점 3관\n"
							+ "좌석 : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "\n"
							+ "관람일 : " + ticketsMDay_JWH[ticketCount_JWH] + "\n"
							+ "관람 시작 시간 : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH];
				}
				byte[] byte_JWH = tkContent_JWH.getBytes();
				tkOut_JWH.write(byte_JWH);
			} catch (Exception e1) {
				e1.getStackTrace();
			}
			
			if(ticketsSaveMName[ticketCount_JWH] == "winter"){
				HomeMainPanel_KHJ.kakao_View1.user("오늘 뭐볼래?","","", "<html>예매가 완료되었습니다.<br>" + "영화 제목 : 겨울왕국2<br>" + "금액 : 8,000원<br>" + 
								"영화관 : 서면점 1관<br>" + "좌석 : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "<br>" + 
								"관람일 : " + ticketsMDay_JWH[ticketCount_JWH] + "<br>" + "관람 시작 시간 : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH] +"</html>");
				//HomeMainPanel_KHJ.kakao_View1.userMake(2);
				line_view();
			} else if (ticketsSaveMName[ticketCount_JWH] == "chun"){
				HomeMainPanel_KHJ.kakao_View1.user("오늘 뭐볼래?","","", "<html>예매가 완료되었습니다.<br>" + "영화 제목 : 천문<br>" + "금액 : 8,000원<br>" + 
						"영화관 : 서면점 2관<br>" + "좌석 : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "<br>" + 
						"관람일 : " + ticketsMDay_JWH[ticketCount_JWH] + "<br>" + "관람 시작 시간 : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH] +"</html>");
				//HomeMainPanel_KHJ.kakao_View1.userMake(2);
				line_view();
			} else if (ticketsSaveMName[ticketCount_JWH] == "ff"){
				HomeMainPanel_KHJ.kakao_View1.user("오늘 뭐볼래?","","", "<html>예매가 완료되었습니다.<br>" + "영화 제목 : 포드V페라리<br>" + "금액 : 8,000원<br>" + 
						"영화관 : 서면점 3관<br>" + "좌석 : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "<br>" + 
						"관람일 : " + ticketsMDay_JWH[ticketCount_JWH] + "<br>" + "관람 시작 시간 : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH] +"</html>");
				//HomeMainPanel_KHJ.kakao_View1.userMake(2);
				line_view();
			} 
			
			ticketCount_JWH++; // 티켓이 생성되면 티켓 카운터 1 증가
			/* end */

			winter1610.setEnabled(true);
			winter1840.setEnabled(true);
			chun1250.setEnabled(true);
			chun2030.setEnabled(true);
			ff1515.setEnabled(true);
			ff2100.setEnabled(true);
			
			selectSeat_JWH = "";
			seatLbl_JWH.setText("좌석 : " + selectSeat_JWH);
			msPanel_JWH.setVisible(false);
			
			numTransBtn_JWH.setEnabled(true);
			confirmBtn_JWH.setEnabled(true);
			nameTF_JWH.setEnabled(true);
			nameTF_JWH.setText(null);
			resiNumTF1_JWH.setEnabled(true);
			resiNumTF1_JWH.setText(null);
			resiNumTF2_JWH.setEnabled(true);
			resiNumTF2_JWH.setText(null);
			phoneNumTF_JWH.setEnabled(true);
			phoneNumTF_JWH.setText(null);
			payInputTF_JWH.setEditable(true);
			payInputTF_JWH.setText(null);
			progressBtn_JWH.setEnabled(false);
			
			card_JWH.show(this, "main");
		}
		/* end */
		
		/* 예매확인 버튼을 눌렀을 때 예매확인 화면으로 넝어감 */
		if(e.getSource() == checkBtn_JWH){
			card_JWH.show(this, "check");	
		}
		/* end */
		
		/* 예메확인 화면에서 뒤로가기 버튼(<)을 누르면 처음으로 되돌아감 */
		if(e.getSource() == backBtn6_JWH){
			card_JWH.show(this, "main");
		}
		/* end */	
	}
	
	public void End(){
		this.setVisible(false);
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}
	
}
