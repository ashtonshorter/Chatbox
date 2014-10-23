package chatbot.model;

import java.util.ArrayList;
/*
 * The chatbot model class. Used for checking and manipulating Strings
 * @author Ashton Shorter
 * @version 1.1 9/26/14
 */
public class Chatbot
{
	private String name;
	private int chatCount;
	private ArrayList<String> memeList;
	
	//Creates a chatbot object with he supplied name and initializes the current number of chats to zero
	public Chatbot(String name) {
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
	}

	//returns the name of the chatbot
	public String getName() {
		return name;
	}
	
	//gives you the number of chats
	public int getChatCount() {
		return chatCount;
	}
	
	//sets the chatbot's name
	public void setName(String name) {
		this.name = name;
	}
	
	private void fillTheMemeList() {
		memeList.add("Puppies");
		memeList.add("Doge");
		memeList.add("y u no");
		memeList.add("forever alone");
		memeList.add("darth vader");
		memeList.add("wut");
	}
	
	//increments the chat count
	private void updateChatCount() {
		chatCount++;
	}
	
	//processes the text and randomly chooses what the topic should be
	public String processText(String userText) {
		String processedText = "";
		updateChatCount();
		
		int randomChoice = (int)(Math.random() * 3);
		
		if(userText != null) {
			if(randomChoice == 0) {
				if(stringChecker(userText)) {
					processedText = "Too long";
				} else {
					processedText = "Short words";
				}
			} else if(randomChoice == 1) {
				if(contentChecker(userText)) {
					processedText = "Yup, you know the secret";
				} else {
					processedText = "Try again another time";
				}
			} else {
				if(memeChecker(userText)) {
					processedText = "Hey, you found a meme: " + userText;
					processedText = "Isn't that cool.";
				} else {
					processedText = "Boring, that wasn't a meme.";
				}
			}
		} else {
			processedText = "Use words pls.";
		}
		
		return processedText;
	}
	
	//checks to see if the string is too long
	private boolean stringChecker(String check) {
		boolean tooLong = false;
		
		if(check.length() > 20) {
			tooLong = true;
		}
		
		return tooLong;
	}
	
	//checks if the content contains something about a topic
	private boolean contentChecker(String check) {
		boolean videoGames = false;
		
		if(check.contains("Zelda")) {
			videoGames = true;
		}
		
		return videoGames;
	}
	
	//checks if the user is talking about memes
	private boolean memeChecker(String input) {
		boolean isAMeme = false;
		
		for(String currentMeme : memeList) {
			if(input.equalsIgnoreCase(currentMeme)) {
				isAMeme = true;
			}
		}
		
		return isAMeme;
	}
	
	//checks if user wants to quit application
	public boolean QuitChecker(String input) {
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("bye"))
			okToQuit = true;

		return okToQuit;
	}
}
