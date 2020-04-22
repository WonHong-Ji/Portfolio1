import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class MessageClass_JWH extends JPanel implements ActionListener{
	// 문자 어플은 메시지 받기, 메시지 확인 기능만 구현함
	// 컴포넌트 선언은 화면의 위에서 아래 방향으로 쓰여질 순서로 선언함
	// 화면에 받은 문자를 몇개 정도만 표시할 것이라 사용될 배열들은 길이를 일단 10으로 설정
	
	// 처음 화면을 구성할 패널 선언
	// mainPanel_JWH : 가장 하위 패널이며 borderlayout으로 설정
	// titlePanel_JWH : mainPanel의 상위 패널으로 North에 배치됨. 하늘색 바탕으로 설정되며 "받은 메시지"레이블을 배치하는 패널
	// listPanel_JWH : mainPanel의 상위 패널으로 Center에 배치됨. 하얀색 바탕으로 설정되며 보낸사람과 내용으로 구성된 문자 리스트를 보여줌
	JPanel mainPanel_JWH, titlePanel_JWH, listPanel_JWH; 
	
	// titleLabel_JWH : titlePanel에 배치할 "받은 메시지"라는 텍스트로 보여질 레이블 
	JLabel titleLabel_JWH;
	
	// JPanel[] messagePanel_JWH : 리스트의 구성 요소 1개로 사용될 패널 배열. 보낸 사람으로부터 문자를 1개 받으면 messagePanel이 1개 생성됨. 이 패널에 아이콘 이미지와 버튼이 들어감.  
	JPanel[] messagePanel_JWH = new JPanel[10];
	
	// 문자 내용 왼쪽에 프로필 아이콘을 표시
	// 아이콘을 씌우기 위해 사용할 레이블을 선언
	// 경로 상의 png 파일을 사용하기 위해 ImageIcon 사용
	JLabel[] iconLabel_JWH = new JLabel[10];
	String iconPath_JWH = "Img/usericon.png";
	ImageIcon iconImg_JWH = new ImageIcon(iconPath_JWH);
	
	// 보낸 사람 1명을 나타내는 버튼 
	// 보낸 사람 이름과 문자 내용을 버튼 텍스트로 설정함
	// final을 안붙이면 "보낸사람문자내용"식으로 줄바꿈이 안되서 붙임 
	// 액션리스너를 추가하여 버튼을 누르면 화면 전환 이벤트 발생
	final JButton[] listBtn_JWH = new JButton[10];
	
	// listBtn의 보낸 사람 이름과,문자 내용을 표시하기 위한 텍스트를 담기 위해 사용됨
	String[] saveFrom = new String[10];
	String[] saveContent = new String[10];
	
	// contentPanel_JWH : listBtn을 누르면 그 사람이 보낸 문자를 전부 표시하기 위한 화면으로 사용될 패널
	// content_titlePanel : contentPanel의 상위 패널으로 North에 배치됨. 하늘색 바탕으로 설정되며 "보낸이의 이름"레이블을 배치하는 패널
	// content_messagePanel_JWH : contentPanel의 상위 패널으로 Center에 배치됨. 하얀색 바탕으로 설정되며 "문자 내용"을 배치하는 패널
	JPanel[] contentPanel_JWH = new JPanel[10];
	JPanel[] content_titlePanel_JWH = new JPanel[10];
	JPanel[] content_messagePanel_JWH = new JPanel[10];	
	
	// backBtn_JWH : 화면 전환 후 다시 되돌아가기 기능을 하는 버튼. content_titlePanel에 배치됨
	JButton[] backBtn_JWH = new JButton[10];
	
	// content_titleLabel_JWH : "보낸이의 이름"이라는 텍스트로 보여질 레이블. content_titlePanel에 배치됨
	JLabel[] content_titleLabel_JWH = new JLabel[10];
	
	// 10명 각각의 문자 내용을 11개까지 저장
	JButton[][] data_JWH = new JButton[10][11];
	
	// receiveMessage 메서드로 메시지를 받은 횟수를 카운트
	int Mcount_JWH = 0;
	
	//mainpanel을 받아오기 위해 객체를 선언합니다.
	HomeMainPanel_KHJ mainHome;
		
	public MessageClass_JWH(JPanel mainHomePanel) {
		
		//생성자의 매개변수를 통해 mainpanel을 받아옵니다.
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		/* 프레임 기본 설정 start */
		//this.setSize(378, 674);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* end */
		
		this.setLayout(new BorderLayout());
		
		/* 초기 화면 설정 start */
		// mainPanel 위에 titlePanel, listPanel 배치 
		// titlePanel위에 "받은 메시지" 레이블 배치
		mainPanel_JWH = new JPanel();
		mainPanel_JWH.setBackground(Color.WHITE);
		mainPanel_JWH.setLayout(new BorderLayout());
		
		titlePanel_JWH = new JPanel();
		titlePanel_JWH.setBackground(new Color(194, 226, 232));
		titlePanel_JWH.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		listPanel_JWH = new JPanel();
		listPanel_JWH.setBackground(Color.WHITE);
		listPanel_JWH.setLayout(new FlowLayout());
		
		titleLabel_JWH = new JLabel("받은 메시지");
		titleLabel_JWH.setFont(new Font("나눔고딕", Font.BOLD, 24));
		titleLabel_JWH.setForeground(Color.WHITE);
		titlePanel_JWH.add(titleLabel_JWH);
		
		mainPanel_JWH.add(titlePanel_JWH, "North");
		mainPanel_JWH.add(listPanel_JWH, "Center");
		/* end */
		
		/* listBtn을 터치하면 보낸 사람 각자의 화면을 표시하기 위한 패널 생성 start*/
		// mainPanel과 동일한 구조로 contentPanel 위에 content_titlePanel, content_messagePanel이 생성되어 배치됨  
		for(int i=0; i<contentPanel_JWH.length; i++){
		contentPanel_JWH[i] = new JPanel();
		contentPanel_JWH[i].setBackground(Color.WHITE);
		contentPanel_JWH[i].setLayout(new BorderLayout());
		
		content_titlePanel_JWH[i] = new JPanel();
		content_titlePanel_JWH[i].setBackground(new Color(194, 226, 232));
		content_titlePanel_JWH[i].setLayout(new FlowLayout(FlowLayout.LEFT));
		
		content_messagePanel_JWH[i] = new JPanel();
		content_messagePanel_JWH[i].setBackground(Color.WHITE);
		content_messagePanel_JWH[i].setLayout(new BoxLayout(content_messagePanel_JWH[i], BoxLayout.Y_AXIS));
		
		// 뒤로가기 버튼을 구현하여 content_titlePanel의 가장 왼쪽에 배치함
		backBtn_JWH[i] = new JButton("<");
		backBtn_JWH[i].addActionListener(this);
		backBtn_JWH[i].setBorder(null);
		backBtn_JWH[i].setPreferredSize(new Dimension(29, 29));
		backBtn_JWH[i].setFont(new Font("나눔고딕", Font.BOLD, 24));
		backBtn_JWH[i].setBackground(new Color(194, 226, 232));
		backBtn_JWH[i].setForeground(Color.WHITE);
		backBtn_JWH[i].setBorderPainted(false);
		
		// 보낸 사람의 이름을 표시하기 위한 레이블.뒤로가기 바로 옆에 배치
		// 아래의 receiveMessage 메서드로 보낸 사람이 입력되면 setText로 바뀌게 됨
		content_titleLabel_JWH[i] = new JLabel("");
		content_titleLabel_JWH[i].setFont(new Font("나눔고딕", Font.BOLD, 24));
		content_titleLabel_JWH[i].setForeground(Color.WHITE);
		
		// 생성한 뒤로가기 버튼, 레이블을 content_titlePanel에 배치함
		content_titlePanel_JWH[i].add(backBtn_JWH[i]);
		content_titlePanel_JWH[i].add(content_titleLabel_JWH[i]);
		
		// contentPanel에 content_titlePanel과 content_messagePanel을 배치함
		contentPanel_JWH[i].add(content_titlePanel_JWH[i], "North");
		contentPanel_JWH[i].add(content_messagePanel_JWH[i], "Center");
		}
		/* end */
		
		add(mainPanel_JWH);
		//this.setVisible(true);
	}
	
	// 메시지를 받고 표시하는 메서드
	// from:보낸사람, content:보낸내용
	public void receiveMessage(String from, String content){
		
		/* 동일한 사람인지 체크 */
		// 가장 먼저 동일한 사람에게 받았다면 똑같은 content_messagePanel에 내용만 추가하고 종료됨
		for(int i=0; i<10; i++){
			if(saveFrom[i]== from){
				content_messagePanel_JWH[i].add(Box.createVerticalStrut(5));
				data_JWH[i][i+1] = new JButton();
				data_JWH[i][i+1].setText(content);
				data_JWH[i][i+1].setFont(new Font("나눔고딕", Font.PLAIN, 18));
				data_JWH[i][i+1].setBackground(new Color(246, 246, 246));
				data_JWH[i][i+1].setBorderPainted(false);	
				listBtn_JWH[i].setText("<html>" + from + "<br/>" + "\r" + "<html>" + content + "<br/>");
				content_messagePanel_JWH[i].add(data_JWH[i][i+1]);
				return;
			}
		}
		/* end */
		
		// 입력된 from과 content를 배열에 저장하고 저장된 데이터는 아래의 코드에서 초기화면의 버튼 텍스트로 사용됨
		saveFrom[Mcount_JWH] = from;
		saveContent[Mcount_JWH] = content;
		
		/* 메시지를 처음 보낸 사람인 경우를 처리 start */
		// mainPanel-listPanel에 하나씩 추가될 패널을 생성함
		messagePanel_JWH[Mcount_JWH] = new JPanel();
		messagePanel_JWH[Mcount_JWH].setPreferredSize(new Dimension(350, 70));
		messagePanel_JWH[Mcount_JWH].setBackground(Color.WHITE);
		messagePanel_JWH[Mcount_JWH].setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// 추가된 패널에 프로필 아이콘부터 추가
		iconLabel_JWH[Mcount_JWH] = new JLabel(iconImg_JWH, JLabel.CENTER);
		iconLabel_JWH[Mcount_JWH].setHorizontalAlignment(JLabel.CENTER);
		
		// 아이콘 오른쪽에 배치되는 listBtn을 생성. 버튼의 text를 설정하는데 줄바꿈을 이용하여 from은 위쪽에, content는 아래쪽에 배치됨
		listBtn_JWH[Mcount_JWH] = new JButton("");
		listBtn_JWH[Mcount_JWH].addActionListener(this);
		listBtn_JWH[Mcount_JWH].setHorizontalAlignment(SwingConstants.LEFT);
		listBtn_JWH[Mcount_JWH].setText("<html>" + from + "<br/>" + "\r" + "<html>" + content + "<br/>");
		listBtn_JWH[Mcount_JWH].setBackground(Color.WHITE);
		listBtn_JWH[Mcount_JWH].setFont(new Font("나눔고딕", Font.PLAIN, 15));
		listBtn_JWH[Mcount_JWH].setPreferredSize(new Dimension(250, 70));
		listBtn_JWH[Mcount_JWH].setBorderPainted(false); // 버튼 테두리 삭제
		
		// messagePanel에 아이콘과 버튼을 추가하여 mainPanel-listPanel에 추가함
		messagePanel_JWH[Mcount_JWH].add(iconLabel_JWH[Mcount_JWH]);
		messagePanel_JWH[Mcount_JWH].add(listBtn_JWH[Mcount_JWH]);
		listPanel_JWH.add(messagePanel_JWH[Mcount_JWH]);
		revalidate();
		repaint();

		// 전환된 화면의 titleLabel을 입력받은 from으로 설정
		content_titleLabel_JWH[Mcount_JWH].setText(from);
			
		content_messagePanel_JWH[Mcount_JWH].add(Box.createVerticalStrut(5));		
		data_JWH[Mcount_JWH][Mcount_JWH] = new JButton();
		data_JWH[Mcount_JWH][Mcount_JWH].setText(content);
		data_JWH[Mcount_JWH][Mcount_JWH].setFont(new Font("나눔고딕", Font.PLAIN, 18));
		data_JWH[Mcount_JWH][Mcount_JWH].setBackground(new Color(246, 246, 246));
		data_JWH[Mcount_JWH][Mcount_JWH].setBorderPainted(false);			
		
		content_messagePanel_JWH[Mcount_JWH].add(data_JWH[Mcount_JWH][Mcount_JWH]);
		
		Mcount_JWH++;
		/* end */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<contentPanel_JWH.length; i++){
			// 버튼을 눌렀을때 버튼에 해당하는 화면으로 전환됨
			if(e.getSource() == listBtn_JWH[i]){
				mainPanel_JWH.setVisible(false);
				this.add(contentPanel_JWH[i]);
				contentPanel_JWH[i].setVisible(true);
				revalidate();
				repaint();
			// 뒤로가기 버튼을 누르면 다시 mainPanel로 돌아감
			} else if(e.getSource() == backBtn_JWH[i]){
				for(int j=0; j<contentPanel_JWH.length; j++){
					contentPanel_JWH[j].setVisible(false);
					mainPanel_JWH.setVisible(true);
					revalidate();
					repaint();
				}
			}
		}
	}
	
	public void End(){
		//현재 패널을 닫아줍니다.
		this.setVisible(false);
		//main의 패널을 모두 켭니다.
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}
}
