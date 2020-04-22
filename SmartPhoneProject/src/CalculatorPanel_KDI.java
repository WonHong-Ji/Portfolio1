import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class CalculatorPanel_KDI extends JPanel implements ActionListener {
	JPanel jpButton, jpResult; // �г� �ʱ�ȭ
	JMenuBar jmb; // �޴��� �ʱ�ȭ
	JMenu jmEdit, jmHelp; // �޴� �ʱ�ȭ
	JMenuItem mCopy, mPaste, mHelp, mInfo; // �޴� ������ �ʱ�ȭ
	JLabel jlbResult1, jlbResult2, jlbResult3 ,jlbResult4; // ���̺� �ʱ�ȭ
	JButton[] jbButton = null; // ��ư�迭 �ʱ�ȭ
	String result = "";
	String result1 = "";
	String result2 = "";
	String number[] = { " ", " ", " " };
	String[] numStr = { "��", "CE", "C", "/", "7", "8", "9", "*", "4", "5", "6",
			"-", "1", "2", "3", "+", "0", "00", ".", "=" }; // ��ư�� �� ��


	// �ڵ��� ������
	JPanel phoneFramePanel;
	JLabel phoneFrameLabel;
	ImageIcon phoneFrameImage;

	// �г� ���� - �� �гο� ���缭 �۾��Ͻø� �˴ϴ�.
	JPanel samplePanel;
	JLabel sampleLabel;
	ImageIcon sampleImage;
	
	HomeMainPanel_KHJ mainHome;

	public CalculatorPanel_KDI(JPanel mainHomePanel) {
		mainHome = (HomeMainPanel_KHJ) mainHomePanel;
		this.setLayout(null);
		// ������¡ ����

		// ���� �ʵ� �ʱ�ȭ
		samplePanel = new JPanel();
		samplePanel.setLayout(new BorderLayout());
		sampleImage = new ImageIcon("homeImage/panelSample.png");
		sampleLabel = new JLabel(sampleImage);

		// ������ ������Ʈ���� �����̳ʿ� �߰�
		samplePanel.add(sampleLabel);

		this.add(samplePanel);

		// this�� �߰��� �г��� ��ġ, ������ ����
		this.samplePanel.setBounds(0, 0, 378, 674);

		// super("����"); // Ÿ��Ʋ ��

		/** �޴��� ���� */
		jmb = new JMenuBar();

		// jmEdit = new JMenu("����(E)");
		// jmHelp = new JMenu("����(H)");

		// mCopy = new JMenuItem("����");
		// mPaste = new JMenuItem("�ٿ��ֱ�");
		// mHelp = new JMenuItem("���� ����");
		// mInfo = new JMenuItem("���� ����");

		// jmEdit.add(mCopy); // jmEdit��� �޴��� mCopy��� �޴������� �߰�
		// jmEdit.add(mPaste); // jmEdit��� �޴��� mPaste��� �޴������� �߰�
		// jmHelp.add(mHelp); // jmHelp��� �޴��� mHelp��� �޴������� �߰�
		// jmHelp.add(mInfo); // jmHelp��� �޴��� mInfo��� �޴������� �߰�

		// jmb.add(jmEdit); // jmb��� �޴��ٿ� jmEdit��� �޴� �߰�
		// jmb.add(jmHelp); // jmb��� �޴��ٿ� jmHelp��� �޴� �߰�

		// setJMenuBar(jmb); // jmb�޴��� �߰�
		/** �޴��� �� */

		/** ���̺� ���� */
		jpResult = new JPanel(new GridLayout(4, 1)); // jpResult��� �гο�
														// GrideLayot�� ����, 2 x 1
		Color color = new Color(174, 188, 200);
		jpResult.setBackground(color);// jpResult��� �гο� ��� �������
		jlbResult4 = new JLabel(" ����", JLabel.LEFT);
		
		jlbResult3 = new JLabel("", JLabel.RIGHT);
		
		jlbResult1 = new JLabel("", JLabel.RIGHT); // jlbResult1��� �� ���� ���̺�,
													// ��������
		jlbResult2 = new JLabel("0", JLabel.RIGHT); // jlbResult2��� �⺻�� 0�� ���̺�,
													// ��������
		jlbResult2.setFont(new Font("����", Font.BOLD, 50)); // jlbResult2 ���̺�
															// ��Ʈ�� ����, ���ϰ�, ũ��20
															// ����
		jlbResult4.setFont(new Font("����", Font.CENTER_BASELINE, 15));
		jlbResult1.setFont(new Font("����", Font.BOLD, 20));

		jpResult.add(jlbResult4);
		jpResult.add(jlbResult3);
		jpResult.add(jlbResult1); // jpResult �гο� jlbResult1 ���̺� �߰�
		jpResult.add(jlbResult2); // jpResult �гο� jlbResult2 ���̺� �߰�
		/** ���̺� �� */

		/** ��ư ���� */
		jpButton = new JPanel(new GridLayout(5, 4, 2, 2)); // jpButton��� �г�,
															// GridLayout����, 5 x
															// 4, ������ ���μ��� 5��
		Color color2 = new Color(234, 234, 234);
		jpButton.setBackground(color2); // jpButton �г� ����� ���
		jbButton = new JButton[numStr.length]; // jbButton ��ư �迭 �ʱ�ȭ
//		String[] numStr = { "��", "CE", "C", "/", "7", "8", "9", "*", "4", "5", "6",
//				"-", "1", "2", "3", "+", "0", "00", ".", "=" }; // ��ư�� �� ��

		
		jbButton[0] = new JButton(new ImageIcon("cal_Img/delete.png"));
		jbButton[1] = new JButton(new ImageIcon("cal_Img/ce.png"));
		jbButton[2] = new JButton(new ImageIcon("cal_Img/c.png"));
		jbButton[3] = new JButton(new ImageIcon("cal_Img/nanugi.png"));
		jbButton[4] = new JButton(new ImageIcon("cal_Img/7.png"));
		jbButton[5] = new JButton(new ImageIcon("cal_Img/8.png"));
		jbButton[6] = new JButton(new ImageIcon("cal_Img/9.png"));
		jbButton[7] = new JButton(new ImageIcon("cal_Img/gobhagi.png"));
		jbButton[8] = new JButton(new ImageIcon("cal_Img/4.png"));
		jbButton[9] = new JButton(new ImageIcon("cal_Img/5.png"));
		jbButton[10] = new JButton(new ImageIcon("cal_Img/6.png"));
		
		jbButton[11] = new JButton(new ImageIcon("cal_Img/minus.png"));
		jbButton[12] = new JButton(new ImageIcon("cal_Img/1.png"));
		jbButton[13] = new JButton(new ImageIcon("cal_Img/2.png"));
		jbButton[14] = new JButton(new ImageIcon("cal_Img/3.png"));
		jbButton[15] = new JButton(new ImageIcon("cal_Img/plus.png"));
		jbButton[16] = new JButton(new ImageIcon("cal_Img/0.png"));
		jbButton[17] = new JButton(new ImageIcon("cal_Img/00.png"));
		jbButton[18] = new JButton(new ImageIcon("cal_Img/spot.png"));
		jbButton[19] = new JButton(new ImageIcon("cal_Img/is.png"));
		//jbButton[20] = new JButton(new ImageIcon("cal_Img/delete.png"));
		
		
		// jbButton�� ǥ���� ���� ����
		for (int i = 0; i < numStr.length; i++) {
			//jbButton[i] = new JButton(numStr[i]);
			//jbButton[i].setFont(new Font("����", Font.BOLD, 20));
			jpButton.add(jbButton[i]);
			jbButton[i].addActionListener(this);
		}
		
		/** ��ư �� ���� */
		for (int j = 0; j < numStr.length; j++) {
			if (j < 3) {
				Color color3 = new Color(207, 223, 234);
				jbButton[j].setForeground(Color.BLACK);
				jbButton[j].setBackground(color3);
			} else if (j == 3 || j == 7 || j == 11 || j == 15 || j == 19) {
				Color color3 = new Color(207, 223, 234);
				jbButton[j].setForeground(Color.BLACK);
				jbButton[j].setBackground(color3);
			}
		}
		jbButton[0].setForeground(Color.BLACK);

		samplePanel.add("North", jpResult);
		samplePanel.add("Center", jpButton);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String txtButton = null;
		//int txtButtonInt = Integer.parseInt(txtButton);
		
		for (int i = 0; i < numStr.length; i++) {
			if(e.getSource() == jbButton[i])
				txtButton = numStr[i];
		}
		
		//System.out.println(txtButton);
		
		if (txtButton.equals("1") || txtButton.equals("2")
				|| txtButton.equals("3") || txtButton.equals("4")
				|| txtButton.equals("5") || txtButton.equals("6")
				|| txtButton.equals("7") || txtButton.equals("8")
				|| txtButton.equals("9")) 
		
		{
			if (result2.equals("0")) {
				result2 = "";
			}
			//
			result2 = result2+txtButton ;
			jlbResult2.setText(result2);
		}

		else if (txtButton.equals("��")) {
			int len = jlbResult2.getText().length();
			if (len == 1) {
				result2 = "";
				jlbResult2.setText("0");
			} else {
				if (!"".equals(result2)) {
					result2 = result2.substring(0, len - 1);
					jlbResult2.setText(result2);
				}
			}
		}
		
		else if (txtButton.equals("CE")) {
			result2 = "";
			result = "";
			jlbResult2.setText("0");
			number[0] = "0";
		} else if (txtButton.equals("C")) {
			result = "";
			result1 = "";
			result2 = "";
			jlbResult1.setText("");
			jlbResult2.setText("0");
			number[0] = " ";
			number[1] = " ";
			number[2] = " ";
		}
		
		
		else if (txtButton.equals("0") || txtButton.equals("00")) {
			if (!("".equals(result2))) {
				if (!"0".equals(result2)) {
					result2 += txtButton;
					jlbResult2.setText(result2);
				}
			} else {
				result2 = "0";
			}
		}
		
		/////////////////////////////////////////////////////////////////////////////
		
		else if (txtButton.equals(".")) {
			if ("".equals(result2)) {
				result2 = "0" + txtButton;
			} else {
				if (result2.indexOf(".") == -1) {
					result2 += txtButton;
				}
			}
			jlbResult2.setText(result2);
		} else if (txtButton.equals("=")) {
			if (!"".equals(result2)) {
				number[2] = result2;
			}
			if ("".equals(result1)) {
				if (!number[1].equals(" ")) {
					result = Cal();
					if ("0���� ���� �� �����ϴ�.".equals(result)) {
						result = "";
						result1 = "";
						result2 = "";
						number[0] = " ";
						number[1] = " ";
						number[2] = " ";
					} else {
						number[0] = result;
						jlbResult2.setText(result);
					}
				}
				jlbResult1.setText(result1);
			} else {
				if (" ".equals(number[2])) {
					number[2] = result2;
				}
				result = number[0];

				if ("0���� ���� �� �����ϴ�.".equals(result)) {
					jlbResult2.setText(result);
					result = "";
					result1 = "";
					result2 = "";
					number[0] = " ";
					number[1] = " ";
					number[2] = " ";
				} else {
					result = Cal();

					if (!"0���� ���� �� �����ϴ�.".equals(result)) {
						result1 = "";
						number[0] = result;
						jlbResult2.setText(result);
						jlbResult1.setText(result1);
						result2 = "";
					} else {
						jlbResult2.setText("0���� ���� �� �����ϴ�.");
						jlbResult1.setText("");
						result = "";
						result1 = "";
						result2 = "";
						number[0] = " ";
						number[1] = " ";
						number[2] = " ";
					}
					System.out.println("?");
				}
			}
		} else if (txtButton.equals("/") || txtButton.equals("*")
				|| txtButton.equals("-") || txtButton.equals("+")) {
			if ("".equals(result1)) {
				if ("".equals(result2)) {
					if ("".equals(result)) {
						result1 = "0" + txtButton;
						number[0] = "0";
					} else {
						result1 = result + txtButton;
					}
				} else {
					if (!"".equals(result)) {
						result1 = result + txtButton;
					}
					result1 = result2 + txtButton;
					number[0] = result2;
				}
				number[1] = txtButton;
			} else {
				if ("".equals(result2)) {
					result1 = result1.substring(0, result1.length() - 1)
							+ txtButton;
					number[1] = txtButton;
				} else {
					result1 += result2 + txtButton;
					number[2] = result2;
					result = Cal();
					number[1] = txtButton;
					jlbResult2.setText(result);
					number[0] = result;
				}
			}
			if (number[1].equals("/")
					&& (number[2].equals(" 0") || number[2].equals("0"))) {

			} else {
				result2 = "";
				jlbResult1.setText(result1);
			}

		}
	}

	/** ��ư �̺�Ʈ �� */

	/** ��� �޼ҵ� ���� */
	public String Cal() {
		String num = "";
		String testNum1 = "";
		String testNum2 = "";

		if (number[0].indexOf(".") != -1) {
			int index1 = number[0].indexOf(".");

			testNum1 = number[0].substring(index1, number[0].length());

			if (testNum1.replaceAll("0", "").equals(".")) {
				number[0] = number[0].substring(0, index1);
			}
		}

		if (number[2].indexOf(".") != -1) {
			int index2 = number[2].indexOf(".");

			testNum2 = number[2].substring(index2, number[2].length());

			if (testNum2.replaceAll("0", "").equals(".")) {
				number[2] = number[2].substring(0, index2);
			}
		}
		if (number[1].equals("*")) {
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) * Double
						.parseDouble(number[2])) + "";
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) * Long
							.parseLong(number[2])) + "";
					result = num;
					number[0] = result;
				}
			}
		} else if (number[1].equals("+")) {
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) + Double
						.parseDouble(number[2])) + "";
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) + Long
							.parseLong(number[2])) + "";
					result = num;
					number[0] = result;
				}
			}
		} else if (number[1].equals("-")) {
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) - Double
						.parseDouble(number[2])) + "";
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) - Long
							.parseLong(number[2])) + "";
					result = num;
					number[0] = result;
				}
			}
		} else if (number[1].equals("/")) {
			number[2].trim();
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) / Double
						.parseDouble(number[2])) + "";
			} else {
				if (number[2].equals("0")) {
					num = "0���� ���� �� �����ϴ�.";
					result2 = "";
				} else {
					if ("".equals(number[2])) {
						num = result2;
					} else {
						if (!"".equals(result)) {
							number[0] = result;
						}
						num = (Double.parseDouble(number[0]) / Double
								.parseDouble(number[2])) + "";

						if (num.indexOf(".") != -1) {
							int index3 = num.indexOf(".");
							String testNum3 = num.substring(index3,
									num.length());
							if (testNum3.replaceAll("0", "").equals(".")) {
								num = num.substring(0, index3);
							}
						}
						result = num;
						number[0] = result;
					}
				}
			}
		}
		return num;
	}

	public void End(){
		this.setVisible(false);
		mainHome.setOnHome();
		mainHome.nowApp = 1;
	}

}