package chatbot.controller;

import javax.swing.JOptionPane;
import chatbox.view.ChatbotView;

public class ChatboxAppController
{
	private ChatbotView appView;
	
	public ChatboxAppController() {
		appView = new ChatbotView(this);
	}
	
	public void start() {
		String result = appView.showChatbot("Ashton");
		
		if(result.equalsIgnoreCase("exit")) {
			Quit();
		}
	}
	
	private void Quit() {
		JOptionPane.showMessageDialog(null, "Goodbye cruel world");
		System.exit(0);
	}

}
