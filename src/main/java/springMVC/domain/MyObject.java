package springMVC.domain;

public class MyObject {
	private Long id;
	private String name;
	//for jackson 严格按照set，get格式
	public MyObject() {
		super();
	}
	public MyObject(Long id,String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
