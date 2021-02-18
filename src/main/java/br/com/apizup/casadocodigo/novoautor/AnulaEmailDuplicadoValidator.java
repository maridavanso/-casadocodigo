/*
 * package br.com.apizup.casadocodigo.novoautor;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component; import
 * org.springframework.validation.Errors; import
 * org.springframework.validation.Validator;
 * 
 * 
 * 
 * @Component public class AnulaEmailDuplicadoValidator implements Validator{
 * 
 * @Autowired private AutorRepository autorRepository;
 * 
 * @Override public boolean supports(Class<?> clazz) {
 * 
 * return NovoAutorRequest.class.isAssignableFrom(clazz); }
 * 
 * @Override public void validate(Object target, Errors errors) {
 * 
 * if(errors.hasErrors()) { return; } NovoAutorRequest request =
 * (NovoAutorRequest) target; Optional<Autor> autorExistente =
 * autorRepository.findByEmail(request.getEmail());
 * 
 * if (autorExistente.isPresent()) { errors.rejectValue("email", null,
 * "Esse email já existe " + request.getEmail()); } }
 * 
 * }
 */