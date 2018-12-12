package com.para.crud_auditoria.services;

import com.para.crud_auditoria.documents.Auditoria;

import java.util.List;
import java.util.Optional;

public interface AuditoriaService {


//    /**
//     * Persistir uma auditoria na base de dado
//     *
//     * @param auditoria
//     * @return Auditoria
//     */
    Auditoria persistir( Auditoria auditoria);


    /**
     * Buscar uma auditoria dado uma entidade
     *
     * @param entidade
     * @return Optional<List<Auditoria>>
     */



    List<Auditoria> findByEntidade(String entidade);


//    /**
//     * Buscar uma auditoria, dado uma Entidade e um Id
//     *
//     * @param entidade
//     * @param id
//     * @return Optional<List<Auditoria>>
//     */
//    Optional<List<Auditoria>> buscarPorEntidadeId(String entidade, String id);


    /**
     * Listar todos as auditorias
     *
     * @return Optional<List<Auditoria>>
     */
   List<Auditoria> listarTodos();


}
