package br.com.henrique.service;

import br.com.henrique.domain.Pedido;
import br.com.henrique.exception.EntityNotFoundException;
import br.com.henrique.repository.PedidoDao;
import br.com.henrique.repository.ProdutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    public List<Pedido> recuperarAll() {
        return pedidoDao.findAll();
    }

    @Override
    public Page<Pedido> recuperar(int page, int size, String nome) {
        Pageable pageable = new PageRequest(page, size);
        return pedidoDao.findAllByMesaNomeContainingIgnoreCaseOrderByDataPedidoAsc(pageable, nome);
    }

    @Transactional(readOnly = true)
    @Override
    public Pedido recuperarPorId(Long id) {
        return pedidoDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido","id",id));
    }

    @Override
    public Pedido atualizar(Long id,Pedido pedido) {
        Pedido pedidoBuscado=pedidoDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido","id",id));
        pedido.setDataPedido(pedidoBuscado.getDataPedido());
        pedido.setId(id);
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
        Pedido pedido = pedidoDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido","id",id));
        pedidoDao.delete(pedido);
    }


}
