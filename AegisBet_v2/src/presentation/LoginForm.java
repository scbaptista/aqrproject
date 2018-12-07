package presentation;

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

public class LoginForm  {

	private JFrame frame;

	public void loginPanel() {
		
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
        	logoImg = ImageIO.read(new File("logo.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        JLabel picLabel = new JLabel(new ImageIcon(logoImg));
        picLabel.setBounds(10, 10, 600, 600);
        panel.add(picLabel);
		
		btnLogin.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String uname = textEmail.getText();
	     		    String pass = textPass.getText();
//	     		    AegisBet user = new AegisBetDAO().login(uname, pass);
	     		    

	     		    User user = new User();
	     		    user.setName("Sandra Baptista");
	     		    user.setEssCoins(12);
//	     		    if(user != null){
	     		   if(uname.equals("ss") && pass.equals("ss")){
   		    	
	     			  LoginForm.this.frame.dispose();
	     			   new Home().home(user);
	     		    	
	     		    }else{
	     		    	System.out.println("Erro");
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


