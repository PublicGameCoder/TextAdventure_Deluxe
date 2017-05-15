package rooms;

public class Upstairs extends Room {

	public Upstairs() {
		this.setBasicText(new String[] {"You are now at room: %RoomName%!"} );
		this.name = "Upstairs";
	}
}
