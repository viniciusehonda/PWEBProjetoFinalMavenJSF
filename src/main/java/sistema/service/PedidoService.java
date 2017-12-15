package sistema.service;

import java.util.List;

import sistema.dao.PedidoDAO;
import sistema.modelos.Pedido;
import sistema.modelos.Produto;

public class PedidoService {
PedidoDAO pedidoDAO = new PedidoDAO();
 	
	public List<Produto> getProdutosPedido(Pedido pedidoSelecionado) {
		List <Produto> list = pedidoDAO.getProdutosPedidos(pedidoSelecionado);
		pedidoDAO.closeEntityManager();
		return list;
	}
	
	public Pedido salvar(Pedido pedido)
	{
		pedido = pedidoDAO.save(pedido);
		pedidoDAO.closeEntityManager();
		return pedido;
		
	}
	
	public List <Pedido> getPedidos()
	{
		List <Pedido> list = pedidoDAO.getAll(Pedido.class);
		pedidoDAO.closeEntityManager();
		return list;
	}

	public void alterar(Pedido pedido) {
		pedidoDAO.save(pedido);
		pedidoDAO.closeEntityManager();
	}

	
	public void remover(Pedido pedido) {
		
		pedido = pedidoDAO.getById(Pedido.class, pedido.getId());
		pedidoDAO.remove(pedido);
		pedidoDAO.closeEntityManager();
	}
	public List<Produto> pesquisarProdutosPedido(Pedido pedido) {

		List<Produto> produtos;
		pedido = pedidoDAO.getById(Pedido.class, pedido.getId());
		produtos = pedido.getProdutos();
		return produtos;
	}
	public Pedido pesquisar(Pedido pedido) {

		pedido = pedidoDAO.getById(Pedido.class, pedido.getId());
		pedidoDAO.closeEntityManager();
		return pedido;
	}
}