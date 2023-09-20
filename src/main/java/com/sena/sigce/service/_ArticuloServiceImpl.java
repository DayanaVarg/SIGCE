package com.sena.sigce.service;

import com.sena.sigce.model.Articulo;
import com.sena.sigce.repository.articuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class _ArticuloServiceImpl implements IArticuloService{

    @Autowired
    private articuloRepository articuloRepository;

    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) articuloRepository.findAll();
    }

    @Override
    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }
}
