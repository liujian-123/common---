package com.liujian.common.utils;

import java.util.Calendar;
import java.util.Date;


public class DateUtil {

	
	/** 
	 * @ClassName: getAge 
	 * @Description: 根据日期计算年龄
	 * @author:刘建
	 * @date: 2019年10月13日 下午6:42:28  
	 */
	public static int getAge(Date birthday) {
		//获取当前系统日历类
		Calendar instance = Calendar.getInstance();
		//获取当前年月日
		int yearNow = instance.get(Calendar.YEAR);
		int monthNow = instance.get(Calendar.MONTH);
		int dateNow = instance.get(Calendar.DAY_OF_MONTH);
		instance.setTime(birthday);
		int yearBirth = instance.get(Calendar.YEAR);
		int monthBirth = instance.get(Calendar.MONTH);
		int dateBirth = instance.get(Calendar.DAY_OF_MONTH);
		//年龄 1990-02-10 2019-02-08
		int age = yearNow - yearBirth;
		if(monthBirth > monthNow) {
			age--;
		}
		//如果月份一致并且日期大于当前日期 年龄减一
		if(monthBirth == monthNow && dateBirth > dateNow) {
			age--;
		}
		return age;
	}
	
	/**
	 * 返回个在minDate和maxDAte之间的随机日期
	 * @Title: getDate 
	 * @Description: TODO
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @return: Date
	 */
	public static Date getDate(Date minDate ,Date maxDate) {
		
		//最小毫秒数
		long min = minDate.getTime();
		long max = maxDate.getTime();
		long x =(long) ((Math.random() * (max -min +1)) +min);
		return new Date(x);
		
	}
	
	
	/*
	* 方法1：(5分) 返回给定日期的月初
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	public static Date getDateByInitMonth(Date src){
		//获取日历类
		Calendar instance = Calendar.getInstance();
		//用传入得日期初始化日历类
		instance.setTime(src);
		//改变日期，设置为月初 即1号得00：00：00
		instance.set(Calendar.DAY_OF_MONTH, 1);
		instance.set(Calendar.MONTH, 2);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		return instance.getTime();
	}
	
	/*
	* 方法2：(5分) //返回给定日期的月末
	* 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static Date getDateByFullMonth(Date src){
		//思路让传入的月份+1，再把小时分秒都设置为0最后让日期减去1秒
		//获取日历类
		Calendar instance = Calendar.getInstance();
		//用传入的日期初始化日历类
		instance.setTime(src);
		//让月份加1
		instance.add(Calendar.MONTH, 1);
		//调用月初的工具类返回，月初
		Date dateByInitMonth = getDateByInitMonth(instance.getTime());
		//用月初初始化日历类
		instance.add(Calendar.SECOND,-1);
		
		return instance.getTime();
	}

	/** 
	 * @Title: getdateByBefore 
	 * @Description: 24小時之前的時間
	 * @return
	 * @return: Date
	 */
	public static Date getDateByBefore() {
		//現獲取Calender
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(instance.getTime()+"+++++++++++++++++++");
		return instance.getTime();
	}
		
}
