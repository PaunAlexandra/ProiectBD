/** Clasa pentru stratul de servicii
 * @author Paun Alexandra
 * @version 10 ianuarie 2025
 */
package com.mycompany.lista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ListaService {
    @Autowired
    private ListaRepository repo;

    public List<Lista> listAll() {
        return repo.findAll();
    }

    public void save(Lista lista) {
        repo.save(lista);
    }

    public Lista get(Long id) throws ListaNotFoundException {
        Optional<Lista> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ListaNotFoundException("Could not find any items with ID " + id);
    }

    public void delete(Long id) throws ListaNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new ListaNotFoundException("Could not find any items with ID " + id);
        }
        repo.deleteById(id);
    }
    public List<Lista> sortByPrioritateAsc() {
        return repo.findAllOrderByPrioritateAsc();
    }

    public List<Lista> sortByPrioritateDesc() {
        return repo.findAllOrderByPrioritateDesc();
    }

    public List<Lista> sortByPretAsc() {
        return repo.findAllOrderByPretAsc();
    }

    public List<Lista> sortByPretDesc() {
        return repo.findAllOrderByPretDesc();
    }

    public List<Lista> getAll() {
        return repo.findAll();
    }
}
