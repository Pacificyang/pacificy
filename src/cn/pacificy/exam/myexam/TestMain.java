package cn.pacificy.exam.myexam;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;



/*
 * 模拟数据库的导入功能，运行代码时，会把xml文件中的信息，写入到数据库中。（不必要用连接池）

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

public class TestMain {
	public static void main(String[] args) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document doc = reader.read("src/com/test/students.xml");
		
		ArrayList<Student> sList = new ArrayList<Student>();

		
        Element root = doc.getRootElement();		
		List<Element> elist = root.elements();
		for (Element e : elist) {
			Student s = new Student(e.attributeValue("id"),e.getText());
			sList.add(s);
		}
		//System.out.println(sList);
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123");
			
			
			String sql = "insert into student values (null,?,?)";
			pstmt = conn.prepareStatement(sql);

			for (Student s : sList) {
				pstmt.setString(1,s.getId());
				pstmt.setString(2,s.getName());
				pstmt.executeUpdate();
			}
			
			//3、通过jdbc，在控制台打印出，名字包含“李”的学员的id、姓名（15分）
			
			
			sql = "select * from student where name like '%李%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("id")+" "+rs.getString("name"));
			}


		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				pstmt = null;
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				conn = null;
			}
		}

		
		
	}

}
