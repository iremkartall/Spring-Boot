package kodlama.io.rentACar.WebApi.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import kodlama.io.rentACar.Business.Abstracts.ModelService;
import kodlama.io.rentACar.Business.requests.CreateModelRequest;
import kodlama.io.rentACar.Business.response.GetAllModelsResponse;

@RestController
@RequestMapping("/api/models")

public class ModelController {
	private ModelService modelService;
	
	@GetMapping()
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid	CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}

}
