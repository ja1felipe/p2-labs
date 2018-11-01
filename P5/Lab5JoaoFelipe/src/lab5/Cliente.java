package lab5;

/**
 * Representacao de um cliente.
 * @author Joao Felipe da Silva Freitas.
 *
 */
public class Cliente {
	
	private String cpf;
	private String nome;
	private String email;
	private String local;
	
	/**
	 * Constroi um Cliente apatir do cpf, nome, email e local.
	 * @param cpf cpf do cliente.
	 * @param nome nome do cliente.
	 * @param email email do cliente.
	 * @param local localizacao do cliente.
	 */
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

	/**
	 * Seta um nome para o cliente.
	 * @param nome nome do cliente.
	 */
	public void setNome(String nome) {
		if(nome == null || "".equals(nome)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		this.nome = nome;
	}

	/**
	 * Seta um email para o cliente.
	 * @param email email do cliente.
	 */
	public void setEmail(String email) {
		if(email == null || "".equals(email)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		this.email = email;
	}

	/**
	 * Seta um local para o cliente.
	 * @param local local do cliente.
	 */
	public void setLocal(String local) {
		if(local == null || "".equals(local)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
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
