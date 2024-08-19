package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class Main {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuario_logado;
    private static Cinema cinema_selecionado;
    private static ArrayList<Cinema> cinemas = new ArrayList<>();
    private static ArrayList<Midia> midias = new ArrayList<>();
    private static ArrayList<Pagamento> pagamentos = new ArrayList<>();

    public static void main(String[] args) {
        definicoesIniciais(); // Aqui são feitas as definições inicias como cadastro do cinema, salas, adm etc

        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            exibirMenuLogin();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    login(scanner);
                    if (usuario_logado != null) { // Usuario Logado, o próximo menu pode ser acessado
                        option = 0;
                    }
                    break;
                case 2:
                    cadastrarCliente(scanner);
                    if (usuario_logado != null) { // Usuario Logado, o próximo menu pode ser acessado
                        option = 0;
                    }
                    break;
                case 0:
                    logout();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);

        exibirMenuPrincipal(scanner);

        scanner.close();
    }

    public static void exibirMenuPrincipal(Scanner scanner) {

        int option;

        do {

            if (usuario_logado instanceof Cliente) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Mídias");
                System.out.println("2. Sessões");
                System.out.println("3. Ingressos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        exibirMenuMidias(scanner);
                        break;
                    case 2:
                        exibirMenuSessoes(scanner);
                        break;
                    case 3:
                        exibirMenuIngressos(scanner);
                        break;
                    case 0:
                        logout();
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } else {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Usuarios");
                System.out.println("2. Mídias");
                System.out.println("3. Sessões");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        exibirMenuUsuarios(scanner);
                        break;
                    case 2:
                        exibirMenuMidias(scanner);
                        break;
                    case 3:
                        exibirMenuSessoes(scanner);
                        break;
                    case 0:
                        logout();
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            }
        } while (option != 0);
    }

    public static void exibirMenuLogin() {
        System.out.println("\n--- Cine Lumiére ---");
        System.out.println("1. Login");
        System.out.println("2. Cadastro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.println("\n--- Novo cliente ---");
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite o seu cpf: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Deveria ter uma validação se este email/cpf já existe

        Cliente cliente = new Cliente(cpf, email, senha);

        usuarios.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");

        usuario_logado = cliente;
    }

    private static void login(Scanner scanner) {
        System.out.println("\n--- Login ---");
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        for (Usuario user : usuarios) { // Aplicação de polimorfismo , neste caso, o usuário pode ser adm ou cliente
            if (user.getEmail().equals(email) && user.checkSenha(senha)) {
                System.out.println("Login bem-sucedido!");
                usuario_logado = user;
                return;
            }
        }
        System.out.println("Nome de usuário ou senha incorretos.");
    }

    private static void exibirMenuMidias(Scanner scanner) {
        int option;

        do {
            if (usuario_logado instanceof Cliente) {

                // Aqui opções que serão exibidas para o cliente

                System.out.println("\n--- Midias ---");
                System.out.println("1. Exibir catálogo");
                // Pode ter mais opções
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        exibirCatalogo();
                        break;
                    case 0:
                        System.out.println("Voltando ...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } else {
                // Aqui opções que serão exibidas para o administrador

                System.out.println("\n--- Midias ---");
                System.out.println("1. Exibir catálogo");
                System.out.println("2. Cadastrar mídia");
                // Pode ter mais opções
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        exibirCatalogo();
                        break;
                    case 2:
                        exibirMenuCadastroMidia(scanner);
                        break;
                    case 0:
                        System.out.println("Voltando ...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            }
        } while (option != 0);
    }

    private static void exibirMenuSessoes(Scanner scanner) {
        int option = 0;
        do {
            if (cinema_selecionado == null) {
                exibirMenuCinema(scanner);
            }

            if (usuario_logado instanceof Cliente) {
                // Opções para o cliente
                System.out.println("\n--- Sessões ---");
                System.out.println("- " + cinema_selecionado.getNome() + " -");
                System.out.println("1. Exibir sessões");
                System.out.println("2. Comprar ingresso");
                System.out.println("3. Trocar cinema");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        exibirSessoes(scanner);
                        break;
                    case 2:
                        exibirMenuCompraIngressos(scanner);
                        break;
                    case 3:
                        exibirMenuCinema(scanner);
                        break;
                    case 0:
                        System.out.println("Voltando ...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } else {
                // Opções para o administrador
                System.out.println("\n--- Sessões ---");
                System.out.println("- " + cinema_selecionado.getNome() + " -");
                System.out.println("1. Exibir sessões");
                System.out.println("2. Cadastrar sessão");
                System.out.println("3. Gerenciar sessões");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        exibirSessoes(scanner);
                        break;
                    case 2:
                        exibirMenuCadastroSessao(scanner);
                        break;
                    case 3:
                        // Opção para gerenciar sessões (alterar/excluir)
                        break;
                    case 0:
                        System.out.println("Voltando ...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } while (option != 0);
    }

    private static void exibirSessoes(Scanner scanner) {
        if (usuario_logado instanceof Cliente) {
            System.out.println("\n--- Sessões Disponíveis ---");
            for (Sala sala : cinema_selecionado.getSalas()) {
                System.out.println("\nSala " + sala.getNumero() + ":");
                if (sala.getSessoes().isEmpty()) {
                    System.out.println("Nenhuma sessão disponível.");
                } else {
                    for (Sessao sessao : sala.getSessoes()) {
                        System.out.println(sessao);
                    }
                }
            }
        } else {
            for (Cinema cinema : cinemas) {
                System.out.println("\nCinema " + cinema.getNome() + ":");
                System.out.println("\nSala " + cinema.getSalas() + ":");
                for (Sala Sala : cinema.getSalas()) {
                    System.out.println("\nSala " + Sala.getNumero() + ":");
                    if (Sala.getSessoes().isEmpty()) {
                        System.out.println("Nenhuma sessão disponível.");
                    } else {
                        for (Sessao sessao : Sala.getSessoes()) {
                            System.out.println(sessao);
                        }
                    }

                }
            }
        }
    }

    private static void exibirMenuCadastroSessao(Scanner scanner) {
        System.out.println("\n--- Cadastro de Sessão ---");

        System.out.println("Salas disponíveis no " + cinema_selecionado.getNome() + ":");
        for (int i = 1; i <= cinema_selecionado.getSalas().size(); i++) {
            Sala sala = cinema_selecionado.getSalas().get(i - 1);
            System.out.println(i + ". Sala " + sala.getNumero());
        }

        System.out.print("Escolha uma sala: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine();
        Sala salaSelecionada = cinema_selecionado.getSalas().get(numeroSala - 1);

        System.out.println("\n--- Selecione a Mídia ---");
        for (int i = 1; i <= midias.size(); i++) {
            System.out.println(i + ". " + midias.get(i - 1).getTitulo());
        }

        System.out.print("Escolha uma mídia: ");
        int numeroMidia = scanner.nextInt();
        scanner.nextLine();
        Midia midiaSelecionada = midias.get(numeroMidia - 1);

        System.out.print("Informe a data da sessão (ano-mês-dia, por exemplo 2024-07-31): ");
        String dataInput = scanner.nextLine();
        LocalDate dataSessao = LocalDate.parse(dataInput);

        System.out.print("Informe o horário da sessão (HH:mm, por exemplo 16:40): ");
        String horarioInput = scanner.nextLine();
        LocalTime horarioSessao = LocalTime.parse(horarioInput);

        Sessao novaSessao = new Sessao(salaSelecionada, midiaSelecionada, dataSessao, horarioSessao);
        salaSelecionada.adicionarSessao(novaSessao);

        System.out.println("Sessão cadastrada com sucesso!");
    }

    private static void exibirMenuIngressos(Scanner scanner) {
        int option;

        do {
            System.out.println("\n--- Ingressos ---");
            System.out.println("1. Meus ingressos");
            // Pode ter mais opções
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    exibirCompras();
                    break;
                case 0:
                    System.out.println("Voltando ...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }

    // Aqui deve conter qualquer operação que deve ser feita quando o cliente sair
    // do sistema
    private static void logout() {
        System.out.println("Saindo...");
    }

    private static void exibirMenuCinema(Scanner scanner) {
        cinema_selecionado = null;

        int option;

        System.out.println("\n--- Selecione o cinema quer quer visualizar ---");

        for (int i = 1; i <= cinemas.size(); i++) {
            Cinema cinema = cinemas.get(i - 1);
            System.out.print("1. ");
            cinema.exibirDetalhes();
        }

        do {

            option = scanner.nextInt();
            scanner.nextLine();

            if (option <= cinemas.size()) {
                cinema_selecionado = cinemas.get(option - 1);
                System.out.println("Cinema selecionado: " + cinema_selecionado.getNome());
                return;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (cinema_selecionado != null);
    }

    private static void definicoesIniciais() {
        Cinema cinema1 = new Cinema("Cine Lumière - Salvador Shopping",
                "Av. Tancredo Neves, 3133 - Caminho das Árvores, Salvador");
        Sala sala1 = new Sala(cinema1, 01);
        Sala sala2 = new Sala(cinema1, 02);
        cinema1.adicionarSala(sala1);
        cinema1.adicionarSala(sala2);
        cinemas.add(cinema1);

        Administrador adm = new Administrador("12345678900", "adm@email", "12345");
        usuarios.add(adm);

        Cliente cliente = new Cliente("00987654321", "client1@email", "12345");
        usuarios.add(cliente);

        Filme filme1 = new Filme("A Mosca", 96,
                "O excêntrico cientista Seth Brundle completa seu dispositivo de teletransporte e decide testar a eficácia do experimento em si próprio. Sem que ele perceba, uma mosca cai no aparelho durante o processo e provoca uma fusão dele com o inseto. Contudo, ele pensa que o experimento foi um sucesso, até que começa a notar que as células da mosca estão tomando conta de seu corpo, e ele acaba se transformando em uma criatura monstruosa.",
                "David Cronenberg", "Jeff Goldblum, Geena Davis", 1986, "14 anos", "EUA");

        Documentario documentario1 = new Documentario("Paris is Burning", 78,
                "Uma crônica da cena drag queen nova-iorquina dos anos 1980, focando nos bailes, dança vogue, ambições e sonhos daqueles que proporcionaram calor e vitalidade para uma era.",
                "Jennie Livingston", 1990, "18 anos", "EUA");

        midias.add(filme1);
        midias.add(documentario1);

        Sessao sessao1 = new Sessao(sala1, filme1, LocalDate.of(2024, 07, 31), LocalTime.of(16, 40));
        sala1.adicionarSessao(sessao1);
    }

    private static void exibirMenuUsuarios(Scanner scanner) {
        int option;

        do {
            System.out.println("\n--- Usuários ---");
            System.out.println("1. Listar usuários do sistema");
            System.out.println("2. Visualizar usuário");
            // Pode ter mais opções
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("\n--- usuários ativos---");
                    for (Usuario user : usuarios) { // Aplicação de polimorfismo , neste caso, o usuário pode ser adm ou
                        // cliente
                        System.out.println(" - " + user.getEmail() + " (" + user.getCpf() + ")");
                    }
                    break;
                case 2:

                    break;
                case 0:
                    System.out.println("Voltando ...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 0);
    }

    private static void exibirCatalogo() {
        System.out.println("\n--- Catálogo Cine Lumiere ---");
        for (Midia midia : midias) {
            System.out.print(" - ");
            midia.exibirDetalhes();
            System.out.print("\n");
        }
    }

    private static void exibirMenuCadastroMidia(Scanner scanner) {
        System.out.println("\n--- Cadastro de Mídia ---");
        System.out.print("Selecione o tipo de mídia: \n1 - Filme \n2 - Documentário\n");
        int categoria = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Duração (em minutos): ");
        int duracaoEmMinutos = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();
        System.out.print("Diretor: ");
        String diretor = scanner.nextLine();
        System.out.print("Ano de Lançamento: ");
        int anoDeLancamento = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Classificação Indicativa: ");
        String classificacaoIndicativa = scanner.nextLine();
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();

        if (categoria == 1) {
            System.out.print("Elenco: ");
            String elenco = scanner.nextLine();
            Filme filme = new Filme(titulo, duracaoEmMinutos, sinopse, diretor, elenco, anoDeLancamento,
                    classificacaoIndicativa, nacionalidade);
            midias.add(filme);
            System.out.println("Filme cadastrado com sucesso!");
        } else if (categoria == 2) {
            Documentario documentario = new Documentario(titulo, duracaoEmMinutos, sinopse, diretor, anoDeLancamento,
                    classificacaoIndicativa, nacionalidade);
            midias.add(documentario);
            System.out.println("Documentário cadastrado com sucesso!");
        } else {
            System.out.println("Categoria inválida. Mídia não cadastrada.");
        }
    }

    private static void exibirMenuCompraIngressos(Scanner scanner) {

        int option;
        Sessao sessao_selecionada = null;

        do {

            System.out.println("\n--- Selecão de sessão ---");

            for (int i = 0; i < cinema_selecionado.getSessoes().size(); i++) {
                Sessao sessao = cinema_selecionado.getSessoes().get(i);
                System.out.println("\n" + (i + 1) + ". Sala " + sessao.getSala().getNumero() + " - "
                        + sessao.getMidia().getTitulo() + " (" + sessao.getHorario() + " " + sessao.getData() + ")");
            }

            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 0) {
                System.out.println("Voltando ...");
                return;
            }

            if (option - 1 > cinema_selecionado.getSessoes().size() || option < 0) {
                System.out.println("\nOpção inválida. Tente novamente.");
            } else {
                sessao_selecionada = cinema_selecionado.getSessoes().get(option - 1);
            }
        } while (sessao_selecionada == null);

        System.out.println("\n Sessão Selecionada: " + sessao_selecionada.toString() + "\n");

        Poltrona poltrona_selecionada = null;

        do {

            System.out.println("\n--- Selecão de poltrona ---");

            sessao_selecionada.exibirPoltronas();

            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 0) {
                sessao_selecionada = null;
                System.out.println("Voltando ...");
                return;
            }

            if (option < 0 || option > sessao_selecionada.getPoltronas().size()) {
                System.out.println("\nOpção inválida. Tente novamente.");
            } else {
                Poltrona poltrona = sessao_selecionada.getPoltronas().get(option - 1);
                if (poltrona.isDisponivel()) {
                    poltrona_selecionada = poltrona;
                    poltrona_selecionada.setDisponivel(false);
                } else {
                    System.out.println("\nPoltrona indisponível");
                }
            }

        } while (poltrona_selecionada == null);

        System.out.println("\n Poltrona Selecionada: " + poltrona_selecionada.getCodigo() + "\n");

        String metodo_pagamento = "";

        do {

            System.out.println("\n--- Método de pagamento ---");

            System.out.println("\nValor do ingresso: R$ 5\n");

            System.out.println("1. PIX");
            System.out.println("2. Credito");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    metodo_pagamento = "PIX";
                    break;
                case 2:
                    metodo_pagamento = "Crédito";
                    break;
                case 0:
                    sessao_selecionada = null;
                    poltrona_selecionada = null;
                    System.out.println("Voltando ...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (metodo_pagamento == "");

        Ingresso ingresso = new Ingresso(Integer.parseInt(poltrona_selecionada.getCodigo()), sessao_selecionada,
                poltrona_selecionada, 5);

        ArrayList<Ingresso> ingressos = new ArrayList<>();

        ingressos.add(ingresso);

        Pagamento pagamento = new Pagamento(5, (Cliente) usuario_logado, ingressos, metodo_pagamento);

        pagamentos.add(pagamento);

        Cliente cliente = (Cliente) usuario_logado;

        cliente.getCompras().add(ingresso);

        System.out.println("\nCompra efetuada com sucesso!\n");
    }

    private static void exibirCompras() {
        System.out.println("\n--- Ingressos comprados ---");

        Cliente cliente = (Cliente) usuario_logado;

        for (Ingresso ingresso : cliente.getCompras()) {
            Sessao sessao = ingresso.getSessao();
            System.out.println("Título: " + sessao.getMidia().getTitulo());
            System.out.println("Data: " + sessao.getData());
            System.out.println("Horário: " + sessao.getHorario());
            System.out.println("Sala: " + sessao.getSala().getNumero());
            System.out.println("Poltrona: " + ingresso.getPoltrona().getCodigo());
            System.out.println("----------------------");
        }
    }
}
