package cn.pacificy.exam;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 	模拟数据库的导入功能，运行代码时，会把xml文件中的信息，写入到数据库中。（不必要用连接池）
			有如下students.xml文件，内容如下（学员不要改动xml的内容）：
			<?xml version="1.0" encoding="UTF-8"?>
			<students>
				<student id="stu001">张三</student>
				<student id="stu002">李四</student>
				<student id="stu003">李大嘴</student>
				<student id="stu004">赵六</student>
				<student id="stu005">铁拐李</student>
			</students>
			要求：
			1、创建一个新的java项目，项目名称，就用自己的中文名字（方便记录分数）
			
			2、建立适当的javabean、创建数据库 demo，创建适当的student表。
			通过jdbc，把xml的学生信息，写入student表中（完全正确50分，按步骤算分）
			
			3、通过jdbc，在控制台打印出，名字包含“李”的学员的id、姓名（15分）
			
			答卷提交：
			    1、创建数据库、数据表的sql语句的文本文件
			    2、自己的java代码的项目
			其他评分细则：
			1、数据库、数据表的创建 ： 20分
			2、xml文件的创建：5分
			3、javabean代码：10分
		 */
		
		//读取xml
		List<Student> list = getDataFromXml();
		/*
		 * 去数据库中创建数据库和数据表。
		 */
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123");
		
		//插入数据
		insert2DB(list,conn);
		
		//查询数据
		selectData(conn);
		
		conn.close();
		
	}

	private static void selectData(Connection conn) throws SQLException {
		String sql2 = "select * from student where name like '%李%'";
		
		PreparedStatement pstat = conn.prepareStatement(sql2);
		
		ResultSet rs = pstat.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString("id") + ":" + rs.getString("name"));
		}
		
		rs.close();
		pstat.close();
	}

	private static void insert2DB(List<Student> list,Connection conn) throws SQLException {
		//获取连接
		
		String sql1 = "insert into student values(null,?,?)";
		
		PreparedStatement pstat = conn.prepareStatement(sql1);
		
		for (Student student : list) {
			pstat.setString(1, student.getId());
			pstat.setString(2, student.getName());
			pstat.executeUpdate();
		}
		
		pstat.close();
	}
	
	/*
	 * 读取xml文件中的信息，封装到javaBean中
	 */
	public static List<Student> getDataFromXml() throws Exception{
		ArrayList<Student> list = new ArrayList();
		
		SAXReader reader= new SAXReader();
		Document d = reader.read("students.xml");
		
		Element root = d.getRootElement();
		
		List<Element> studentsE = root.elements();
		
		for (Element sE : studentsE) {
			String id = sE.attributeValue("id");
			String name = sE.getText();
			
			Student s = new Student(id,name);
			list.add(s);
		}
		
		return list;
	}
}
