package com.para.crud_auditoria.controllers;

import com.para.crud_auditoria.documents.Auditoria;
import com.para.crud_auditoria.dtos.AuditoriaDto;
import com.para.crud_auditoria.repositories.AuditoriaRepository;
import com.para.crud_auditoria.response.Response;
import com.para.crud_auditoria.services.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crud/api/auditoria")
public class AuditoriaController {


    @Autowired
    private AuditoriaService auditoriaService;


    /**
     * Método responsáveç por retorna todas as auditorias
     *
     * @return ResponseEntity<AuditoriaDto>
     */
    @GetMapping("/listar-todos")
    public List<Auditoria> listarTodo(){

        return this.auditoriaService.listarTodos();
    }

//    @GetMapping("/entidade/{entidade}")
//    public ResponseEntity<Response<List<AuditoriaDto>>> buscarPorEntidade(@PathVariable("entidade") String entidade){
//
//        Response<List<AuditoriaDto>> response =  new Response<>();
//        List<Auditoria> auditorias = this.auditoriaService.findByEntidade(entidade);
//        List<AuditoriaDto> auditoriaDtos = auditorias.get(auditorias.);
//
//        return this.auditoriaService.findByEntidade(entidade);
//    }

    @GetMapping("/entidade/{entidade}")
    public List<Auditoria> buscarPorEntidade(@PathVariable("entidade") String entidade){

        return this.auditoriaService.findByEntidade(entidade);
    }




    @PostMapping("/save")
    public ResponseEntity<Response<AuditoriaDto>> salvar(@Valid @RequestBody AuditoriaDto auditoriaDto,
                                                        BindingResult result) throws ParseException{

        Response<AuditoriaDto> response = new Response<>();
        Auditoria auditoria = this.converterDtoParaAuditorio(auditoriaDto, result);

        auditoria = this.auditoriaService.persistir(auditoria);
        response.setData(this.converterAuditoriaDto(auditoria));
        return ResponseEntity.ok(response);
    }

    private AuditoriaDto converterAuditoriaDto(Auditoria auditoria) {
        AuditoriaDto auditoriaDto = new AuditoriaDto();

        auditoriaDto.setId(auditoria.getId());
        auditoriaDto.setObjetoAntigo(auditoria.getObjetoAntigo());
        auditoriaDto.setObjetoNovo(auditoria.getObjetoNovo());
        auditoriaDto.setEntidade(auditoria.getEntidade());
        auditoriaDto.setData_modificacao(auditoria.getData_modificacao());

        return auditoriaDto;
    }

    private Auditoria converterDtoParaAuditorio(AuditoriaDto auditoriaDto, BindingResult result) {

        return new Auditoria(auditoriaDto.getObjetoAntigo(), auditoriaDto.getObjetoNovo(), auditoriaDto.getEntidade());
    }


}
