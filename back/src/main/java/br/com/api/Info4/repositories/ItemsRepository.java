package br.com.api.Info4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.Info4.entities.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
