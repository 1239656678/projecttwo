package com.like.service;

import java.util.List;

import com.like.dao.DbHelper;
import com.like.vo.User;

public class UserService {
	DbHelper dh=new DbHelper();
	//判断用户名密码是否正确
	public boolean isRightUser(String username,String password) {
		User user=dh.SelectByName(username);
		if(null==user||!user.getPassword().equals(password)) {
			System.out.print("用户名密码错误");
			return false;
		}
		return true;
	}
	//根据username查
	public User getUser(String username) {
		User user=dh.SelectByName(username);
		return user;
	}
	//根据id查
    public User selectUser(int id) {
    	return dh.selectById(id);
    }
	//全查
	public List<User> getAllUser() {
		return dh.selectUser();
	}
	//查询Sys_user表的总页数
	public int selectCount(int pagesize) {
		//表示总条数
		int count=dh.selectCount();
		int pageCount=(int)Math.ceil(1.0*count/pagesize);//算出总共需要多少页
        return pageCount;
	}
	//获得指定页的数据
	public List<User>  getpageUser(int pageno,int pagesize) {
		List<User> list=dh.getpageUser(pageno, pagesize);
		return list;
	}
	//根据id修改数据
	public int updateId(User user) {
		return dh.update(user);
	}
	//根据id删除
	public int deleteId(int id) {
		return dh.delete(id);
	}
	//添加数据
	public int insertUser(User user) {
		return dh.insert(user);
	}
}
