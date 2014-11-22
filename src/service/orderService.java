package service;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

import utils.pageBean;

import dao.orderlistDaoImpl;
import dao.ordersDaoImpl;
import entity.Orderlist;
import entity.Orders;

public class orderService {
	private ordersDaoImpl ordersdaoimpl;
	private orderlistDaoImpl orderlistdaoimpl;

	public ordersDaoImpl getOrdersdaoimpl() {
		return ordersdaoimpl;
	}

	public void setOrdersdaoimpl(ordersDaoImpl ordersdaoimpl) {
		this.ordersdaoimpl = ordersdaoimpl;
	}
	
	
	public orderlistDaoImpl getOrderlistdaoimpl() {
		return orderlistdaoimpl;
	}

	public void setOrderlistdaoimpl(orderlistDaoImpl orderlistdaoimpl) {
		this.orderlistdaoimpl = orderlistdaoimpl;
	}

	/**
	 * 获取订单主表
	 * @return
	 */
	public List<Orders> listOrdersAll(){
		String hql="From Orders group by id";
		return ordersdaoimpl.getOrderslist(hql);
	}
	
	/**
	 * 获取客户销售贡献
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List listOrdersAmount(){
		return ordersdaoimpl.queryOrdersAmount();
	}
	/**
	 * 按客户id号显示对应的订单列表
	 * @param customerid
	 * @return
	 */
	public List<Orders> listOrders(int customerid){
		String hql="From Orders where customerid="+customerid+" order by id";
		
		return ordersdaoimpl.getOrderslist(hql);
	}
	
	/**
	 * 获取订单
	 * @param id
	 * @return
	 */
	public Orders getOrders(int id){
		return ordersdaoimpl.getOrders(id);
	}
	
	/**
	 * 获取订单明细
	 * @param orderid
	 * @return
	 */
	public List<Orderlist> getOrderlist(int orderid){
		String hql="From Orderlist where orderid="+orderid+" order by id";
		return orderlistdaoimpl.getOrderlistlist(hql);
	}
	
	/**
	 * 生成客户贡献图形报表
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void reptCustomerAmount(HttpServletRequest request,List list){
		DefaultPieDataset defaultpiedataset=new DefaultPieDataset();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				Object[] obj=(Object[]) list.get(i);
				defaultpiedataset.setValue(obj[0].toString(),Integer.parseInt(obj[1].toString()));
			}
		}
		//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		   //应用主题样式  
		   ChartFactory.setChartTheme(standardChartTheme);
		   JFreeChart jfreechart=ChartFactory.createPieChart3D("客户贡献统计图", defaultpiedataset);
		   
		   String filename=request.getRealPath("/")+"rept\\contr.jpeg";
		   try {
				FileOutputStream fos=new FileOutputStream(filename);
				ChartUtilities.writeChartAsJPEG(fos, jfreechart, 600, 350);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 分页查询订单
	 * @param hql
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return 分页查询的订单记录
	 */
	public pageBean queryListorders(String hql,int currentPage,int pageSize){
		List<Orders> listorders=ordersdaoimpl.getOrderslist(hql);
		int totalResult=listorders.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		pageBean pagebean=new pageBean();
		pagebean.setTotalPage(totalPage);
		pagebean.setTotalResult(totalResult);
		pagebean.setCurrentPage(currentPage);
		pagebean.setPageSize(pageSize);
		pagebean.setAction("queryListorders");
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(listorders));
		
		return pagebean;
	}
	
	/**
	 * 分页查询客户贡献
	 * @param hql
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListordersamount(String hql,int currentPage,int pageSize){
		List list=ordersdaoimpl.queryOrdersAmount(hql);
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
		pagebean.setAction("queryListordersamount");
		
		return pagebean;
	}
}
