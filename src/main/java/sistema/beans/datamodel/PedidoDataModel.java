package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Pedido;
import sistema.service.PedidoService;


public class PedidoDataModel extends ListDataModel<Pedido> implements SelectableDataModel<Pedido> 
{
	private PedidoService servico = new PedidoService();
	
	public PedidoDataModel()
	{
		
	}

	public PedidoDataModel(List <Pedido> list)
	{
	   super(list);	
	}

	
	@Override
	public Pedido getRowData(String rowKey) {
		
		for(Pedido p: servico.getPedidos())
		   if(Integer.parseInt(rowKey) ==  p.getCodigo())
			   return servico.pesquisar(p);
		
		return null;
	}

	@Override
	public Object getRowKey(Pedido pedido) {
		return pedido.getCodigo();
	}
	
}