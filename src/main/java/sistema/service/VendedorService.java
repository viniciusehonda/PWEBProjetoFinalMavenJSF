package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.VendedorDAO;
import sistema.modelos.Cliente;
import sistema.modelos.Vendedor;
import sistema.modelos.Produto;

public class VendedorService {

	private VendedorDAO vendedorDAO = new VendedorDAO();

	public Vendedor salvar(Vendedor vendedor) {

		vendedor = vendedorDAO.save(vendedor);
		vendedorDAO.closeEntityManager();
		return vendedor;
	}

	public List<Vendedor> getVendedores() {
		List<Vendedor> list = vendedorDAO.getAll(Vendedor.class);
		vendedorDAO.closeEntityManager();
		return list;
	}

	public void alterar(Vendedor vendedor) {

		vendedorDAO.save(vendedor);
		vendedorDAO.closeEntityManager();

	}

	public void remover(Vendedor vendedor) {

		vendedor = vendedorDAO.getById(Vendedor.class, vendedor.getCodigo());
		vendedorDAO.remove(vendedor);
		vendedorDAO.closeEntityManager();
	}

	public Vendedor pesquisar(Vendedor vendedor) {

		vendedor = vendedorDAO.getById(Vendedor.class, vendedor.getCodigo());
		vendedorDAO.closeEntityManager();
		return vendedor;
	}

	public List<Produto> pesquisarProdutosVendedor(Vendedor vendedor) {

		List<Produto> produtos;
		vendedor = vendedorDAO.getById(Vendedor.class, vendedor.getCodigo());
		produtos = vendedor.getProdutos();
		return produtos;
	}

	

}
