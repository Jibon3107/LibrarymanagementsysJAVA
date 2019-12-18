import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.awt.Font;
import java.sql.*;
class Addbook extends JFrame implements ActionListener, MouseListener {

	JButton btnAdd, btnBack,btnCheck;
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lblName;
	JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8;
	
	JPanel panel;
	JLabel imgLabel;
	ImageIcon image;
	
	
    String LibName,LibMail,LibAddress,LibContact,LibStatus,LibUserName,LibPass;  
	
	
	
	public Addbook(){
		
		this.setTitle("Add Book");
		this.lblName = new JLabel("Add Book");
		
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();
					
		this.lb2 = new JLabel("Name          :");
		this.lb3 = new JLabel("Author         :");
		this.lb4 = new JLabel("Publisher     :");
		this.lb5 = new JLabel("Edition        :");
		this.lb6 = new JLabel("Call No        :");
		this.lb7 = new JLabel("Rack (r/c)    :");
		this.lb8 = new JLabel("Quantity      :");
				
		this.tx2 = new JTextField();
		this.tx3 = new JTextField();
		this.tx4 = new JTextField();
		this.tx5 = new JTextField();
		this.tx6 = new JTextField();
		this.tx7 = new JTextField();
		this.tx8 = new JTextField();
		
		this.btnAdd = new JButton("Add");
		this.btnBack = new JButton("Back");
		this.btnCheck = new JButton("Check CallNo");
		btnAdd.setBackground(new Color(153,50,204));
		btnAdd.setForeground(Color.white);
		btnAdd.addMouseListener(this);
		btnBack.setBackground(new Color(153,50,204));
		btnBack.setForeground(Color.white);
		btnBack.addMouseListener(this);
		btnCheck.setBackground(new Color(153,50,204));
		btnCheck.setForeground(Color.white);
		btnCheck.addMouseListener(this);
		
		
		
		this.setLayout(null);
		this.setSize(700,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.lb2.setBounds(200,150,120,30);
		this.lb3.setBounds(200,200,120,30);
		this.lb4.setBounds(200,250,130,30);
		this.lb5.setBounds(200,300,120,30);
		this.lb6.setBounds(200,350,130,30);
		this.lb7.setBounds(200,400,130,30);
		this.lb8.setBounds(200,450,130,30);
		
		this.lblName.setBounds(250,40,200,50);

		this.tx2.setBounds(350,150,270,30);
		this.tx3.setBounds(350,200,270,30);
		this.tx4.setBounds(350,250,270,30);
		this.tx5.setBounds(350,300,120,30);
		this.tx6.setBounds(350,350,120,30);
		this.tx7.setBounds(350,400,120,30);
		this.tx8.setBounds(350,450,120,30);
		
		
		this.btnAdd.setBounds(275,500,100,30);
		this.btnBack.setBounds(400,550,100,30);
		this.btnCheck.setBounds(510,350,140,30);
		
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
		
		add(this.lb2);
		add(this.lb3);
		add(this.lb4);
		add(this.lb5);
		add(this.lb6);
		add(this.lb7);
		add(this.lb8);
		
		add(this.lblName);
		
		add(this.tx2);
		add(this.tx3);
		add(this.tx4);
		add(this.tx5);
		add(this.tx6);
		add(this.tx7);
		add(this.tx8);
		
		add(this.btnAdd);
		add(this.btnBack);
		add(this.btnCheck);
		
		btnAdd.setBackground(new Color(153,50,204));
		btnAdd.setForeground(Color.white);
		btnBack.setBackground(new Color(153,50,204));
		btnBack.setForeground(Color.white);
		btnCheck.setBackground(new Color(153,50,204));
		btnCheck.setForeground(Color.white);
		
		
	    btnAdd.addActionListener(this);
		btnBack.addActionListener(this);
		btnCheck.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		
		
        imgLabel.setSize(700,650);   
        this.add(imgLabel);
        image=new ImageIcon("ab2.jpg");
        imgLabel.setIcon(image);
			
		
	   
	}

 	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnBack){
			new Librarian();
			this.dispose();

		}
		if(e.getSource()==btnCheck){
			
			ViewBook.main(new String[]{});

		}
 		
		 if(e.getSource()==btnAdd){
			
			
			if (tx2.getText().isEmpty() || tx3.getText().isEmpty() || tx4.getText().isEmpty() || tx5.getText().isEmpty() || tx6.getText().isEmpty() || tx7.getText().isEmpty() || tx8.getText().isEmpty() )
			{
				JOptionPane.showMessageDialog(this, "Please fill up all fields");
				
				
			} 
			
			else {
			
			LibName=tx2.getText();
			LibMail=tx3.getText();
			LibAddress=tx4.getText();
			LibContact=tx5.getText();
			LibStatus=tx6.getText();
			LibUserName=tx7.getText();
			LibPass=tx8.getText();
			
			
			
			
			this.DBConnect();
			
		
			
			tx2.setText("");
			tx3.setText("");
			tx4.setText("");
			tx5.setText("");
			tx6.setText("");
			tx7.setText("");
			tx8.setText("");
			
		      }	

		}

	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnAdd)
		{
			btnAdd.setBackground(new Color(176,196,222));
			btnAdd.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnBack)
		{
	    btnBack.setBackground(new Color(176,196,222));
		btnBack.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnCheck)
		{
			btnCheck.setBackground(new Color(176,196,222));
			btnCheck.setForeground(new Color(72,61,139));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnAdd)
		{
			btnAdd.setBackground(new Color(123,104,238));
			btnAdd.setForeground(Color.white);
		}

		if(e.getSource()==btnBack)
		{
			btnBack.setBackground(new Color(123,104,238));
			btnBack.setForeground(Color.white);
		}
		if(e.getSource()==btnCheck)
		{
			btnCheck.setBackground(new Color(123,104,238));
			btnCheck.setForeground(Color.white);
		}

	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
	




public void DBConnect()
		{
			
			
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			String query="insert into book ( Name, Author, Publisher, Edition, CallNo, Rack, Quantity) values ('"+LibName+"','"+LibMail+"','"+LibAddress+"','"+LibContact+"','"+LibStatus+"','"+LibUserName+"','"+LibPass+"');";			
			
			
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");
				st = con.createStatement();
				System.out.println("statement created");
				st.execute(query);
				JOptionPane.showMessageDialog(this, "Book Add Successful");
				
			
				
			}
			catch(Exception e)
			{
				System.out.println("Exception : " +e.getMessage());
				JOptionPane.showMessageDialog(this, "This Call No already Exist. Please enter different");
				tx7.setText("");
			}
			finally
			{
				try
				{
					if(rs!=null)
						rs.close();

					if(st!=null)
						st.close();

					if(con!=null)
						con.close();
				}
				catch(Exception ex){}
			}
			
			
			
		}
	
	

	public static void main(String [] ar){
		new Addbook(); 
	}
	
}
