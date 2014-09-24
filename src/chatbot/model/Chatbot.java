package chatbot.model;

public class Chatbot
{
	private String name;
	private int chatCount;
	
	public Chatbot(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getChatCount() {
		return chatCount;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private void updateChatCount() {
		chatCount++;
	}
}
