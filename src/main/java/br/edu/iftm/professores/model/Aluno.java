package br.edu.iftm.professores.model;

<<<<<<< HEAD
public class Aluno implements java.io.Serializable {

	private Integer ID;
	private String nome;
	private String cpf;
	private String email;

	public Aluno(){
		
	}
	public Aluno(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}
	
=======
public class Aluno {
    private String nome, email, cpf;
    private Integer id;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "{" +
                " nome='" + getNome() + "'" +
                ", email='" + getEmail() + "'" +
                ", cpf='" + getCpf() + "'" +
                "}";
    }

>>>>>>> 9475e3244daa4cd37cc9654d70683699ae4acaf0
}
