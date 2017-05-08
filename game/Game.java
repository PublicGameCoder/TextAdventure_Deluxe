package game;

import java.awt.EventQueue;

import gui.Adventure;
import gui.Main_Menu;
import rooms.RoomManager;

public class Game{
	
    public static String username = "Guest";
    
    public static void main(String[] args) throws InterruptedException {
    	
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adventure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adventure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adventure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adventure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    	// Creating rooms
    	createRooms();
    	
        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Menu().setVisible(true);
            }
        });
    }

	private static void createRooms() {
		RoomManager.getManager().CreateRoom("Living Room", new String[] {"Hello %Username%!","We're now in the %RoomName%!", "and its now: %Time%!"});
	}
}