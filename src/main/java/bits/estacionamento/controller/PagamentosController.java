package bits.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bits.estacionamento.entity.Estadia;
import bits.estacionamento.entity.TipoPlano;
import bits.estacionamento.exception.EstadiaNaoEncontradaException;
import bits.estacionamento.repository.EstadiasRepository;

@Controller
public class PagamentosController {

  @Autowired
  private EstadiasRepository estadiasRepository;

  @RequestMapping(value = "/pagamentos/novo", method = RequestMethod.GET)
  public ModelAndView novoPagamento(@RequestParam("estadia_id") Long estadiaId, ModelAndView modelAndView) {
    Estadia estadia = estadiasRepository.findById(estadiaId).orElseThrow(() -> new EstadiaNaoEncontradaException());
    if (estadia.getPlano() == TipoPlano.MENSAL) {
      modelAndView.setViewName("validate-payment-monthly");
    } else {
      modelAndView.setViewName("validate-payment-avulso");
    }
    return modelAndView;
  }
}
