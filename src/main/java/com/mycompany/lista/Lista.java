/** Clasa pentru Lista -- structura tabelului
 * @author Paun Alexandra
 * @version 10 ianuarie 2025
 */
package com.mycompany.lista;

import javax.persistence.*;

@Entity
@Table(name = "lista")
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 100)
    public String nume;

    @Column(precision = 10, scale = 2)
    public Double pret;

    @Column(nullable = false)
    public Integer prioritate;

    @Column(length = 50)
    public String categorie;

    // Getters și Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public Integer getPrioritate() {
        return prioritate;
    }

    public void setPrioritate(Integer prioritate) {
        this.prioritate = prioritate;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                ", prioritate=" + prioritate +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}