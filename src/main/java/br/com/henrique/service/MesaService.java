package br.com.henrique.service;

import br.com.henrique.domain.Mesa;
import org.springframework.data.domain.Page;

import java.util.List;


public interface MesaService {
    Mesa salvar(Mesa mesa);
    List<Mesa> recuperarAll();
    Page<Mesa> recuperar(int page, int size, String nome);
    Mesa recuperarPorId(Long id);
    Mesa atualizar(Long id,Mesa mesa);
    void apagar(Long id);
}
