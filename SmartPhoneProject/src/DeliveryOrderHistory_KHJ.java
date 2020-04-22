import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.View;

import java.util.*;

import javax.swing.*;

public class DeliveryOrderHistory_KHJ extends JDialog implements ActionListener{
	JButton backBtn;
	JPanel listPanel, topPanel;
	
	//주문한 항목을 담는 버튼 벡터
	Vector<JButton> orderItem = new Vector<JButton>();
	
	//orderTime패널 크기 조정용
	Vector<Integer> orderItemSize = new Vector<Integer>();
	
	String storeInfo;
	
	public DeliveryOrderHistory_KHJ(JPanel panel){
		this.setModal(true);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		setSize(378, 674);
		this. setLocationRelativeTo(panel);
		
		//뒤로가기 버튼
		backBtn = new JButton(new ImageIcon("homeImage/deliveryImg/backIcon.png"));
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.addActionListener(this);
		
		listPanel = new JPanel();
		topPanel = new JPanel();
		
		listPanel.setLayout(new FlowLayout());
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		topPanel.setBackground(Color.white);
		
		//파일입출력 
		BufferedReader br = null;
		FileReader fr = null;
		String str = null;
		String[] array = null;
		
		//가게정보(첫줄) 출력용
		boolean isStoreInfoPrint = false;

		try {
			fr = new FileReader("DeliveryInfo/Order/myOrderHistory.txt");
			br = new BufferedReader(fr);

			while((str = br.readLine()) != null){
				array = str.split("%");

				JButton itemBtn = new JButton();
				itemBtn.setLayout(new BorderLayout());
				JLabel selectKind = new JLabel("(" + array[0] + ")"); 
				JLabel selectStore = new JLabel(array[1]); 
				
				selectStore.setFont(new Font("맑은 고딕", Font.BOLD, 20));
				
				if(array[0].equals("한식")){
					storeInfo = "DeliveryInfo/K_Store_Info.txt";
				}
				else if(array[0].equals("카페")){
					storeInfo = "DeliveryInfo/C_Store_Info.txt";
				}
				else if(array[0].equals("분식")){
					storeInfo = "DeliveryInfo/B_Store_Info.txt";
				}
				
				//음식 옵션
				JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
				
				JLabel selectOption = new JLabel(array[2] + " 외");
				JLabel selectPrice = new JLabel("총액: " + array[3] + "원");
				
				selectOption.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
				selectPrice.setFont(new Font("맑은 고딕", Font.BOLD, 13));
				selectPrice.setForeground(new Color(42,195,190));
				
				optionPanel.add(selectOption);
				
				//가게이름 받아내기 위한 파일
				BufferedReader br1 = null;
				FileReader fr1 = null;
				String str1 = null;
				String[] array1 = null;
				int indexStore = 0;
				int indexStoreThis = Integer.parseInt(selectStore.getText());
				
				try {
					fr1 = new FileReader(storeInfo);
					br1 = new BufferedReader(fr1);
	
					while((str1 = br1.readLine()) != null){
						array1 = str1.split("%");
						if(indexStore == indexStoreThis)
							selectStore.setText(array1[0]);
						indexStore++;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				} finally{
					try{if(br1 != null)
						br1.close();
					if (fr1 != null)
						fr1.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				JPanel storeNamePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
				
				storeNamePanel.setBackground(Color.white);
				optionPanel.setBackground(Color.white);
				selectPrice.setBackground(Color.white);
				itemBtn.setBackground(Color.white);
				storeNamePanel.add(selectStore);
				
				
				itemBtn.add(storeNamePanel, "North");
				itemBtn.add(optionPanel);
				itemBtn.add(selectPrice, "East");	

				orderItem.add(itemBtn);
			}
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(br != null)
					br.close();
				if (fr != null)
					fr.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < orderItem.size(); i++){
			orderItem.elementAt(i).setBackground(Color.white);
			
			orderItem.elementAt(i).setPreferredSize(new Dimension(380,95));
			orderItem.elementAt(i).setContentAreaFilled(false);
			orderItem.elementAt(i).setFocusPainted(false);
			listPanel.add(orderItem.elementAt(i));
		}

		topPanel.add(backBtn);
		
		this.getContentPane().setBackground(Color.white);
		listPanel.setBackground(Color.white);
		this.add(topPanel, "North");
		this.add(listPanel, "Center");
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backBtn){
			this.dispose();
		}
		
	}
}