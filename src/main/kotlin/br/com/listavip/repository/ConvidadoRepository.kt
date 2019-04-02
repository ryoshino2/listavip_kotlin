package br.com.listavip.repository

import br.com.listavip.model.Convidado
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ConvidadoRepository : CrudRepository <Convidado, Long>{
    fun findByNomeIgnoreCase(nome:String) : List<Convidado>
}