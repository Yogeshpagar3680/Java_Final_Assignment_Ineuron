package in.ineuron.service;

import in.ineuron.entity.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public String saveProducts(Products products);
    public List<Products> getAllProducts();
    public Optional<Products> getProductById(Integer id);
    public String updateProductsDetails(Products products);
    public String deleteProductsById(Integer id);
}
