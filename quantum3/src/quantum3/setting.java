package quantum3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class setting extends QMain{
	
	private JTextArea textAreaInfo1 = new JTextArea();
	private JPanel panel2 = new JPanel();
	private JPanel panel1a = new JPanel();
	private JButton close1 = new JButton("x");
	private JButton next1 = new JButton("Next");
	private JLabel appName = new JLabel("System"),buttonDevice1 = new JLabel(),labelInfo1 = new JLabel(),labelPassword1 = new JLabel(),labelName1 = new JLabel("Setting Color");

	private JPanel panelColor = new JPanel();
	private JPanel panelR = new JPanel(),panelG = new JPanel(),panelB = new JPanel();
	private JLabel labelR = new JLabel("Red(0)"),labelG = new JLabel("Green(0)"),labelB = new JLabel("Blue(0)"),component = new JLabel("Click here");
	
	private JPanel[] panelColorA = new JPanel[20];
	
	int green = 0,locationX1=0,locationY1=0;
	private String type = "";
	protected void initial_color() {
		if(!colorString.equals("")) {
		String color = "";
		int r = 0,g = 0,b = 0;
		for(int i = 0; i < panelColorA.length;i++) {
			if(panelColorA[i] == null) {
			}else {
			color = colorString.substring(0,colorString.indexOf("/"));
			colorString = colorString.substring(colorString.indexOf("/")+1);
				for(int ii = 0; ii <3;ii++) {
					if(ii == 0) {
						r = Integer.parseInt(color.substring(0,color.indexOf(",")));
						color = color.substring(color.indexOf(",")+1);
					}else if(ii == 1) {
						g = Integer.parseInt(color.substring(0,color.indexOf(",")));
						color = color.substring(color.indexOf(",")+1);
					}else if(ii == 2) {
						b = Integer.parseInt(color.substring(0));
					}
				}
				panelColorA[i].setBackground(new Color(r,g,b));
			}
		}
		}
	}
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
	protected void p(JPanel p) {
		p.setBackground(new Color(50,50,50));
		p.setLayout(new GridLayout(1,1));
	}
	protected void b(JButton b) {
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
		button2(b);
		b.setForeground(new Color(200,200,200));
	}
	public void l(JLabel  l) {
		l.setFont(new Font("one",Font.PLAIN,17));
		l.setForeground(new Color(190,190,190));
	}
	public void blackL(JLabel l) {
		l.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				l.setForeground(new Color(20,20,20));
			}
			public void mouseExited(MouseEvent e) {
				l.setForeground(new Color(190,190,190));
			}
		});
	}
	boolean colorTF = false;
	public static int xA = 0,yA = 0,xB = 0,yB = 0,colorNumber = 0;
	public setting() {
		panelContent.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		if(settingTf != true) {
		button1(close1);
		//panelColor
		panelColorA[0] = panelRoot;
		panelColorA[1] = panelMain;
		panelColorA[2] = panelContent;
		panelColorA[3] = panelFileMainF;
		panelColorA[4] = panelFileBuffer;
		panelColorA[5] = panelFile2;
		panelColorA[6] = panelFileFile;
		panelColorA[7] = panelOther;
		panelColorA[8] = panelMovie;
		
		
		appName.setForeground(new Color(170,230,170));
		
		appName.setFont(new Font("one",Font.PLAIN,15));
		close1.setFont(new Font("one",Font.PLAIN,19));
		buttonDevice1.setFont(new Font("one",Font.PLAIN,14));
		textAreaInfo1.setFont(new Font("one",Font.PLAIN,16));
		
		panelR.setBackground(new Color(170,80,80));
		panelG.setBackground(new Color(80,170,80));
		panelB.setBackground(new Color(80,80,170));
		
		textAreaInfo1.setBackground(new Color(30,30,30));
		panelColor.setBackground(new Color(50,50,50));
		textAreaInfo1.setForeground(new Color(190,190,190));
		next1.setFont(new Font("one",Font.PLAIN,17));	
		textAreaInfo1.setWrapStyleWord(true);
		textAreaInfo1.setLineWrap(true);
		textAreaInfo1.setEditable(false);
		l(labelR);
		l(labelG);
		l(labelB);
		l(component);
		
		panel1a.setBackground(new Color(150,150,150));
		panel2.setBackground(new Color(30,30,30));
		panel1a.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		label1(labelName1);
		label1(labelPassword1);
		label1(labelInfo1);
		button1(next1);
		button2(next1);
		label1(buttonDevice1);
		label3(buttonDevice1);
		label1(nameLabel);
		
		close1.setBounds(450,0,50,25);
		appName.setBounds(5,0,100,25);
		panel2.setBounds(2,2,496,346);
		textAreaInfo1.setBounds(1000,0,0,0);
		panel1a.setBounds((int)900/2-250,(int)600/2-175,0,0);
		panelColor.setBounds(5,35,0,0);
		
	    component.setBounds(20,10,150,25);
	    labelR.setBounds(20,65,150,25);
	    labelG.setBounds(20,120,150,25);
	    labelB.setBounds(20,175,150,25);
	    panelR.setBounds(200,65,20,25);
	    panelG.setBounds(200,120,20,25);
	    panelB.setBounds(200,175,20,25);
	    next1.setBounds(panel2.getWidth()-100,panel2.getHeight()-30,100,20);
	    
		panelColor.add(labelR);
		panelColor.add(panelR);
		panelColor.add(labelG);
		panelColor.add(panelG);
		panelColor.add(labelB);
		panelColor.add(panelB);
		panelColor.add(component);
		
		panel1a.setLayout(null);
		panel2.setLayout(null);
		panelColor.setLayout(null);

		panel2.add(close1);
		panel2.add(appName);
		panel2.add(panelColor);
		
		panel2.add(labelPassword1);
		panel2.add(labelName1);
		panel2.add(next1);
		panel2.add(labelInfo1);
		panel2.add(buttonDevice1);
		panel2.add(textAreaInfo1);
		panel1a.add(panel2);
		panel2.add(next1);
		panelContent.add(panel1a);
		blackL(labelR);
		blackL(labelG);
		blackL(labelB);
		blackL(component);
		Timer colorTimer1 = new Timer();
		colorTimer1.schedule(new TimerTask() {
			public void run() {
				initial_color();
				frameMain.setVisible(true);
				cancel();
				colorTimer1.purge();
			}
		},1000*1,100*1);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i = 0;
					File file = new File(destinationPath+".txt");
					Scanner input = new Scanner(file);
					String allColor = "";
					String[] content = new String[10];
					while(input.hasNextLine()) {
						content[i] = input.next();
						i+=1;
						if(i > 1) {
							break;
						}
					}
					for(int o = 0; o<panelColorA.length;o++) {
						if(panelColorA[o]!=null) {
							allColor += panelColorA[o].getBackground().getRed()+",";
							allColor += panelColorA[o].getBackground().getGreen()+",";
							allColor += panelColorA[o].getBackground().getBlue()+"/";
						}
					}
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(file,false));
						bw.write(content[0]+"\n");
						bw.write(content[1]+"\n");
						bw.write(allColor);
						bw.close();
					}catch(FileNotFoundException e3) {
					}
				}catch(IOException e2) {
					
				}
				frame.dispose();
				frameMain.dispose();
			}
		});
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type("Background");
			}
		});
		appName.setForeground(new Color(170,170,170));
		close1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1a.setBounds((int)frameMain.getWidth()/2-250,(int)frameMain.getHeight()/2-175,0,0);
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
				int x1 =(int)(MouseInfo.getPointerInfo().getLocation().getX()-frameMain.getLocation().getX()-x);
				int y1 =(int)(MouseInfo.getPointerInfo().getLocation().getY()-frameMain.getLocation().getY()-y-27);
				panel1a.setLocation(x1,y1);
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(searchField.getText().equals("set")) {
					panel1a.setBounds((int)frameMain.getWidth()/2-250,(int)frameMain.getHeight()/2-175,500,350);
				}
			}
		});
		panelG.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				int i = (int)(MouseInfo.getPointerInfo().getLocation().getX()-panelColor.getLocationOnScreen().getX());
				if(i >=200&&i<= 455) {
					panelG.setLocation(i,panelG.getY());
					int number = i - 200;
					labelG.setText("Red("+number+")");
					green1 = number;
				}
				
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		panelR.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				int i = (int)(MouseInfo.getPointerInfo().getLocation().getX()-panelColor.getLocationOnScreen().getX());				
				if(i >=200&&i<= 455) {
					panelR.setLocation(i,panelR.getY());
					int number = i - 200;
					labelR.setText("Red("+number+")");
					red1 = number;
				}
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		panelB.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				int i = (int)(MouseInfo.getPointerInfo().getLocation().getX()-panelColor.getLocationOnScreen().getX());
				if(i >=200&&i<= 455) {
					panelB.setLocation(i,panelB.getY());
					int number = i - 200;
					labelB.setText("Red("+number+")");
					blue1 = number;
				}
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		component.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				colorNumber += 1;
				if(colorNumber < panelColorA.length&&panelColorA[colorNumber] !=null) {
					component.setText(panelColorA[colorNumber].getName());
				}else {
					colorNumber = -1;
				}
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		next1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColorA[colorNumber].setBackground(new Color(red1,green1,blue1));
			}
		});
		}
	}
	private Timer timerColor;
	protected void type(String type) {
		switch(type) {
		case"Background":
			panelColor.setBounds(5,35,panel2.getWidth()-10,panel2.getHeight()-80);
			timerColor = new Timer();
			timerColor.schedule(new TimerTask() {
				public void run() {
					panelColor.setBackground(new Color(red1,green1,blue1));
				}
			},100*1,100*1);
			break;
		}
			
	}
}


