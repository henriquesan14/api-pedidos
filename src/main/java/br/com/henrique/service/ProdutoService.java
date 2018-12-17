package br.com.henrique.service;

import br.com.henrique.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    Produto salvar(Produto produto);
    List<Produto> recuperar();
    Optional<Produto> recuperarPorId(Long id);
    Produto atualizar(Long id,Produto produto);
    void apagar(Long id);
}
