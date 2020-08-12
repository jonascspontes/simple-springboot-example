package com.example.demo.repository;
import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, BigInteger> {
}