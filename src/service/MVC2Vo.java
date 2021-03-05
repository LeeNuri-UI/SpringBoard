package service;  //MVC2 테이블의 가져올 값을 설정한다.


public class MVC2Vo {
	private int MVC2_num;
	private int user_MVC2num;
	private String MVC2_sub;
	private String MVC2_content;
	private String MVC2_file;
    private int MVC2_re_ref;
    private int MVC2_re_lev;
    private int MVC2_re_step;
    private String MVC2_date;
    private int MVC2_viewcount;
    private String delyn;
    private String html_ip;
    private String MVC2_writer;
    private String MVC2_catagory;

    public String getMVC2_catagory() {
		return MVC2_catagory;
	}
	public void setMVC2_catagory(String mVC2_catagory) {
		MVC2_catagory = mVC2_catagory;
	}
	// get 컬럼-> 얻어오고 return 보내겠다
    public int getMVC2_num() {
		return MVC2_num;
	}
	public void setMVC2_num(int mVC2_num) {
		MVC2_num = mVC2_num;
	}
	public int getUser_MVC2num() {
		return user_MVC2num;
	}
	public void setUser_MVC2num(int user_MVC2num) {
		this.user_MVC2num = user_MVC2num;
	}
	public String getMVC2_sub() {
		return MVC2_sub;
	}
	public void setMVC2_sub(String mVC2_sub) {
		MVC2_sub = mVC2_sub;
	}
	public String getMVC2_content() {
		return MVC2_content;
	}
	public void setMVC2_content(String mVC2_content) {
		MVC2_content = mVC2_content;
	}
	public String getMVC2_file() {
		return MVC2_file;
	}
	public void setMVC2_file(String mVC2_file) {
		MVC2_file = mVC2_file;
	}
	public int getMVC2_re_ref() {
		return MVC2_re_ref;
	}
	public void setMVC2_re_ref(int mVC2_re_ref) {
		MVC2_re_ref = mVC2_re_ref;
	}
	public int getMVC2_re_lev() {
		return MVC2_re_lev;
	}
	public void setMVC2_re_lev(int mVC2_re_lev) {
		MVC2_re_lev = mVC2_re_lev;
	}
	public int getMVC2_re_step() {
		return MVC2_re_step;
	}
	public void setMVC2_re_step(int mVC2_re_step) {
		MVC2_re_step = mVC2_re_step;
	}
	public String getMVC2_date() {
		return MVC2_date;
	}
	public void setMVC2_date(String mVC2_date) {
		MVC2_date = mVC2_date;
	}
	public int getMVC2_viewcount() {
		return MVC2_viewcount;
	}
	public void setMVC2_viewcount(int mVC2_viewcount) {
		MVC2_viewcount = mVC2_viewcount;
	}
	public String getDelyn() {
		return delyn;
	}
	public void setDelyn(String delyn) {
		this.delyn = delyn;
	}
	public String getHtml_ip() {
		return html_ip;
	}
	public void setHtml_ip(String html_ip) {
		this.html_ip = html_ip;
	}
	public String getMVC2_writer() {
		return MVC2_writer;
	}
	public void setMVC2_writer(String MVC2_writer) {
		this.MVC2_writer = MVC2_writer;
	}
	

}
