package br.com.henrique.resource;

import br.com.henrique.domain.Mesa;
import br.com.henrique.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/mesas")
public class MesaResource {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<Mesa> listar(){
        return mesaService.recuperar();
    }

    @GetMapping("{id}")
    public Mesa listarPorId(@PathVariable Long id){
        return mesaService.recuperarPorId(id);
    }

    @PostMapping
    public Mesa salvar(@Valid @RequestBody  Mesa mesa){
        return mesaService.salvar(mesa);
    }

    @PutMapping("{id}")
    public Mesa editar(@Valid @RequestBody Mesa mesa, @PathVariable("id") Long id){
        return mesaService.atualizar(id,mesa);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Mesa> apagar(@PathVariable("id") Long id){
        mesaService.apagar(id);
        return ResponseEntity.ok().build();
    }



}
