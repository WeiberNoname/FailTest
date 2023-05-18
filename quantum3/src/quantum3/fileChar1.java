package quantum3;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;


public class fileChar1 extends QMain {
	private Thread t1,d1;
	private Runnable runnable1;
	private ArrayList<File> directory = new ArrayList<File>();
	private ArrayList<File> fileList = new ArrayList<File>();
	private ArrayList<File> fileL1 = new ArrayList<File>();
	
	private Timer timer1 = new Timer();
	private Timer timer = new Timer();
	
	private boolean forHide = false,tTF = false,destroyTF = false,runnable1TF = false;
	private int forRoot = 1,forRoot1 = 0;
	private long numberFile = 0;
	private String buttonPath = "",buttonPathE = "";
	private int num1 = 0;
	private String progress = "";
	
	public void decrypt() {
		t1 = new Thread(new Runnable() {
			public void run() {
		File file = new File(buttonPathE);
		ArrayList<File> fileArray = new ArrayList<File>();
		ArrayList<File> directoryArray = new ArrayList<File>();
		boolean fileTF = false;
		if(file.isFile()) {
			if(file.getName().indexOf("Encrypt.txt") > -1) {
				StringBuffer words ;
				String  pathOriginal = "";
				try {
					BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
					words = new StringBuffer();
					String all = input.readLine() ;
					while(all != null) {
						if(all.indexOf("EncryptNull")>-1&&fileTF == false) {
							fileTF =true;
							pathOriginal = all.substring(11);
						}else {
							words.append(all+"\n");
						}
						try {
							Thread.sleep(1);
						}catch(InterruptedException e) {
						}
						all = input.readLine();
					}
						input.close();
					if(fileTF) {
						try {
							BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "ISO-8859-1"));
							bw.write(words.toString());
							bw.close();
							file.renameTo(new File(pathOriginal));
						}catch(IOException e) {
						}
					}
				} catch (IOException e) {
				}
			}
		}else if(file.isDirectory()){
			System.out.println(3);
			if(file.getName().indexOf("Encrypt.txt") > -1) {
				System.out.println(4);
			File[] fileE = file.listFiles();
			ArrayList<File> fileL2 = new ArrayList<File>();
			for(int i = 0; i<fileE.length;i++) {
				fileL2.add(fileE[i]);
			}
			for(int i = 0 ; i < fileL2.size();i++) {
				if(fileL2.get(i).isDirectory()) {
				File[] fileBuffer = fileL2.get(i).listFiles();
				for(int ii = 0; ii<fileBuffer.length;ii++) {
					fileL2.add(fileBuffer[i]);
				}
				}
			}
			for(int ii = 0 ; ii < fileL2.size();ii++) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}	
			StringBuffer words ;
			String  pathOriginal = "";
			try {
				Scanner input = new Scanner(fileL2.get(ii));
				words = new StringBuffer();
				while(input.hasNextLine()) {
					if(input.nextLine().indexOf("EncryptNull")>-1&&(!fileTF)) {
						fileTF =true;
					}else {
						pathOriginal = input.nextLine().substring(11);
						System.out.println(pathOriginal);
					}
					words.append(input.nextLine()+System.lineSeparator());
				}
				input.close();
				if(fileTF) {
					String string1 = words.toString();
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(fileL2.get(ii)));
						bw.write(string1);
						bw.close();
						fileL2.get(ii).renameTo(new File(pathOriginal));
					}catch(IOException e) {
					}
				}
			} catch (FileNotFoundException e) {
			}
			}
			}
			}
			}
		});
		t1.start();
	}
	
	public void buttonShow(JButton b) {
		b.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				File file = new File(buttonPath);
				if(file.exists()&&e.getButton() == 3){
					buttonPathE = buttonPath;
				}
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
				if(encryptTF) {
				buttonPath = b.getText();
				File file = new File(b.getText());
				if(file.exists()) {
					b.setText(file.getName());
				}
			}
			}
			public void mouseExited(MouseEvent e) {
				File file = new File(buttonPath);
				if(encryptTF&&file.exists()) {
					b.setText(buttonPath);
				}
			}
		});
	}
	private void buttonStart(JButton b){
		b.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				File file = new File(buttonPathE);
				if(file.exists()&& e.getButton() ==3&&(!b.getText().equals("null"))) {
					if(encryptTF) {
					bN1.setForeground(new Color(200,200,200));	
					tAInfo.setText("File Path : "+buttonPathE+"\nEncrypt");
					dialogInfo.setVisible(true);
					bN1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(encryptTF&&(!runnable1TF)) {
							if(file.getName().indexOf("Encrypt.txt")>-1) {
								decrypt();
								System.out.println("ok");
							}else {
								try {
									encrypt();
								}catch(IOException e1) {
								}
							}
							bN1.setForeground(new Color(80,80,80));
							runnable1TF = true;
							}
						}
					});
					}
				}else if(e.getButton() ==3) {
					if(encryptTF) {
						bN1.setForeground(new Color(80,80,80));
						tAInfo.setText("File Name : Not exists");
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
		});
	}
	public void stopD() {
		if(runnable1TF&&encryptTF) {
		t1.stop();
		runnable1TF = false;
		bN1.setForeground(new Color(200,200,200));
		directory.clear();
		}
	}
	private void encrypt() throws IOException{
		bB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopD();
			}
		});
		t1 = new Thread(new Runnable() {
			public void run() {
		fileList.clear();		
		File file = new File(buttonPathE);
		if(file.isFile()&&runnable1TF) {
			all(1,0);
			file.setWritable(true);
			file.setExecutable(true);
			file.setReadable(true);
			File newD = new File(file+"Encrypt.txt");
			int i1= 0;
			if(newD.exists()) {
				while(newD.exists()) {
				newD = new File(file+String.valueOf(i1)+"Encrypt.txt");
				i1++;
				}
			}
			file.renameTo(newD);
			try {
				Thread.sleep(2000);
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(newD,true));
				bw.write("\nEncryptNull"+file);
				bw.close();
			}catch(IOException e) {
			}
			all(1,1);	
			} catch (InterruptedException e) {
			}
		}else {
		File[] file1 = file.listFiles();
		if(file1 != null&&file.isDirectory()) {
		for(int i = 0; i< file.listFiles().length;i++ ) {
			fileList.add(file1[i]);
			file1[i].setWritable(true);
			file1[i].setExecutable(true);
			file1[i].setReadable(true);
			tAInfo.setText("Main Items : "+fileList.size());
		}
		int numOfStart = 0;
		do {
		directory.clear();
		for(int i = numOfStart ; i<fileList.size();i++) {
			if(fileList.get(i).isDirectory()) {
				directory.add(fileList.get(i));
			}
		}
		numOfStart = fileList.size()-1;
		for(int i = 0 ; i<directory.size();i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			arrayToList(directory.get(i).listFiles());
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		tAInfo.setText("Items Analyze : "+fileList.size());
		}while(!(numOfStart < fileList.size()-1));
		try {
			Thread.sleep(10000);
			start1();
		} catch (InterruptedException e) {
		}catch(IOException e) {
		}
		stopD();
			}
		}
			}
		});
		t1.start();
	}
	private String I;
	private void start1() throws IOException{
	File fileA,newD;
	ZipOutputStream zipOut;
	FileOutputStream fos;
	FileInputStream fis;
	ZipEntry zipEntry ;
		for(int i = 0; i < fileList.size();i++) {
			if(!fileList.get(i).isDirectory()) {
			try {
				Thread.sleep(1000);
			all(fileList.size(),i+1);	
			fileA = fileList.get(i);
			fos = new FileOutputStream(fileA);
			zipOut = new ZipOutputStream(fos);
			newD = new File(fileA+"Compressed.zip");
			int i1= 0;
			if(newD.exists()) {
				while(newD.exists()) {
				newD = new File(fileA+String.valueOf(i1)+"Encrypt.txt");
				i1++;
				}
			}
			
			
			System.out.println(newD);
			fis = new FileInputStream(newD);
			zipEntry = new ZipEntry(newD.getName());
			zipOut.putNextEntry(zipEntry);
			byte[] bytes = new byte[1024];
			int length;
			while((length = fis.read(bytes))>=0) {
				zipOut.write(bytes,0,length);
			}
			zipOut.close();
			fis.close();
			fos.close();
			} catch (InterruptedException e) {
			}
			}
			all(fileList.size(),i+1);
		}
	}
	public void all(int all,int some) {
		 I = "";
		double percentage = ((some*100)/all);
		for(int i = 3 ;i < (int)percentage; i++) {
			I += "|";
		}
		tAInfo.setText("Complete : "+percentage+"%"+" | last seconds : "+(all-some)+"\n\n"+I);
	}
	public void arrayToList(File[] file) {
		for(int i = 0; i <file.length;i++) {
			fileList.add(file[i]);
			file[i].setWritable(true);
			file[i].setExecutable(true);
			file[i].setReadable(true);
		}
	}
	public fileChar1() {
		bB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopD();
			}
		});
		numberOfFile.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if(!encryptTF) {
					encryptTF = true;
					panelFileChar.setBackground(new Color(150,150,20));
				}else if(encryptTF){
					encryptTF = false;
					panelFileChar.setBackground(new Color(200,200,200));
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
		buttonShow(char1);
		buttonShow(char2);
		buttonShow(char3);
		buttonShow(char4);
		buttonShow(char5);
		buttonShow(char6);
		buttonShow(char7);
		buttonShow(char8);
		buttonStart(char1);
		buttonStart(char2);
		buttonStart(char3);
		buttonStart(char4);
		buttonStart(char5);
		buttonStart(char6);
		buttonStart(char7);
		buttonStart(char8);
		
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
	}
}
