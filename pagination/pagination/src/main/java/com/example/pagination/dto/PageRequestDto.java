package com.example.pagination.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;


public class PageRequestDto {
    private int pageNumber = 0;
    private int pageSize = 10;
    private Sort.Direction sort = Sort.Direction.ASC;
    private String sortByColumn = "id";


    public Pageable getPageable(PageRequestDto dto){
        int page = Objects.nonNull(dto.getPageNumber()) ? dto.getPageNumber() : this.pageNumber;
        int size = Objects.nonNull(dto.getPageSize()) ? dto.getPageSize() : this.pageSize;
        Sort.Direction sort = Objects.nonNull(dto.getSort()) ? dto.getSort() : this.sort;
        String sortByColumn = Objects.nonNull(dto.getSortByColumn()) ? dto.getSortByColumn() : this.sortByColumn;
        PageRequest request = PageRequest.of(page, size, sort, sortByColumn);

        return request;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Sort.Direction getSort() {
        return sort;
    }

    public String getSortByColumn() {
        return sortByColumn;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSort(Sort.Direction sort) {
        this.sort = sort;
    }

    public void setSortByColumn(String sortByColumn) {
        this.sortByColumn = sortByColumn;
    }
}
