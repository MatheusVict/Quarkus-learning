package io.matheusvictor.service.impl;

import io.matheusvictor.domain.ProductEntity;
import io.matheusvictor.dto.ProductDTO;
import io.matheusvictor.repository.ProductRepository;
import io.matheusvictor.service.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    @Inject
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        this.productRepository.findAll()
                .stream().
                forEach(productEntity ->
                        products.add(toProductDTO(productEntity))
                );
        return products;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        this.productRepository.persist(toProductEntity(productDTO));
    }

    @Override
    public void changeProduct(Long id, ProductDTO productDTO) {
        ProductDTO productFound = this.getProductById(id);
        productFound.setName(productDTO.getName());
        productFound.setDescription(productDTO.getDescription());
        productFound.setCategory(productDTO.getCategory());
        productFound.setModel(productDTO.getModel());
        productFound.setPrice(productDTO.getPrice());
        ProductEntity converted = this.toProductEntity(productFound);

        this.productRepository.persist(converted);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return this.toProductDTO(this.productRepository.findById(id));
    }

    private ProductEntity toProductEntity(ProductDTO productDTO) {
        return ProductEntity.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .model(productDTO.getModel())
                .price(productDTO.getPrice())
                .build();
    }

    private ProductDTO toProductDTO(ProductEntity productEntity) {
        return ProductDTO.builder()
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .category(productEntity.getCategory())
                .model(productEntity.getModel())
                .price(productEntity.getPrice())
                .build();
    }
}
