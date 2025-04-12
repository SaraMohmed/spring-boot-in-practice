package com.example.pagination.service;

import com.example.pagination.dto.PageRequestDto;
import com.example.pagination.entity.Product;
import com.example.pagination.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProductsUsingPagination(PageRequestDto dto) {
        Pageable pageable = new PageRequestDto().getPageable(dto);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage;
    }

    @Override
    public Page<Product> getAllProductUsingPaginationQueryMethod(PageRequestDto dto, String category) {
        Pageable pageable = new PageRequestDto().getPageable(dto);
        Page<Product> productPage = productRepository.findAllByCategory(category,dto.getPageable(dto));
        return productPage;
    }
}
