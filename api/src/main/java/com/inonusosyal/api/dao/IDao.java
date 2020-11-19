package com.inonusosyal.api.dao;

import com.inonusosyal.api.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDao <T>{
    List<T> get();
    Optional<T> getById(UUID id);
    int add(T t);
    int update(T t);
    int remove(UUID id);
}
