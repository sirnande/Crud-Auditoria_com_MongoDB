package com.para.crud_auditoria.repositories;

import com.para.crud_auditoria.documents.Auditoria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuditoriaRepository extends MongoRepository<Auditoria, String> {


    List<Auditoria> findByEntidade(String entidade);


//
//
//    List<Auditoria> findByEntidadeId(String entidade, String id);
}
