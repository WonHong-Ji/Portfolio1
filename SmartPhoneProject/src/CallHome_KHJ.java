import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

import javax.swing.*;

public class CallHome_KHJ extends JPanel implements ActionListener{
	
	JPanel keypadPanel, bottomPanel, topPanel;
	JButton keypadBtn[] = new JButton[12];
	JButton etcBtn, callBtn, cancelBtn;
	//키패드 입력창(배경, 텍스트)
	JLabel topLabel;
	JTextArea topTextArea;
	String defaultNum, resultNum;
	
	
	JPanel callingPanel, callbtnPanel, optionBtnPanel, callingBackPanel, callingWhosPanel;
	JLabel backgroundLable;
	JButton callOption[] = new JButton[4];
	JButton endCallBtn;
	
	JLabel empty_call,whosnum,callTime;
	
	HomeMainPanel_KHJ mainHome;
	
	public CallHome_KHJ(JPanel mainHomePanel){
		
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		this.setLayout(new BorderLayout());
		
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		defaultNum = "\r\n\r\n  ";
		resultNum = "";
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(0, 3));
		keypadPanel = new JPanel();
		keypadPanel.setLayout(new GridLayout(4,3));
		
		topTextArea = new JTextArea(5, 8);
		topTextArea.setFont(new Font("Vrinda", Font.PLAIN, 40));
		//편집 불가
		topTextArea.setEditable(false);
		//줄바꿈 ON
		topTextArea.setLineWrap(true);
		
		keypadBtn[0] = new JButton(new ImageIcon("homeImage/callImg/num_1.png"));
		keypadBtn[1] = new JButton(new ImageIcon("homeImage/callImg/num_2.png"));
		keypadBtn[2] = new JButton(new ImageIcon("homeImage/callImg/num_3.png"));
		keypadBtn[3] = new JButton(new ImageIcon("homeImage/callImg/num_4.png"));
		keypadBtn[4] = new JButton(new ImageIcon("homeImage/callImg/num_5.png"));
		keypadBtn[5] = new JButton(new ImageIcon("homeImage/callImg/num_6.png"));
		keypadBtn[6] = new JButton(new ImageIcon("homeImage/callImg/num_7.png"));
		keypadBtn[7] = new JButton(new ImageIcon("homeImage/callImg/num_8.png"));
		keypadBtn[8] = new JButton(new ImageIcon("homeImage/callImg/num_9.png"));
		keypadBtn[9] = new JButton(new ImageIcon("homeImage/callImg/num_star.png"));
		keypadBtn[10] = new JButton(new ImageIcon("homeImage/callImg/num_0.png"));
		keypadBtn[11] = new JButton(new ImageIcon("homeImage/callImg/num_shap.png"));
		
		etcBtn = new JButton(new ImageIcon("homeImage/callImg/etcImg.png"));
		callBtn = new JButton(new ImageIcon("homeImage/callImg/callImg.png"));
		cancelBtn = new JButton(new ImageIcon("homeImage/callImg/cancelImg.png"));
		
		etcBtn.setBorderPainted(false);
		etcBtn.setContentAreaFilled(false);
		etcBtn.setFocusPainted(false);
		
		callBtn.setBorderPainted(false);
		callBtn.setContentAreaFilled(false);
		callBtn.setFocusPainted(false);
		
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		
		etcBtn.addActionListener(this);
		callBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		for(int i = 0; i < keypadBtn.length; i++){
			keypadBtn[i].setContentAreaFilled(false);
			keypadBtn[i].setFocusPainted(false);
			
			keypadBtn[i].addActionListener(this);
			keypadPanel.add(keypadBtn[i]);
		}
		
		//===============================================================================
		// 발신중
		//===============================================================================
		callingPanel = new JPanel();
		optionBtnPanel = new JPanel();
		callbtnPanel = new JPanel();
		callingBackPanel = new JPanel();
		callingWhosPanel = new JPanel();
		
		callingWhosPanel.setLayout(new BorderLayout());
		callingPanel.setLayout(new BorderLayout());
		callingBackPanel.setLayout(new BorderLayout());
		optionBtnPanel.setLayout(new GridLayout(0,4));
		callbtnPanel.setLayout(new BorderLayout());
		
		callingBackPanel.setBackground(new Color(47, 49, 62));
		
		//통화옵션, 통화종료버튼 생성
		callOption[0] = new JButton(new ImageIcon("homeImage/callImg/calling/speaker.png"));
		callOption[1] = new JButton(new ImageIcon("homeImage/callImg/calling/BlueTooth.png"));
		callOption[2] = new JButton(new ImageIcon("homeImage/callImg/calling/Keypad.png"));
		callOption[3] = new JButton(new ImageIcon("homeImage/callImg/calling/rec.png"));
		endCallBtn = new JButton(new ImageIcon("homeImage/callImg/calling/endCall.png"));
		
