package arqproject.obj;

public class UsersObj {
	
	private String id;
	private String nome;
	private String email;
	private String pass;
	
	
	public UsersObj (){}
	
	public UsersObj(String id, String nome, String email){
		setId(id);
		setNome(nome);
		setEmail(email);
	}
	
	public UsersObj(String id, String nome, String email, String pass){
		setId(id);
		setNome(nome);
		setEmail(email);
		setPass(pass);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	

}
