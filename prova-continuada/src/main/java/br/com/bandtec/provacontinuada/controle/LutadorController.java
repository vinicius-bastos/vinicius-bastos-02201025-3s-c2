package br.com.bandtec.provacontinuada.controle;

import br.com.bandtec.provacontinuada.dominio.Lutador;
import br.com.bandtec.provacontinuada.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutador")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutadores(@RequestBody @Valid Lutador novoLutador){
        novoLutador.setVida(100.0);
        novoLutador.setVivo(true);
        novoLutador.setConcentracoesRealizadas(0);
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutadores(){
        return ResponseEntity.status(200).body(repository.findAllForca());
    }


    @GetMapping("/contagem-vivos")
    public ResponseEntity getLutadorVivo(){
        return ResponseEntity.status(200).body(repository.countAllByVivoTrue());
    }

    @GetMapping("/contagem-mortos")
    public ResponseEntity getLutadorMorto(){
        return ResponseEntity.status(200).body(repository.countAllByVivoFalse());
    }


//    @PostMapping("/{id}/concentrar")
//    public ResponseEntity postLutadores(PathVariable Integer id){
//        return ResponseEntity.status(200).body(repository.countAllByVivoTrue());
//    }

}
