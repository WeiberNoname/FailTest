package quantum3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.im.InputContext;
import java.awt.im.InputMethodRequests;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class QMain {
	public static JFrame frameMain = new JFrame();
	public static JFrame frame = new JFrame();
	
	public static JPanel panelMain = new JPanel();
	public static JPanel panelRoot = new JPanel(),panelRoot0 = new JPanel();
	public static JPanel panelContent = new JPanel();
	public static JPanel panelMovie = new JPanel(),panelOther = new JPanel(),panelFileFile = new JPanel();
	public static JPanel panelFile2 = new JPanel(),panelFileBuffer = new JPanel(),panelFileMainF = new JPanel();
	public static JPanel panelFileFileM1 = new JPanel(),panelFileFileM2 = new JPanel(),panelFileFileM3 = new JPanel(),panelFileFileM4= new JPanel(),panelFileFileM5 = new JPanel();; 
	public static JPanel  panelFileNews =new JPanel(),panelFileProperties = new JPanel(),panelFileTree = new JPanel();
	public static JPanel panelFileChar = new JPanel(),panelFileChar1 = new JPanel();
	public static JPanel pMain = new JPanel(),pMain1 = new JPanel();
	
	public static JButton changeColor = new JButton();
	public static JButton resize = new JButton("Resize");
	public static JButton close = new JButton(),small = new JButton();
	public static JButton search = new JButton();
	public static JButton type = new JButton();
	public static JButton next = new JButton("Next");
	public static JButton back = new JButton("Back");
	public static JButton isHide = new JButton("HIDE"),isLocation = new JButton("Location"),buttonN = new JButton(">"),buttonB = new JButton("<");
	public static JButton char1 = new JButton(),char2 = new JButton(),char3 = new JButton(),char4 = new JButton(),char5 = new JButton(),char6 = new JButton(),char7 = new JButton(),char8 = new JButton();
	public static JButton bN1 = new JButton("Accept"), bB1 = new JButton("Cancel !");
	
	public static JTextArea textAreaInfo = new JTextArea(); 
	public static JTextArea tAInfo = new JTextArea();
	
	public static JTextField searchField = new JTextField();
	public static JTextField password = new JTextField();
	public static JTextField fieldPassword = new JTextField();
	public static JTextField fieldName = new JTextField();
	public static JTextField fieldChar = new JTextField();
	
	public static JLabel labelName = new JLabel("Clone Conservader : ");
	public static JLabel  labelPassword = new JLabel("Password : ");
	public static JLabel labelInfo = new JLabel("");
	public static JLabel buttonDevice = new JLabel("Device Clone Conservader Location : Device ");
	public static JLabel nameLabel = new JLabel();
	public static JLabel numberOfFile = new JLabel();
	
	public static JDialog dialogInfo = new JDialog();
	
	public static int device = 0,right = 0;
	public static int frameX1,frameY1;
	public static int enterNum = 10;
	public static int red1 = 0, green1 = 0,blue1 = 0;
	
	public static String helperName = "",passwordA = "",typeOfFrame = "";
	public static String destinationPath = "";
	public static String colorString = "";
	public static String buttonPathD = "";

	public static boolean lockTF = false,settingTf = false;
	public static  boolean encryptTF = false;
	
	public static File fileDevice;
	public static Timer timeTimer;	
	
	// setting

	//public static Color 
	
	public static void main(String[] args) {
		frameMain.setUndecorated(true);
		
		panelMain.setName("Main");
		panelContent.setName("Content");
		panelRoot.setName("Root");
		panelFileMainF.setName("Main Area");
		panelFileBuffer.setName("Buffer Area");
		panelFile2.setName("File Main");
		panelOther.setName("Other");
		panelFileFile.setName("File List");
		panelMovie.setName("Movie Bar");
		
		new destination();
		new scaleScreen();
		new loginOut();
		new DialogInfo();
		
		buttonDevice.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				File[] fileList  = File.listRoots();
				buttonDevice.setText("Device Clone Conservader Location : "+fileList[device]+"\\Conservader1");
				fileDevice = fileList[device];
				device +=1;
				if(device == fileList.length) {
					device =  0;
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
		
		small.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameX1 = frameMain.getWidth();
				frameY1 = frameMain.getHeight();
				frameMain.setSize(200,70);
			}
		});
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				dialogInfo.dispose();
			}
		});
	}
}
