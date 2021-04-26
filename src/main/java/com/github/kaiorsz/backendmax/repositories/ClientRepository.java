package com.github.kaiorsz.backendmax.repositories;

import com.github.kaiorsz.backendmax.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, String> {
}
