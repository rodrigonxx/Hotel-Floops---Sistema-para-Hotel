package `Hora de Codar 7 - Hotel Terabithia`

import kotlin.math.ceil
import Hotel.nomeHosp
import Hotel.validarSenha
import Hotel.menu

var numeroConvidados = 0
var auditorio = ""
var cadeirasAdicionais = 0
var diaEvento = ""
var horaEvento = 0
var nomeEmpresa = ""
var duracaoEvento = 0
var quantidadeGarcons = 0
var custoGarcons = 0.0
var custoBuffet = 0.0


fun menuEventos() {
    if (!validarSenha()) {
        println("Senha incorreta!")
        menuEventos()
        return
    }

    println("--- Gerenciamento de Eventos ---")
    println("1) Definir quantidade de convidados")
    println("2) Agendar evento")
    println("3) Calcular equipe e custos")
    println("4) Ver resumo do evento")
    println("5) Sair aba Eventos")
    print("Escolha uma opção: ")

    when (readln().toIntOrNull()) {
        1 -> definirQtdConvidados()
        2 -> agendarEvento()
        3 -> calcularEqpeECustos()
        4 -> verResumoEvento()
        5 -> sairEventos()
        else -> {
            println("Opção inválida!")
            menuEventos()
        }
    }
}

fun definirQtdConvidados() {
    println("\n--- Quantidade de Convidados ---")
    print("Quantos convidados para o evento? ")
    numeroConvidados = readln().toInt()

    when {
        numeroConvidados < 0 || numeroConvidados > 350 -> {
            println("Número de convidados inválido!")
            definirQtdConvidados()
        }
        numeroConvidados <= 150 -> {
            auditorio = "Laranja"
            println("Auditório Laranja selecionado")
        }
        numeroConvidados <= 220 -> {
            auditorio = "Laranja"
            cadeirasAdicionais = numeroConvidados - 150
            println("Auditório Laranja selecionado (mais $cadeirasAdicionais cadeiras adicionais)")
        }
        else -> {
            auditorio = "Colorado"
            println("Auditório Colorado selecionado")
        }
    }
    menuEventos()
}

fun agendarEvento() {
    println("\n--- Agendamento do Evento ---")
    print("Qual o dia do evento? ")
    diaEvento = readln().lowercase()

    print("Qual a hora do evento (7-23)? ")
    horaEvento = readln().toInt()

    val disponivel = when (diaEvento) {
        "sabado", "domingo" -> horaEvento in 7..15
        else -> horaEvento in 7..23
    }

    if (!disponivel) {
        println("Auditório indisponível neste horário!")
        agendarEvento()
    } else {
        print("Nome da empresa contratante: ")
        nomeEmpresa = readln()
        println("Agendamento realizado para $nomeEmpresa")
    }
    menuEventos()
}

fun calcularEqpeECustos() {
    println("\n--- Cálculo de Equipe e Custos ---")
    print("Duração do evento em horas: ")
    duracaoEvento = readln().toInt()

    quantidadeGarcons = ceil(numeroConvidados / 12.0).toInt() + ceil(duracaoEvento / 2.0).toInt()
    custoGarcons = quantidadeGarcons * 10.50 * duracaoEvento

    val litrosCafe = numeroConvidados * 0.2
    val litrosAgua = numeroConvidados * 0.5
    val salgados = numeroConvidados * 7
    custoBuffet = (litrosCafe * 0.8) + (litrosAgua * 0.4) + (salgados / 100.0 * 34)

    println("Equipe necessária: $quantidadeGarcons garçons")
    println("Custo total estimado: R$ ${custoGarcons + custoBuffet}")
    menuEventos()
}

fun verResumoEvento() {
    println("\n--- Resumo do Evento ---")
    println("Auditório: $auditorio")
    if (auditorio == "Laranja" && cadeirasAdicionais > 0) {
        println("Cadeiras adicionais: $cadeirasAdicionais")
    }
    println("Empresa: $nomeEmpresa")
    println("Data: ${diaEvento.capitalize()} às ${horaEvento}h")
    println("Duração: $duracaoEvento horas")
    println("Convidados: $numeroConvidados")
    println("Garçons: $quantidadeGarcons (R$ $custoGarcons)")
    println("Custo do buffet: R$ $custoBuffet")
    println("TOTAL: R$ ${custoGarcons + custoBuffet}")

    print("\nConfirmar reserva? (S/N) ")
    if (readln().equals("S", true)) {
        println("Evento confirmado para $nomeEmpresa!")
    } else {
        println("Reserva não confirmada")
    }
    menuEventos()
}

fun sairEventos() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    if (readln().toBoolean()) {
        println("Muito obrigado e até logo $nomeHosp")
    } else {
        menu()
    }
}

fun erroEventos() {
    println("Por favor, informe um número entre 1 e 5.")
    menuEventos()
}