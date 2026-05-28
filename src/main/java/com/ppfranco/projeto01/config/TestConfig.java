package com.ppfranco.projeto01.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ppfranco.projeto01.entidades.Categoria;
import com.ppfranco.projeto01.entidades.ItemPedido;
import com.ppfranco.projeto01.entidades.Pagamento;
import com.ppfranco.projeto01.entidades.Pedido;
import com.ppfranco.projeto01.entidades.Produto;
import com.ppfranco.projeto01.entidades.User;
import com.ppfranco.projeto01.enuns.StatusPedido;
import com.ppfranco.projeto01.repositories.CategoriaRepositories;
import com.ppfranco.projeto01.repositories.ItemPedidoRepositories;
import com.ppfranco.projeto01.repositories.PedidoRepositories;
import com.ppfranco.projeto01.repositories.ProdutoRepositories;
import com.ppfranco.projeto01.repositories.UserRepositories;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepositories userRepositories;

	@Autowired
	private PedidoRepositories pedidoRepositories;

	@Autowired
	private CategoriaRepositories categoriarepositories;

	@Autowired
	private ProdutoRepositories produtoRepositories;
	
	@Autowired
	private ItemPedidoRepositories itemPedidoRepositories;

	@Override
	public void run(String... args) throws Exception {

	    Categoria cat1 = new Categoria(null, "Electronics");
	    Categoria cat2 = new Categoria(null, "Books");
	    Categoria cat3 = new Categoria(null, "Computers");
	    categoriarepositories.saveAll(Arrays.asList(cat1, cat2, cat3));

	    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	    User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	    userRepositories.saveAll(Arrays.asList(u1, u2));

	    Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, StatusPedido.PAGO);
	    Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, StatusPedido.AGUARDADNDO_PAGAMENTO);
	    Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, StatusPedido.AGUARDADNDO_PAGAMENTO);
	    pedidoRepositories.saveAll(Arrays.asList(o1, o2, o3));

	   
	    Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
	    Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
	    Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
	    Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
	    Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

	  
	    p1.getCategorias().add(cat2);
	    p2.getCategorias().add(cat1);
	    p2.getCategorias().add(cat3);
	    p3.getCategorias().add(cat3);
	    p4.getCategorias().add(cat3);
	    p5.getCategorias().add(cat2);

	    
	    produtoRepositories.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	    
	    ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getPreco()); 
	    ItemPedido oi2 = new ItemPedido(o1, p3, 1, p3.getPreco()); 
	    ItemPedido oi3 = new ItemPedido(o2, p3, 2, p3.getPreco()); 
	    ItemPedido oi4 = new ItemPedido(o3, p5, 2, p5.getPreco());
	    itemPedidoRepositories.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	    
	    Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
	    o1.setPagamento(pag1);
	    pedidoRepositories.save(o1);
	}
	}


