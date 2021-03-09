package br.com.fiap.webapplication.DemoAplicacaoWeb.controller;

import br.com.fiap.webapplication.DemoAplicacaoWeb.model.Produto;
import br.com.fiap.webapplication.DemoAplicacaoWeb.repository.CategoriaRepository;
import br.com.fiap.webapplication.DemoAplicacaoWeb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository  categoriaRepository;

    @GetMapping("cadastrar")
    public String abrirFormulario(Produto produto, Model model){
        model.addAttribute("categorias",categoriaRepository.findAll());
        return "produto/form";
    }
    @PostMapping("cadastrar")
    public String processarFormulario(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "produto/form";
        }
        redirectAttributes.addFlashAttribute("msg", "Cadastrado");
        produtoRepository.save(produto);
        return "redirect:listar";
    }

    @GetMapping("listar")
    public String listarProdutos(Model model){
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produto/lista";
    }
    @GetMapping("editar/{id}")
    public String editarProduto(@PathVariable int codigo, Model model){
        model.addAttribute("produto", produtoRepository.findById(codigo));
        return "produto/form";

    }
    @PostMapping("excluir")
    public String excluirProduto(@PathVariable int codigo,RedirectAttributes redirectAttributes, Model model){
        redirectAttributes.addFlashAttribute("msg","Removido!");
        produtoRepository.deleteById(codigo);
        return "redirect:listar";
    }


}
