package com.example.pagination.controller;

import com.example.pagination.dto.PageRequestDto;
import com.example.pagination.entity.Product;
import com.example.pagination.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public Page<Product> getAllProductsUsingPagination(@RequestBody PageRequestDto dto){
        return productService.getAllProductsUsingPagination(dto);
    }

    @PostMapping("/queryMethod")
    public Page<Product> getAllProductUsingPaginationQueryMethod(@RequestBody PageRequestDto dto, @RequestParam String category) {
        return productService.getAllProductUsingPaginationQueryMethod(dto,category);
    }


}
