package Game;

import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    static int pontos = 0;
    static Calcular calc;
    static int continuar;

    static void main(String[] args)
    {
            jogar();
    }

    public static void jogar() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  BEM-VINDO AO JOGO DE MATEMÁTICA    ║");
        System.out.println("║ TESTE OS SEUS CONHECIMENTOS AQUI!!  ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.println("Informe o nível de dificuldade [1, 2, 3 ou 4] ");
        int dificuldade = Main.input.nextInt();
        Main.calc = new Calcular(dificuldade);

        System.out.println("Informe o resultado: ");

        if (calc.getOperacao() == 0) {
            System.out.println(calc.getValor1() + " + " + calc.getValor2());
            int resposta = input.nextInt();

            if (calc.somar(resposta)) {
                Main.pontos++;
                System.out.println("Você tem " + Main.pontos + " Ponto(s).");
            } else {
                System.out.println("Você terminou com " + Main.pontos + " Ponto(s)");
                Main.pontos = 0;
            }
        } else if (calc.getOperacao() == 1) {
            System.out.println(calc.getValor1() + " - " + calc.getValor2());
            int resposta = input.nextInt();

            if (calc.subtrair(resposta)) {
                Main.pontos++;
                System.out.println("Você tem " + Main.pontos + " Ponto(s).");
            } else {
                System.out.println("Você terminou com " + Main.pontos + " Ponto(s)");
                Main.pontos = 0;
            }
        } else if (calc.getOperacao() == 2) {
            System.out.println(calc.getValor1() + " * " + calc.getValor2());
            int resposta = input.nextInt();

            if (calc.multiplicar(resposta)) {
                Main.pontos++;
                System.out.println("Você tem " + Main.pontos + " Ponto(s).");
            } else {
                System.out.println("Você terminou com " + Main.pontos + " Ponto(s)");
                Main.pontos = 0;

            }
        } else {
            System.out.println("Essa operação não existe");
        }

        Thread inputThread = new Thread(() ->
        {
            System.out.println("Desejar continuar: [0] - Sair e [1] - Continuar)");
            System.out.println("Por favor, inserir um valor em até 10 segundos antes que o jogo se encerre!!");
            continuar = input.nextInt();
        });

        inputThread.start();

        try {
            inputThread.join(10000); // espera até 10 segundos
            if (inputThread.isAlive()) {
                System.out.println("\nTempo esgotado!");
                System.out.println("Pontuação final: "+Main.pontos+" Ponto(s)");
                System.out.println("Até a próximo");
                System.exit(0);
                inputThread.interrupt(); // encerra a thread de entrada
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        while (continuar == 1)
        {
            for (int i = 0; i <= 100; i += 10)
            {
                System.out.print("\rCarregando: " + i + "%");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("\n");
            Main.jogar();
        }

        System.out.println("Pontuação final: "+Main.pontos+" Ponto(s)");
        System.out.println("Até a próximo");
        System.exit(0); // Finalização imediata do jogo


    }
}
