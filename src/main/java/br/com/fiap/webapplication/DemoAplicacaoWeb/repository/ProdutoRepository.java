package br.com.fiap.webapplication.DemoAplicacaoWeb.repository;

import br.com.fiap.webapplication.DemoAplicacaoWeb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    List<Produto> findByNome(String nome);
    List<Produto> findByNovo(boolean novo);
    List<Produto> findByNomeAndNovo(String prod,boolean novo);
    List<Produto> findByPrecoGreaterThan(double preco);
}
