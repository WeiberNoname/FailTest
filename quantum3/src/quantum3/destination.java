package quantum3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
//Translator translate = Translator.getInstance();
//String text = translate.translate("Hello!", Language.ENGLISH, Language.HINDI);
//System.out.println(text); // "नमस्ते" 

public class destination extends QMain{
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JButton name = new JButton("Clone Data Conservader");
	private JButton getIn = new JButton("Follow My Command");
	private JButton close1 = new JButton("x");
	private JLabel appName = new JLabel("Legendary");
	int green = 0,locationX1=0,locationY1=0;
	public void button1(JButton button) {
		button.setForeground(new Color(200,200,200));
		button.setFocusPainted(false);
		button.setBorderPainted(false);	
		button.setContentAreaFilled(false);
	}
	public void button2(JButton b) {
		b.addMouseListener(new MouseListener() {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			b.setFont(new Font("one",Font.PLAIN,19));	
		}
		public void mouseExited(MouseEvent e) {
			b.setFont(new Font("one",Font.PLAIN,17));	
		}
		});
	}
	public void label3(JLabel b) {
		b.addMouseListener(new MouseListener() {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			b.setFont(new Font("one",Font.PLAIN,15));	
		}
		public void mouseExited(MouseEvent e) {
			b.setFont(new Font("one",Font.PLAIN,14));	
		}
		});
	}
	public void bounds(JPanel p,Graphics g) {
		Rectangle bound = p.getBounds();
		Random random = new Random();
		int red = p.getBackground().getRed();
		int green = p.getBackground().getGreen();
		int blue = p.getBackground().getBlue();
		for(int i = 0;i < 350;i++) {
			g.setColor(new Color(red,green,blue));
			g.drawLine(0,i,p.getWidth(),i);
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
		}
	}
	public void label1(JLabel l) {
		l.setForeground(new Color(200,200,200));
		getIn.setFont(new Font("one",Font.PLAIN,16));
	}
	public void textField(JTextField field) {
		field.setBackground(new Color(30,30,30));
		field.setForeground(new Color(180,180,180));
		field.setFont(new Font("one",Font.PLAIN,15));
	}
	public void create() {
		name.setBounds(1000,125,300,30);
		getIn.setBounds(1000,195,300,30);
		close1.setBounds(4050,0,50,25);
		appName.setBounds(5000,0,100,25);
		next.setFont(new Font("one",Font.PLAIN,17));	
		back.setFont(new Font("one",Font.PLAIN,17));	
		labelName.setFont(new Font("one",Font.PLAIN,19));	
		labelPassword.setFont(new Font("one",Font.PLAIN,19));	
		labelName.setBounds(50,100,200,20);
		labelPassword.setBounds(50,160,150,20);
		fieldName.setBounds(280,100,160,25);
		fieldPassword.setBounds(280,160,160,25);
		back.setBounds(0,320,100,20);
		next.setBounds(390,320,100,20);
		labelInfo.setBounds(50,240,380,20);
		buttonDevice.setBounds(50,35,380,20);
		textAreaInfo.setBounds(1000,0,0,0);
	}
	public void getIn1() {
		name.setBounds(1000,125,300,30);
		getIn.setBounds(1000,195,300,30);
		close1.setBounds(4050,0,50,25);
		appName.setBounds(5000,0,100,25);
		next.setFont(new Font("one",Font.PLAIN,17));	
		back.setFont(new Font("one",Font.PLAIN,17));	
		labelName.setFont(new Font("one",Font.PLAIN,19));	
		labelPassword.setFont(new Font("one",Font.PLAIN,19));	
		labelName.setBounds(50,100,200,20);
		labelPassword.setBounds(50,160,150,20);
		fieldName.setBounds(280,100,160,25);
		fieldPassword.setBounds(280,160,160,25);
		back.setBounds(0,320,100,20);
		next.setBounds(390,320,100,20);
		labelInfo.setBounds(50,240,380,20);
		buttonDevice.setBounds(50,35,380,20);
		textAreaInfo.setBounds(1000,0,0,0);
	}
	public void back() {
		name.setBounds(100,125,300,30);
		getIn.setBounds(100,195,300,30);
		close1.setBounds(450,0,50,25);
		appName.setBounds(5,0,100,25);
		labelName.setBounds(50,1000,100,20);
		labelPassword.setBounds(50,1500,100,20);
		fieldName.setBounds(170,1000,100,20);
		fieldPassword.setBounds(170,1500,100,20);
		back.setBounds(1000,320,100,20);
		next.setBounds(3190,320,100,20);
		labelInfo.setBounds(1330,240,230,20);
		buttonDevice.setBounds(1150,240,300,20);
		textAreaInfo.setBounds(1000,0,0,0);
		helperName = "";
		passwordA = "";
	}
	public void afterCreate() {
		name.setBounds(1000,125,300,30);
		getIn.setBounds(1000,195,300,30);
		close1.setBounds(450,0,50,25);
		appName.setBounds(1000,0,100,25);
		labelName.setBounds(1150,1000,100,20);
		labelPassword.setBounds(50,1500,100,20);
		fieldName.setBounds(1170,1000,100,20);
		fieldPassword.setBounds(1170,1500,100,20);
		back.setBounds(0,320,100,20);
		next.setBounds(390,320,100,20);
		labelInfo.setBounds(1330,240,230,20);
		buttonDevice.setBounds(1150,240,300,20);
		textAreaInfo.setBounds(50,20,400,300);
		helperName = fieldName.getText();
		passwordA = fieldName.getText();
		textAreaInfo.setText("This application was made from Java program, thanks to the developer of Java programmer, to make up such a strong application function, this could provide more facility ways to fix the problem, the word I use in the app name is the helper manager short, you don't need anyone to help you to accomplish the project anymore, welcome home commander."+"\n\n\nConservader : "+helperName+"\n\nTime : "+LocalTime.now());
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(helperName.length()>0) {
				frame.dispose();
				new QMainSetUp();
				new setting();
				new file();
				new fileChar();
				settingTf = true;
				}
			}
		});
	}
	
	public static int xA = 0,yA = 0,xB = 0,yB = 0;
	public destination() {
		frame.setUndecorated(true);
		new loginOut();
		button1(name);
		button1(close1);
		button1(getIn);
		
		appName.setForeground(new Color(170,230,170));
		
		appName.setFont(new Font("one",Font.PLAIN,15));
		name.setFont(new Font("one",Font.PLAIN,17));
		close1.setFont(new Font("one",Font.PLAIN,19));
		getIn.setFont(new Font("one",Font.PLAIN,17));
		buttonDevice.setFont(new Font("one",Font.PLAIN,14));
		textAreaInfo.setFont(new Font("one",Font.PLAIN,16));

		textAreaInfo.setBackground(new Color(30,30,30));
		textAreaInfo.setForeground(new Color(190,190,190));
		textAreaInfo.setWrapStyleWord(true);
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setEditable(false);
		
		panel1.setBackground(new Color(150,150,150));
		panel2.setBackground(new Color(30,30,30));
		panel1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		label1(labelName);
		label1(labelPassword);
		label1(labelInfo);
		textField(fieldName);
		textField(fieldPassword);
		button1(next);
		button2(back);
		button1(back);
		button2(next);
		label1(buttonDevice);
		label3(buttonDevice);
		label1(nameLabel);
		
		name.setBounds(100,125,300,30);
		getIn.setBounds(100,195,300,30);
		close1.setBounds(450,0,50,25);
		appName.setBounds(5,0,100,25);
		panel2.setBounds(2,2,496,346);
		textAreaInfo.setBounds(1000,0,0,0);
		nameLabel.setBounds(5000,10000,380,25);
		
		frame.setLayout(new GridLayout(1,1));
		panel1.setLayout(null);
		panel2.setLayout(null);
		
		panel2.add(name);
		panel2.add(getIn);
		panel2.add(close1);
		panel2.add(appName);
		
		panel2.add(labelPassword);
		panel2.add(labelName);
		panel2.add(fieldName);
		panel2.add(fieldPassword);
		panel2.add(next);
		panel2.add(back);
		panel2.add(labelInfo);
		panel2.add(buttonDevice);
		panelMain.add(nameLabel);
		panel2.add(textAreaInfo);
		
		panel1.add(panel2);
		frame.add(panel1);
		frame.pack();
		frame.setSize(500,350);
		Dimension dimension1 = Toolkit.getDefaultToolkit().getScreenSize();
		int locationX = (int)(dimension1.getWidth()/2-frame.getWidth()/2);
		int locationY = (int)(dimension1.getHeight()/2-frame.getHeight()/2);
		frame.setLocation(locationX,locationY);
		frame.setVisible(true);
		
		button2(name);
		button2(getIn);
		
		Timer timer3 = new Timer();
		timer3.schedule(new TimerTask() {
			public void run() {
			if(green == 255) {
			 green = 0;
			}
			appName.setForeground(new Color(170,green,170));
			green +=1;
			}
		},50*1,50*1);
		
		close1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				timer3.cancel();
				timer3.purge();
			}
		});
	
		panel2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				locationX1 = e.getX();
				locationY1 = e.getY();
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		panel2.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				int x = locationX1;
				int y = locationY1;
				int x1 =(int)MouseInfo.getPointerInfo().getLocation().getX()-x;
				int y1 =(int)MouseInfo.getPointerInfo().getLocation().getY()-y;
				frame.setLocation(x1,y1);
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
				typeOfFrame = "C";
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonDevice.setText("Device Clone Conservader Location : Device ");
				fieldPassword.setText("");
				fieldName.setText("");
				fileDevice = new File("");
				right = 0;
				passwordA = "";
				destinationPath = "";
				labelInfo.setText("");
				back();
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = "";
				if(typeOfFrame.equals("C")) {
				if(fieldName.getText().length() == 0) {
					info +="Name Error";
				}else {
					right += 1;
				}
				if(fieldPassword.getText().length() == 0) {
					info +=" "+"Password Error";
				}else {
					right +=1;
				}
				if(buttonDevice.getText().indexOf("\\Conservader")==-1) {
					info +=" "+"Device Location Error";
					labelRed(buttonDevice);
				}else {
					right +=1;
				}
				String device = fileDevice+"Conservader1"+"\\";
				File file = new File(device+fieldName.getText()+".txt");
				if(right == 3&&!file.exists()) {
					afterCreate();
				}else {
					right = 0;
				}
				labelInfo.setText(info);
				if(file.exists()) {
					fieldName.setText("");
					labelInfo.setText("Already created");
				}
				info = "";
				}
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeOfFrame.equals("G")) {
					new subLogin();
				}
			}
		});
		getIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getIn1();
				typeOfFrame = "G";
			}
		});
	}
	int i = 10;
	
	public void labelRed(JLabel label) {
		if(i == 10) {
		timeTimer = new Timer();
		timeTimer.schedule(new TimerTask() {
			public void run() {
				if(label.getForeground().getGreen() == 200) {
					label.setForeground(new Color(190,50,50));
				}else{
					label.setForeground(new Color(200,200,200));
				}
				i -= 1;
				if(i < 0) {
					label.setForeground(new Color(200,200,200));
					cancel();
					i = 10;
				}
			}
		},500*1,500*1);
		}
	}
	
}
