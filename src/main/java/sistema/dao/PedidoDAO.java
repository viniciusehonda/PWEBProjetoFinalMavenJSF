package sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import sistema.dao.generic.DAOImpl;
import sistema.modelos.Pedido;
import sistema.modelos.Produto;

public class PedidoDAO  extends DAOImpl<Pedido, Integer>{
	
	public List<Produto> getProdutosPedidos(Pedido pedidoSelecionado) {
		
		List<Produto> produtos = null;
		EntityManager em = getEntityManager();
		Pedido r = em.find(Pedido.class, pedidoSelecionado.getId());
		em.refresh(r);
		produtos = r.getProdutos();
		em.close();

		return produtos;
	}
}
