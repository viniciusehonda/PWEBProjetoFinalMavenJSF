package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	
	private String nome;
	private String endereco;
	private String cpf_cnpj;
	private String telefone;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Cliente(long codigo, String nome, String endereco, String cpf_cnpj, String telefone) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf_cnpj = cpf_cnpj;
		this.telefone = telefone;
	}
	
	public Cliente() {
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public void addPedido(Pedido pedido)	{
		pedidos.add(pedido);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		//long temp;
		//temp = Double.doubleToLongBits(valor);
		//result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		//if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			//return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cpf_cnpj=" + cpf_cnpj + ", telefone=" + telefone + "]";
	}
	
	
	
	
	

}
