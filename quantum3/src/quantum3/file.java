package quantum3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class file extends QMain {
	private JTextArea textAreaInfo1 = new JTextArea();
	private JTextField fieldName1 = new JTextField(),fieldPassword1 = new JTextField();
	private JLabel appName = new JLabel("FileManager - "+helperName),buttonDevice1 = new JLabel(),labelInfo1 = new JLabel(),labelPassword1 = new JLabel(),labelName1 = new JLabel();
	private JButton next1 = new JButton("Next"),back1 = new JButton("Back");
	int green = 0,locationX1=0,locationY1=0;
	private JPanel panel1a = new JPanel();
	
	public static Color color_panel1a = new Color(0,0,0),color_panelMainF = new Color(0,0,0), color_panelBuffer = new Color(0,0,0),color_panel2 = new Color(0,0,0);  
	protected void button1(JButton button) {
		button.setForeground(new Color(200,200,200));
		button.setFocusPainted(false);
		button.setBorderPainted(false);	
		button.setContentAreaFilled(false);
	}
	protected void button2(JButton b) {
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
	protected void label3(JLabel b) {
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
	protected void label1(JLabel l) {
		l.setForeground(new Color(200,200,200));
	}
	protected void textField(JTextField field) {
		field.setBackground(new Color(30,30,30));
		field.setForeground(new Color(180,180,180));
		field.setFont(new Font("one",Font.PLAIN,15));
	}
	
	public static int xA = 0,yA = 0,xB = 0,yB = 0,location_X= -1,location_Y = -1;
	public file() {
		if(settingTf != true) {
		appName.setForeground(new Color(170,230,170));
		appName.setFont(new Font("one",Font.PLAIN,10));
		buttonDevice1.setFont(new Font("one",Font.PLAIN,14));
		textAreaInfo1.setFont(new Font("one",Font.PLAIN,16));

		textAreaInfo1.setBackground(new Color(30,30,30));
		textAreaInfo1.setForeground(new Color(190,190,190));
		textAreaInfo1.setWrapStyleWord(true);
		textAreaInfo1.setLineWrap(true);
		textAreaInfo1.setEditable(false);
		
		panel1a.setBackground(new Color(150,150,150));
		panelFileBuffer.setBackground(new Color(30,30,30));
		panelFileMainF.setBackground(new Color(30,30,30));
		panelFile2.setBackground(new Color(50,50,50));
		
		panelFileFile.setBackground(new Color(200,200,200));
		panelOther.setBackground(new Color(200,200,200));
		panelMovie.setBackground(new Color(200,200,200));
		
		panel1a.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		label1(labelName1);
		label1(labelPassword1);
		label1(labelInfo1);
		textField(fieldName1);
		textField(fieldPassword1);
		button1(next1);
		button2(back1);
		button1(back1);
		button2(next1);
		label1(buttonDevice1);
		label3(buttonDevice1);
		label1(nameLabel);
		
		appName.setBounds(5,0,100,25);
		textAreaInfo1.setBounds(1000,0,0,0);
		panel1a.setBounds((int)-1,(int)-1,900,600);
		panelFileMainF.setBounds((panel1a.getWidth()-4)/4,25,(int)(panel1a.getWidth()-4)*3/4-2,(int)panel1a.getHeight()-30);
		panelFileBuffer.setBounds(2,25,(int)(panel1a.getWidth()-4)/4-4,(int)panel1a.getHeight()-30);
		panelFile2.setBounds(2,2,(int)panel1a.getWidth()-4-2,(int)panel1a.getHeight()-4);
		
		panelMovie.setBounds(3,3,panelFileMainF.getWidth()-5,panelFileMainF.getHeight()/3-53);
		panelOther.setBounds(3,3+panelFileMainF.getHeight()/3-50,panelFileMainF.getWidth()-5,panelFileMainF.getHeight()/3-3-70);
		panelFileFile.setBounds(3,panelFileMainF.getHeight()/3*2+3-120,panelFileMainF.getWidth()-5,panelFileMainF.getHeight()/3-3+120);
		
		panel1a.setLayout(new GridLayout(1,1));
		panelFile2.setLayout(null);
		panelFileMainF.setLayout(null);
		panelFileBuffer.setLayout(null);
		panelFileFile.setLayout(new  GridLayout());
		panelMovie.setLayout(null);
		panelFileFile.setLayout(null);
		
		panelFileMainF.add(panelMovie);
		panelFileMainF.add(panelOther);
		panelFileMainF.add(panelFileFile);
		
		panelFile2.add(appName);
		panelFile2.add(labelPassword1);
		panelFile2.add(labelName1);
		panelFile2.add(fieldName1);
		panelFile2.add(fieldPassword1);
		panelFile2.add(next1);
		panelFile2.add(back1);
		panelFile2.add(labelInfo1);
		panelFile2.add(buttonDevice1);
		panelFile2.add(textAreaInfo1);
		panelFile2.add(panelFileBuffer);
		panelFile2.add(panelFileMainF);
		panel1a.add(panelFile2);
		panelContent.add(panel1a);
		
		appName.setForeground(new Color(170,170,170));
		
		panelContent.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				panelMainFSize();
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		
		panelFile2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				locationX1 = e.getX();
				locationY1 = e.getY();
			}
			public void mouseReleased(MouseEvent e) {
				panelMainFSize();
				panel1a.setBackground(new Color(150,150,150));
			}
			public void mouseEntered(MouseEvent e) {
				locationX1 = e.getX();
				locationY1 = e.getY();
				panelMainFSize();
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		panelFile2.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				int x = locationX1;
				int y = locationY1;
				int x1 =(int)(MouseInfo.getPointerInfo().getLocation().getX()-frameMain.getLocationOnScreen().getX()-x);
				int y1 =(int)(MouseInfo.getPointerInfo().getLocation().getY()-frameMain.getLocationOnScreen().getY()-y-27);
				panel1a.setLocation(x1,y1);
				location_X = panel1a.getX();
				location_Y = panel1a.getY();
				if(panel1a.getX()>=(panelContent.getWidth()-50)||panel1a.getY()>=(panelContent.getHeight()-50)) {
					panel1a.setBackground(new Color(150,200,150));
				}else if((panel1a.getX()+panel1a.getWidth())<=50||(panel1a.getY()+panel1a.getHeight())<=50) {
					panel1a.setBackground(new Color(150,200,150));
				}else if(panel1a.getX()>=-50&&panel1a.getX()<=0&&panel1a.getY()<=0&&panel1a.getY()>=-50) {
					panel1a.setBackground(new Color(230,230,230));
				}else {
					panel1a.setBackground(new Color(150,150,150));
				}
				panelFile2.setBounds(2,2,(int)panel1a.getWidth()-4,(int)panel1a.getHeight()-4);
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		appName.setText("FileManager - "+helperName);
		panelMainFSize();
		resize.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				greatChange();
				panelMainFSize();
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				panelMainFSize();
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		mouseResize m1 = new mouseResize();
		panelMain.addMouseListener(m1);
		
		}
	}
	
	class mouseResize implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			panelMainFSize();
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	
	int i = 10;
	protected void panelMainFSize() {
		panel1a.setBounds((int)location_X,(int)location_Y,panelContent.getWidth(),panelContent.getHeight());
		if(panel1a.getX()>=(panelContent.getWidth()-50)||panel1a.getY()>=(panelContent.getHeight()-50)) {
			panel1a.setBounds((int)-1,(int)0,panelContent.getWidth(),panelContent.getHeight());
			location_X = 0;
			location_Y = 0;
			panelFileMainF.setBounds((panel1a.getWidth()-4)/4,25,(int)(panel1a.getWidth()-4)*3/4-2,(int)panel1a.getHeight()-30);
			panelFileBuffer.setBounds(2,25,(int)(panel1a.getWidth()-4)/4-4,(int)panel1a.getHeight()-30);
		}else if((panel1a.getX()+panel1a.getWidth())<=50||(panel1a.getY()+panel1a.getHeight())<=50) {
			panel1a.setBounds((int)-1,(int)0,panelContent.getWidth(),panelContent.getHeight());
			location_X = 0;
			location_Y = 0;
			panelFileMainF.setBounds((panel1a.getWidth()-4)/4,25,(int)(panel1a.getWidth()-4)*3/4-2,(int)panel1a.getHeight()-30);
			panelFileBuffer.setBounds(2,25,(int)(panel1a.getWidth()-4)/4-4,(int)panel1a.getHeight()-30);
		}else if(panel1a.getX()>=-50&&panel1a.getX()<=0&&panel1a.getY()<=0&&panel1a.getY()>=-50 ) {
			panel1a.setBounds((int)-1,(int)0,panelContent.getWidth(),panelContent.getHeight());
			location_X = 0;
			location_Y = 0;
			panelFileMainF.setBounds((panel1a.getWidth()-4)/4,25,(int)(panel1a.getWidth()-4)*3/4-2,(int)panel1a.getHeight()-30);
			panelFileBuffer.setBounds(2,25,(int)(panel1a.getWidth()-4)/4-4,(int)panel1a.getHeight()-30);
		}else {
			panelFileMainF.setBounds((panel1a.getWidth()-4)/4,25,(int)(panel1a.getWidth()-4)*3/4-2,(int)panel1a.getHeight()-30);
			panelFileBuffer.setBounds(2,25,(int)(panel1a.getWidth()-4)/4-4,(int)panel1a.getHeight()-30);
		}
		panelFile2.setBounds(2,2,(int)panel1a.getWidth()-4,(int)panel1a.getHeight()-4);
		panelMovie.setBounds(0,0,panelFileMainF.getWidth(),panelFileMainF.getHeight()/3-50);
		panelOther.setBounds(0,0+panelFileMainF.getHeight()/3-50,panelFileMainF.getWidth(),panelFileMainF.getHeight()/3-70);
		panelFileFile.setBounds(0,panelFileMainF.getHeight()/3*2-120,panelFileMainF.getWidth(),panelFileMainF.getHeight()/3+120);
		panelFileChar.setBounds(panelFileFile.getWidth()*2/3-50,1,panelFileFile.getWidth()*1/3+50,panelFileFile.getHeight()-3);
		panelFileChar1.setBounds(2,23,panelFileChar.getWidth()-4,panelFileChar.getHeight()-50);
		if(frameMain.getWidth() == 900) {
		fieldChar.setBounds(188,1,panelFileChar.getWidth()/3-10,20);
		buttonB.setBounds(0,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
		numberOfFile.setBounds(panelFileChar.getWidth()/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3-10,20);
		buttonN.setBounds(panelFileChar.getWidth()*2/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
		}else {
			fieldChar.setBounds(188,1,panelFileChar.getWidth()/3+20,20);
			buttonB.setBounds(0,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
			numberOfFile.setBounds(panelFileChar.getWidth()/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3+20,20);
			buttonN.setBounds(panelFileChar.getWidth()*2/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
		}
		}
	protected void greatChange() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		if(frameMain.getLocationOnScreen().getX() <= 0&&frameMain.getLocationOnScreen().getY()<=0) {
			frameMain.setLocation(0,0);
			int X = (int)(dimension.getWidth()-900);
			int Y = (int)(dimension.getHeight()-600);
			int X1 = (int)(dimension.getWidth()-900)/2;
			int Y1 = (int)(dimension.getHeight()-600)/2;
			if(panelContent.getBounds().x > 0 ) {
				panelContent.setBounds((int)dimension.getWidth(),25,900+X,545+Y);
			}else {
				panelContent.setBounds(0,25,900+X,545+Y);
			}
			frameMain.setVisible(false);
			close.setBounds(860+X,0,50,25);
			small.setBounds(810+X,0,50,25);
			search.setBounds(650+X1,575+Y,100,20);
			searchField.setBounds(250+X1,575+Y,390,20);
			type.setBounds(140+X1,575+Y,100,20);
			resize.setBounds(0,575+Y,100,20);
			fieldChar.setBounds(188,1,panelFileChar.getWidth()/3+20,20);
			buttonB.setBounds(0,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
			numberOfFile.setBounds(panelFileChar.getWidth()/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
			buttonN.setBounds(panelFileChar.getWidth()*2/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
			if(lockTF) {
			password.setBounds(350+X1,350+Y1,200,24);
			}
			frameMain.setSize((int)dimension.getWidth(),(int)dimension.getHeight());
		}else if(frameMain.getSize().getWidth() == dimension.getWidth()&&frameMain.getSize().getHeight()==dimension.getHeight()) {
			int locationX = (int)(dimension.getWidth()/2-frameMain.getWidth()/2);
			int locationY = (int)(dimension.getHeight()/2-frameMain.getHeight()/2);
		
			if(panelContent.getBounds().x > 0 ) {
				panelContent.setBounds((int)dimension.getWidth(),25,900,545);
			}else {
				panelContent.setBounds(0,25,900,545);
			}
			close.setBounds(860,0,50,25);
			small.setBounds(810,0,50,25);
			search.setBounds(650,575,100,20);
			searchField.setBounds(250,575,390,20);
			type.setBounds(140,575,100,20);
			resize.setBounds(0,575,100,20);
			fieldChar.setBounds(188,1,panelFileChar.getWidth()/3-10,20);
			buttonB.setBounds(0,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
			numberOfFile.setBounds(panelFileChar.getWidth()/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
			buttonN.setBounds(panelFileChar.getWidth()*2/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
			if(lockTF) {
				password.setBounds(350,350,200,24);
			}
			frameMain.setSize(900,600);
			frameMain.setLocation(locationX,locationY);
		}
		frameMain.setVisible(false);
		frameMain.setVisible(true);
	}
	protected void labelRed(JLabel label) {
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
					timeTimer.purge();
					i = 10;
				}
			}
		},500*1,500*1);
		}
	}		
}
