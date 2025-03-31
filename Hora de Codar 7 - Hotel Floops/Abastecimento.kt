package `Hora de Codar 7 - Hotel Terabithia`

import Hotel.*
import kotlin.math.round

fun menuAbastecimento() {
    println("--- Menu de Abastecimento ---")
    println("1) Calcular melhor combustível")
    println("2) Abastecimento do Automovel")
    println("3) Sair de Abastecimento")
    print("$nomeHosp Escolha uma opção: ")

    when (readln().toIntOrNull()) {
        1 -> calcularMlCombustivel()
        2 -> abastecimentoDeAutomoveis()
        3 -> sairAbs()
        else -> {
            println("Opção inválida!")
            erroAbs()
        }
    }
}

fun calcularMlCombustivel() {
    if (!validarSenha()) {
        println("Senha incorreta!")
        menuAbastecimento()
        return
    }

    println("\n--- Cálculo do Melhor Combustível ---")

    // Obter preços do Wayne Oil
    print("Qual o valor do álcool no posto Wayne Oil? ")
    val alcoolWayne = readln().toDouble()
    print("Qual o valor da gasolina no posto Wayne Oil? ")
    val gasolinaWayne = readln().toDouble()

    // Obter preços do Stark Petrol
    print("Qual o valor do álcool no posto Stark Petrol? ")
    val alcoolStark = readln().toDouble()
    print("Qual o valor da gasolina no posto Stark Petrol? ")
    val gasolinaStark = readln().toDouble()

    // Calcular qual combustível é mais vantajoso em cada posto
    val vantagemWayne = calcularVantagem(alcoolWayne, gasolinaWayne)
    val vantagemStark = calcularVantagem(alcoolStark, gasolinaStark)

    // Calcular custo total para 42 litros em cada opção
    val opcoes = listOf(
        OpcaoAbastecimento("álcool", "Wayne Oil", alcoolWayne * 42),
        OpcaoAbastecimento("gasolina", "Wayne Oil", gasolinaWayne * 42),
        OpcaoAbastecimento("álcool", "Stark Petrol", alcoolStark * 42),
        OpcaoAbastecimento("gasolina", "Stark Petrol", gasolinaStark * 42)
    )

    // Encontrar a opção mais barata
    val melhorOpcao = opcoes.minByOrNull { it.custoTotal }!!

    // Exibir resultado
    println("\n$nomeHosp, é mais barato abastecer com ${melhorOpcao.combustivel} no posto ${melhorOpcao.posto}.")
    println("Custo total para 42 litros: R$ ${round(melhorOpcao.custoTotal * 100) / 100}")

    menuAbastecimento()
}

fun calcularVantagem(precoAlcool: Double, precoGasolina: Double): String {
    val porcentagemMaisBarato = (precoGasolina - precoAlcool) / precoGasolina * 100
    return if (porcentagemMaisBarato >= 30) "álcool" else "gasolina"
}

data class OpcaoAbastecimento(
    val combustivel: String,
    val posto: String,
    val custoTotal: Double
)

fun abastecimentoDeAutomoveis() {
    if (!validarSenha()) {
        println("Senha incorreta!")
        menuAbastecimento()
        return
    }

    println("--- Abastecimento de Automóveis ---")
    calcularMlCombustivel()
}

fun sairAbs() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toBoolean() // digite true ou false ou 1 ou 0
    if (confirma) {
        println("Muito obrigado e até logo, $nomeHosp")
    } else {
        menu()
    }
}

fun erroAbs() {
    println("Por favor, informe um número entre 1 e 3.")
    menuAbastecimento()
}