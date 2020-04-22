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
	
	//�޴��˾��Ѱ��г�
	JPanel itemInfoPanel;
	
	//�޴� �̸�, �̹��� ���� �г�
	JPanel foodNamePanel;
	//�޴� �ɼ� �Ѱ��г�
	JPanel foodOptionPanel;
	//�޴� �߰��ɼ� �Ѱ��г�
	JPanel foodAddOptionPanel;
	//�޴��̸� ���̺�
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
	
	//������ ���� �з��� �̸�
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
		
		//�ֹ����� �����ϱ� ���� �������� (�������� / �����̸�)
		nowStoreKindNum = storeKind + "%" + storeNum + "%";
				
		BufferedReader br = null;
		FileReader fr = null;
		String str = null;
		String[] array = null;
		
		try {
			
			//� ���� �ҷ�����
			if(storeKind == "�ѽ�")
				fr = new FileReader("DeliveryInfo/K_Store_Item/K_Item_Store_" + storeNum + ".txt");
			else if(storeKind == "ī��")
				fr = new FileReader("DeliveryInfo/C_Store_Item/C_Item_Store_" + storeNum + ".txt");
			else if(storeKind == "�н�")
				fr = new FileReader("DeliveryInfo/B_Store_Item/B_Item_Store_" + storeNum + ".txt");
			
			br = new BufferedReader(fr);
			int num = 0;
			int gridnum = 0;
			
			while((str = br.readLine()) != null){
				array = str.split("%");
				
				if(num == fooditemNum){
					
					//�����̸�, �̹��� �г�
					foodNamePanel.setLayout(new BorderLayout());
					foodNamePanel.setBackground(Color.white);
					//�޴� �ɼǵ� ǥ�� �г�
					foodAddOptionPanel.setLayout(new BorderLayout());
					foodAddOptionPanel.setBackground(Color.white);
					
					//!!!�Ѱ��г�!!! 
					itemInfoPanel.setLayout(new BorderLayout());
					itemInfoPanel.setBackground(Color.white);
					
					JLabel foodImg = new JLabel(new ImageIcon(array[myItemNum]));
					foodName = new JLabel(array[++myItemNum] , JLabel.CENTER);
					foodName.setFont(new Font("���� ���", Font.BOLD, 20));
					
					foodNamePanel.add(foodImg,"North");
					foodNamePanel.add(foodName);
					
					//end���� ������ ������ üũ�ڽ� Ȥ�� ������ư�� �������ش�
					while(!array[myItemNum+1].equals("end")){
						
						//������ư ����
						if(array[myItemNum+1].equals("R")){
							myItemNum++;
							int radioNum = Integer.parseInt(array[++myItemNum]);
							
							JLabel foodOption_ = new JLabel(array[++myItemNum]);
							JLabel foodOption_Label = new JLabel("");
							
							
							//���̾ƿ� ���߱� ���� ī�װ� ���Ƿ� ������ ����
							foodOption_.setPreferredSize(new Dimension(350, 30));
							
							//�޴� ī�װ�(�⺻) �г�
							JPanel foodOptionRadioTitlePanel = new JPanel();
							foodOptionRadioTitlePanel.setBackground(Color.white);
							foodOptionRadioTitlePanel.add(foodOption_);
							foodOption_.setFont(new Font("���� ���", Font.BOLD, 17));
							
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
								foodOptionRadioBtn1Label[i] = new JLabel("+" + array[++myItemNum] +"��");
								radioPriceVector.add(array[myItemNum]);
								foodOptionrBtnGroup.add (foodOptionRadioBtn[i]);
								
								foodOptionRadioPanel[i] = new JPanel();
								foodOptionRadioPanel[i].setLayout(new BorderLayout());
								foodOptionRadioPanel[i].setPreferredSize(new Dimension(340,20));
								
								foodOptionRadioPanel[i].add(foodOptionRadioBtn[i], "West");
								foodOptionRadioPanel[i].add(foodOptionRadioBtn1Label[i], "East");
								
								foodOptionRadioPanel[i].setBackground(Color.white);
								foodOptionRadioBtn[i].setBackground(Color.white);
								foodOptionRadioBtn1Label[i].setFont(new Font("���� ���", Font.PLAIN, 13));
								foodOptionRadioBtn[i].setFont(new Font("���� ���", Font.PLAIN, 13));
								
								foodOptionRadioPanelMng.add(foodOptionRadioPanel[i]);
								
								radioVector.add(foodOptionRadioBtn[i]);

								foodOptionRadioBtn[i].addActionListener(this);
								foodOptionRadioBtn[i].addItemListener(this);
							}
							
							foodOptionPanel_1.add(foodOptionRadioPanelMng);
							
							foodOptionPanel.add(foodOptionPanel_1);

						}
						//üũ�ڽ� ����
						if(array[myItemNum+1].equals("C")){
							myItemNum++;
							int checkNum = Integer.parseInt(array[++myItemNum]);
							
							JLabel foodAddOption1_ = new JLabel(array[++myItemNum]);
							//���̾ƿ� ���߱� ���� ī�װ� ���Ƿ� ������ ����
							foodAddOption1_.setPreferredSize(new Dimension(350, 30));
							
							//�޴� ī�װ�(�߰�����) �г�
							JPanel foodOptionCheckTitlePanel = new JPanel();
							foodOptionCheckTitlePanel.setBackground(Color.white);
							foodOptionCheckTitlePanel.add(foodAddOption1_);
							foodAddOption1_.setFont(new Font("���� ���", Font.BOLD, 17));
							
							JCheckBox foodOptionCheckBox[] = new JCheckBox[checkNum];
							JLabel foodOptionCheckBox1Label[] = new JLabel[checkNum];
							
							JPanel foodOptionCheckPanel_[] = new JPanel[checkNum];
							
							//�г��� �����׸��� ���� �г�
							JPanel foodOptionCheckPanel = new JPanel();
							foodOptionCheckPanel.setBackground(Color.white);
							foodOptionCheckPanel.setLayout(new GridLayout(checkNum,0,5,10));
							gridnum = gridnum + checkNum + 1;
							
							for(int i = 0; i < checkNum; i++){
								foodOptionCheckBox[i] = new JCheckBox(array[++myItemNum] + " �߰�");
								foodOptionCheckBox1Label[i] = new JLabel("+" + array[++myItemNum] + "��");
								checkPriceVector.add(array[myItemNum]);
								
								foodOptionCheckPanel_[i] = new JPanel();
								foodOptionCheckPanel_[i].setLayout(new BorderLayout());
								foodOptionCheckPanel_[i].setPreferredSize(new Dimension(350,20));
								
								foodOptionCheckPanel_[i].add(foodOptionCheckBox[i], "West");
								foodOptionCheckPanel_[i].add(foodOptionCheckBox1Label[i], "East");
								
								foodOptionCheckPanel_[i].setBackground(Color.white);
								foodOptionCheckBox[i].setBackground(Color.white);
								foodOptionCheckBox[i].setFont(new Font("���� ���", Font.PLAIN, 13));
								foodOptionCheckBox1Label[i].setFont(new Font("���� ���", Font.PLAIN, 13));
								
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
		
		//�ڷΰ��� ��ư
		backPanel.setBackground(Color.white);
		backButton = new JButton(new ImageIcon("homeImage/deliveryImg/backIcon.png"));
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addActionListener(this);
		backButton.addActionListener(this);
		
		backPanel.add(backButton);
		
		//�ֹ���ư
		orderButton = new JButton (new ImageIcon("homeImage/deliveryImg/orderBtn.png"));
		orderButton.addActionListener(this);
		
		this.add(backPanel, "North");
		this.add(itemInfoPanel, "Center");
		this.add(orderButton, "South");
		
		//���� ��ư�� defalut���� ���� ���ݰ��� ���� �ʱ�ȭ�� �Ѵ�
		for(int i = 0; i < radioVector.size(); i++){
			if(radioVector.elementAt(i).isSelected()){
				totalPrice +=  Integer.parseInt(radioPriceVector.elementAt(i));
				radioNameVector.add(radioVector.elementAt(i).getText());
				radioNameVector.add(radioPriceVector.elementAt(i));
			}
		}	
		
		//�ֹ���ư ���� �������� ǥ��
		orderPriceLabel = new JLabel(totalPrice + "��");
		orderPriceLabel.setForeground(Color.white);
		orderPriceLabel.setFont(new Font("���� ���", Font.BOLD, 13));
		orderButton.setLayout(new FlowLayout(FlowLayout.TRAILING));
		orderButton.add(orderPriceLabel);
		

		this.setVisible(true);		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//������
		if(e.getSource() == backButton){
			this.dispose();
		}
		
		//�ֹ��ϱ⸦ ������ �ÿ� ���Ͽ� ����
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
				return;	//��������
			}
			
			
			 PrintWriter pw = null;
			 BufferedReader br = null;
			 
			try {
		        pw= new PrintWriter(new FileWriter(f, true));
		        br = new BufferedReader(new FileReader(f));
		        
		        String nowStoreKindNumStr = br.readLine();
	        	
		        if(!nowStoreKindNum.equals(nowStoreKindNumStr)){

					//������ ��������, �����̸�
					if(br.readLine() == null){
						pw.write(nowStoreKindNum);
						pw.write("\r\n");
					}
					else
					{
						//�ٸ� ������ �޴��� ��Ҵٸ�
						int result = JOptionPane.showConfirmDialog(null, "<html>��ٱ��Ͽ��� ���� ������ �޴��� ���� �� �ֽ��ϴ�.<br>������ ���� �޴��� �����˴ϴ�.<html>",
								"", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null) ;
						
						if(result == JOptionPane.YES_OPTION){
							//���� ������ ���, ��� �ʱ�ȭ�Ѵ�.
							pw = new PrintWriter(new FileWriter(f, false));
							pw.write(nowStoreKindNum);
							pw.write("\r\n");
						}
						else {
							return;
						}
					}
		        }
		        
		        //������ ���� �̸�
				pw.write(foodName.getText() + "%");
				
				//������ư ���
				for(int j = 0; j < radioNameVector.size()/2; j+=2){
					pw.write(radioNameVector.elementAt(j) + "%" +radioNameVector.elementAt(j+1) + "%");
				}
				//üũ�ڽ� ���
				for(int j = 0; j < checkNameVector.size(); j+=2){
					pw.write(checkNameVector.elementAt(j) + "%" +checkNameVector.elementAt(j+1) + "%");
				}
				//�� ����
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
	
	//üũ�ڽ� Ȥ�� ���� ��ư�� ������ �ÿ� ȣ��Ǵ� itemStateChanged �޼ҵ�
	public void itemStateChanged(ItemEvent e) {
				
		//���� ���õ� �̺�Ʈ ������Ʈ�� �޾ƿ´�
		Object source = e.getItemSelectable();
		
		//������ư �˻�
		for (int i = 0; i < radioVector.size(); i++){
			if (source == radioVector.elementAt(i)) {
				//������ư�� Ŭ�� ������ ���̶��
				if (e.getStateChange() == ItemEvent.DESELECTED){
					//���� �ݾ׿��� ���õ� ������ư�� �ݾ��� ���Ѵ�
					totalPrice -= Integer.parseInt(radioPriceVector.elementAt(i));
					//�ֹ������� �ش� ������ư�� �ؽ�Ʈ�� ã��, �ִٸ� �����Ѵ�.
					for(int j = 0; j < radioNameVector.size(); j++){
						if(radioNameVector.elementAt(j) == radioVector.elementAt(i).getText()){
							radioNameVector.remove(j+1);
							radioNameVector.remove(j);
						}
					}
				}
				else{
					//���� �ݾ׿��� ���õ� ���� ��ư�� �ݾ��� ���Ѵ�
					totalPrice += Integer.parseInt(radioPriceVector.elementAt(i));
					//�ֹ������� �ش�Ǵ� ���� ��ư�� �ؽ�Ʈ�� �߰��Ѵ�.
					radioNameVector.add(radioVector.elementAt(i).getText());
					//�ֹ������� �ش�Ǵ� ���� ��ư�� ���� �ؽ�Ʈ�� �߰��Ѵ�.
					radioNameVector.add(radioPriceVector.elementAt(i));
				}

			}
		}
		//üũ��ư �˻�
		for (int i = 0; i < checkVector.size(); i++){
			if (source == checkVector.elementAt(i)) {
				//�ش� üũ��ư�� ������ ���̶��
				if (e.getStateChange() == ItemEvent.DESELECTED){
					//���� �ݾ׿��� üũ��ư�� ���ݸ�ŭ �����Ѵ�.
					totalPrice -= Integer.parseInt(checkPriceVector.elementAt(i));
					//���� üũ��ư�� �׸��� ��� ���Ϳ� �����ϴ��� ã��
					if(checkNameVector.size() != 0){
						for(int j = 0; j < checkNameVector.size(); j++){
							if(checkNameVector.elementAt(j) == checkVector.elementAt(i).getText()){
								//�������ش�
								checkNameVector.remove(j+1);
								checkNameVector.remove(j);
							}
						}
					}
				}
				else{
					//���� üũ�ڽ��� ���ݸ�ŭ ���������� ���Ѵ�
					totalPrice += Integer.parseInt(checkPriceVector.elementAt(i));
					//���Ϳ� �߰����ش�
					checkNameVector.add(checkVector.elementAt(i).getText());
					checkNameVector.add(checkPriceVector.elementAt(i));
				}
			}
		}
		
		orderPriceLabel.setText(totalPrice + "��");
		
	}

}
