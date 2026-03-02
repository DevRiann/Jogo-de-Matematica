package Game;

import java.util.Random;

public class Calcular
{
    private int dificuldade;
    private int valor1;
    private int valor2;
    private int resultado;
    private int operacao;
    private String op;


    public Calcular(int dificuldade)
    {
        Random rand = new Random();
        this.dificuldade = dificuldade;
        this.operacao = rand.nextInt(3);

        if (dificuldade == 1)
        {
            this.valor2 = rand.nextInt(10);
            this.valor1 = rand.nextInt(10);
        }
        else if (dificuldade == 2)
        {
            this.valor2 = rand.nextInt(100);
            this.valor1 = rand.nextInt(100);
        }
        else if (dificuldade == 3)
        {
            this.valor2 = rand.nextInt(1000);
            this.valor1 = rand.nextInt(1000);
        }
        else if (dificuldade == 4)
        {
            this.valor2 = rand.nextInt(10000);
            this.valor1 = rand.nextInt(10000);
        }
        else
        {
            this.valor2 = rand.nextInt(100000);
            this.valor1 = rand.nextInt(100000);
        }

        switch (this.getOperacao())
        {
            case 0:
                op = "Soma";
                break;
            case 1:
                op = "Subtrair";
                break;
            case 2:
                op="Multiplicar";
                break;
        }
    }

    public String toString()
    {
        return "Dificuldade: "+getDificuldade()+
                "\nOperação: "+getOp()+
                "\nValor 1: "+getValor1()+
                "\nValor 2: "+getValor2();
    }

    public boolean somar (int resultado)
    {
        this.resultado = this.getValor1() + this.getValor2();
        boolean certo = false;

        if (resultado == this.resultado)
        {
            System.out.println("Resposta Correto");
            certo = true;
        }
        else
        {
            System.out.println("Resposta Incorreta!");
        }
        System.out.println(this.getValor1()+" + "+this.getValor2()+" = "+this.getResultado());
        return certo;
    }

    public boolean subtrair (int resultado)
    {
        this.resultado = this.getValor1() - this.getValor2();
        boolean certo = false;

        if (resultado == this.resultado)
        {
            System.out.println("Resposta Correto");
            certo = true;
        }
        else
        {
            System.out.println("Resposta Incorreta!");
        }
        System.out.println(this.getValor1()+" - "+this.getValor2()+" = "+this.getResultado());
        return certo;
    }

    public boolean multiplicar (int resultado)
    {
        this.resultado = this.getValor1() * this.getValor2();
        boolean certo = false;

        if (resultado == this.resultado)
        {
            System.out.println("Resposta Correto");
            certo = true;
        }
        else
        {
            System.out.println("Resposta Incorreta!");
        }
        System.out.println(this.getValor1()+" * "+this.getValor2()+" = "+this.getResultado());
        return certo;
    }

    public int getDificuldade()
    {
        return dificuldade;
    }
    public void setDificuldade(int dificuldade)
    {
        this.dificuldade = dificuldade;
    }
    public int getValor1()
    {
        return valor1;
    }
    public int getValor2()
    {
        return valor2;
    }
    public int getOperacao()
    {
        return operacao;
    }
    public int getResultado()
    {
        return resultado;
    }
    public String getOp() { return op; }
}
