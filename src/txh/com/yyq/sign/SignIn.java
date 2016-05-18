package txh.com.yyq.sign;


public class SignIn {
	String name;
	String passwd;

	public String getName() {
		System.out.println("name:" + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		System.out.println("passwd:" + passwd);
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public static void main(String args[]) {
		SignIn sign = new SignIn();
		sign.setName("imopan507");
		sign.setPasswd("123456");
		sign.getName();
		sign.getPasswd();

	}

}
