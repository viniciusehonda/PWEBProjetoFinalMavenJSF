package sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import sistema.dao.generic.DAOImpl;
import sistema.modelos.Pedido;
import sistema.modelos.Produto;

public class PedidoDAO  extends DAOImpl<Pedido, Long>{
	
	public List<Produto> getProdutosPedidos(Pedido pedidoSelecionado) {
		
		List<Produto> produtos = null;
		EntityManager em = getEntityManager();
		Pedido r = em.find(Pedido.class, pedidoSelecionado.getCodigo());
		em.refresh(r);
		produtos = r.getProdutos();
		em.close();

		return produtos;
	}
}
