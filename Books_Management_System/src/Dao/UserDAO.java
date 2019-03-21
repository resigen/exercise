package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Users;

public class UserDAO extends BaseDAO {
	

	//查询
	public ArrayList<Users> getUsersByName(String name)
	{
		
		//实体类
		//查询
		//创建了集合-----保存多个Users对象，每一个users对象存放一行数据
		//list里存放 多行数据
		ArrayList<Users> userList=new ArrayList<Users>();
		
		
		String sql="select users.*,zy.title from users,zy where users.zy_id=zy.id and name like '%"+name+"%'";
		
		System.out.println(sql+"========");
		
		Connection con=getCon();
		
		
		try {
			PreparedStatement pst= con.prepareStatement(sql);
						
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				Users u=new Users();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPwd(rs.getString(3));
				u.setAge(rs.getInt(4));
				u.setAddress(rs.getString(5));
				
				userList.add(u);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeCon(con);
		}
		
		return userList;
		
	}
	
	//注册----添加
	
	public boolean add(String name,String pwd,int age,String address)
	{
		
		String sql="insert into users values(users_seq.nextVal,?,?,?,?)";
		Connection con=getCon();
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, pwd);
			pst.setInt(3, age);
			pst.setString(4, address);
		
			
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
	
	public boolean login(String name,String pass)
	{
		String sql="select * from users where name=? and pwd=?";
		
		Connection con=getCon();
		
		
		try {
			
			PreparedStatement pst= con.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, pass);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
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
