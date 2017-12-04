package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Pedido;
import sistema.service.PedidoService;

@ManagedBean
@ViewScoped
public class PedidoManagedBean {
	private Pedido pedido = new Pedido();
	private List<Pedido> pedidos;
	private PedidoService service = new PedidoService();

	// Edição de um pedido na tabela
	public void onRowEdit(RowEditEvent event) {

		Pedido p = ((Pedido) event.getObject());
		service.alterar(p);
	}

	public void salvar() {
		pedido = service.salvar(pedido);

		if (pedidos != null)
			pedidos.add(pedido);

		pedido = new Pedido();

	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setAluno(Pedido pedido) {
		this.pedido = pedido;
	}

	// Retorna a lista de pedidos para a tabela
	public List<Pedido> getPedidos() {
		if (pedidos == null)
			pedidos = service.getPedidos();

		return pedidos;
	}

	public void remover(Pedido pedido) {
		service.remover(pedido);
		pedidos.remove(pedido);

	}

}
