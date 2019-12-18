import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.awt.Font;
import java.sql.*;





import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ViewBorrow1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static String usrname;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBorrow1 frame= new ViewBorrow1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public ViewBorrow1() {
		System.out.println("In ViewBorrow1 Username: "+usrname);
		this.setTitle("View Borrowed Books");
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		
		contentPane.setSize(500,300);
		contentPane.setBackground(new Color(127,255,212));		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.add(contentPane);                                                
		
		String data[][]=null;
		String column[]=null;
		
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from issuebook where UserName='"+usrname+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			System.out.println("In Db Username: "+usrname);
			
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			System.out.println("Into the loop:");
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
				System.out.println(column[i-1]);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			System.out.println("In the data loop:");
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
					System.out.println("data: "+data[count][i-1]);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	}

}
