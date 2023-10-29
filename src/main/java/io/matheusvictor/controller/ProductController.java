package io.matheusvictor.controller;

import io.matheusvictor.dto.ProductDTO;
import io.matheusvictor.service.ProductService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/products")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> findAll() {
        return this.productService.getAllProducts();
    }

    @GET
    @Path("/{id}")
    public ProductDTO findById(@PathParam("id") Long id) {
        return this.productService.getProductById(id);
    }

    @POST
    @Transactional
    public Response create(ProductDTO productDTO) {
        this.productService.createProduct(productDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, ProductDTO productDTO) {
        this.productService.changeProduct(id, productDTO);
        return Response.status(Response.Status.CREATED).build();
    }


}
