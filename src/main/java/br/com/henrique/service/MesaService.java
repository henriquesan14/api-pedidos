package br.com.henrique.service;

import br.com.henrique.domain.Mesa;

import java.util.List;


public interface MesaService {
    Mesa salvar(Mesa mesa);
    List<Mesa> recuperar();
    Mesa recuperarPorId(Long id);
    Mesa atualizar(Long id,Mesa mesa);
    void apagar(Long id);
}
