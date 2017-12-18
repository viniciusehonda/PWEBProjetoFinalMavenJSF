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
public class Vendedor implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	
	private String nome;
	private String endereco;
	private String telefone;
	
	@OneToMany(mappedBy="vendedor")
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	
	public Vendedor(long codigo, String nome, String endereco, String telefone) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public Vendedor() {
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
		Vendedor other = (Vendedor) obj;
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
		return "Vendedor [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}

	

	
	
	
	
}
