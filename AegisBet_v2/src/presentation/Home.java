package presentation;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import business.User;

public class Home {
	private JFrame frame;
	private User user;
	

	public void home(User user) {
		
		this.user = user;
		
		this.frame = new JFrame("Home Panel");
		this.frame.setSize(1200, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel panel = new JPanel();
		this.frame.add(setcontent(panel));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(Box.createHorizontalGlue());
	    JMenuItem alertUser, buyCoins;

	    // Menu
	    JMenu fileMenu = new JMenu("Profile");
	    JMenu fileMenu1 = new JMenu("History");
	    JMenu fileMenu2 = new JMenu("Logout");

	    // Menu Item (Drop down menus)
	    alertUser = new JMenuItem("Alter profile", new ImageIcon("user.png"));
	    alertUser.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            alertUserActionPerformed(evt);
	        }
	    });
	    

	
	    
	    buyCoins = new JMenuItem("Buy Coins", new ImageIcon("buy-coins.png"));
	    buyCoins.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	buyCoinsActionPerformed(evt);
	        }
	    });
	    


	    // Adding menu items to menu
	    fileMenu.add(alertUser);
	    fileMenu.add(buyCoins);

	    // adding menu to menu bar
	    menuBar.add(fileMenu);
	    menuBar.add(fileMenu1);
	    menuBar.add(fileMenu2);
	    
	  
	    
	    fileMenu1.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	 Home.this.frame.dispose();
			     new HistoryBet().history(Home.this.user);
		    }  
		}); 
	    
	    fileMenu2.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       Home.this.frame.dispose();
		       new LoginForm().loginPanel();

		    }  
		}); 

	    this.frame.setJMenuBar(menuBar);

		this.frame.setVisible(true);
	     
	     
	  }



	protected void buyCoinsActionPerformed(ActionEvent evt) {
		Home.this.frame.dispose();
    	new BuyCoins().buycoins(Home.this.user);
	}



	protected void alertUserActionPerformed(ActionEvent evt) {
		
		Home.this.frame.dispose();
    	new UserProfile().profile(Home.this.user.getId());
	}



	private Component setcontent(JPanel panel) {
		
		panel.setLayout(null);
		

		BufferedImage logoImg = null;
        try {
        	logoImg = ImageIO.read(new File("logo-small.png"));
        	        	
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        
        
        JLabel picLabel = new JLabel(new ImageIcon(logoImg));
        picLabel.setBounds(10, 10, logoImg.getWidth(), logoImg.getHeight());
        panel.add(picLabel);

        JLabel lbUserCoins = new JLabel("<html><font>"+this.user.getName()+" have </font> <font color='green'>"+this.user.getEssCoins()+"</font><font> coins</font>" );
	    lbUserCoins.setBounds(965, 50, 400, 20 );
        panel.add(lbUserCoins);
        
		//add table games
		panel.add(setTableGames());
		
		
		//bet panel
		
		JLabel blBet = new JLabel("Make our bet");
		blBet.setBounds(50, 500, 300, 20);
		panel.add(blBet);
		
		JLabel blCodeGame = new JLabel("Code Game:");
		blCodeGame.setBounds(50, 550, 100, 20);
		panel.add(blCodeGame);
		
		JTextField  txtCodeGame = new JTextField();
		txtCodeGame.setBounds(150, 550, 100, 20);
		panel.add(txtCodeGame);
		
		
		JLabel blTypeBet = new JLabel("Type of bet:");
		blTypeBet.setBounds(300, 550, 100, 20);
		panel.add(blTypeBet);
		
		// create an empty combo box with items of type String
		JComboBox<String> comboTypeBet = new JComboBox<String>();
		comboTypeBet.setBounds(400, 550, 150, 20);
		panel.add(comboTypeBet);
		 
		// add items to the combo box
		comboTypeBet.addItem("");
		comboTypeBet.addItem("Home Team");
		comboTypeBet.addItem("Tie");
		comboTypeBet.addItem("Visiting Team");
		
		
		JLabel blValueBet = new JLabel("Value of bet:");
		blValueBet.setBounds(600, 550, 100, 20);
		panel.add(blValueBet);
		
		JTextField  txtValueBet = new JTextField();
		txtValueBet.setBounds(700, 550, 100, 20);
		panel.add(txtValueBet);
		
		JButton  btnBet = new JButton("New Bet");
		btnBet.setBounds(950, 550, 100, 20);
		panel.add(btnBet);
		
		btnBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// make the bet , so should save information in the BD
            }
		});
		
		
	   
		  
		return panel;
	}



	private Component setTableGames() {
		
		// the rowData going to be == to array that came from the data base
		 Object rowData[][] = { 
				 { "1", "Braga vs Porto", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" },
				 { "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2" },
				 { "3", "Porto vs Benfica", "1.1", " 0.8" ," 2" },
				 { "4", "Porto vs Rio Ave", "1.1", " 0.8" ," 2" }
		};
		 
	    Object columnNames[] = { "Code Game", "Game", "Odds 1", "Odds 2", "Odds 3"};
	    JTable table = new JTable(rowData, columnNames);
	    table.setEnabled(false);

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(50, 70, 1100, 400);
		
		
		return scrollPane;
		
	}
}
