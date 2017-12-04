package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import org.primefaces.event.RowEditEvent;
import sistema.beans.datamodel.VendedorDataModel;
import sistema.modelos.Vendedor;
import sistema.modelos.Produto;
import sistema.service.VendedorService;

@ManagedBean
@ViewScoped
public class VendedorManagedBean {

	private Vendedor vendedor = new Vendedor();
	private Vendedor vendedorSelecionado;
	private VendedorService servico = new VendedorService();
	private List<Vendedor> vendedores;

	/**
	 * @return the vendedorSelecionado
	 */
	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	/**
	 * @param vendedorSelecionado
	 *            the vendedorSelecionado to set
	 */
	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = servico.pesquisar(vendedorSelecionado);
	}

	public void salvar() {
		vendedor = servico.salvar(vendedor);

		if (vendedores != null)
			vendedores.add(vendedor);

		vendedor = new Vendedor();

	}

	public DataModel<Vendedor> getVendedores() {
		if (vendedores == null)
			vendedores = servico.getVendedores();

		return new VendedorDataModel(vendedores);
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void remove(Vendedor vendedor) {
		if (servico.pesquisarProdutosVendedor(vendedor).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover vendedor",
					"Vendedor possui produtos!"));
		} else {
			servico.remover(vendedor);
			vendedores.remove(vendedor);
		}
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<Produto> getProdutosVendedor() {
		if (vendedorSelecionado != null) {
			return servico.pesquisarProdutosVendedor(vendedorSelecionado);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {

		Vendedor v = ((Vendedor) event.getObject());
		servico.alterar(v);
	}

}
