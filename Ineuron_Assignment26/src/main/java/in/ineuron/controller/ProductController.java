package in.ineuron.controller;

import in.ineuron.entity.Products;
import in.ineuron.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/save")
    public ResponseEntity<String> saveProducts(@RequestBody Products products){
        String message = service.saveProducts(products);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @GetMapping("/display")
    public ResponseEntity<List> getAllProducts(){
     List<Products> products = service.getAllProducts();
     return new ResponseEntity<List>(products,HttpStatus.OK);
    }

    @GetMapping("getProduct/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        Optional<Products> products = service.getProductById(id);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> updateProductDetails(@RequestBody Products products){
        String message = service.updateProductsDetails(products);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer id){
        String message = service.deleteProductsById(id);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
}
