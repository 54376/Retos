package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.model.Quadbike;
import com.usa.ciclo3.reto3.repository.QuadbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuadbikeService {
    @Autowired
    private QuadbikeRepository quadbikeRepository;

    public List<Quadbike> getAll() {
        return quadbikeRepository.getAll();
    }

    public Optional<Quadbike> getQuadbike(int id) {
        return quadbikeRepository.getQuadbike(id);
    }

    public Quadbike save(Quadbike quadbike) {
        if (quadbike.getId() == null) {
            return quadbikeRepository.save(quadbike);
        } else {
            Optional<Quadbike> tmpquadbike = quadbikeRepository.getQuadbike(quadbike.getId());
            if (tmpquadbike.isEmpty()) {
                return quadbikeRepository.save(quadbike);
            } else {
                return quadbike;
            }
        }
    }

    public Quadbike update(Quadbike quadbike) {
        if (quadbike.getId() != null) {
            Optional<Quadbike> tmpquadbike = quadbikeRepository.getQuadbike(quadbike.getId());
            if (!tmpquadbike.isEmpty()) {
                return quadbikeRepository.save(quadbike);
            }
        }
        return null;
    }

    public boolean deleteQuadbike(int id){
        boolean Boolean=getQuadbike(id).map(quadbike -> {
            quadbikeRepository.delete(quadbike);
            return true;
        }).orElse(false);
        return Boolean;
    }
}