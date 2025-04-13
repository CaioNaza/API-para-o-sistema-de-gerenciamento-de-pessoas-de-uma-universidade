package api.trabalho.repository;
import api.trabalho.entity.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Pessoa, UUID> {
}