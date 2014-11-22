package service;

import java.util.List;

import dao.customercontactDaoImpl;
import entity.Customercontact;

public class customercontactService {
	private customercontactDaoImpl customercontactdaoimpl;

	public List<Customercontact> listCustomercontact(int customerid){
		String hql="From Customercontact where isdel=0 and customerid="+customerid+" order by id";
		return customercontactdaoimpl.getCustomercontactlist(hql);
	}
	
	public Customercontact getCustomercontact(int id){
		return customercontactdaoimpl.getCustomercontact(id);
	}
	
	public customercontactDaoImpl getCustomercontactdaoimpl() {
		return customercontactdaoimpl;
	}

	public void setCustomercontactdaoimpl(
			customercontactDaoImpl customercontactdaoimpl) {
		this.customercontactdaoimpl = customercontactdaoimpl;
	}
	
	public void addCustomercontact(Customercontact customercontact){
		customercontactdaoimpl.add(customercontact);
	}
	
	public void editCustomercontact(Customercontact customercontact){
		customercontactdaoimpl.edit(customercontact);
	}
	
	public void delCustomercontact(int id){
		customercontactdaoimpl.del(id);
	}
	
}
