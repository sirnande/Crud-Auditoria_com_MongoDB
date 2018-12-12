package com.para.crud_auditoria.services.implementations;

import com.para.crud_auditoria.documents.Auditoria;
import com.para.crud_auditoria.repositories.AuditoriaRepository;
import com.para.crud_auditoria.services.AuditoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriaServiceImplementation implements AuditoriaService {

    public static final Logger log = LoggerFactory.getLogger(AuditoriaServiceImplementation.class);

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public Auditoria persistir( Auditoria auditoria) {
        log.info("Perisitindo uma nova auditoria");
        return this.auditoriaRepository.save(auditoria);
    }

    @Override
    public List<Auditoria> findByEntidade(String entidade) {
        return this.auditoriaRepository.findByEntidade(entidade);
    }

    //    @Override
//    public Optional<List<Auditoria>> buscarPorEntidadeId(String entidade, String id) {
//        log.info("Buscar uma lista de auditoria por nome de entidade e id");
//        return Optional.ofNullable(this.auditoriaRepository.findByEntidadeId(entidade, id));
//    }




    @Override
    public List<Auditoria> listarTodos() {
        return this.auditoriaRepository.findAll();
    }
}
