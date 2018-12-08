package presentation;

import business.AegisBet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm  {
        private AegisBet aBet;
	private JFrame frame;

	public void loginPanel() {
		this.aBet = new AegisBet();
		this.frame = new JFrame("Access Panel");
		this.frame.setSize(1200, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel panel = new JPanel();
		this.frame.add(setcontent(panel));

		this.frame.setVisible(true);
		
		
	
	}

	private JPanel setcontent(JPanel panel) {
		panel.setLayout(null);

		JLabel lbEmail = new JLabel("Email");
		lbEmail.setBounds(700, 120, 300, 30);
		panel.add(lbEmail);
		
		JLabel  lbPass = new JLabel("Password");
		lbPass.setBounds(700, 160, 200, 30);
		panel.add(lbPass);
		
		JTextField  textEmail = new JTextField();
		textEmail.setBounds(800, 120, 300, 30);
		panel.add(textEmail);
		
		JPasswordField  textPass = new JPasswordField();
		textPass.setBounds(800, 160, 300, 30);
		panel.add(textPass);
		
		JButton  btnLogin = new JButton("Login");
		btnLogin.setBounds(800, 250, 100, 30);
		panel.add(btnLogin);
		
		JButton  btnRegist = new JButton("New User");
		btnRegist.setBounds(950, 250, 100, 30);
		panel.add(btnRegist);
		
 
		BufferedImage logoImg = null;
        try {
        	logoImg = ImageIO.read(new File("img/logo.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        JLabel picLabel = new JLabel(new ImageIcon(logoImg));
        picLabel.setBounds(10, 10, 600, 600);
        panel.add(picLabel);
		
		btnLogin.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String email = textEmail.getText();
	     		String pass = textPass.getText();
                        
                        if(LoginForm.this.aBet.login(email, pass) == 1) {
   		    	
	     			  LoginForm.this.frame.dispose();
	     			   new Home().home(LoginForm.this.aBet);
	     		    	
	     		    }else{
	     		    	JOptionPane.showMessageDialog(new JFrame(), "Email or Password Incorrect!", "Dialog", JOptionPane.ERROR_MESSAGE);
	     		    }
	            }
	     });
		
		btnRegist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LoginForm.this.frame.dispose();
            	new Regist().register();
            }
		});
		  
		
 
		  
		return panel;
	}
}


