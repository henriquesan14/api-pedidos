package br.com.henrique.service;

import br.com.henrique.domain.Mesa;
import br.com.henrique.exception.EntityNotFoundException;
import br.com.henrique.repository.MesaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaDao mesaDao;

    @Override
    public Mesa salvar(Mesa mesa) {
        return mesaDao.save(mesa);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Mesa> recuperarAll() {
        return mesaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Mesa> recuperar(int page, int size, String nome) {
        Pageable pageable = new PageRequest(page, size);
        return mesaDao.findAllByNomeContainingIgnoreCaseOrderByNomeAsc(pageable,nome);
    }

    @Transactional(readOnly = true)
    @Override
    public Mesa recuperarPorId(Long id) {
        return mesaDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mesa","id",id));
    }

    @Override
    public Mesa atualizar(Long id,Mesa mesa) {
        Mesa mesaBuscada = mesaDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mesa","id",id));
        mesa.setId(id);
        return mesaDao.save(mesa);
    }

    @Override
    public void apagar(Long id) {
        Mesa mesa = mesaDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mesa","id",id));
        mesaDao.delete(mesa);
    }

}
