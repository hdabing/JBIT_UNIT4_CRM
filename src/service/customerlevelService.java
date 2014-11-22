package service;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.write.WriteException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.text.DocumentException;

import utils.SimpleExcelWrite;
import utils.SimplePdfWrite;
import utils.pageBean;
import dao.customerlevelDaoImpl;
import entity.Customerlevel;

public class customerlevelService {
	public customerlevelDaoImpl customerleveldaoimpl;
	
	public void setCustomerleveldaoimpl(customerlevelDaoImpl customerleveldaoimpl) {
		this.customerleveldaoimpl = customerleveldaoimpl;
	}

	/**
	 * 获取客户等级列表
	 * @return
	 */
	public List<Customerlevel> listCustomerlevel(){
		String hql="From Customerlevel where isdel=0 order by id";
		return customerleveldaoimpl.getCustomerlevellist(hql);
	}
	
	/**
	 * 获取客户等级信息
	 * @param id 客户等级id 
	 * @return
	 */
	public Customerlevel getCustomerlevel(int id){
		return customerleveldaoimpl.getCustomerlevel(id);
	}
	
	/**
	 * 修改客户等级信息
	 * @param customerlevel
	 */
	public void editCustomerlevel(Customerlevel customerlevel){
		customerleveldaoimpl.edit(customerlevel);
	}
	
	/**
	 * 删除客户等级,将客户等级isdel设置为1
	 * @param id
	 */
	public void delCustomerlevel(int id){
		customerleveldaoimpl.del(id);
	}
	
	public void addCustomerlevel(Customerlevel customerlevel){
		customerlevel.setIsdel(0);
		customerleveldaoimpl.add(customerlevel);
	}
	
	/**
	 * 客户等级数量统计
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List countCutstomerlevel(){
		return customerleveldaoimpl.queryCustomerlevel();
	}
	
	/**
	 * 生成客户等级柱状图
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void drawCountcustomerlevel(HttpServletRequest request,List list){
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
		DefaultCategoryDataset dcd=new DefaultCategoryDataset();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				Object[] obj=(Object[]) list.get(i);
				dcd.addValue(Integer.parseInt(obj[1].toString()), obj[0].toString(), "客户类型");
			}
		}
		JFreeChart jfc=ChartFactory.createBarChart3D("客户构成统计图", null, "客户数量", dcd);
		
		String filename=request.getRealPath("/")+"rept/cons.jpeg";
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ChartUtilities.writeChartAsJPEG(fos, jfc, 600, 350);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询客户类型统计
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListcustomercount(int currentPage,int pageSize){
		List list=customerleveldaoimpl.queryCustomerlevel();
		int totalResult=list.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		pageBean pagebean=new pageBean();
		pagebean.setTotalPage(totalPage);
		pagebean.setTotalResult(totalResult);
		pagebean.setPageSize(pageSize);
		pagebean.setCurrentPage(currentPage);
		pagebean.setAction("queryListcustomercount");
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(list));
		
		return pagebean;
	}
	
	/**
	 * 分页查询客户等级
	 * @param hql
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListcustomer(String hql,int currentPage,int pageSize){
		List list=customerleveldaoimpl.queryCustomerlevel(hql);
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
	 * 将客户等级统计数据写入excel
	 * @param request
	 * @param list 客户等级统计数据
	 * @throws IOException 
	 * @throws WriteException 
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void excelCountlevel(HttpServletRequest request,List list) throws WriteException, IOException{
		String filename=request.getRealPath("/")+"rept/excelCountlevel.xls";
		FileOutputStream fos=new FileOutputStream(filename);
		SimpleExcelWrite sw=new SimpleExcelWrite();
		String[] title={"编号","客户等级","数量"};
		sw.createExcel(fos, title, list);
	}
	
	/**
	 * 将客户等级统计数据写入PDF
	 * @param request
	 * @param list 客户等级统计数据
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws DocumentException 
	 */
	@SuppressWarnings({ "rawtypes", "unused", "deprecation" })
	public void pdfCountlevel(HttpServletRequest request,List list) throws WriteException, IOException, DocumentException{
		String filename=request.getRealPath("/")+"rept/pdfCountlevel.pdf";
		FileOutputStream fos=new FileOutputStream(filename);
		SimplePdfWrite spw=new SimplePdfWrite();
		String[] title={"编号","客户等级","数量"};
		spw.ExportPDF(filename, title, list);
	}
}
