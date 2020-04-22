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
	// ���� ������ �޽��� �ޱ�, �޽��� Ȯ�� ��ɸ� ������
	// ������Ʈ ������ ȭ���� ������ �Ʒ� �������� ������ ������ ������
	// ȭ�鿡 ���� ���ڸ� � ������ ǥ���� ���̶� ���� �迭���� ���̸� �ϴ� 10���� ����
	
	// ó�� ȭ���� ������ �г� ����
	// mainPanel_JWH : ���� ���� �г��̸� borderlayout���� ����
	// titlePanel_JWH : mainPanel�� ���� �г����� North�� ��ġ��. �ϴû� �������� �����Ǹ� "���� �޽���"���̺��� ��ġ�ϴ� �г�
	// listPanel_JWH : mainPanel�� ���� �г����� Center�� ��ġ��. �Ͼ�� �������� �����Ǹ� ��������� �������� ������ ���� ����Ʈ�� ������
	JPanel mainPanel_JWH, titlePanel_JWH, listPanel_JWH; 
	
	// titleLabel_JWH : titlePanel�� ��ġ�� "���� �޽���"��� �ؽ�Ʈ�� ������ ���̺� 
	JLabel titleLabel_JWH;
	
	// JPanel[] messagePanel_JWH : ����Ʈ�� ���� ��� 1���� ���� �г� �迭. ���� ������κ��� ���ڸ� 1�� ������ messagePanel�� 1�� ������. �� �гο� ������ �̹����� ��ư�� ��.  
	JPanel[] messagePanel_JWH = new JPanel[10];
	
	// ���� ���� ���ʿ� ������ �������� ǥ��
	// �������� ����� ���� ����� ���̺��� ����
	// ��� ���� png ������ ����ϱ� ���� ImageIcon ���
	JLabel[] iconLabel_JWH = new JLabel[10];
	String iconPath_JWH = "Img/usericon.png";
	ImageIcon iconImg_JWH = new ImageIcon(iconPath_JWH);
	
	// ���� ��� 1���� ��Ÿ���� ��ư 
	// ���� ��� �̸��� ���� ������ ��ư �ؽ�Ʈ�� ������
	// final�� �Ⱥ��̸� "����������ڳ���"������ �ٹٲ��� �ȵǼ� ���� 
	// �׼Ǹ����ʸ� �߰��Ͽ� ��ư�� ������ ȭ�� ��ȯ �̺�Ʈ �߻�
	final JButton[] listBtn_JWH = new JButton[10];
	
	// listBtn�� ���� ��� �̸���,���� ������ ǥ���ϱ� ���� �ؽ�Ʈ�� ��� ���� ����
	String[] saveFrom = new String[10];
	String[] saveContent = new String[10];
	
	// contentPanel_JWH : listBtn�� ������ �� ����� ���� ���ڸ� ���� ǥ���ϱ� ���� ȭ������ ���� �г�
	// content_titlePanel : contentPanel�� ���� �г����� North�� ��ġ��. �ϴû� �������� �����Ǹ� "�������� �̸�"���̺��� ��ġ�ϴ� �г�
	// content_messagePanel_JWH : contentPanel�� ���� �г����� Center�� ��ġ��. �Ͼ�� �������� �����Ǹ� "���� ����"�� ��ġ�ϴ� �г�
	JPanel[] contentPanel_JWH = new JPanel[10];
	JPanel[] content_titlePanel_JWH = new JPanel[10];
	JPanel[] content_messagePanel_JWH = new JPanel[10];	
	
	// backBtn_JWH : ȭ�� ��ȯ �� �ٽ� �ǵ��ư��� ����� �ϴ� ��ư. content_titlePanel�� ��ġ��
	JButton[] backBtn_JWH = new JButton[10];
	
	// content_titleLabel_JWH : "�������� �̸�"�̶�� �ؽ�Ʈ�� ������ ���̺�. content_titlePanel�� ��ġ��
	JLabel[] content_titleLabel_JWH = new JLabel[10];
	
	// 10�� ������ ���� ������ 11������ ����
	JButton[][] data_JWH = new JButton[10][11];
	
	// receiveMessage �޼���� �޽����� ���� Ƚ���� ī��Ʈ
	int Mcount_JWH = 0;
	
	//mainpanel�� �޾ƿ��� ���� ��ü�� �����մϴ�.
	HomeMainPanel_KHJ mainHome;
		
	public MessageClass_JWH(JPanel mainHomePanel) {
		
		//�������� �Ű������� ���� mainpanel�� �޾ƿɴϴ�.
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		/* ������ �⺻ ���� start */
		//this.setSize(378, 674);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* end */
		
		this.setLayout(new BorderLayout());
		
		/* �ʱ� ȭ�� ���� start */
		// mainPanel ���� titlePanel, listPanel ��ġ 
		// titlePanel���� "���� �޽���" ���̺� ��ġ
		mainPanel_JWH = new JPanel();
		mainPanel_JWH.setBackground(Color.WHITE);
		mainPanel_JWH.setLayout(new BorderLayout());
		
		titlePanel_JWH = new JPanel();
		titlePanel_JWH.setBackground(new Color(194, 226, 232));
		titlePanel_JWH.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		listPanel_JWH = new JPanel();
		listPanel_JWH.setBackground(Color.WHITE);
		listPanel_JWH.setLayout(new FlowLayout());
		
		titleLabel_JWH = new JLabel("���� �޽���");
		titleLabel_JWH.setFont(new Font("�������", Font.BOLD, 24));
		titleLabel_JWH.setForeground(Color.WHITE);
		titlePanel_JWH.add(titleLabel_JWH);
		
		mainPanel_JWH.add(titlePanel_JWH, "North");
		mainPanel_JWH.add(listPanel_JWH, "Center");
		/* end */
		
		/* listBtn�� ��ġ�ϸ� ���� ��� ������ ȭ���� ǥ���ϱ� ���� �г� ���� start*/
		// mainPanel�� ������ ������ contentPanel ���� content_titlePanel, content_messagePanel�� �����Ǿ� ��ġ��  
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
		
		// �ڷΰ��� ��ư�� �����Ͽ� content_titlePanel�� ���� ���ʿ� ��ġ��
		backBtn_JWH[i] = new JButton("<");
		backBtn_JWH[i].addActionListener(this);
		backBtn_JWH[i].setBorder(null);
		backBtn_JWH[i].setPreferredSize(new Dimension(29, 29));
		backBtn_JWH[i].setFont(new Font("�������", Font.BOLD, 24));
		backBtn_JWH[i].setBackground(new Color(194, 226, 232));
		backBtn_JWH[i].setForeground(Color.WHITE);
		backBtn_JWH[i].setBorderPainted(false);
		
		// ���� ����� �̸��� ǥ���ϱ� ���� ���̺�.�ڷΰ��� �ٷ� ���� ��ġ
		// �Ʒ��� receiveMessage �޼���� ���� ����� �ԷµǸ� setText�� �ٲ�� ��
		content_titleLabel_JWH[i] = new JLabel("");
		content_titleLabel_JWH[i].setFont(new Font("�������", Font.BOLD, 24));
		content_titleLabel_JWH[i].setForeground(Color.WHITE);
		
		// ������ �ڷΰ��� ��ư, ���̺��� content_titlePanel�� ��ġ��
		content_titlePanel_JWH[i].add(backBtn_JWH[i]);
		content_titlePanel_JWH[i].add(content_titleLabel_JWH[i]);
		
		// contentPanel�� content_titlePanel�� content_messagePanel�� ��ġ��
		contentPanel_JWH[i].add(content_titlePanel_JWH[i], "North");
		contentPanel_JWH[i].add(content_messagePanel_JWH[i], "Center");
		}
		/* end */
		
		add(mainPanel_JWH);
		//this.setVisible(true);
	}
	
	// �޽����� �ް� ǥ���ϴ� �޼���
	// from:�������, content:��������
	public void receiveMessage(String from, String content){
		
		/* ������ ������� üũ */
		// ���� ���� ������ ������� �޾Ҵٸ� �Ȱ��� content_messagePanel�� ���븸 �߰��ϰ� �����
		for(int i=0; i<10; i++){
			if(saveFrom[i]== from){
				content_messagePanel_JWH[i].add(Box.createVerticalStrut(5));
				data_JWH[i][i+1] = new JButton();
				data_JWH[i][i+1].setText(content);
				data_JWH[i][i+1].setFont(new Font("�������", Font.PLAIN, 18));
				data_JWH[i][i+1].setBackground(new Color(246, 246, 246));
				data_JWH[i][i+1].setBorderPainted(false);	
				listBtn_JWH[i].setText("<html>" + from + "<br/>" + "\r" + "<html>" + content + "<br/>");
				content_messagePanel_JWH[i].add(data_JWH[i][i+1]);
				return;
			}
		}
		/* end */
		
		// �Էµ� from�� content�� �迭�� �����ϰ� ����� �����ʹ� �Ʒ��� �ڵ忡�� �ʱ�ȭ���� ��ư �ؽ�Ʈ�� ����
		saveFrom[Mcount_JWH] = from;
		saveContent[Mcount_JWH] = content;
		
		/* �޽����� ó�� ���� ����� ��츦 ó�� start */
		// mainPanel-listPanel�� �ϳ��� �߰��� �г��� ������
		messagePanel_JWH[Mcount_JWH] = new JPanel();
		messagePanel_JWH[Mcount_JWH].setPreferredSize(new Dimension(350, 70));
		messagePanel_JWH[Mcount_JWH].setBackground(Color.WHITE);
		messagePanel_JWH[Mcount_JWH].setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// �߰��� �гο� ������ �����ܺ��� �߰�
		iconLabel_JWH[Mcount_JWH] = new JLabel(iconImg_JWH, JLabel.CENTER);
		iconLabel_JWH[Mcount_JWH].setHorizontalAlignment(JLabel.CENTER);
		
		// ������ �����ʿ� ��ġ�Ǵ� listBtn�� ����. ��ư�� text�� �����ϴµ� �ٹٲ��� �̿��Ͽ� from�� ���ʿ�, content�� �Ʒ��ʿ� ��ġ��
		listBtn_JWH[Mcount_JWH] = new JButton("");
		listBtn_JWH[Mcount_JWH].addActionListener(this);
		listBtn_JWH[Mcount_JWH].setHorizontalAlignment(SwingConstants.LEFT);
		listBtn_JWH[Mcount_JWH].setText("<html>" + from + "<br/>" + "\r" + "<html>" + content + "<br/>");
		listBtn_JWH[Mcount_JWH].setBackground(Color.WHITE);
		listBtn_JWH[Mcount_JWH].setFont(new Font("�������", Font.PLAIN, 15));
		listBtn_JWH[Mcount_JWH].setPreferredSize(new Dimension(250, 70));
		listBtn_JWH[Mcount_JWH].setBorderPainted(false); // ��ư �׵θ� ����
		
		// messagePanel�� �����ܰ� ��ư�� �߰��Ͽ� mainPanel-listPanel�� �߰���
		messagePanel_JWH[Mcount_JWH].add(iconLabel_JWH[Mcount_JWH]);
		messagePanel_JWH[Mcount_JWH].add(listBtn_JWH[Mcount_JWH]);
		listPanel_JWH.add(messagePanel_JWH[Mcount_JWH]);
		revalidate();
		repaint();

		// ��ȯ�� ȭ���� titleLabel�� �Է¹��� from���� ����
		content_titleLabel_JWH[Mcount_JWH].setText(from);
			
		content_messagePanel_JWH[Mcount_JWH].add(Box.createVerticalStrut(5));		
		data_JWH[Mcount_JWH][Mcount_JWH] = new JButton();
		data_JWH[Mcount_JWH][Mcount_JWH].setText(content);
		data_JWH[Mcount_JWH][Mcount_JWH].setFont(new Font("�������", Font.PLAIN, 18));
		data_JWH[Mcount_JWH][Mcount_JWH].setBackground(new Color(246, 246, 246));
		data_JWH[Mcount_JWH][Mcount_JWH].setBorderPainted(false);			
		
		content_messagePanel_JWH[Mcount_JWH].add(data_JWH[Mcount_JWH][Mcount_JWH]);
		
		Mcount_JWH++;
		/* end */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<contentPanel_JWH.length; i++){
			// ��ư�� �������� ��ư�� �ش��ϴ� ȭ������ ��ȯ��
			if(e.getSource() == listBtn_JWH[i]){
				mainPanel_JWH.setVisible(false);
				this.add(contentPanel_JWH[i]);
				contentPanel_JWH[i].setVisible(true);
				revalidate();
				repaint();
			// �ڷΰ��� ��ư�� ������ �ٽ� mainPanel�� ���ư�
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
		//���� �г��� �ݾ��ݴϴ�.
		this.setVisible(false);
		//main�� �г��� ��� �մϴ�.
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}
}
