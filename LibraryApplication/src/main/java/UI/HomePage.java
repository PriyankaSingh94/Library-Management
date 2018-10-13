package main.java.UI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HomePage {
	
	HomePage hmpg;
	JFrame frame;
	public JPanel mainPanel;
	JPanel topPanel;
	JPanel sidePanel;
	JPanel panel;
	JLabel imgLbl;
	JButton barBtn;
	JButton userBtn;
	JButton stdBtn;
	JButton tchrBtn;
	JButton libnBtn;
	JButton booksBtn;
	JButton contctBtn;
	JButton proflBtn;
	boolean isOpen;

	public void welcome() throws IOException {

		frame = new JFrame();
		mainPanel = new JPanel();
		topPanel = new JPanel();
		sidePanel = new JPanel(new FlowLayout());
		panel = new JPanel();
		barBtn = new JButton(new ImageIcon(ImageIO
				.read(new File("C:/Users/pc/git/Library-Management/LibraryApplication/src/main/resources/sidemenu.png"))
				.getScaledInstance(25, 30, Image.SCALE_SMOOTH)));
		barBtn.setBorder(BorderFactory.createEmptyBorder());
		barBtn.addActionListener(new BarBtnListener());
		userBtn = new JButton("Users");
		stdBtn = new JButton("Students");
		tchrBtn = new JButton("Teachers");
		libnBtn = new JButton("Librarian");
		booksBtn = new JButton("Books");
		contctBtn = new JButton("Contact");
		proflBtn = new JButton("Profile");
		JLabel welcmMsg = new JLabel("Welcome to APJ Abdul Kalam Library");
		booksBtn.setBackground(Color.orange);
		contctBtn.setBackground(Color.orange);
		proflBtn.setBackground(Color.orange);
		mainPanel.setBackground(Color.GRAY);
		topPanel.setBackground(Color.green);
		topPanel.add(barBtn);
		topPanel.add(Box.createHorizontalStrut(50));
		topPanel.add(booksBtn);
		topPanel.add(Box.createHorizontalStrut(50));
		topPanel.add(contctBtn);
		topPanel.add(Box.createHorizontalStrut(50));
		topPanel.add(proflBtn);
		mainPanel.add(topPanel, BorderLayout.NORTH);	
		mainPanel.add(new JLabel(new ImageIcon("C:/Users/pc/Downloads/MyLibrary.JPG")), BorderLayout.SOUTH);
		frame.getContentPane().add(mainPanel);
		frame.setTitle("APJ Abdul Kalam Library");
		frame.setVisible(true);
		frame.setSize(600, 600);
		topPanel.setPreferredSize(new Dimension(frame.getWidth(), 40));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		frame.setVisible(true);
	}

	public void sidePanel(){
		sidePanel.setBackground(Color.green);
		userBtn.setBackground(Color.orange);
		stdBtn.setBackground(Color.orange);
		tchrBtn.setBackground(Color.orange);
		libnBtn.setBackground(Color.orange);
		frame.getContentPane().setLayout(null);
		sidePanel.setBounds(0, 45, 130, 420);	
//		sidePanel.setPreferredSize(new Dimension(50, 200));
		sidePanel.setLayout(null);
		sidePanel.add(userBtn);
		userBtn.setBounds(5, 10, 80, 40);
		sidePanel.add(stdBtn);
		stdBtn.setBounds(5, 60, 100, 40);
		sidePanel.add(tchrBtn);
		tchrBtn.setBounds(5, 110, 100, 40);
		sidePanel.add(libnBtn);
		libnBtn.setBounds(5, 170, 100, 40);
		sidePanel.setBackground(Color.red);
		frame.getContentPane().add(sidePanel);
		frame.setVisible(true);		
	}
	class BooksBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent evnt) {

		}
	}

	class StudentBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent evnt) {

		}
	}

	class TeacherBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent evnt) {

		}
	}

	class UserBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent evnt) {

		}
	}

	class LibrarianBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent evnt) {

		}
	}

	class ContactListener implements ActionListener {

		public void actionPerformed(ActionEvent evnt) {

		}
	}

	class ProfileBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent evnt) {

		}
	}
	
	class BarBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent evnt) {
			sidePanel();
//			if(isOpen) {
//				isOpen = false;
//				frame.getContentPane().remove(sidePanel);
//			}
//			else {
//				isOpen = true;
//				sidePanel();
//			}
		}
	}

}
