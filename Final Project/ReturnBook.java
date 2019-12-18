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
class ReturnBook extends JFrame implements ActionListener,MouseListener
{

	

	JButton btnRefresh;
	JButton btnReturn;
	JButton btnLogout;
	JButton btnDone;
	
    JTextField txtCustomerid;
	JTextField txtBookid;
	JTextField txtBorrow;
	JTextField txtReturn;
	JTextField txtCurrent;
	JTextField txtFine;
	
	JLabel lblCustomerid;
	JLabel lblBookid;
	JLabel lblBorrow;
	JLabel lblReturn;
	JLabel lblFine;
	JLabel lblName;
	JLabel lblCurrent;
	JLabel lb1;
	JPanel panel;
	
	JLabel imgLabel;
	ImageIcon image;
	
	
	String CallNo,UserName,IssueDate,Fine;
	int a,b;
	
	public ReturnBook () 
	
	{
		this.setTitle("Return Book");
		
		this.lblCustomerid = new JLabel("Book Call No         :");
		this.lblBookid = new JLabel("Member UserName :");
		this.lblBorrow = new JLabel("Borrow Date          :");
		this.lblReturn = new JLabel("Return Date            :");
		
		this.lblCurrent = new JLabel("Current Date           :");
		
		this.lblFine = new JLabel("Fine Amount           :");
		this.lblName = new JLabel("Return Book ");
		this.lb1 = new JLabel("Press After Name Entry");
		
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();
		
		
		
		this.txtCustomerid = new JTextField();
		this.txtBookid = new JTextField();
		this.txtBorrow = new JTextField();
		this.txtReturn = new JTextField();
		
		this.txtCurrent = new JTextField();
		
		this.txtFine = new JTextField();
		
		this.btnRefresh = new JButton("Refresh");
		this.btnLogout = new JButton("Back");
		this.btnDone = new JButton("Done");
		btnDone.setBackground(new Color(153,50,204));
		btnDone.setForeground(Color.white);
		btnDone.addMouseListener(this);
		btnLogout.setBackground(new Color(153,50,204));
		btnLogout.setForeground(Color.white);
		btnLogout.addMouseListener(this);
		btnRefresh.setBackground(new Color(153,50,204));
		btnRefresh.setForeground(Color.white);
		btnRefresh.addMouseListener(this);
		
		this.setLayout(null);
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.lblCustomerid.setBounds(200,200,170,30);
		this.lblBookid.setBounds(200,250,170,30);
		this.lblBorrow.setBounds(200,300,170,30);
		this.lblReturn.setBounds(200,350,170,30);
		
		this.lblCurrent.setBounds(200,400,170,30);
		
		this.lblFine.setBounds(200,450,170,30);
        this.lb1.setBounds(520,220,150,30);
		
		this.lblName.setBounds(260,30,400,100);
		
		this.txtCustomerid.setBounds(380,200,120,30);
		this.txtBookid.setBounds(380,250,120,30);
		this.txtBorrow.setBounds(380,300,130,30);
		this.txtReturn.setBounds(380,350,130,30);
		
		this.txtCurrent.setBounds(380,400,130,30);
		
		this.txtFine.setBounds(380,450,120,30);
		
		this.btnRefresh.setBounds(530,250,100,30);
		this.btnLogout.setBounds(420,600,100,30);
		this.btnDone.setBounds(310,550,100,30);
		
		lblCustomerid.setFont(new Font("times new roman", Font.PLAIN, 20));
		lblCustomerid.setForeground(new Color(0,0,139));
		lblBookid.setFont(new Font("times new roman", Font.PLAIN, 20));
		lblBookid.setForeground(new Color(0,0,139));
		lblBorrow.setFont(new Font("times new roman", Font.PLAIN, 20));
		lblBorrow.setForeground(new Color(0,0,139));
		lblReturn.setFont(new Font("times new roman", Font.PLAIN, 20));
		lblReturn.setForeground(new Color(0,0,139));
		lblReturn.setFont(new Font("times new roman", Font.PLAIN, 20));
	    lblReturn.setForeground(new Color(0,0,139));
		
		lblCurrent.setFont(new Font("times new roman", Font.PLAIN, 20));
	    lblCurrent.setForeground(new Color(0,0,139));
		lb1.setFont(new Font("Goudy Old Style", Font.BOLD, 12));
		lb1.setForeground(new Color(0,0,139));
		lblFine.setFont(new Font("times new roman", Font.PLAIN, 20));
	    lblFine.setForeground(new Color(0,0,139));
		
		
		lblName.setFont(new Font("times new roman", Font.BOLD, 30));
		lblName.setForeground(new Color(75,0,130));
		
		
	
		add(this.lblCustomerid);
		add(this.lblBookid);
		add(this.lblBorrow);
		add(this.lblReturn);
		
		add(this.lblCurrent);
		add(this.lb1);
		add(this.lblFine);
		add(this.lblName);
		
		add(this.txtCustomerid);
		add(this.txtBookid);
		add(this.txtBorrow);
		add(this.txtReturn);
		
		add(this.txtCurrent);
		
		add(this.txtFine);
		
		add(this.btnRefresh);
		add(this.btnLogout);
		add(this.btnDone);
		
	
		
		btnRefresh.addActionListener(this);
		btnLogout.addActionListener(this);
		btnDone.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	

		imgLabel.setSize(700,700);   
        this.add(imgLabel);
        image=new ImageIcon("Bookinfo.jpg");
        imgLabel.setIcon(image);
		
			
	   
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnRefresh)
		{
			
			if (txtCustomerid.getText().isEmpty() || txtBookid.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Enter CallNo and UserName");
			}
			
			else 
			{
				CallNo=txtCustomerid.getText();
			    UserName=txtBookid.getText();
				
				this.DBConnect1();
			}
						
		
	}
	
	
	if(e.getSource()==btnDone)
		{  
	
	      if (txtCustomerid.getText().isEmpty() || txtBookid.getText().isEmpty() || txtBorrow.getText().isEmpty() || txtReturn.getText().isEmpty() || txtFine.getText().isEmpty())
		  {
			  JOptionPane.showMessageDialog(this, "Please Enter CallNo and UserName");
		  } 
		  
		  else {
			
			
			CallNo=txtCustomerid.getText();
			UserName=txtBookid.getText();
			IssueDate=txtBorrow.getText();
			Fine=txtFine.getText();
			this.DBConnect();
			
			
			
			
		    txtCustomerid.setText("");
			txtBookid.setText("");
			txtBorrow.setText("");
			txtReturn.setText("");
			txtCurrent.setText("");
			txtFine.setText("");
		  } 
	}
	
