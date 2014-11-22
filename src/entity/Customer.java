package entity;

import java.io.Serializable;

/**
 * 客户表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Customer implements Serializable {
	private int id;
	private String name;// 客户名称
	private String code;// 客户编号
	private int userid;// 客户经理id
	private int areaid;// 区域id
	private int levelid;// 用户等级id
	private String managername;// 负责人
	private int agreelevel;// 满意度
	private int creditlevel;// 信誉度
	private String address;// 地址
	private String postcode;// 邮政编码
	private String phone;// 电话
	private String fax;// 传真
	private String website;// 网站
	private String bussinesscode;// 营业执照
	private float regsmoney;// 注册资金
	private String regbank;// 开户行
	private String landtaxcode;// 地税登记号
	private String legalperson;// 法人
	private float bussinessmoney;// 年营业额
	private String bankaccount;// 银行账号
	private String nationaltaxcode;// 国税登记号
	private int islost;// 是否流失
	private int isdel;//是否删除  0未删除，1删除
	
	private Users users;//客户经理
	private Area area;//区域
	private Customerlevel customerlevel;//客户等级
	
	
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Customerlevel getCustomerlevel() {
		return customerlevel;
	}
	public void setCustomerlevel(Customerlevel customerlevel) {
		this.customerlevel = customerlevel;
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	public int getLevelid() {
		return levelid;
	}

	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public int getAgreelevel() {
		return agreelevel;
	}

	public void setAgreelevel(int agreelevel) {
		this.agreelevel = agreelevel;
	}

	public int getCreditlevel() {
		return creditlevel;
	}

	public void setCreditlevel(int creditlevel) {
		this.creditlevel = creditlevel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBussinesscode() {
		return bussinesscode;
	}

	public void setBussinesscode(String bussinesscode) {
		this.bussinesscode = bussinesscode;
	}

	public float getRegsmoney() {
		return regsmoney;
	}

	public void setRegsmoney(float regsmoney) {
		this.regsmoney = regsmoney;
	}

	public String getRegbank() {
		return regbank;
	}

	public void setRegbank(String regbank) {
		this.regbank = regbank;
	}

	public String getLandtaxcode() {
		return landtaxcode;
	}

	public void setLandtaxcode(String landtaxcode) {
		this.landtaxcode = landtaxcode;
	}

	public String getLegalperson() {
		return legalperson;
	}

	public void setLegalperson(String legalperson) {
		this.legalperson = legalperson;
	}

	public float getBussinessmoney() {
		return bussinessmoney;
	}

	public void setBussinessmoney(float bussinessmoney) {
		this.bussinessmoney = bussinessmoney;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getNationaltaxcode() {
		return nationaltaxcode;
	}

	public void setNationaltaxcode(String nationaltaxcode) {
		this.nationaltaxcode = nationaltaxcode;
	}

	public int getIslost() {
		return islost;
	}

	public void setIslost(int islost) {
		this.islost = islost;
	}

}
