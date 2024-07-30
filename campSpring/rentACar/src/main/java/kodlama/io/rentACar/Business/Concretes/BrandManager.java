package kodlama.io.rentACar.Business.Concretes;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.Business.Abstracts.BrandService;
import kodlama.io.rentACar.Business.requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.Business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.Business.response.GetByIdResponse;
import kodlama.io.rentACar.Business.rules.BrandBusinessRules;
import kodlama.io.rentACar.DataAccess.Abstracts.BrandRepository;
import kodlama.io.rentACar.Entities.concretes.Brand;
import kodlama.io.rentACar.core.utilities.mapper.ModelMapperService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService mapperService;
	private BrandBusinessRules brandBusinessRules;
	




	@Override
	public  List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = (brandRepository).findAll();
//		List<GetAllBrandsResponse> brandsResponses=new ArrayList<GetAllBrandsResponse>();
//		
//		for(Brand brand:brands) {
//			GetAllBrandsResponse responseItem= new GetAllBrandsResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			
//			brandsResponses.add(responseItem);
//		}
		List<GetAllBrandsResponse> brandsResponses=brands.stream().map(brand->this.mapperService.forResponse()
				.map(brands, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return brandsResponses;
		
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
//		Brand brand= new Brand();
//		brand.setName(createBrandRequest.getName());
		this.brandBusinessRules.checkIfExists(createBrandRequest.getName());
		Brand brand = mapperService.forRequest()
				.map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand= this.mapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}


	@Override
	public GetByIdResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdResponse response=this.mapperService.forResponse().map(brand, GetByIdResponse.class);
		
			return response;
	}


	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);	}


	


	
	

}
