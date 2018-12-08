package presentation;

import business.AegisBet;
import business.Game;
import java.awt.Component;
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
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Home {
	private JFrame frame;
	private User user;
        private AegisBet aBet;
	

	public void home(AegisBet aBet) {
		this.aBet = aBet;
		this.user = aBet.getUser();
		
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
            JMenu fileMenu0 = new JMenu("Bet State");
	    JMenu fileMenu1 = new JMenu("History");
	    JMenu fileMenu2 = new JMenu("Logout");

	    // Menu Item (Drop down menus)
	    alertUser = new JMenuItem("Alter profile", new ImageIcon("img/user.png"));
	    alertUser.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            alertUserActionPerformed(evt);
	        }
	    });
	    

	
	    
	    buyCoins = new JMenuItem("Buy Coins", new ImageIcon("img/buy-coins.png"));
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
            menuBar.add(fileMenu0);
	    menuBar.add(fileMenu1);
	    menuBar.add(fileMenu2);
	    
	  
	    
	    fileMenu1.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	 Home.this.frame.dispose();
			     new HistoryBet().history(Home.this.aBet);
		    }  
		}); 
	    
            fileMenu0.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    Home.this.frame.dispose();
                    new StateBet().state(Home.this.aBet);
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
    	new BuyCoins().buycoins(Home.this.aBet);
	}



	protected void alertUserActionPerformed(ActionEvent evt) {
		
		Home.this.frame.dispose();
                new UserProfile().profile(Home.this.aBet);
	}



	private Component setcontent(JPanel panel) {
		
		panel.setLayout(null);
		

		BufferedImage logoImg = null;
        try {
        	logoImg = ImageIO.read(new File("img/logo-small.png"));
        	        	
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        
        
        JLabel picLabel = new JLabel(new ImageIcon(logoImg));
        picLabel.setBounds(10, 10, logoImg.getWidth(), logoImg.getHeight());
        panel.add(picLabel);

        JLabel userImg = new JLabel(this.user.getName(), new ImageIcon("img/user.png"), 0);
        JLabel userCoins = new JLabel(""+this.user.getEssCoins(), new ImageIcon("img/coins.png"), 0);
        JLabel lbUserCoins = new JLabel("<html><font>"+this.user.getName()+" have </font> <font color='green'>"+this.user.getEssCoins()+"</font><font> coins</font>" );
	userImg.setBounds(905, 20, 400, 20 );
        userCoins.setBounds(905, 40, 400, 20 );
        panel.add(userImg);
        panel.add(userCoins);
		//add table games
		panel.add(setTableGames());
		
		
		//bet panel
		
		JLabel blBet = new JLabel("Make a bet");
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
                int idGame = Integer.parseInt(txtCodeGame.getText());
                float amount = Float.parseFloat(txtValueBet.getText());
                int type = comboTypeBet.getSelectedIndex();
                
                if(Home.this.aBet.makeBet(idGame, amount, type)==1) {
                        JOptionPane.showMessageDialog(new JFrame(), "Your bet was made\n    GOOD LUCK  ", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                        
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Bet already made or closed\n     TRY AGAIN  ", "Dialog", JOptionPane.ERROR_MESSAGE);

                }
                setTableGames();
                txtCodeGame.setText("");
                comboTypeBet.setSelectedIndex(0);
                txtValueBet.setText("");
            }
		});
		  
		return panel;
	}



	private Component setTableGames() {
		
            Set<Game> games = this.aBet.getAvailableGames();
            Vector<Vector> rowData = new Vector<>();
            int i = 0;
            for(Game g : games) {
                Vector<String> line = new Vector<>();
                line.addElement("" + g.getId());
                line.addElement(g.getHouseTeam());
                line.addElement(g.getGuestTeam());
                line.addElement("" + g.getOddVictory());
                line.addElement("" + g.getOddDraw());
                line.addElement("" + g.getOddDefeat());
                line.addElement(g.getDate());
                line.addElement(g.getTimeBegin());
                    
                rowData.addElement(line);
            }
            
		 
	    Vector<String> columnNames = new Vector<>();
            columnNames.addElement("Code");
            columnNames.addElement("House Team");
            columnNames.addElement("Guest Team");
            columnNames.addElement("Odds 1");
            columnNames.addElement("Odds 2");
            columnNames.addElement("Odds 3");
            columnNames.addElement("Data");
            columnNames.addElement("Time");
            
	    JTable table = new JTable(rowData, columnNames);
	    table.setEnabled(false);

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(50, 70, 1100, 400);
		
		
            return scrollPane;
        }
}
