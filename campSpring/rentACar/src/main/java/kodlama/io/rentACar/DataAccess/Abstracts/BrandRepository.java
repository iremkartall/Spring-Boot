package kodlama.io.rentACar.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.Entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
			boolean existsByName(String name);
}
