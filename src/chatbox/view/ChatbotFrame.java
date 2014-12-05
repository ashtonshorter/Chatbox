package chatbox.view;

import javax.swing.JFrame;

import chatbot.controller.ChatboxAppController;

public class ChatbotFrame extends JFrame {
	private ChatbotPanel basePanel;
	
	//starts frame and runs layout
	public ChatbotFrame(ChatboxAppController baseController) {
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	
	//loads panel and sets attributes
	private void setupFrame() {
		this.setContentPane(basePanel);
		this.setSize(490, 400);
		this.setResizable(false);
		
		setVisible(true);
	}

}
