import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.print.attribute.standard.Chromaticity;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.text.View;

import java.util.*;

import javax.swing.*;

public class DeliveryStoreMenuItem_KHJ extends JDialog implements ActionListener, ItemListener{
	JButton backButton, orderButton;
	
	//메뉴팝업총괄패널
	JPanel itemInfoPanel;
	
	//메뉴 이름, 이미지 저장 패널
	JPanel foodNamePanel;
	//메뉴 옵션 총괄패널
	JPanel foodOptionPanel;
	//메뉴 추가옵션 총괄패널
	JPanel foodAddOptionPanel;
	//메뉴이름 레이블
	JLabel foodName;
	
	JPanel backPanel;
	
	Vector<JCheckBox> checkVector = new Vector<JCheckBox>();
	Vector<JRadioButton> radioVector = new Vector<JRadioButton>();
	
	Vector<String> checkPriceVector = new Vector<String>();
	Vector<String> radioPriceVector = new Vector<String>();
	
	Vector<String> checkNameVector = new Vector<String>();
	Vector<String> radioNameVector = new Vector<String>();
		
	int totalPrice = 0;
	
	JLabel orderPriceLabel;
	
	//선택한 가게 분류와 이름
	String nowStoreKindNum = null;

	public DeliveryStoreMenuItem_KHJ(DeliveryStore_KHJ deliveryStore_KHJ, String storeKind, int storeNum ,int fooditemNum){
		this.setModal(true);
		this.setUndecorated(true);
		setSize(378, 674);
		this. setLocationRelativeTo(deliveryStore_KHJ);
		this.getContentPane().setBackground(Color.white);

		int myItemNum = 0;
		
		itemInfoPanel = new JPanel();
		foodNamePanel = new JPanel();
		foodOptionPanel = new JPanel();
		foodAddOptionPanel = new JPanel();
		backPanel = new JPanel();
		
		backPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setLayout(new BorderLayout());	
		
		//주문서에 저장하기 위한 변수저장 (가게종류 / 가게이름)
		nowStoreKindNum = storeKind + "%" + storeNum + "%";
				
		BufferedReader br = null;
		FileReader fr = null;
		String str = null;
		String[] array = null;
		
		try {
			
			//어떤 파일 불러올지
			if(storeKind == "한식")
				fr = new FileReader("DeliveryInfo/K_Store_Item/K_Item_Store_" + storeNum + ".txt");
			else if(storeKind == "카페")
				fr = new FileReader("DeliveryInfo/C_Store_Item/C_Item_Store_" + storeNum + ".txt");
			else if(storeKind == "분식")
				fr = new FileReader("DeliveryInfo/B_Store_Item/B_Item_Store_" + storeNum + ".txt");
			
			br = new BufferedReader(fr);
			int num = 0;
			int gridnum = 0;
			
			while((str = br.readLine()) != null){
				array = str.split("%");
				
				if(num == fooditemNum){
					
					//음식이름, 이미지 패널
					foodNamePanel.setLayout(new BorderLayout());
					foodNamePanel.setBackground(Color.white);
					//메뉴 옵션들 표시 패널
					foodAddOptionPanel.setLayout(new BorderLayout());
					foodAddOptionPanel.setBackground(Color.white);
					
					//!!!총괄패널!!! 
					itemInfoPanel.setLayout(new BorderLayout());
					itemInfoPanel.setBackground(Color.white);
					
					JLabel foodImg = new JLabel(new ImageIcon(array[myItemNum]));
					foodName = new JLabel(array[++myItemNum] , JLabel.CENTER);
					foodName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
					
					foodNamePanel.add(foodImg,"North");
					foodNamePanel.add(foodName);
					
					//end값이 들어오기 전까지 체크박스 혹은 라디오버튼을 생성해준다
					while(!array[myItemNum+1].equals("end")){
						
						//라디오버튼 생성
						if(array[myItemNum+1].equals("R")){
							myItemNum++;
							int radioNum = Integer.parseInt(array[++myItemNum]);
							
							JLabel foodOption_ = new JLabel(array[++myItemNum]);
							JLabel foodOption_Label = new JLabel("");
							
							
							//레이아웃 맞추기 위해 카테고리 임의로 사이즈 지정
							foodOption_.setPreferredSize(new Dimension(350, 30));
							
							//메뉴 카테고리(기본) 패널
							JPanel foodOptionRadioTitlePanel = new JPanel();
							foodOptionRadioTitlePanel.setBackground(Color.white);
							foodOptionRadioTitlePanel.add(foodOption_);
							foodOption_.setFont(new Font("맑은 고딕", Font.BOLD, 17));
							
							JRadioButton foodOptionRadioBtn[] = new JRadioButton[radioNum];
							JLabel foodOptionRadioBtn1Label[] = new JLabel[radioNum];
							ButtonGroup foodOptionrBtnGroup = new ButtonGroup();
							

							JPanel foodOptionRadioPanel[] = new JPanel[radioNum];
							
							JPanel foodOptionRadioPanelMng = new JPanel();
							foodOptionRadioPanelMng.setLayout(new GridLayout(radioNum,0,5,8));
							foodOptionRadioPanelMng.setBackground(Color.white);
							gridnum = gridnum + radioNum + 1;
							
							JPanel foodOptionPanel_1 = new JPanel(new BorderLayout());
							foodOptionPanel_1.add(foodOptionRadioTitlePanel,"North");
							
							for(int i = 0; i < radioNum; i++){
								foodOptionRadioBtn[i] = new JRadioButton(array[++myItemNum], true);
								foodOptionRadioBtn1Label[i] = new JLabel("+" + array[++myItemNum] +"원");
								radioPriceVector.add(array[myItemNum]);
								foodOptionrBtnGroup.add (foodOptionRadioBtn[i]);
								
								foodOptionRadioPanel[i] = new JPanel();
								foodOptionRadioPanel[i].setLayout(new BorderLayout());
								foodOptionRadioPanel[i].setPreferredSize(new Dimension(340,20));
								
								foodOptionRadioPanel[i].add(foodOptionRadioBtn[i], "West");
								foodOptionRadioPanel[i].add(foodOptionRadioBtn1Label[i], "East");
								
								foodOptionRadioPanel[i].setBackground(Color.white);
								foodOptionRadioBtn[i].setBackground(Color.white);
								foodOptionRadioBtn1Label[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
								foodOptionRadioBtn[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
								
								foodOptionRadioPanelMng.add(foodOptionRadioPanel[i]);
								
								radioVector.add(foodOptionRadioBtn[i]);

								foodOptionRadioBtn[i].addActionListener(this);
								foodOptionRadioBtn[i].addItemListener(this);
							}
							
							foodOptionPanel_1.add(foodOptionRadioPanelMng);
							
							foodOptionPanel.add(foodOptionPanel_1);

						}
						//체크박스 생성
						if(array[myItemNum+1].equals("C")){
							myItemNum++;
							int checkNum = Integer.parseInt(array[++myItemNum]);
							
							JLabel foodAddOption1_ = new JLabel(array[++myItemNum]);
							//레이아웃 맞추기 위해 카테고리 임의로 사이즈 지정
							foodAddOption1_.setPreferredSize(new Dimension(350, 30));
							
							//메뉴 카테고리(추가선택) 패널
							JPanel foodOptionCheckTitlePanel = new JPanel();
							foodOptionCheckTitlePanel.setBackground(Color.white);
							foodOptionCheckTitlePanel.add(foodAddOption1_);
							foodAddOption1_.setFont(new Font("맑은 고딕", Font.BOLD, 17));
							
							JCheckBox foodOptionCheckBox[] = new JCheckBox[checkNum];
							JLabel foodOptionCheckBox1Label[] = new JLabel[checkNum];
							
							JPanel foodOptionCheckPanel_[] = new JPanel[checkNum];
							
							//패널의 여러항목을 묶는 패널
							JPanel foodOptionCheckPanel = new JPanel();
							foodOptionCheckPanel.setBackground(Color.white);
							foodOptionCheckPanel.setLayout(new GridLayout(checkNum,0,5,10));
							gridnum = gridnum + checkNum + 1;
							
							for(int i = 0; i < checkNum; i++){
								foodOptionCheckBox[i] = new JCheckBox(array[++myItemNum] + " 추가");
								foodOptionCheckBox1Label[i] = new JLabel("+" + array[++myItemNum] + "원");
								checkPriceVector.add(array[myItemNum]);
								
								foodOptionCheckPanel_[i] = new JPanel();
								foodOptionCheckPanel_[i].setLayout(new BorderLayout());
								foodOptionCheckPanel_[i].setPreferredSize(new Dimension(350,20));
								
								foodOptionCheckPanel_[i].add(foodOptionCheckBox[i], "West");
								foodOptionCheckPanel_[i].add(foodOptionCheckBox1Label[i], "East");
								
								foodOptionCheckPanel_[i].setBackground(Color.white);
								foodOptionCheckBox[i].setBackground(Color.white);
								foodOptionCheckBox[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
								foodOptionCheckBox1Label[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
								
								foodOptionCheckPanel.add(foodOptionCheckPanel_[i]);
								
								checkVector.add(foodOptionCheckBox[i]);
								foodOptionCheckBox[i].addItemListener(this);
								
							}

							JPanel foodOptionPanel_2 = new JPanel(new BorderLayout());
							foodOptionPanel_2.setBackground(Color.white);
							foodOptionPanel_2.add(foodOptionCheckTitlePanel,"North");
							foodOptionPanel_2.add(foodOptionCheckPanel);
							
							foodOptionPanel.add(foodOptionPanel_2);
						}
					}
				}
				num++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{if(br != null)
				br.close();
			if (fr != null)
				fr.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		foodOptionPanel.setLayout(new FlowLayout());
		foodOptionPanel.setBackground(Color.white);
		foodOptionPanel.setPreferredSize(new Dimension(355,2000));
		
		JScrollPane scrollPane = new JScrollPane(foodOptionPanel);

		itemInfoPanel.add(foodNamePanel,"North");
		itemInfoPanel.add(scrollPane);
		
		//뒤로가기 버튼
		backPanel.setBackground(Color.white);
		backButton = new JButton(new ImageIcon("homeImage/deliveryImg/backIcon.png"));
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addActionListener(this);
		backButton.addActionListener(this);
		
		backPanel.add(backButton);
		
		//주문버튼
		orderButton = new JButton (new ImageIcon("homeImage/deliveryImg/orderBtn.png"));
		orderButton.addActionListener(this);
		
		this.add(backPanel, "North");
		this.add(itemInfoPanel, "Center");
		this.add(orderButton, "South");
		
		//라디오 버튼의 defalut값에 대한 가격계산과 저장 초기화를 한다
		for(int i = 0; i < radioVector.size(); i++){
			if(radioVector.elementAt(i).isSelected()){
				totalPrice +=  Integer.parseInt(radioPriceVector.elementAt(i));
				radioNameVector.add(radioVector.elementAt(i).getText());
				radioNameVector.add(radioPriceVector.elementAt(i));
			}
		}	
		
		//주문버튼 옆에 최종가격 표시
		orderPriceLabel = new JLabel(totalPrice + "원");
		orderPriceLabel.setForeground(Color.white);
		orderPriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		orderButton.setLayout(new FlowLayout(FlowLayout.TRAILING));
		orderButton.add(orderPriceLabel);
		

		this.setVisible(true);		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//나가기
		if(e.getSource() == backButton){
			this.dispose();
		}
		
		//주문하기를 눌렀을 시에 파일에 쓴다
		else if (e.getSource() == orderButton) {			
			
			File f = new File("DeliveryInfo/Order/myOrder.txt");
			
			if(!f.exists()){
				OutputStream os = null;
				
				try {
					os = new FileOutputStream(f);
					os.write(-1);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally{
						try {
							if(os != null)
							os.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				}
				return;	//강제종료
			}
			
			
			 PrintWriter pw = null;
			 BufferedReader br = null;
			 
			try {
		        pw= new PrintWriter(new FileWriter(f, true));
		        br = new BufferedReader(new FileReader(f));
		        
		        String nowStoreKindNumStr = br.readLine();
	        	
		        if(!nowStoreKindNum.equals(nowStoreKindNumStr)){

					//선택한 가게종류, 가게이름
					if(br.readLine() == null){
						pw.write(nowStoreKindNum);
						pw.write("\r\n");
					}
					else
					{
						//다른 가게의 메뉴를 담았다면
						int result = JOptionPane.showConfirmDialog(null, "<html>장바구니에는 같은 가게의 메뉴만 담을 수 있습니다.<br>이전에 담은 메뉴가 삭제됩니다.<html>",
								"", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) ;
						
						if(result == JOptionPane.YES_OPTION){
							//예를 눌렀을 경우, 모두 초기화한다.
							pw = new PrintWriter(new FileWriter(f, false));
							pw.write(nowStoreKindNum);
							pw.write("\r\n");
						}
						else {
							return;
						}
					}
		        }
		        
		        //선택한 음식 이름
				pw.write(foodName.getText() + "%");
				
				//라디오버튼 기록
				for(int j = 0; j < radioNameVector.size()/2; j+=2){
					pw.write(radioNameVector.elementAt(j) + "%" +radioNameVector.elementAt(j+1) + "%");
				}
				//체크박스 기록
				for(int j = 0; j < checkNameVector.size(); j+=2){
					pw.write(checkNameVector.elementAt(j) + "%" +checkNameVector.elementAt(j+1) + "%");
				}
				//총 가격
				pw.write(totalPrice + "%" + "end");
				pw.write("\r\n");
				pw.flush();
		        
				pw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
				
			
			this.dispose();
		}
	}
	
	//체크박스 혹은 라디오 버튼이 눌렸을 시에 호출되는 itemStateChanged 메소드
	public void itemStateChanged(ItemEvent e) {
				
		//현재 선택된 이벤트 오브젝트를 받아온다
		Object source = e.getItemSelectable();
		
		//라디오버튼 검사
		for (int i = 0; i < radioVector.size(); i++){
			if (source == radioVector.elementAt(i)) {
				//라디오버튼이 클릭 해제된 것이라면
				if (e.getStateChange() == ItemEvent.DESELECTED){
					//현재 금액에서 선택된 라디오버튼의 금액을 제한다
					totalPrice -= Integer.parseInt(radioPriceVector.elementAt(i));
					//주문서에서 해당 라디오버튼의 텍스트를 찾고, 있다면 제거한다.
					for(int j = 0; j < radioNameVector.size(); j++){
						if(radioNameVector.elementAt(j) == radioVector.elementAt(i).getText()){
							radioNameVector.remove(j+1);
							radioNameVector.remove(j);
						}
					}
				}
				else{
					//현재 금액에서 선택된 라디오 버튼의 금액을 더한다
					totalPrice += Integer.parseInt(radioPriceVector.elementAt(i));
					//주문서에서 해당되는 라디오 버튼의 텍스트를 추가한다.
					radioNameVector.add(radioVector.elementAt(i).getText());
					//주문서에서 해당되는 라디오 버튼의 가격 텍스트를 추가한다.
					radioNameVector.add(radioPriceVector.elementAt(i));
				}

			}
		}
		//체크버튼 검사
		for (int i = 0; i < checkVector.size(); i++){
			if (source == checkVector.elementAt(i)) {
				//해당 체크버튼이 해제된 것이라면
				if (e.getStateChange() == ItemEvent.DESELECTED){
					//현재 금액에서 체크버튼의 가격만큼 제거한다.
					totalPrice -= Integer.parseInt(checkPriceVector.elementAt(i));
					//현재 체크버튼의 항목이 어느 벡터에 존재하는지 찾고
					if(checkNameVector.size() != 0){
						for(int j = 0; j < checkNameVector.size(); j++){
							if(checkNameVector.elementAt(j) == checkVector.elementAt(i).getText()){
								//제거해준다
								checkNameVector.remove(j+1);
								checkNameVector.remove(j);
							}
						}
					}
				}
				else{
					//현재 체크박스의 가격만큼 최종가격을 더한다
					totalPrice += Integer.parseInt(checkPriceVector.elementAt(i));
					//벡터에 추가해준다
					checkNameVector.add(checkVector.elementAt(i).getText());
					checkNameVector.add(checkPriceVector.elementAt(i));
				}
			}
		}
		
		orderPriceLabel.setText(totalPrice + "원");
		
	}

}
