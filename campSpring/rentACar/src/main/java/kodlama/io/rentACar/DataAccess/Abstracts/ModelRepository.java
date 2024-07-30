package kodlama.io.rentACar.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.Entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
		
}
