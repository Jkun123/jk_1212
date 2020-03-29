package com.jk.test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jk.beans.Inspection;
import com.jk.beans.Status;
import com.jk.mapper.InspectionMapper;
import com.jk.utils.DateUtil;
import com.jk.utils.IOUtil;
import com.jk.utils.StringUtils;


public class TestIO {

	public static void main(String[] args) throws Exception {
		int i=1;
			ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
			InspectionMapper bean = app.getBean(InspectionMapper.class);
			List<Object[]> readFile = IOUtil.readFile("cms附件-机械设备公司年检信息.txt", "\\t");
			for (Object[] objects : readFile) {
			//	System.out.println(Arrays.toString(objects));
				Inspection is = new Inspection();
//			主键 System.out.println(objects[0]); 
				
				String id = objects[0]+"";
				String keyword = objects[1]+"";
				String mes = objects[2]+"";
				String name = objects[3]+"";
				String product = objects[4]+"";
				String address = objects[5]+"";
				String capital = objects[6]+"";
				String idate = objects[7]+"";
				String status = objects[10]+"";
				if(i==1){
					id=id.substring(1);
				}
				i++;
//				a.id值要使用isNumber()工具方法判断是不是数字（3分）
				if(StringUtils.isNumber(id)){
					is.setId(new BigInteger(id));
				}
//				b. keywords	、description、公司名称、主营产品、地址要使用hasText()方法判断有没有值。（3分）
				if(!StringUtils.isEmpty2(keyword)){
					is.setKeyword(keyword);
				}
				if(!StringUtils.isEmpty2(mes)){
					is.setMes(mes);
				}
				if(!StringUtils.isEmpty2(name)){
					is.setName(name);
				}
				if(!StringUtils.isEmpty2(product)){
					is.setProduct(product);
				}
				if(!StringUtils.isEmpty2(address)){
					is.setAddress(address);
				}
//				
//				c. 注册资本要使用hasText()方法判断有没有值，并使用isNumber()判断是不是数字（3分）
				if(!StringUtils.isEmpty2(capital)){
					if(StringUtils.isNumber(capital)){
						is.setCapital(Double.parseDouble(capital));
					}else{
						System.out.println(id+"注册资本不是数字");
					}
				}else{
					System.out.println(id+"注册资本为空");
				}
//				d.年检日期为null，在前端必须显示为空，不能显示null（3分）
//				c. 成立时间要使用hasText()方法判断有没有值,判断是不是日期 idate
				if(!StringUtils.isEmpty2(idate)){
					if(StringUtils.isDate(idate)){
						is.setIdate(DateUtil.stringToDate(idate));
					}
				}
				
				//is.setStatus(status.equals("未年检")?Status.WAIT:status.equals("通过")?Status.SUCCESS:Status.NOTSUCCESS);
				
//				类型（3分）
//				   d.将集合对象中每个年检对象通过MyBatis保存到数据库。总共316
//				行，少一行扣2分，最多扣20分(6分)
				//System.out.println(is.getStatus().getName());
				bean.insert(is);
			}
	}
}
