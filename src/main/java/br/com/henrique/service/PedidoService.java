package br.com.henrique.service;

import br.com.henrique.domain.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido salvar(Pedido pedido);
    List<Pedido> recuperar();
    Pedido recuperarPorId(Long id);
    Pedido atualizar(Long id,Pedido pedido);
    void apagar(Long id);
}
