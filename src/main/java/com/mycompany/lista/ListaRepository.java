/** Clasa pentru metode de interogare a bazei de date
 * @author Paun Alexandra
 * @version 10 ianuarie 2025
 */

package com.mycompany.lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ListaRepository extends JpaRepository<Lista, Long> {


    @Query("SELECT l FROM Lista l ORDER BY l.prioritate ASC")
    List<Lista> findAllOrderByPrioritateAsc();

    @Query("SELECT l FROM Lista l ORDER BY l.prioritate DESC")
    List<Lista> findAllOrderByPrioritateDesc();

    @Query("SELECT l FROM Lista l ORDER BY l.pret ASC")
    List<Lista> findAllOrderByPretAsc();

    @Query("SELECT l FROM Lista l ORDER BY l.pret DESC")
    List<Lista> findAllOrderByPretDesc();

    Long countById(Long id);
}