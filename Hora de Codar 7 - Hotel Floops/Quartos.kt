package `Hora de Codar 7 - Hotel Terabithia`

import Hotel.*

fun menuQuartos() {
    println("Menu: ")
    println("1) Verificar Disponibilidade de Quartos")
    println("2) Reservar Quarto")
    println("3) Liberar Quarto")
    println("4) Sair Quartos")

    print("$nomeHosp Escolha uma das opções: ")

    val escolha = readln().toIntOrNull()

    when (escolha) { //WHEN é uma ferramenta versátil para lidar com múltiplos casos
        1 -> verificarDisponibilidade()
        2 -> reservarQuarto()
        3 -> liberarQuarto()
        4 -> sairQuartos()
        else -> erroQuartos()
    }
}

fun verificarDisponibilidade() { //Parênteses vazios indicam que a função não recebe parâmetros.
    println("--- Disponibilidade de Quartos ---")
    val quartosLivres = quartos.count { it } // Conta quantos quartos estão livres (onde IT é TRUE)
    //COUNT: é uma função que conta quantos elementos atendem à condição
    //{ it }: Lambda (função anônima) que:
    //IT: representa cada elemento do array quartos.
    //Se IT for TRUE, o elemento é contabilizado.

    println("Total de quartos livres: $quartosLivres de ${quartos.size}") //Mostra o total de quartos livres e o total geral de quartos
    // Exemplo: "Total de quartos livres: 15 de 20"
    //quartos é o array que guarda o estado de todos os quartos

    println("Status dos quartos:")
    //Loop para Percorrer os Quartos
    for (i in quartos.indices) { //quartos.indices: Retorna um intervalo de 0 até quartos.size - 1 (19, no caso).
        //i: Variável temporária que armazena o índice atual.

        val status = if (quartos[i]) "Livre"
        else "Ocupado" //if (quartos[i]): Verifica se o valor do quarto na posição i é true (livre). //quartos[i]: Acessa o elemento do array na posição i.
        //Se quartos[i] for true, atribui "Livre" a status // Se for false, atribui "Ocupado".

        println("Quarto ${i + 1}: $status") //i + 1: Como arrays começam em 0, soma 1 para exibir quartos de 1 a 20. //$status: Insere o valor da variável status ("Livre" ou "Ocupado").

        //Fluxo de Execução (Passo a Passo)
        //A função é chamada (ex.: quando usuário digita 1 no menu).
        //Imprime o título "--- Disponibilidade de Quartos ---".
        //Conta quantos true existem no array quartos (quartos livres).
        //Exibe o total (ex.: "Total de quartos livres: 15 de 20").
        //Imprime o cabeçalho "Status dos quartos:" com uma linha em branco antes (\n).
        //Para cada quarto (de 0 a 19):
        //Verifica se está livre (true) ou ocupado (false).
        //Atribui "Livre" ou "Ocupado" à variável status.
        //Imprime "Quarto X: Livre/Ocupado" (onde X é i + 1).
        //Chama menu() para retornar ao menu principal.

        //OBS IMPORTANTES
        //Array quartos: É declarado globalmente como val quartos = Array(20) { true }.
        //Inicializado com true em todas as posições (todos livres no início).
        //Alternativa para Evitar Recursão:
        //Substituir menu() no final por um loop while no main() (como mostrado em respostas anteriores).
        //Clareza do Código:
        //Nomes descritivos (quartosLivres, status) facilitam o entendimento.
        //Uso de println para organizar a saída no console.
        //Espero que esta explicação ultradetalhada tenha esclarecido cada aspecto da função!
    }

    menuQuartos()
}

fun reservarQuarto() {
    println("--- Reservar Quarto ---")

    print("Digite o número do quarto que deseja reservar entre (1-20): ")
    val numeroQuarto = readln().toIntOrNull() ?: 0

    if (numeroQuarto !in 1..20) {
        println("Número de quarto inválido!")
    } else if (!quartos[numeroQuarto - 1]) {
        println("Quarto $numeroQuarto já está ocupado!")
    } else {
        quartos[numeroQuarto - 1] = false
        println("Quarto $numeroQuarto reservado com sucesso!")
    }

    menuQuartos()
}

fun liberarQuarto() {
    println("\n--- Liberar Quarto ---")
    print("Digite o número do quarto que deseja liberar (1-20): ")
    val numeroQuarto = readln().toIntOrNull() ?: 0

    if (numeroQuarto !in 1..20) {
        println("Número de quarto inválido!")
    } else if (quartos[numeroQuarto - 1]) {
        println("Quarto $numeroQuarto já está livre!")
    } else {
        quartos[numeroQuarto - 1] = true
        println("Quarto $numeroQuarto liberado com sucesso!")
    }

    menuQuartos()
}

fun sairQuartos() {
    println("Você deseja sair?\n Informe 1 para \"sim\" e 0 para \"não\"")
    val confirma = readln().toBoolean() // digite true ou false ou 1 ou 0
    if (confirma) {
        println("Muito obrigado e até logo, $nomeHosp")
    } else {
        menuQuartos()
    }
}
fun erroQuartos() {
    println("Por favor, informe um número entre 1 e 3.")
    menuQuartos()
}