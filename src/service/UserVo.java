package service; //user_if 테이블의 가져올 값을 설정한다.

public class UserVo {
	
	//필드값
	private int user_num;
	private String user_id; 
	private String user_pwd; 
	private String user_name;  
	private String user_e_mail; 
	private String user_date; 
	private String adminyn; 
	private String delyn;
	private String user_e_mail2;
	
	
	// get 컬럼-> 얻어오고 return 보내겠다고 만든 컬럼들
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getUser_e_mail() {
		return user_e_mail;
	}
	public void setUser_e_mail(String user_e_mail) {
		this.user_e_mail = user_e_mail;
	}
	public String getUser_date() {
		return user_date;
	}
	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	public String getAdminyn() {
		return adminyn;
	}
	public void setAdminyn(String adminyn) {
		this.adminyn = adminyn;
	}
	public String getDelyn() {
		return delyn;
	}
	public void setDelyn(String delyn) {
		this.delyn = delyn;
	}
	public String getUser_e_mail2() {
		return user_e_mail2;
	}
	public void setUser_e_mail2(String user_e_mail2) {
		this.user_e_mail2 = user_e_mail2;
	}
}
