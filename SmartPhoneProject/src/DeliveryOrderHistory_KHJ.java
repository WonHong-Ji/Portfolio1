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
	
	//�ֹ��� �׸��� ��� ��ư ����
	Vector<JButton> orderItem = new Vector<JButton>();
	
	//orderTime�г� ũ�� ������
	Vector<Integer> orderItemSize = new Vector<Integer>();
	
	String storeInfo;
	
	public DeliveryOrderHistory_KHJ(JPanel panel){
		this.setModal(true);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		setSize(378, 674);
		this. setLocationRelativeTo(panel);
		
		//�ڷΰ��� ��ư
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
		
		//��������� 
		BufferedReader br = null;
		FileReader fr = null;
		String str = null;
		String[] array = null;
		
		//��������(ù��) ��¿�
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
				
				selectStore.setFont(new Font("���� ���", Font.BOLD, 20));
				
				if(array[0].equals("�ѽ�")){
					storeInfo = "DeliveryInfo/K_Store_Info.txt";
				}
				else if(array[0].equals("ī��")){
					storeInfo = "DeliveryInfo/C_Store_Info.txt";
				}
				else if(array[0].equals("�н�")){
					storeInfo = "DeliveryInfo/B_Store_Info.txt";
				}
				
				//���� �ɼ�
				JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
				
				JLabel selectOption = new JLabel(array[2] + " ��");
				JLabel selectPrice = new JLabel("�Ѿ�: " + array[3] + "��");
				
				selectOption.setFont(new Font("���� ���", Font.PLAIN, 13));
				selectPrice.setFont(new Font("���� ���", Font.BOLD, 13));
				selectPrice.setForeground(new Color(42,195,190));
				
				optionPanel.add(selectOption);
				
				//�����̸� �޾Ƴ��� ���� ����
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