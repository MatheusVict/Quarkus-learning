package io.matheusvictor.service;

import io.matheusvictor.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    void createProduct(ProductDTO productDTO);

    void changeProduct(Long id, ProductDTO productDTO);

    ProductDTO getProductById(Long id);
}
