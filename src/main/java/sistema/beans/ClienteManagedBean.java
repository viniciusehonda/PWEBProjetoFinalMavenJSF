package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Cliente;
import sistema.modelos.Pedido;
import sistema.service.ClienteService;

@ManagedBean
@ViewScoped
public class ClienteManagedBean {

	private Cliente cliente = new Cliente();
	private Cliente clienteSelecionado;
	private List<Cliente> clientes;
	private ClienteService service = new ClienteService();

	// Edição de um cliente na tabela
	
	public void onRowEdit(RowEditEvent event) {

		Cliente c = ((Cliente) event.getObject());
		service.alterar(c);
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public void salvar() {
		cliente = service.salvar(cliente);

		if (clientes != null)
			clientes.add(cliente);

		cliente = new Cliente();

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setAluno(Cliente cliente) {
		this.cliente = cliente;
	}

	// Retorna a lista de clientes para a tabela
	public List<Cliente> getClientes() {
		if (clientes == null)
			clientes = service.getClientes();

		return clientes;
	}

	public void remover(Cliente cliente) {
		service.remover(cliente);
		clientes.remove(cliente);

	}
	
	public List<Pedido> getPedidosCliente() {
		if (clienteSelecionado != null) {
			return service.pesquisarPedidosCliente(clienteSelecionado);
		} else
			return null;
	}
}
