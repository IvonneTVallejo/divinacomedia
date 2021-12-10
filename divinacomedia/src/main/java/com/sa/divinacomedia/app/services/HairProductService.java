package com.sa.divinacomedia.app.services;

import com.sa.divinacomedia.app.entities.HairProduct;
import com.sa.divinacomedia.app.repositories.HairProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Tatiana
 */
@Service
public class HairProductService {

    @Autowired
    private HairProductRepository repository;

    public List<HairProduct> getAll(){
        return repository.getAll();
    }

    public HairProduct save(HairProduct product) {
        if (product.getId() == null) {
            return repository.save(product);
        } else {
            Optional<HairProduct> existProduct = repository.getById(product.getId());
            if (existProduct.isPresent()) {
                return product;
            } else {
                return repository.save(product);
            }
        }
    }

    public HairProduct update(HairProduct product){
        if (product.getId()!= null) {
            Optional<HairProduct> existProduct = repository.getById(product.getId());
            if (existProduct.isPresent()) {
                if (product.getBrand()!= null) {
                    existProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory()!= null) {
                    existProduct.get().setCategory(product.getCategory());
                }
                if (product.getName()!= null) {
                    existProduct.get().setName(product.getName());
                }
                if (product.getDescription()!= null) {
                    existProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0) {
                    existProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity()!= 0) {
                    existProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!= null) {
                    existProduct.get().setPhotography(product.getPhotography());
                }
                return repository.save(existProduct.get());
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public void delete(String id){
        repository.delete(id);
    }


    public Optional<HairProduct> findById(String id){
        return repository.getById(id);
    }
}
