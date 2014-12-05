package chatbot.controller;

import javax.swing.JOptionPane;

import chatbox.view.ChatbotPanel;
import chatbot.model.Chatbot;
import chatbox.view.ChatbotFrame;
import chatbox.view.ChatbotView;

public class ChatboxAppController
{
	private ChatbotView appView;
	private Chatbot mySillyChatbot;
	private String name;
	private String startMessage;
	private String quitMessage;
	public String chatbotName;
	
	private ChatbotFrame appFrame;	//references the GUI JFrame object for the app
	
	public ChatboxAppController() {
		appView = new ChatbotView(this);
		mySillyChatbot = new Chatbot("Derf");
		
		appFrame = new ChatbotFrame(this);
		
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot. What is your name?";
		quitMessage = "Goodbye.";
	}
	
	//gets the chatbot and returns it
	public Chatbot getMyChatbot() {
		return mySillyChatbot;
	}
	//always running, greeting and checks if okay to quit
	public void start() {
		//((ChatbotPanel) appFrame.getContentPane()).showTextMessage(startMessage);
	}
	
	public String getChatbotDialog(String input)
	{
		String result = "";
		
		if(mySillyChatbot.QuitChecker(input))
		{
			Quit();
		}
		
		result = mySillyChatbot.processText(input);
		
		return result;
	}
	
	//Quits the appliation with message
	private void Quit() {
		appView.showChatbotMessage(quitMessage);
		System.exit(0);
	}

}
