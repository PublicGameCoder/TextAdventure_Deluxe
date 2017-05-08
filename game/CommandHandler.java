package game;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import gui.Adventure;

public class CommandHandler {
	
	public static void ExecuteCommand(String str) {
		// Converts str to 2 variables called: label (Command label) & args (all arguments after the command label)
		
		String[] args = str.split(" ");
		final String label = (String) args[0];
		Object[] objectArray = ArrayUtils.remove(args, 0);
		args = Arrays.copyOf(objectArray, objectArray.length, String[].class);
		
		if (label.equalsIgnoreCase("get") && args.length > 0 ) {
			Adventure.ChatBoxOutput.setText(Adventure.ChatBoxOutput.getText() + "You got a " + args[0] +"!\n");
		}
		
		if (label.equalsIgnoreCase("open") && args.length > 0 ) {
			Adventure.ChatBoxOutput.setText(Adventure.ChatBoxOutput.getText() + "You opend a " + args[0] +"!\n");
		}
	}
}
