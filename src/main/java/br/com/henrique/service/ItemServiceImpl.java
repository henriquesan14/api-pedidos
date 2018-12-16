package br.com.henrique.service;

import br.com.henrique.domain.ItemPedido;
import br.com.henrique.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public ItemPedido salvar(ItemPedido item) {
        return itemDao.save(item);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ItemPedido> recuperar() {
        return itemDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ItemPedido> recuperarPorId(Long id) {
        return itemDao.findById(id);
    }

    @Override
    public ItemPedido atualizar(ItemPedido item) {
        return itemDao.save(item);
    }

    @Override
    public void apagar(Long id) {
        itemDao.deleteById(id);
    }
}
