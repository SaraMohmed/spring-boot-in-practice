package com.example.pagination.service;

import com.example.pagination.dto.PageRequestDto;
import com.example.pagination.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductService {
    public Page<Product> getAllProductsUsingPagination(PageRequestDto dto);
    public Page<Product> getAllProductUsingPaginationQueryMethod(PageRequestDto dto, String category);

}
