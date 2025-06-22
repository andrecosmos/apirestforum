package forum.vel.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erro = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(DtoErro::new).toList());
    }

    public  record DtoErro (String campo, String mensagem){

        public DtoErro (FieldError erro){
           this(erro.getField(), erro.getDefaultMessage());
        }
    }


}
