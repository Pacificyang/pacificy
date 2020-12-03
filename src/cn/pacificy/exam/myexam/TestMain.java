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
 * ģ�����ݿ�ĵ��빦�ܣ����д���ʱ�����xml�ļ��е���Ϣ��д�뵽���ݿ��С�������Ҫ�����ӳأ�

������students.xml�ļ����������£�ѧԱ��Ҫ�Ķ�xml�����ݣ���
<?xml version="1.0" encoding="UTF-8"?>
<students>
	<student id="stu001">����</student>
	<student id="stu002">����</student>
	<student id="stu003">�����</student>
	<student id="stu004">����</student>
	<student id="stu005">������</student>
</students>

Ҫ��
1������һ���µ�java��Ŀ����Ŀ���ƣ������Լ����������֣������¼������

2�������ʵ���javabean���������ݿ� demo�������ʵ���student��
ͨ��jdbc����xml��ѧ����Ϣ��д��student���У���ȫ��ȷ50�֣���������֣�

3��ͨ��jdbc���ڿ���̨��ӡ�������ְ��������ѧԱ��id��������15�֣�

����ύ��
    1���������ݿ⡢���ݱ��sql�����ı��ļ�
    2���Լ���java�������Ŀ

��������ϸ��
1�����ݿ⡢���ݱ�Ĵ��� �� 20��
2��xml�ļ��Ĵ�����5��
3��javabean���룺10��

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
			
			//3��ͨ��jdbc���ڿ���̨��ӡ�������ְ��������ѧԱ��id��������15�֣�
			
			
			sql = "select * from student where name like '%��%'";
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
