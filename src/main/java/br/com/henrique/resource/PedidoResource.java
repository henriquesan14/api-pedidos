package br.com.henrique.resource;

import br.com.henrique.domain.Pedido;
import br.com.henrique.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public List<Pedido> recuperarAll(){
        return pedidoService.recuperarAll();
    }

    @GetMapping
    public Page<Pedido> recuperar(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "5") int size,
                                  @RequestParam(value = "nome", defaultValue = "") String nome){
        return pedidoService.recuperar(page,size, nome);
    }

    @GetMapping("{id}")
    public Pedido recuperarPorId(@PathVariable Long id){
        return pedidoService.recuperarPorId(id);
    }


    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido){
        return pedidoService.salvar(pedido);
    }

    @PutMapping("{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido){
        return pedidoService.atualizar(id,pedido);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pedido> apagar(@PathVariable Long id){
        pedidoService.apagar(id);
        return ResponseEntity.ok().build();
    }



}
