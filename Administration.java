package four;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Administration extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5405800831390946124L;
	private JTextField jtext;
	private JPanel top, center, end;
	private String jtextInfo;
	private int position;
	private char symbal;
	
	public Administration() {
		this.setLayout(null);
		this.setBounds(0, 0, 600, 400);
		jtextInfo = new String("0");
		position = 0;
		settop();
		setcenter();
		setend();
		this.add(top);
		this.add(center);
		this.add(end);
	}
	

	private void settop() {
		// TODO �Զ����ɵķ������
		top = new JPanel();
		top.setLayout(null);
		top.setBounds(0, 0, 600, 30);
		this.jtext = new JTextField();
		jtext.setText("0");
		jtext.setEditable(false);
		jtext.setBackground(Color.WHITE);
		jtext.setBounds(0, 0, 600, 30);
		top.add(jtext);
	}

	private void setcenter() {
		// TODO �Զ����ɵķ������
		center = new JPanel();
		center.setLayout(null);
		center.setBounds(0, 30, 600, 50);
		String[] text = {"By   ZPY", "Backspace", "CE", "C"};
		JButton[] buttons = new JButton[4];
		for(int i = 0; i < 4; i++) {
			buttons[i] = new JButton(text[i]);
			buttons[i].setBounds(i * 150, 0, 150, 50);
		}
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				
			}
		});
		//BACKSPACE�¼�
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {
					if(jtextInfo.length() > 1)
						jtextInfo = jtextInfo.substring(0, jtextInfo.length() - 1);
					else {
						jtextInfo = "0";
					}
				}
				else{
					position = 0;
					symbal = ' ';
					if(jtextInfo.length() > 1)
						jtextInfo = jtextInfo.substring(0, jtextInfo.length() - 1);
					else
						jtextInfo = "0";
				}
				jtext.setText(jtextInfo);
			}
		});
		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//CE�¼�
			}
		});
		
		//C�¼�
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//C�¼�
				jtextInfo = "0";
				jtext.setText("0");
				position = 0;
				symbal = ' ';
			}
		});
		
		for(int i = 0; i < 4; i++) {
			center.add(buttons[i]);
		}
	}
	
	private void setend() {
		// TODO �Զ����ɵķ������
		end = new JPanel();
		end.setLayout(null);
		end.setBounds(0, 80, 600, 320);
		end.add(setEndLeft());
		end.add(setEndRight());
	}
	
	private JPanel setEndLeft() {
		JPanel end_left = new JPanel();
		end_left.setLayout(null);
		end_left.setBounds(0, 0, 80, 320);
		String[] text = {"MC", "MR", "MS", "M+"};
		JButton[] buttons = new JButton[4];
		for(int i = 0; i < 4; i++) {
			buttons[i] = new JButton(text[i]);
			buttons[i].setBounds(0, 80 * i, 80, 80);
		}
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//MC�¼�
			}
		});
		
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//MR�¼�
			}
		});
		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//MS�¼�
			}
		});
		
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//M+�¼�
			}
		});
		
		for(int i = 0; i < 4; i++) {
			end_left.add(buttons[i]);
		}
		return end_left;
	}
	
	private JPanel setEndRight() {
		JPanel end_right = new JPanel();
		end_right.setLayout(null);
		end_right.setBounds(80, 0, 520, 320);
		String[] text = {"7", "8", "9", "/", "sqrt", "4", "5", "6", "*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "="};
		JButton[] buttons = new JButton[20];
		for(int i = 0; i < 20; i++) {
			buttons[i] = new JButton(text[i]);
			buttons[i].setBounds(i % 5 * 104, i / 5 * 80, 104, 80);
		}
		
		//������׷���¼�
		for(int i= 0; i< 10; i++) {
			buttons[((i / 3) * 5 + (i % 3))].addActionListener(new ActionListener() {
				private JButton button;
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);		//��ȡ���һ���ַ�
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		//���һ���ַ����������
						if(temp_end == '0' && position == 0 && Double.parseDouble(jtextInfo) == 0) {			//field��ֻ��0����ʱֱ�Ӹ��ǲ�����׷��
							jtextInfo = button.getText();
						}
						//��ֻ��0ʱ����׷��
						else{
							if(symbal != 'x')		//������δ��=
								jtextInfo += button.getText();
							else{
								jtextInfo = button.getText();
								symbal = ' ';
							}
						}
					}
					//���һλΪ�����ʱ���Է�����Ϣ���б�ǲ�׷������
					else {
						//��ֹ��0
						if(temp_end == '/' && button.getText() == "0") {
							//���ı�ֵ
						}
						//׷��ֵ
						else {
							position = jtextInfo.length();
							symbal = temp_end;
							jtextInfo += button.getText();
						}
					}
					jtext.setText(jtextInfo);
				}
				public ActionListener setbutton(JButton button) {
					this.button = button;
					return this;
				}
			}.setbutton(buttons[((i / 3) * 5 + (i % 3))]));
		}
		
		// /��
		buttons[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position != 0) {			//һ����������������Ƚ��м���
					jtextInfo = result() + '/';
					position = 0;			//���Ϊ0��֪����һ����������+����
				}
				else {
					//���һλ��Ϊ�����,׷��/
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
						jtextInfo += '/';
					}
					//���һλΪ���������ʱ��δ�������֣�����positionΪ0,��׷��
					else {
						//�ı����һλ
						if(jtextInfo.length() > 1) {
							jtextInfo = jtextInfo.substring(0, jtextInfo.length() - 1) + "/";
						}
						else
							jtextInfo = "/";
					}
				}
				jtext.setText(jtextInfo);
			}	
		});
		
		// *��
		buttons[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
					if(position != 0) {			//һ����������������Ƚ��м���
						jtextInfo = result() + '*';
						position = 0;			//���Ϊ0��֪����һ����������+����
					}
					else {
						//���һλ��Ϊ�����,׷��/
						if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
							jtextInfo += '*';
						}
						//���һλΪ���������ʱ��δ�������֣�����positionΪ0,��׷��
						else {
							//�ı����һλ
							if(jtextInfo.length() > 1) {
								jtextInfo = jtextInfo.substring(0, jtextInfo.length() - 1) + "*";
							}
							else
								jtextInfo = "*";
						}
					}
					jtext.setText(jtextInfo);
			}	
		});		
		
		// -��
		buttons[13].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
					if(position != 0) {			//һ����������������Ƚ��м���
						jtextInfo = result() + '-';
						position = 0;			//���Ϊ0��֪����һ����������+����
					}
					else {
						//���һλ��Ϊ�����,׷��/
						if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
							jtextInfo += '-';
						}
						//���һλΪ���������ʱ��δ�������֣�����positionΪ0,��׷��
						else {
							//�ı����һλ
							if(jtextInfo.length() > 1) {
								jtextInfo = jtextInfo.substring(0, jtextInfo.length() - 1) + "-";
							}
							else
								jtextInfo = "-";
						}
					}
					jtext.setText(jtextInfo);
			}	
		});
		
		// +��
		buttons[18].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
					if(position != 0) {			//һ����������������Ƚ��м���
						jtextInfo = result() + '+';
						position = 0;			//���Ϊ0��֪����һ����������+����
					}
					else {
						//���һλ��Ϊ�����,׷��/
						if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
							jtextInfo += '+';
						}
						//���һλΪ���������ʱ��δ�������֣�����positionΪ0,��׷��
						else {
							//�ı����һλ
							if(jtextInfo.length() > 1) {
								jtextInfo = jtextInfo.substring(0, jtextInfo.length() - 1) + "+";
							}
							else
								jtextInfo = "+";
						}
					}
					jtext.setText(jtextInfo);
			}	
		});
		
		// %
		buttons[9].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position != 0) {			//һ����������������Ƚ��м���
					jtextInfo = result() + '%';
					position = 0;			//���Ϊ0��֪����һ����������+����
				}
				else {
					//���һλ��Ϊ�����,׷��/
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
						jtextInfo += '%';
					}
					//���һλΪ���������ʱ��δ�������֣�����positionΪ0,��׷��,���Ըı����
					else {
						//�ı����һλ
						if(jtextInfo.length() > 1) {
							jtextInfo = jtextInfo.substring(0, jtextInfo.length() - 1) + "%";
						}
						else
							jtextInfo = "%";
					}
				}
				jtext.setText(jtextInfo);
			}	
		});

		// sqrt
		buttons[4].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position == 0 && temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		//ʽ�����޷���ʱ�ſ�ʹ��
					jtextInfo = String.valueOf(Math.sqrt(Double.parseDouble(jtextInfo)));
				}
				jtext.setText(jtextInfo);
			}
		});

		// 1/x
		buttons[14].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position == 0 && temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		//ʽ�����޷���ʱ�ſ�ʹ��
					jtextInfo = String.valueOf(1 / Double.parseDouble(jtextInfo));
				}
				jtext.setText(jtextInfo);
			}
		});
		
		// =
		buttons[19].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
					if(position != 0) {			//һ����������������Ƚ��м���
						jtextInfo = result();
						position = 0;			//���Ϊ0��֪����һ����������+����
					}
					else {
						//���һλ��Ϊ�����,׷��/
						if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
							//������
						}
						//���һλΪ���������ʱ��δ�������֣�����positionΪ0,ȥ���������
						else {
							jtextInfo = jtextInfo.substring(0, jtextInfo.length() - 1);
						}
					}
					symbal = 'x';
					jtext.setText(jtextInfo);
				}
		});

		// +-
		buttons[16].addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				//��positionλ�õ�ĿǰΪֹ���������ָı䷽��
				if(position != 0) {		//ʽ�ӷ�Ϊ�����֣�ֻ�ı��벿��
					String end = String.valueOf(0 - Double.parseDouble(jtextInfo.substring(position, jtextInfo.length())));
					String start = jtextInfo.substring(0, position - 1);
					jtextInfo = start + symbal + end;
				}
				else {		
					//���һλ��Ϊ�����,�����ַ�
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
						jtextInfo = String.valueOf(0 - Double.parseDouble(jtextInfo));
					}
					//���һλΪ���������ʱ��δ�������֣�����positionΪ0,���ı�
					else {
						//������
					}
				}
				jtext.setText(jtextInfo);
			}
		});
		
		// .
		buttons[17].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position != 0) {		//ʽ�ӷ�Ϊ�����֣�ֻ�ı��벿��
					String end = jtextInfo.substring(position, jtextInfo.length());
					String start = jtextInfo.substring(0, position - 1);
					if(end.indexOf(".") == -1) {
						jtextInfo = start + symbal + end + '.';
					}
					else{
						//������
					}
				}
				else {		
					//���һλ��Ϊ�����,�����ַ�
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {	
						if(jtextInfo.indexOf(".") == -1)
							jtextInfo += '.';
					}
					//���һλΪ���������ʱ��δ�������֣�����positionΪ0,���ı�
					else {
						//������
					}
				}
				jtext.setText(jtextInfo);
			}
		});
		
		for(int i = 0; i < 20; i++) {
			end_right.add(buttons[i]);
		}
		return end_right;
	}
	
	
	private String result() {
		double result_end = 0;
		double first = Double.parseDouble(jtextInfo.substring(0, position - 1));
		double end = Double.parseDouble(jtextInfo.substring(position, jtextInfo.length()));
		switch (symbal) {
		case '+':
			result_end = first + end;
			break;
		case '-':
			result_end = first - end;
			break;
		case '*':
			result_end = first * end;
			break;
		case '/':
			result_end = first / end;
			break;
		case '%':
			result_end = first % end;
			break;
		default:
			break;
		}
		return "" + result_end;
	}
	
}
