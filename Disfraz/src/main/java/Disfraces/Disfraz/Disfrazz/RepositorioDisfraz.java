/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Disfraces.Disfraz.Disfrazz;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author magom
 */
@Repository
public class RepositorioDisfraz {

    @Autowired
    private InterfaceDisfraz crud;

    public List<Disfraz> getAll() {
        return (List<Disfraz>) crud.findAll();
    }

    public Optional<Disfraz> getDisfraz(int id) {
        return crud.findById(id);
    }

    public Disfraz save(Disfraz disfraz) {
        return crud.save(disfraz);
    }

    public void delete(Disfraz disfraz) {
        crud.delete(disfraz);
    }
}