package br.com.listavip.service

import br.com.listavip.model.Convidado
import br.com.listavip.repository.ConvidadoRepository
import io.kotlintest.shouldBe
import io.kotlintest.specs.AnnotationSpec
import org.springframework.beans.factory.annotation.Autowired

class ConvidadoServiceTest : AnnotationSpec(){

    @Autowired
    private val convidadoRepository : ConvidadoRepository? = null

    private val convidadoService :ConvidadoService? = null
    private val convidado = Convidado("ana", "ana@julia.com", "123")

    @Test
    fun testSaveConvidado(){
        convidadoService?.salvarConvidado(convidado)
        val convidado1 = convidado
        convidado shouldBe convidado1
    }

}