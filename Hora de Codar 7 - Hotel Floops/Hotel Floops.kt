package Hotel

import `Hora de Codar 7 - Hotel Terabithia`.menuQuartos
import `Hora de Codar 7 - Hotel Terabithia`.menuAbastecimento
import `Hora de Codar 7 - Hotel Terabithia`.menuEventos
import `Hora de Codar 7 - Hotel Terabithia`.menuAr

val hotel = "Floops"
const val senha = 2678 // Constante com a senha correta
var nomeHosp: String = ""
val quartos = Array(20) { true } // Array de 20 quartos, inicialmente todos livres (true = livre)

fun main() {
    // Função principal que chama a função inicio().
    iniciar()
}

fun iniciar() {
    println("Bem Vindo(a) ao Hotel $hotel")
    print("Como gostaria de ser chamado(a)? ")
    nomeHosp = readln()
    println("Bem vindo(a) ao Hotel $hotel, $nomeHosp É um imenso prazer ter você por aqui!")
    println("Sua senha de acesso é 2678 guarde-a com segurança")

    menu()
}

fun validarSenha(): Boolean {
    print("Digite sua senha: ")
    val senhaDigi = readln().toInt()
    return senhaDigi == senha
}

fun menu() {
    println("--- Menu ---")
    println("1) Cadastrar Hóspedes")
    println("2) Reservar Quartos")
    println("3) Abastecimento de Automóveis")
    println("4) Eventos")
    println("5) Manutenção de Ar-Condicionado")
    println("6) Sair Do Hotel")
    print("$nomeHosp Escolha uma das opções: ")

    val escolha = readln().toIntOrNull()

    when (escolha) {
        1 -> cadastrarHospedes()
        2 -> menuQuartos()
        3 -> menuAbastecimento()
        4 -> menuEventos()
        5 -> menuAr()
        6 -> sairDoHotel()
        else -> erro()
    }
}

fun cadastrarHospedes() {
    if (!validarSenha()) {
        println("Senha incorreta!")
        menu()
        return
    }

    println("\n--- Cadastro de Hóspedes ---")
    // Implementação do cadastro de hóspedes aqui
    println("Funcionalidade de cadastro de hóspedes será implementada aqui.")
    menu()
}

fun sairDoHotel() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toBoolean() // digite true ou false ou 1 ou 0
    if (confirma) {
        println("Muito obrigado e até logo, $nomeHosp")
    } else {
        menu()
    }
}

fun erro() {
    println("Por favor, informe um número entre 1 e 6.")
    menu()
}