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

    public Construction getById(int id) {
        return constructionRepo.getOne(id);
    }

    public Construction getByName(String name) {
        return null;
    }

    public void create(Construction construction) {
        constructionRepo.save(construction);
    }

    public void update(Construction construction) {
    }

    public void delete(int id) {
        constructionRepo.deleteById(id);
    }
}
