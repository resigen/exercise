package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Users;
import entity.booklist;

public class booklistDAO extends BaseDAO {
	

	//��ѯ
	public ArrayList<booklist> getbooklistByName(String name)
	{
		
		//ʵ����
		//��ѯ
		//�����˼���-----������Users����ÿһ��users������һ������
		//list���� ��������
		ArrayList<booklist> bookList=new ArrayList<booklist>();
		
		
		String sql="select * from booklist where name like '%"+name+"%'";
		
		System.out.println(sql+"========");
		
		Connection con=getCon();
		
		
		try {
			PreparedStatement pst= con.prepareStatement(sql);
						
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				booklist u=new booklist();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setprice(rs.getString(3));
				u.setauth(rs.getString(4));
				u.setpub_date(rs.getString(5));
				u.setpress(rs.getString(6));
				u.setstates(rs.getString(7));
				bookList.add(u);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeCon(con);
		}
		
		return bookList;
		
	}
	
	//ע��----���
	
	public boolean add(String name,String price,String auth,String pub_date,String press)
	{
		
		String sql="insert into booklist values(booklist_seq.nextVal,?,?,?,?,?,'��')";
		Connection con=getCon();
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, price);
			pst.setString(3, auth);
			pst.setString(4, pub_date);
			pst.setString(5, press);
			
			int count=pst.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeCon(con);
		}
		
		
		
		return false;
		
		
		
		
		
	}
	
	public boolean repair(int id)
	{
String sql="update booklist set states='��' where id="+id;
		
		Connection con=getCon();

		try {
			Statement st= con.createStatement();
			int count=st.executeUpdate(sql);
			
			if(count>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeCon(con);
		}
		
		return false;
		
	}
	
	public boolean borrowed(int id)
	{
		String sql="update booklist set states='��' where id="+id;
		
		Connection con=getCon();
		
		
		try {
			Statement st= con.createStatement();
			int count=st.executeUpdate(sql);
			
			if(count>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeCon(con);
		}
		
		return false;
		
	}
	
	
	
	
	public boolean update(String name,String price,String auth,String pub_date,String press,int id)
	{
		
		String sql="update booklist set name=?,price=?,auth=?,pub_date=?,press=? where id=?";
		Connection con=getCon();
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, price);
			pst.setString(3, auth);
			pst.setString(4, pub_date);
			pst.setString(5, press);
			pst.setInt(6, id);
			
			int count=pst.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeCon(con);
		}
		
		
		
		return false;
	}



		public boolean delete(int id) 
		{
			String sql="delete from booklist  where id="+id;
			
			Connection con=getCon();
			
			
			try {
				Statement st= con.createStatement();
				int count=st.executeUpdate(sql);
				
				if(count>0)
				{
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				closeCon(con);
			}
			
			return false;	
	}
}
