package quantum3;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;

public class QMainSetUp extends QMain{
	public static int textAreaInfoNum = 1;
	public static int positionUnderPanelMainX = 0,positionUnderPanelMainY = 0;  
	int locked = 0,timerSet1 = 0;
	
	void timer1() {
		Timer timer1 = new Timer();
		timer1.schedule(new TimerTask() {
		public void run() {
			locked +=20;
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			if(panelContent.getBounds().getWidth() == 900) {
				panelContent.setBounds(locked,25,900,545);
			}else {
				int h1 = (int)dimension.getHeight()-600;
				panelContent.setBounds(locked,25,(int)dimension.getWidth(),545+h1);
			}
			if(locked > dimension.getWidth()+100) {
				locked = 0;
				int h1 = (int)(dimension.getHeight()-600)/2;
				int w1 = (int)(dimension.getWidth()-900)/2;
				nameLabel.setText(helperName);
				if(panelContent.getBounds().getWidth()>900) {
					nameLabel.setBounds(20,10,500,50);
					password.setBounds(350+w1,350+h1,200,24);
				}else {
					nameLabel.setBounds(20,10,500,50);
					password.setBounds(350,350,200,24);
				}
				timer1.cancel();
			}
		}
	},1*1,1*1);
	}
	void startTimer(int timerSet) {
		enterNum = timerSet;
		Timer timer2 = new Timer();
		timer2.schedule(new TimerTask() {
			public void run() {
				enterNum -= 1;
				System.out.println(enterNum);
				if(enterNum == 0) {
				timer1();
				lockTF = true;
				timer2.cancel();
				timer2.purge();
				}
			}
		},1000*1,1000*1);
	}
	int locationX1 = 0,locationY1 = 0;
	public QMainSetUp() {
		Dimension dimension1 = Toolkit.getDefaultToolkit().getScreenSize();

		close.setFocusPainted(false);
		close.setBorderPainted(false);	
		close.setContentAreaFilled(false);
		small.setFocusPainted(false);
		small.setBorderPainted(false);	
		small.setContentAreaFilled(false);
		search.setFocusPainted(false);
		search.setBorderPainted(false);	
		type.setFocusPainted(false);
		type.setBorderPainted(false);	
		searchField.setBackground(new Color(30,30,30));
		searchField.setForeground(new Color(200,200,200));
		password.setBackground(new Color(30,30,30));
		password.setForeground(new Color(170,170,170));
		search.setForeground(new Color(20,20,20));
		search.setBackground(new Color(180,180,180));
		type.setForeground(new Color(20,20,20));
		type.setBackground(new Color(180,180,180));
		close.setForeground(new Color(200,200,200));
		small.setForeground(new Color(200,200,200));
		
		close.setText("x");
		small.setText("--");
		search.setText("Search");
		type.setText("Type");
		close.setFont(new Font("one",Font.CENTER_BASELINE,15));
		small.setFont(new Font("one",Font.CENTER_BASELINE,15));
		searchField.setFont(new Font("one",Font.PLAIN,15));
		nameLabel.setFont(new Font("one",Font.PLAIN,35));
		search.setFont(new Font("one",Font.CENTER_BASELINE,11));
		type.setFont(new Font("one",Font.CENTER_BASELINE,11));
		panelMain.setBorder(BorderFactory.createEmptyBorder(25,0,50,0));
		panelContent.setLayout(null);
		panelMain.setLayout(null);
		panelRoot.setLayout(new GridLayout(1,1));
		frameMain.setLayout(new GridLayout(1,1));
		//change
		panelMain.setBackground(colorChange(1,0));
		panelContent.setBackground(colorChange(0,1));
		panelRoot.setBackground(new Color(110,110,110));
		
		panelContent.setBounds(0,25,900,545);
		close.setBounds(860,0,50,25);
		small.setBounds(810,0,50,25);
		search.setBounds(650,575,100,20);
		searchField.setBounds(250,575,390,20);
		type.setBounds(140,575,100,20);
		password.setBounds(35004,30450,200,24);
		resize.setBounds(0,575,100,20);
		
		panelRoot.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		
		frameMain.add(panelRoot);
		panelRoot.add(panelMain);
		panelMain.add(password);
		panelMain.add(close);
		panelMain.add(small);
		panelMain.add(searchField);
		panelMain.add(search);
		panelMain.add(type);
		panelMain.add(panelContent);
		panelMain.add(resize);
		
		frameMain.pack();
		frameMain.setSize(900,600);
		int locationX = (int)(dimension1.getWidth()/2-frameMain.getWidth()/2);
		int locationY = (int)(dimension1.getHeight()/2-frameMain.getHeight()/2);
		frameMain.setLocation(locationX,locationY);
		startTimer(20);
		searchField.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			String buffer = searchField.getText();
			searchField.setText("");
			searchField.paste();
			File file = new File(searchField.getText());
			if(file.exists()) {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				Transferable transfer = new StringSelection(buffer);
				clipboard.setContents(transfer, null);
			}else {
				searchField.setText(buffer);
			}
			}
			public void mouseExited(MouseEvent e) {
			
			}
		});
		
		panelMain.addMouseListener(new MouseListener() {
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
		panelMain.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				int x = locationX1;
				int y = locationY1;
				int x1 =(int)MouseInfo.getPointerInfo().getLocation().getX()-x;
				int y1 =(int)MouseInfo.getPointerInfo().getLocation().getY()-y;
				frameMain.setLocation(x1,y1);
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		
	
		panelContent.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				enterNum = 180;
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
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password.getText().equals(passwordA)) {
					if(panelContent.getBounds().getWidth() == 900) {
						panelContent.setBounds(0,25,900,545);
						password.setBounds(35004,30450,0,0);
						nameLabel.setBounds(10000,10000,0,0);
						password.setText("");
						lockTF = false;
					}else {
						Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
						int X = (int)(dimension.getWidth()-900);
						int Y = (int)(dimension.getHeight()-600);
						panelContent.setBounds(0,25,900+X,545+Y);
						password.setBounds(35004,30450,0,0);
						nameLabel.setBounds(10000,10000,0,0);
						lockTF = false;
						password.setText("");
					}
					password.setText("");
					startTimer(10);
				}
			}
		});
	}
	public Color colorChange(int typeHigh,int typeLight) {
		Color color = Color.blue;
		switch(typeHigh) {
		case 1:
			color = new Color(20,20,20);
			break;
		case 2:
			color = new Color(30,30,150);
			break;
		case 3:
			color = new Color(130,20,20);
			break;
		case 4:
			color = new Color(190,190,190);
			break;
		case 5:
			color = new Color(100,100,100);
			break;
		case 6:
			color = new Color(10,90,10);
		break;
		}
		switch(typeLight) {
		case 1:
			color = new Color(50,50,50);
			break;
		case 2:
			color = new Color(50,50,170);
			break;
		case 3:
			color = new Color(150,40,40);
			break;
		case 4:
			color = new Color(210,210,210);
			break;
		case 5:
			color = new Color(120,120,120);
			break;
		case 6:
			color = new Color(30,110,30);
		break;
		}
		
		return color;
	}
}

