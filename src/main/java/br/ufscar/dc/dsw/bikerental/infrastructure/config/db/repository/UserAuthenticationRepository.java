package br.ufscar.dc.dsw.bikerental.infrastructure.config.db.repository;

import br.ufscar.dc.dsw.bikerental.entity.authentication.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthenticationRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}