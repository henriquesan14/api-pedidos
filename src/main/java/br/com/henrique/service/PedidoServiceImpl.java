package br.com.henrique.service;

import br.com.henrique.domain.Pedido;
import br.com.henrique.repository.PedidoDao;
import br.com.henrique.repository.ProdutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Autowired
    private ProdutoDao produtoDao;


    @Override
    public Pedido salvar(Pedido pedido) {
        pedido.setDataPedido(LocalDateTime.now());
        pedido.getItensPedidos().forEach(i -> {
            i.setPedido(pedido);
            i.setProduto(produtoDao.findById(i.getProduto().getId()).get());

        });

        BigDecimal totalItens = pedido.getItensPedidos().stream()
                .map(i -> i.getProduto().getValorUnitario().multiply(new BigDecimal(i.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setValorTotal(totalItens);

        return pedidoDao.save(pedido);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pedido> recuperar() {
        return pedidoDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Pedido> recuperarPorId(Long id) {
        return pedidoDao.findById(id);
    }

    @Override
    public Pedido atualizar(Long id,Pedido pedido) {
        pedido.setId(id);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.getItensPedidos().forEach(i -> {
            i.setPedido(pedido);
            i.setProduto(produtoDao.findById(i.getProduto().getId()).get());
        });

        BigDecimal totalItens = pedido.getItensPedidos().stream()
                .map(i -> i.getProduto().getValorUnitario().multiply(new BigDecimal(i.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setValorTotal(totalItens);

        return pedidoDao.save(pedido);
    }

    @Override
    public void apagar(Long id) {
        pedidoDao.deleteById(id);
    }
}
