import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.awt.Font;
import java.sql.*;
class BookDetails extends JFrame implements ActionListener, MouseListener {

	JButton  btnBack;
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lblName;
	JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8;
	
	JPanel panel;
	
	JLabel imgLabel;
	ImageIcon image;
	
	
	public BookDetails(String ID,String Name,String Author,String Publisher,String Edition,String CallNo,String Rack,String Quantity){
		
		this.setTitle("Book Info");
		this.lblName = new JLabel("Book Info");
		
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();
		
		
		
		this.lb1 = new JLabel("ID               :");
		this.lb2 = new JLabel("Name          :");
		this.lb3 = new JLabel("Author         :");
		this.lb4 = new JLabel("Publisher     :");
		this.lb5 = new JLabel("Edition        :");
		this.lb6 = new JLabel("Call No        :");
		this.lb7 = new JLabel("Rack (r/c)    :");
		this.lb8 = new JLabel("Quantity      :");
		
		
		this.tx1 = new JTextField();
		this.tx2 = new JTextField();
		this.tx3 = new JTextField();
		this.tx4 = new JTextField();
		this.tx5 = new JTextField();
		this.tx6 = new JTextField();
		this.tx7 = new JTextField();
		this.tx8 = new JTextField();
		
		
		this.btnBack = new JButton("Back");
		btnBack.setBackground(new Color(153,50,204));
		btnBack.setForeground(Color.white);
		btnBack.addMouseListener(this);
		
		
		
		this.setLayout(null);
		this.setSize(792,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		this.lb1.setBounds(200,150,120,30);
		this.lb2.setBounds(200,200,120,30);
		this.lb3.setBounds(200,250,120,30);
		this.lb4.setBounds(200,300,130,30);
		this.lb5.setBounds(200,350,120,30);
		this.lb6.setBounds(200,400,130,30);
		this.lb7.setBounds(200,450,130,30);
		this.lb8.setBounds(200,500,130,30);
		
		this.lblName.setBounds(300,40,200,50);
		
		this.tx1.setBounds(350,150,120,30);
		this.tx2.setBounds(350,200,270,30);
		this.tx3.setBounds(350,250,270,30);
		this.tx4.setBounds(350,300,270,30);
		this.tx5.setBounds(350,350,120,30);
		this.tx6.setBounds(350,400,120,30);
		this.tx7.setBounds(350,450,120,30);
		this.tx8.setBounds(350,500,120,30);
		
		
	
		this.btnBack.setBounds(450,560,100,30);
		
		
		lb1.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lb1.setForeground(new Color(0,0,139));
		lb2.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lb2.setForeground(new Color(0,0,139));
		lb3.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lb3.setForeground(new Color(0,0,139));
		lb4.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lb4.setForeground(new Color(0,0,139));
		lb5.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lb5.setForeground(new Color(0,0,139));
		lb6.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lb6.setForeground(new Color(0,0,139));
		lb7.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lb7.setForeground(new Color(0,0,139));
		lb8.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lb8.setForeground(new Color(0,0,139));
		
		lblName.setFont(new Font("Forte", Font.BOLD, 30));
		lblName.setForeground(new Color(75,0,130));
		
		add(this.lb1);
		add(this.lb2);
		add(this.lb3);
		add(this.lb4);
		add(this.lb5);
		add(this.lb6);
		add(this.lb7);
		add(this.lb8);
		
		add(this.lblName);
		
		add(this.tx1);
		add(this.tx2);
		add(this.tx3);
		add(this.tx4);
		add(this.tx5);
		add(this.tx6);
		add(this.tx7);
		add(this.tx8);
		
	
		add(this.btnBack);
		
		btnBack.setBackground(new Color(153,50,204));
		btnBack.setForeground(Color.white);
		
	    btnBack.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		
		

        imgLabel.setSize(792,650);   
        this.add(imgLabel);
        image=new ImageIcon("add.jpg");
        imgLabel.setIcon(image);
		
		
		tx1.setText(ID);
		tx2.setText(Name);
		tx3.setText(Author);
		tx4.setText(Publisher);
		tx5.setText(Edition);
		tx6.setText(CallNo);
		tx7.setText(Rack);
		tx8.setText(Quantity);
				
			
		
	   
	}

 	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnBack){
			new Member();
			this.dispose();

		}
 		
		
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if(e.getSource()==btnBack)
		{
	    btnBack.setBackground(new Color(176,196,222));
		btnBack.setForeground(new Color(72,61,139));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

		if(e.getSource()==btnBack)
		{
			btnBack.setBackground(new Color(123,104,238));
			btnBack.setForeground(Color.white);
		}
		

	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
		
}
