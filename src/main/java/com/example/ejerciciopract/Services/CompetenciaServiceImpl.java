package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Competencia;
import com.example.ejerciciopract.repository.ICompetencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CompetenciaServiceImpl extends GenericServiceImpl<Competencia,Long> implements IGenericService<Competencia,Long> {
    @Autowired
    ICompetencia competenciaRepository;

    @Override
    public CrudRepository<Competencia, Long> getDao() {
        return competenciaRepository;
    }
}
