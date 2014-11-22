package service;

import java.util.List;

import utils.pageBean;
import dao.usersDaoImpl;
import entity.Roleauthor;
import entity.Users;

/**
 * 用户类服务
 * @author 陈捷
 *
 */
public class userService {
	private usersDaoImpl usersdaoimpl;

	public void setUsersdaoimpl(usersDaoImpl usersdaoimpl) {
		this.usersdaoimpl = usersdaoimpl;
	}
	
	/**
	 * 用户登录检测
	 * @param user 用户对象
	 * @return 检测通过返回true，否则返回false
	 */
	public boolean checkLogin(Users user){
		String hql="From Users where isdel=0 and username='"+user.getUsername()
				+"' and password='"+user.getPassword()+"'";
		if(usersdaoimpl.getUserslist(hql).size()>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据用户名密码返回Hibernate用户类型
	 * @param user
	 * @return
	 */
	public Users getUser(Users user){
		return usersdaoimpl.getUsers(user);
	}
	
	/**
	 * 根据用户id返回该用户类
	 * @param id 用户id
	 * @return 用户类
	 */
	public Users getUser(int id){
		return usersdaoimpl.getUsers(id);
	}
	
	/**
	 * 获取用户列表
	 * @return 用户列表
	 */
	public List<Users> getUserslist(){
		String hql="From Users where isdel=0 order by id";
		return usersdaoimpl.getUserslist(hql);
	}
	/**
	 * 添加用户
	 * @param users 用户类
	 */
	public void addUser(Users user){
		usersdaoimpl.add(user);
	}
	
	/**
	 * 删除用户
	 */
	public void delUser(int id){
		usersdaoimpl.del(id);
	}
	
	/**
	 * 修改用户
	 * @param user 用户类
	 */
	public void editUser(Users user){
		usersdaoimpl.edit(user);
	}
	
	/**
	 * 分页查询用户信息
	 * @param hql
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListusers(String hql,int currentPage,int pageSize){
		List list=usersdaoimpl.queryListusers(hql);
		int totalResult=list.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		pageBean pagebean=new pageBean();
		pagebean.setTotalPage(totalPage);
		pagebean.setTotalResult(totalResult);
		pagebean.setPageSize(pageSize);
		pagebean.setCurrentPage(currentPage);
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(list));
		
		return pagebean;
	}
	
	
	/**
	 * 将角色权限列表转换为角色权限JSON格式的字符串，然后给前台权限赋值
	 * @param List 角色权限的列表
	 * @return
	 */
	public String RoleauthorToJSON(List<Roleauthor> listroleauthor){
		String str_json="{";
		if(listroleauthor!=null){
			for(Roleauthor roleauthor:listroleauthor){
				str_json+="'"+roleauthor.getAuthor().getCode()+"':'"+roleauthor.getIsdel()+"',";
			}
		}
		str_json=str_json.substring(0, str_json.length()-1);
		str_json+="}";
		return str_json;
	}
}
