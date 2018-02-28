package vn.edu.ctu.forum.models.untils;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author NTD
 */
public interface ConnectionPool {
    
//    trả về kết nối
    public Connection getConnectionPool()throws SQLException;
//    lấy lại kết nối đã kết nối trước đó   
    public void releaseConnection(Connection conn) throws SQLException;
//    làm mới lại kết nối
    public void refreshConnectionPool();


}
