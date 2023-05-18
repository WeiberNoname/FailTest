package quantum3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class scaleScreen extends QMain{
	private JFrame frameScale = new JFrame();
	public scaleScreen() {
		frameScale.setUndecorated(true);
		frameScale.setBackground(new Color(150,150,150,120));
		frameScale.pack();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int y = (int)(dimension.getHeight()-10);
		int x = (int)(dimension.getWidth()-10);
		frameScale.setSize(x,y);
		frameScale.setLocation(5,5);
		frameScale.setVisible(false);
		
		panelMain.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				if(frameMain.getLocationOnScreen().getX() <= 0&&frameMain.getLocationOnScreen().getY()<=0) {
					frameScale.setVisible(true);
				}else {
					frameScale.setVisible(false);
				}
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		panelMain.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
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
					close.setBounds(860+X,0,50,25);
					small.setBounds(810+X,0,50,25);
					search.setBounds(650+X1,575+Y,100,20);
					searchField.setBounds(250+X1,575+Y,390,20);
					type.setBounds(140+X1,575+Y,100,20);
					resize.setBounds(0,575+Y,100,20);
					if(frameMain.getWidth() == 900) {
						fieldChar.setBounds(188,1,panelFileChar.getWidth()/3-10,20);	
					}else {
						fieldChar.setBounds(188,1,panelFileChar.getWidth()/3+20,20);	
					}
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
					fieldChar.setBounds(188,1,panelFileChar.getWidth()/3+20,20);
					if(lockTF) {
						password.setBounds(350,350,200,24);
					}
					
					frameMain.setLocation(locationX,locationY);
					frameMain.setSize(900,600);
				
				}
				frameScale.setVisible(false);
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frameScale.dispose();	
			}
		});

		changeScaleA cA = new changeScaleA();
		changeScaleB cB = new changeScaleB();
		panelRoot.addMouseListener(cA);
		panelRoot.addMouseMotionListener(cB);
	
	}
	int frameX ;
	int frameY ;
	class changeScaleA implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			frameX = frameMain.getWidth();
			frameY = frameMain.getHeight();
			if((int)dimension.getWidth() > frameX||(int)dimension.getHeight() > frameY) {
				frameMain.setSize(frameX+4,frameY+4);
				panelRoot.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			}
		}
		public void mouseExited(MouseEvent e) {
			panelRoot.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
			frameMain.setSize(frameX,frameY);
		}		
	}
	class changeScaleB implements MouseMotionListener{
		public void mouseDragged(MouseEvent e) {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			frameX = frameMain.getWidth();
			frameY = frameMain.getHeight();
			int deviationX = e.getX();
			int deviationY = e.getY();
			if(deviationX > 900) {
				deviationX = 900;
			}
			if(deviationY > 600) {
				deviationY = 600;
			}
			if(deviationX >50&& deviationY>50) {
				frameMain.setSize(deviationX,deviationY);	
			}else if(deviationX >50) {
				frameMain.setSize(deviationX,50);
			}else if(deviationY >50) {
				frameMain.setSize(50,deviationY);
			}
		}
		public void mouseMoved(MouseEvent e) {
		}
	}
}
