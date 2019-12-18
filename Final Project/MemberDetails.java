import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.awt.Font;
import java.sql.*;


 class MemberDetails extends JFrame implements ActionListener,MouseListener
{
	JLabel memberidLabel,  nameLabel, emailLabel, addressLabel,contractLabel,statusLabel, usernameLabel,passwordlabel,pageNameLabel;
	JTextField memberTF, nameTF, emailTF, addressTF, contractTF,statusTF,userTF,passwordTF;
 	JButton refreshBtn,backBtn,payBtn;
	 JPanel panel;
	
	

	 JLabel imgLabel;
	 ImageIcon image;
	 
	public MemberDetails(String ID,String Name,String EMail,String Address,String Contact,String Fine,String UserName,String Password)
    
	{
	
	this.setTitle("Member Details");
		
	    this.imgLabel=new JLabel();
		this.image=new ImageIcon();
		this.backBtn = new JButton("Back");
		this.payBtn = new JButton("Paid");
	    this.memberidLabel = new JLabel("ID             :");
		this.memberTF = new JTextField();
		this.nameLabel = new JLabel("Name         :");
		this.nameTF = new JTextField();
		this.emailLabel = new JLabel("E-Mail        :");
		this.emailTF = new JTextField();

		this.addressLabel=new JLabel("Address     :");
		this.addressTF=new JTextField();
		this.contractLabel = new JLabel("Contact       :");
		this.contractTF = new JTextField();
		this.statusLabel = new JLabel("Fine            :");
		this.statusTF = new JTextField();
		this.usernameLabel = new JLabel("User Name  :");
		this.userTF = new JTextField();
		this.passwordlabel = new JLabel("Password     :");
		this.passwordTF = new JTextField();
		
		backBtn.setBackground(new Color(153,50,204));
		backBtn.setForeground(Color.white);
		backBtn.addMouseListener(this);
		payBtn.setBackground(new Color(153,50,204));
		payBtn.setForeground(Color.white);
		payBtn.addMouseListener(this);
		this.setLayout(null);
		this.setSize(750,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.memberidLabel.setBounds(250, 150, 130, 30);
		this.memberTF.setBounds(400, 150, 200, 30);
		
        this.nameLabel.setBounds(250, 200, 120, 30);
		this.nameTF.setBounds(400, 200, 200, 30);
		
		this.emailLabel.setBounds(250, 250, 120, 30);
		this.emailTF.setBounds(400, 250, 200, 30);
		
		this.addressLabel.setBounds(250, 300, 120, 30);
		this.addressTF.setBounds(400, 300, 200, 30);
		
		this.contractLabel.setBounds(250, 350, 120, 30);
		this.contractTF.setBounds(400, 350, 200, 30);
		
		this.statusLabel.setBounds(250,400,150,30);
		this.statusTF.setBounds(400,400,100,30);
		
	
		this.usernameLabel.setBounds(250, 450, 130, 30);
		this.userTF.setBounds(400, 450, 200, 30);
		
		this.passwordlabel.setBounds(250, 500, 130, 30);
		this.passwordTF.setBounds(400, 500, 200, 30);
		this.backBtn.setBounds(475, 600, 120, 30);
		this.payBtn.setBounds(550, 400, 100, 30);
		
		
		memberidLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		memberidLabel.setForeground(new Color(0,0,139));
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nameLabel.setForeground(new Color(0,0,139));
		emailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		emailLabel.setForeground(new Color(0,0,139));
		addressLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addressLabel.setForeground(new Color(0,0,139));
		contractLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	    contractLabel.setForeground(new Color(0,0,139));
		
	    statusLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	    statusLabel.setForeground(new Color(0,0,139));
		usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	    usernameLabel.setForeground(new Color(0,0,139));
		passwordlabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	    passwordlabel.setForeground(new Color(0,0,139));
		
		
		pageNameLabel=new JLabel("Member Details");
		pageNameLabel.setBounds(320, 70, 300, 50);
		pageNameLabel.setFont(new Font("Forte", Font.BOLD, 30));
		pageNameLabel.setForeground(new Color(75,0,130)); 
		add(this.pageNameLabel);
	
		add(this.memberidLabel);
		add(this.memberTF);
		add(this.nameLabel);
		add(this.nameTF);
		add(this.emailLabel);
		add(this.emailTF);
		add(this.addressLabel);
		add(this.addressTF);
		add(this.contractLabel);
		add(this.contractTF);
		
		add(this.statusLabel);
		add(this.statusTF);
		
		add(this.usernameLabel);
		add(this.userTF);
		
		add(this.passwordlabel);
		add(this.passwordTF);
		
		

		add(this.backBtn);
		add(this.payBtn);

		imgLabel.setSize(938,704);
        this.add(imgLabel);
        image=new ImageIcon("d4.jpg");
        imgLabel.setIcon(image);
		
		
		backBtn.addActionListener(this);
		payBtn.addActionListener(this);
		
		
		 memberTF.setText(ID);           
		 nameTF.setText(Name);
		 emailTF.setText(EMail);
		 addressTF.setText(Address);
		 contractTF.setText(Contact);
		 statusTF.setText(Fine);
		 userTF.setText(UserName);
		 passwordTF.setText(Password); 
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			
	}	


public void actionPerformed(ActionEvent e){
		if(e.getSource()==backBtn){
			new Librarian();
			this.dispose();
			
		}
		
		if(e.getSource()==payBtn){
			this.DBConnect();
			statusTF.setText("0");
			
		}
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(e.getSource()==backBtn)
		{
			
	    backBtn.setBackground(new Color(176,196,222));
		backBtn.setForeground(new Color(72,61,139));
		}
		
		if(e.getSource()==payBtn)
		{
			
	    payBtn.setBackground(new Color(176,196,222));
		payBtn.setForeground(new Color(72,61,139));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		

		if(e.getSource()==backBtn)
		{
			
			backBtn.setBackground(new Color(123,104,238));
			backBtn.setForeground(Color.white);
			
			
		}
		if(e.getSource()==payBtn)
		{
			
			payBtn.setBackground(new Color(123,104,238));
			payBtn.setForeground(Color.white);
			
			
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
            String query = "UPDATE member set Fine ='0'  where UserName= '"+userTF.getText()+"'";
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");
				
				st = con.createStatement();
				System.out.println("statement created");
				
				st.execute(query);
				JOptionPane.showMessageDialog(this, "Thanks. Payment Successful");
				
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
	 
}