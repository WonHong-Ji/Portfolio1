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

public class DeliveryBasket_KHJ extends JDialog implements ActionListener{
	
	JButton backBtn, orderBtn, allDelBtn;
	JPanel backAndAllDelPanel, storeNamePanel, topPanel;
	JPanel listPanel;
	JLabel emptyLabel;
	
	
	//주문한 항목을 담는 패널 벡터
	Vector<JPanel> orderItem = new Vector<JPanel>();
	
	//orderTime패널 크기 조정용
	Vector<Integer> orderItemSize = new Vector<Integer>();
	//삭제버튼
	Vector<JButton> delBtn = new Vector<JButton>();
	
	int totalPrice;
	JScrollPane scrollPane;
	String storeInfo;

	public DeliveryBasket_KHJ(JPanel panel){
		this.setModal(true);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		setSize(378, 674);
		this. setLocationRelativeTo(panel);
		
		listPanel = new JPanel();
		storeNamePanel = new JPanel();
		topPanel = new JPanel();
		backAndAllDelPanel = new JPanel();
		
		listPanel.setLayout(new FlowLayout());
		storeNamePanel.setLayout(new FlowLayout());
		topPanel.setLayout(new BorderLayout());
		backAndAllDelPanel.setLayout(new BorderLayout());
		
		listPanel.setPreferredSize(new Dimension(355,2000));
		
		storeNamePanel.setBackground(Color.WHITE);
		emptyLabel = new JLabel(new ImageIcon("homeImage/deliveryImg/empty.png"));
		
		//뒤로가기 버튼
		backBtn = new JButton(new ImageIcon("homeImage/deliveryImg/backIcon.png"));
		btnUIRemove(backBtn);
		backBtn.addActionListener(this);
		
		allDelBtn = new JButton(new ImageIcon("homeImage/deliveryImg/allDelIcon.png"));
		btnUIRemove(allDelBtn);
		allDelBtn.addActionListener(this);
		
		orderBtn = new JButton(new ImageIcon("homeImage/deliveryImg/orderBtn.png"));
		btnUIRemove(orderBtn);
		orderBtn.addActionListener(this);
		
		totalPrice = 0;
		
		//파일입출력 
		BufferedReader br = null;
		FileReader fr = null;
		String str = null;
		String[] array = null;
		
		//가게정보(첫줄) 출력용
		boolean isStoreInfoPrint = false;
		int index = 0;

		try {
			fr = new FileReader("DeliveryInfo/Order/myOrder.txt");
			br = new BufferedReader(fr);

			while((str = br.readLine()) != null){
				array = str.split("%");
				
				index = 0;
				
				if(!isStoreInfoPrint){
					//주문한 아이템의 정보를 담는 패널 생성
					JPanel selectOrderItemPanel = new JPanel(); 
					
					//가게이름 레이블 최상단
					JLabel selectKind = new JLabel("(" + array[index] + ")"); 
					
					if(array[index].equals("한식")){
						storeInfo = "DeliveryInfo/K_Store_Info.txt";
					}
					else if(array[index].equals("카페")){
						storeInfo = "DeliveryInfo/C_Store_Info.txt";
					}
					else if(array[index].equals("분식")){
						storeInfo = "DeliveryInfo/B_Store_Info.txt";
					}
					
					JLabel selectStore = new JLabel(array[++index]); 
					
					selectStore.setFont(new Font("맑은 고딕", Font.BOLD, 18));
					
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
					
					storeNamePanel.add(selectStore);
					
					isStoreInfoPrint = true;
				}
				else{
					JPanel itemPanel = new JPanel();
					itemPanel.setBackground(Color.white);
					itemPanel.setLayout(new BorderLayout());
					
					JButton del = new JButton("삭제");
					del.setFont(new Font("맑은 고딕", Font.BOLD, 14));
					del.setForeground(new Color(42,195,190));
					btnUIRemove(del);
					del.addActionListener(this);
					delBtn.add(del);
					
					//음식이름
					JLabel selectName = new JLabel(array[index]);
					
					selectName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
					
					JPanel itemtopPanel = new JPanel(new BorderLayout());
					
					itemtopPanel.add(selectName,"West");
					itemtopPanel.add(del, "East");
					
					itemtopPanel.setBackground(Color.white);
					
					itemPanel.add(itemtopPanel,"North");
					
					JPanel optionItemPanel = new JPanel(new FlowLayout());
					optionItemPanel.setBackground(Color.white);
					
					int orderItemInt = 0;
					//음식 옵션
					for(int i = (index+1); i < array.length-3; i+=2){
						
						JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
						JLabel selectOption = new JLabel(array[++index] + ":");
						JLabel selectOption2 = new JLabel("(" + array[++index] + "원)");
						int temp = Integer.parseInt(array[index]);
						
						selectOption.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
						selectOption2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
						
						selectOption.setForeground(Color.DARK_GRAY);
						selectOption2.setForeground(Color.DARK_GRAY);
						
						optionPanel.add(selectOption);
						optionPanel.add(selectOption2);
						optionPanel.setBackground(Color.white);
						
						optionPanel.setPreferredSize(new Dimension(340, 30));
						
						optionItemPanel.add(optionPanel);
						
						
						totalPrice += temp;
						orderItemInt++;
					}
					
					itemPanel.add(optionItemPanel,"Center");
					
					//가격
					JPanel bottomPanel = new JPanel(new BorderLayout());
					bottomPanel.setBackground(Color.white);
					
					JLabel selectPrice = new JLabel(array[++index] + "원");
					selectPrice.setFont(new Font("맑은 고딕", Font.BOLD, 14));
					
					bottomPanel.add(selectPrice,"East");
					bottomPanel.add(new JLabel("──────────────────────────"),"South");

					itemPanel.add(bottomPanel, "South");
					//itemPanel.add();
					orderItem.add(itemPanel);
					orderItemSize.add(orderItemInt);
					
				}

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


		//주문한 음식의 갯수만큼 생성된 패널벡터의 설정 일괄조정
		for(int i = 0; i < orderItem.size(); i++){
			orderItem.elementAt(i).setPreferredSize(new Dimension(350, 85 + (35 * orderItemSize.elementAt(i))));
			listPanel.add(orderItem.elementAt(i));
		}

		if(!isStoreInfoPrint){
			listPanel.removeAll();
			listPanel.setLayout(new BorderLayout());
			listPanel.setPreferredSize(new Dimension(355,500));
			listPanel.add(emptyLabel);
		}
		
		listPanel.setBackground(Color.white);
		
		backAndAllDelPanel.add(backBtn,"West");
		backAndAllDelPanel.add(allDelBtn,"East");
		backAndAllDelPanel.setBackground(Color.white);
		
		topPanel.add(backAndAllDelPanel, "North");
		topPanel.add(storeNamePanel, "South");
		
		this.getContentPane().setBackground(Color.white);
		
		scrollPane = new JScrollPane(listPanel);
		
		
		this.add(topPanel,"North");
		this.add(scrollPane);
		this.add(orderBtn,"South");

		this.setVisible(true);
		
	}
	
	//버튼의 기본 테두리나 기본 배경을 삭제하는 메소드 
	public void btnUIRemove(JButton btn){
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn){
			this.dispose();
		}
		//주문버튼
		else if(e.getSource() == orderBtn){
			//주문하기 선택시에 모두 지우고, 계산서를 작성해 메모장에 따로 저장해둔다.
			
			if(orderItem.size() != 0){
				InputStream is = null;
				OutputStream os = null;
				

				//가게종류, 가게이름, 주문음식, 총금액 담는 String배열
				String orderStr[] = new String[4];
				
				//파일입출력 
				BufferedReader br = null;
				FileReader fr = null;
				String str = null;
				String[] array = null;
				
				//가게정보(첫줄) 출력용
				boolean isStoreInfoPrint = false;
				int index = 0;

				//파일을 읽어와, 필요한 정보만을 저장하고 닫아준다
				try {
					fr = new FileReader("DeliveryInfo/Order/myOrder.txt");
					br = new BufferedReader(fr);

					while((str = br.readLine()) != null){
						array = str.split("%");
						
						index = 0;
						
						if(!isStoreInfoPrint){
							orderStr[0] = array[index]; 
							orderStr[1] = array[++index]; 
							isStoreInfoPrint = true;
						}
						else{
							orderStr[2] = array [index];

							//가격
							orderStr[3] = totalPrice + "";

						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}catch (IOException e1) {
					e1.printStackTrace();
				} finally{
					try{if(br != null)
						br.close();
					if (fr != null)
						fr.close();
					}catch (IOException e1) {
						e1.printStackTrace();
					}
				}
							
				//저장한 정보값을 새 파일에 넣어준다.
				try {
			        PrintWriter pw= new PrintWriter(new FileWriter("DeliveryInfo/Order/myOrderHistory.txt", true));
			        pw.write(orderStr[0] + "%");
			        pw.write(orderStr[1] + "%");
			        pw.write(orderStr[2] + "%");
			        pw.write(orderStr[3]);
			        pw.write("\r\n");
			     
			        pw.close();
			    } catch (IOException e1) {
			        e1.printStackTrace();
			    }              
				
				//처리가 모두 끝났다면, 내부 내용을 모두 삭제하고 창을 닫아준다
				try {
					new FileOutputStream("DeliveryInfo/Order/myOrder.txt").close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				storeNamePanel.removeAll();
				listPanel.removeAll();
				listPanel.revalidate();
				listPanel.repaint();
				totalPrice = 0;
				
				int result = JOptionPane.showConfirmDialog(null, "주문이 완료되었습니다.",
						"", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null) ;
				
				if(result == JOptionPane.OK_OPTION){
					this.dispose();
				}
			}
			else{
				int result = JOptionPane.showConfirmDialog(null, "장바구니가 비어있습니다.",
						"", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null) ;
			}
		}
		
		else if(e.getSource() == allDelBtn){
			try {
				new FileOutputStream("DeliveryInfo/Order/myOrder.txt").close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			storeNamePanel.removeAll();
			listPanel.removeAll();
			
			listPanel.setLayout(new BorderLayout());
			listPanel.setPreferredSize(new Dimension(355,500));
			listPanel.add(emptyLabel);
			totalPrice = 0;

			listPanel.revalidate();
			listPanel.repaint();
		}
		
		for(int i = 0; i < delBtn.size(); i++){
			if(e.getSource() == delBtn.elementAt(i)){
				//삭제버튼 선택시에 지워주기 (만약 하나밖에 없다면 다 지워주는if문 추가) 
				
				//파일 열어서 삭제하는 로직 
				//요소가 하나밖에 남지 않았다면
				if(delBtn.size() == 1){
					try {
						new FileOutputStream("DeliveryInfo/Order/myOrder.txt").close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					storeNamePanel.removeAll();
					listPanel.removeAll();
					
					listPanel.setLayout(new BorderLayout());
					listPanel.setPreferredSize(new Dimension(355,500));
					listPanel.add(emptyLabel);
					totalPrice = 0;
					
					listPanel.revalidate();
					listPanel.repaint();
				}
				else{
					File file = new File("DeliveryInfo/Order/myOrder.txt");		

					String dummy = "";

					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

						//1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
						String line;
						for(int j = 0; j < (i+1); j++) {
						    line = br.readLine(); //읽으며 이동
						    dummy += (line + "\r\n" );
						}

						//2. 데이터삭제 건너뛰기전에 가격만 알아와서 총값 빼주기
						String delData = br.readLine();
						
						String array[] = delData.split("%");
						
						int temp = Integer.parseInt(array[array.length-2]);
						totalPrice -= temp;
						
						System.out.println(delData);

						//3. 삭제하고자 하는 position 이후부터 dummy에 저장
						while((line = br.readLine())!=null) {
							dummy += (line + "\r\n" ); 
						}
						//4. FileWriter를 이용해서 덮어쓰기
						FileWriter fw = new FileWriter("DeliveryInfo/Order/myOrder.txt");
						fw.write(dummy);			
						fw.close();
						br.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					//=================================================================================================
					//삭제가 예쁘게 안되어서 그냥 처음부터 다시 그려주는 부분...
					//=================================================================================================
					listPanel.removeAll();
					orderItem.removeAllElements();
					orderItemSize.removeAllElements();
					delBtn.removeAllElements();		
					this.remove(scrollPane);

					BufferedReader br = null;
					FileReader fr = null;
					String str = null;
					String[] array = null;
					
					//가게정보(첫줄) 출력용
					boolean isStoreInfoPrint = false;
					int index = 0;

					try {
						fr = new FileReader("DeliveryInfo/Order/myOrder.txt");
						br = new BufferedReader(fr);

						while((str = br.readLine()) != null){
							array = str.split("%");
							
							index = 0;
							
							if(!isStoreInfoPrint)
								isStoreInfoPrint = true;
							else{
								JPanel itemPanel = new JPanel();
								itemPanel.setBackground(Color.white);
								itemPanel.setLayout(new BorderLayout());
								
								JButton del = new JButton("삭제");
								del.setFont(new Font("맑은 고딕", Font.BOLD, 14));
								del.setForeground(new Color(42,195,190));
								btnUIRemove(del);
								del.addActionListener(this);
								delBtn.add(del);
								
								//음식이름
								JLabel selectName = new JLabel(array[index]);
								
								selectName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
								
								JPanel itemtopPanel = new JPanel(new BorderLayout());
								
								itemtopPanel.add(selectName,"West");
								itemtopPanel.add(del, "East");
								
								itemtopPanel.setBackground(Color.white);
								
								itemPanel.add(itemtopPanel,"North");
								
								JPanel optionItemPanel = new JPanel(new FlowLayout());
								optionItemPanel.setBackground(Color.white);
								
								int orderItemInt = 0;
								//음식 옵션
								for(int j = (index+1); j < array.length-3; j+=2){
									
									JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
									JLabel selectOption = new JLabel(array[++index] + ":");
									JLabel selectOption2 = new JLabel("(" + array[++index] + "원)");
									
									selectOption.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
									selectOption2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
									
									selectOption.setForeground(Color.DARK_GRAY);
									selectOption2.setForeground(Color.DARK_GRAY);
									
									optionPanel.add(selectOption);
									optionPanel.add(selectOption2);
									optionPanel.setBackground(Color.white);
									
									optionPanel.setPreferredSize(new Dimension(340, 30));
									
									optionItemPanel.add(optionPanel);
									
									orderItemInt++;

								}
								itemPanel.add(optionItemPanel,"Center");
								
								//가격
								JPanel bottomPanel = new JPanel(new BorderLayout());
								bottomPanel.setBackground(Color.white);
								
								JLabel selectPrice = new JLabel(array[++index] + "원");
								selectPrice.setFont(new Font("맑은 고딕", Font.BOLD, 14));
								
								bottomPanel.add(selectPrice,"East");
								bottomPanel.add(new JLabel("──────────────────────────"),"South");

								itemPanel.add(bottomPanel, "South");
								//itemPanel.add();
								orderItem.add(itemPanel);
								orderItemSize.add(orderItemInt);
								
							}

						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}catch (IOException e1) {
						e1.printStackTrace();
					} finally{
						try{if(br != null)
							br.close();
						if (fr != null)
							fr.close();
						}catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					for(int j = 0; j < orderItem.size(); j++){
						orderItem.elementAt(j).setPreferredSize(new Dimension(350, 85 + (35 * orderItemSize.elementAt(j))));
						listPanel.add(orderItem.elementAt(j));
					}
					
					scrollPane = new JScrollPane(listPanel);
					listPanel.setPreferredSize(new Dimension(355,2000));
					
					this.add(scrollPane);
					
					//=================================================================================================
					//다 그림!
					//=================================================================================================
					
					scrollPane.revalidate();
					scrollPane.repaint();
					revalidate();
					repaint();
				}
			}
		}
	}
}
