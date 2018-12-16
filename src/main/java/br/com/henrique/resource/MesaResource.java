package br.com.henrique.resource;

import br.com.henrique.domain.Mesa;
import br.com.henrique.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public Mesa salvar(@Valid @RequestBody  Mesa mesa){
        return mesaService.salvar(mesa);
    }


}
