package in.ineuron.service;

import in.ineuron.dao.ProductRepository;
import in.ineuron.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository repository;

    @Override
    public String saveProducts(Products products) {
        Integer id = repository.save(products).getId();
        return "Product is saved with id :: " + id;
    }

    @Override
    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<Products> getProductById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public String updateProductsDetails(Products products) {
        Optional<Products> optional = repository.findById(products.getId());
        if (optional.isPresent()){
          repository.save(products);
          return "Products with the id : " + products.getId() + " updated";
        }
        return "Products with the id : " + products.getId() + " not found";
    }

    @Override
    public String deleteProductsById(Integer id) {
        Optional<Products> optional = repository.findById(id);
        if(optional.isPresent()){
           repository.delete(optional.get());
           return "Product with id :: " + id + " deleted";
        }
        return "product not found!";
    }
}
