package kodlama.io.rentACar.Business.Abstracts;

import java.util.List;

import kodlama.io.rentACar.Business.requests.CreateModelRequest;
import kodlama.io.rentACar.Business.response.GetAllModelsResponse;

public interface ModelService {
		
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
