import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
import java.lang.*;
class Home extends JFrame implements ActionListener,MouseListener{

	
	JButton btnLogin;
	JButton btnReg;
    JTextField txtId;
	JPasswordField txtPass;
	JPanel panel;
	JLabel lblId;
    JLabel lblPass,pageNameLabel,pageNameLabel1;
	JLabel imgLabel;
	ImageIcon image;
		
	
	public Home(){
		this.panel=new JPanel();
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();
		this.lblId = new JLabel("USER ID :");
		this.lblPass = new JLabel("PASSWORD :");
		this.pageNameLabel=new JLabel("Welcome To Library");
		this.pageNameLabel1=new JLabel("Management System");
		
		this.txtId = new JTextField();
		this.txtPass = new JPasswordField();
		
		this.btnLogin = new JButton("Login");
	    this.btnReg = new JButton("Reg");
		this.setLayout(null);
		this.txtId.setBounds(340,250,120,30);
		this.txtPass.setBounds(340,320,120,30);
		this.btnLogin.setBounds(200,410,100,30);
		this.btnReg.setBounds(370,410,100,30);
		this.lblId.setBounds(200,250,160,30);
		this.lblPass.setBounds(200,320,170,30);
		
		lblId.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblId.setForeground(new Color(102,51,153));
		lblPass.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPass.setForeground(new Color(102,51,153));
	
		pageNameLabel.setBounds(150,40,400,100);
		pageNameLabel.setFont(new Font("Forte", Font.BOLD, 35));
		pageNameLabel.setForeground(new Color(75,0,130));
		panel.add(pageNameLabel);
		pageNameLabel1.setBounds(150,110,400,100);
		pageNameLabel1.setFont(new Font("Forte", Font.BOLD, 35));
		pageNameLabel1.setForeground(new Color(75,0,130));
		panel.add(pageNameLabel1);
		btnLogin.setBackground(new Color(153,50,204));
		btnReg.setBackground(new Color(153,50,204));
		btnLogin.setForeground(Color.WHITE);
		btnReg.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("times new roman",Font.BOLD,15));
		btnReg.setFont(new Font("times new roman",Font.BOLD,15));
		btnLogin.addMouseListener(this);
		btnReg.addMouseListener(this);
	    
		add(this.lblId);
		add(this.lblPass);
		add(this.txtId);
		add(this.txtPass);
		add(this.btnLogin);
		add(this.btnReg);
		
		add(this.pageNameLabel);
	    add(this.pageNameLabel1);
		
		
	
		
		btnLogin.addActionListener(this);
		btnReg.addActionListener(this);
		
		
	
		
        this.setTitle("Home");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(737,586);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        
        imgLabel.setSize(737,586);
        this.add(imgLabel);
        image=new ImageIcon("cl1.jpg");
        imgLabel.setIcon(image);	
			
		
	   
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnReg){
			new Reg();
			this.dispose();
			
		}
		if(e.getSource()==btnLogin){
			
			
			
		      if(txtId.getText().equals("admin") && txtPass.getText().equals("12345"))
			  {
				  new Manager();
				  this.dispose();
			  }

           else  {			
			
			this.DBConnect();
			
		   }
		}
	}
		public void DBConnect()
		{
			String query="select UserName,Password,Status from member where UserName='"+txtId.getText()+"'";
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
					String password=rs.getString("Password");
					if(password.equals(new String(txtPass.getText())))
					{
						System.out.println("Login is Confirmed");
						String type=rs.getString("Status");
						int a= Integer.parseInt(type);
						if(a==0)
						{
						new Member();}
						else if(a==1)
						{
							new Librarian();
						}
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong Password");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong UserName");
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
		if(e.getSource()==btnLogin)
		{
			btnLogin.setBackground(new Color(176,196,222));
			btnLogin.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnReg)
		{
			btnReg.setBackground(new Color(176,196,222));
			btnReg.setForeground(new Color(72,61,139));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnLogin)
		{
			btnLogin.setBackground(new Color(123,104,238));
			btnLogin.setForeground(Color.white);
		}
		if(e.getSource()==btnReg)
		{
			btnReg.setBackground(new Color(123,104,238));
		}	btnReg.setForeground(Color.white);
	}


@Override
	public void mousePressed(MouseEvent e) {
		
	}
 @Override
 public void mouseReleased(MouseEvent e)
{

}


	public static void main(String [] ar){
		new Home(); 
	}
	
}