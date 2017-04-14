package com.zmw.servlet;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result result = new Result();
		result.setResult(1);
		
		List<Person> persondata = new ArrayList<Person>();
		
		Person person1 = new Person();
		person1.setAge(12);
		person1.setName("zhuangmingwei");
		person1.setUrl("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=51553588,3796425299&fm=58");
		List<SchoolInfo> schoolInfos = new ArrayList<SchoolInfo>();
		SchoolInfo schoolInfo1 = new SchoolInfo();
		schoolInfo1.setShcoolName("希信");
		SchoolInfo schoolInfo2 = new SchoolInfo();
		schoolInfo2.setShcoolName("季延");
		schoolInfos.add(schoolInfo1);
		schoolInfos.add(schoolInfo2);
		person1.setList(schoolInfos);
		persondata.add(person1);
		
		
		Person person2 = new Person();
		person2.setAge(24);
		person2.setName("zhuangxiansheng");
		person2.setUrl("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1271528039,2031925530&fm=58");
		List<SchoolInfo> schoolinfo = new ArrayList<SchoolInfo>();
		SchoolInfo schoolInfo3 = new SchoolInfo();
		schoolInfo3.setShcoolName("子江");
		SchoolInfo schoolInfo4 = new SchoolInfo();
		schoolInfo4.setShcoolName("南理工");
		schoolinfo.add(schoolInfo3);
		schoolinfo.add(schoolInfo4);
		person2.setList(schoolinfo);
		persondata.add(person2);
		
		result.setList(persondata);
		Gson gson = new Gson();
		System.out.println(	gson.toJson(result));
	}

}
