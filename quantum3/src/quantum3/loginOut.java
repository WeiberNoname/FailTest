package quantum3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class loginOut extends QMain{
	int n = 0;
	boolean tfOfFile = false;
	public loginOut() {
		fieldPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		fieldName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldPassword.getText().length()>0&&fieldName.getText().length()>0&&right == 3) {
					File file1 = new File(fileDevice+"Conservader1");
				if(!file1.exists()) {
				file1.mkdir();
				}
				String device = fileDevice+"Conservader1"+"\\";
				File file = new File(device+fieldName.getText()+".txt");
					if(file.exists()) {
					}else {
						tfOfFile = true;
					}
					if(tfOfFile) {
					try {
						passwordA = fieldPassword.getText();
						helperName = fieldName.getText();
						File fileX = new File(device+fieldName.getText());
						fileX.mkdir();
						file.createNewFile();
						BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
						destinationPath = fileX.toString();
						bw.write(fieldPassword.getText()+"\n");
						bw.write(fileX.toString());
						bw.close();
						//settingTf = true;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}
					tfOfFile = false;
				}
				
			}			
		});
	
	}
	int moveLock = 0;
}