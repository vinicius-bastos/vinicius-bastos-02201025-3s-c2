package br.com.bandtec.provacontinuada.repositorio;

import br.com.bandtec.provacontinuada.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository  extends JpaRepository<Lutador, Integer> {

//    @Query("select f from lutador f")
//    List<Lutador> findAllForca();

//    @Query("select f from lutador order by forca_golpe ASC")
//    List<Lutador> findAllForca();
//

    @Query("select f from Lutador f order by forca_golpe DESC") //
    List<Lutador> findAllForca();


    Integer countAllByVivoTrue();

    Integer countAllByVivoFalse();



}
