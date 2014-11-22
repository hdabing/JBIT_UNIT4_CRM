package entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 计划表
 * 
 * @author 陈捷
 * 
 */
@SuppressWarnings("serial")
public class Chancesplan implements Serializable {
	private int id;
	private int chancesid;// 销售机会id
	private Date plantime;// 计划日期
	private String planname;// 计划项
	private String effect;// 执行效果

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChancesid() {
		return chancesid;
	}

	public void setChancesid(int chancesid) {
		this.chancesid = chancesid;
	}

	public Date getPlantime() {
		return plantime;
	}

	public void setPlantime(Date plantime) {
		this.plantime = plantime;
	}

	public String getPlanname() {
		return planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

}
