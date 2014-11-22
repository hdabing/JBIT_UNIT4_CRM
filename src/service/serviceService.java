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
import dao.serviceDaoImpl;
import dao.servicelistDaoImpl;
import dao.servicestateDaoImpl;
import entity.Service;
import entity.Servicelist;
import entity.Servicestate;

public class serviceService {
	private servicelistDaoImpl servicelistdaoimpl;
	private servicestateDaoImpl servicestatedaoimpl;
	private serviceDaoImpl servicedaoimpl;
	public servicelistDaoImpl getServicelistdaoimpl() {
		return servicelistdaoimpl;
	}
	public void setServicelistdaoimpl(servicelistDaoImpl servicelistdaoimpl) {
		this.servicelistdaoimpl = servicelistdaoimpl;
	}
	public servicestateDaoImpl getServicestatedaoimpl() {
		return servicestatedaoimpl;
	}
	public void setServicestatedaoimpl(servicestateDaoImpl servicestatedaoimpl) {
		this.servicestatedaoimpl = servicestatedaoimpl;
	}
	public serviceDaoImpl getServicedaoimpl() {
		return servicedaoimpl;
	}
	public void setServicedaoimpl(serviceDaoImpl servicedaoimpl) {
		this.servicedaoimpl = servicedaoimpl;
	}
	
	/*****************服务信息明细操作*********************/
	/**
	 * 获取服务信息明细
	 * @return 服务明细列表
	 */
	public List<Servicelist> listServicelist(){
		String hql="From Servicelist order by id";
		return servicelistdaoimpl.getServicelistlist(hql);
	}
	
	/**
	 * 获取未分配服务列表
	 * @return
	 */
	public List<Servicelist> listServicelistUnGrant(){
		String hql="From Servicelist where state=1 order by id";
		return servicelistdaoimpl.getServicelistlist(hql);
	}
	
	/**
	 * 获取已分配的服务列表
	 * @return
	 */
	public List<Servicelist> listServicelistGrant(){
		String hql="From Servicelist where state=2 order by id";
		return servicelistdaoimpl.getServicelistlist(hql);
	}
	
	/**
	 * 获取已操作的服务列表
	 */
	public List<Servicelist> listServicelistOperator(){
		String hql="From Servicelist where state=3 order by id";
		return servicelistdaoimpl.getServicelistlist(hql);
	}
	
	/**
	 * 获取已归档的服务列表
	 * @return
	 */
	public List<Servicelist> listArchservicelist(){
		String hql="From Servicelist where state=4 order by id";
		return servicelistdaoimpl.getServicelistlist(hql);
	}
	/**
	 * 获取服务信息
	 * @param id 服务信息id
	 * @return 服务信息
	 */
	public Servicelist getServicelist(int id){
		return servicelistdaoimpl.getServicelist(id);
	}
	/**
	 * 添加服务信息
	 * @param servicelist
	 */
	public void addServicelist(Servicelist servicelist){
		servicelistdaoimpl.add(servicelist);
	}
	
	/**
	 * 修改服务信息
	 * @param servicelist
	 */
	public void editServicelist(Servicelist servicelist){
		servicelistdaoimpl.edit(servicelist);
	}
	
	/**
	 * 删除服务信息
	 * @param id
	 */
	public void delServicelist(int id){
		servicelistdaoimpl.del(id);
	}
	
	/*****************服务类型操作*********************/
	/**
	 * 获取服务类型列表
	 * @return 服务类型列表
	 */
	public List<Service> listService(){
		String hql="From Service where isdel=0 order by id";
		return servicedaoimpl.getServicelist(hql);
	}
	
	/**
	 * 获取服务类型
	 * @param id 服务类型id
	 * @return 服务类型
	 */
	public Service getService(int id){
		return servicedaoimpl.getService(id);
	}
	
	/**
	 * 添加服务类型
	 * @param service 服务类型
	 */
	public void addService(Service service){
		servicedaoimpl.add(service);
	}
	
	/**
	 * 修改服务类型
	 * @param service 服务类型
	 */
	public void editService(Service service){
		servicedaoimpl.edit(service);
	}
	
