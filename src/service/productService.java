package service;

import java.util.List;

import utils.pageBean;
import dao.productDaoImpl;
import entity.Product;

public class productService {
	private productDaoImpl productdaoimpl;

	public productDaoImpl getProductdaoimpl() {
		return productdaoimpl;
	}

	public void setProductdaoimpl(productDaoImpl productdaoimpl) {
		this.productdaoimpl = productdaoimpl;
	}
	
	
	public List<Product> listProduct(){
		String hql="From Product order by id";
		return productdaoimpl.getProductlist(hql);
	}
	
	/**
	 * 分页查询商品信息
	 * @param hql
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListproduct(String hql,int currentPage,int pageSize){
		List list=productdaoimpl.queryListproduct(hql);
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
