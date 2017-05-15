package rooms;

public class Garden extends Room {

	public Garden() {
		this.setBasicText(new String[] {"You are now at room: %RoomName%!"} );
		this.name = "Garden";
	}
}
