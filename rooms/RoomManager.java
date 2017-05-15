package rooms;

import java.util.HashMap;

public class RoomManager {

	public static RoomManager RM;
	public HashMap<RoomsEnum, Room> rooms = new HashMap<RoomsEnum, Room>();
	
	public enum RoomsEnum {
		Living_Room,
		Hallway,
		Upstairs,
		Your_Bedroom,
		Parent_Bedroom,
		Bath_Room,
		Garden,
		Street;
	}
	
	public RoomManager() {
		rooms.put(RoomsEnum.Living_Room, new LivingRoom());
		rooms.put(RoomsEnum.Hallway, new Hallway());
		rooms.put(RoomsEnum.Upstairs, new Upstairs());
		rooms.put(RoomsEnum.Your_Bedroom, new Your_Bedroom());
		rooms.put(RoomsEnum.Parent_Bedroom, new Parent_Bedroom());
		rooms.put(RoomsEnum.Bath_Room, new Bath_Room());
		rooms.put(RoomsEnum.Garden, new Garden());
		rooms.put(RoomsEnum.Street, new Street());
	}
	public static RoomManager getManager() {
		if (RM == null) {
			RM = new RoomManager();
		}
		
		return RM;
	}
	
	public Room getRoomByEnum(RoomsEnum arg) {
		for (Room rm : rooms.values()) {
			if (rm.getName().equalsIgnoreCase(arg.toString())) {
				return rm;
			}
		}
		return null;
	}
	public Room getRoomByName(String string) {
		// TODO Auto-generated method stub
		for (Enum<RoomsEnum> e : RoomsEnum.values()) {
			if (string.equalsIgnoreCase( e.toString())) {
				return rooms.get(e);
			}
		}
		return null;
	}
}
