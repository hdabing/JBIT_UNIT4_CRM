package entity;

import java.io.Serializable;
import java.sql.Date;
/**
 * 销售机会表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Chances implements Serializable {
	private int id;
	private String name;// 客户名称
	private int areaid;// 区域id
	private int levelid;// 等级id
	private String managername;// 负责人
	private String chancesfrom;// 机会来源
	private String phone;// 电话
	private String content;// 概要
	private int successrate;// 成功率
	private String chancesdesc;// 机会描述
	private int userid;// 指派人员id
	private int createuserid;// 创建人id
	private Date createtime;// 创建时间
	private Date chancestime;// 指派时间
	private int state;// 状态
	private int issuccess;// 是否成功0未成功，1成功
	private Chancestate chancestate;// 销售机会状态
	private Customerlevel customerlevel;// 客户等级
	private Users grantuser;// 指派用户
	private Users createuser;// 创建用户
	private Area area;// 区域

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Users getCreateuser() {
		return createuser;
	}

	public void setCreateuser(Users createuser) {
		this.createuser = createuser;
	}

	public int getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(int createuserid) {
		this.createuserid = createuserid;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Chancestate getChancestate() {
		return chancestate;
	}

	public void setChancestate(Chancestate chancestate) {
		this.chancestate = chancestate;
	}

	public Customerlevel getCustomerlevel() {
		return customerlevel;
	}

	public void setCustomerlevel(Customerlevel customerlevel) {
		this.customerlevel = customerlevel;
	}

	public Users getGrantuser() {
		return grantuser;
	}

	public void setGrantuser(Users grantuser) {
		this.grantuser = grantuser;
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

	public String getChancesfrom() {
		return chancesfrom;
	}

	public void setChancesfrom(String chancesfrom) {
		this.chancesfrom = chancesfrom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSuccessrate() {
		return successrate;
	}

	public void setSuccessrate(int successrate) {
		this.successrate = successrate;
	}

	public String getChancesdesc() {
		return chancesdesc;
	}

	public void setChancesdesc(String chancesdesc) {
		this.chancesdesc = chancesdesc;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getChancestime() {
		return chancestime;
	}

	public void setChancestime(Date chancestime) {
		this.chancestime = chancestime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getIssuccess() {
		return issuccess;
	}

	public void setIssuccess(int issuccess) {
		this.issuccess = issuccess;
	}

}
