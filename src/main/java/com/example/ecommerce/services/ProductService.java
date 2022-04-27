package com.example.ecommerce.services;

import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.Supplier;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final SupplierService supplierService;

    public ProductService(ProductRepository productRepository, SupplierService supplierService) {
        this.productRepository = productRepository;
        this.supplierService = supplierService;
    }

    /**
     *
     * @return
     */
    public List<Product>getProducts(){
        return productRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Product getProduct(Long id){
        return productRepository.findById(id).orElseThrow(null);
    }

    /**
     *
     * @param supplierId
     * @param product
     * @return
     */
    public Product addProduct(Long supplierId,Product product){
        Supplier supplier=supplierService.getSupplier(supplierId);
        product.setSupplier(supplier);
        return productRepository.save(product);
    }

    /**
     *
     * @param id
     */
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
