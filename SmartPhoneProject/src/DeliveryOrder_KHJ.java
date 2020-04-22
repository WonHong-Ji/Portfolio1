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


public class DeliveryOrder_KHJ extends JDialog implements ActionListener{

	//�ݱ��г� ���������г�
	JPanel backBtnPanel;
	
	JPanel storeListPanel_K;
	JPanel storeListPanel_C;
	JPanel storeListPanel_B;
	
	JButton backBtn;
	
	JTabbedPane selOrderTab;
	
	//�������� UI
	Vector<JButton> storeBtnK = new Vector<JButton>();
	Vector<JLabel> storeImgK = new Vector<JLabel>();
	Vector<JLabel> storeNameK = new Vector<JLabel>();
	Vector<JLabel> storeRankK = new Vector<JLabel>();
	Vector<JLabel> storeTimeK = new Vector<JLabel>();
	Vector<JLabel> storeDelTipK = new Vector<JLabel>();

	Vector<JButton> storeBtnC = new Vector<JButton>();
	Vector<JLabel> storeImgC = new Vector<JLabel>();
	Vector<JLabel> storeNameC = new Vector<JLabel>();
	Vector<JLabel> storeRankC = new Vector<JLabel>();
	Vector<JLabel> storeTimeC = new Vector<JLabel>();
	Vector<JLabel> storeDelTipC = new Vector<JLabel>();
	
	Vector<JButton> storeBtnB = new Vector<JButton>();
	Vector<JLabel> storeImgB = new Vector<JLabel>();
	Vector<JLabel> storeNameB = new Vector<JLabel>();
	Vector<JLabel> storeRankB = new Vector<JLabel>();
	Vector<JLabel> storeTimeB = new Vector<JLabel>();
	Vector<JLabel> storeDelTipB = new Vector<JLabel>();
	
	
	//�������� 
	
	//0: �ѽ� , 1: ī�����Ʈ, 2: �н�
	int tabNum = 0;
	
