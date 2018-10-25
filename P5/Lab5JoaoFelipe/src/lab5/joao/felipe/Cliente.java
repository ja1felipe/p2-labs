package lab5.joao.felipe;

public class Cliente {
	
	private String cpf;
	private String nome;
	private String email;
	private String local;
	
	public Cliente(String cpf, String nome, String email, String local) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.local = local;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	public String toString() {
		String msg = this.nome + " - " + this.local + " - " + this.email;
		return msg;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}
