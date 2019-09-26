package com.like.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.like.vo.User;

public class DbUtil {
	//创建连接
	public static Connection  getConn() {
		try {
			Class.forName(DbInterface.JDBC_DRIVER);
			Connection conn=DriverManager.getConnection(DbInterface.JDBC_URL,DbInterface.JDBC_NAME,DbInterface.JDBC_PASSWORD);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//关流
	public static void getClose(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(null!=rs) {
					conn.close();
			}
			if(null!=ps) {
					ps.close();
			}
			if(null!=conn&&!conn.isClosed()) {
					conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询
	public static List<User> selectTable(String sql){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>();
		try {
			conn=DbUtil.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				User user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("createDate"),rs.getString("name"),rs.getString("phone"),rs.getString("address"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.getClose(conn, ps, rs);
		}
		return list;
	}
	//分页查询(查询总页数)
	public static int selectPaging(String sql) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try {
			conn=DbUtil.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.getClose(conn, ps, null);
		}
		return count;
	}
	//增删改
	public static int updateTable(String sql) {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		try {
			conn=DbUtil.getConn();
			ps=conn.prepareStatement(sql);
			i=ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.getClose(conn, ps, null);
		}
		return i;
	}
	public static void main(String[] args) {
//		String sql="select * from sys_user";
//		List<User> list=DbUtil.selectTable(sql);
//		System.out.println(list);
		
//		String sql="update sys_user set username='1111',password='1111' where id=1";
//		int i=DbUtil.updateTable(sql);
//		System.out.println(i);
		
		String sql="select count(*) from sys_user";
		int i=DbUtil.selectPaging(sql);
		System.out.println(i);
	}
}
