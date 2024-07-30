package kodlama.io.rentACar.Business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.DataAccess.Abstracts.BrandRepository;
import kodlama.io.rentACar.core.utilities.exceptions.BusinessExceptions;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
		private BrandRepository brandRepository;
		
		public void checkIfExists(String name) {
			if(brandRepository.existsByName(name)){
				throw new BusinessExceptions("Brand is already exists");
			}
		}
}
