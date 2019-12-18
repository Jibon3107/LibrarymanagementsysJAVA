import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.awt.Font;
import java.sql.*;
class Manager extends JFrame implements ActionListener,MouseListener{
      
	 String LibUserName;
	 String Status;
	
	JButton btnAdd;
	JButton btnView;
	JButton btnDelete;
	JButton btnLogout;
	
	JLabel imgLabel;
	ImageIcon image;
	JPanel panel;
	
	JLabel lblName, lb1;
	JTextField tx1;
	
	
	public Manager(){
		
		this.setTitle("Manager");
		this.lblName = new JLabel("Welcome  Manager");
		this.lb1 = new JLabel("Enter Librarian UserName");
		
		this.tx1 = new JTextField();
		
		this.btnAdd = new JButton("Add Librarian");
		this.btnView = new JButton("View Librarian");
		this.btnDelete = new JButton("Delete Librarian");
		this.btnLogout = new JButton("Logout");
		
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();

		
		this.setLayout(null);
		this.setSize(700,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
	    this.lblName.setBounds(180,60,400,100);
		lblName.setFont(new Font("Forte", Font.BOLD, 35));
		
		this.lb1.setBounds(144,330,180,30);
		
		this.tx1.setBounds(150,300,150,30);
		
		lb1.setFont(new Font("Goudy Old Style", Font.BOLD, 14));
		lb1.setForeground(new Color(0,0,139));
		
			
		this.btnAdd.setBounds(150,200,150,30);
		this.btnView.setBounds(340,200,150,30);
		this.btnDelete.setBounds(340,300,150,30);
		this.btnLogout.setBounds(240,450,150,30);
		
		lblName.setForeground(new Color(0,0,139));
       
	    btnAdd.setBackground(new Color(153,50,204));
		btnAdd.setForeground(Color.white);
		btnView.setBackground(new Color(153,50,204));
		btnView.setForeground(Color.white);
		btnDelete.setBackground(new Color(153,50,204));
		btnDelete.setForeground(Color.white);
		btnLogout.setBackground(new Color(153,50,204));
		btnLogout.setForeground(Color.white);
		
	    add(this.lblName);
		add(this.lb1);
		add(this.tx1);
                                       
		add(this.btnAdd);
		add(this.btnView);
		add(this.btnDelete);
		add(this.btnLogout);
		
	    btnAdd.addActionListener(this);
		btnView.addActionListener(this);
		btnDelete.addActionListener(this);
		btnLogout.addActionListener(this);
		
		btnAdd.addMouseListener(this);
		btnView.addMouseListener(this);
		btnDelete.addMouseListener(this);
		btnLogout.addMouseListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		
		
        imgLabel.setSize(747,602);   
        this.add(imgLabel);
        image=new ImageIcon("d3.jpg");
        imgLabel.setIcon(image);
  	
		
	}

 	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnLogout){
			new Home();
			this.dispose();
			
		}
 		 if(e.getSource()==btnAdd){
			
			new AddLibrarian();
			this.dispose();
		}


		if(e.getSource()==btnView){
			
			ViewLibrarian.main(new String[]{});
			
			
		}
	
     	if(e.getSource()==btnDelete){
			
			if (tx1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Enter Librarian UserName to Delete");
			}	

        else {
			
			LibUserName=tx1.getText();
			this.DBConnect(); 
			tx1.setText("");

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
		if(e.getSource()==btnView)
		{
	    btnView.setBackground(new Color(176,196,222));
		btnView.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnDelete)
		{
	    btnDelete.setBackground(new Color(176,196,222));
		btnDelete.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnLogout)
		{
	    btnLogout.setBackground(new Color(176,196,222));
		btnLogout.setForeground(new Color(72,61,139));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnAdd)
		{
			btnAdd.setBackground(new Color(123,104,238));
			btnAdd.setForeground(Color.white);
		}

		if(e.getSource()==btnView)
		{
			btnView.setBackground(new Color(123,104,238));
			btnView.setForeground(Color.white);
		}
		if(e.getSource()==btnDelete)
		{
			btnDelete.setBackground(new Color(123,104,238));
			btnDelete.setForeground(Color.white);
		}
		if(e.getSource()==btnLogout)
		{
			btnLogout.setBackground(new Color(123,104,238));
			btnLogout.setForeground(Color.white);
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
			Connection con1=null;
			
			Statement st = null;
			Statement st1 = null;
			
			ResultSet rs = null;
			
			String query="select * from member";
			String query1="delete from member where UserName='"+tx1.getText()+"' and Status='1'";			
			
			
			
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
				
				
				if(rs.next())
				{
					String LibUserName=rs.getString("UserName");
					String Status=rs.getString("Status");
					
					
					if(LibUserName.equals(new String(tx1.getText())) )
					{
					  
					  JOptionPane.showMessageDialog(this, "Wrong UserName. Please enter again");
					  tx1.setText("");
					
					}
                     
                    else if (Status.equals(null) )
					{
						JOptionPane.showMessageDialog(this, "Wrong UserName. Please enter again");
					}						
					
					else if (!LibUserName.equals(new String(tx1.getText())) )
					{
						
						
						JOptionPane.showMessageDialog(this, "Librarian Delete Successful");
						tx1.setText("");
					}
				}  
				     
				
  
				
				else
				{
					
			  
			   JOptionPane.showMessageDialog(this, "Librarian Delete Successful");
			   tx1.setText("");
				
				}
				
			   
			}
			catch(Exception e)
			{
			System.out.println("Exception : " +e.getMessage());
			JOptionPane.showMessageDialog(this, "Wrong UserName. Please enter again");
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
	



	public static void main(String [] ar){
		new Manager(); 
	}
	
}
