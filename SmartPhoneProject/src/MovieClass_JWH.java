import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;


public class MovieClass_JWH extends JPanel implements ActionListener {
	
	/* Tickets��� �̸��� ������ �־�� Ƽ�� �ؽ�Ʈ ������ ������ */
	
	/* ������Ʈ ����� ��� ���̴����� ���� ���� */
	/* ����� ���� ó�� ���̴� ���� ȭ�鿡�� ����� ������Ʈ ���� */ 
	Container container_JWH;
	CardLayout card_JWH; // ȭ�� ��ȯ�� cardLayout�� ����� .
	
	JPanel mainPanel_JWH, // ����ȭ���� �����ϴ� �г�, BorderLayout���� ������.
		   logoPanel_JWH, // mainPanel�� North�� ��ġ. "���� ������?" ���̺��� ��ġ��. image�� background �̹��� ����.
		   contentPanel_JWH, // mainPanel�� Center�� ��ġ. ��ȭ �̹����� ������ ��ġ��.
		   buttonPanel_JWH, // mainPanel�� South�� ��ġ. ��ȭ����, ����Ȯ�� ��ư�� ��ġ��.
		   content1_JWH, // �ܿ�ձ��� ���� ������ ���� ������Ʈ���� �� �г�.
		   content2_JWH, // õ�� �гο� ���� ������ ���� ������Ʈ���� �� �г�.
		   content3_JWH, //	����V��� �гο� ���� ������ ���� ������Ʈ���� �� �г�.
		   moviePnl1_JWH, // �ܿ�ձ� ������.
		   moviePnl2_JWH, // õ�� ������.
		   moviePnl3_JWH; // ����V��� ������.
	JButton reserveBtn_JWH, // ��ȭ���� ��ư.
			checkBtn_JWH, // ����Ȯ�� ��ư.
			leftBtn_JWH, // ��ȭ�� ���� �������� �ٲٴ� ȭ��ǥ ��ư .
			rightBtn_JWH; // ��ȭ�� ������ �������� �ٲٴ� ȭ��ǥ ��ư.
	JLabel logoLbl_JWH; // "���� ������?"�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
	String select_JWH = "winter"; // ���õ� ��ȭ�� �ʱⰪ�� �ܿ�ձ����� ������.
	/* ����ȭ�� ������Ʈ ���� end */
	
	/* �ð����� ȭ�鿡�� ����� ������Ʈ ���� */
	JPanel timePanel_JWH, // �ð����� ȭ���� �����ϴ� �г�, BorderLayout���� ������.
		   titlePanel2_JWH, // timePanel�� North�� ��ġ. �ڷΰ���(<) ��ư�� "�ð�����"���̺��� ��ġ��.
		   timeSelectPanel_JWH; // timePanel�� Center�� ��ġ. �ð� ��ư���� ��ġ��.
	JButton backBtn2_JWH, // �ڷΰ���(<) ��ư. �ð�����->����ȭ������ ��ȯ�Ǵ� ����� ����.
			winter1610, // �ܿ�ձ� 16:10 ��ư. timeM ������ "16:10"�� �����ϰ� �¼����� ȭ������ ��ȯ�Ǵ� ����� ����.
			winter1840, // �ܿ�ձ� 18:40 ��ư. timeM ������ "18:40"�� �����ϰ� �¼����� ȭ������ ��ȯ�Ǵ� ����� ����.
			chun1250, // õ�� 12:50 ��ư. timeM ������ "12:50"�� �����ϰ� �¼����� ȭ������ ��ȯ�Ǵ� ����� ����.
			chun2030, // õ�� 20:30 ��ư. timeM ������ "20:30"�� �����ϰ� �¼����� ȭ������ ��ȯ�Ǵ� ����� ����.
			ff1515, // ����V��� 15:15 ��ư. timeM ������ "15:15"�� �����ϰ� �¼����� ȭ������ ��ȯ�Ǵ� ����� ����.
			ff2100; // ����V��� 21:00 ��ư. timeM ������ "15:15"�� �����ϰ� �¼����� ȭ������ ��ȯ�Ǵ� ����� ����.
	JLabel titleLbl2_JWH, // "�ð�����"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   g1_winter, // "1�� �ܿ�ձ�"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   g2_chun, // "2�� õ��"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   g3_ff; // "3�� ����V���"�� �ؽ�Ʈ�� �����Ǵ� ���̺�. 
	String timeM_JWH = ""; // �ð���ư�� �ؽ�Ʈ�� getText�� �����ϴ� ����.
	/* �ð����� ȭ�� ������Ʈ ���� end */
	
	/* �¼����� ȭ�鿡�� ����� ������Ʈ ���� */
	JPanel seatPanel_JWH, // �¼����� ȭ���� �����ϴ� �г�, BorderLayout���� ������.
		   titlePanel3_JWH, // seatPanel�� North�� ��ġ. �ڷΰ���(<)��ư�� "�¼�����"���̺��� ��ġ��.
		   seatSelectPanel_JWH, // seatPanel�� Center�� ��ġ. line�гΰ� line�� �ش��ϴ� �¼� ��ư���� ��ġ��.
		   informPanel_JWH, // seatPanel�� South�� ��ġ. ������ ��ȭ�� �������� ���� ������Ʈ��� �������� ��ư�� ��ġ��.
		   lineScreen_JWH, // "Screen"���̺��� ��ġ�Ǵ� �г�. 
		   line0_JWH, // lineScreen�гΰ� lineA�г� ���̿� ������ ����� ���� �� �г�. 
		   lineA_JWH, // A~��ư���� ��ġ�Ǵ� �г� 
		   lineB_JWH, // B~��ư���� ��ġ�Ǵ� �г�
		   lineC_JWH, // C~��ư���� ��ġ�Ǵ� �г�
		   lineD_JWH, // D~��ư���� ��ġ�Ǵ� �г�
		   lineE_JWH, // E~��ư���� ��ġ�Ǵ� �г�
		   lineF_JWH, // F~��ư���� ��ġ�Ǵ� �г�
		   lineG_JWH, // G~��ư���� ��ġ�Ǵ� �г�
		   moviePnl4_JWH, // �ܿ�ձ� ������, informPanel�� ��ġ��.
		   moviePnl5_JWH, // õ�� ������, informPanel�� ��ġ��.
		   moviePnl6_JWH; // ����V��� ������, informPanel�� ��ġ��.
	JButton backBtn3_JWH, // �ڷΰ���(<) ��ư. �¼�����->�ð��������� ��ȯ�Ǵ� ����� ����.
			goPay_JWH; // ��������(>) ��ư. �¼������� �Ϸ�Ǹ� setEnable(true)�� �ٲ�� Ȱ��ȭ��. �¼�����->������������ ��ȯ�Ǵ� ����� ����.
	JLabel titleLbl3_JWH, // "�¼�����"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   movieNameLbl_JWH, // "��ȭ����(xx�̿밡)"�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   cinemaLbl_JWH, // "���� : ������"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   dayLbl_JWH, // "������ : xxxx.xx.xx"���� �ؽ�Ʈ�� �����Ǵ� ���̺�. 
		   startTimeLbl_JWH, // "�����ð� : xx:xx"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   sangyoungLbl_JWH, // "�󿵰� : x"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   seatLbl_JWH; // "�¼� : xx"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
	JButton[][] seatsBtn_JWH = new JButton[8][12]; // �¼���ư���� ����Ǵ� �迭. [A~G][1~12].
	String selectSeat_JWH = ""; // ������ �¼���ư(seatsBtn)�� �ؽ�Ʈ�� getText�� �����ϴ� ����.
	String st_JWH = ""; // xxxx.xx.xx�������� ������ ��¥�� �����ϴ� ����.
	/* �¼����� ȭ�� ������Ʈ ���� end */
	
	/* �������� ȭ�鿡�� ����� ������Ʈ ���� */
	JPanel payPanel_JWH, // �������� ȭ���� �����ϴ� �г�, BorderLayout���� ������.
		   titlePanel4_JWH, // payPanel�� North�� ��ġ. �ڷΰ���(<)��ư�� "��������"���̺��� ��ġ��.
		   payContentPanel_JWH, // payPanel�� Center�� ��ġ. ��ȭ�� �ݾ�, �̸�, �ֹι�ȣ, �޴��� ��ȣ, ������ȣ �Է� ���� ������Ʈ���� ��ġ��.
		   simpleInfoPanel_JWH, // "��ȭ�̸�(�¼�)", "�Ϲ� 1��", "�����ݾ� 8,000��"���̺���� ��ġ�Ǵ� ������ ���� �г�.
		   msPanel_JWH; // ������ȣ���� ��ư, Ȯ�� ��ư�� ���� �������� �����ִ� �г�. setVisible(false)�� �⺻���̸� ��ư�� ������ �� true�� �����.
	JButton backBtn4_JWH, // �ڷΰ���(<)��ư. ��������->�¼��������� ��ȯ�Ǵ� ����� ����.
			numTransBtn_JWH, // ������ȣ���� ��ư. ��ư�� ������ �̸� ����, �ֹε�Ϲ�ȣ ����, �޴��� ��ȣ ���̸� �Ǵ��ϰ� �׿� ���� ������ msPanel���� ������.
							 // ��� ������ �����Ǹ� �ܼ�â�� ������ȣ�� ����� 
			confirmBtn_JWH, // Ȯ�� ��ư. ��ư�� ������ ��µ� ������ȣ�� �Էµ� ������ȣ�� ������ ����. ������ �����ϱ� ��ư Ȱ��ȭ.  
			progressBtn_JWH, // �����ϱ� ��ư. ��������->�����Ϸ�� ��ȯ�Ǵ� ����� ����.
			msBtn_JWH; // msPanel�� Ȯ�� ��ư. ��ư�� ������ msPanel�� setVisible(false)��.
	JLabel titleLbl4_JWH, // "��������"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   simpleLbl1_JWH, // "��ȭ����(�¼�)"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   simpleLbl2_JWH, // "�Ϲ� 1��"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   simpleLbl3_JWH, // "�����ݾ� 8,000��"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   warningLbl_JWH, // "�� ������ �׽�Ʈ �������� ���� ������ ���ѵ˴ϴ�."�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   payName_JWH, // "�̸�"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   payResiNum_JWH, // "�ֹε�Ϲ�ȣ"�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   payPhoneNum_JWH, // "�޴��� ��ȣ"�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   payInputNum_JWH, // "������ȣ�Է�"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   msLbl1_JWH; // msPanel�� ���� ������ �ؽ�Ʈ�� ǥ���ϱ� ���� ���̺�.
	JTextField nameTF_JWH, // �̸��� �Է��ϴ� �ؽ�Ʈ�ʵ�.
			   resiNumTF1_JWH, // �ֹε�Ϲ�ȣ ���ڸ��� �Է��ϴ� �ؽ�Ʈ�ʵ�.
			   resiNumTF2_JWH, // �ֹε�Ϲ�ȣ ���ڸ� �ϳ��� �Է��ϴ� �ؽ�Ʈ�ʵ�.
			   phoneNumTF_JWH, // �޴�����ȣ�� �Է��ϴ� �ؽ�Ʈ�ʵ�.
			   payInputTF_JWH; // ������ȣ�� �Է��ϴ� �ؽ�Ʈ �ʵ�.
	int num1_JWH = 0; // ������ȣ ù��° ����.
	int num2_JWH = 0; // ������ȣ �ι�° ����.
	int num3_JWH = 0; // ������ȣ ����° ����.
	int num4_JWH = 0; // ������ȣ �׹�° ����.
	int num5_JWH = 0; // ������ȣ �ټ���° ����.
	int num6_JWH = 0; // ������ȣ ������° ����.
	int certNum1_JWH = 0; // �ٷ� �Ʒ� certNum2 ���� ������ �ٽ� ���ڷ� ��ȯ�Ͽ� �����ϴ� ����. (������ ���ڳ��� ���� ���ϴϱ� �ȵǼ� ���ڳ��� �񱳷� �ٲ�)
	int certNumInput1_JWH = 0; // �ٷ� �Ʒ� certNumInput2 ���� ������ �ٽ� ���ڷ� ��ȯ�Ͽ� �����ϴ� ����.
	String certNum2_JWH = ""; // num1~6�� �����ڸ� ������ȣ�� ���ڷ� �����ϴ� ����. 
	String certNumInput2_JWH = ""; // payInputTF�� �Է��� ������ȣ�� ���ڷ� �����ϴ� ����.
	/* �������� ȭ�� ������Ʈ ���� end */
	