     	if(e.getSource()==btnLogout)
		{
		  new Librarian();
		  this.dispose();
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
		if(e.getSource()==btnRefresh)
		{
	    btnRefresh.setBackground(new Color(176,196,222));
		btnRefresh.setForeground(new Color(72,61,139));
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
		if(e.getSource()==btnRefresh)
		{
			btnRefresh.setBackground(new Color(123,104,238));
			btnRefresh.setForeground(Color.white);
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
			
			String query="select IssueDate, ReturnDate from issuebook where CallNo='"+txtCustomerid.getText()+"' and UserName='"+txtBookid.getText()+"'";
			String query1="update current set Name=Name+1 where ID=1";
			String query2="select CurrentTime from current";
			
			Connection con=null;
			Connection con1=null;
			Connection con2=null;
			Statement st = null;
			Statement st1 = null;
			Statement st2 = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");
				st = con.createStatement();
				st1 = con1.createStatement();
				st2 = con2.createStatement();
				System.out.println("statement created");
				st2.execute(query1);
				rs = st.executeQuery(query);
				rs1 = st1.executeQuery(query2);
				System.out.println("results received");
				
			
                if(rs1.next())
				{
					String CurrentTime=rs1.getString("CurrentTime");
					txtCurrent.setText(CurrentTime);
					
				}

     			if(rs.next())
				{
					String IssueDate=rs.getString("IssueDate");
					String ReturnDate=rs.getString("ReturnDate");
					
					txtBorrow.setText(IssueDate);
					txtReturn.setText(ReturnDate);
					
					String date1 = txtCurrent.getText();
			        String date2 = txtReturn.getText();

   				   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
				   
				   	Date d1 = null;
                 	Date d2 = null;
					
					d1 = format.parse(date1);
             		d2 = format.parse(date2);
			   
			   long diff = d1.getTime() - d2.getTime(); 
			   
			   int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
				   
				   System.out.println(+diffDays);
			       
				   if(diffDays>=1)
			     {				
		   
		          int x=(diffDays*10);
		          String y=Integer.toString(x);
                  txtFine.setText(y);
		    
			    } 
		
		
                else{
			     txtFine.setText("No Fine");
			       }
		}
				
				
				
				
				else
				{
					JOptionPane.showMessageDialog(this, "Please Enter All Fields");
					
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
			Connection con2=null;
			Statement st = null;
			Statement st1 = null;
			Statement st2 = null;
			ResultSet rs = null;
		
			
			String query = "delete from issuebook where UserName= '"+txtBookid.getText()+"' and CallNo='"+txtCustomerid.getText()+"' and IssueDate='"+txtBorrow.getText()+"'";
			String query1 = "UPDATE book set Quantity =Quantity+1 where CallNo= '"+txtCustomerid.getText()+"'";
			String query2 = "UPDATE member set Fine =Fine+'"+txtFine.getText()+"' where UserName= '"+txtBookid.getText()+"' ";

			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");
				st = con.createStatement();
				st1 = con1.createStatement();
				st2 = con2.createStatement();
				System.out.println("statement created");
				st.execute(query);
				st1.execute(query1);
				st2.execute(query2);
				JOptionPane.showMessageDialog(this, "Book Return Done");
				
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
		new ReturnBook(); 
	} 
}
	

