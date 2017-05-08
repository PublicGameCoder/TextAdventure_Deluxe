/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import game.CommandHandler;
import game.Game;
import rooms.RoomManager;

/**
 *
 * @author mike de groot
 */
@SuppressWarnings("serial")
public class Adventure extends JFrame {
	
    private JButton BackButton;
    private JPanel BackToMainMenu;
    private JPanel ChangeUsernamePanel;
    private JTextField ChatBoxInput;
    public static JTextArea ChatBoxOutput;
    private JLabel ChatMessageLabel;
    private JMenuItem GameMenubutton;
    private JPanel GamePanel;
    public static							 JPanel ItemBox;
    private JLabel ItemsLabel;
    private JScrollPane OutputScrollPane;
    private JButton SendButton;
    private JLabel TimePostedLabel;
    private JMenuItem UsernameMenubutton;
    private JLabel jLabel2;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;

    private final Main_Menu main_Menu;
    public static boolean CMDExpected = false;
    
    public Adventure(Main_Menu main_Menu) {
        this.main_Menu = main_Menu;
        initComponents();
        GamePanel.setVisible(true);
        ChangeUsernamePanel.setVisible(false);
    }

    private void initComponents() {
    	
        GamePanel = new JPanel();
        OutputScrollPane = new JScrollPane();
        ChatBoxOutput = new JTextArea();
        ChatBoxInput = new JTextField();
        ItemBox = new JPanel();
        BackToMainMenu = new JPanel();
        BackButton = new JButton();
        ItemsLabel = new JLabel();
        ChatMessageLabel = new JLabel();
        TimePostedLabel = new JLabel();
        SendButton = new JButton();
        ChangeUsernamePanel = new JPanel();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel2 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        GameMenubutton = new JMenuItem();
        UsernameMenubutton = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TextAdventure Deluxe");
        setBackground(new Color(0, 204, 255));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        ChatBoxOutput.setColumns(2);
        ChatBoxOutput.setRows(5);
        ChatBoxOutput.setEditable(false);
        OutputScrollPane.setViewportView(ChatBoxOutput);

        GroupLayout ItemBoxLayout = new GroupLayout(ItemBox);
        ItemBox.setLayout(ItemBoxLayout);
        ItemBoxLayout.setHorizontalGroup(
            ItemBoxLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ItemBoxLayout.setVerticalGroup(
            ItemBoxLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        BackButton.setText("Back to main menu");
        BackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        GroupLayout BackToMainMenuLayout = new GroupLayout(BackToMainMenu);
        BackToMainMenu.setLayout(BackToMainMenuLayout);
        BackToMainMenuLayout.setHorizontalGroup(
            BackToMainMenuLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(BackButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        BackToMainMenuLayout.setVerticalGroup(
            BackToMainMenuLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(BackButton, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        ItemsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ItemsLabel.setText("Items");

        ChatMessageLabel.setText("Chat message");

        TimePostedLabel.setText("Time Pasted");

        SendButton.setText("Send");
        SendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        GroupLayout GamePanelLayout = new GroupLayout(GamePanel);
        GamePanel.setLayout(GamePanelLayout);
        GamePanelLayout.setHorizontalGroup(
            GamePanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, GamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GamePanelLayout.createParallelGroup(Alignment.TRAILING)
                    .addComponent(ItemsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackToMainMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(GamePanelLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(OutputScrollPane)
                    .addGroup(GamePanelLayout.createSequentialGroup()
                        .addComponent(ChatMessageLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(TimePostedLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GamePanelLayout.createSequentialGroup()
                        .addComponent(ChatBoxInput)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(SendButton)))
                .addContainerGap())
        );
        GamePanelLayout.setVerticalGroup(
            GamePanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, GamePanelLayout.createSequentialGroup()
                .addGroup(GamePanelLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(ItemsLabel)
                    .addComponent(ChatMessageLabel)
                    .addComponent(TimePostedLabel))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(GamePanelLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(ItemBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OutputScrollPane, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(GamePanelLayout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(BackToMainMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChatBoxInput)
                    .addComponent(SendButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        ChatBoxInput.getAccessibleContext().setAccessibleName("");
        TimePostedLabel.getAccessibleContext().setAccessibleName("ChatTime");
        TimePostedLabel.getAccessibleContext().setAccessibleDescription("");

        jTextArea1.setBackground(new java.awt.Color(255, 255, 204));
        jTextArea1.setColumns(1);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setText(Game.username);
        jTextArea1.setToolTipText("");
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Change your nickname!");

        GroupLayout ChangeUsernamePanelLayout = new GroupLayout(ChangeUsernamePanel);
        ChangeUsernamePanel.setLayout(ChangeUsernamePanelLayout);
        ChangeUsernamePanelLayout.setHorizontalGroup(
            ChangeUsernamePanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, ChangeUsernamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChangeUsernamePanelLayout.createParallelGroup(Alignment.TRAILING)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        ChangeUsernamePanelLayout.setVerticalGroup(
            ChangeUsernamePanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, ChangeUsernamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Options");

        GameMenubutton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
        GameMenubutton.setText("Game");
        GameMenubutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GameMenubuttonActionPerformed(evt);
            }
        });
        jMenu1.add(GameMenubutton);

        UsernameMenubutton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
        UsernameMenubutton.setText("Username");
        UsernameMenubutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UsernameMenubuttonActionPerformed(evt);
            }
        });
        jMenu1.add(UsernameMenubutton);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(GamePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ChangeUsernamePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(GamePanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(ChangeUsernamePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("Game");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }

    private void BackButtonActionPerformed(ActionEvent evt) {
        main_Menu.setVisible(true);
        this.setVisible(false);
    }

    private void GameMenubuttonActionPerformed(ActionEvent evt) {
    	Game.username = jTextArea1.getText();
        GamePanel.setVisible(true);
        ChangeUsernamePanel.setVisible(false);
    }
    private void UsernameMenubuttonActionPerformed(ActionEvent evt) {
    	jTextArea1.setText(Game.username);
        GamePanel.setVisible(false);
        ChangeUsernamePanel.setVisible(true);
    }

    private void SendButtonActionPerformed(ActionEvent evt) {
        if (CMDExpected == false) {
        	
        	
        	RoomManager.getManager().getRoom("Living Room").PrintSlow(75);
        	
        	
        	return;
        }
        String cmd = ChatBoxInput.getText();
        CommandHandler.ExecuteCommand(cmd);
        //ChatBoxOutput.setText(ChatBoxOutput.getText() + cmd);
        ChatBoxInput.setText("");
    }
    
    public void clearChatBoxOutput() {
    	ChatBoxOutput.setText("");
    }
}
