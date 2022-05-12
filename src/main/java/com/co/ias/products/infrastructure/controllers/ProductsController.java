package com.co.ias.products.infrastructure.controllers;

import com.co.ias.products.products.application.models.ProductDTO;
import com.co.ias.products.products.application.ports.in.CreateProductUseCase;
import com.co.ias.products.products.application.ports.in.DeleteProductUseCase;
import com.co.ias.products.products.application.ports.in.QueryProductUseCase;
import com.co.ias.products.products.application.ports.in.UpdateProductUseCase;
import com.co.ias.products.shared.errors.AplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductsController {

    private final CreateProductUseCase createProductUseCase;
    private final QueryProductUseCase queryProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductsController(CreateProductUseCase createProductUseCase, QueryProductUseCase queryProductUseCase,
            UpdateProductUseCase updateProductUseCase,
            DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.queryProductUseCase = queryProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            ProductDTO product = createProductUseCase.excute(productDTO);
            return ResponseEntity.ok(product);

        } catch (IllegalArgumentException | NullPointerException e) {
            AplicationError aplicationError = new AplicationError(
                    "InputValidation",
                    "Bad input data");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aplicationError);
        } catch (Exception exception) {
            AplicationError aplicationError = new AplicationError(
                    "SystemError",
                    exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aplicationError);
        }
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer id) {
        try {
            Optional<ProductDTO> productDTO = queryProductUseCase.excute(id);
            return productDTO.isPresent() ? ResponseEntity.ok(productDTO)
                    : ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
        } catch (IllegalArgumentException | NullPointerException e) {
            AplicationError aplicationError = new AplicationError(
                    "InputValidation",
                    "Bad input data");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aplicationError);
        } catch (Exception exception) {
            AplicationError aplicationError = new AplicationError(
                    "SystemError",
                    exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aplicationError);
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
        try {
            ProductDTO product = updateProductUseCase.excute(productDTO);
            return ResponseEntity.ok(product);
        } catch (IllegalArgumentException | NullPointerException e) {
            AplicationError aplicationError = new AplicationError(
                    "InputValidation",
                    "Bad input data");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aplicationError);
        } catch (Exception exception) {
            AplicationError aplicationError = new AplicationError(
                    "SystemError",
                    exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aplicationError);
        }
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        try {
            deleteProductUseCase.excute(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (IllegalArgumentException | NullPointerException e) {
            AplicationError aplicationError = new AplicationError(
                    "InputValidation",
                    "Bad input data");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aplicationError);
        } catch (Exception exception) {
            AplicationError aplicationError = new AplicationError(
                    "SystemError",
                    exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aplicationError);
        }
    }
}
