package cn.pacificy.ping;

import cn.pacificy.jdbc.utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

//import org.junit.Test;

/**
 * 开源连接池Druid的使用
 * @author pacificy
 *
 */
public class Jdbc {
//	@Test
	/**
	 * Druid的使用:
	 * * 配置方式设置参数
	 * Druid配置方式可以使用属性文件配置的。
	 * * 文件名称没有规定但是属性文件中的key要一定的。
	 */
	public List<String> getips(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> ips = new LinkedList<String>();
		try{
			// 使用连接池：
			// 从属性文件中获取：
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/druid2.properties"));
			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
			// 获得连接：
//			conn = JDBCUtils.getConnection();
			conn = dataSource.getConnection();
			// 编写SQL:
			String sql = "select * from appserver";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			// 执行SQL:
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("server_ip")+" "+rs.getString("server_status"));
			    ips.add(rs.getString("server_ip"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, pstmt, conn);
		}

		return ips;
	}

	public List<String> setips(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> ips = new LinkedList<String>();
		try{
			// 使用连接池：
			// 从属性文件中获取：
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/druid2.properties"));
			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
			// 获得连接：
//			conn = JDBCUtils.getConnection();
			conn = dataSource.getConnection();
			// 编写SQL:
			String sql = "select * from appserver";
			// 预编译SQL:
			pstmt = conn.prepareStatement(sql);
			// 设置参数:
			// 执行SQL:
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("server_ip")+" "+rs.getString("server_status"));
				ips.add(rs.getString("server_ip"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, pstmt, conn);
		}

		return ips;
	}
}
