package sistema.service;


import java.util.List;

import sistema.dao.ClienteDAO;
import sistema.modelos.Cliente;
import sistema.modelos.Pedido;


public class ClienteService {

 	ClienteDAO clienteDAO = new ClienteDAO();
 	
	public Cliente salvar(Cliente cliente)
	{
		cliente = clienteDAO.save(cliente);
		clienteDAO.closeEntityManager();
		return cliente;
		
	}
	
	public List <Cliente> getClientes()
	{
		List <Cliente> list = clienteDAO.getAll(Cliente.class);
		clienteDAO.closeEntityManager();
		return list;
	}

	public void alterar(Cliente cliente) {
		clienteDAO.save(cliente);
		clienteDAO.closeEntityManager();
	}

	
	public void remover(Cliente cliente) {
		
		cliente = clienteDAO.getById(Cliente.class, cliente.getCodigo());
		clienteDAO.remove(cliente);
		clienteDAO.closeEntityManager();
	}
	public Cliente pesquisar(Cliente cliente) {

		cliente = clienteDAO.getById(Cliente.class, cliente.getCodigo());
		clienteDAO.closeEntityManager();
		return cliente;
	}
	
	public List<Pedido> pesquisarPedidosCliente(Cliente cliente) {

		List<Pedido> pedidos;
		cliente = clienteDAO.getById(Cliente.class, cliente.getCodigo());
		pedidos = cliente.getPedidos();
		return pedidos;
	}
}
