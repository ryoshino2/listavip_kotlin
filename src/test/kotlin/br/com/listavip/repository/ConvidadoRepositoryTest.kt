package br.com.listavip.repository

import br.com.listavip.model.Convidado
import io.kotlintest.shouldBe
import io.kotlintest.specs.AnnotationSpec
import org.junit.Assert
import org.springframework.beans.factory.annotation.Autowired


class ConvidadoRepositoryTest : AnnotationSpec() {

    @Autowired
    private val convidadoRepository: ConvidadoRepository? = null

    @Test
    fun testSaveConvidado() {
        val convidado = Convidado("banana", "rafael@r.com.br", "123")
        convidadoRepository?.save(convidado)
        "banana" shouldBe convidado.nome
    }
}
