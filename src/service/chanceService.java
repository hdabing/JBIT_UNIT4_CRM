package service;

import java.util.List;

import utils.pageBean;
import dao.chancesDaoImpl;
import dao.chancesplanDaoImpl;
import dao.customerDaoImpl;
import entity.Chances;
import entity.Chancesplan;
import entity.Customer;

public class chanceService {
	private chancesDaoImpl chancesdaoimpl;
	private chancesplanDaoImpl chancesplandaoimpl;
	private customerDaoImpl customerdaoimpl;

	public void setCustomerdaoimpl(customerDaoImpl customerdaoimpl) {
		this.customerdaoimpl = customerdaoimpl;
	}

	public void setChancesplandaoimpl(chancesplanDaoImpl chancesplandaoimpl) {
		this.chancesplandaoimpl = chancesplandaoimpl;
	}

	public void setChancesdaoimpl(chancesDaoImpl chancesdaoimpl) {
		this.chancesdaoimpl = chancesdaoimpl;
	}
	
	/**
	 * 显示销售机会列表
	 * @return
	 */
	public List<Chances> listChances(){
		String hql="From Chances where state=1";//状态1为未指派
		return chancesdaoimpl.getChanceslist(hql);
	}
	
	/**
	 * 添加销售机会
	 * @param chances
	 */
	public void addChances(Chances chances){
		chancesdaoimpl.add(chances);
	}
	
	/**
	 * 获取销售机会
	 * @param id:销售机会id
	 * @return 销售机会
	 */
	public Chances getChances(int id){
		return chancesdaoimpl.getChances(id);
	}
	
	/**
	 * 修改销售机会
	 * @param chances
	 */
	public void editChances(Chances chances){
		chancesdaoimpl.edit(chances);
	}
	
	/**
	 * 删除销售机会
	 * @param id
	 */
	public void delChances(int id){
		chancesdaoimpl.del(id);
	}
	
	/**
	 * 显示客户开发计划列表
	 * @return
	 */
	public List<Chances> listChancesOfplan(){
		//状态2为开发中,3为已归档,4为开发失败
		String hql="From Chances where state in(2,3,4)";
		return chancesdaoimpl.getChanceslist(hql);
	}
	
	/**
	 * 显示客户开发计划明细
	 * @param chancesid开发计划id 
	 * @return
	 */
	public List<Chancesplan> listChancesplan(int chancesid){
		String hql="From Chancesplan where chancesid="+chancesid+"  order by id";
		return chancesplandaoimpl.getChancesplanlist(hql);
	}
	/**
	 * 添加开发计划
	 * @param chancesplan
	 */
	public void addChancesplan(Chancesplan chancesplan){
		chancesplandaoimpl.add(chancesplan);
	}
	
	/**
	 * 删除开发计划
	 * @param id
	 */
	public void delChancesplan(int id){
		chancesplandaoimpl.del(id);
	}
	
	/**
	 * 执行开发计划
	 * @param chancesplan
	 */
	public void executeChancesplan(Chancesplan chancesplan){
		chancesplandaoimpl.edit(chancesplan);
	}
	
	/**
	 * 开发成功,添加新客户
	 * @param id 销售机会id
	 */
	public void successChances(int id){
		chancesdaoimpl.successChances(id);
		Chances chances=chancesdaoimpl.getChances(id);
		Customer customer=new Customer();
		customer.setName(chances.getName());
		customer.setAreaid(chances.getAreaid());
		customer.setLevelid(chances.getLevelid());
		customer.setManagername(chances.getManagername());
		customer.setUserid(chances.getUserid());
		customer.setPhone(chances.getPhone());
		customer.setAgreelevel(1);
		customer.setCreditlevel(1);
		customer.setPostcode("");
		customer.setAddress("");
		customer.setFax("");
		customer.setWebsite("");
		customer.setBussinesscode("");
		customer.setBussinessmoney(0);
		customer.setRegbank("");
		customer.setRegsmoney(0);
		customer.setLandtaxcode("");
		customer.setLegalperson(chances.getManagername());
		customer.setBankaccount("");
		customer.setNationaltaxcode("");
		customer.setIsdel(0);
		customer.setIslost(0);
		
		customerdaoimpl.add(customer);
	}
	
	/**
	 * 开发失败
	 * @param id 销售机会id
	 */
	public void failChances(int id){
		chancesdaoimpl.failChances(id);
	}
	
	/**
	 * 分页查询销售机会管理
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return 分页bean
	 */
	public pageBean queryChancesForPage(String hql,int currentPage,int pageSize){
		List<Chances> listchances=chancesdaoimpl.getChanceslist(hql);
		int totalResult=listchances.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		
		//将结果保存到pagebean
		pageBean pagebean=new pageBean();
		pagebean.setPageSize(pageSize);
		pagebean.setCurrentPage(currentPage);
		pagebean.setTotalResult(totalResult);
		pagebean.setTotalPage(totalPage);
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(listchances));
		
		return pagebean;
	}
	
	/**
	 * 分页查询销售机会
	 * @return
	 */
	public pageBean queryListchances(String hql,int currentPage,int pageSize){
		
		pageBean pagebean=queryChancesForPage(hql,currentPage,pageSize);
		
		return pagebean;
	}
	

}
