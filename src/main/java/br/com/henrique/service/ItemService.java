package br.com.henrique.service;

import br.com.henrique.domain.ItemPedido;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    ItemPedido salvar(ItemPedido item);
    List<ItemPedido> recuperar();
    Optional<ItemPedido> recuperarPorId(Long id);
    ItemPedido atualizar(ItemPedido item);
    void apagar(Long id);
}
