package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:file:C:/data/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Mutter> findAll(){
		Connection conn = null;
		List<Mutter> mutterList = new ArrayList<Mutter>();
		try{
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			//SELECT文の準備
			String sql = "select id, name, text from mutter order by id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()){
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return mutterList;
	}

	public boolean create (Mutter mutter){
		Connection conn = null;
		try{
			//データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			//INSERT文の準備(idは自動連番なので指定しなくてもよい)
			String sql = "insert into  mutter (name, text) values(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2,  mutter.getText());

			//INSERT文を実行
			int result = pStmt.executeUpdate();

			if(result != 1){
				return false;
			}
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally {
			//データベース切断
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
