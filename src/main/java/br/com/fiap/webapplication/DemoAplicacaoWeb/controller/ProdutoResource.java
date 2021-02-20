package br.com.fiap.webapplication.DemoAplicacaoWeb.controller;


import br.com.fiap.webapplication.DemoAplicacaoWeb.model.Produto;
import br.com.fiap.webapplication.DemoAplicacaoWeb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoResource {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar(){return produtoRepository.findAll();}

    @GetMapping("{codigo}")
    public Produto buscar (@PathVariable int codigo){ return produtoRepository.findById(codigo).get(); }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto novo(@RequestBody Produto produto) { return produtoRepository.save(produto); }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Produto alterar(@RequestBody Produto produto,@PathVariable int id){
        produto.setCodigo(id);
        return produtoRepository.save(produto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{codigo}")
    public void deletar(@PathVariable int codigo){  produtoRepository.deleteById(codigo); }
}
