package br.com.henrique.resource;

import br.com.henrique.domain.Produto;
import br.com.henrique.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> recuperar(){
        return produtoService.recuperar();
    }

    @PostMapping
    public Produto salvar(@Valid @RequestBody  Produto produto){
        return produtoService.salvar(produto);
    }

}
