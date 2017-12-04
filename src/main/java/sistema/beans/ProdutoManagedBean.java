package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Cliente;
import sistema.modelos.Vendedor;
import sistema.modelos.Produto;
import sistema.service.VendedorService;
import sistema.service.ProdutoService;

@ManagedBean(name = "produtoManagedBean")
@ViewScoped
public class ProdutoManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	private Vendedor vendedor;
	private ProdutoService prodService = new ProdutoService();
	private VendedorService vendService = new VendedorService();
	private List<Produto> produtos;

	public void salvar() {
		vendedor.addProduto(produto);
		produto.setVendedor(vendedor);

		produto = prodService.salvar(produto);

		if (produtos != null)
			produtos.add(produto);

		produto = new Produto();
		vendedor = null;

	}

	public List<Vendedor> getVendedores() {
		return vendService.getVendedores();

	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void remove(Produto produto) {
		prodService.remover(produto);
		produtos.remove(produto);
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (produtos == null)
			produtos = prodService.getProdutos();

		return produtos;
	}

	public void onRowEdit(RowEditEvent event) {

		Produto p = ((Produto) event.getObject());
		prodService.alterar(p);
	}

}
