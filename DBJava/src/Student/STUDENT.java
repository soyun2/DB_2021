package Student;

public class STUDENT {
	public int studentno;
	private String name;
	private String phonenumber;
	private String city;
	private String department;	
	// 1 setter...
	// 2 생성자로...
	public STUDENT(int studentno,String name,String phonenumber, String city,String department){
		this.studentno = studentno;
		this.name = name;
		this.phonenumber = phonenumber;
		this.city = city;
		this.department = department;
	}
	public void print(){
		System.out.println("학생번호는 "+studentno+"입니다");
		System.out.println("이름은 "+name+"입니다");
		System.out.println("전화번호는 "+phonenumber+"입니다");
		System.out.println("고향은 "+city+"입니다");
		System.out.println("전공은 "+department+"입니다");
		System.out.println();
		System.out.println();
	}
}
