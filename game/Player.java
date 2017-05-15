package game;

import rooms.Room;

public class Player {
	
	private Room currentRoom;
	private double Health = 100.5;
	
	/**
	 * 
	 * @return the room the player is currently in
	 */
	public Room getRoom() {
		return currentRoom;
	}
	
	/**
	 * Makes the player enter a room
	 * @param the room to enter
	 */
	public void enterRoom(Room r) {
		currentRoom = r;
	}

	/**
	 * checks if the player is still alive
	 * @return if the player is alive
	 */
	public boolean isAlive() {
		boolean result = true;
		
		if (this.Health == 0.0){
			result = false;
		}
		return result;
	}
	
	/**
	 * Damages the player by a specified amount
	 * @param amount of damage
	 */
	public void damage(double amount) {
		
		this.Health -= amount;
		
		if (this.Health <= 0.0) {
			this.Health = 0.0;
		}
	}
	
	/**
	 * Heals the player by a specified amount
	 * @param amount to heal
	 */
	public void heal(double amount) {
		
		this.Health += amount;
		
		if (this.Health >= 100.0) {
			this.Health = 100.0;
		}
	}
}
