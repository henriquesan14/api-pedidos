package br.com.henrique.service;

import br.com.henrique.domain.Produto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProdutoService {
    Produto salvar(Produto produto);
    List<Produto> recuperarAll();
    Page<Produto> recuperar(int page, int size, String nome);
    Produto recuperarPorId(Long id);
    Produto atualizar(Long id,Produto produto);
    void apagar(Long id);
}