	/**
	 * 删除服务类型
	 * @param id 服务类型id
	 */
	public void delService(int id){
		servicedaoimpl.del(id);
	}
	
	/*****************服务状态操作*********************/
	/**
	 * 获取服务状态列表
	 * @return 服务状态列表
	 */
	public List<Servicestate> listServicestate(){
		String hql="From Servicestate where isdel=0 order by id";
		return servicestatedaoimpl.getServicestatelist(hql);
	}
	
	/**
	 * 获取服务状态
	 * @param id 服务状态id
	 * @return 服务状态
	 */
	public Servicestate getServicestate(int id){
		return servicestatedaoimpl.getServicestate(id);
	}
	
	/**
	 * 添加服务状态
	 * @param servicestate 服务状态
	 */
	public void addServicestate(Servicestate servicestate){
		servicestatedaoimpl.add(servicestate);
	}
	
	/**
	 * 修改服务状态
	 * @param servicestate 服务状态
	 */
	public void editServicestate(Servicestate servicestate){
		servicestatedaoimpl.edit(servicestate);
	}
	
	/**
	 * 删除服务状态
	 * @param id 服务状态id
	 */
	public void delServicestate(int id){
		servicestatedaoimpl.del(id);
	}
	
	/**
	 * 统计服务数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List countService(){
		return servicedaoimpl.countService();
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void drawCountService(HttpServletRequest request,List list){
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
				dcd.addValue(Integer.parseInt(obj[1].toString()), obj[0].toString(), "服务类型");
			}
		}
		JFreeChart jfc=ChartFactory.createBarChart3D("客户服务统计图", null, "服务数量", dcd);
		
		String filename=request.getRealPath("/")+"rept/ser.jpeg";
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
	 * 分页查询服务明细记录
	 * @param hql
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return 分页大小的服务明细记录集
	 */
	public pageBean queryListservicelist(String hql,int currentPage,int pageSize){
		List<Servicelist> listservicelist=servicelistdaoimpl.getServicelistlist(hql);
		int totalResult=listservicelist.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		pageBean pagebean=new pageBean();
		pagebean.setTotalPage(totalPage);
		pagebean.setTotalResult(totalResult);
		pagebean.setPageSize(pageSize);
		pagebean.setCurrentPage(currentPage);
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(listservicelist));
		
		return pagebean;
	}
	
	/**
	 * 分页查询客户服务分析
	 * @param hql
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListservicelistCount(String hql,int currentPage,int pageSize){
		List list=servicedaoimpl.countService(hql);
		int totalResult=list.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		pageBean pagebean=new pageBean();
		pagebean.setTotalPage(totalPage);
		pagebean.setTotalResult(totalResult);
		pagebean.setPageSize(pageSize);
		pagebean.setCurrentPage(currentPage);
		pagebean.setAction("queryListservicelistCount");
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(list));
		
		return pagebean;
	}
	
	/**
	 * 分页查询服务类型
	 * @param hql
	 * @param currentPage 当前页
	 * @param pageSize 分页大小 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListservice(String hql,int currentPage,int pageSize){
		List list=servicedaoimpl.queryService(hql);
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
	 * 写入数据到客户服务统计excel表格
	 * @throws IOException 
	 * @throws WriteException 
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void excelSer(HttpServletRequest request,List list) throws WriteException, IOException{
		String filename=request.getRealPath("/")+"rept/excelSer.xls";
		FileOutputStream fos=new FileOutputStream(filename);
		String[] title={"编号","服务类型","服务数量"};
		SimpleExcelWrite sw=new SimpleExcelWrite();
		sw.createExcel(fos, title, list);
	}
	
	/**
	 * 写入数据到客户服务统计PDF文件
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws DocumentException 
	 */
	@SuppressWarnings({ "rawtypes", "deprecation", "unused" })
	public void PdfSer(HttpServletRequest request,List list) throws WriteException, IOException, DocumentException{
		String filename=request.getRealPath("/")+"rept/pdfSer.pdf";
		FileOutputStream fos=new FileOutputStream(filename);
		String[] title={"编号","服务类型","服务数量"};
		SimplePdfWrite spw=new SimplePdfWrite();
		spw.ExportPDF(filename, title, list);
	}
}
