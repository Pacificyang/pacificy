package cn.pacificy.jdbc.datasource.demo0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

//import org.junit.Test;

import cn.pacificy.jdbc.utils.JDBCUtils;

/**
 * 自定义连接池的测试类
 * @author jt
 *
 */
public class DataSourceDemo {

//	@Test
	/**
	 * 测试自定义连接池
	 */
	public void demo1(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DataSource dataSource = null;
		try{
			// 获得连接:
			// conn = JDBCUtils.getConnection();
			// 从连接池中获得连接：
			dataSource = new cn.pacificy.jdbc.datasource.demo0.MyDataSource();
			conn = dataSource.getConnection();
			// 编写SQL：
			String sql = "select * from account";
			// 预编译SQL：
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			// 执行SQL:
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("money"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, pstmt, conn);
			// 归还连接：
			// dataSource.addBack(conn);
		}
	}
}
