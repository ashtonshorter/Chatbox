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
	private ArrayList<String> userInputList;
	private ChatbotUser myUser;
	private String contentArea;
	
	//Creates a chatbot object with he supplied name and initializes the current number of chats to zero
	public Chatbot(String name) {
		memeList = new ArrayList<String>();
		userInputList = new ArrayList<String>();
		this.name = name;
		contentArea = "";
		chatCount = 0;
		myUser = new ChatbotUser();
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
	
	//returns user
	public ChatbotUser getMyUser() {
		return myUser;
	}
	
	//sets user
	public void setMyUser(ChatbotUser myUser) {
		this.myUser = myUser;
	}
	
	//sets the chatbot's name
	public void setName(String name) {
		this.name = name;
	}
	
	//fills the meme list with memes
	private void fillTheMemeList() {
		memeList.add("Puppies");
		memeList.add("Doge");
		memeList.add("y u no");
		memeList.add("forever alone");
		memeList.add("darth vader");
		memeList.add("wut");
	}
	
	//processes the text and randomly chooses what the topic should be
	public String processText(String userText) {
		String processedText = "";
		
		
		//ask questions to user and update chat
		if(getChatCount() < 5) {
			if(getChatCount() == 0) {
				myUser.setUserName(userText);
				processedText = "Good name " + myUser.getUserName() + " how old are you?";
				
			} else if(getChatCount() == 1) {
				int userAge = Integer.parseInt(userText);
				myUser.setUserAge(userAge);
				processedText = ("Wow, " + " thats cool ");
				
			} else if (getChatCount() == 2) {
				double userWeight = Double.parseDouble(userText);
				myUser.setUserWeight(userWeight);
				processedText = "Wow, interesting " + myUser.getUserName() + " do you play games?";
				
			} else if (getChatCount() == 3) {
				boolean playsGames = Boolean.parseBoolean(userText);
				myUser.setPlaysGames(playsGames);
				processedText = "thats cool" + myUser.getUserName() + " are you a boy or a girl?";
				
			} else {
				boolean userGender = Boolean.parseBoolean(userText);
				myUser.setMale(userGender);
				processedText = "that's cool, " + myUser.getUserName() + " What do you want to talk about????????";
			}
		}
		
		//generates random number between 0 and 6
		int randomChoice = (int)(Math.random() * 7);
		
		//randomly chooses the topic while not null
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
				
			} else if(randomChoice == 3) {
				processedText = userTopic(userText);
				
			} else if(randomChoice == 4) {
				userInputList.add(userText);
				processedText = "Thank you for the comment";
			}
			
			else if(randomChoice == 5) {
				if(mashChecker(userText)) {
					processedText = mashingDetected(userText);
				} else {
					processedText = noMashingDetected(userText);
				}
				
			} else if(randomChoice == 6) {
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
		
		updateChatCount();
		return processedText;
	}
	
	//if the user is mashing, return their mashing several times
	private String mashingDetected(String input) {
		String mashed = "";
		
		mashed = input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);
		
		return mashed;
	}
	
	//if they are not mashing thank them, and return what they didn't mash with
	private String noMashingDetected(String input) {
		String noMashing = "Thank you for not mashing your keyboard with: ";
		
		if(input.length() > 1) {
			noMashing += input.substring(input.length()/3, input.length()/2);
		}
		
		return noMashing;
	}
	
	//checks for keyboard mashing
	private boolean mashChecker(String input) {
		boolean isMashing = false;
		
		if(input.indexOf("asdf") > -1) {
			isMashing = true;
		}
		
		return isMashing;
	}
	
	//gives the right output for the conversation
	private String userTopic(String userInput)
	{
		String userBasedResponse = "";

		int randomUserTopic = (int) (Math.random() * 6);

		switch (randomUserTopic)
		{
		case 1:
			userBasedResponse = myUser.playsGames() + " is the response to games";
			break;
		case 0:
			userBasedResponse = myUser.getUserName() + " is a silly name";
			break;
		default:
			userBasedResponse = myUser.getUserAge() + " is old";
			break;
		}

		return userBasedResponse;
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
		boolean hasMyContent = false;
		
		if(check.contains(contentArea)) {
			hasMyContent = true;
		}
		
		return hasMyContent;
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
	
	//checks the input
	private boolean userInputChecker(String userInput) {
		boolean matchesInput = false;
		
		for(int loopCount = 0; loopCount < userInputList.size(); loopCount++) {
			if(userInput.equalsIgnoreCase(userInputList.get(loopCount))) {
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}
		}
		
		return matchesInput;
	}
	
	//increments the chat count
	private void updateChatCount() {
		chatCount++;
	}
	
	//checks if user wants to quit application
	public boolean QuitChecker(String input) {
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("bye"))
			okToQuit = true;

		return okToQuit;
	}
}
