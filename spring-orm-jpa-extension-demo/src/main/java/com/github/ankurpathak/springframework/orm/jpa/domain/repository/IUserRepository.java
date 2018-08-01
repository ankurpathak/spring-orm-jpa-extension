package com.github.ankurpathak.springframework.orm.jpa.domain.repository;

import com.github.ankurpathak.springframework.orm.jpa.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface IUserRepository extends JpaRepository<User, BigInteger> {
}
