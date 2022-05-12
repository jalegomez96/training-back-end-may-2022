package com.co.ias.products.infrastructure.controllers;

import com.co.ias.products.shared.errors.AplicationError;
import com.co.ias.products.types.application.models.TypeDTO;
import com.co.ias.products.types.application.ports.in.CreateTypeUseCase;
import com.co.ias.products.types.application.ports.in.DeleteTypeUseCase;
import com.co.ias.products.types.application.ports.in.QueryTypeUseCase;
import com.co.ias.products.types.application.ports.in.UpdateTypeUseCase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TypesController {

    private final CreateTypeUseCase createTypeUseCase;
    private final QueryTypeUseCase queryTypeUseCase;
    private final UpdateTypeUseCase updateTypeUseCase;
    private final DeleteTypeUseCase deleteTypeUseCase;

    public TypesController(CreateTypeUseCase createTypeUseCase, QueryTypeUseCase queryTypeUseCase,
            UpdateTypeUseCase updateTypeUseCase,
            DeleteTypeUseCase deleteTypeUseCase) {
        this.createTypeUseCase = createTypeUseCase;
        this.queryTypeUseCase = queryTypeUseCase;
        this.updateTypeUseCase = updateTypeUseCase;
        this.deleteTypeUseCase = deleteTypeUseCase;
    }

    @RequestMapping(value = "/types", method = RequestMethod.POST)
    public ResponseEntity<?> createType(@RequestBody TypeDTO typeDTO) {
        try {
            TypeDTO type = createTypeUseCase.excute(typeDTO);
            return ResponseEntity.ok(type);

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

    @RequestMapping(value = "/types/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getType(@PathVariable("id") Integer id) {
        try {
            Optional<TypeDTO> typeDTO = queryTypeUseCase.excute(id);
            return typeDTO.isPresent() ? ResponseEntity.ok(typeDTO)
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

    @RequestMapping(value = "/types", method = RequestMethod.PUT)
    public ResponseEntity<?> updateType(@RequestBody TypeDTO typeDTO) {
        try {
            TypeDTO type = updateTypeUseCase.excute(typeDTO);
            return ResponseEntity.ok(type);
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

    @RequestMapping(value = "/types/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteType(@PathVariable("id") Integer id) {
        try {
            deleteTypeUseCase.excute(id);
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
