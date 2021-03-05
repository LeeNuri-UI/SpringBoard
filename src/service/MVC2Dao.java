package service;
//Dao(Data Access Object) : �����ͺ��̽� ���� ��ü�� ���� 
import java.sql.Connection; //SQL ����
import java.sql.PreparedStatement; //Statement�� �����ϱ� SQL�� �������ϴ� ����  
import java.sql.ResultSet; //ResultSet SELECT�� ����� �����ϴ� ��ü
import java.sql.SQLException; //����Ÿ���̽� �׼��� ���� �Ǵ� �� ���� ������ ���� ������ �����ϴ� �����Դϴ�
import java.util.ArrayList;

import dbconn.DBconn;
import domain.SearchCriteria;


public class MVC2Dao {
	
	//�ʵ带 ���� �Ӽ�����
		private Connection conn; //dbconn�� conn���� SQL ����̹� ���� �س��� �װ� �����ϰڴٰ�  
		PreparedStatement pstmt = null; //�̸� �غ��� ���� ����
		
		//ȸ������ ������
		public MVC2Dao(){
			//������ ���̽��� �����Ų��
			DBconn conn = new DBconn();  //DBconn ��ü����
			this.conn = conn.getConnect();  //�����ϴ� �޼ҵ�ȣ��
		}
		
		//�۾��� �׼�
		public int MVC2Isert(String MVC2cate, String MVC2sub,String MVC2content, String user_name, int user_num, String html_ip) {
			
			int value=0;
			
			System.out.println("MVC2Dao���� Ȯ����");
			String sql="insert into MVC2 (MVC2_num,user_num,MVC2_sub,MVC2_content,MVC2_file,MVC2_re_ref,MVC2_re_lev,MVC2_re_step,MVC2_date,MVC2_viewcount,delyn,html_ip,MVC2_writer,MVC2_catagory)"
					+ "values(MVC2_num_seq.nextval,?,?,?,0,0,0,0,default,0,'N',?,?,?)";
					//user_date �κ��� default�� �־�� �˾Ƽ� ���Գ�¥�� �־���->table �ۼ��� sysdate�� ����. 
			
			try {
				pstmt = conn.prepareStatement(sql); // conn���� �����Ͽ� sql�� �����ϴ� ��ü�� PreparedStatement �޼ҵ�ȣ�� 
				pstmt.setInt(1,user_num); //�� ����(�ֱ�)
				pstmt.setString(2,MVC2sub); 
				pstmt.setString(3,MVC2content); 
				pstmt.setString(4,html_ip);
				pstmt.setString(5,user_name);
				pstmt.setString(6,MVC2cate);
				
				System.out.println("DAo �Է����Ǿ��°� Ȯ��");
				
				value = pstmt.executeUpdate(); //�����ϴ� �޼ҵ� insert�ϱ� executeUpdate() ��� select�� �Ƹ� executeQuery() �̰�?
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace(); //try ���н� catch�� �Ѿ�ͼ� �����޼��� ���
			}		
			return value;
		}
		
		public ArrayList<MVC2Vo> boardSelectAll(SearchCriteria scri, String MVC2_catagory) {
			//�Խñ� ����Ʈ �ҷ�����
			ArrayList<MVC2Vo> alist = new ArrayList<MVC2Vo>();
			ResultSet rs = null;
			
			String sql = "select * from MVC2 "
					+ "where delyn='N' "
					+ "order by MVC2_num desc, MVC2_re_step asc";
			try {
				//������ �����Ͽ� pstmt�� ��� ������ ���� �� rs�� ����
				
				pstmt = conn.prepareStatement(sql);
			
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					MVC2Vo bv = new MVC2Vo();
					
					System.out.println("0.2");
					bv.setMVC2_num(rs.getInt("MVC2_num"));
					bv.setMVC2_catagory(rs.getString("MVC2_catagory"));
					bv.setMVC2_writer(rs.getString("MVC2_writer"));
					bv.setMVC2_sub(rs.getString("MVC2_sub"));
					bv.setMVC2_date(rs.getString("MVC2_date"));
					bv.setMVC2_viewcount(rs.getInt("MVC2_viewcount"));
					
					System.out.println("0.3");
					alist.add(bv);
					System.out.println("0.4");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return alist;
		}
		
		public int boardTotal(String keyword) {
			//�Խñ� ��ü ����
			ResultSet rs = null;
			int cnt = 0;
			
			String sql = "select count(*) as cnt from MVC2 where delyn='N' and MVC2_sub like ?";
			
			try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+keyword+"%");
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						cnt = rs.getInt("cnt");
					}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return cnt;
		}
		
		
		public MVC2Vo HtmlView(int MVC2_num){
			
			ResultSet rs = null; //�޼ҵ��� ���� ���� �� select ������ ����
			MVC2Vo MVC2v = null; // MVC2Vo �޾ƿ� �⺻ �� ����
			
			String sql = "select * from MVC2 where delyn='N' and MVC2_num=?";
			
			try {
				pstmt = conn.prepareStatement(sql); // sql���� �������ִ� �޼ҵ� ����
				pstmt.setInt(1, MVC2_num); //�Ű������� ������
				rs = pstmt.executeQuery(); // ResultSet rs = null;�� �����ض�
				
				if(rs.next()) {
					MVC2v = new MVC2Vo(); //MVC2Vo �� ���� ��ü����
					
					//MVC2Vo����  �޾ƿ� ���� rs�� ��ڴ�.
					MVC2v.setMVC2_writer(rs.getString("MVC2_writer"));
					MVC2v.setMVC2_sub(rs.getString("MVC2_sub"));
					MVC2v.setMVC2_content(rs.getString("MVC2_content"));
					MVC2v.setMVC2_file(rs.getString("MVC2_file"));
					MVC2v.setMVC2_re_ref(rs.getInt("MVC2_re_ref"));
					MVC2v.setMVC2_re_lev(rs.getInt("MVC2_re_lev"));
					MVC2v.setMVC2_re_step(rs.getInt("MVC2_re_step"));
					MVC2v.setMVC2_date(rs.getString("MVC2_date"));			
				
				}
			
			}catch (SQLException e){
					e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				//5.MVC2v�� ����
			return MVC2v;
		}
				
}