		JLabel callBackLabel = new JLabel(new ImageIcon("homeImage/callImg/calling/call.png"));
		
		//통화종료버튼 배경날리기
		endCallBtn.setContentAreaFilled(false);
		endCallBtn.setFocusPainted(false);
		
		//통화종료버튼 액션추가		
		endCallBtn.addActionListener(this);
		
		//통화옵션버튼 패널추가/배경날리기/액션추가
		for(int i = 0; i < callOption.length ; i++){
			optionBtnPanel.add(callOption[i]);
			callOption[i].setContentAreaFilled(false);
			callOption[i].setFocusPainted(false);
			callOption[i].addActionListener(this);
		}
		
		callingBackPanel.add(callBackLabel);
		
		callbtnPanel.add(optionBtnPanel);
		callbtnPanel.add(endCallBtn,"South");
		callbtnPanel.setBackground(new Color(244, 74, 77));
		
		callingPanel.add(callingBackPanel);
		callingPanel.add(callbtnPanel,"South");
		
		callingPanel.setVisible(false);
		
		topPanel.add(topTextArea);

		bottomPanel.add(etcBtn);
		bottomPanel.add(callBtn);
		bottomPanel.add(cancelBtn);
		
		this.add(topPanel,"North");
		this.add(keypadPanel);
		this.add(bottomPanel, "South");
	}
	
	public void End(){
	
		this.setVisible(false);
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == etcBtn){
			resultNum = "";
			topTextArea.setText(defaultNum + resultNum);
			End();
		}
		else if(e.getSource() == cancelBtn){
			int len = resultNum.length();
			if(len == 0) {
				resultNum = "";
				topTextArea.setText(defaultNum + resultNum);
			} else {
				if(!"".equals(resultNum)) {
					resultNum = resultNum.substring(0, len-1);
					topTextArea.setText(defaultNum + resultNum);
				}
			}
		}
		else if(e.getSource() == callBtn){
			if(!callingPanel.isVisible()){
				//기존 패널을 다 끄고
				topPanel.setVisible(false);
				keypadPanel.setVisible(false);
				bottomPanel.setVisible(false);
				//콜링패널을 띄워준다
				this.add(callingPanel, "Center");
				callingPanel.setVisible(true);
				
				//통화한 번호
				empty_call = new JLabel(" ");
				whosnum = new JLabel("    "+resultNum);
				callTime = new JLabel("      "+"00:00");
				
				empty_call.setFont(new Font("나눔고딕", Font.BOLD, 50));
				whosnum.setFont(new Font("Vrinda", Font.PLAIN, 20));
				callTime.setFont(new Font("Vrinda", Font.PLAIN, 16));
				
				callingWhosPanel.setBackground(new Color(47, 49, 62));
				callTime.setForeground(new Color(103,247,87));
				
				whosnum.setForeground(Color.WHITE);
				callingWhosPanel.add(empty_call,"North");
				callingWhosPanel.add(whosnum);
				callingWhosPanel.add(callTime,"South");
				callingPanel.add(callingWhosPanel,"North");
				//통화시간
			}
		}
		else if(e.getSource() == endCallBtn){
			//종료 시에, 통화했던 번호를 초기화
			whosnum.setText(" ");
			
			//통화패널을 꺼준다
			callingPanel.setVisible(false);
			
			//키패드 패널을 켜준다
			topPanel.setVisible(true);
			keypadPanel.setVisible(true);
			bottomPanel.setVisible(true);
		}
		else{
			if(topTextArea.getText().length() < 19){
				if(resultNum.length() == 3){
					resultNum = resultNum + "-";
					topTextArea.setText(defaultNum + resultNum);
				}
					
				else if(resultNum.length() == 8){
					resultNum = resultNum + "-";
					topTextArea.setText(defaultNum + resultNum);
				}	
				
				for(int i = 0; i < keypadBtn.length; i++){
					if(e.getSource() == keypadBtn[i]){
						//*을 입력받았을 경우
						if(i == 9){
							resultNum = resultNum + "*";
							topTextArea.setText(defaultNum + resultNum);
						}
						//0을 입력받았을 경우
						else if(i == 10){
							resultNum = resultNum + "0";
							topTextArea.setText(defaultNum + resultNum);
						}
						//#을 입력받았을 경우
						else if(i == 11){
							resultNum = resultNum + "#";
							topTextArea.setText(defaultNum + resultNum);
						}
						else{
							resultNum = resultNum + (i+1);
							topTextArea.setText(defaultNum + resultNum);
						}
					}
				}			
			}
		}
	}

}
