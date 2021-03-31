package ru.goryachev.forgeo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.forgeo.models.Construction;
import ru.goryachev.forgeo.repositories.ConstructionRepo;
import java.util.List;


@Service
public class ConstructionService {

    @Autowired
    private ConstructionRepo constructionRepo;

    public List<Construction> getAll() {
        return constructionRepo.findAll();
    }

    public Construction getById(Long id) {
        return constructionRepo.findById(id).get();
    }

    public Construction getByName(String name) {
        return null;
    }

    public void create(Construction construction) {

       constructionRepo.save(construction);
    }

    public void update(Long id, Construction modifiedConstruction) {

        Construction construction = constructionRepo.findById(id).get();;
        construction.setDescription(modifiedConstruction.getDescription());
        construction.setCodeNumber(modifiedConstruction.getCodeNumber());
        construction.setName(modifiedConstruction.getName());
        constructionRepo.save(construction);
    }

    public void delete(Long id) {
        constructionRepo.deleteById(id);
    }
}
