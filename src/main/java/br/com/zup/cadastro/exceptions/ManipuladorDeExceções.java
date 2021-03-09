package br.com.zup.cadastro.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorDeExceções extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjetoDeErro> objetosDeErro = getErros(ex);
        RespostaDeErro resErro = new RespostaDeErro("Validação", status.value(),
                status.getReasonPhrase(), objetosDeErro);

        return ResponseEntity.status(status).body(objetosDeErro);
    }
    private List<ObjetoDeErro> getErros(MethodArgumentNotValidException exception) {
        List<ObjetoDeErro> objetoDeErros = exception.getBindingResult().getFieldErrors().stream()
                .map(erro -> new ObjetoDeErro(erro.getDefaultMessage(), erro.getField()))
                .collect(Collectors.toList());

        return objetoDeErros;

    }

    @ExceptionHandler({CadastroNaoEncontradoException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaDeErro manipularRuntimeException(CadastroNaoEncontradoException erro){
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(erro.getMessage(), erro.getCampo());
        RespostaDeErro respostaDeErro = new RespostaDeErro(erro.getTipoErro(), erro.getStatus(), erro.getRazao(),
                Arrays.asList(objetoDeErro));

        return respostaDeErro;
    }
}
