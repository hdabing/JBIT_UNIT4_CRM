package service;

import java.util.List;

import utils.pageBean;

import dao.areaDaoImpl;
import entity.Area;

public class areaService {
	public areaDaoImpl areadaoimpl;

	public void setAreadaoimpl(areaDaoImpl areadaoimpl) {
		this.areadaoimpl = areadaoimpl;
	}
	
	/**
	 * 显示地区列表
	 * @return
	 */
	public List<Area> listArea(){
		String hql="From Area where isdel=0 order by id";
		return areadaoimpl.getArealist(hql);
	}
	
	public void addArea(Area area){
		areadaoimpl.add(area);
	}
	
	public void editArea(Area area){
		areadaoimpl.edit(area);
	}
	
	public void delArea(int id){
		areadaoimpl.del(id);
	}
	
	public Area getArea(int id){
		return areadaoimpl.getArea(id);
	}
	
	/**
	 * 分页显示地区
	 * @param hql
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListarea(String hql,int currentPage,int pageSize){
		List list=areadaoimpl.queryListarea(hql);
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
}
