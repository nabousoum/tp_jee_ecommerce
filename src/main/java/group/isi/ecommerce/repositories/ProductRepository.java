package group.isi.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductRepository,String> {
    Optional<ProductRepository> findByRef(String ref);
    Optional<ProductRepository> findByName(String name);
    //Optional<ProductRepository> findAll();
}
