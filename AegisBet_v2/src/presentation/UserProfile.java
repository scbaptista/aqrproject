package presentation;

import business.AegisBet;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import business.User;

public class UserProfile {

        private AegisBet aBet;
	private JFrame frame;
	private User user;
	private JTextField textName;
	private JTextField textEmail;
	private JPasswordField textPass;

	public void profile(AegisBet aBet) {
                this.aBet = aBet;
		this.frame = new JFrame("User Profile");
		this.frame.setSize(1200, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel panel = new JPanel();
		this.frame.add(setcontent(panel));

		this.frame.setVisible(true);
		
		setUserInformation(aBet.getUser());
	}

	private void setUserInformation(User u) {
		this.user = u;
		//this.user = new AegisBet().getUser(id);
		this.textName.setText(this.user.getName());
		this.textEmail.setText(this.user.getEmail());
		this.textPass.setText(this.user.getPassword());
	}

	private Component setcontent(JPanel panel) {
		panel.setLayout(null);

		JLabel lbName = new JLabel("Name");
		lbName.setBounds(700, 120, 300, 30);
		panel.add(lbName);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setBounds(700, 160, 300, 30);
		panel.add(lbEmail);
		
		JLabel  lbPass = new JLabel("Password");
		lbPass.setBounds(700, 200, 300, 30);
		panel.add(lbPass);
		
		this.textName = new JTextField();
		textName.setBounds(800, 120, 300, 30);
		panel.add(textName);
		
		this.textEmail = new JTextField();
		textEmail.setBounds(800, 160, 300, 30);
		panel.add(textEmail);
		
		this.textPass = new JPasswordField();
		textPass.setBounds(800, 200, 300, 30);
		panel.add(textPass);
		
		JButton  btnReturn = new JButton("Return");
		btnReturn.setBounds(800, 350, 100, 30);
		panel.add(btnReturn);
		
		JButton  btnSbumit = new JButton("Save");
		btnSbumit.setBounds(950, 350, 100, 30);
		panel.add(btnSbumit);

		
		BufferedImage myPicture = null;
        try {
        	myPicture = ImageIO.read(new File("img/logo.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(10, 10, 600, 600);
        panel.add(picLabel);
        
        
        
		btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	UserProfile.this.frame.dispose();
            	new Home().home(UserProfile.this.aBet);
            	
            	
            }
		});
		
		btnSbumit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	UserProfile.this.user.setName(textName.getText());
            	UserProfile.this.user.setEmail(textEmail.getText());
            	UserProfile.this.user.setPassword(textPass.getText());
     		    
            	//TO DO 	
            	// update os dados do utilizador usando os dados que est�o a UserProfile.this.user 
            	
            	
            	
            	UserProfile.this.frame.dispose();
            	new Home().home(UserProfile.this.aBet);
            	
            	
            }
		});
		
		return panel;
	}

}
