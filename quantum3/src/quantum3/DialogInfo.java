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

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class DialogInfo extends QMain {
	private int locationX = 0,locationY = 0;
	public void buttonNB1(JButton b) {
		b.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				b.setFont(new Font("one",Font.CENTER_BASELINE,15));
			}
			public void mouseExited(MouseEvent e) {
				b.setFont(new Font("one",Font.CENTER_BASELINE,13));
			}
		});
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
	}
	
	class dragged1 implements MouseListener{
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			locationX = (int)e.getX();
			locationY = (int)e.getY();
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	class dragged2 implements MouseMotionListener{
		public void mouseDragged(MouseEvent e) {
			int mouseX =(int) MouseInfo.getPointerInfo().getLocation().getX()-locationX;
			int mouseY = (int)MouseInfo.getPointerInfo().getLocation().getY()-locationY;
			dialogInfo.setLocation(mouseX,mouseY);
		}
		public void mouseMoved(MouseEvent e) {
		}
	}
	
	public DialogInfo(){
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

		buttonNB1(bB1);
		buttonNB1(bN1);
		
		pMain.setBackground(new Color(70,70,70));
		pMain1.setBackground(new Color(30,30,30));
		tAInfo.setBackground(new Color(30,30,30));
		bB1.setForeground(new Color(200,200,200));
		bN1.setForeground(new Color(200,200,200));
		bN1.setFont(new Font("one",Font.CENTER_BASELINE,13));
		bB1.setFont(new Font("one",Font.CENTER_BASELINE,13));
		
		tAInfo.setForeground(new Color(190,190,190));
		tAInfo.setFont(new Font("one",Font.PLAIN,12));
		tAInfo.setWrapStyleWord(true);
		tAInfo.setLineWrap(true);
		tAInfo.setEditable(false);
		
		tAInfo.setBounds(2,2,292,70);
		bB1.setBounds(200,85,100,20);
		bN1.setBounds(0,85,100,20);
		
		pMain.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		pMain.setLayout(new GridLayout(1,1));
		pMain1.setLayout(null);
		dialogInfo.setLayout(new GridLayout(1,1));
	
		pMain.add(pMain1);
		pMain1.add(tAInfo);
		pMain1.add(bB1);
		pMain1.add(bN1);
		dialogInfo.add(pMain);
		
		dialogInfo.setUndecorated(true);
		dialogInfo.pack();
		dialogInfo.setSize(300,110);
		dialogInfo.setLocation((int)dimension.getWidth()/2-dialogInfo.getWidth()/2,(int)dimension.getHeight()/2-dialogInfo.getHeight()/2);
		dialogInfo.setVisible(false);
		dragged1 drag1 = new dragged1();
		dragged2 drag2 = new dragged2();
		pMain.addMouseListener(drag1);
		tAInfo.addMouseListener(drag1);
		pMain.addMouseMotionListener(drag2);
		tAInfo.addMouseMotionListener(drag2);
		bB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogInfo.setVisible(false);
				tAInfo.setText("");
			}
		});
		
	}
}
