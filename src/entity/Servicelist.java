package entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 服务明细表
 * @author 陈捷
 *
 */
@SuppressWarnings("serial")
public class Servicelist implements Serializable {
	private int id;
	private int customerid;// 客户id
	private int operatorid;// 操作人id
	private int userid;// 经理人id
	private int serviceid;// 服务类型id
	private String summary;// 概要
	private String content;// 服务请求
	private int state;// 服务状态id
	private Date createtime;//创建时间
	private Date granttime;//分配时间
	private Date operatortime;//操作时间
	private Servicestate servicestate;//服务状态类
	private Service service;//服务类型
	private Customer customer;//客户类
	private Users operator;//操作员类
	private Users manager;//经理人
	private String operatorcontent;//服务处理内容
	private String resultcontent;//处理结果内容
	private int agreelevel;//客户满意度
	private int createuserid;//创建人id
	private Users createuser;//创建人
	
	
	
	
	public int getAgreelevel() {
		return agreelevel;
	}

	public void setAgreelevel(int agreelevel) {
		this.agreelevel = agreelevel;
	}

	public int getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(int createuserid) {
		this.createuserid = createuserid;
	}

	public Users getCreateuser() {
		return createuser;
	}

	public void setCreateuser(Users createuser) {
		this.createuser = createuser;
	}

	public String getOperatorcontent() {
		return operatorcontent;
	}

	public void setOperatorcontent(String operatorcontent) {
		this.operatorcontent = operatorcontent;
	}

	public String getResultcontent() {
		return resultcontent;
	}

	public void setResultcontent(String resultcontent) {
		this.resultcontent = resultcontent;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getGranttime() {
		return granttime;
	}

	public void setGranttime(Date granttime) {
		this.granttime = granttime;
	}

	public Date getOperatortime() {
		return operatortime;
	}

	public void setOperatortime(Date operatortime) {
		this.operatortime = operatortime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Users getOperator() {
		return operator;
	}

	public void setOperator(Users operator) {
		this.operator = operator;
	}

	public Users getManager() {
		return manager;
	}

	public void setManager(Users manager) {
		this.manager = manager;
	}

	public Servicestate getServicestate() {
		return servicestate;
	}

	public void setServicestate(Servicestate servicestate) {
		this.servicestate = servicestate;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(int operatorid) {
		this.operatorid = operatorid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
