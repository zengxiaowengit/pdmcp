package hackathon;

import org.junit.Test;

import java.sql.*;

public class DbConn {
    /** 设置参数 **/
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    /** 构造方法，链接数据库 **/
    public DbConn() {
        try {
            System.out.println("正在连接数据库..........");
            Class.forName("com.mysql.jdbc.Driver");// 加载mysql驱动程序类
            String url = "jdbc:mysql://127.0.0.1:3307/pdmcp";// url为连接字符串
            String user = "root";// 数据库用户名
            String pwd = "admin";// 数据库密码
            conn = (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("数据库连接成功...........");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void main(String[] args) throws SQLException {
        DbConn a = new DbConn();// 实例化对象，作用是调用构造方法
        /** 查询语句 **/
        String sql = "select * from TBL_PDMCP_USR_INF";
        stmt = (Statement) conn.createStatement();
        stmt.execute(sql);// 执行select语句用executeQuery()方法，执行insert、update、delete语句用executeUpdate()方法。
        rs = (ResultSet) stmt.getResultSet();
        if(rs.last())
            System.out.println(rs.getRow());
        rs.close();// 后定义，先关闭
        stmt.close();
        conn.close();// 先定义，后关闭
    }
}