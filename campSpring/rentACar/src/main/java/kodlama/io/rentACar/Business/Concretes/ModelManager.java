package kodlama.io.rentACar.Business.Concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import kodlama.io.rentACar.Business.Abstracts.ModelService;
import kodlama.io.rentACar.Business.requests.CreateModelRequest;
import kodlama.io.rentACar.Business.response.GetAllModelsResponse;
import kodlama.io.rentACar.DataAccess.Abstracts.ModelRepository;
import kodlama.io.rentACar.Entities.concretes.Model;
import kodlama.io.rentACar.core.utilities.mapper.ModelMapperService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

			private ModelRepository modelRepository;
			private ModelMapperService modelMapperService;
		@Override
		public List<GetAllModelsResponse> getAll() {
			List<Model> models = modelRepository.findAll();
			List<GetAllModelsResponse> modelsResponses=models.stream().map(model->this.modelMapperService.forResponse()
					.map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
			return modelsResponses;
		}
		@Override
		public void add(CreateModelRequest createModelRequest) {
			Model model=this.modelMapperService.forRequest().map(createModelRequest,Model.class);
			
			this.modelRepository.save(model);
			
		}
	

}
