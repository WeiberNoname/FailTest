package quantum3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class subLogin extends QMain {
	public subLogin() {
		String destination = fileDevice+"Conservader1";
		File[] destination1 = new File(destination).listFiles();
		if(destination1 != null) {
		for(File file:destination1) {
			if(file.getAbsoluteFile().toString().indexOf("\\"+fieldName.getText()+".txt")>-1){
				helperName = fieldName.getText();
				passwordA = "";
				destinationPath = "";
				try {
					int i = 0;
					Scanner input= new Scanner(file);
					while(input.hasNextLine()) {
						String passwordAndPath = input.nextLine();
						if(i == 0&&passwordAndPath.equals(fieldPassword.getText())) {
							passwordA = passwordAndPath;
						}else if(i == 1&&passwordA.length() != 0){
							destinationPath = passwordAndPath;
						}else if(i == 2) {
							colorString = passwordAndPath;
						}
						i+=1;
					}
					i = 0;
					if(!passwordA.equals("")) {
						frame.dispose();
						new QMainSetUp();
						new setting();
						new file();
						new fileChar();
						settingTf = true;
					}else {
						labelInfo.setText("Error");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}else {
		labelInfo.setText("Error");
		labelRed(buttonDevice);
	}
		if(passwordA.length() == 0) {
			labelInfo.setText("Error");
		}
		
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
