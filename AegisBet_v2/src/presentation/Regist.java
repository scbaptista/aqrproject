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

import javax.swing.JOptionPane;

public class Regist {

	private JFrame frame;

	public void register() {
		this.frame = new JFrame("Register Panel");
		this.frame.setSize(1200, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel panel = new JPanel();
		this.frame.add(setcontent(panel));

		this.frame.setVisible(true);
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
		
		JTextField  textName = new JTextField();
		textName.setBounds(800, 120, 300, 30);
		panel.add(textName);
		
		JTextField textEmail = new JTextField();
		textEmail.setBounds(800, 160, 300, 30);
		panel.add(textEmail);
		
		JPasswordField  textPass = new JPasswordField();
		textPass.setBounds(800, 200, 300, 30);
		panel.add(textPass);
		
		JButton  btnReturn = new JButton("Return");
		btnReturn.setBounds(800, 350, 100, 30);
		panel.add(btnReturn);
		
		JButton  btnRegist = new JButton("Regist");
		btnRegist.setBounds(950, 350, 100, 30);
		panel.add(btnRegist);
		
		BufferedImage myPicture = null;
        try {
        	myPicture = ImageIO.read(new File("img/logo.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(10, 10, 600, 600);
        panel.add(picLabel);
		
		btnRegist.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
                        AegisBet a = new AegisBet();
                        
                        if(a.register(textEmail.getText(), textPass.getText(), textName.getText())==1) {
                            Regist.this.frame.dispose();
                            new LoginForm().loginPanel();
                        } else 
                            JOptionPane.showMessageDialog(new JFrame(), "Email already in use!", "Dialog", JOptionPane.ERROR_MESSAGE);
                            Regist.this.frame.dispose();
                            new LoginForm().loginPanel();
	            }
	     });
		
		btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Regist.this.frame.dispose();
            	new LoginForm().loginPanel();
            }
		});
		
		return panel;
	}

}
