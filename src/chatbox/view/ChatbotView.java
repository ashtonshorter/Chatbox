package chatbox.view;
import javax.swing.JOptionPane;

import chatbot.controller.ChatboxAppController;

public class ChatbotView
{
	private ChatboxAppController baseController;
	
	public ChatbotView(ChatboxAppController baseController) {
		this.baseController = baseController;
	}
	
	public String showChatbot(String currentInput) {
		String result = "";
		
		JOptionPane.showMessageDialog(null,"Hello, " + currentInput);
		result = JOptionPane.showInputDialog(null, "Are you done?");
		return result;
	}
}
