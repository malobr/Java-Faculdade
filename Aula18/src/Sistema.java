import java.util.ArrayList;

public class Sistema {

    private static void exibirMenu() {

        System.out.println("\nSistema de Combate");
        System.out.println("1) Cadastrar Herói");
        System.out.println("2) Cadastrar Vilão");
        System.out.println("3) Listar personagens");
        System.out.println("0) Sair");
        System.out.print("Informe uma Opção: ");
    }

    private static void cadastrarHeroi() {

        System.out.println("\nCadastro de Herói");
        System.out.println("Nome: ");
        String nome = Console.lerString();

        System.out.println("Pontos de vida iniciais: ");
        int pstsVida = Console.lerInt();

        System.out.println("Classe do herói: ");
        String classe = Console.lerString();

        Heroi h = new Heroi(nome, pstsVida, classe);

        Cadastro.cadastrarPersonagem(h);

        System.out.println("\nHerói cadastrado com sucesso!");

    }

    private static void cadastrarVilao() {

        System.out.println("\nCadastro de Vilão");
        System.out.println("Nome: ");
        String nome = Console.lerString();

        System.out.println("Pontos de vida iniciais: ");
        int pstsVida = Console.lerInt();

        System.out.println("Nível de dificuldade: ");
        int nivel = Console.lerInt();

        Vilao v = new Vilao(nome, pstsVida, nivel);

        Cadastro.cadastrarPersonagem(v);

        System.out.println("\nVilão cadastrado com sucesso!");

    }

    private static void listarPersonagens() {

        if (Cadastro.verificarListaVazia()) {

            System.out.println("\nNão há personagens cadastrados");
            return;
        }

        System.out.println("\nLista de Personagens Cadastrados");

        for (Personagem tempPersonagem : Cadastro.listarPersonagens()) {

            System.out.println(tempPersonagem);
        }

    }

    private static void verificarOpcao(int op) {

        switch (op) {

            case 1:
                cadastrarHeroi();
                break;

            case 2:
                cadastrarVilao();
                break;

            case 3:
                listarPersonagens();
                break;

            case 0:
                System.out.println("\nSistema finalizado...");
                break;

            default:
                System.out.println("\nOpção inválida. Digite novamente");
                break;
        }

    }

    public static void executar() {

        int op;

        do {

            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);

        } while (op != 0);

    }

}
