package service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.DocumentException;

import jxl.write.WriteException;
import utils.SimpleExcelWrite;
import utils.SimplePdfWrite;
import utils.pageBean;
import dao.customerDaoImpl;
import dao.customercontactDaoImpl;
import entity.Customer;
import entity.Customercontact;

public class customerService {
	private customerDaoImpl customerdaoimpl;
	private customercontactDaoImpl customercontactdaoimpl;
	public void setCustomerdaoimpl(customerDaoImpl customerdaoimpl) {
		this.customerdaoimpl = customerdaoimpl;
	}
	public void setCustomercontactdaoimpl(
			customercontactDaoImpl customercontactdaoimpl) {
		this.customercontactdaoimpl = customercontactdaoimpl;
	}
	
	/**
	 * 显示客户列表
	 * @return
	 */
	public List<Customer> listCustomer(){
		String hql="From Customer where isdel=0 order by id";
		return customerdaoimpl.getCustomerlist(hql);
	}
	
	/**
	 * 获取单个客户信息
	 * @param id 客户id
	 * @return
	 */
	public Customer getCustomer(int id){
		return customerdaoimpl.getCustomer(id);
	}
	
	/**
	 * 添加客户
	 * @param customer 客户类
	 */
	public void addCustomer(Customer customer){
		customerdaoimpl.add(customer);
	}
	
	/**
	 * 修改客户
	 * @param customer 客户类
	 */
	public void editCustomer(Customer customer){
		customerdaoimpl.edit(customer);
	}
	/**
	 * 删除客户,将客户isdel设为1
	 * @param id 客户id
	 */
	public void delCustomer(int id){
		Customer customer=customerdaoimpl.getCustomer(id);
		customer.setIsdel(1);
		customerdaoimpl.edit(customer);
	}
	
	/**
	 * 显示客户联系人列表
	 * @param customerid 客户id
	 * @return 
	 */
	public List<Customercontact> listCustomercontact(int customerid){
		String hql="From Customercontact where customerid="+customerid+" order by id";
		return customercontactdaoimpl.getCustomercontactlist(hql);
	}
	
	/**
	 * 显示联系人
	 * @param id 联系人id
	 * @return
	 */
	public Customercontact getCustomercontact(int id){
		return customercontactdaoimpl.getCustomercontact(id);
	}
	
	/**
	 * 添加联系人
	 * @param customercontact联系人类
	 */
	public void addCustomercontact(Customercontact customercontact){
		customercontactdaoimpl.add(customercontact);
	}
	
	/**
	 * 删除联系人，将联系人isdel设置为1
	 * @param id 联系人id
	 */
	public void delCustomercontact(int id){
		Customercontact customercontact=customercontactdaoimpl.getCustomercontact(id);
		customercontact.setIsdel(1);
		customercontactdaoimpl.edit(customercontact);
	}
	
	/**
	 * 修改联系人
	 * @param customercontact 联系人类
	 */
	public void editCustomercontact(Customercontact customercontact){
		customercontactdaoimpl.edit(customercontact);
	}
	
	/**
	 * 分页查询客户
	 * @param hql
	 * @param currentPage 当前页
	 * @param pageSize 分页大小
	 * @return 分页查询的客户列表
	 */
	public pageBean queryListcustomer(String hql,int currentPage,int pageSize){
		List<Customer> listcustomer=customerdaoimpl.getCustomerlist(hql);
		int totalResult=listcustomer.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		pageBean pagebean=new pageBean();
		pagebean.setTotalResult(totalResult);
		pagebean.setCurrentPage(currentPage);
		pagebean.setTotalPage(totalPage);
		pagebean.setPageSize(pageSize);
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(listcustomer));
		
		return pagebean;
	}
	
	/**
	 * 生成客户贡献excel
	 */
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void excelContr(HttpServletRequest request,List list){
		SimpleExcelWrite sew=new SimpleExcelWrite();
		
		String filename=request.getRealPath("/")+"rept/excelContr.xls";
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			String[] title={"编号","客户名称","订单金额"};
			sew.createExcel(fos,title,list);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将客户贡献报表输出到PDF
	 * @param request
	 * @param list
	 * @throws DocumentException
	 * @throws IOException
	 */
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void pdfContr(HttpServletRequest request,List list) throws DocumentException, IOException{
		SimplePdfWrite spw=new SimplePdfWrite();
		String filename=request.getRealPath("/")+"rept/pdfContr.pdf";
		String[] title={"编号","客户名称","订单金额"};
		spw.ExportPDF(filename, title, list);
	}
}
