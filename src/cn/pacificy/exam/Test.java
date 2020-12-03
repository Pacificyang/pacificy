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
		 	ģ�����ݿ�ĵ��빦�ܣ����д���ʱ�����xml�ļ��е���Ϣ��д�뵽���ݿ��С�������Ҫ�����ӳأ�
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
		
		//��ȡxml
		List<Student> list = getDataFromXml();
		/*
		 * ȥ���ݿ��д������ݿ�����ݱ�
		 */
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123");
		
		//��������
		insert2DB(list,conn);
		
		//��ѯ����
		selectData(conn);
		
		conn.close();
		
	}

	private static void selectData(Connection conn) throws SQLException {
		String sql2 = "select * from student where name like '%��%'";
		
		PreparedStatement pstat = conn.prepareStatement(sql2);
		
		ResultSet rs = pstat.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString("id") + ":" + rs.getString("name"));
		}
		
		rs.close();
		pstat.close();
	}

	private static void insert2DB(List<Student> list,Connection conn) throws SQLException {
		//��ȡ����
		
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
	 * ��ȡxml�ļ��е���Ϣ����װ��javaBean��
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
