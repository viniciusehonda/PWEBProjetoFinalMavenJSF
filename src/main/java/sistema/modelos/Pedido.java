package sistema.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String dataEmissaoPedido;
	private String dataPagto;
	private boolean status;
	
	@ManyToMany(mappedBy="pedidos")
	private List<Produto> produtos = new ArrayList<Produto>();
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Vendedor vendedor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataEmissaoPedido() {
		return dataEmissaoPedido;
	}
	public void setDataEmissaoPedido(String dataEmissaoPedido) {
		this.dataEmissaoPedido = dataEmissaoPedido;
	}
	public String getDataPagto() {
		return dataPagto;
	}
	public void setDataPagto(String dataPagto) {
		this.dataPagto = dataPagto;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public void addProduto(Produto produto)	{
		produtos.add(produto);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cliente=" + cliente + ", vendedor=" + vendedor + "]";
	}
}
