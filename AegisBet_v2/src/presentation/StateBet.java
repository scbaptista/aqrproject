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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import business.User;
import java.util.Vector;
import javax.swing.JOptionPane;

public class StateBet implements UserObserver {
        
        private AegisBet aBet;
	private User user;
	private JFrame frame;
        private JPanel panel;
    private Vector<Vector> rowData;
    private JTable table;
    private Vector<Object> columnNames;
       

	public void state(AegisBet aBet) {
                this.aBet = aBet;
		this.user = aBet.getUser();
		
		this.frame = new JFrame("Bet State");
		this.frame.setSize(1200, 700);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		this.frame.add(setcontent(panel));
		
		this.frame.setVisible(true);
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
        
        
     // the rowData going to be == to array that came from the data base
		this.rowData = StateBet.this.aBet.openBets();
                
                this.columnNames = new Vector<>();
                columnNames.addElement("Code Game");
                columnNames.addElement("House Team");
                columnNames.addElement("Guest Team");
                columnNames.addElement("Odds 1");
                columnNames.addElement("Odds 2");
                columnNames.addElement("Odds 3");
                columnNames.addElement("Date");
                columnNames.addElement("Type");
                columnNames.addElement("Goals HT");
                columnNames.addElement("Goals GT");
                columnNames.addElement("Amount");
                columnNames.addElement("Type");
	    
                this.table = new JTable(rowData, columnNames);
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
		   	StateBet.this.frame.dispose();
		   	new Home().home(StateBet.this.aBet);
		   }
		});

        
		return panel;
	}

    public void update() {
        JOptionPane.showMessageDialog(new JFrame(), "GAME HAS CLOSE CHECK YOU HISTORY FOR MORE INFORMATIONS", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                        StateBet.this.frame.dispose();
		   	new Home().home(StateBet.this.aBet);
//this.frame.remove(this.panel);
        //this.panel.setLayout(null);
        //this.panel = new JPanel();
        //this.frame.add(setcontent(this.panel));
    }

}
