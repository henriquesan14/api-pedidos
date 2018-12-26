package br.com.henrique.resource;

import br.com.henrique.domain.Mesa;
import br.com.henrique.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/all")
    public List<Mesa> listarAll(){
        return mesaService.recuperarAll();
    }

    @GetMapping
    public Page<Mesa> listar(@RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "size", defaultValue = "5") int size,
                                    @RequestParam(value = "nome", defaultValue = "") String nome){
        return mesaService.recuperar(page,size, nome);
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
