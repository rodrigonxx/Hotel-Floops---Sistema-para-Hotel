package `Hora de Codar 7 - Hotel Terabithia`

import Hotel.nomeHosp
import kotlin.system.exitProcess

class `Cadastrar Hospedes Floop` {

    fun cadastrarHospedes() {
        var listaHospedes = mutableListOf(
            "Carlos Villagran",
            "Maria Antonieta de las Nieves",
            "Roberto Gómez Bolaños",
            "Florinda Meza",
            "Ramón Valdés",
            "Rubén Aguirre",
            "Angelines Fernández",
            "Edgar Vivar",
            "Horácio Gómez Bolaños",
            "Raúl Padilla"
        )

        while (true) {
            println("""Cadastro de Hóspedes
        Selecione uma opção:
        1. Cadastrar
        2. Pesquisar
        3. Sair""")

            val escolha = readln().toIntOrNull()

            when (escolha) {
                1 -> cadastrarNovoHospede(listaHospedes)
                2 -> pesquisarHospede(listaHospedes)
                3 -> sairCadastroDeHospedes()
                else -> erroCadastroDeHospedes()
            }
        }
    }

    fun cadastrarNovoHospede(listaHospedes: MutableList<String>) {
        println("Por favor, informe o valor padrão da diária:")
        val diaria = readln().toDouble()

        var gratuidades = 0
        var meias = 0
        var valorTotal = 0.0

        while (true) {
            println("Qual o nome do Hóspede? (Digite 'PARE' para encerrar)")
            val nomeHospede = readln()

            if (nomeHospede.uppercase() == "PARE") {
                break
            }

            println("Qual a idade do Hóspede?")
            val idade = readln().toInt()

            when {
                idade < 6 -> {
                    println("$nomeHospede possui gratuidade")
                    gratuidades++
                }
                idade > 60 -> {
                    println("$nomeHospede paga meia")
                    valorTotal += diaria / 2
                    meias++
                }
                else -> {
                    valorTotal += diaria
                }
            }

            listaHospedes.add(nomeHospede)
            println("$nomeHospede cadastrada(o) com sucesso.")
        }

        println("O valor total das hospedagens é: R$${valorTotal}; $gratuidades gratuidade(s); $meias meia(s)")
    }

    fun pesquisarHospede(listaHospedes: MutableList<String>) {
        println("Pesquisa de Hóspedes.\nPor favor, informe o nome da Hóspede:")
        val nomeHospede = readln()

        if (listaHospedes.any { it.equals(nomeHospede, ignoreCase = true) }) {
            println("Hospede $nomeHospede foi encontrado(a)!")
        } else {
            println("Hóspede não encontrado")
        }
    }

    fun sairCadastroDeHospedes() {
        println("Você deseja sair? S/N")
        val escolha = readln()

        when (escolha.uppercase()) {
            "S" -> {
                println("Ate Logo, $nomeHosp.")
                exitProcess(0)
            }
            "N" -> {
                println("Ok, voltando ao início.")
                cadastrarHospedes()
            }
            else -> {
                println("Desculpe, mas não compreendi.")
                sairCadastroDeHospedes()
            }
        }
    }

    fun erroCadastroDeHospedes() {
        println("Por favor, informe um número entre 1 e 3.")
        cadastrarHospedes()
    }
}