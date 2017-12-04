package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.ClienteDAO;
import sistema.modelos.Cliente;


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
		
		cliente = clienteDAO.getById(Cliente.class, cliente.getId());
		clienteDAO.remove(cliente);
		clienteDAO.closeEntityManager();
	}
	
}
