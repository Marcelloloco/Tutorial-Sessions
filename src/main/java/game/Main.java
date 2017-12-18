package game;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Gameplay gameplay = new Gameplay();
		frame.setBounds(200, 200, 700, 600);
		frame.setTitle("Tutorium Game");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gameplay);
	}

}
