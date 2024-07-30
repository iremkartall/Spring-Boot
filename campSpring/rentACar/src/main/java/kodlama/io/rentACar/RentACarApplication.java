package kodlama.io.rentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessExceptions;
import kodlama.io.rentACar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.utilities.exceptions.ValidationProblemDetail;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessExceptions businessExceptions) {
		ProblemDetails problemDetails = new  ProblemDetails();
		problemDetails.setName(businessExceptions.getMessage());
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetail validationProblemDetail=new ValidationProblemDetail();
		validationProblemDetail.setMessage("VALİDATİON.EXCEPTİON");
		validationProblemDetail.setValidationErrors(new HashMap<String, String>());
		
		for(FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetail.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
			
		}
		return validationProblemDetail;
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	

}
