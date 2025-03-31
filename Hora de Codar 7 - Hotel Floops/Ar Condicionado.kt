package `Hora de Codar 7 - Hotel Terabithia`

import Hotel.*
import kotlin.math.round

data class Orcamento(
    val empresa: String,
    val valorTotal: Double
)
fun menuAr() {
    println("--- Menu Ar Condicionado---")
    println("1) Manutencao Ar Condicionado")
    println("2) Orcamento")
    println("3) Sair de Ar Condicionado")
    print("$nomeHosp Escolha uma das opções: ")

    val escolha = readln().toIntOrNull()

    when (escolha) {
        1 -> menuManutencaoAr()
        2 -> calcularOrcamento()
        3 -> sairAr()
        else -> erroAr()
    }
}

fun menuManutencaoAr() {
    if (!validarSenha()) {
        println("Senha incorreta!")
        menu()
        return
    }

    println("\n--- Manutenção de Ar-Condicionado ---")
    val orcamentos = mutableListOf<Orcamento>()

    do {
        val orcamento = calcularOrcamento()
        orcamentos.add(orcamento)

        print("\nDeseja informar novos dados, $nomeHosp? (S/N) ")
        val continuar = readln().equals("S", ignoreCase = true)

        if (!continuar && orcamentos.size < 2) {
            println("É necessário informar pelo menos duas empresas para comparação.")
        }
    } while (continuar || orcamentos.size < 2)

    val menorOrcamento = orcamentos.minByOrNull { it.valorTotal }!!
    println("\nO orçamento de menor valor é o de ${menorOrcamento.empresa} por R$ ${"%.2f".format(menorOrcamento.valorTotal)}")

    menu()
}

fun calcularOrcamento(): Orcamento {
    println("\n--- Novo Orçamento ---")
    print("Qual o nome da empresa? ")
    val empresa = readln()

    print("Qual o valor por aparelho? ")
    val valorUnitario = readln().toDouble()

    print("Qual a quantidade de aparelhos? ")
    val quantidade = readln().toInt()

    print("Qual a porcentagem de desconto? ")
    val descontoPercentual = readln().toDouble()

    print("Qual o número mínimo de aparelhos para conseguir o desconto? ")
    val minimoParaDesconto = readln().toInt()

    var valorTotal = valorUnitario * quantidade

    if (quantidade > minimoParaDesconto) {
        val desconto = valorTotal * (descontoPercentual / 100)
        valorTotal -= desconto
    }

    println("O serviço de $empresa custará R$ ${"%.2f".format(valorTotal)}")

    return Orcamento(empresa, valorTotal)
}

fun sairAr() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toBoolean() // digite true ou false ou 1 ou 0
    if (confirma) {
        println("Muito obrigado e até logo, $nomeHosp")
    } else {
        menuAr()
    }
}

fun erroAr() {
    println("Por favor, informe um número entre 1 e 3.")
    menuAr()
}
