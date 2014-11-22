package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换工具
 * @author 陈捷
 *
 */
public class dateTools {
	
	/**
	 * 获取字符串类型日期
	 * @return 字符串类型日期
	 */
	@SuppressWarnings("deprecation")
	public String getDate(){
		String strDate="";
		Calendar calendar=Calendar.getInstance();
		Date date = calendar.getTime();
		strDate=(date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
		return strDate;
	}
	
	/**
	 * 将日期格式化为字符串格式
	 * @param date sql日期类
	 * @return 字符串格式的日期
	 */
	public String FormatDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat();
		return sdf.format(date);
	}
	
	/**
	 * 获取SQL的date类型
	 * @return
	 */
	public java.sql.Date getSqlDate(){
		return java.sql.Date.valueOf(this.getDate());
	}
}
