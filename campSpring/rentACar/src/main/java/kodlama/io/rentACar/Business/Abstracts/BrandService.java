package kodlama.io.rentACar.Business.Abstracts;

import java.util.List;

import kodlama.io.rentACar.Business.requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.Business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.Business.response.GetByIdResponse;

public interface BrandService {
        List<GetAllBrandsResponse> getAll();
        GetByIdResponse getById(int id);
        void add(CreateBrandRequest createBrandRequest);
        void update(UpdateBrandRequest updateBrandRequest);
        void delete(int id);
}
