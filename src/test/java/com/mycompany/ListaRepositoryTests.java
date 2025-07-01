package com.mycompany;

import com.mycompany.lista.Lista;
import com.mycompany.lista.ListaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ListaRepositoryTests {
    @Autowired private ListaRepository repo;

    @Test
    public void testAddNew() {
        Lista lista = new Lista();
        lista.setNume("Laptop");
        lista.setPret(3500.00);
        lista.setPrioritate(3);
        lista.setCategorie("Electronics");

        Lista savedLista = repo.save(lista);

        Assertions.assertThat(savedLista).isNotNull();
        Assertions.assertThat(savedLista.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Lista> listItems = repo.findAll();
        Assertions.assertThat(listItems).hasSizeGreaterThan(0);

        for (Lista lista : listItems) {
            System.out.println(lista);
        }
    }

    @Test
    public void testUpdate() {
        Long itemId = 1L;
        Optional<Lista> optionalLista = repo.findById(itemId);
        Lista lista = optionalLista.get();
        lista.setPret(4000.00);
        repo.save(lista);

        Lista updatedLista = repo.findById(itemId).get();
        Assertions.assertThat(updatedLista.getPret()).isEqualTo(4000.00);
    }

    @Test
    public void testGet() {
        Long itemId = 2L;
        Optional<Lista> optionalLista = repo.findById(itemId);
        Assertions.assertThat(optionalLista).isPresent();
        System.out.println(optionalLista.get());
    }

    @Test
    public void testDelete() {
        Long itemId = 2L;
        repo.deleteById(itemId);

        Optional<Lista> optionalLista = repo.findById(itemId);
        Assertions.assertThat(optionalLista).isNotPresent();
    }
}