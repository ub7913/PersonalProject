package Res;

public class ResVO {
	Integer no;
	String title;
	String content;
	String name;
	String tel;
	String address;
	String regdate;
	Integer first;
	Integer last;
	
	
	
	public ResVO(Integer no, String title, String content, String name, String tel, String address, String regdate,
			Integer first, Integer last) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.regdate = regdate;
		this.first = first;
		this.last = last;
	}

	public ResVO() { }
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}
	
	
	
}
