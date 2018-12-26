package br.com.henrique.service;

import br.com.henrique.domain.Pedido;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PedidoService {
    Pedido salvar(Pedido pedido);
    List<Pedido> recuperarAll();
    Page<Pedido> recuperar(int page, int size, String nome);
    Pedido recuperarPorId(Long id);
    Pedido atualizar(Long id,Pedido pedido);
    void apagar(Long id);
}
