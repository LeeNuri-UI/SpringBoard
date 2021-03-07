package service;
//Dao(Data Access Object) : �����ͺ��̽� ���� ��ü�� ���� 
import java.sql.Connection; //SQL ����
import java.sql.PreparedStatement; //Statement�� �����ϱ� SQL�� �������ϴ� ����  
import java.sql.ResultSet; //ResultSet SELECT�� ����� �����ϴ� ��ü
import java.sql.SQLException; //����Ÿ���̽� �׼��� ���� �Ǵ� �� ���� ������ ���� ������ �����ϴ� �����Դϴ�
import java.util.ArrayList;

import dbconn.DBconn;

public class UserDao{
	
	//�ʵ带 ���� �Ӽ�����
	private Connection conn; //dbconn�� conn���� SQL ����̹� ���� �س��� �װ� �����ϰڴٰ�  
	PreparedStatement pstmt = null; //�̸� �غ��� ���� ����
	
	//ȸ������ ������
	public UserDao(){
		
		//������ ���̽��� �����Ų��
		DBconn conn = new DBconn();  //DBconn ��ü����
		this.conn = conn.getConnect();  //conn�� �����ϴ� �޼ҵ�ȣ��
	}
	
	public UserVo UserLogin(String user_id, String user_pwd) {
		
		// �޴� �� ����
		ResultSet rs = null; //executeQuery(String sql)�� ���� ���� �����ϸ� ResultSetŸ������ ��ȯ�� ���־� ������� ����	
		UserVo uv = null; //UserVo���� �޾ƿ��� �� uv�� ��µ� ���� ���� ���ٰ� ����
		
		try {
			String sql = "select * from user_if where user_id= ? and user_pwd= ?";					

			pstmt = conn.prepareStatement(sql); //
			pstmt.setString(1,user_id); 
			pstmt.setString(2,user_pwd);
			rs = pstmt.executeQuery(); //executeQuery�� rs�� ���� ��ȯ�Ѵ�.			
			
			if (rs.next()) {				
				uv = new UserVo(); // ��ü����		
				//UserVo�� ���� ����
				uv.setUser_num(rs.getInt("user_num"));		
				uv.setUser_id(rs.getString("user_id"));	
				uv.setUser_name(rs.getString("user_name"));	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		System.out.println("����?"+uv); 
		return uv;
	}
	
	/*public int User_IdCheck(String user_id) {
		int value= 0;
		ResultSet rs = null;
		
		String sql = "select count(*) as cnt from user_if where user_id= ? ";	//user_if�� user_id�� ���ڴٰ� ���� cnt�� ��Ƽ�				
		System.out.println("ID DAo �Է����Ǿ��°� Ȯ��");
		try {
			pstmt = conn.prepareStatement(sql); //sql �����ϴ� ��ü
			pstmt.setString(1, user_id); // �ԷµǴ� ���̵� ����
			rs = pstmt.executeQuery(); // sql���� select�� executeQuery()��  executeUpdate()�� update��  insert � �� 
			
			if (rs.next()) {
			value = rs.getInt("cnt");		
			}			
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
			
		return value;
	}*/
	
	public int UserInsert(String user_id, String user_pwd, String user_name, String user_e_mail, String user_e_mail2) {
		int value=0;
		
		System.out.println("UserDao���� Ȯ����");
		String sql="insert into user_if (user_num,user_id,user_pwd,user_name,user_e_mail,user_date,adminyn,delyn,user_e_mail2)"
				+ "values(user_num_seq.nextval,?,?,?,?,default,'N','N',?)";
				//user_date �κ��� defalt�� �־�� �˾Ƽ� ���Գ�¥�� �־���->table �ۼ��� sysdate�� ����. 
		
		try {
			pstmt = conn.prepareStatement(sql); // conn���� �����Ͽ� sql�� �����ϴ� ��ü�� PreparedStatement ����
			pstmt.setString(1,user_id); //�� ����(�ֱ�)
			pstmt.setString(2,user_pwd); 
			pstmt.setString(3,user_name); 
			pstmt.setString(4,user_e_mail);
			pstmt.setString(5,user_e_mail2);
			value = pstmt.executeUpdate(); //�����ϴ� �޼ҵ� insert�ϱ� executeUpdate() ��� select�� �Ƹ� executeQuery() �̰�?
			
			System.out.println("DAo �Է����Ǿ��°� Ȯ��");
			
		} catch (SQLException e) {
			
			e.printStackTrace(); //try ���н� catch�� �Ѿ�ͼ� �����޼��� ���
		}		
		return value;
	}
	
}
