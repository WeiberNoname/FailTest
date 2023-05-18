package quantum3;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;

public class fileChar extends QMain{
	private Thread t,d;
	private Runnable runnable1;
	private ArrayList<File> arrayFile = new ArrayList<File>();
	private ArrayList<File> fileList = new ArrayList<File>();
	private ArrayList<File> fileL1 = new ArrayList<File>();
	
	private Timer timer1 = new Timer();
	private Timer timer = new Timer();
	
	private boolean forHide = false,tTF = false,destroyTF = false,runnable1TF = false;
	private int forRoot = 1,forRoot1 = 0;
	private long numberFile = 0;
	
	private JButton[] button = new JButton[8];
	private String buttonPath = "",stringString="",progress = "";
	
	class destroy implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if(!encryptTF&&!buttonPath.equals("null")) {
			bB1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					timer1.cancel();
					timer.cancel();
					timer1.purge();
					timer.purge();
					bN1.setForeground(new Color(200,200,200));
				}
			});
			if(e.getButton() == 3&&(!runnable1TF)) {
			buttonPathD = buttonPath;
			runnable1TF = true;
			File file = new File(buttonPathD);
			if(file.exists()) {
				destroyTF = true;
				dialogInfo.setVisible(true);
				tAInfo.setText("File Name : "+file.getName()+"\nAbsolute Path"+file.getAbsolutePath()+"\n"+" Destroy");
				timer = new Timer();
				bN1.setForeground(new Color(200,200,200));
				timer.schedule(new TimerTask() {
					public void run() {
						dialogInfo.setVisible(false);
						tAInfo.setText("");
						runnable1TF = false;
						destroyTF = false;
						timer1.cancel();
						cancel();
						timer1.purge();
						timer.purge();
					}
				},10000*1,1000*1);
			}else if(!file.exists()) {
				dialogInfo.setVisible(true);
				tAInfo.setText("File Name : Not exists");
				bN1.setForeground(new Color(80,80,80));
				timer1 = new Timer();
				timer1.schedule(new TimerTask() {
					public void run() {
						dialogInfo.setVisible(false);
						tAInfo.setText("");
						runnable1TF = false;
						timer.cancel();
						cancel();
						timer1.purge();
						timer.purge();
					}
				},10000*1,1000*1);
			}
			}
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
	}
	class destroy1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(destroyTF == true) {
				destroy();
				bN1.setForeground(new Color(80,80,80));
			}
		}
	}
	public void destroy() {
		if(runnable1TF) {
			fileL1.clear();
			timer1.cancel();
			timer.cancel();
			timer1.purge();
			timer.purge();
			d = new Thread(new Runnable(){
			 public void run() {
			runnable1TF = true;	
		File file = new File(buttonPathD);
		if(file.exists()&&destroyTF == true) {
			int nameNum = 0;
			File fileD = new File(destinationPath+"\\"+file.getName());
			while(fileD.exists()) {
				fileD = new File(destinationPath+"\\"+file.getName()+nameNum);
				nameNum +=1;
			}
			fileD.mkdir();
			if(file.isDirectory()) {
				File[] fileList = file.listFiles();
				for(int i = 0;i <fileList.length;i++) {
					fileL1.add(fileList[i]);
				}
				if(fileList != null) {
				for(int i = 0; i<= fileL1.size();i++ ) {
					if(i != fileL1.size()) {
					fileL1.get(i).setWritable(true);
					fileL1.get(i).setReadable(true);
					fileL1.get(i).setExecutable(true);
					}
					try {
						TimeUnit.MILLISECONDS.sleep(100);
						int fileLastItem = fileL1.size()-i;
						double filePercentage;
						if(fileL1.size() == 0) {
							filePercentage = 100;
						}else {
							filePercentage = ((i *100 )/ fileL1.size());
						}
						for(int iii = 0 ; iii < (int)filePercentage-3;iii++) {
							progress = progress + "|";
						}
						tAInfo.setText(" Last items : "+fileLastItem+" Complete : "+filePercentage+"% "+"\n\n"+progress);
						progress = "";
					}catch(InterruptedException e) {
					}
					if(i!=fileL1.size()) {
					if(fileL1.get(i).isDirectory()) {
						File[] file3 = fileL1.get(i).listFiles();
						if(file3 != null) {
						for(int ii = 0 ; ii <file3.length;ii++) {
							fileL1.add(file3[ii]);
							try {
								TimeUnit.MILLISECONDS.sleep(100);
							}catch(InterruptedException e) {
							}
						}
						}
					}
					}
					File file1 = new File(fileD+"\\"+i+".txt");
					if(i<fileL1.size()) {
						if(!fileL1.get(i).isDirectory()) {
						fileL1.get(i).renameTo(file1);
						fileL1.get(i).delete();
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(file1,false));
							bw.write("Null");
							bw.close();
						}catch(IOException e) {
						}
						}
					}else if( i == fileL1.size()){
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(file1,false));
							bw.write("Null");
							bw.close();
						}catch(IOException e) {
						}
					}
				}
				}
			}else {
					File file1 = new File(fileD+"\\"+1+".txt");
					file.renameTo(file1);
					file.delete();
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(file1,false));
						bw.write("Null");
						bw.close();
					}catch(IOException e) {
					}
			}
			runnable1TF = false;
			destroyTF = false;
			dialogInfo.setVisible(false);
			tAInfo.setText("");	
			stopD();
		}
		    }
		});
		d.start();
		}
	}
	public final void stopD() {
		if(runnable1TF&&(!encryptTF)) {
			d.stop();
			runnable1TF = false;
			bN1.setForeground(new Color(200,200,200));
			fileL1.clear();
		}
	}
	public void buttonShow(JButton b) {
		b.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				File file = new File(buttonPath);
				if(file.exists()&&e.getButton() == 1) {
				try {
					Desktop.getDesktop().open(file);
				}catch(IOException e1) {
				}
				}
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				if(encryptTF == false) {
				buttonPath = b.getText();
				File file = new File(b.getText());
				if(file.exists()) {
							b.setText(file.getName());
				}
			}
			}
			public void mouseExited(MouseEvent e) {
				if(encryptTF == false) {
				b.setText(buttonPath);
				}
			}
		});
	}
	public void button1(JButton b) {
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
		b.setFont(new Font("one",Font.CENTER_BASELINE,10));
		b.setForeground(new Color(200,200,200));
		b.setText("Null");
		destroy d = new destroy();
		b.addMouseListener(d);
		panelFileChar1.add(b);
	}
	public void button2(JButton b) {
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
		b.setFont(new Font("one",Font.PLAIN,12));
		b.setForeground(new Color(20,20,20));
		panelFileChar.add(b);
	}
	
	public fileChar() {
		new fileChar1();
		numberOfFile.setForeground(new Color(20,20,20));
		numberOfFile.setFont(new Font("one",Font.PLAIN,9));
		fieldChar.setFont(new Font("one",Font.PLAIN,10));
		fieldChar.setForeground(new Color(200,200,200));
		fieldChar.setBackground(new Color(20,20,20));
		
		panelFileChar.setBackground(new Color(200,200,200));
		panelFileChar1.setBackground(new Color(20,20,20));
		panelFileChar.setLayout(null);
		panelFileChar1.setLayout(new GridLayout(8,1));
		
		resize.setBorderPainted(false);
		resize.setFocusPainted(false);
		resize.setContentAreaFilled(false);
		resize.setFont(new Font("one",Font.PLAIN,8));
		resize.setForeground(new Color(200,200,200));
		
		button1(char1);
		button1(char2);
		button1(char3);
		button1(char4);
		button1(char5);
		button1(char6);
		button1(char7);
		button1(char8);
		buttonShow(char1);
		buttonShow(char2);
		buttonShow(char3);
		buttonShow(char4);
		buttonShow(char5);
		buttonShow(char6);
		buttonShow(char7);
		buttonShow(char8);
		button[0] = char1;
		button[1] = char2;
		button[2] = char3;
		button[3] = char4;
		button[4] = char5;
		button[5] = char6;
		button[6] = char7;
		button[7] = char8;
		button2(isHide);
		button2(isLocation);
		button2(buttonN);
		button2(buttonB);
		destroy1 d1 = new destroy1();
		bN1.addActionListener(d1);
		bB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnable1TF = false;
				destroyTF = false;
				dialogInfo.setVisible(false);
				tAInfo.setText("");	
				if(runnable1TF == true) {
				stopD();
				}
			}
		});
		numberOfFile.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				runnable1TF = false;
				destroyTF = false;
				dialogInfo.setVisible(false);
				tAInfo.setText("");	
				if(runnable1TF == true) {
				stopD();
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
		buttonN.setFont(new Font("one",Font.CENTER_BASELINE,12));
		buttonB.setFont(new Font("one",Font.CENTER_BASELINE,12));
		
		isHide.setBounds(3,1,70,20);
		isLocation.setBounds(78,1,110,20);
		fieldChar.setBounds(188,1,panelFileChar.getWidth()/3-10,20);
		
		panelFileChar.setBounds(panelFileFile.getWidth()*2/3-50,1,panelFileFile.getWidth()*1/3-1+50,panelFileFile.getHeight()-3);
		panelFileChar1.setBounds(2,23,panelFileChar.getWidth()-4,panelFileChar.getHeight()-50);
		
		buttonB.setBounds(0,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
		numberOfFile.setBounds(panelFileChar.getWidth()/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
		buttonN.setBounds(panelFileChar.getWidth()*2/3,panelFileChar1.getHeight()+27,panelFileChar.getWidth()/3,20);
		
		panelFileChar.add(numberOfFile);
		panelFileChar.add(fieldChar);
		panelFileChar.add(panelFileChar1);
		panelFileFile.add(panelFileChar);
		
		isHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(forHide == true) {
					isHide.setText("HIDE");
					forHide = false;
				}else {
					isHide.setText("NOW");
					forHide = true;
				}
			}
		});
		isLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File[] file = File.listRoots();
				isLocation.setText(file[forRoot].toString());
				forRoot1 = forRoot;
				if(forRoot == file.length-1) {
				forRoot = -1;	
				}
				forRoot +=1;
			}
		});
	
		fieldChar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldChar.getText().equals(stringString)) {
				}else {
					if(tTF ==true) {
					//	t.interrupt();
						stopT();
						tTF = false;
					}else {
					}
				stringString = fieldChar.getText();
				try {
					Thread.sleep(1000, blue1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				t = new Thread(new Runnable(){
				    public void run() {
				    	findOut(fieldChar.getText());
				    	tTF = true;
				    }
				});
				t.start();
				}
			//	Runnable runnable = () -> System.out.println("Hello");
			}
		});
		
		buttonN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCharP();
			}
		});
		buttonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCharM();
			}
		});
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.purge();
				timer1.purge();
			}
		});
	}
	
	public void findOut(String word) {
		long total = 0,all = 0;
		File[] fileList1 = File.listRoots();
		File[] fileList2 = fileList1[forRoot1].listFiles();
		arrayFile.clear();
		fileList.clear();
		File[] file3 ;
		if(fileList2 != null) {
		for(int i = 0;i< fileList2.length;i++) {
			if(fileList2[i] != null) {
				fileList.add(fileList2[i]);
			if(fileList2[i].getName().indexOf(word) > -1) {
				charSet(total,fileList2[i],all);
				total +=1;
			}
			all+=1;
			}
		}
	//	int size = fileList.size();
		for(int i = 0 ; i<fileList.size();i++ ) {
			if(fileList.get(i).isDirectory()&&fileList.get(i) != null) {
				file3 = fileList.get(i).listFiles();
				if(file3 != null) {
				for(int ii = 0 ;ii< file3.length;ii++) {
					if(file3[ii] != null&&forHide == false){
						fileList.add(file3[ii]);
						if(file3[ii].getName().indexOf(word) > -1) {
							charSet(total,file3[ii],all);
							total+=1;
						}
						all+=1;
					}else if(file3[ii] != null&&(!file3[ii].isHidden())){
						fileList.add(file3[ii]);
						if(file3[ii].getName().indexOf(word) > -1) {
							charSet(total,file3[ii],all);
							total+=1;
						}
						all+=1;
						}
					numberOfFile.setText(total+" / "+all+" File List");
					}
				}
				}
		}
		}
	}
	public final void stopT() {
		t.stop();
	}
	public void setCharM() {
		for(int i = 0 ; i <8;i++) {
			if(numberFile>0) {
				numberFile -= 1;
				button[i].setText(arrayFile.get((int) numberFile).toString());
				File file = new File(arrayFile.get((int)numberFile).toString());
				if(file.isDirectory()) {
					button[i].setForeground(new Color(150,150,10));
				}else {
					button[i].setForeground(new Color(200,200,200));
				}
			}
		}
	}
	public void setCharP() {
		for(int i = 0 ; i < 8 ;i++ ) {
			if(numberFile < arrayFile.size()-1) {
				numberFile += 1;
				button[i].setText(arrayFile.get((int)numberFile).toString());
				File file = new File(arrayFile.get((int)numberFile).toString());
				if(file.isDirectory()) {
					button[i].setForeground(new Color(150,150,10));
				}else {
					button[i].setForeground(new Color(200,200,200));
				}
			}
		}
	}
	public void setChar(byte b) {
			if(b < arrayFile.size()) {
				File file = new File(arrayFile.get(b).toString());
				button[b].setText(arrayFile.get(b).toString());
				if(file.isDirectory()) {
					button[b].setForeground(new Color(150,150,10));
				}else {
					button[b].setForeground(new Color(200,200,200));
				}
			}
			for(long i = b ; i > -1;i--) {
					File file = new File(arrayFile.get(b).toString());
					button[(int)i].setText(arrayFile.get((int)i).toString());
					if(file.isDirectory()) {
						button[b].setForeground(new Color(150,150,10));
					}else {
						button[b].setForeground(new Color(200,200,200));
					}
			}
			for(long i = (b+1) ; i < 8;i++) {
				button[(int)i].setText("null");
				button[(int)i].setForeground(new Color(200,200,200));
		}
	}
	public void charSet(long longNum,File filePath,long all) {
		arrayFile.add(filePath);
		if(longNum <=7) {
		setChar((byte)longNum);
		}
	}
	
}