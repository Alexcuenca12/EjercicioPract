package com.example.ejerciciopract.Services;

import com.example.ejerciciopract.model.Competencias_Roles;
import com.example.ejerciciopract.repository.ICompetencia_Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Competencia_RolesServiceImpl extends GenericServiceImpl<Competencias_Roles,Long> implements IGenericService<Competencias_Roles,Long> {
    @Autowired
    ICompetencia_Roles competencia_rolesRepository;
    @Override
    public CrudRepository<Competencias_Roles, Long> getDao() {
        return competencia_rolesRepository;
    }
}
