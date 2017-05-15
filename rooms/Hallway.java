package rooms;

public class Hallway extends Room {

	public Hallway() {
		this.setBasicText(new String[] {"You are now at room: %RoomName%!"} );
		this.name = "Hallway";
	}
}
