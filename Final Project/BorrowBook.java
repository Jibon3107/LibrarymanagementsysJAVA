import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

import java.util.Calendar;
import java.text.ParseException;


class BorrowBook extends JFrame implements ActionListener,MouseListener
{

	JButton btnReturn;
	JButton btnLogout;
	JButton btnDone;
	
    JTextField txtCustomerid;
	JTextField txtBookid;
	JTextField txtBorrow;
	JTextField txtReturn;

	
	JLabel lblCustomerid;
	JLabel lblBookid;
	JLabel lblBorrow;
	JLabel lblReturn;
    JLabel lblFine;
	JLabel lblName;
	JPanel panel;
	
	JLabel imgLabel;
	ImageIcon image;
	
	String CallNo,UserName,ReturnDate,Quantity,Fine;
	int a,b;
	int k=0;
	
	
	public BorrowBook () 
	{   
		this.setTitle("Borrow Book");
		this.lblCustomerid = new JLabel("Book Call No          :");
		this.lblBookid = new JLabel("Member UserName :");
		this.lblBorrow = new JLabel("Return Date           :");
		this.lblReturn = new JLabel("Press After Name Entry");
	    this.lblName = new JLabel("Borrow Book");
		
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();
		
		
		this.txtCustomerid = new JTextField();
		this.txtBookid = new JTextField();
		this.txtBorrow = new JTextField();
		
	    this.btnReturn = new JButton("Refresh");
		this.btnLogout = new JButton("Back");
		this.btnDone = new JButton("Done");
		btnDone.setBackground(new Color(153,50,204));
		btnDone.setForeground(Color.white);
		btnDone.addMouseListener(this);
		btnLogout.setBackground(new Color(153,50,204));
		btnLogout.setForeground(Color.white);
		btnLogout.addMouseListener(this);
		btnReturn.setBackground(new Color(153,50,204));
		btnReturn.setForeground(Color.white);
		btnReturn.addMouseListener(this);
		
		this.setLayout(null);
		this.setSize(700,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.lblCustomerid.setBounds(200,150,200,30);
		this.lblBookid.setBounds(200,210,200,30);
		this.lblBorrow.setBounds(200,285,200,30);
		this.lblReturn.setBounds(540,240,150,30);
		this.lblName.setBounds(240,30,400,100);
		
		this.txtCustomerid.setBounds(400,150,120,30);
		this.txtBookid.setBounds(400,210,120,30);
		this.txtBorrow.setBounds(400,285,130,30);
		
		this.btnReturn.setBounds(550,210,100,30);
		this.btnLogout.setBounds(380,480,100,30);
		this.btnDone.setBounds(290,400,100,30);
		
		lblCustomerid.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblCustomerid.setForeground(new Color(0,0,139));
		lblBookid.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblBookid.setForeground(new Color(0,0,139));
		lblBorrow.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblBorrow.setForeground(new Color(0,0,139));
		lblReturn.setFont(new Font("Goudy Old Style", Font.BOLD, 12));
		lblReturn.setForeground(new Color(0,0,139));
		
		lblName.setFont(new Font("Forte", Font.BOLD, 30));
		lblName.setForeground(new Color(75,0,130));
	
		add(this.lblCustomerid);
		add(this.lblBookid);
		add(this.lblBorrow);
		add(this.lblReturn);
		add(this.lblName);
		
		add(this.txtCustomerid);
		add(this.txtBookid);
		add(this.txtBorrow);
	
		add(this.btnReturn);
		add(this.btnLogout);
		add(this.btnDone);
		
		btnReturn.addActionListener(this);
		btnLogout.addActionListener(this);
		btnDone.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	

		imgLabel.setSize(700,600);   
        this.add(imgLabel);
        image=new ImageIcon("ab5.jpg");
        imgLabel.setIcon(image);
		
	
		
			
	   
	}
	public void actionPerformed(ActionEvent e){
		
	
		if(e.getSource()==btnLogout)
		{
		 new Librarian();
		 this.dispose();
		}
		
		if(e.getSource()==btnReturn)
		{
			if (txtCustomerid.getText().isEmpty() || txtBookid.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Enter CallNo and UserName");
			}
			
			else {
				UserName=txtBookid.getText();
				this.DBConnect1();
                
                				
			}
			
		}	
		
		
		
		
		
		if(e.getSource()==btnDone)
		{   
	
	       if (txtCustomerid.getText().isEmpty() || txtBookid.getText().isEmpty() || txtBorrow.getText().isEmpty()) 
		   {
			   JOptionPane.showMessageDialog(this, "Please Enter CallNo and UserName");
		   }
		   
		   else {
	       
			CallNo=txtCustomerid.getText();
			UserName=txtBookid.getText();
		    ReturnDate=txtBorrow.getText(); 
			this.DBConnect(); 
			
			txtCustomerid.setText("");
			txtBookid.setText("");
			txtBorrow.setText("");
			
		   }
		}
		}
		
		
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnDone)
		{
			btnDone.setBackground(new Color(176,196,222));
			btnDone.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnLogout)
		{
	    btnLogout.setBackground(new Color(176,196,222));
		btnLogout.setForeground(new Color(72,61,139));
		}
		
