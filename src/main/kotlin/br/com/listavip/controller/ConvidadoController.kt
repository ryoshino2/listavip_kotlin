package br.com.listavip.controller

import br.com.listavip.model.Convidado
import br.com.listavip.service.ConvidadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
class ConvidadoController {

    @Autowired
    private var convidadoService: ConvidadoService? = null

    @GetMapping("/")
    fun index(): ModelAndView {
        return ModelAndView("index")
    }

    @RequestMapping("/listaconvidados")
    fun listarConvidados(): ModelAndView {
        val modelAndView = ModelAndView("listaconvidados")
        val convidados = convidadoService!!.obterTodos()
        modelAndView.addObject("convidados", convidados)
        return modelAndView
    }

    @PostMapping(value = ["salvar"])
    fun salvar(convidado: Convidado): ModelAndView {
        val modelAndView = ModelAndView("listaconvidados")
        convidadoService?.salvarConvidado(convidado)

        val convidados: Iterable<Convidado>? = convidadoService?.obterTodos()
        modelAndView.addObject("convidados", convidados)
        return modelAndView
    }

    @GetMapping("/listaconvidados/{id}")
    fun findById(@PathVariable("id") id: Long): ModelAndView {
        val modelAndView = ModelAndView("listaconvidados")
        val convidados = convidadoService?.obterPorId(id)
        modelAndView.addObject("convidados", convidados)
        return modelAndView
    }

    @GetMapping("/{nome}")
    fun findByName(@PathVariable("nome") nome: String): ModelAndView {
        val modelAndView = ModelAndView("listaconvidados")
        modelAndView.addObject("convidados", convidadoService?.obterPorNome(nome))
        return modelAndView
    }

    @GetMapping("/listaconvidados/delete/{id}")
    fun deleteById(@PathVariable("id") id: Long): String {
        convidadoService?.excluirPorId(id)
        return "redirect:/listaconvidados"
    }
}