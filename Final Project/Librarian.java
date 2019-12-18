import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
import java.awt.Color;

class Librarian extends JFrame implements ActionListener,MouseListener{
    
	String Callno;

	JButton btnAddbooks;
	JButton btnViewbooks;
	JButton btnDeletebooks;
	JButton btnSearchbooks;
	JButton btnViewmember;
	JButton btnSearchmember;
	JButton btnBorrowbooks;
	JButton btnReturnbooks;
	JButton btnLogout;
	JButton btnViwbrbook;

	
	JPanel panel;
	JLabel lblName,lb1,lb2,lb3;
	JTextField tx1;
    JTextField tx2;	
	JTextField tx3;
	
	JLabel imgLabel;
	ImageIcon image;
	
	public Librarian(){
		
		this.setTitle("Librarian");
		this.lblName = new JLabel("Welcome  Librarian");
		
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();
		
		this.lb1 = new JLabel("Enter Book Call No");
		this.tx1 = new JTextField();
		lb1.setFont(new Font("Goudy Old Style", Font.BOLD, 17));
		lb1.setForeground(new Color(0,0,139));
		
		this.lb2 = new JLabel("Enter  Book Name");
		this.tx2 = new JTextField();
		
		lb2.setFont(new Font("Goudy Old Style", Font.BOLD, 17));
		lb2.setForeground(new Color(0,0,139));
		
		this.lb3 = new JLabel("Enter  UserName");
		this.tx3 = new JTextField();
		
		lb3.setFont(new Font("Goudy Old Style", Font.BOLD, 17));
		lb3.setForeground(new Color(0,0,139));

		
		this.btnAddbooks = new JButton("Add Book");
		this.btnViewbooks = new JButton("View Book");
		this.btnViewmember = new JButton("View Member");
		this.btnBorrowbooks= new JButton("Borrow Book");
		this.btnReturnbooks = new JButton("Return Book");
		this.btnDeletebooks = new JButton("Delet Book");
		this.btnSearchbooks= new JButton("Search Book");
		this.btnSearchmember = new JButton("Search Member");
		this.btnLogout = new JButton("Logout");
		this.btnViwbrbook = new JButton("View Brrowed Books");
		
		this.setLayout(null);
		this.setSize(700,728);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		btnAddbooks.addMouseListener(this);
		btnViewbooks.addMouseListener(this);
		btnViewmember.addMouseListener(this);
		btnBorrowbooks.addMouseListener(this);		
		btnReturnbooks.addMouseListener(this);
		btnDeletebooks.addMouseListener(this);
		btnSearchbooks.addMouseListener(this);
		btnSearchmember.addMouseListener(this);
		btnLogout.addMouseListener(this);
		btnViwbrbook.addMouseListener(this);
		
		this.lb1.setBounds(450,400,180,30);
		this.tx1.setBounds(320,400,120,30);
		
		this.lb2.setBounds(450,490,180,30);
		this.tx2.setBounds(320,490,120,30);
		
		this.lb3.setBounds(450,580,180,30);
		this.tx3.setBounds(320,580,120,30);
		

	    this.lblName.setBounds(180,60,400,100);
		lblName.setFont(new Font("Forte", Font.BOLD, 35));
		
		this.btnAddbooks.setBounds(100,200,120,30);
		this.btnViewbooks.setBounds(250,200,120,30);
		this.btnViewmember.setBounds(400,200,120,30);
	    this.btnBorrowbooks.setBounds(100,300,120,30);
		this.btnReturnbooks.setBounds(250,300,120,30);
		this.btnViwbrbook.setBounds(400,300,160,30);
		this.btnDeletebooks.setBounds(150,400,120,30);
		this.btnSearchbooks.setBounds(150,490,120,30);
		this.btnSearchmember.setBounds(150,580,130,30);
		this.btnLogout.setBounds(450,638,90,30);

		lblName.setForeground(new Color(0,0,139));
      
	  
		btnAddbooks.setBackground(new Color(153,50,204));
		btnAddbooks.setForeground(Color.white);
		btnViewbooks.setBackground(new Color(153,50,204));
		btnViewbooks.setForeground(Color.white);
		btnDeletebooks.setBackground(new Color(153,50,204));
		btnDeletebooks.setForeground(Color.white);
		btnSearchbooks.setBackground(new Color(153,50,204));
		btnSearchbooks.setForeground(Color.white);
		btnViewmember.setBackground(new Color(153,50,204));
		btnViewmember.setForeground(Color.white);
		btnSearchmember.setBackground(new Color(153,50,204));
		btnSearchmember.setForeground(Color.white);
		btnBorrowbooks.setBackground(new Color(153,50,204));
	    btnBorrowbooks .setForeground(Color.white);
		btnReturnbooks.setBackground(new Color(153,50,204));
		btnReturnbooks.setForeground(Color.white);
		
		btnLogout.setBackground(new Color(153,50,204));
		btnLogout.setForeground(Color.white);
		
		btnViwbrbook.setBackground(new Color(153,50,204));
		btnViwbrbook.setForeground(Color.white);
		
	    add(this.lblName);
		
		add(this.lb1);
		add(this.tx1);
		
		add(this.lb2);
		add(this.tx2);
		
		add(this.lb3);
		add(this.tx3);
		
		add(this.btnAddbooks);
		add(this.btnViewbooks);
		add(this.btnViewmember);
		add(this.btnBorrowbooks);
	    add(this.btnReturnbooks);

		add(this.btnDeletebooks);
		add(this.btnSearchbooks);

		
	   add(this.btnSearchmember);
	   add(this.btnLogout);
	   
	   add(this.btnViwbrbook);

		btnAddbooks.addActionListener(this);
		btnViewbooks.addActionListener(this);
		
		btnViewmember.addActionListener(this);
		btnDeletebooks.addActionListener(this);
		btnSearchbooks.addActionListener(this);		
		btnSearchmember.addActionListener(this);
		btnBorrowbooks.addActionListener(this);
		btnReturnbooks.addActionListener(this);
		btnLogout.addActionListener(this);
		
		btnViwbrbook.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		
		
        imgLabel.setSize(950,720);   
        this.add(imgLabel);
        image=new ImageIcon("abc4.jpg");
        imgLabel.setIcon(image);
			
		
	   
	}

	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==btnAddbooks){
			new Addbook();
			this.dispose();
			
		}
		
		if(e.getSource()==btnViewbooks){
          
		  ViewBook.main(new String[]{});

		}
		
		if(e.getSource()==btnDeletebooks){
			
			if (tx1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Enter Book Call No to Delete");
			}	

        else {
			
			Callno=tx1.getText();
			this.DBConnect(); 
			tx1.setText("");

        }	
		}
		
		if(e.getSource()==btnViewmember){
			
			ViewMember.main(new String[]{});
		}
		
		if(e.getSource()==btnSearchbooks){
			this.DBConnect1();
			
		}
		if(e.getSource()==btnSearchmember){
			
			this.DBConnect2();
			
			
		}
		
		if(e.getSource()==btnBorrowbooks){
			 new BorrowBook();
			 this.dispose();
			
		}
		
		if(e.getSource()==btnReturnbooks){
			   new ReturnBook();
			   this.dispose();
			
		}
		
		if(e.getSource()==btnLogout){
			new Home();
			
			this.dispose();
			
		}
		
		if(e.getSource()==btnViwbrbook){
			
			ViewBorrow.main(new String[]{});
			
			
			
		}
	}
	
	
	
	
