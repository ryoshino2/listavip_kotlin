package br.com.listavip.service

import br.com.listavip.model.Convidado
import br.com.listavip.repository.ConvidadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConvidadoService(@field:Autowired val convidadoRepository: ConvidadoRepository) {

    fun obterTodos(): Iterable<Convidado> {
        return convidadoRepository.findAll()
    }

    fun salvarConvidado(convidado : Convidado) {
        if (verificarConvidado(convidado)) {
            convidadoRepository.save(convidado)
        }
    }

    fun verificarConvidado(convidado: Convidado) : Boolean{
        return !convidadoRepository.findByNomeIgnoreCase(convidado.nome!!).isNotEmpty()
    }

    fun obterPorId(id:Long): Optional<Convidado> {
        return convidadoRepository.findById(id)
    }

    fun obterPorNome(nome:String): List<Convidado> {
        return convidadoRepository.findByNomeIgnoreCase(nome)
    }

    fun excluirPorId(id:Long) {
        convidadoRepository.deleteById(id)
    }
}
