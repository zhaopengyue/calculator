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
		// TODO 自动生成的方法存根
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
		// TODO 自动生成的方法存根
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
				// TODO 自动生成的方法存根
				
			}
		});
		//BACKSPACE事件
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
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
				// TODO 自动生成的方法存根
				//CE事件
			}
		});
		
		//C事件
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//C事件
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
		// TODO 自动生成的方法存根
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
				// TODO 自动生成的方法存根
				//MC事件
			}
		});
		
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//MR事件
			}
		});
		
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//MS事件
			}
		});
		
		buttons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//M+事件
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
		
		//向数字追加事件
		for(int i= 0; i< 10; i++) {
			buttons[((i / 3) * 5 + (i % 3))].addActionListener(new ActionListener() {
				private JButton button;
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);		//获取最后一个字符
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		//最后一个字符不是运算符
						if(temp_end == '0' && position == 0 && Double.parseDouble(jtextInfo) == 0) {			//field中只有0，此时直接覆盖不进行追加
							jtextInfo = button.getText();
						}
						//不只有0时进行追加
						else{
							if(symbal != 'x')		//计算器未按=
								jtextInfo += button.getText();
							else{
								jtextInfo = button.getText();
								symbal = ' ';
							}
						}
					}
					//最后一位为运算符时，对符号信息进行标记并追加数字
					else {
						//防止除0
						if(temp_end == '/' && button.getText() == "0") {
							//不改变值
						}
						//追加值
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
		
		// /号
		buttons[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position != 0) {			//一定存在运算符，则先进行计算
					jtextInfo = result() + '/';
					position = 0;			//标记为0，知道下一次遇到符号+数字
				}
				else {
					//最后一位不为运算符,追加/
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
						jtextInfo += '/';
					}
					//最后一位为运算符，此时还未输入数字，故其position为0,不追加
					else {
						//改变最后一位
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
		
		// *号
		buttons[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
					if(position != 0) {			//一定存在运算符，则先进行计算
						jtextInfo = result() + '*';
						position = 0;			//标记为0，知道下一次遇到符号+数字
					}
					else {
						//最后一位不为运算符,追加/
						if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
							jtextInfo += '*';
						}
						//最后一位为运算符，此时还未输入数字，故其position为0,不追加
						else {
							//改变最后一位
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
		
		// -号
		buttons[13].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
					if(position != 0) {			//一定存在运算符，则先进行计算
						jtextInfo = result() + '-';
						position = 0;			//标记为0，知道下一次遇到符号+数字
					}
					else {
						//最后一位不为运算符,追加/
						if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
							jtextInfo += '-';
						}
						//最后一位为运算符，此时还未输入数字，故其position为0,不追加
						else {
							//改变最后一位
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
		
		// +号
		buttons[18].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
					if(position != 0) {			//一定存在运算符，则先进行计算
						jtextInfo = result() + '+';
						position = 0;			//标记为0，知道下一次遇到符号+数字
					}
					else {
						//最后一位不为运算符,追加/
						if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
							jtextInfo += '+';
						}
						//最后一位为运算符，此时还未输入数字，故其position为0,不追加
						else {
							//改变最后一位
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
				if(position != 0) {			//一定存在运算符，则先进行计算
					jtextInfo = result() + '%';
					position = 0;			//标记为0，知道下一次遇到符号+数字
				}
				else {
					//最后一位不为运算符,追加/
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
						jtextInfo += '%';
					}
					//最后一位为运算符，此时还未输入数字，故其position为0,不追加,可以改变符号
					else {
						//改变最后一位
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
				// TODO 自动生成的方法存根
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position == 0 && temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		//式子中无符号时才可使用
					jtextInfo = String.valueOf(Math.sqrt(Double.parseDouble(jtextInfo)));
				}
				jtext.setText(jtextInfo);
			}
		});

		// 1/x
		buttons[14].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position == 0 && temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		//式子中无符号时才可使用
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
					if(position != 0) {			//一定存在运算符，则先进行计算
						jtextInfo = result();
						position = 0;			//标记为0，知道下一次遇到符号+数字
					}
					else {
						//最后一位不为运算符,追加/
						if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
							//不处理
						}
						//最后一位为运算符，此时还未输入数字，故其position为0,去掉符号输出
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
				// TODO 自动生成的方法存根
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				//将position位置到目前为止的所有数字改变方向
				if(position != 0) {		//式子分为两部分，只改变后半部分
					String end = String.valueOf(0 - Double.parseDouble(jtextInfo.substring(position, jtextInfo.length())));
					String start = jtextInfo.substring(0, position - 1);
					jtextInfo = start + symbal + end;
				}
				else {		
					//最后一位不为运算符,处理字符
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {		
						jtextInfo = String.valueOf(0 - Double.parseDouble(jtextInfo));
					}
					//最后一位为运算符，此时还未输入数字，故其position为0,不改变
					else {
						//不处理
					}
				}
				jtext.setText(jtextInfo);
			}
		});
		
		// .
		buttons[17].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				char temp_end = jtextInfo.charAt(jtextInfo.length() - 1);
				if(position != 0) {		//式子分为两部分，只改变后半部分
					String end = jtextInfo.substring(position, jtextInfo.length());
					String start = jtextInfo.substring(0, position - 1);
					if(end.indexOf(".") == -1) {
						jtextInfo = start + symbal + end + '.';
					}
					else{
						//不操作
					}
				}
				else {		
					//最后一位不为运算符,处理字符
					if(temp_end != '+' && temp_end != '-' && temp_end != '*' && temp_end != '/' && temp_end != '%') {	
						if(jtextInfo.indexOf(".") == -1)
							jtextInfo += '.';
					}
					//最后一位为运算符，此时还未输入数字，故其position为0,不改变
					else {
						//不处理
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
