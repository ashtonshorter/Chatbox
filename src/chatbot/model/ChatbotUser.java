package chatbot.model;

public class ChatbotUser
{
	private String userName;
	private int userAge;
	private double userWeight;
	private boolean playsGames;
	private boolean isMale;
	
	public ChatbotUser() {
		this.userName = "";
		this.userAge = -1;
		this.userWeight = -1;
		this.playsGames = true;
		this.isMale = true;
	}
	
	//all of the getters and setters for user info
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getUserAge()
	{
		return userAge;
	}
	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}
	public double getUserWeight()
	{
		return userWeight;
	}
	public void setUserWeight(double userWeight)
	{
		this.userWeight = userWeight;
	}
	public boolean playsGames()
	{
		return playsGames;
	}
	public void setPlaysGames(boolean playsSports)
	{
		this.playsGames = playsSports;
	}
	public boolean isMale()
	{
		return isMale;
	}
	public void setMale(boolean isMale)
	{
		this.isMale = isMale;
	}
}