	/* �����Ϸ� ȭ�鿡�� ����� ������Ʈ */
	JPanel sucPanel_JWH, // �����Ϸ�ȭ���� �����ϴ� �г�. BorderLayout���� ������.
		   titlePanel5_JWH, // sucPanel�� North�� ��ġ. "�����Ϸ�"���̺��� ��ġ��.
		   sucContentPanel_JWH; // sucPanel�� Center�� ��ġ. �����Ϸ� ���� ���̺�� Ȯ�� ��ư�� ��ġ��.
	JButton okBtn_JWH; // Ȯ�ι�ư. ��ư�� ������ �����Ϸ�->����ȭ������ ��ȯ�Ǵ� ����� ����.
	JLabel titleLbl5_JWH, // "�����Ϸ�"�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   simpleLbl4_JWH, // "������ �Ϸ�Ǿ����ϴ�."�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
		   simpleLbl5_JWH; // "����ǥ�� [����Ȯ��]���� Ȯ���� �� �ֽ��ϴ�."�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
	/* �����Ϸ� ȭ�� ������Ʈ ���� end */
	
	/* ����Ȯ�� ȭ��� ���ŵ� �¼���ư�� disable ��ų �� ����� ������Ʈ ���� */
	int ticketCount_JWH = 0; // Ƽ�� �߱� ������ ��Ÿ���� ����. 0���� ���۵ǰ� �����Ϸᰡ �Ǹ� ����Ȯ�� ȭ�鿡 Ƽ�� �߱� �� +1��.
	boolean[] addTicket_JWH = new boolean[100]; // ����Ȯ��ȭ�鿡 n��° Ƽ���� �߱޵Ǹ� true�� �˷��ֱ� ���� ���� �迭. 
	JPanel checkPanel_JWH, // ����Ȯ��ȭ���� �����ϴ� �г�. BorderLayout���� ������.
		   titlePanel6_JWH, // checkPanel�� North�� ��ġ. "����Ȯ��"���̺��� ��ġ��.
		   checkContentPanel_JWH; // checkPanel�� Center�� ��ġ. Ƽ�ϵ��� ������.
	JButton backBtn6_JWH; // �ڷΰ���(<)��ư. ��ư�� ������ ����Ȯ��->����ȭ������ ��ȯ�Ǵ� ����� ����.
	JLabel titleLbl6_JWH; // "����Ȯ��"�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
	JPanel[] tickets_JWH = new JPanel[100]; // n��° Ƽ�� ������ҵ��� ��� ��� �г�
	JLabel[] tNameLbl_JWH = new JLabel[100]; // n��° Ƽ���� "��ȭ�̸�(�¼�)"���� �ؽ�Ʈ�� �����Ǵ� ���̺�. 
	JLabel[] tCinemaLbl_JWH = new JLabel[100]; // n��° Ƽ���� "������ x��"���� �ؽ�Ʈ�� �����Ǵ� ���̺�.
	JLabel[] tDayLbl_JWH = new JLabel[100]; // n��° Ƽ���� "xxxx.xx.xx"(��¥)�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
	JLabel[] tTimeLbl_JWH = new JLabel[100]; // n��° Ƽ���� "xx:xx"(�ð�)�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
	JLabel[] tMentLbl_JWH = new JLabel[100]; // n��° Ƽ���� "�� ������ �ִٸ� ���� ������ ����ǥ�Դϴ�."�� �ؽ�Ʈ�� �����Ǵ� ���̺�.
	String[] ticketsSaveMName = new String[100]; // n��° Ƽ���� ��ȭ�� �����ϴ� ���� 
//	String[] ticketsMName_JWH = new String[100];
	String[] ticketsSaveSeat_JWH = new String[100]; // n��° Ƽ���� �¼� �̸��� �����ϴ� ����
	String[] ticketsMDay_JWH = new String[100]; // n��° Ƽ���� ��¥�� �����ϴ� ����
	String[] ticketsMTime_Hour_JWH = new String[100]; // n��° Ƽ���� �ð����� �ø� �����ϴ� ����
	String[] ticketsMTime_Minute_JWH = new String[100]; // n��° Ƽ���� �ð����� �и� �����ϴ� ����
	String[] ticketsMTime_JWH = new String[100]; // n��° Ƽ���� �ð��� ��� �����ϴ� ����
	String[] ticketsMment_JWH = new String[100]; // "�� ������ �ִٸ� ���� ������ ����ǥ�Դϴ�."
	JButton[] checkBtns = new JButton[100]; // ������ �¼� ��ư�� �����ϴ� ��ư �迭.
	/* ����Ȯ�� ������Ʈ ���� end */
	
	boolean addCheck_JWH;
	
	HomeMainPanel_KHJ mainHome;
	
	public MovieClass_JWH(JPanel mainHomePanel) {
		
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		
		this.setSize(378, 674);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//container_JWH = getContentPane();
		card_JWH = new CardLayout(0,0);
		this.setLayout(card_JWH);
		
		////////////////////////////////////////////////////////
		//////////////////// ����ȭ�� ���� start ////////////////////
		
		/* ���� ȭ���� ���̽� �г� ���� */
		mainPanel_JWH = new JPanel();
		mainPanel_JWH.setBackground(Color.WHITE);
		mainPanel_JWH.setLayout(new BorderLayout());
		/* end */
		
		/* �ΰ� �� North �г� ���� */
		logoPanel_JWH = new JPanel(){
			ImageIcon logoBackground_JWH = new ImageIcon("Img/titleBackground.jpg");
			Image logoImg_JWH = logoBackground_JWH.getImage();
			Image change1_JWH = logoImg_JWH.getScaledInstance(378, 200, Image.SCALE_SMOOTH);
			ImageIcon title = new ImageIcon(change1_JWH);
			
			public void paintComponent(Graphics g){
				g.drawImage(title.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		logoPanel_JWH.setLayout(null);
		logoPanel_JWH.setPreferredSize(new Dimension(378, 200));		
		/* end */
		
		/* ��ȭ ����� ������ Center �г� ���� */
		contentPanel_JWH = new JPanel();
		contentPanel_JWH.setLayout(null);
		contentPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* ��ȭ����, ����Ȯ�� ��ư�� ��ġ�� South �г� ���� */ 
		buttonPanel_JWH = new JPanel();
		buttonPanel_JWH.setLayout(new GridLayout());
		buttonPanel_JWH.setBackground(new Color(2, 23, 71));
		buttonPanel_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
				
		/* �ΰ� ���̺� ���� */	
		logoLbl_JWH = new JLabel("���� ������?");
		logoLbl_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 55));
		logoLbl_JWH.setBounds(98, 85, 200, 50);
		logoLbl_JWH.setForeground(Color.WHITE);
		logoPanel_JWH.add(logoLbl_JWH);
		/* end */
		
		/* ù��° ������ �г�(content1) ���� */
		content1_JWH = new JPanel(); // content1 : �ܿ�ձ�
		content1_JWH.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
		content1_JWH.setPreferredSize(new Dimension(320, 350));
		content1_JWH.setBackground(Color.WHITE);
		content1_JWH.setBounds(20, 10, 320, 350);
		
		moviePnl1_JWH = new JPanel(){
			ImageIcon movieBackground1_JWH = new ImageIcon("Img/winter.jpg");
			Image movieImg1_JWH = movieBackground1_JWH.getImage();
			Image change2_JWH = movieImg1_JWH.getScaledInstance(320, 170, Image.SCALE_SMOOTH);
			ImageIcon mc1_JWH = new ImageIcon(change2_JWH);
			
			public void paintComponent(Graphics g){
				g.drawImage(mc1_JWH.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		moviePnl1_JWH.setPreferredSize(new Dimension(320, 170));
		
		JLabel titleText1_JWH = new JLabel("�ܿ�ձ�2");
		titleText1_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 40));
		titleText1_JWH.setForeground(new Color(2, 23, 71));
		JLabel subText1_JWH = new JLabel("<html>�� ������ ���� ��� ������?"
										+ "<br>���� �θ��� �� ��Ҹ��� ������?"
										+ "<br>"
										+ "<br>��� �� ���ϰ� �ǹ��� ��Ҹ��� ���縦 �θ���, "
										+ "<br>��ȭ�ο� �Ʒ��� �ձ��� �����Ѵ�.</html>");
		subText1_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 15));
		subText1_JWH.setForeground(new Color(33, 33, 33));
		
		content1_JWH.add(moviePnl1_JWH);
		content1_JWH.add(titleText1_JWH);
		content1_JWH.add(subText1_JWH);
		/* end */
		
		/* �ι�° ������ �г�(content2) ����  */
		content2_JWH = new JPanel(); // content2 : õ��
		content2_JWH.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
		content2_JWH.setPreferredSize(new Dimension(320, 350));
		content2_JWH.setBackground(Color.WHITE);
		content2_JWH.setBounds(20, 10, 320, 350);
		
		moviePnl2_JWH = new JPanel(){
			ImageIcon movieBackground2_JWH = new ImageIcon("Img/chun.jpg");
			Image movieImg2_JWH = movieBackground2_JWH.getImage();
			Image change2_JWH = movieImg2_JWH.getScaledInstance(320, 170, Image.SCALE_SMOOTH);
			ImageIcon mc2_JWH = new ImageIcon(change2_JWH);
			
			public void paintComponent(Graphics g){
				g.drawImage(mc2_JWH.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		moviePnl2_JWH.setPreferredSize(new Dimension(320, 170));
		
		JLabel titleText2_JWH = new JLabel("õ��");
		titleText2_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 40));
		titleText2_JWH.setForeground(new Color(2, 23, 71));
		JLabel subText2_JWH = new JLabel("<html>����� ���� ������ �� ����"
										+ "<br>����� �¾ ��3ǰ ��ȣ���� �� õ�� ������ �念��"
										+ "<br>"
										+ "<br>������ �ð��� �ϴ��� ������� �ߴ� ������ �念��!"
										+ "<br>�׵��� ������ �̾߱Ⱑ ��������!</html>");
		subText2_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 15));
		subText2_JWH.setForeground(new Color(33, 33, 33));
		
		content2_JWH.add(moviePnl2_JWH);
		content2_JWH.add(titleText2_JWH);
		content2_JWH.add(subText2_JWH);
		contentPanel_JWH.add(content2_JWH);
		content2_JWH.setVisible(false);
		/* end */
		
		/* ����° ������ �г�(content3) ����  */
		content3_JWH = new JPanel(); // content3 : ����V���
		content3_JWH.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
		content3_JWH.setPreferredSize(new Dimension(320, 350));
		content3_JWH.setBackground(Color.WHITE);
		content3_JWH.setBounds(20, 10, 320, 350);
		