	public DeliveryOrder_KHJ(JPanel panel, int tabNum){
		
		this.setModal(true);
		this.setUndecorated(true);
		setSize(378, 674);
		this. setLocationRelativeTo(panel);
		
		this.getContentPane().setBackground(Color.white);
		
		backBtnPanel = new JPanel();
		//�ѽ� ī�� �н��г�
		storeListPanel_K = new JPanel();
		storeListPanel_C = new JPanel();
		storeListPanel_B = new JPanel();
		
		storeListPanel_K.setLayout(new FlowLayout(FlowLayout.CENTER, 0, -5));
		storeListPanel_C.setLayout(new FlowLayout(FlowLayout.CENTER, 0, -5));
		storeListPanel_B.setLayout(new FlowLayout(FlowLayout.CENTER, 0, -5));
		
		backBtnPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		backBtnPanel.setBackground(Color.white);
		backBtn = new JButton(new ImageIcon("homeImage/deliveryImg/backIcon.png"));
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		
		backBtn.addActionListener(this);

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
		
		
		selOrderTab = new JTabbedPane(){
		      public Color getForegroundAt(int index){
		    	  //������ ���� ������ Ǫ�������� �ϰ�, �̼����� �� ��ȸ������ �Ѵ�.
		          if(getSelectedIndex() == index)
		        	  return new Color(42,195,190);
		          return Color.LIGHT_GRAY;
		      }
		};
		
		selOrderTab.setBackground(Color.white);
		selOrderTab.setFont(new Font("���� ���", Font.BOLD, 20));
		
		//=================================================================================
		// �ѽ� �г�
		//=================================================================================

		BufferedReader brK = null;
		FileReader frK = null;
		String strK = null;
		String[] arrayK = null;
		
		try {
			frK = new FileReader("DeliveryInfo/K_Store_Info.txt");
			brK = new BufferedReader(frK);

			while((strK = brK.readLine()) != null){
				arrayK = strK.split("%");
				
				JLabel nameK = new JLabel(arrayK[0]);
				JLabel rankK = new JLabel("���� : " + arrayK[2] + "   " + arrayK[1]);
				JLabel timeK = new JLabel("��޽ð� : " + arrayK[4] + "��");
				JLabel delTipK = new JLabel("����� : " + arrayK[5] + "��");
				
				storeNameK.add(nameK);
				storeRankK.add(rankK);
				storeTimeK.add(timeK);
				storeDelTipK.add(delTipK);
				storeImgK.add(new JLabel(new ImageIcon(arrayK[6])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{if(brK != null)
				brK.close();
			if (frK != null)
				frK.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//UI����
		for(int i = 0; i < storeNameK.size(); i++){
			Font storeFont = new Font("���� ���",Font.BOLD, 20);
			Font storesmallFont = new Font("���� ���",Font.PLAIN, 10);
			
			storeNameK.elementAt(i).setFont(storeFont);
			storeRankK.elementAt(i).setFont(storesmallFont);
			storeTimeK.elementAt(i).setFont(storesmallFont);
			storeDelTipK.elementAt(i).setFont(storesmallFont);
			
			storeBtnK.add(new JButton());
			storeBtnK.elementAt(i).setLayout(new BorderLayout());
			JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
			storeBtnK.elementAt(i).setPreferredSize(new Dimension(380, 95));	
			btnUIRemove(storeBtnK.elementAt(i));
			
			JPanel storePanel = new JPanel();
			storePanel.setLayout(new BoxLayout(storePanel, BoxLayout.Y_AXIS));
			storePanel.setBackground(Color.WHITE);
			
			storePanel.add(storeNameK.elementAt(i));
			storePanel.add(storeRankK.elementAt(i));
			storePanel.add(storeTimeK.elementAt(i));
			storePanel.add(storeDelTipK.elementAt(i));
			
			infoPanel.add(storePanel);
			infoPanel.setBackground(Color.white);
			storeBtnK.elementAt(i).setBackground(Color.white);
			storeBtnK.elementAt(i).add(storeImgK.elementAt(i), "East");
			storeBtnK.elementAt(i).add(infoPanel, "Center");
			storeListPanel_K.add(storeBtnK.elementAt(i));
			storeBtnK.elementAt(i).addActionListener(this);
			storeBtnK.elementAt(i).setOpaque(true);
		}

		//=================================================================================
		// ī�� �г�
		//=================================================================================
		
		BufferedReader brC = null;
		FileReader frC = null;
		String strC = null;
		String[] arrayC = null;
		
		try {
			frC = new FileReader("DeliveryInfo/C_Store_Info.txt");
			brC = new BufferedReader(frC);

			while((strC = brC.readLine()) != null){
				arrayC = strC.split("%");
				
				JLabel nameC = new JLabel(arrayC[0]);
				JLabel rankC = new JLabel("���� : " + arrayC[2] + "   " + arrayC[1]);
				JLabel timeC = new JLabel("��޽ð� : " + arrayC[4] + "��");
				JLabel delTipC = new JLabel("����� : " + arrayC[5] + "��");
				
				storeNameC.add(nameC);
				storeRankC.add(rankC);
				storeTimeC.add(timeC);
				storeDelTipC.add(delTipC);
				storeImgC.add(new JLabel(new ImageIcon(arrayC[6])));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{if(brC != null)
				brC.close();
			if (frC != null)
				frC.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//UI ����
		for(int i = 0; i < storeNameC.size(); i++){
			Font storeFont = new Font("���� ���",Font.BOLD, 20);
			Font storesmallFont = new Font("���� ���",Font.PLAIN, 10);
			
			storeNameC.elementAt(i).setFont(storeFont);
			storeRankC.elementAt(i).setFont(storesmallFont);
			storeTimeC.elementAt(i).setFont(storesmallFont);
			storeDelTipC.elementAt(i).setFont(storesmallFont);
			
			storeBtnC.add(new JButton());
			JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
			storeBtnC.elementAt(i).setLayout(new BorderLayout());
			storeBtnC.elementAt(i).setPreferredSize(new Dimension(380, 95));	
			btnUIRemove(storeBtnC.elementAt(i));

			JPanel storePanel = new JPanel();
			storePanel.setLayout(new BoxLayout(storePanel, BoxLayout.Y_AXIS));
			storePanel.setBackground(Color.WHITE);
			
			storePanel.add(storeNameC.elementAt(i));
			storePanel.add(storeRankC.elementAt(i));
			storePanel.add(storeTimeC.elementAt(i));
			storePanel.add(storeDelTipC.elementAt(i));
			
			infoPanel.add(storePanel);
			infoPanel.setBackground(Color.white);
			storeBtnC.elementAt(i).add(storeImgC.elementAt(i), "East");
			storeBtnC.elementAt(i).add(infoPanel, "Center");
			storeBtnC.elementAt(i).setBackground(Color.white);
			storeListPanel_C.add(storeBtnC.elementAt(i));
			storeBtnC.elementAt(i).setOpaque(true);
			storeBtnC.elementAt(i).addActionListener(this);
		}
		
		//=================================================================================
		// �н� �г�
		//=================================================================================
		
		BufferedReader brB = null;
		FileReader frB = null;
		String strB = null;
		String[] arrayB = null;
		
		try {
			frB = new FileReader("DeliveryInfo/B_Store_Info.txt");
			brB = new BufferedReader(frB);

			while((strB = brB.readLine()) != null){
				arrayB = strB.split("%");
				
				storeNameB.add(new JLabel(arrayB[0]));
				storeRankB.add(new JLabel("���� : " + arrayB[2] + "   " + arrayB[1]));
				storeTimeB.add(new JLabel("��޽ð� : " + arrayB[4] + "��"));
				storeDelTipB.add(new JLabel("����� : " + arrayB[5] + "��"));
				storeImgB.add(new JLabel(new ImageIcon(arrayB[6])));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{if(brB != null)
				brB.close();
			if (frB != null)
				frB.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//UI����
		for(int i = 0; i < storeNameB.size(); i++){
			Font storeFont = new Font("���� ���",Font.BOLD, 20);
			Font storesmallFont = new Font("���� ���",Font.PLAIN, 10);
			
			storeNameB.elementAt(i).setFont(storeFont);
			storeRankB.elementAt(i).setFont(storesmallFont);
			storeTimeB.elementAt(i).setFont(storesmallFont);
			storeDelTipB.elementAt(i).setFont(storesmallFont);
			
			storeBtnB.add(new JButton());
			JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
			storeBtnB.elementAt(i).setLayout(new BorderLayout());
			storeBtnB.elementAt(i).setPreferredSize(new Dimension(380, 95));	
			btnUIRemove(storeBtnB.elementAt(i));
			
			JPanel storePanel = new JPanel();
			storePanel.setLayout(new BoxLayout(storePanel, BoxLayout.Y_AXIS));
			storePanel.setBackground(Color.WHITE);
			
			storePanel.add(storeNameB.elementAt(i));
			storePanel.add(storeRankB.elementAt(i));
			storePanel.add(storeTimeB.elementAt(i));
			storePanel.add(storeDelTipB.elementAt(i));
			
			infoPanel.add(storePanel);
			infoPanel.setBackground(Color.white);
			storeBtnB.elementAt(i).add(storeImgB.elementAt(i), "East");
			storeBtnB.elementAt(i).add(infoPanel);
			storeBtnB.elementAt(i).setBackground(Color.white);
			storeListPanel_B.add(storeBtnB.elementAt(i));
			storeBtnB.elementAt(i).setOpaque(true);
			storeBtnB.elementAt(i).addActionListener(this);
		}
		
		
		selOrderTab.add("   �ѽ�   ",storeListPanel_K);
		selOrderTab.add("   ī��   ",storeListPanel_C);
		selOrderTab.add("   �н�   ",storeListPanel_B);

		//�� ���� ����
		selOrderTab.getComponentAt(0).setBackground(Color.WHITE);
		selOrderTab.getComponentAt(1).setBackground(Color.WHITE);
		selOrderTab.getComponentAt(2).setBackground(Color.WHITE);
		
		selOrderTab.setSelectedIndex(tabNum);
		backBtnPanel.add(backBtn);
		
		add(backBtnPanel,"North");
		add(selOrderTab,"Center");
		
		setVisible(true);

	}
	
	private Dimension Dimension(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	//��ư�� �⺻ �׵θ��� �⺻ ����� �����ϴ� �޼ҵ� 
	public void btnUIRemove(JButton btn){
		//btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == backBtn){
			this.dispose();
		}
		
		//�ѽ��� ���
		if(selOrderTab.getSelectedIndex() == 0){
			for(int i = 0; i < storeBtnK.size(); i++){
				if(e.getSource() == storeBtnK.elementAt(i))
					new DeliveryStore_KHJ(this, "�ѽ�", i);
			}
		}
		//ī���� ���
		else if(selOrderTab.getSelectedIndex() == 1){
			for(int i = 0; i < storeBtnC.size(); i++){
				if(e.getSource() == storeBtnC.elementAt(i)){
					new DeliveryStore_KHJ(this, "ī��", i);
				}
			}
		}
		//�н��� ���
		else if(selOrderTab.getSelectedIndex() == 2){
			for(int i = 0; i < storeBtnB.size(); i++){
				if(e.getSource() == storeBtnB.elementAt(i))
					new DeliveryStore_KHJ(this, "�н�", i);
			}
		}
	}
}
