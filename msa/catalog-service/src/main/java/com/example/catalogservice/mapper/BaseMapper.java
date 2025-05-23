package com.example.catalogservice.mapper;


public interface BaseMapper<C, D, E> {

    E toEntity(C command);

    D toDto(E command);
}
