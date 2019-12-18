import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
class Member extends JFrame implements ActionListener,MouseListener{
	
	String usrname;


     JButton btnViewbooks;
	JButton btnViewborrowbooks;
	JButton btnSearchbook;
	JButton btnLogout;
	
	
	JPanel panel;
	JLabel lblName,lb1,lb2;
	JTextField tx1;
	JTextField tx2;
	
	JLabel imgLabel;
	ImageIcon image;
	
    
	
	
	public Member(){
		
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();
		
		this.setTitle("Member");
		this.lblName = new JLabel("Welcome Member");
		
		this.lb1 = new JLabel("Enter Book Name");
		this.tx1 = new JTextField();
		
		this.lb2 = new JLabel("Enter UserName");
		this.tx2 = new JTextField();
		
		lb1.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lb1.setForeground(new Color(0,0,139));
		
		lb2.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lb2.setForeground(new Color(0,0,139));
		
		this.btnViewbooks = new JButton("View Books");
		this.btnSearchbook = new JButton("Search Book");
		this.btnViewborrowbooks= new JButton("View Borrow Book");
		this.btnLogout = new JButton("Logout");
		
		this.setLayout(null);
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		this.lb1.setBounds(300,330,180,30);
		this.tx1.setBounds(300,300,120,30);
		
		this.lb2.setBounds(300,430,180,30);
		this.tx2.setBounds(300,400,120,30);
		
	    this.lblName.setBounds(175,70,400,100);
		lblName.setFont(new Font("century gothic", Font.PLAIN, 30));
		
		this.btnViewbooks.setBounds(200,200,120,30);
		this.btnSearchbook.setBounds(100,300,120,30);
		this.btnViewborrowbooks.setBounds(100,400,150,30);
		this.btnLogout.setBounds(350,500,90,30);
		
		btnViewbooks.addMouseListener(this);
		btnSearchbook.addMouseListener(this);
		btnViewborrowbooks.addMouseListener(this);
		btnLogout.addMouseListener(this);


		lblName.setForeground(new Color(0,0,139));
		
		btnViewbooks.setBackground(new Color(153,50,204));
		btnViewbooks.setForeground(Color.white);
		btnViewborrowbooks.setBackground(new Color(153,50,204));
		btnViewborrowbooks.setForeground(Color.white);
		btnSearchbook.setBackground(new Color(153,50,204));
		btnSearchbook.setForeground(Color.white);
		btnLogout.setBackground(new Color(153,50,204));
		btnLogout.setForeground(Color.white);
		
		
		 add(this.lblName);
		
		add(this.lb1);
		add(this.tx1);
		add(this.lb2);
		add(this.tx2);
		add(this.btnViewbooks);
		add(this.btnSearchbook);
		add(this.btnViewborrowbooks);
		add(this.btnLogout);
		
		btnViewbooks.addActionListener(this);
		btnViewborrowbooks.addActionListener(this);
		
		btnSearchbook.addActionListener(this);
		btnLogout.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imgLabel.setSize(722,663);
        this.add(imgLabel);
        image=new ImageIcon("reg1.jpg");
        imgLabel.setIcon(image);		
			
		
	   
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnViewbooks){
			
			ViewBook.main(new String[]{});
		} 
		
		if(e.getSource()==btnViewborrowbooks){
			
			if (tx2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Please Enter UserName");
			}
			
			else {
			
			ViewBorrow1.main(new String[]{});
			
			usrname=tx2.getText();
			System.out.println("in member: Username: "+usrname);
			
			ViewBorrow1.usrname=usrname;
			
			}
		}
		
		if(e.getSource()==btnSearchbook){
			
			this.DBConnect1();
			
		}
		
		if(e.getSource()==btnLogout){
		
			new Home();
			this.dispose();
			
		}
	}



public void DBConnect1()
		{
			
			String query="select ID,Name,Author,Publisher,Edition,CallNo,Rack,Quantity from book where Name='"+tx1.getText()+"'";
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
					
					if(Name.equals(new String(tx1.getText())))
					{
					
					 BookDetails a =new BookDetails(ID,Name,Author,Publisher,Edition,CallNo,Rack,Quantity);
					 this.dispose();
					
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong Name. Please Enter again");
						tx1.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please Enter Book Name");
					tx1.setText("");
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
		if(e.getSource()==btnViewbooks)
		{
			btnViewbooks.setBackground(new Color(176,196,222));
			btnViewbooks.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnViewborrowbooks)
		{
	    btnViewborrowbooks.setBackground(new Color(176,196,222));
		btnViewborrowbooks.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnSearchbook)
		{
	    btnSearchbook.setBackground(new Color(176,196,222));
		btnSearchbook.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnLogout)
		{
	    btnLogout.setBackground(new Color(176,196,222));
		btnLogout.setForeground(new Color(72,61,139));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnViewbooks)
		{
			btnViewbooks.setBackground(new Color(123,104,238));
			btnViewbooks.setForeground(Color.white);
		}

		if(e.getSource()==btnViewborrowbooks)
		{
			btnViewborrowbooks.setBackground(new Color(123,104,238));
			btnViewborrowbooks.setForeground(Color.white);
		}
		if(e.getSource()==btnSearchbook)
		{
			btnSearchbook.setBackground(new Color(123,104,238));
			btnSearchbook.setForeground(Color.white);
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
	

	public static void main(String [] ar){
		new Member(); 
	}
	
}