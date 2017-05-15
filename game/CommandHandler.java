package game;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import gui.Adventure;
import rooms.LivingRoom;

public class CommandHandler {
	
	private static String[] args;
	private static String label;
	
	/**
	 * Turns
	 * @param str
	 * is the command string to execute!
	 */
	public static void ExecuteCommand(String str) {
		// Converts str to 2 variables called: label (Command label) & args (all arguments after the command label)
		
		ConvertCommand(str);
		
		if (label.equalsIgnoreCase("look")) {
			if (args.length > 0 && args[0].equalsIgnoreCase("list")) {
				String [] list = Adventure.getPlayer().getRoom().getlookCMDs();
				Adventure.ChatBoxOutput.setText(Adventure.ChatBoxOutput.getText() + "List of look commands:" +"\n");
				for (String string : list) {
					Adventure.ChatBoxOutput.setText(Adventure.ChatBoxOutput.getText() + string +"\n");
				}
			}else if (args.length > 0 && args[0].equalsIgnoreCase("room")){
				Adventure.getPlayer().getRoom().PrintSlow(Adventure.getPlayer().getRoom().getBasicText(), 75);
			}else if (args.length > 0 && args[0].equalsIgnoreCase("clock")) {
				((LivingRoom) Adventure.getPlayer().getRoom() ).LookAtClock();
			}else {
				Adventure.getPlayer().getRoom().PrintSlow(Adventure.getPlayer().getRoom().getBasicText(), 75);
			}
		}
	}

	/**
	 * Converts a string to 2 variables called: label (Command label) & args (all arguments after the command label)
	 * @param str
	 * the string to convert
	 */
	private static void ConvertCommand(String str) {
		
		args = str.split(" ");
		label = (String) args[0];
		Object[] objectArray = ArrayUtils.remove(args, 0);
		args = Arrays.copyOf(objectArray, objectArray.length, String[].class);
		
	}
}
