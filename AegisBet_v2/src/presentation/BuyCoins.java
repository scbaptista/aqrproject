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
import javax.swing.JTextField;

import business.User;

public class BuyCoins {
        private AegisBet aBet;
	private JFrame frame;
	private JTextField textBuyCoins;
	private User user;

	public void buycoins(AegisBet aBet) {
                this.aBet = aBet;
		this.user = aBet.getUser();
		
		this.frame = new JFrame("Buy Coins");
		this.frame.setSize(1200, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel panel = new JPanel();
		this.frame.add(setcontent(panel));

		this.frame.setVisible(true);
		
	}

	private Component setcontent(JPanel panel) {
		panel.setLayout(null);

		JLabel lbBuyCoins = new JLabel("Number of coins");
		lbBuyCoins.setBounds(700, 120, 300, 30);
		panel.add(lbBuyCoins);
		
		this.textBuyCoins = new JTextField();
		textBuyCoins.setBounds(800, 120, 300, 30);
		panel.add(textBuyCoins);
		
		
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
            	BuyCoins.this.frame.dispose();
            	new Home().home(BuyCoins.this.aBet);
            	
            	
            }
		});
		
		btnSbumit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//TO DO 		    
                String v = BuyCoins.this.textBuyCoins.getText();
                float value = Float.parseFloat(v);
             
            	BuyCoins.this.aBet.updateCoins(value);
            	
            	
            	BuyCoins.this.frame.dispose();
            	new Home().home(BuyCoins.this.aBet);
            	
            	
            }
		});
		
		return panel;
	}
	

}