		if(e.getSource()==btnReturn)
		{
	    btnReturn.setBackground(new Color(176,196,222));
		btnReturn.setForeground(new Color(72,61,139));
		} 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnDone)
		{
			btnDone.setBackground(new Color(123,104,238));
			btnDone.setForeground(Color.white);
		}

		if(e.getSource()==btnLogout)
		{
			btnLogout.setBackground(new Color(123,104,238));
			btnLogout.setForeground(Color.white);
		}
		
		if(e.getSource()==btnReturn)
		{
			btnReturn.setBackground(new Color(123,104,238));
			btnReturn.setForeground(Color.white);
		} 
		
		

	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	

public void DBConnect1()
		{
			
			String query="select Fine from member where UserName= '"+txtBookid.getText()+"'";
			String query1="update current set Name=Name+1 where ID=1";
			String query2="select CurrentTime from current";
			String query3="select Quantity from book where CallNo= '"+txtCustomerid.getText()+"'";
			String query4="select count(*) as MY_COUNT from issuebook where UserName='"+txtBookid.getText()+"'";

			
			Connection con=null;
			Connection con1=null;
			Connection con2=null;
			Connection con3=null;
			Connection con4=null;
			Statement st = null;
			Statement st1 = null;
			Statement st2 = null;
			Statement st3 = null;
			Statement st4 = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");
				st = con.createStatement();
				st1 = con1.createStatement();
				st2 = con2.createStatement();
				st3 = con2.createStatement();
				st4 = con2.createStatement();
				System.out.println("statement created");
				rs = st.executeQuery(query);
				rs2 = st3.executeQuery(query3);
				st2.execute(query1);
				rs1 = st1.executeQuery(query2);
				rs3 = st4.executeQuery(query4);
				System.out.println("results received");
				
			    
				if(rs.next())
				{
					String Fine=rs.getString("Fine");
					a = Integer.parseInt(Fine);
					
					if(a>0)
					{
						JOptionPane.showMessageDialog(this, "Fine Due. Go Search Member");
						txtCustomerid.setText("");
			            txtBookid.setText("");
						txtBorrow.setText("");
						
					}
				} 
				
				if(rs3.next())
				{ 

                    k=rs3.getInt("MY_COUNT");
			
			     	
					if(k>=3)
					{
						JOptionPane.showMessageDialog(this, "Borrow Limit Reached 3 ! Sorry");
						txtCustomerid.setText("");
			            txtBookid.setText("");
						txtBorrow.setText("");
						
						
					}
					
				}
					
				
				if(rs2.next())
				{
					String Quantity=rs2.getString("Quantity");
					b = Integer.parseInt(Quantity);
					
					if(b<=20)
					{
						JOptionPane.showMessageDialog(this, "Book Quantity Limit reached 20 !");
						txtCustomerid.setText("");
			            txtBookid.setText("");
						txtBorrow.setText("");
						
					}
					
				}
				
                if(rs1.next())
				{
					String CurrentTime=rs1.getString("CurrentTime");
				    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
					
					Calendar c = Calendar.getInstance();
                    	
					try{
	                        
                     	   c.setTime(format.parse(CurrentTime));
                        }
						
					catch(ParseException e){
	                         	e.printStackTrace();
	                         }
	   
                       	
                     	c.add(Calendar.DAY_OF_MONTH, 2);  
	                   
                      	String newDate = format.format(c.getTime()); 
                        
						if(a<=0 && b>20 && k<3){
						txtBorrow.setText(newDate);
                        }						
					
				}

     			
				else
				{
					JOptionPane.showMessageDialog(this, "Please Enter CallNo and UserName");
					
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



	public void DBConnect()
		{
			
			
			Connection con=null;
			Connection con1=null;
			Statement st = null;
			Statement st1 = null;
			ResultSet rs = null;
		
			String query="insert into issuebook(CallNo,UserName,ReturnDate) values('"+CallNo+ "','"+UserName+"','"+ ReturnDate+"');";
		
            String query1 = "UPDATE book set Quantity = Quantity-1 where CallNo= '"+txtCustomerid.getText()+"'";
			
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
				st.execute(query);
				st1.execute(query1);
				JOptionPane.showMessageDialog(this, "Borrow Book Done");
				
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
	
	
	

	public static void main(String [] ar){
		new BorrowBook(); 
	} 
}
	

