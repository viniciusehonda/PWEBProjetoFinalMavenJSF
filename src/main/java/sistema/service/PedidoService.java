package sistema.service;

import java.util.List;

import sistema.dao.PedidoDAO;
import sistema.modelos.Pedido;

public class PedidoService {
PedidoDAO pedidoDAO = new PedidoDAO();
 	
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
}
