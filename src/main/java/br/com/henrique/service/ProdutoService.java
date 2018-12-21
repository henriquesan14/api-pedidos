package br.com.henrique.service;

import br.com.henrique.domain.Produto;

import java.util.List;

public interface ProdutoService {
    Produto salvar(Produto produto);
    List<Produto> recuperar();
    Produto recuperarPorId(Long id);
    Produto atualizar(Long id,Produto produto);
    void apagar(Long id);
}
