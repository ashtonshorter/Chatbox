package chatbox.view;

import javax.swing.JOptionPane;
import chatbot.controller.ChatboxAppController;
import chatbot.model.Chatbot;

public class ChatbotView
{
	private ChatboxAppController baseController;
	
	public ChatbotView(ChatboxAppController baseController) {
		this.baseController = baseController;
	}
	
	//displays all of the text chatbot is saying
	public String showChatbotDialog(String currentInput) {
		String result = "";
		
		result = JOptionPane.showInputDialog(null, baseController.getMyChatbot().getName() + " says: " + currentInput);
		
		return result;
	}
	
	//displays the chatbots message
	public void showChatbotMessage(String currentInput) {
		JOptionPane.showMessageDialog(null, baseController.getMyChatbot().getName() + " says: " + currentInput);
	}
}
