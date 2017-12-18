package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;

import sistema.modelos.Cliente;
import sistema.modelos.Pedido;
import sistema.modelos.Produto;
import sistema.modelos.Vendedor;
import sistema.service.ClienteService;
import sistema.service.PedidoService;
import sistema.service.ProdutoService;
import sistema.service.VendedorService;

@ManagedBean
@ViewScoped
public class PedidoManagedBean {
	private Pedido pedido = new Pedido();
	private Pedido pedidoSelecionado;
	private List<Pedido> pedidos;
	private PedidoService service = new PedidoService();
	private Cliente cliente;
	private ClienteService clienteService = new ClienteService();
	private Vendedor vendedor;
	private VendedorService vendedorService = new VendedorService();
	private DualListModel<Produto> dualList = new DualListModel<Produto>();
	private ProdutoService produtoService = new ProdutoService();
	
	public void addProdutoToPedido(Pedido pedido)
	{
		pedidoSelecionado = pedido;  
		  
	}
	
	public void associar()
	{
		for(Produto p : dualList.getSource())
	 	{   
	       	p.getPedidos().remove(pedidoSelecionado);
	 	}
	 
	 	for(Produto p : dualList.getTarget())
	 	{   
		 	p.getPedidos().add(pedidoSelecionado);
	 	}
	 
	 	pedidoSelecionado.getProdutos().clear();
	 	pedidoSelecionado.getProdutos().addAll(dualList.getTarget());
	 	service.alterar(pedidoSelecionado);
	 
	 	pedidoSelecionado.getProdutos().clear();
	 	pedidoSelecionado.getProdutos().clear();	   
	}
	
	// Edição de um pedido na tabela
	public void onRowEdit(RowEditEvent event) {

		Pedido p = ((Pedido) event.getObject());
		service.alterar(p);
	}

	public void salvar() {
		cliente.addPedido(pedido);
		pedido.setCliente(cliente);
		
		vendedor.addPedido(pedido);
		pedido.setVendedor(vendedor);
		
		pedido = service.salvar(pedido);

		if (pedidos != null)
			pedidos.add(pedido);

		pedido = new Pedido();
		
		cliente = null;
		vendedor = null;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getClientes() {
		return clienteService.getClientes();
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public List<Vendedor> getVendedores() {
		return vendedorService.getVendedores();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	// Retorna a lista de pedidos para a tabela
	public List<Pedido> getPedidos() {
		if (pedidos == null)
			pedidos = service.getPedidos();

		return pedidos;
	}
	
	public List<Produto> getProdutosPedido() {
		if (pedidoSelecionado != null) {
			return service.pesquisarProdutosPedido(pedidoSelecionado);
		} else
			return null;
	}
	
	public DualListModel<Produto> getProdutos()
	{
		   
	   List <Produto> source  = new ArrayList<Produto>();
	   List <Produto> target  =  new ArrayList<Produto>();
	   
	   source.addAll(produtoService.getProdutos());
	
	   if(pedidoSelecionado != null)
	   {
		   target.addAll(pedidoSelecionado.getProdutos());
		   source.removeAll(pedidoSelecionado.getProdutos());
	   }
	   
	   dualList.setSource(source);
	   dualList.setTarget(target);
	   
	   return dualList;
	   
	}
	
	public void setProdutos(DualListModel<Produto> produtos)
	  {
		  this.dualList = produtos;
		  
	  }
	
	public void remove(Pedido pedido) {
		service.remover(pedido);
		pedidos.remove(pedido);

	}

	public Pedido getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	public void setPedidoSelecionado(Pedido pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}
}
