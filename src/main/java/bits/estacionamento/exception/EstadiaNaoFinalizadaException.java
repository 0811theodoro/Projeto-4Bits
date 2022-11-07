package bits.estacionamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "A estadia não foi finalizada")
public class EstadiaNaoFinalizadaException extends RuntimeException {
}
