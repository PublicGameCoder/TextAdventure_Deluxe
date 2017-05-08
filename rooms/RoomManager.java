package rooms;

import java.util.HashMap;

public class RoomManager {

	public static RoomManager RM;
	public HashMap<String, Room> rooms = new HashMap<String, Room>();
	
	public static RoomManager getManager() {
		if (RM == null) {
			RM = new RoomManager();
		}
		
		return RM;
	}
	
	private int unsolvednamecounter = 0;
	public void CreateRoom(String name, String[] args) {
		if (name == null) {
			unsolvednamecounter++;
			name = "room"+unsolvednamecounter;
		}
		Room room = new Room(name, args);
		rooms.put(name, room);
	}
	
	public Room getRoom(String arg) {
		for (Room rm : rooms.values()) {
			if (rm.getName().equalsIgnoreCase(arg)) {
				return rm;
			}
		}
		return null;
	}
}
