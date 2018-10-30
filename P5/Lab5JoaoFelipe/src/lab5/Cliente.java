package lab5;

public class Cliente {
	
	private String cpf;
	private String nome;
	private String email;
	private String local;
	
	public Cliente(String cpf, String nome, String email, String local) {
		if(nome == null || "".equals(nome)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}else if(email == null || "".equals(email)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}else if(local == null || "".equals(local)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}else if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
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
