package br.com.henrique.resource;

import br.com.henrique.domain.Produto;
import br.com.henrique.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("all")
    public List<Produto> recuperarAll(){
        return produtoService.recuperarAll();
    }

    @GetMapping
    public Page<Produto> recuperar(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "5") int size,
                                   @RequestParam(value = "nome", defaultValue = "") String nome){
        return produtoService.recuperar(page, size, nome);
    }

    @GetMapping("{id}")
    public Produto recuperarPorId(@PathVariable Long id){
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
    public ResponseEntity<Produto> apagar(@PathVariable Long id){
        produtoService.apagar(id);
        return ResponseEntity.ok().build();
    }


}
