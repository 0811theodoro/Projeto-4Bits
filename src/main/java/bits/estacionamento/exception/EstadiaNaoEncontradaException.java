package bits.estacionamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Estadia não encontrada")
public class EstadiaNaoEncontradaException extends RuntimeException {
}
