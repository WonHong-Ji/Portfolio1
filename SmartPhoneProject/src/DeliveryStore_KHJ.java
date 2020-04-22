import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.*;


public class DeliveryStore_KHJ extends JDialog implements ActionListener{
	
	//최종적으로 모든 것을 포함하는 패널
	JPanel storeDiglog;
	JPanel storeCenterPanel, storeInfoCenterPanel, storeBtnCenterPanel;
	JPanel storeInfoTabPanePanel;
	
	//뒤로가기 버튼
	JButton backButton;
	//뒤로가기 버튼패널
	JPanel backPanel;
	
	//가게정보 레이블
	JLabel storeNameLabel, storeRankLabel;
	JLabel storeLeastPriceLabel_, storeLeastPriceLabel;
	JLabel storeDelTimeLabel_, storeDelTimeLabel;
	JLabel storeDelTipLabel_, storeDelTipLabel;
	
	//가게정보 패널
	JPanel leastPanel;
	JPanel dekTimePanel;
	JPanel delTipPanel;	
	
	//전화하기/찜하기/공유버튼
	JButton storeCallBtn, storeLoveBtn, storeShareBtn;
	
	//메뉴, 정보, 리뷰 볼 수 있는 탭패널
	JTabbedPane storeInfoTab;
	JPanel storeMenutabPanel, storeInfoTabPanel, storeReviewTabPanel;
	
	//가게의 메뉴들
	Vector<JButton> storeMenuItemButton = new Vector<JButton>();
	
	String storeKind = null;
	int storeNum = -1;
	
