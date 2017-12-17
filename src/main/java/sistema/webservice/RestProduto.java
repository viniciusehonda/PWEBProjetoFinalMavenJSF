package sistema.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import sistema.modelos.Produto;
import sistema.service.ProdutoService;

@Path("/produto")
public class RestProduto {
	
	   //Instalar o Chrome Advanced REST Client
	   //Para abrir: chrome://apps/  -> Escolha o ARC
       //Referencia: http://o7planning.org/en/11207/simple-crud-example-with-java-restful-web-service

       
	   //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/client/findById?id=9999
	   @GET
	   @Path("/findById")
	   @Produces(MediaType.APPLICATION_JSON)
       public Produto findById(@QueryParam("id") int id){
             ProdutoService service = new ProdutoService();
             return service.getUserById(id);
       }
	   

	   //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/client/save
	   @POST
	   @Path("/save")
	   @Produces(MediaType.APPLICATION_JSON)
       public Produto save(Produto produto){
             ProdutoService service = new ProdutoService();
             return service.salvar(produto);
       }
	   
	   
	  //Exemplo: http://localhost:8080/ProjetoWSRestJSON/rest/client/delete?id=99999
	   @DELETE
	   @Path("/delete")
	   @Produces(MediaType.APPLICATION_JSON)
       public void delete(@QueryParam("id") long id){
             ProdutoService service = new ProdutoService();
             service.delete(id);
       }
	   
	   //http://localhost:8080/ProjetoWSRestJSON/rest/user/client/all
	   @GET
	   @Path("/all")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Produto> getAllClients(){
		   List<Produto> produtos;
		   ProdutoService service = new ProdutoService();
		   produtos = service.getProdutos();
	       return produtos;
	   }
	   

	   //http://localhost:8080/ProjetoWSRestJSON/rest/user/update
	   @PUT
	   @Path("/update")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Produto update(Produto produto){
		   ProdutoService service = new ProdutoService();
		   produto = service.update(produto);
	       return produto;
	   }
	   
	   
 
}
