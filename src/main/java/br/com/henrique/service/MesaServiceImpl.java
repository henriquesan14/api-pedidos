package br.com.henrique.service;

import br.com.henrique.domain.Mesa;
import br.com.henrique.repository.MesaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public List<Mesa> recuperar() {
        return mesaDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Mesa> recuperarPorId(Long id) {
        return mesaDao.findById(id);
    }

    @Override
    public Mesa atualizar(Long id,Mesa mesa) {
        mesa.setId(id);
        return mesaDao.save(mesa);
    }

    @Override
    public void apagar(Long id) {
        mesaDao.deleteById(id);
    }
}
