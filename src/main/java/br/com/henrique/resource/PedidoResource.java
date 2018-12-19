package br.com.henrique.resource;

import br.com.henrique.domain.Pedido;
import br.com.henrique.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> recuperar(){
        return pedidoService.recuperar();
    }

    @GetMapping("{id}")
    public Optional<Pedido> recuperarPorId(@PathVariable Long id){
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
    public void apagar(@PathVariable Long id){
        pedidoService.apagar(id);
    }



}
