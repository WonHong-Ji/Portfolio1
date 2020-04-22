import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Gallery_KDI extends JPanel implements ActionListener {
	int isContinue;
	JPanel jpButton, jpResult; 
	JPanel eventpl;// �г� �ʱ�ȭ
	JMenuBar jmb; // �޴��� �ʱ�ȭ
	JMenu jmEdit, jmHelp; // �޴� �ʱ�ȭ
	JMenuItem mCopy, mPaste, mHelp, mInfo; // �޴� ������ �ʱ�ȭ
	JLabel jlbResult1, jlbResult2, jlbResult3 ,jlbResult4 ,eventlb; // ���̺� �ʱ�ȭ
	JButton[] jbButton = null;// ��ư�迭 �ʱ�ȭ
	JButton[] CardlayoutBtn = null;
	String result = "";
	String result1 = "";
	String result2 = "";
	String number[] = { " ", " ", " " };
	String[] numStr = { "��", "CE", "C", "/", "7", "8", "9", "*", "4", "5", "6",
			"-", "1", "2", "3", "+", "0", "00", ".", "=","a" }; // ��ư�� �� ��
	JButton gallerySelBtn;

	
	// �г� ���� - �� �гο� ���缭 �۾��Ͻø� �˴ϴ�.
	JPanel samplePanel;
	JLabel sampleLabel;
	ImageIcon sampleImage;
	//ī�巹�̾ƿ� ��ư
	String PREVIOUS = "PREVIOUS";
	String NEXT = "NEXT";
	String FIRST = "FIRST";
	String LAST = "LAST";
	JButton btn1 = new JButton("ó��");
	JButton btn3 = new JButton("����");
	JButton btn2 = new JButton("����");
	JButton btn4 = new JButton("������");
	JPanel controlButtons = new JPanel();
	CardLayout cl = null;
	//�޴�
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("���� ó��");
	JMenuItem equalAction = new JMenuItem("����");
	JMenuItem negativeAction = new JMenuItem("����");
	JMenuItem mirrorAction = new JMenuItem("�¿� ��Ī");
	JMenuItem mirror2Action = new JMenuItem("���� ��Ī");
	
	String jbButtonAddress[] = { "cal_Img/moon.png", "cal_Img/paris.jpg",
			"cal_Img/city.jpg", "cal_Img/flower.jpg", "cal_Img/space.jpg",
			"cal_Img/eur.jpg", "cal_Img/moon2.jpg", "cal_Img/moon3.jpg",
			"cal_Img/flower2.jpg", "cal_Img/flower3.jpg",
			"cal_Img/sky.jpg", "cal_Img/space2.jpg", "cal_Img/flower4.jpg",
			"cal_Img/cloud2.jpg", "cal_Img/cloud3.jpg",
			"cal_Img/moon4.jpg", "cal_Img/table.jpg", "cal_Img/city2.jpg",
			"cal_Img/box.jpg", "cal_Img/road.jpg", "cal_Img/flower5.jpg" };
	
	
	int testInt = 0;
	
	HomeMainPanel_KHJ mainHome;

	public Gallery_KDI(JPanel mainHomePanel) {
		
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		this.setLayout(null);


		// ���� �ʵ� �ʱ�ȭ
		samplePanel = new JPanel();
		samplePanel.setLayout(new BorderLayout());
		sampleImage = new ImageIcon("homeImage/panelSample.png");
		sampleLabel = new JLabel(sampleImage);

		// ������ ������Ʈ���� �����̳ʿ� �߰�
		samplePanel.add(sampleLabel);
		
		eventpl = new JPanel();
		eventpl.setVisible(false);
		controlButtons.setVisible(false);
		cl = new CardLayout();
		eventpl.setLayout(cl);

		//���⿡ �г��߰�
		this.add(eventpl);
        this.add(controlButtons);
		this.add(samplePanel);

			    
		// this�� �߰��� �г��� ��ġ, ������ ����
		this.samplePanel.setBounds(0, 0, 378, 674);
		this.eventpl.setBounds(0, 0, 378, 630);
		this.controlButtons.setBounds(0, 630, 378, 44);

		/** �޴��� ���� */
		menuBar.add(menu);
				
		/** ���̺� ���� */
		jpResult = new JPanel(new GridLayout(1, 1));
		
		Color color = new Color(140, 140, 140);
		
		jpResult.setBackground(color);// jpResult��� �гο� ��� �������
																						// ��������
		jlbResult2 = new JLabel("Gallery", JLabel.LEFT); // jlbResult2��� �⺻�� 0�� ���̺�,
													// ��������
		jlbResult2.setFont(new Font("����", Font.ITALIC, 20)); // jlbResult2 ���̺�
		
		jpResult.add(jlbResult2); // jpResult �гο� jlbResult2 ���̺� �߰�
		/** ���̺� �� */

		/** ��ư ���� */
		jpButton = new JPanel(new GridLayout(0, 3 ,6,7));
		Color color2 = new Color(234, 234, 234);
		jpButton.setBackground(color2); // jpButton �г� ����� ���
		jbButton = new JButton[numStr.length]; // jbButton ��ư �迭 �ʱ�ȭ
		controlButtons.setBackground(color);//ī�巹�̾ƿ� �г� ����	
				
		jbButton[0] = new JButton(new ImageIcon("cal_Img/moon.png"));
		jbButton[1] = new JButton(new ImageIcon("cal_Img/paris.jpg"));
		jbButton[2] = new JButton(new ImageIcon("cal_Img/city.jpg"));
		jbButton[3] = new JButton(new ImageIcon("cal_Img/flower.jpg"));
		jbButton[4] = new JButton(new ImageIcon("cal_Img/space.jpg"));
		jbButton[5] = new JButton(new ImageIcon("cal_Img/eur.jpg"));
		jbButton[6] = new JButton(new ImageIcon("cal_Img/moon2.jpg"));
		jbButton[7] = new JButton(new ImageIcon("cal_Img/moon3.jpg"));
		jbButton[8] = new JButton(new ImageIcon("cal_Img/flower2.jpg"));
		jbButton[9] = new JButton(new ImageIcon("cal_Img/flower3.jpg"));
		jbButton[10] = new JButton(new ImageIcon("cal_Img/sky.jpg"));
		
		jbButton[11] = new JButton(new ImageIcon("cal_Img/space2.jpg"));
		jbButton[12] = new JButton(new ImageIcon("cal_Img/flower4.jpg"));
		jbButton[13] = new JButton(new ImageIcon("cal_Img/cloud2.jpg"));
		jbButton[14] = new JButton(new ImageIcon("cal_Img/cloud3.jpg"));
		jbButton[15] = new JButton(new ImageIcon("cal_Img/moon4.jpg"));
		jbButton[16] = new JButton(new ImageIcon("cal_Img/table.jpg"));
		jbButton[17] = new JButton(new ImageIcon("cal_Img/city2.jpg"));
		jbButton[18] = new JButton(new ImageIcon("cal_Img/box.jpg"));
		jbButton[19] = new JButton(new ImageIcon("cal_Img/road.jpg"));
		jbButton[20] = new JButton(new ImageIcon("cal_Img/flower5.jpg"));
		// jbButton�� ǥ���� ���� ����
		CardlayoutBtn = new JButton[numStr.length];
		
		CardlayoutBtn[0] = new JButton(new ImageIcon("cal_Img/moon.png"));
		CardlayoutBtn[1] = new JButton(new ImageIcon("cal_Img/paris.jpg"));
		CardlayoutBtn[2] = new JButton(new ImageIcon("cal_Img/city.jpg"));
		CardlayoutBtn[3] = new JButton(new ImageIcon("cal_Img/flower.jpg"));
		CardlayoutBtn[4] = new JButton(new ImageIcon("cal_Img/space.jpg"));
		CardlayoutBtn[5] = new JButton(new ImageIcon("cal_Img/eur.jpg"));
		CardlayoutBtn[6] = new JButton(new ImageIcon("cal_Img/moon2.jpg"));
		CardlayoutBtn[7] = new JButton(new ImageIcon("cal_Img/moon3.jpg"));
		CardlayoutBtn[8] = new JButton(new ImageIcon("cal_Img/flower2.jpg"));
		CardlayoutBtn[9] = new JButton(new ImageIcon("cal_Img/flower3.jpg"));
		CardlayoutBtn[10] = new JButton(new ImageIcon("cal_Img/sky.jpg"));
		
		CardlayoutBtn[11] = new JButton(new ImageIcon("cal_Img/space2.jpg"));
		CardlayoutBtn[12] = new JButton(new ImageIcon("cal_Img/flower4.jpg"));
		CardlayoutBtn[13] = new JButton(new ImageIcon("cal_Img/cloud2.jpg"));
		CardlayoutBtn[14] = new JButton(new ImageIcon("cal_Img/cloud3.jpg"));
		CardlayoutBtn[15] = new JButton(new ImageIcon("cal_Img/moon4.jpg"));
		CardlayoutBtn[16] = new JButton(new ImageIcon("cal_Img/table.jpg"));
		CardlayoutBtn[17] = new JButton(new ImageIcon("cal_Img/city2.jpg"));
		CardlayoutBtn[18] = new JButton(new ImageIcon("cal_Img/box.jpg"));
		CardlayoutBtn[19] = new JButton(new ImageIcon("cal_Img/road.jpg"));
		CardlayoutBtn[20] = new JButton(new ImageIcon("cal_Img/flower5.jpg"));
				
		for (int i = 0; i < numStr.length; i++) {
			jpButton.add(jbButton[i]);
			jbButton[i].addActionListener(this);
		}
		for (int j = 0; j < CardlayoutBtn.length; j++) {
			eventpl.add(CardlayoutBtn[j],j+"");
			CardlayoutBtn[j].addActionListener(this);
			CardlayoutBtn[j].setBackground(Color.BLACK);
		}
		samplePanel.add("North", jpResult);
		samplePanel.add("Center", jpButton);

		
		//ī�巹�̾ƿ� ��ư ����
		btn1.setActionCommand(FIRST);
		btn1.addActionListener(this);
		controlButtons.add(btn1); 
				
		btn3.setActionCommand(PREVIOUS);
		btn3.addActionListener(this);
		controlButtons.add(btn3);
		
		btn2.setActionCommand(NEXT);
		btn2.addActionListener(this);
		controlButtons.add(btn2);
		
		btn4.setActionCommand(LAST);
		btn4.addActionListener(this);
		controlButtons.add(btn4);
		
	    isContinue = 1 ;
	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals(NEXT)) {
		     cl.next(eventpl);
		}else if (cmd.equals(PREVIOUS)) {
			cl.previous(eventpl);
		}else if (cmd.equals(FIRST)) {
			cl.first(eventpl);
		}else if (cmd.equals(LAST)) {
			cl.last(eventpl);
		}
		
		for(int i = 0;  i< CardlayoutBtn.length; i++){
			if (e.getSource() == CardlayoutBtn[i]) {
				eventpl.setVisible(false);
				controlButtons.setVisible(false);
				samplePanel.add("North", jpResult);
				samplePanel.add("Center", jpButton);
				samplePanel.revalidate();
				samplePanel.repaint();
				isContinue++;
				samplePanel.setVisible(true);
			}
		}
		for (int i = 0; i < CardlayoutBtn.length; i++) {
			if (e.getSource() == jbButton[i]) {
					samplePanel.removeAll();
					controlButtons.setVisible(true);
					btn2.setVisible(true);
				    cl.show(eventpl,i+"");
					eventpl.setVisible(true);
				}
			}
		}
		public void End(){
		this.setVisible(false);
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}

}