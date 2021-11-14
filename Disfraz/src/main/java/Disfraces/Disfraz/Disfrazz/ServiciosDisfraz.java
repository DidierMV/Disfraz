/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Disfraces.Disfraz.Disfrazz;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author magom
 */
@Service
public class ServiciosDisfraz {

    @Autowired
    private RepositorioDisfraz metodosCrud;

    public List<Disfraz> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Disfraz> getDisfraz(int disfrazId) {
        return metodosCrud.getDisfraz(disfrazId);
    }

    public Disfraz save(Disfraz disfraz) {
        if (disfraz.getId() == null) {
            return metodosCrud.save(disfraz);
        } else {
            Optional<Disfraz> e = metodosCrud.getDisfraz(disfraz.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(disfraz);
            } else {
                return disfraz;
            }
        }
    }

    public Disfraz update(Disfraz disfraz) {
        if (disfraz.getId() != null) {
            Optional<Disfraz> e = metodosCrud.getDisfraz(disfraz.getId());
            if (!e.isEmpty()) {
                if (disfraz.getName() != null) {
                    e.get().setName(disfraz.getName());
                }
                if (disfraz.getBrand() != null) {
                    e.get().setBrand(disfraz.getBrand());
                }
                if (disfraz.getYear() != null) {
                    e.get().setYear(disfraz.getYear());
                }
                if (disfraz.getDescription() != null) {
                    e.get().setDescription(disfraz.getDescription());
                }
                if (disfraz.getCategory() != null) {
                    e.get().setCategory(disfraz.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return disfraz;
            }
        } else {
            return disfraz;
        }
    }

    public boolean deleteDisfraz(int disfrazId) {
        Boolean aBoolean = getDisfraz(disfrazId).map(disfraz -> {
            metodosCrud.delete(disfraz);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}