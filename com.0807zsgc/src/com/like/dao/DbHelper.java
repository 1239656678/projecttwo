package com.like.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.like.vo.User;

public class DbHelper {
	//全查
	public List<User>  selectUser() {
		String sql="select * from sys_user";
		List<User> list=DbUtil.selectTable(sql);
		System.out.println(list);
		return list;
	}
	//根据id查询
	public User selectById(int id) {
		String sql="select * from sys_user where id='"+id+"'";
		List<User> list=DbUtil.selectTable(sql);
		return list.size()==0?null:list.get(0);
	}
	//根据username查询
	public User SelectByName(String username) {
		String sql="select * from sys_user where username='"+username+"'";
		List<User> list=DbUtil.selectTable(sql);
		//注意结果为多条的情况
		return list.size()==0?null:list.get(0);
	}
	//分页查询(查询总条数)
	public int selectCount() {
		String sql="select count(*) from sys_user";
		int count=DbUtil.selectPaging(sql);
		return count;
	}
	//获得指定页的数据
	public List<User>  getpageUser(int pageno,int pagesize) {
		String sql="select * from sys_user limit "+(pageno-1)*pagesize+","+pagesize+"";
		List<User> list=DbUtil.selectTable(sql);
		return list;
	}
	//修改
	public  int update(User user) { //根据id修改
		String sql="update sys_user set username='"+user.getUsername()+"',password='"+user.getPassword()+"',createDate='"+user.getCreateDate()+"',name='"+user.getName()+"',phone='"+user.getPhone()+"',address='"+user.getAddress()+"' where id="+user.getId()+"";       
		int i=DbUtil.updateTable(sql);
		return i;
	}
	//增加
	public int insert(User user) {
		String sql="insert into sys_user values("+user.getId()+",'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getCreateDate()+"','"+user.getName()+"','"+user.getPhone()+"','"+user.getAddress()+"')";
		int i=DbUtil.updateTable(sql);
		return i;
	}
	//删除
	public int delete(int id) {
		String sql="delete from sys_user where id="+id+"";
		int i=DbUtil.updateTable(sql);
		return i;
	}
	
	public static void main(String[] args) {
		DbHelper dh=new DbHelper();
//		User user=dh.selectById(1);
//		System.out.println(user);
		
//		User user=new User(1,"one","one","2019-1-1","one","one","one");
//		int i=dh.update(user);
//		System.out.println(i);
		
//		User user=new User(18,"one","one","2019-1-1","one","one","one");
//		int i=dh.insert(user);
//		System.out.println(i);
		
//		int i=dh.delete(18);
//		System.out.print(i);
		
		List<User> list=dh.getpageUser(1, 1);
		System.out.println(list);
		
	}
}
