package br.com.fiap.webapplication.DemoAplicacaoWeb.repository;

import br.com.fiap.webapplication.DemoAplicacaoWeb.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaRepository  extends JpaRepository<Categoria,Integer> {
    List<Categoria> findByNome(String nome);
}