public void DBConnect()
		{
			
			
			Connection con=null;
			Connection con1=null;
			
			Statement st = null;
			Statement st1 = null;
			
			ResultSet rs = null;
			
			String query="select * from book";
			String query1="delete from book where CallNo='"+tx1.getText()+"'";			
			
			
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");

				System.out.println("connection done");
				st = con.createStatement();
				st1 = con1.createStatement();
				
				System.out.println("statement created");
				
			    rs = st.executeQuery(query);
				System.out.println("results received");
                st1.execute(query1);
				JOptionPane.showMessageDialog(this, "Book Delete Successful");
				
				
			   
			}
			catch(Exception e)
			{
			System.out.println("Exception : " +e.getMessage());
			JOptionPane.showMessageDialog(this, "Wrong Call No. Please enter again");
			tx1.setText("");
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
	
	
	
	
	
	
	public void DBConnect1()
		{
			
			String query="select ID,Name,Author,Publisher,Edition,CallNo,Rack,Quantity from book where Name='"+tx2.getText()+"'";
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");
				st = con.createStatement();
				System.out.println("statement created");
				rs = st.executeQuery(query);
				System.out.println("results received");
				
				if(rs.next())
				{
					String ID=rs.getString("ID");
					String Name=rs.getString("Name");
					String Author=rs.getString("Author");
					String Publisher=rs.getString("Publisher");
					String Edition=rs.getString("Edition");
					String CallNo=rs.getString("CallNo");
					String Rack=rs.getString("Rack");
					String Quantity=rs.getString("Quantity");
					
					if(Name.equals(new String(tx2.getText())))
					{
					
					 BookDetails1 ac =new BookDetails1(ID,Name,Author,Publisher,Edition,CallNo,Rack,Quantity);
					 this.dispose();
					
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong Name. Please Enter again");
						tx2.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please Enter Book Name");
					tx2.setText("");
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception : " +e.getMessage());
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
	




public void DBConnect2()
		{
			
			String query="select ID,Name, EMail, Address, Contact, Fine, UserName, Password from member where UserName='"+tx3.getText()+"'";
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");
				st = con.createStatement();
				System.out.println("statement created");
				rs = st.executeQuery(query);
				System.out.println("results received");
				
				if(rs.next())
				{
					String ID=rs.getString("ID");
					String Name=rs.getString("Name");
					String EMail=rs.getString("EMail");
					String Address=rs.getString("Address");
					String Contact=rs.getString("Contact");
					String Fine=rs.getString("Fine");
					String UserName=rs.getString("UserName");
					String Password=rs.getString("Password");
					
					if(UserName.equals(new String(tx3.getText())))
					{
					
					 MemberDetails ab =new MemberDetails(ID,Name, EMail, Address, Contact, Fine, UserName, Password);
					 this.dispose();
					
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong UserName. Please Enter again");
						tx3.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please Fill the gaps");
					tx3.setText("");
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception : " +e.getMessage());
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
		
@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnAddbooks)
		{
			btnAddbooks.setBackground(new Color(176,196,222));
			btnAddbooks.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnViewbooks)
		{
	    btnViewbooks.setBackground(new Color(176,196,222));
		btnViewbooks.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnViewmember)
		{
	    btnViewmember.setBackground(new Color(176,196,222));
		btnViewmember.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnDeletebooks)
		{
	    btnDeletebooks.setBackground(new Color(176,196,222));
		btnDeletebooks.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnSearchbooks)
		{
			btnSearchbooks.setBackground(new Color(176,196,222));
			btnSearchbooks.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnSearchmember)
		{
			btnSearchmember.setBackground(new Color(176,196,222));
			btnSearchmember.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnBorrowbooks)
		{
			btnBorrowbooks.setBackground(new Color(176,196,222));
			btnBorrowbooks.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnReturnbooks)
		{
			btnReturnbooks.setBackground(new Color(176,196,222));
			btnReturnbooks.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnLogout)
		{
			btnLogout.setBackground(new Color(176,196,222));
			btnLogout.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnViwbrbook)
		{
			btnViwbrbook.setBackground(new Color(176,196,222));
			btnViwbrbook.setForeground(new Color(72,61,139));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnAddbooks)
		{
			btnAddbooks.setBackground(new Color(123,104,238));
			btnAddbooks.setForeground(Color.white);
		}

		if(e.getSource()==btnViewbooks)
		{
			btnViewbooks.setBackground(new Color(123,104,238));
			btnViewbooks.setForeground(Color.white);
		}
		if(e.getSource()==btnDeletebooks)
		{
			btnDeletebooks.setBackground(new Color(123,104,238));
			btnDeletebooks.setForeground(Color.white);
		}
		if(e.getSource()==btnViewmember)
		{
			btnViewmember.setBackground(new Color(123,104,238));
			btnViewmember.setForeground(Color.white);
		}
		if(e.getSource()==btnSearchbooks)
		{
			btnSearchbooks.setBackground(new Color(123,104,238));
			btnSearchbooks.setForeground(Color.white);
		}
		if(e.getSource()==btnSearchmember)
		{
			btnSearchmember.setBackground(new Color(123,104,238));
			btnSearchmember.setForeground(Color.white);
		}
		if(e.getSource()==btnBorrowbooks)
		{
			btnBorrowbooks.setBackground(new Color(123,104,238));
			btnBorrowbooks.setForeground(Color.white);
		}
		if(e.getSource()==btnReturnbooks)
		{
			btnReturnbooks.setBackground(new Color(123,104,238));
			btnReturnbooks.setForeground(Color.white);
		}
		if(e.getSource()==btnLogout)
		{
			btnLogout.setBackground(new Color(123,104,238));
			btnLogout.setForeground(Color.white);
		}
		if(e.getSource()==btnViwbrbook)
		{
			btnViwbrbook.setBackground(new Color(123,104,238));
			btnViwbrbook.setForeground(Color.white);
		}
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
			
	


	public static void main(String [] ar){
		new Librarian(); 
	}
	
}

