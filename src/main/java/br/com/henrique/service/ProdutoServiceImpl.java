package br.com.henrique.service;

import br.com.henrique.domain.Produto;
import br.com.henrique.exception.EntityNotFoundException;
import br.com.henrique.repository.ProdutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoDao produtoDao;

    @Override
    public Produto salvar(Produto produto) {
        return produtoDao.save(produto);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Produto> recuperar() {
        return produtoDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Produto recuperarPorId(Long id) {
        return produtoDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto","id",id));
    }

    @Override
    public Produto atualizar(Long id,Produto produto) {
        Produto produtoBuscado = produtoDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto","id",id));
        produto.setId(id);
        return produtoDao.save(produto);
    }

    @Override
    public void apagar(Long id) {
        Produto produto = produtoDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto","id",id));
        produtoDao.deleteById(id);
    }



}