	public DeliveryStore_KHJ(DeliveryOrder_KHJ deliveryOrder_KHJ, String storeKind, int storeNum){
		this.setModal(true);
		this.setUndecorated(true);
		setSize(378, 674);
		this. setLocationRelativeTo(deliveryOrder_KHJ);
		
		storeCenterPanel = new JPanel();
		storeInfoCenterPanel = new JPanel();
		storeBtnCenterPanel = new JPanel();
		storeDiglog = new JPanel();
		storeMenutabPanel = new JPanel();
		storeInfoTabPanel = new JPanel();
		storeReviewTabPanel = new JPanel();
		storeInfoTabPanePanel = new JPanel();
		
		leastPanel = new JPanel();
		dekTimePanel = new JPanel();
		delTipPanel = new JPanel();
		
		backPanel = new JPanel();
		
		this.storeKind = storeKind;
		this.storeNum = storeNum;
		
		storeCenterPanel.setLayout(new BorderLayout());
		storeInfoCenterPanel.setLayout(new BorderLayout());
		storeMenutabPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, -1));
		storeMenutabPanel.setPreferredSize(new Dimension(355,2000));
		
		//================================================================
		//선택된 가게정보 읽기
		//================================================================
		
		
		BufferedReader br = null;
		FileReader fr = null;
		String str = null;
		String[] array = null;
		
		try {
			
			if(storeKind == "한식")
				fr = new FileReader("DeliveryInfo/K_Store_Info.txt");
			else if(storeKind == "카페")
				fr = new FileReader("DeliveryInfo/C_Store_Info.txt");
			else if(storeKind == "분식")
				fr = new FileReader("DeliveryInfo/B_Store_Info.txt");
			
			br = new BufferedReader(fr);
			int num = 0;
			
			while((str = br.readLine()) != null){
				array = str.split("%");
				
				//선택한 가게의 정보만 노출하도록
				if(num == storeNum){

					JLabel storeNameLabel = new JLabel(array[0], JLabel.CENTER);
					storeNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
					
					JLabel storeRankLabel = new JLabel(array[1] + " 평점: " + array[2]);
					
					JLabel storeLeastPriceLabel_ = new JLabel("최소주문: ");
					JLabel storeLeastPriceLabel = new JLabel(array[3] + "원");
					JLabel storeDelTimeLabel_ = new JLabel("배달시간: ");
					JLabel storeDelTimeLabel = new JLabel(array[4] + "분   |");
					JLabel storeDelTipLabel_ = new JLabel("배달팁: ");
					JLabel storeDelTipLabel = new JLabel(array[5] + "원");
					
					Font infoSmallFont = new Font("맑은 고딕", Font.PLAIN, 13);
					
					storeRankLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
					storeLeastPriceLabel_.setFont(infoSmallFont);
					storeLeastPriceLabel.setFont(infoSmallFont);
					storeDelTimeLabel_.setFont(infoSmallFont);
					storeDelTimeLabel.setFont(infoSmallFont);
					storeDelTipLabel_.setFont(infoSmallFont);
					storeDelTipLabel.setFont(infoSmallFont);
					
					leastPanel.add(storeLeastPriceLabel_);
					leastPanel.add(storeLeastPriceLabel);
					leastPanel.setBackground(Color.white);
					
					dekTimePanel.add(storeDelTimeLabel_);
					dekTimePanel.add(storeDelTimeLabel);
					dekTimePanel.setBackground(Color.white);
					
					dekTimePanel.add(storeDelTipLabel_);
					dekTimePanel.add(storeDelTipLabel);
					dekTimePanel.setBackground(Color.white);
					
					storeInfoCenterPanel.add(storeNameLabel,"North");
					storeInfoCenterPanel.add(leastPanel,"Center");
					storeInfoCenterPanel.add(dekTimePanel,"South");
					
					storeInfoCenterPanel.setBackground(Color.white);
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
		
		//================================================================
		//중간패널
		//================================================================
		
		backPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		backPanel.setBackground(Color.white);
		backButton = new JButton(new ImageIcon("homeImage/deliveryImg/backIcon.png"));
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addActionListener(this);
		
		backPanel.add(backButton,"West");
		

		
		storeCallBtn = new JButton(new ImageIcon("homeImage/deliveryImg/callIcon.png"));
		storeLoveBtn = new JButton(new ImageIcon("homeImage/deliveryImg/heartIcon.png"));
		storeShareBtn = new JButton(new ImageIcon("homeImage/deliveryImg/shareIcon.png"));
		
		btnUIRemove(storeCallBtn);
		btnUIRemove(storeLoveBtn);
		btnUIRemove(storeShareBtn);
		
		storeBtnCenterPanel.setLayout(new BorderLayout());
		storeBtnCenterPanel.setBackground(Color.white);
		storeBtnCenterPanel.add(storeCallBtn,"West");
		storeBtnCenterPanel.add(storeLoveBtn);
		storeBtnCenterPanel.add(storeShareBtn,"East");
		
		storeCenterPanel.add(backPanel, "North");
		storeCenterPanel.add(storeInfoCenterPanel);
		storeCenterPanel.add(storeBtnCenterPanel, "South");

		//================================================================
		//탭패널
		//================================================================
		
		//탭 UI 모두 흰색으로 변경
		UIManager.put("TabbedPane.selected", Color.WHITE);
		UIManager.put("TabbedPane.borderColor", Color.WHITE);
		UIManager.put("TabbedPane.darkShadow", Color.WHITE);
		UIManager.put("TabbedPane.light", Color.WHITE);
		UIManager.put("TabbedPane.highlight", Color.WHITE);
		UIManager.put("TabbedPane.focus", Color.WHITE);
		UIManager.put("TabbedPane.unselectedBackground", Color.WHITE);
		UIManager.put("TabbedPane.selectHighlight", Color.WHITE);
		UIManager.put("TabbedPane.tabAreaBackground", Color.WHITE);
		UIManager.put("TabbedPane.borderHightlightColor", Color.WHITE);
		
		//JTabbedPane을 생성한다.
		storeInfoTab = new JTabbedPane(){
		      public Color getForegroundAt(int index){
		    	  //선택한 탭의 색상을 푸른색으로 하고, 미선택일 시 연회색으로 한다.
		          if(getSelectedIndex() == index)
		        	  return new Color(42,195,190);
		          return Color.LIGHT_GRAY;
		      }
		};
		storeInfoTab.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		
		JScrollPane scrollPane = new JScrollPane(storeMenutabPanel);

		storeInfoTab.add("      메뉴     ",scrollPane);
		storeInfoTab.add("      정보     ",storeInfoTabPanel);
		storeInfoTab.add("     리뷰      ",storeReviewTabPanel);
		
		storeInfoTabPanePanel.setLayout(new BorderLayout());
		
		storeInfoTabPanePanel.add(storeInfoTab);
		storeInfoTabPanePanel.setBackground(Color.white);
		//================================================================
		//탭 내용 패널 - (1) 메뉴 정보
		//================================================================
		
		BufferedReader brMenu = null;
		FileReader frMenu = null;
		String strMenu = null;
		String[] arrayMenu = null;
		int numMenu = 0;
		
		//가게 눌렀을때 음식 버튼 좌라라라락 하는 그거!!
		
		try {		
			if(storeKind == "한식")
				frMenu = new FileReader("DeliveryInfo/K_Store_Item/K_Item_Store_" + storeNum + ".txt");
			else if(storeKind == "카페")
				frMenu = new FileReader("DeliveryInfo/C_Store_Item/C_Item_Store_" + storeNum + ".txt");
			else if(storeKind == "분식")
				frMenu = new FileReader("DeliveryInfo/B_Store_Item/B_Item_Store_" + storeNum + ".txt");
				
			
			brMenu = new BufferedReader(frMenu);
			
			while((strMenu = brMenu.readLine()) != null){
				arrayMenu = strMenu.split("%");
				
				storeMenuItemButton.add(new JButton());
				storeMenuItemButton.get(numMenu).setPreferredSize(new Dimension(380, 65));
				storeMenuItemButton.get(numMenu).setBackground(Color.WHITE);

				storeMenuItemButton.get(numMenu).setContentAreaFilled(false);
				storeMenuItemButton.get(numMenu).setFocusPainted(false);
				
				
				JPanel menuItemLabelPanel = new JPanel();
				menuItemLabelPanel.setLayout(new BorderLayout());
				menuItemLabelPanel.setBackground(Color.WHITE);
				
				JLabel menuItemName = new JLabel(arrayMenu[1]);
				JLabel menuItemPrice = new JLabel(arrayMenu[6] + "원", JLabel.RIGHT);
				
				menuItemName.setFont(new Font("맑은 고딕", Font.BOLD, 17));
				menuItemPrice.setForeground(Color.DARK_GRAY);
				menuItemPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				
				menuItemLabelPanel.add(menuItemName);
				menuItemLabelPanel.add(menuItemPrice, "South");

				storeMenuItemButton.get(numMenu).add(menuItemLabelPanel, "West");
				
				storeMenutabPanel.add(storeMenuItemButton.elementAt(numMenu));
				storeMenutabPanel.setBackground(Color.white);
				storeMenuItemButton.get(numMenu).addActionListener(this);
				numMenu++;
						
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{if(brMenu != null)
				brMenu.close();
			if (frMenu != null)
				frMenu.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		
		
		
		this.setLayout(new BorderLayout());

		this.add(storeCenterPanel, "North"); 
		this.add(storeInfoTabPanePanel);
		
		this.setVisible(true);
	}
	
	public void btnUIRemove(JButton btn){
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}

	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == backButton){
			this.dispose();
		}
		else{
			for(int i = 0; i < storeMenuItemButton.size(); i++){
				if(e.getSource() == storeMenuItemButton.elementAt(i)){
					new DeliveryStoreMenuItem_KHJ(this,storeKind,storeNum,i);
				}
			}
		}
	}
}
