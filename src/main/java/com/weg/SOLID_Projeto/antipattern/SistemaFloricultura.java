package com.weg.SOLID_Projeto.antipattern;

import org.hibernate.annotations.processing.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaFloricultura {

    static Scanner scanner = new Scanner(System.in);

    // CLIENTE
    static int clienteId = 0;
    static String clienteNome = "";
    static String clienteTelefone = "";
    static String clienteTipo = "";

    // FLOR
    static int florId = 0;
    static String florNome = "";
    static double florValor = 0;
    static String florTipo = "";

    // FUNCIONARIO
    static int funcionarioId = 0;
    static String funcionarioNome = "";
    static double funcionarioSalario = 0;
    static String funcionarioTipo = "";

    // SERVICO
    static int servicoId = 0;
    static String servicoNome = "";
    static double servicoPreco = 0;
    static String servicoTipo = "";

    public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Cliente");
            System.out.println("2 - Flor");
            System.out.println("3 - Funcionario");
            System.out.println("4 - Servico");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) menuCliente();
            else if (opcao == 2) menuFlor();
            else if (opcao == 3) menuFuncionario();
            else if (opcao == 4) menuServico();
        }
    }

    // ================= CLIENTE =================
    public static void menuCliente() {
        System.out.println("===== MENU CLIENTE=====");
        System.out.println("1 - Adicionar Cliente");
        System.out.println("2 - Buscar Cliente");
        System.out.println("3 - Atualizar Cliente");
        System.out.println("4 - Deletar Cliente");
        int opcao = scanner.nextInt(); scanner.nextLine();

        if (opcao == 1) {
            clienteId = 1;

            System.out.print("Nome: ");
            clienteNome = scanner.nextLine();

            System.out.print("Telefone: ");
            clienteTelefone = scanner.nextLine();

            System.out.println("Tipo (1-Premium, 2-VIP, 3-Normal): ");
            int tipo = scanner.nextInt(); scanner.nextLine();

            if (tipo == 1) clienteTipo = "Premium";
            else if (tipo == 2) clienteTipo = "VIP";
            else clienteTipo = "Normal";

        } else if (opcao == 2) {
            System.out.println(clienteId + " " + clienteNome + " " + clienteTelefone + " " + clienteTipo);

        } else if (opcao == 3) {
            System.out.print("Novo nome: ");
            clienteNome = scanner.nextLine();

            System.out.print("Novo telefone: ");
            clienteTelefone = scanner.nextLine();

        } else if (opcao == 4) {
            clienteId = 0;
            clienteNome = "";
            clienteTelefone = "";
            clienteTipo = "";
        }
    }

    // ================= FLOR =================
    public static void menuFlor() {
        System.out.println("===== MENU FLOR=====");
        System.out.println("1 - Adicionar Flor");
        System.out.println("2 - Buscar Flor");
        System.out.println("3 - Atualizar Flor");
        System.out.println("4 - Deletar Flor");
        int opcao = scanner.nextInt(); scanner.nextLine();

        if (opcao == 1) {
            florId = 1;

            System.out.print("Nome: ");
            florNome = scanner.nextLine();

            System.out.print("Valor: ");
            florValor = scanner.nextDouble(); scanner.nextLine();

            System.out.println("Tipo (1-Arbusto, 2-Espinhosa, 3-Herbacea): ");
            int tipo = scanner.nextInt(); scanner.nextLine();

            if (tipo == 1) {
                florTipo = "Arbusto";
                florValor += 10;
            } else if (tipo == 2) {
                florTipo = "Espinhosa";
                florValor += 5;
            } else {
                florTipo = "Herbacea";
                florValor += 2;
            }

        } else if (opcao == 2) {
            System.out.println(florId + " " + florNome + " " + florValor + " " + florTipo);

        } else if (opcao == 3) {
            System.out.print("Novo nome: ");
            florNome = scanner.nextLine();

        } else if (opcao == 4) {
            florId = 0;
            florNome = "";
            florValor = 0;
            florTipo = "";
        }
    }

    // ================= FUNCIONARIO =================
    public static void menuFuncionario() {
        System.out.println("===== MENU FUNCIONÁRIO=====");
        System.out.println("1 - Adicionar Funcionário");
        System.out.println("2 - Buscar Funcionário");
        System.out.println("3 - Atualizar Funcionário");
        System.out.println("4 - Deletar Funcionário");
        int opcao = scanner.nextInt(); scanner.nextLine();

        if (opcao == 1) {
            funcionarioId = 1;

            System.out.print("Nome: ");
            funcionarioNome = scanner.nextLine();

            System.out.print("Salário: ");
            funcionarioSalario = scanner.nextDouble(); scanner.nextLine();

            System.out.println("Tipo (1-Jardineiro, 2-Atendente, 3-Entregador): ");
            int tipo = scanner.nextInt(); scanner.nextLine();

            if (tipo == 1) {
                funcionarioTipo = "Jardineiro";
                funcionarioSalario += 200;
            } else if (tipo == 2) {
                funcionarioTipo = "Atendente";
                funcionarioSalario += 100;
            } else {
                funcionarioTipo = "Entregador";
                funcionarioSalario += 150;
            }

        } else if (opcao == 2) {
            System.out.println(funcionarioId + " " + funcionarioNome + " " + funcionarioSalario + " " + funcionarioTipo);

        } else if (opcao == 3) {
            System.out.print("Novo nome: ");
            funcionarioNome = scanner.nextLine();

        } else if (opcao == 4) {
            funcionarioId = 0;
            funcionarioNome = "";
            funcionarioSalario = 0;
            funcionarioTipo = "";
        }
    }

    // ================= SERVICO =================
    public static void menuServico() {
        System.out.println("===== MENU SERVIÇO=====");
        System.out.println("1 - Adicionar Serviço");
        System.out.println("2 - Buscar Serviço");
        System.out.println("3 - Atualizar Serviço");
        System.out.println("4 - Deletar Serviço");
        int opcao = scanner.nextInt(); scanner.nextLine();

        if (opcao == 1) {
            servicoId = 1;

            System.out.print("Nome: ");
            servicoNome = scanner.nextLine();

            System.out.print("Preço: ");
            servicoPreco = scanner.nextDouble(); scanner.nextLine();

            System.out.println("Tipo (1-Casamento, 2-Buque, 3-Festa): ");
            int tipo = scanner.nextInt(); scanner.nextLine();

            if (tipo == 1) {
                servicoTipo = "Casamento";
                servicoPreco += 500;
            } else if (tipo == 2) {
                servicoTipo = "Buque";
                servicoPreco += 100;
            } else {
                servicoTipo = "Festa";
                servicoPreco += 300;
            }

        } else if (opcao == 2) {
            System.out.println(servicoId + " " + servicoNome + " " + servicoPreco + " " + servicoTipo);

        } else if (opcao == 3) {
            System.out.print("Novo nome: ");
            servicoNome = scanner.nextLine();

        } else if (opcao == 4) {
            servicoId = 0;
            servicoNome = "";
            servicoPreco = 0;
            servicoTipo = "";
        }
    }
}
