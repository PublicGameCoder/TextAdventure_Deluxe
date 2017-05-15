package rooms;

public class Street extends Room {

	public Street() {
		this.setBasicText(new String[] {"You are now at room: %RoomName%!"} );
		this.name = "Street";
	}
}
