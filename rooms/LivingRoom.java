package rooms;

public class LivingRoom extends Room {
	
	private String[] LookAtClockText = {"You are looking at an old and ordinary wooden clock!","Current time: %Time%"};
	

	public LivingRoom() {
		this.setBasicText(new String[] {"You are now at room: %RoomName%!"} );
		this.name = "Living_Room";
		this.lookCMDs = new String[] {"clock"};
	}
	
	public void LookAtClock() {
		PrintSlow(LookAtClockText, 75);
	}
}