		moviePnl3_JWH = new JPanel(){
			ImageIcon movieBackground3_JWH = new ImageIcon("Img/fp.jpg");
			Image movieImg3_JWH = movieBackground3_JWH.getImage();
			Image change3_JWH = movieImg3_JWH.getScaledInstance(320, 170, Image.SCALE_SMOOTH);
			ImageIcon mc3_JWH = new ImageIcon(change3_JWH);
			
			public void paintComponent(Graphics g){
				g.drawImage(mc3_JWH.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		moviePnl3_JWH.setPreferredSize(new Dimension(320, 170));
		
		JLabel titleText3_JWH = new JLabel("����V��� ");
		titleText3_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 40));
		titleText3_JWH.setForeground(new Color(2, 23, 71));
		JLabel subText3_JWH = new JLabel("<html>������ �濵���� �� �ڴ����"
										+ "<br>���� ���Ͻ����� ��������ó�� �����"
										+ "<br>�ڽŵ��� �Ը��� ���� ���̽��� ��ġ�⸦ ����������"
										+ "<br>�� ����� � �������� ������ �ʰ�"
										+ "<br>�Ұ����� �پ�ѱ� ���� ���ָ� �����ϴµ���</html>");
		subText3_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 15));
		subText3_JWH.setForeground(new Color(33, 33, 33));
		
		content3_JWH.add(moviePnl3_JWH);
		content3_JWH.add(titleText3_JWH);
		content3_JWH.add(subText3_JWH);
		contentPanel_JWH.add(content3_JWH);
		content3_JWH.setVisible(false);
		/* end */
		
		/* ȭ��ǥ  ��ư ���� */	
		leftBtn_JWH = new JButton("<");
		leftBtn_JWH.addActionListener(this);
		leftBtn_JWH.setContentAreaFilled(false);
		leftBtn_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 30));
		leftBtn_JWH.setForeground(new Color(2, 23, 71));
		leftBtn_JWH.setBorderPainted(false);
		leftBtn_JWH.setBounds(-15, 90, 50, 50);
	
		rightBtn_JWH = new JButton(">");
		rightBtn_JWH.addActionListener(this);
		rightBtn_JWH.setContentAreaFilled(false);
		rightBtn_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 30));
		rightBtn_JWH.setForeground(new Color(2, 23, 71));
		rightBtn_JWH.setBorderPainted(false);
		rightBtn_JWH.setBounds(325, 90, 50, 50);
		
		contentPanel_JWH.add(leftBtn_JWH);
		contentPanel_JWH.add(rightBtn_JWH);	
		/* end */
		
		/* ��ȭ����, ����Ȯ�� ��ư ���� */
		reserveBtn_JWH = new JButton("��ȭ ����");
		reserveBtn_JWH.setBackground(new Color(2, 23, 71));
		reserveBtn_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		reserveBtn_JWH.setForeground(Color.WHITE);
		reserveBtn_JWH.setBorderPainted(false);
		reserveBtn_JWH.addActionListener(this);
				
		checkBtn_JWH = new JButton("���� Ȯ��");
		checkBtn_JWH.addActionListener(this);
		checkBtn_JWH.setBackground(new Color(2, 23, 71));
		checkBtn_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		checkBtn_JWH.setForeground(Color.WHITE);
		checkBtn_JWH.setBorderPainted(false);
				
		buttonPanel_JWH.add(reserveBtn_JWH);
		buttonPanel_JWH.add(checkBtn_JWH);
		/* end */

		contentPanel_JWH.add(content1_JWH);
		mainPanel_JWH.add(logoPanel_JWH, "North");
		mainPanel_JWH.add(contentPanel_JWH, "Center");
		mainPanel_JWH.add(buttonPanel_JWH, "South");
		
		//////////////////// ����ȭ�� end ////////////////////
		//////////////////////////////////////////////////
		
		
		
		
		
		//////////////////////////////////////////////////
		///////////////// �ð����� ȭ�� ���� Start ///////////////
		
		/* �ð����� ȭ�� ���̽� �г� ���� */
		timePanel_JWH = new JPanel();
		timePanel_JWH.setLayout(new BorderLayout());
		timePanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "�ð�����" ���̺��� �� North �г� ���� */
		titlePanel2_JWH = new JPanel();
		titlePanel2_JWH.setLayout(null);
		titlePanel2_JWH.setBackground(new Color(2, 23, 71));
		titlePanel2_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* ��ȭ �� �ð� ��ư�� �� Center �г� ���� */
		timeSelectPanel_JWH = new JPanel();
		timeSelectPanel_JWH.setLayout(null);
		timeSelectPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* �ڷΰ��� ��ư ���� */
		backBtn2_JWH = new JButton("<");
		backBtn2_JWH.addActionListener(this);
		backBtn2_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 40));
		backBtn2_JWH.setForeground(Color.WHITE);
		backBtn2_JWH.setBounds(3, 5, 50, 50);
		backBtn2_JWH.setContentAreaFilled(false);
		backBtn2_JWH.setBorderPainted(false);
		titlePanel2_JWH.add(backBtn2_JWH);
		/* end */
		
		/* "�ð�����" ���̺� ���� */
		titleLbl2_JWH = new JLabel("�ð�����");
		titleLbl2_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		titleLbl2_JWH.setForeground(Color.WHITE);
		titleLbl2_JWH.setBounds(140, 6, 100, 50);
		titlePanel2_JWH.add(titleLbl2_JWH);
		/* end */
		
		/* "1�� �ܿ�ձ�" ���̺� ���� */
		g1_winter = new JLabel("1�� �ܿ�ձ�");
		g1_winter.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		g1_winter.setForeground(new Color(33, 33, 33));
		g1_winter.setBounds(20, 50, 200, 50);
		timeSelectPanel_JWH.add(g1_winter);
		/* end */
		
		/* �ܿ�ձ� 16:10 ��ư ���� */
		winter1610 = new JButton("16:10");
		winter1610.addActionListener(this);
		winter1610.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 18));
		winter1610.setBackground(new Color(2, 23, 71));
		winter1610.setForeground(Color.WHITE);
		winter1610.setBorderPainted(false);
		winter1610.setBorder(null);
		winter1610.setBounds(20, 100, 60, 30);
		timeSelectPanel_JWH.add(winter1610);
		/* end */
		
		/* �ܿ�ձ� 18:40 ��ư ���� */
		winter1840 = new JButton("18:40");
		winter1840.addActionListener(this);
		winter1840.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 18));
		winter1840.setBackground(new Color(2, 23, 71));
		winter1840.setForeground(Color.WHITE);
		winter1840.setBorderPainted(false);
		winter1840.setBorder(null);
		winter1840.setBounds(90, 100, 60, 30);
		timeSelectPanel_JWH.add(winter1840);
		/* end */
		
		/* "2�� õ��" ���̺� ���� */
		g2_chun = new JLabel("2�� õ��");
		g2_chun.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		g2_chun.setForeground(new Color(33, 33, 33));
		g2_chun.setBounds(20, 180, 200, 50);
		timeSelectPanel_JWH.add(g2_chun);
		/* end */
		
		/* õ�� 12:50 ��ư ���� */
		chun1250 = new JButton("12:50");
		chun1250.addActionListener(this);
		chun1250.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 18));
		chun1250.setBackground(new Color(2, 23, 71));
		chun1250.setForeground(Color.WHITE);
		chun1250.setBorderPainted(false);
		chun1250.setBorder(null);
		chun1250.setBounds(20, 230, 60, 30);
		timeSelectPanel_JWH.add(chun1250);
		/* end */
		
		/* õ�� 20:30 ��ư ���� */
		chun2030 = new JButton("20:30");
		chun2030.addActionListener(this);
		chun2030.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 18));
		chun2030.setBackground(new Color(2, 23, 71));
		chun2030.setForeground(Color.WHITE);
		chun2030.setBorderPainted(false);
		chun2030.setBorder(null);
		chun2030.setBounds(90, 230, 60, 30);
		timeSelectPanel_JWH.add(chun2030);
		/* end */
		
		/* "3�� ����V���" ���̺� ���� */
		g3_ff = new JLabel("3�� ����V���");
		g3_ff.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		g3_ff.setForeground(new Color(33, 33, 33));
		g3_ff.setBounds(20, 310, 200, 50);
		timeSelectPanel_JWH.add(g3_ff);
		/* end */
		
		/* ����V��� 15:15 ��ư ���� */
		ff1515 = new JButton("15:15");
		ff1515.addActionListener(this);
		ff1515.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 18));
		ff1515.setBackground(new Color(2, 23, 71));
		ff1515.setForeground(Color.WHITE);
		ff1515.setBorderPainted(false);
		ff1515.setBorder(null);
		ff1515.setBounds(20, 360, 60, 30);
		timeSelectPanel_JWH.add(ff1515);
		/* end */
		
		/* ����V��� 21:00 ��ư ���� */
		ff2100 = new JButton("21:00");
		ff2100.addActionListener(this);
		ff2100.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 18));
		ff2100.setBackground(new Color(2, 23, 71));
		ff2100.setForeground(Color.WHITE);
		ff2100.setBorderPainted(false);
		ff2100.setBorder(null);
		ff2100.setBounds(90, 360, 60, 30);
		timeSelectPanel_JWH.add(ff2100);
		/* end */

		timePanel_JWH.add(titlePanel2_JWH, "North");
		timePanel_JWH.add(timeSelectPanel_JWH, "Center");		
		///////////////// �ð����� ȭ�� end  ///////////////////
		//////////////////////////////////////////////////
		
		
		
		
		
		//////////////////////////////////////////////////
		///////////////// �¼����� ȭ�� ����  ////////////////////
		
		/* �¼����� ȭ�� ���̽� �г� ���� */
		seatPanel_JWH = new JPanel();
		seatPanel_JWH.setBackground(Color.WHITE);
		seatPanel_JWH.setLayout(new BorderLayout());
		/* end */
		
		/* "�¼�����" ���̺��� �� North �г� ���� */
		titlePanel3_JWH = new JPanel();
		titlePanel3_JWH.setLayout(null);
		titlePanel3_JWH.setBackground(new Color(2, 23, 71));
		titlePanel3_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* �¼� ��ư���� �� Center �г� ���� */
		seatSelectPanel_JWH = new JPanel();
		seatSelectPanel_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		seatSelectPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* ������ ������ ǥ�õ� South �г� ���� */
		informPanel_JWH = new JPanel();
		informPanel_JWH.setLayout(null);
		informPanel_JWH.setBackground(new Color(2, 23, 71));
		informPanel_JWH.setPreferredSize(new Dimension(378, 150));
		/* end */
		
		/* �ڷΰ��� ��ư ���� */
		backBtn3_JWH = new JButton("<");
		backBtn3_JWH.addActionListener(this);
		backBtn3_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 40));
		backBtn3_JWH.setForeground(Color.WHITE);
		backBtn3_JWH.setBounds(3, 5, 50, 50);
		backBtn3_JWH.setContentAreaFilled(false);
		backBtn3_JWH.setBorderPainted(false);
		titlePanel3_JWH.add(backBtn3_JWH);
		/* end */
		
		/* "�¼�����" ���̺� ���� */
		titleLbl3_JWH = new JLabel("�¼�����");
		titleLbl3_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		titleLbl3_JWH.setForeground(Color.WHITE);
		titleLbl3_JWH.setBounds(140, 6, 100, 50);
		titlePanel3_JWH.add(titleLbl3_JWH);
		/* end */
		
		/* "Screen" ���̺��� �� �г� ���� */ 
		lineScreen_JWH = new JPanel();
		lineScreen_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineScreen_JWH.setPreferredSize(new Dimension(320, 40));
		lineScreen_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineScreen_JWH);
		
		/* ��ĭ���� ���� �г� */
		line0_JWH = new JPanel();
		line0_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		line0_JWH.setPreferredSize(new Dimension(320, 20));
		line0_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(line0_JWH);
		/* end */
		
		/* �¼� ��ư�� ���� ���� �г� ���� �� ���������� ������� ��ġ */
		lineA_JWH = new JPanel();
		lineA_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineA_JWH.setPreferredSize(new Dimension(320, 40));
		lineA_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineA_JWH);
		
		lineB_JWH = new JPanel();
		lineB_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineB_JWH.setPreferredSize(new Dimension(320, 40));
		lineB_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineB_JWH);
		
		lineC_JWH = new JPanel();
		lineC_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineC_JWH.setPreferredSize(new Dimension(320, 40));
		lineC_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineC_JWH);
		
		lineD_JWH = new JPanel();
		lineD_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineD_JWH.setPreferredSize(new Dimension(320, 40));
		lineD_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineD_JWH);
		
		lineE_JWH = new JPanel();
		lineE_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineE_JWH.setPreferredSize(new Dimension(320, 40));
		lineE_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineE_JWH);
		
		lineF_JWH = new JPanel();
		lineF_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineF_JWH.setPreferredSize(new Dimension(320, 40));
		lineF_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineF_JWH);
		
		lineG_JWH = new JPanel();
		lineG_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		lineG_JWH.setPreferredSize(new Dimension(320, 40));
		lineG_JWH.setBackground(Color.WHITE);
		seatSelectPanel_JWH.add(lineG_JWH);
		/* end */
		
		/* �¼� ��ư���� �����ϰ� �� ���� �гο� ���� */
		JLabel screen_JWH = new JLabel("Screen");
		screen_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 30));
		screen_JWH.setForeground(new Color(2, 23, 71));
		lineScreen_JWH.add(screen_JWH);
		
		for(int i=0; i<=7; i++){
			seatsBtn_JWH[0][i] = new JButton("A"+(i+1));
			seatsBtn_JWH[0][i].addActionListener(this);
			seatsBtn_JWH[0][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[0][i].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 28));
			seatsBtn_JWH[0][i].setForeground(Color.WHITE);
			seatsBtn_JWH[0][i].setBorder(null);
			seatsBtn_JWH[0][i].setBorderPainted(false);			
			lineA_JWH.add(seatsBtn_JWH[0][i]);
			
			seatsBtn_JWH[1][i] = new JButton("B"+(i+1));
			seatsBtn_JWH[1][i].addActionListener(this);
			seatsBtn_JWH[1][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[1][i].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 28));
			seatsBtn_JWH[1][i].setForeground(Color.WHITE);
			seatsBtn_JWH[1][i].setBorder(null);
			seatsBtn_JWH[1][i].setBorderPainted(false);
			lineB_JWH.add(seatsBtn_JWH[1][i]);
		}
		
		for(int i=0; i<12; i++){
			seatsBtn_JWH[2][i] = new JButton("C"+(i+1));
			seatsBtn_JWH[2][i].addActionListener(this);
			seatsBtn_JWH[2][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[2][i].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 28));
			seatsBtn_JWH[2][i].setForeground(Color.WHITE);
			seatsBtn_JWH[2][i].setBorder(null);
			seatsBtn_JWH[2][i].setBorderPainted(false);
			lineC_JWH.add(seatsBtn_JWH[2][i]);
			
			seatsBtn_JWH[3][i] = new JButton("D"+(i+1));
			seatsBtn_JWH[3][i].addActionListener(this);
			seatsBtn_JWH[3][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[3][i].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 28));
			seatsBtn_JWH[3][i].setForeground(Color.WHITE);
			seatsBtn_JWH[3][i].setBorder(null);
			seatsBtn_JWH[3][i].setBorderPainted(false);
			lineD_JWH.add(seatsBtn_JWH[3][i]);
			
			seatsBtn_JWH[4][i] = new JButton("E"+(i+1));
			seatsBtn_JWH[4][i].addActionListener(this);
			seatsBtn_JWH[4][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[4][i].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 28));
			seatsBtn_JWH[4][i].setForeground(Color.WHITE);
			seatsBtn_JWH[4][i].setBorder(null);
			seatsBtn_JWH[4][i].setBorderPainted(false);
			lineE_JWH.add(seatsBtn_JWH[4][i]);
			
			seatsBtn_JWH[5][i] = new JButton("F"+(i+1));
			seatsBtn_JWH[5][i].addActionListener(this);
			seatsBtn_JWH[5][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[5][i].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 28));
			seatsBtn_JWH[5][i].setForeground(Color.WHITE);
			seatsBtn_JWH[5][i].setBorder(null);
			seatsBtn_JWH[5][i].setBorderPainted(false);
			lineF_JWH.add(seatsBtn_JWH[5][i]);
			
			seatsBtn_JWH[6][i] = new JButton("G"+(i+1));
			seatsBtn_JWH[6][i].addActionListener(this);
			seatsBtn_JWH[6][i].setBackground(new Color(40, 40, 40));
			seatsBtn_JWH[6][i].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 28));
			seatsBtn_JWH[6][i].setForeground(Color.WHITE);
			seatsBtn_JWH[6][i].setBorder(null);
			seatsBtn_JWH[6][i].setBorderPainted(false);
			lineG_JWH.add(seatsBtn_JWH[6][i]);		
		}
		/* end */
		
		/* ������ ��ȭ�� ���� setText�� ��ȭ�̸����� �ٲ� ���̺� ���� */
		movieNameLbl_JWH = new JLabel("");
		movieNameLbl_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 30));
		movieNameLbl_JWH.setForeground(Color.ORANGE);
		movieNameLbl_JWH.setBounds(108, 5, 300, 50);
		informPanel_JWH.add(movieNameLbl_JWH);
		/* end */
		
		/* "���� : ������" ���̺� ���� */
		cinemaLbl_JWH = new JLabel("���� : ������");
		cinemaLbl_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 19));
		cinemaLbl_JWH.setForeground(Color.WHITE);
		cinemaLbl_JWH.setBounds(110, 35, 100, 50);
		informPanel_JWH.add(cinemaLbl_JWH);
		/* end */
		
		/* st_JWH�� ���� ��¥�� ���� �� �ٽ� +1���� ��Ų ��¥�� ���� */
		/* �� ��¥�� �����������Ͽ� informPanel�� setBounds�� ���� */
		Calendar c_JWH = Calendar.getInstance();;
		SimpleDateFormat dateFormat_JWH = new SimpleDateFormat("yyyy.MM.dd");	
		st_JWH = dateFormat_JWH.format(c_JWH.getTime());
		try {
			c_JWH.setTime(dateFormat_JWH.parse(st_JWH));
			c_JWH.add(Calendar.DATE, 1);
			st_JWH = dateFormat_JWH.format(c_JWH.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		dayLbl_JWH = new JLabel("������ : " + st_JWH);
		dayLbl_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 19));
		dayLbl_JWH.setForeground(Color.WHITE);
		dayLbl_JWH.setBounds(220, 35, 150, 50);
		informPanel_JWH.add(dayLbl_JWH);
		/* end */
		
		/* ������ ��ȭ�� ���� �ð��� �ٲ� "���� �ð�" ���̺� ���� */
		startTimeLbl_JWH = new JLabel("");
		startTimeLbl_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 19));
		startTimeLbl_JWH.setForeground(Color.WHITE);
		startTimeLbl_JWH.setBounds(110, 65, 170, 50);
		informPanel_JWH.add(startTimeLbl_JWH);
		/* end */
		
		/* �󿵰� ���̺� ����. winter : 1��, chun : 2��, ff : 3�� */
		sangyoungLbl_JWH = new JLabel("�󿵰� : ");
		sangyoungLbl_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 19));
		sangyoungLbl_JWH.setForeground(Color.WHITE);
		sangyoungLbl_JWH.setBounds(220, 65, 170, 50);
		informPanel_JWH.add(sangyoungLbl_JWH);
		/* end */
		
		/* ������ �¼��� ������ "�¼� : " ���̺� ���� */
		seatLbl_JWH = new JLabel("�¼� : ");
		seatLbl_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 19));
		seatLbl_JWH.setForeground(Color.WHITE);
		seatLbl_JWH.setBounds(110, 95, 170, 50);
		informPanel_JWH.add(seatLbl_JWH);
		/* end */
		
		/* �������� ��ư ���� */
		goPay_JWH = new JButton("�������� >");
		goPay_JWH.addActionListener(this);
		goPay_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 26));
		goPay_JWH.setForeground(Color.WHITE);
		goPay_JWH.setBorder(null);
		goPay_JWH.setBorderPainted(false);
		goPay_JWH.setContentAreaFilled(false);
		goPay_JWH.setBounds(230, 105, 150, 50);
		goPay_JWH.setEnabled(false);
		informPanel_JWH.add(goPay_JWH);
		/* end */
		
		seatPanel_JWH.add(titlePanel3_JWH, "North");
		seatPanel_JWH.add(seatSelectPanel_JWH, "Center");
		seatPanel_JWH.add(informPanel_JWH, "South");
		
		////////////////// �¼����� ȭ�� end ///////////////////
		//////////////////////////////////////////////////
		
		
		
		
		//////////////////////////////////////////////////
		///////////////// �������� ȭ�� ����  ////////////////////
		
		/* �������� ȭ�� ���̽� �г� ���� */
		payPanel_JWH = new JPanel();
		payPanel_JWH.setLayout(new BorderLayout());
		payPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "��������" ���̺��� �� North �г� ���� */
		titlePanel4_JWH = new JPanel();
		titlePanel4_JWH.setLayout(null);
		titlePanel4_JWH.setBackground(new Color(2, 23, 71));
		titlePanel4_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* ���� ���� ������Ʈ���� �� Center �г� ���� */ 
		payContentPanel_JWH = new JPanel();
		payContentPanel_JWH.setLayout(null);
		payContentPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* �ڷΰ��� ��ư ���� */
		backBtn4_JWH = new JButton("<");
		backBtn4_JWH.addActionListener(this);
		backBtn4_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 40));
		backBtn4_JWH.setForeground(Color.WHITE);
		backBtn4_JWH.setBounds(3, 5, 50, 50);
		backBtn4_JWH.setContentAreaFilled(false);
		backBtn4_JWH.setBorderPainted(false);
		titlePanel4_JWH.add(backBtn4_JWH);
		/* end */
		
		/* "��������" ���̺� ���� */
		titleLbl4_JWH = new JLabel("��������");
		titleLbl4_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		titleLbl4_JWH.setForeground(Color.WHITE);
		titleLbl4_JWH.setBounds(140, 6, 100, 50);
		titlePanel4_JWH.add(titleLbl4_JWH);
		/* end */
		
		/* ��ȭ�̸�, �ݾ��� �����ϰ� ǥ�õ� �г� ���� */
		simpleInfoPanel_JWH = new JPanel();
		simpleInfoPanel_JWH.setLayout(null);
		simpleInfoPanel_JWH.setBackground(new Color(2, 23, 71));
		simpleInfoPanel_JWH.setBounds(22, 80, 320, 160);
		payContentPanel_JWH.add(simpleInfoPanel_JWH);
		/* end */
		
		/* ���� �˸� ���̺� ���� */
		warningLbl_JWH = new JLabel("�� ������ �׽�Ʈ �������� ���� ������ ���ѵ˴ϴ�.");
		warningLbl_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 13));
		warningLbl_JWH.setForeground(Color.RED);
		warningLbl_JWH.setBounds(23, 240, 320, 30);
		payContentPanel_JWH.add(warningLbl_JWH);
		/* end */
		
		/* "��ȭ����" ���̺� ���� */
		simpleLbl1_JWH = new JLabel("��ȭ����");
		simpleLbl1_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 48));
		simpleLbl1_JWH.setForeground(Color.WHITE);
		simpleLbl1_JWH.setBounds(7, -10, 300, 100);
		simpleInfoPanel_JWH.add(simpleLbl1_JWH);
		/* end */
		
		/* "�Ϲ� 1��" ���̺� ���� */
		simpleLbl2_JWH = new JLabel("�Ϲ� 1��");
		simpleLbl2_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		simpleLbl2_JWH.setForeground(Color.WHITE);
		simpleLbl2_JWH.setBounds(230, 40, 250, 100);
		simpleInfoPanel_JWH.add(simpleLbl2_JWH);
		/* end */
		
		/* "�����ݾ� 8,000��" ���̺� ���� */
		simpleLbl3_JWH = new JLabel("�����ݾ� 8,000��");
		simpleLbl3_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		simpleLbl3_JWH.setForeground(Color.WHITE);
		simpleLbl3_JWH.setBounds(142, 82, 250, 100);
		simpleInfoPanel_JWH.add(simpleLbl3_JWH);
		/* end */
		
		/* "�̸�" ���̺� ���� */
		payName_JWH = new JLabel("�̸�");
		payName_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 25));
		payName_JWH.setForeground(new Color(25, 25, 25));
		payName_JWH.setBounds(82, 300, 50, 30);
		payContentPanel_JWH.add(payName_JWH);
		/* end */
		
		/* �̸� �ؽ�Ʈ�ʵ� ���� */
		nameTF_JWH = new JTextField(10);
		nameTF_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 16));
		nameTF_JWH.setBounds(125, 300, 80, 30);
		payContentPanel_JWH.add(nameTF_JWH);
		/* end */
		
		/* �ֹε�Ϲ�ȣ ���̺� ���� */
		payResiNum_JWH = new JLabel("�ֹε�Ϲ�ȣ");
		payResiNum_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 25));
		payResiNum_JWH.setForeground(new Color(25, 25, 25));
		payResiNum_JWH.setBounds(35, 340, 150, 30);
		payContentPanel_JWH.add(payResiNum_JWH);
		/* end */
		
		/* �ֹε�Ϲ�ȣ ���ڸ� �ؽ�Ʈ�ʵ� ���� */
		resiNumTF1_JWH = new JTextField();
		resiNumTF1_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 16));
		resiNumTF1_JWH.setBounds(125, 340, 80, 30);
		payContentPanel_JWH.add(resiNumTF1_JWH);
		/* end */
		
		/* "-" ���̺� ����(xxxxxx - x) */
		JLabel minusLbl_JWH = new JLabel("-");
		minusLbl_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 25));
		minusLbl_JWH.setForeground(new Color(25, 25, 25));
		minusLbl_JWH.setBounds(210, 342, 20, 20);
		payContentPanel_JWH.add(minusLbl_JWH);
		/* end */
		
		/* �ֹε�Ϲ�ȣ ���ڸ� �ؽ�Ʈ�ʵ� ���� */
		resiNumTF2_JWH = new JTextField();
		resiNumTF2_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 16));
		resiNumTF2_JWH.setBounds(227, 340, 20, 30);
		payContentPanel_JWH.add(resiNumTF2_JWH);
		/* end */
		
		/* "******" ���̺� ���� */
		JLabel resiNumStar_JWH = new JLabel("******");
		resiNumStar_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 25));
		resiNumStar_JWH.setForeground(new Color(25, 25, 25));
		resiNumStar_JWH.setBounds(250, 340, 150, 20);
		payContentPanel_JWH.add(resiNumStar_JWH);
		/* end */
		
		/* "�޴��� ��ȣ" ���̺� */
		payPhoneNum_JWH = new JLabel("�޴��� ��ȣ");
		payPhoneNum_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 25));
		payPhoneNum_JWH.setForeground(new Color(25, 25, 25));
		payPhoneNum_JWH.setBounds(33, 380, 150, 30);
		payContentPanel_JWH.add(payPhoneNum_JWH);
		/* end */
		
		/* �޴��� ��ȣ �ؽ�Ʈ�ʵ� ���� */
		phoneNumTF_JWH = new JTextField();
		phoneNumTF_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 16));
		phoneNumTF_JWH.setBounds(125, 380, 110, 30);
		payContentPanel_JWH.add(phoneNumTF_JWH);
		/* end */
		
		/* ������ȣ���� ��ư ���� */
		numTransBtn_JWH = new JButton("������ȣ����");
		numTransBtn_JWH.addActionListener(this);
		numTransBtn_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 22));
		numTransBtn_JWH.setForeground(new Color(2, 23, 71));
		numTransBtn_JWH.setBorder(null);
		numTransBtn_JWH.setBorderPainted(false);
		numTransBtn_JWH.setContentAreaFilled(false);
		numTransBtn_JWH.setBounds(200, 380, 150, 30);
		payContentPanel_JWH.add(numTransBtn_JWH);
		/* end */
		
		/* "������ȣ�Է�" ���̺� ���� */
		payInputNum_JWH = new JLabel("������ȣ�Է�");
		payInputNum_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 25));
		payInputNum_JWH.setForeground(new Color(25, 25, 25));
		payInputNum_JWH.setBounds(31, 420, 150, 30);
		payContentPanel_JWH.add(payInputNum_JWH);
		/* end */
		
		/* ������ȣ�Է� �ؽ�Ʈ�ʵ� ���� */
		payInputTF_JWH = new JTextField();
		payInputTF_JWH.setFont(new Font("�����ٸ����", Font.PLAIN, 16));
		payInputTF_JWH.setBounds(125, 420, 110, 30);
		payContentPanel_JWH.add(payInputTF_JWH);
		/* end */
		
		/* Ȯ�� ��ư ���� */
		confirmBtn_JWH = new JButton("Ȯ��");
		confirmBtn_JWH.addActionListener(this);
		confirmBtn_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 22));
		confirmBtn_JWH.setForeground(new Color(2, 23, 71));
		confirmBtn_JWH.setBorder(null);
		confirmBtn_JWH.setBorderPainted(false);
		confirmBtn_JWH.setContentAreaFilled(false);
		confirmBtn_JWH.setBounds(180, 420, 150, 30);
		payContentPanel_JWH.add(confirmBtn_JWH);
		/* end */
		
		/* �����ϱ� ��ư ���� */
		progressBtn_JWH = new JButton("�����ϱ�");
		progressBtn_JWH.addActionListener(this);
		progressBtn_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 27));
		progressBtn_JWH.setBackground(new Color(2, 23, 71));
		progressBtn_JWH.setForeground(Color.WHITE);
		progressBtn_JWH.setBorder(null);
		progressBtn_JWH.setBorderPainted(false);
		progressBtn_JWH.setBounds(41, 480, 280, 33);
		progressBtn_JWH.setEnabled(false);
		payContentPanel_JWH.add(progressBtn_JWH);
		/* end */
		
		/* ������ȣ���� ��ư�� ������ �� ������ ������ �޽��� �г� ���� */
		msPanel_JWH = new JPanel();
		msPanel_JWH.setLayout(new FlowLayout(FlowLayout.CENTER));
		msPanel_JWH.setBackground(Color.WHITE);
		TitledBorder msPanelBorder_JWH = new TitledBorder(new LineBorder(new Color(40, 40, 40)));
		msPanel_JWH.setBorder(msPanelBorder_JWH);
		msPanel_JWH.setBounds(55, 270, 250, 70);
		payPanel_JWH.add(msPanel_JWH);
		msPanel_JWH.setVisible(false);
		
		/* �޽��� ������ ������ ���̺� ���� */
		msLbl1_JWH = new JLabel();
		msLbl1_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 20));
		msLbl1_JWH.setForeground(new Color(25, 25, 25));
		msPanel_JWH.add(msLbl1_JWH);
		/* end */
		
		/* msPanel�� ���� �� �ʿ��� Ȯ�� ��ư ���� */
		msBtn_JWH = new JButton("Ȯ��");
		msBtn_JWH.addActionListener(this);
		msBtn_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 20));
		msBtn_JWH.setBackground(new Color(2, 23, 71));
		msBtn_JWH.setForeground(Color.WHITE);
		msBtn_JWH.setPreferredSize(new Dimension(100, 30));
		msBtn_JWH.setBorder(null);
		msBtn_JWH.setBorderPainted(false);
		msPanel_JWH.add(msBtn_JWH);
		/* end */
					
		payPanel_JWH.add(titlePanel4_JWH, "North");
		payPanel_JWH.add(payContentPanel_JWH, "Center");
		
		///////////////// �������� ȭ�� end  ///////////////////
		//////////////////////////////////////////////////
		
		
		
		
		
		//////////////////////////////////////////////////
		//////////////////// �����Ϸ� ȭ�� /////////////////////
		
		/* �����Ϸ� ȭ�� ���̽� �г� ���� */
		sucPanel_JWH = new JPanel();
		sucPanel_JWH.setLayout(new BorderLayout());
		sucPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "�����Ϸ�" ���̺��� �� North �г� ���� */
		titlePanel5_JWH = new JPanel();
		titlePanel5_JWH.setLayout(null);
		titlePanel5_JWH.setBackground(new Color(2, 23, 71));
		titlePanel5_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* "�����Ϸ�" ���̺� ���� */
		titleLbl5_JWH = new JLabel("�����Ϸ�");
		titleLbl5_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		titleLbl5_JWH.setForeground(Color.WHITE);
		titleLbl5_JWH.setBounds(140, 6, 100, 50);
		titlePanel5_JWH.add(titleLbl5_JWH);
		/* end */
		
		/* �����ϷḦ �˷��� ������Ʈ���� �� Center �г� ���� */
		sucContentPanel_JWH = new JPanel();
		sucContentPanel_JWH.setLayout(null);
		sucContentPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "������ �Ϸ�Ǿ����ϴ�." ���̺� ���� */
		simpleLbl4_JWH = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
		simpleLbl4_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		simpleLbl4_JWH.setForeground(new Color(2, 23, 71));
		simpleLbl4_JWH.setBounds(79, 160, 250, 50);
		sucContentPanel_JWH.add(simpleLbl4_JWH);
		/* end */
		
		/* "����ǥ�� [����Ȯ��]���� Ȯ���� �� �ֽ��ϴ�." ���̺� ���� */
		simpleLbl5_JWH = new JLabel("����ǥ�� [����Ȯ��]���� Ȯ���� �� �ֽ��ϴ�.");
		simpleLbl5_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 22));
		simpleLbl5_JWH.setForeground(new Color(25, 25, 25));
		simpleLbl5_JWH.setBounds(38, 200, 300, 50);
		sucContentPanel_JWH.add(simpleLbl5_JWH);
		/* end */
		
		/* Ȯ�� ��ư ���� */
		okBtn_JWH = new JButton("Ȯ��");
		okBtn_JWH.addActionListener(this);
		okBtn_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 27));
		okBtn_JWH.setBackground(new Color(2, 23, 71));
		okBtn_JWH.setForeground(Color.WHITE);
		okBtn_JWH.setBorder(null);
		okBtn_JWH.setBorderPainted(false);
		okBtn_JWH.setBounds(41, 260, 280, 33);
		sucContentPanel_JWH.add(okBtn_JWH);
		/* end */		
		
		sucPanel_JWH.add(titlePanel5_JWH, "North");
		sucPanel_JWH.add(sucContentPanel_JWH, "Center");
		
		/////////////////// �����Ϸ� end /////////////////////
		//////////////////////////////////////////////////
		
		
		
		
		//////////////////////////////////////////////////
		////////////////////// ����Ȯ�� //////////////////////
		
		/* ����Ȯ�� ȭ�� ���̽� �г� ���� */
		checkPanel_JWH = new JPanel();
		checkPanel_JWH.setLayout(new BorderLayout());
		checkPanel_JWH.setBackground(Color.WHITE);
		/* end */
		
		/* "����Ȯ��" ���̺��� �� North �г� ���� */
		titlePanel6_JWH = new JPanel();
		titlePanel6_JWH.setLayout(null);
		titlePanel6_JWH.setBackground(new Color(2, 23, 71));
		titlePanel6_JWH.setPreferredSize(new Dimension(378, 60));
		/* end */
		
		/* Ƽ�ϵ��� ������ Center �г� ���� */
		checkContentPanel_JWH = new JPanel();
		checkContentPanel_JWH.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		checkContentPanel_JWH.setBackground(Color.WHITE);
		checkContentPanel_JWH.setPreferredSize(new Dimension(350, 1200));
		JScrollPane checkSP_JWH = new JScrollPane();
		checkSP_JWH.setViewportView(checkContentPanel_JWH);
		/* end */
		
		/* �ڷΰ��� ��ư ���� */
		backBtn6_JWH = new JButton("<");
		backBtn6_JWH.addActionListener(this);
		backBtn6_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 40));
		backBtn6_JWH.setForeground(Color.WHITE);
		backBtn6_JWH.setBounds(3, 5, 50, 50);
		backBtn6_JWH.setContentAreaFilled(false);
		backBtn6_JWH.setBorderPainted(false);
		titlePanel6_JWH.add(backBtn6_JWH);
		/* end */
		
		/* "����Ȯ��" ���̺� ���� */
		titleLbl6_JWH = new JLabel("����Ȯ��");
		titleLbl6_JWH.setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
		titleLbl6_JWH.setForeground(Color.WHITE);
		titleLbl6_JWH.setBounds(140, 6, 100, 50);
		titlePanel6_JWH.add(titleLbl6_JWH);
		/* end */
		
		checkPanel_JWH.add(titlePanel6_JWH, "North");
		checkPanel_JWH.add(checkSP_JWH, "Center");
	
		/* ī�� ���̾ƿ��� ���̰� ����ȭ���� ���� ���� ������ */
		this.add("main", mainPanel_JWH);
		this.add("time", timePanel_JWH);
		this.add("seat", seatPanel_JWH);
		this.add("pay", payPanel_JWH);
		this.add("suc", sucPanel_JWH);
		this.add("check", checkPanel_JWH);
		card_JWH.show(this, "main");
		/* end */
		
		//this.setVisible(true);
		//this.setResizable(false); // ������ ũ�� ���� �Ұ���
		
		
	}

	public void line_view(){
	
		HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1] = new JPanel(new BorderLayout());
		HomeMainPanel_KHJ.kakao_View1.view2_userName[HomeMainPanel_KHJ.kakao_View1.cnt-1] =new JLabel(HomeMainPanel_KHJ.kakao_View1.userName_[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		HomeMainPanel_KHJ.kakao_View1.view2_userName[HomeMainPanel_KHJ.kakao_View1.cnt-1].setFont(new Font("�޸տ�ü",Font.BOLD, 20));
		HomeMainPanel_KHJ.kakao_View1.message[HomeMainPanel_KHJ.kakao_View1.cnt-1] = new JLabel(HomeMainPanel_KHJ.kakao_View1.message_[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBackground(Color.WHITE);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1] = new JButton();
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].setLayout(new GridLayout(2,0));
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].add(HomeMainPanel_KHJ.kakao_View1.view2_userName[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].add(HomeMainPanel_KHJ.kakao_View1.message[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].addActionListener(HomeMainPanel_KHJ.kakao_View1);
		HomeMainPanel_KHJ.kakao_View1.message[HomeMainPanel_KHJ.kakao_View1.cnt-1].setFont(HomeMainPanel_KHJ.kakao_View1.font3);
		HomeMainPanel_KHJ.kakao_View1.message[HomeMainPanel_KHJ.kakao_View1.cnt-1].setForeground(Color.GRAY);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBackground(Color.WHITE);
		HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBorderPainted(false);
		HomeMainPanel_KHJ.kakao_View1.profileimageB[HomeMainPanel_KHJ.kakao_View1.cnt-1] = new JButton(new ImageIcon("homeImage/appicon/movie2.png"));
		HomeMainPanel_KHJ.kakao_View1.profileimageB[HomeMainPanel_KHJ.kakao_View1.cnt-1].setContentAreaFilled(false);
		//HomeMainPanel_KHJ.kakao_View1.profilImage[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBorder(null);
		HomeMainPanel_KHJ.kakao_View1.profileimageB[HomeMainPanel_KHJ.kakao_View1.cnt-1].setBorderPainted(false);
		HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1].add(HomeMainPanel_KHJ.kakao_View1.view2_chat[HomeMainPanel_KHJ.kakao_View1.cnt-1], "Center");	
		HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1].add(HomeMainPanel_KHJ.kakao_View1.profileimageB[HomeMainPanel_KHJ.kakao_View1.cnt-1],"West");
		HomeMainPanel_KHJ.kakao_View1.view2_Center.add(HomeMainPanel_KHJ.kakao_View1.view2_user[HomeMainPanel_KHJ.kakao_View1.cnt-1]);
		
		}

	
	
	/* �׼� */
	@Override
	public void actionPerformed(ActionEvent e) {
		/* ����ȭ�鿡�� ���� ȭ��ǥ�� ������ �� ��ȭ�� �ٲ�� ���� ó���� */
		if(e.getSource() == leftBtn_JWH){
			if(select_JWH == "ff"){
				content3_JWH.setVisible(false);
				content1_JWH.setVisible(true);
				select_JWH = "winter";
				revalidate();
				repaint();
			} else if(select_JWH == "winter"){
				content1_JWH.setVisible(false);
				content2_JWH.setVisible(true);
				select_JWH = "chun";
				revalidate();
				repaint();
			} else if(select_JWH == "chun"){
				content2_JWH.setVisible(false);	
				content3_JWH.setVisible(true);
				select_JWH = "ff";
				revalidate();
				repaint();
			}
		/* end */
			
		/* ����ȭ�鿡�� ������ ȭ��ǥ�� ������ �� ��ȭ�� �ٲ�� ���� ó���� */
		} else if(e.getSource() == rightBtn_JWH){
			if(select_JWH == "ff"){
				content2_JWH.setVisible(true);
				content3_JWH.setVisible(false);
				select_JWH = "chun";
			} else if(select_JWH == "winter"){
				content3_JWH.setVisible(true);
				content1_JWH.setVisible(false);
				select_JWH = "ff";
			} else if(select_JWH == "chun") {
				content1_JWH.setVisible(true);
				content2_JWH.setVisible(false);
				select_JWH = "winter";
			}
		}
		/* end */
		
		/* ����ȭ�鿡�� ��ȭ���� ��ư�� ������ �� ������ ��ȭ�� ������ ������ �ð��븦 ��Ȱ��ȭ�ϰ� �ð����� ȭ������ �Ѿ */
		if(e.getSource() == reserveBtn_JWH){
			if(select_JWH == "winter"){ // �ܿ�ձ�2�� �������� �� ������ ����
				moviePnl4_JWH = new JPanel(){
				 	ImageIcon movieBackground4_JWH = new ImageIcon("Img/winter3.jpg");
					Image movieImg4_JWH = movieBackground4_JWH.getImage();
					Image change4_JWH = movieImg4_JWH.getScaledInstance(90, 140, Image.SCALE_SMOOTH);
					ImageIcon mc4_JWH = new ImageIcon(change4_JWH);
						
					public void paintComponent(Graphics g){
						g.drawImage(mc4_JWH.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
					}
				};
				
				moviePnl4_JWH.setBounds(10, 5, 90, 140);
				informPanel_JWH.add(moviePnl4_JWH);		
				
				movieNameLbl_JWH.setText("�ܿ�ձ�2(��ü�̿밡)");	
				
				chun1250.setEnabled(false);
				chun2030.setEnabled(false);
				ff1515.setEnabled(false);
				ff2100.setEnabled(false);
				
				card_JWH.show(this, "time");
			} else if(select_JWH == "chun"){ // õ���� �������� �� ������ ����
				moviePnl5_JWH = new JPanel(){
				 	ImageIcon movieBackground5_JWH = new ImageIcon("Img/chun3.jpg");
					Image movieImg5_JWH = movieBackground5_JWH.getImage();
					Image change5_JWH = movieImg5_JWH.getScaledInstance(90, 140, Image.SCALE_SMOOTH);
					ImageIcon mc5_JWH = new ImageIcon(change5_JWH);
						
					public void paintComponent(Graphics g){
						g.drawImage(mc5_JWH.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
				}
			};
			
				moviePnl5_JWH.setBounds(10, 5, 90, 140);
				informPanel_JWH.add(moviePnl5_JWH);		
				
				movieNameLbl_JWH.setText("õ��(12���̿밡)");	
				
				winter1610.setEnabled(false);
				winter1840.setEnabled(false);
				ff1515.setEnabled(false);
				ff2100.setEnabled(false);
				
				card_JWH.show(this, "time");
				
			} else if(select_JWH == "ff"){				
				moviePnl6_JWH = new JPanel(){ // ����V��󸮸� �������� �� ������ ����
				 	ImageIcon movieBackground6_JWH = new ImageIcon("Img/ff3.jpg");
					Image movieImg6_JWH = movieBackground6_JWH.getImage();
					Image change6_JWH = movieImg6_JWH.getScaledInstance(90, 140, Image.SCALE_SMOOTH);
					ImageIcon mc6_JWH = new ImageIcon(change6_JWH);
						
					public void paintComponent(Graphics g){
						g.drawImage(mc6_JWH.getImage(), 0, 0, null);
						setOpaque(false);
						super.paintComponent(g);
				}					
			};
				moviePnl6_JWH.setBounds(10, 5, 90, 140);
				informPanel_JWH.add(moviePnl6_JWH);
			
				movieNameLbl_JWH.setText("����V���(12���̿밡)");
				
				winter1610.setEnabled(false);
				winter1840.setEnabled(false);
				chun1250.setEnabled(false);
				chun2030.setEnabled(false);
				
				card_JWH.show(this, "time");
			}		
		}		
		/* end */
		
		/* �ð����� ȭ�鿡�� �ڷΰ��� ��ư(<)�� ������ ��Ȱ��ȭ�� ��ư�� �ٽ� Ȱ��ȭ�ϰ� ȭ�鿡 ���̴� �г��� ����ȭ������ ��ü */
		if(e.getSource() == backBtn2_JWH){
			if(select_JWH == "winter"){
				informPanel_JWH.remove(moviePnl4_JWH);
			} else if(select_JWH == "chun"){
				informPanel_JWH.remove(moviePnl5_JWH);
			} else if(select_JWH == "ff"){
				informPanel_JWH.remove(moviePnl6_JWH);
			}
			
			winter1610.setEnabled(true);
			winter1840.setEnabled(true);
			chun1250.setEnabled(true);
			chun2030.setEnabled(true);
			ff1515.setEnabled(true);
			ff2100.setEnabled(true);
			
			card_JWH.show(this, "main");
		}
		/* end */
		
		/* �ð����� ȭ�鿡�� �ð��� ������ �� �ð��� time ������ �����ϰ� �¼����� ȭ������ �Ѿ */
		if(e.getSource() == winter1610){
			timeM_JWH = winter1610.getText();
			startTimeLbl_JWH.setText("�����ð� : " + timeM_JWH);
			sangyoungLbl_JWH.setText("�󿵰� : 1��");
			
			/* ������ ��ȭ, �ð����� �¼� ��Ȱ��ȭ */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == winter1840){
			timeM_JWH = winter1840.getText();
			startTimeLbl_JWH.setText("�����ð� : " + timeM_JWH);
			sangyoungLbl_JWH.setText("�󿵰� : 1��");
			
			/* ������ ��ȭ, �ð����� �¼� ��Ȱ��ȭ */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == chun1250){
			timeM_JWH = chun1250.getText();
			startTimeLbl_JWH.setText("�����ð� : " + timeM_JWH);
			sangyoungLbl_JWH.setText("�󿵰� : 2��");
			
			/* ������ ��ȭ, �ð����� �¼� ��Ȱ��ȭ */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == chun2030){
			timeM_JWH = chun2030.getText();
			startTimeLbl_JWH.setText("�����ð� : " + timeM_JWH);
			sangyoungLbl_JWH.setText("�󿵰� : 2��");
			
			/* ������ ��ȭ, �ð����� �¼� ��Ȱ��ȭ */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == ff1515){
			timeM_JWH = ff1515.getText();
			startTimeLbl_JWH.setText("�����ð� : " + timeM_JWH);
			sangyoungLbl_JWH.setText("�󿵰� : 3��");
			
			/* ������ ��ȭ, �ð����� �¼� ��Ȱ��ȭ */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		} else if(e.getSource() == ff2100){
			timeM_JWH = ff2100.getText();
			startTimeLbl_JWH.setText("�����ð� : " + timeM_JWH);
			sangyoungLbl_JWH.setText("�󿵰� : 3��");
			
			/* ������ ��ȭ, �ð����� �¼� ��Ȱ��ȭ */		
			for(int k=0; k<12; k++){
				String b1 = "";
				String b2 = "";
				
				if(addTicket_JWH[k] == true){
					if(ticketsSaveMName[k] == select_JWH){
						if(ticketsMTime_JWH[k] == timeM_JWH){
							b1 = ticketsSaveSeat_JWH[k];
							for(int l=0; l<=1; l++){
								for(int m=0; m<8; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								} 
							}
							
							for(int l=2; l<=6; l++){
								for(int m=0; m<12; m++){
									b2 = seatsBtn_JWH[l][m].getText();
									if(b1 == b2){
										seatsBtn_JWH[l][m].setEnabled(false);
										break;
									} 
								}
							}
						}		
					} 
				}
			}
			/* end */
			
			card_JWH.show(this, "seat");
		}
		/* end */
		
		/* �¼����� ȭ�鿡�� �ڷΰ��� ��ư(<)�� ������ time ������ �ʱ�ȭ�ϰ� �ð����� ȭ������ �ǵ��ư� */
		if(e.getSource() == backBtn3_JWH){
			timeM_JWH = "";
			startTimeLbl_JWH.setText("�����ð� : " + timeM_JWH);
			seatLbl_JWH.setText("�¼� : ");
			goPay_JWH.setEnabled(false);
			card_JWH.show(this, "time");
			
			for(int i=0; i<8; i++){
				seatsBtn_JWH[0][i].setEnabled(true);
				seatsBtn_JWH[1][i].setEnabled(true);
			}
			for(int i=0; i<12; i++){
				seatsBtn_JWH[2][i].setEnabled(true);
				seatsBtn_JWH[3][i].setEnabled(true);
				seatsBtn_JWH[4][i].setEnabled(true);
				seatsBtn_JWH[5][i].setEnabled(true);
				seatsBtn_JWH[6][i].setEnabled(true);
			}
		}
		/* end */
		
		/* �¼����� ȭ�鿡�� �¼��� �������� �� �ش� �¼� ��ư�� ���� �� ������ �¼��� �ؽ�Ʈ�� ǥ��  */
		for(int i=0; i<12; i++){
			if(e.getSource() == seatsBtn_JWH[0][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[0][i];
				selectSeat_JWH = seatsBtn_JWH[0][i].getText();
				seatLbl_JWH.setText("�¼� : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[1][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[1][i];
				selectSeat_JWH = seatsBtn_JWH[1][i].getText();
				seatLbl_JWH.setText("�¼� : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[2][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[2][i];
				selectSeat_JWH = seatsBtn_JWH[2][i].getText();
				seatLbl_JWH.setText("�¼� : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[3][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[3][i];
				selectSeat_JWH = seatsBtn_JWH[3][i].getText();
				seatLbl_JWH.setText("�¼� : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[4][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[4][i];
				selectSeat_JWH = seatsBtn_JWH[4][i].getText();
				seatLbl_JWH.setText("�¼� : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[5][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[5][i];
				selectSeat_JWH = seatsBtn_JWH[5][i].getText();
				seatLbl_JWH.setText("�¼� : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			} else if(e.getSource() == seatsBtn_JWH[6][i]){
				checkBtns[ticketCount_JWH] = seatsBtn_JWH[6][i];
				selectSeat_JWH = seatsBtn_JWH[6][i].getText();
				seatLbl_JWH.setText("�¼� : " + selectSeat_JWH);
				goPay_JWH.setEnabled(true);
			}
		}
		/* end */
		
		/* �����ϱ� ��ư�� ������ �� �������� ȭ������ �Ѿ */
		if(e.getSource() == goPay_JWH){
			if(select_JWH == "winter"){
				simpleLbl1_JWH.setText("�ܿ�ձ�2(" + selectSeat_JWH + ")");
			} else if(select_JWH == "chun"){
				simpleLbl1_JWH.setText("õ��(" + selectSeat_JWH + ")");
			} else if(select_JWH == "ff"){
				simpleLbl1_JWH.setText("����V���(" + selectSeat_JWH + ")");
			}
			card_JWH.show(this, "pay");
		}
		/* end */
		
		/* �����ϱ� ȭ�鿡�� �ڷΰ��� ��ư(<)�� ������ �¼����� ȭ������ �Ѿ */
		if(e.getSource() == backBtn4_JWH){
			card_JWH.show(this, "seat");	
			
			numTransBtn_JWH.setEnabled(true);
			confirmBtn_JWH.setEnabled(true);
			nameTF_JWH.setEnabled(true);
			nameTF_JWH.setText(null);
			resiNumTF1_JWH.setEnabled(true);
			resiNumTF1_JWH.setText(null);
			resiNumTF2_JWH.setEnabled(true);
			resiNumTF2_JWH.setText(null);
			phoneNumTF_JWH.setEnabled(true);
			phoneNumTF_JWH.setText(null);
			payInputTF_JWH.setEditable(true);
			payInputTF_JWH.setText(null);
			progressBtn_JWH.setEnabled(false);
		}
		/* end */
		
		/* �����ϱ� ȭ�鿡�� ������ȣ���� ��ư�� ������ 0~9���� ������ ���ڰ� num1~num6�� �Էµ� */
		/* ������ȣ�� �ܼ�â�� ��µ� */
		if(e.getSource() == numTransBtn_JWH){
			
			String nameCheck_JWH = nameTF_JWH.getText();
			String resi1Check_JWH = resiNumTF1_JWH.getText();
			String resi2Check_JWH = resiNumTF2_JWH.getText();
			String pnTFLength_JWH = phoneNumTF_JWH.getText();
			if(nameCheck_JWH.length() >= 2){
				if(resi1Check_JWH.length() == 6){
					if(resi2Check_JWH.length() == 1){
						if(pnTFLength_JWH.length() == 11){
							for(int i=0; i<100; i++){
								double dv_JWH = Math.random();
								num1_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num2_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num3_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num4_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num5_JWH = (int)(dv_JWH * 10);
								dv_JWH = Math.random();
								num6_JWH = (int)(dv_JWH * 10);
							}
							msLbl1_JWH.setText(phoneNumTF_JWH.getText() + " �� ������ȣ�� �����߽��ϴ�.");
							msPanel_JWH.setVisible(true);
							certNum2_JWH = "" + num1_JWH + num2_JWH + num3_JWH + num4_JWH + num5_JWH + num6_JWH;
							certNum1_JWH = Integer.parseInt(certNum2_JWH);
							System.out.println("������ ������ȣ�� [" + certNum1_JWH + "] �Դϴ�.");
							HomeMainPanel_KHJ.message.receiveMessage("���� ������?", "������ ������ȣ�� [" + certNum1_JWH + "] �Դϴ�.");
							HomeMainPanel_KHJ.message.listBtn_JWH[HomeMainPanel_KHJ.message.Mcount_JWH-1].setText(
									"<html>" + "���� ������?" + "<br/>" + "\r" + "<html>" + "������ ������ȣ�� [" + certNum1_JWH + "] �Դϴ�." + "<br/>");
						} else {
							msLbl1_JWH.setText("�޴��� ��ȣ�� ��Ȯ�ϰ� �Է����ּ���.");
							msPanel_JWH.setVisible(true);
						}
					} else {
						msLbl1_JWH.setText("�ֹε�Ϲ�ȣ�� ��Ȯ�ϰ� �Է����ּ���.");
						msPanel_JWH.setVisible(true);
					}
				} else {
					msLbl1_JWH.setText("�ֹε�Ϲ�ȣ�� ��Ȯ�ϰ� �Է����ּ���.");
					msPanel_JWH.setVisible(true);
				}		
			} else {
				msLbl1_JWH.setText("�̸��� ��Ȯ�ϰ� �Է����ּ���.");
				msPanel_JWH.setVisible(true);
			}
		}
		/* end */
		
		if(e.getSource() == msBtn_JWH){
			msPanel_JWH.setVisible(false);
		}
		
		/* ������ȣ�Է� TextField�� ������ȣ�� ������ ���ڸ�  �����ϱ� ��ư Ȱ��ȭ */
		if(e.getSource() == confirmBtn_JWH){
			try{
				certNumInput2_JWH = payInputTF_JWH.getText();
				certNumInput1_JWH = Integer.parseInt(certNumInput2_JWH);
				if(certNum1_JWH == certNumInput1_JWH){
					numTransBtn_JWH.setEnabled(false);
					confirmBtn_JWH.setEnabled(false);
					nameTF_JWH.setEnabled(false);
					resiNumTF1_JWH.setEnabled(false);
					resiNumTF2_JWH.setEnabled(false);
					phoneNumTF_JWH.setEnabled(false);
					payInputTF_JWH.setEditable(false);
					progressBtn_JWH.setEnabled(true);
				} 
			} catch(NumberFormatException Ne){
				msLbl1_JWH.setText("������ȣ�� ��Ȯ�ϰ� �Է����ּ���.");
				msPanel_JWH.setVisible(true);
			}
			
		}
		/* end */	
		
		/* �����ϱ� ��ư�� ������ �����Ϸ� ȭ������ �Ѿ */
		if(e.getSource() == progressBtn_JWH){
			card_JWH.show(this, "suc");
		}
		/* end */
		
		/* �����Ϸ� ȭ�鿡�� Ȯ���� ������ Ƽ�� ���� �� ó��ȭ������ �ǵ��ư��� �����ϱ� ȭ�� �ʱ�ȭ */
		if(e.getSource() == okBtn_JWH){
			
			/* ����Ȯ�ο� Ƽ���� �߰� */
			addTicket_JWH[ticketCount_JWH] = true;
			ticketsSaveMName[ticketCount_JWH] = select_JWH;
			ticketsSaveSeat_JWH[ticketCount_JWH] = selectSeat_JWH;
			ticketsMDay_JWH[ticketCount_JWH] = st_JWH;
			ticketsMTime_Hour_JWH[ticketCount_JWH] = timeM_JWH.substring(0, 2);
			ticketsMTime_Minute_JWH[ticketCount_JWH] = timeM_JWH.substring(3, 5);
			ticketsMTime_JWH[ticketCount_JWH] = timeM_JWH;
			ticketsMment_JWH[ticketCount_JWH] = "�� ������ �ִٸ� ������ ���� �Ϸ�� ����ǥ�Դϴ�.";
			
			tickets_JWH[ticketCount_JWH] = new JPanel();
			tickets_JWH[ticketCount_JWH].setLayout(null);
			tickets_JWH[ticketCount_JWH].setBackground(new Color(2, 23, 71));
			tickets_JWH[ticketCount_JWH].setPreferredSize(new Dimension(300, 160));
			
			if(ticketsSaveMName[ticketCount_JWH] == "winter"){
				tNameLbl_JWH[ticketCount_JWH] = new JLabel("�ܿ�ձ�2(" + ticketsSaveSeat_JWH[ticketCount_JWH] +")");
				tNameLbl_JWH[ticketCount_JWH].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
				tNameLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tNameLbl_JWH[ticketCount_JWH].setBounds(90, 6, 200, 50);
				
				tCinemaLbl_JWH[ticketCount_JWH] = new JLabel("������ 1��");
				tCinemaLbl_JWH[ticketCount_JWH].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 15));
				tCinemaLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tCinemaLbl_JWH[ticketCount_JWH].setBounds(250, -5, 200, 50);
				tickets_JWH[ticketCount_JWH].add(tCinemaLbl_JWH[ticketCount_JWH]);
				
				informPanel_JWH.remove(moviePnl4_JWH);
			} else if(ticketsSaveMName[ticketCount_JWH] == "chun"){
				tNameLbl_JWH[ticketCount_JWH] = new JLabel("õ��(" + ticketsSaveSeat_JWH[ticketCount_JWH] +")");
				tNameLbl_JWH[ticketCount_JWH].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
				tNameLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tNameLbl_JWH[ticketCount_JWH].setBounds(110, 6, 200, 50);
				
				tCinemaLbl_JWH[ticketCount_JWH] = new JLabel("������ 2��");
				tCinemaLbl_JWH[ticketCount_JWH].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 15));
				tCinemaLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tCinemaLbl_JWH[ticketCount_JWH].setBounds(250, -5, 200, 50);
				tickets_JWH[ticketCount_JWH].add(tCinemaLbl_JWH[ticketCount_JWH]);
				
				informPanel_JWH.remove(moviePnl5_JWH);
			} else if(ticketsSaveMName[ticketCount_JWH] == "ff"){
				tNameLbl_JWH[ticketCount_JWH] = new JLabel("����V���(" + ticketsSaveSeat_JWH[ticketCount_JWH] +")");
				tNameLbl_JWH[ticketCount_JWH].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 32));
				tNameLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tNameLbl_JWH[ticketCount_JWH].setBounds(80, 6, 200, 50);
				
				tCinemaLbl_JWH[ticketCount_JWH] = new JLabel("������ 3��");
				tCinemaLbl_JWH[ticketCount_JWH].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 15));
				tCinemaLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
				tCinemaLbl_JWH[ticketCount_JWH].setBounds(250, -5, 200, 50);
				tickets_JWH[ticketCount_JWH].add(tCinemaLbl_JWH[ticketCount_JWH]);
				
				informPanel_JWH.remove(moviePnl6_JWH);
			}
			
			tickets_JWH[ticketCount_JWH].add(tNameLbl_JWH[ticketCount_JWH]);
			checkContentPanel_JWH.add(tickets_JWH[ticketCount_JWH]);
			
			tDayLbl_JWH[ticketCount_JWH] = new JLabel(ticketsMDay_JWH[ticketCount_JWH]);
			tDayLbl_JWH[ticketCount_JWH].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 20));
			tDayLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
			tDayLbl_JWH[ticketCount_JWH].setBounds(112, 30, 100, 50);
			tickets_JWH[ticketCount_JWH].add(tDayLbl_JWH[ticketCount_JWH]);
			
			tTimeLbl_JWH[ticketCount_JWH] = new JLabel(ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH]);
			tTimeLbl_JWH[ticketCount_JWH].setFont(new Font("�޸վƹ�ü", Font.PLAIN, 90));
			tTimeLbl_JWH[ticketCount_JWH].setForeground(Color.WHITE);
			tTimeLbl_JWH[ticketCount_JWH].setBounds(85, 60, 200, 70);
			tickets_JWH[ticketCount_JWH].add(tTimeLbl_JWH[ticketCount_JWH]);
			
			tMentLbl_JWH[ticketCount_JWH] = new JLabel("�� ������ �ִٸ� ���� ������ ����ǥ�Դϴ�.");
			tMentLbl_JWH[ticketCount_JWH].setFont(new Font("�����ٸ����", Font.PLAIN, 10));
			tMentLbl_JWH[ticketCount_JWH].setForeground(Color.ORANGE);
			tMentLbl_JWH[ticketCount_JWH].setBounds(63, 110, 250, 70);
			tickets_JWH[ticketCount_JWH].add(tMentLbl_JWH[ticketCount_JWH]);
			
			/* Tickets ������ ticket����.txt �������� ���� */
			try{
				OutputStream tkOut_JWH = new FileOutputStream("Tickets/ticket" + ticketCount_JWH + ".txt");
				String tkContent_JWH = "";
				if(ticketsSaveMName[ticketCount_JWH] == "winter"){
							tkContent_JWH = "���Ű� �Ϸ�Ǿ����ϴ�.\n" 
							+ "��ȭ ���� : �ܿ�ձ�2\n"
							+ "�ݾ� : 8,000��\n"
							+ "��ȭ�� : ������ 1��\n"
							+ "�¼� : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "\n"
							+ "������ : " + ticketsMDay_JWH[ticketCount_JWH] + "\n"
							+ "���� ���� �ð� : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH];
				} else if(ticketsSaveMName[ticketCount_JWH] == "chun"){
							tkContent_JWH = "���Ű� �Ϸ�Ǿ����ϴ�.\n" 
							+ "��ȭ���� : õ��\n"
							+ "�ݾ� : 8,000��\n"
							+ "��ȭ�� : ������ 2��\n"
							+ "�¼� : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "\n"
							+ "������ : " + ticketsMDay_JWH[ticketCount_JWH] + "\n"
							+ "���� ���� �ð� : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH];
				} else if(ticketsSaveMName[ticketCount_JWH] == "ff"){
							tkContent_JWH = "���Ű� �Ϸ�Ǿ����ϴ�.\n" 
							+ "��ȭ���� : ����V���\n"
							+ "�ݾ� : 8,000��\n"
							+ "��ȭ�� : ������ 3��\n"
							+ "�¼� : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "\n"
							+ "������ : " + ticketsMDay_JWH[ticketCount_JWH] + "\n"
							+ "���� ���� �ð� : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH];
				}
				byte[] byte_JWH = tkContent_JWH.getBytes();
				tkOut_JWH.write(byte_JWH);
			} catch (Exception e1) {
				e1.getStackTrace();
			}
			
			if(ticketsSaveMName[ticketCount_JWH] == "winter"){
				HomeMainPanel_KHJ.kakao_View1.user("���� ������?","","", "<html>���Ű� �Ϸ�Ǿ����ϴ�.<br>" + "��ȭ ���� : �ܿ�ձ�2<br>" + "�ݾ� : 8,000��<br>" + 
								"��ȭ�� : ������ 1��<br>" + "�¼� : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "<br>" + 
								"������ : " + ticketsMDay_JWH[ticketCount_JWH] + "<br>" + "���� ���� �ð� : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH] +"</html>");
				//HomeMainPanel_KHJ.kakao_View1.userMake(2);
				line_view();
			} else if (ticketsSaveMName[ticketCount_JWH] == "chun"){
				HomeMainPanel_KHJ.kakao_View1.user("���� ������?","","", "<html>���Ű� �Ϸ�Ǿ����ϴ�.<br>" + "��ȭ ���� : õ��<br>" + "�ݾ� : 8,000��<br>" + 
						"��ȭ�� : ������ 2��<br>" + "�¼� : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "<br>" + 
						"������ : " + ticketsMDay_JWH[ticketCount_JWH] + "<br>" + "���� ���� �ð� : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH] +"</html>");
				//HomeMainPanel_KHJ.kakao_View1.userMake(2);
				line_view();
			} else if (ticketsSaveMName[ticketCount_JWH] == "ff"){
				HomeMainPanel_KHJ.kakao_View1.user("���� ������?","","", "<html>���Ű� �Ϸ�Ǿ����ϴ�.<br>" + "��ȭ ���� : ����V���<br>" + "�ݾ� : 8,000��<br>" + 
						"��ȭ�� : ������ 3��<br>" + "�¼� : " + ticketsSaveSeat_JWH[ticketCount_JWH] + "<br>" + 
						"������ : " + ticketsMDay_JWH[ticketCount_JWH] + "<br>" + "���� ���� �ð� : " + ticketsMTime_Hour_JWH[ticketCount_JWH] + ":" + ticketsMTime_Minute_JWH[ticketCount_JWH] +"</html>");
				//HomeMainPanel_KHJ.kakao_View1.userMake(2);
				line_view();
			} 
			
			ticketCount_JWH++; // Ƽ���� �����Ǹ� Ƽ�� ī���� 1 ����
			/* end */

			winter1610.setEnabled(true);
			winter1840.setEnabled(true);
			chun1250.setEnabled(true);
			chun2030.setEnabled(true);
			ff1515.setEnabled(true);
			ff2100.setEnabled(true);
			
			selectSeat_JWH = "";
			seatLbl_JWH.setText("�¼� : " + selectSeat_JWH);
			msPanel_JWH.setVisible(false);
			
			numTransBtn_JWH.setEnabled(true);
			confirmBtn_JWH.setEnabled(true);
			nameTF_JWH.setEnabled(true);
			nameTF_JWH.setText(null);
			resiNumTF1_JWH.setEnabled(true);
			resiNumTF1_JWH.setText(null);
			resiNumTF2_JWH.setEnabled(true);
			resiNumTF2_JWH.setText(null);
			phoneNumTF_JWH.setEnabled(true);
			phoneNumTF_JWH.setText(null);
			payInputTF_JWH.setEditable(true);
			payInputTF_JWH.setText(null);
			progressBtn_JWH.setEnabled(false);
			
			card_JWH.show(this, "main");
		}
		/* end */
		
		/* ����Ȯ�� ��ư�� ������ �� ����Ȯ�� ȭ������ �վ */
		if(e.getSource() == checkBtn_JWH){
			card_JWH.show(this, "check");	
		}
		/* end */
		
		/* ����Ȯ�� ȭ�鿡�� �ڷΰ��� ��ư(<)�� ������ ó������ �ǵ��ư� */
		if(e.getSource() == backBtn6_JWH){
			card_JWH.show(this, "main");
		}
		/* end */	
	}
	
	public void End(){
		this.setVisible(false);
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}
	
}
