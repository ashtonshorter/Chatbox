package chatbox.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatboxAppController;
import chatbot.model.Chatbot;

public class ChatbotPanel extends JPanel  {
	private ChatboxAppController baseController;
	private Chatbot myChatbot;
	
	private SpringLayout baseLayout;
	private JButton firstBtn;
	private JTextField firstTextField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	private String startMessage;
	
	//starts everything
	public ChatbotPanel(ChatboxAppController baseController) {
		this.baseController = baseController;
		
		startMessage = "Welcome to the " + baseController.getMyChatbot().getName() + " chatbot. What is your name?";
		
		firstBtn = new JButton("Send");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(5, 30);
		chatArea.setLineWrap(true);
		chatPane = new JScrollPane(chatArea);
		
		chatArea.setText(startMessage);
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPane() {
		chatArea.setWrapStyleWord(true);
	}
	
	//sets up the panel with layout options and widgets
	private void setupPanel() {
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		this.setSize(400, 400);
		
		this.add(firstBtn);
		this.add(firstTextField);
		
		this.add(chatPane);
	}
	
	//sets the placement for widgets
	private void setupLayout() {
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 255, SpringLayout.NORTH, this);
		
		baseLayout.putConstraint(SpringLayout.NORTH, firstBtn, -1, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstBtn, 10, SpringLayout.EAST, firstTextField);
		baseLayout.putConstraint(SpringLayout.EAST, firstBtn, -46, SpringLayout.EAST, this);
		
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 75, SpringLayout.WEST, this);
	}
	
	
	//sets listeners for actions on objects
	private void setupListeners() {
		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				chatArea.append("\n" + (firstTextField.getText()));
				firstTextField.setText("");
			}
		});
		
		firstTextField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if(event.getKeyCode() == KeyEvent.VK_ENTER) {
					chatArea.append("\n" + (firstTextField.getText()));
					firstTextField.setText("");
				}
			}
		});
	}

	
}
