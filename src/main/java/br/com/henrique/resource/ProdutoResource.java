package br.com.henrique.resource;

import br.com.henrique.domain.Produto;
import br.com.henrique.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("{id}")
    public Optional<Produto> recuperarPorId(@PathVariable Long id){
        return produtoService.recuperarPorId(id);
    }

    @PostMapping
    public Produto salvar(@Valid @RequestBody  Produto produto){
        return produtoService.salvar(produto);
    }

    @PutMapping("{id}")
    public Produto atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto){
        return produtoService.atualizar(id,produto);
    }

    @DeleteMapping("{id}")
    public void apagar(@PathVariable Long id){
        produtoService.apagar(id);
    }
}
