package service;

import java.util.List;

import utils.pageBean;

import dao.customerlostDaoImpl;
import entity.Customerlost;

public class customerlostService {
	private customerlostDaoImpl customerlostdaoimpl;

	public customerlostDaoImpl getCustomerlostdaoimpl() {
		return customerlostdaoimpl;
	}

	public void setCustomerlostdaoimpl(customerlostDaoImpl customerlostdaoimpl) {
		this.customerlostdaoimpl = customerlostdaoimpl;
	}
	
	/**
	 * 显示客户流失列表
	 * @return
	 */
	public List<Customerlost> listCustomerlost(){
		String hql="From Customerlost order by id";
		return customerlostdaoimpl.getCustomerlostlist(hql);
	}
	
	
	public List<Customerlost> listAgreelost(){
		String hql="From Customerlost where state='确认流失' order by id";
		return customerlostdaoimpl.getCustomerlostlist(hql);
	}
	
	/**
	 * 获取客户流失信息
	 * @param id 流失id号
	 * @return
	 */
	public Customerlost getCustomerlost(int id){
		return customerlostdaoimpl.getCustomerlost(id);
	}
	
	/**
	 * 修改客户流失
	 * @param customerlost
	 */
	public void editLost(Customerlost customerlost){
		customerlostdaoimpl.edit(customerlost);
	}
	
	/**
	 * 分页显示客户流失列表
	 * @param hql
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public pageBean queryListcustomerlost(String hql,int currentPage,int pageSize){
		List<Customerlost> listcustomerlost=customerlostdaoimpl.getCustomerlostlist(hql);
		int totalResult=listcustomerlost.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		pageBean pagebean=new pageBean();
		pagebean.setTotalPage(totalPage);
		pagebean.setTotalResult(totalResult);
		pagebean.setPageSize(pageSize);
		pagebean.setCurrentPage(currentPage);
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(listcustomerlost));
		
		return pagebean;
	}
	
}
