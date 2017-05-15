package rooms;

import java.text.DateFormat;
import java.util.Date;

import game.Game;
import gui.Adventure;

public class Room {
	
	protected String name;
	private String[] basicText;
	protected String[] lookCMDs;
	protected String[] goCMDs;
	protected String[] pickupCMDs;
	
	public String getName() {
		return this.name;
	}
	
	public String[] getlookCMDs() {
		return this.lookCMDs;
	}
	
	public String[] getgoCMDs() {
		return this.lookCMDs;
	}
	
	public String[] getpickupCMDs() {
		return this.lookCMDs;
	}
	
	public void setBasicText(String[] args) {
		this.basicText = args;
	}
	
	public String[] getBasicText() {
		return this.basicText;
	}
	
	public void PrintSlow(String[] strArray,long miliseconds) {
		
		for (String message : strArray) {
			message = PlaceholderHandler(message);
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i = 0; i < message.length(); i++) {
				Adventure.ChatBoxOutput.setText(Adventure.ChatBoxOutput.getText() + message.charAt(i) );
				try {
					Thread.sleep(miliseconds);
					Adventure.ChatBoxOutput.update(Adventure.ChatBoxOutput.getGraphics());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Adventure.ChatBoxOutput.setText(Adventure.ChatBoxOutput.getText() + "\n" );
		}
		Adventure.CMDExpected = true;
	}
	
		
	
	private String PlaceholderHandler(String message) {
		message = ReplacePlaceHolder(message, "%RoomName%", this.name);
		message = ReplacePlaceHolder(message, "%Username%", Game.username);
		message = ReplacePlaceHolder(message, "%Time%", DateFormat.getTimeInstance().format(new Date()));
		return message;
		
	}
	
	private String ReplacePlaceHolder(String str,String placeholder, String replacement) {
		String newstr = str;
		try {
			newstr = str.replaceAll(placeholder, replacement);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newstr;
	}
}
