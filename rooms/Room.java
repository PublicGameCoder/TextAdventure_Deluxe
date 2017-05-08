package rooms;

import game.Game;
import gui.Adventure;

public class Room {
	
	private String name;
	private String[] text;

	public Room(String name, String[] args) {
		this.name = name;
		this.text = args;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setText(String[] args) {
		this.text = args;
	}
	
	public String[] getText() {
		return this.text;
	}
	public void PrintSlow(long miliseconds) {
		
		for (String message : text) {
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
	
		
	
	public String PlaceholderHandler(String message) {
		message = ReplacePlaceHolder(message, "%RoomName%", this.name);
		message = ReplacePlaceHolder(message, "%Username%", Game.username);
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
