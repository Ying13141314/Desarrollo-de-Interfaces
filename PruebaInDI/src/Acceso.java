
public class Acceso {

	//Estado
	
	String user;
	String passw;
	
	
	//Constructor
	public Acceso(String user,String passw){
		this.user = user;
		this.passw = passw;
	}


	
	
	//Comportamiento
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassw() {
		return passw;
	}


	public void setPassw(String passw) {
		this.passw = passw;
	}
	
	
	
}
