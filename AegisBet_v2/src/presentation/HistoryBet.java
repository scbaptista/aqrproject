package presentation;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import business.User;

public class HistoryBet {

	private User user;
	private JFrame frame;

	public void history(User user) {
		this.user = user;
		
		this.frame = new JFrame("Bet history");
		this.frame.setSize(1200, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		this.frame.add(setcontent(panel));
		
		this.frame.setVisible(true);
		
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
        
		// the rowData going to be == to array that came from the data base
				 Object rowData[][] = { 
						 { "", "", "1", "Braga vs Porto", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "3", "Porto vs Benfica", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "1", "Braga vs Porto", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "3", "Porto vs Benfica", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "1", "Braga vs Porto", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "3", "Porto vs Benfica", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "1", "Braga vs Porto", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "3", "Porto vs Benfica", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "1", "Braga vs Porto", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "3", "Porto vs Benfica", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "1", "Braga vs Porto", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "2", "Braga vs Guimarens", "1.1", " 0.8" ," 2", "", "" },
						 { "", "", "3", "Porto vs Benfica", "1.1", " 0.8" ," 2", "", "" }
				};
				 
			    Object columnNames[] = { "Data", "Hours", "Code Game", "Game", "Odds 1", "Odds 2", "Odds 3", "Bet Value", "Goals"};
			    JTable table = new JTable(rowData, columnNames);
			    table.setEnabled(false);

			    JScrollPane scrollPane = new JScrollPane(table);
			    scrollPane.setBounds(50, 70, 1100, 400);
			    
		panel.add(scrollPane);
		
		JButton  btnReturn = new JButton("Return");
		btnReturn.setBounds(950, 550, 100, 20);
		panel.add(btnReturn);
		
		btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	HistoryBet.this.frame.dispose();
            	new Home().home(HistoryBet.this.user);
            }
		});
		
		
			    
		return panel;
	}

}
