package br.com.omesquita.learn.calculatec;

public class Calculadora {

    private double operando;
    private double operandoAnterior;
    private String operadorAnterior;
    private double memoria;


    public Calculadora() {
        this.operando = 0;
        this.operandoAnterior = 0;
        this.operadorAnterior = "";
        this.memoria = 0;
    }

    public double getOperando() {
        return this.operando;
    }

    public void setOperando(double operando) {
        this.operando = operando;
    }

    private void realizaOperacaoAnterior() {
        if (!operadorAnterior.equals("")) {
            switch (operadorAnterior) {
                case "+":
                    operando = operandoAnterior + operando;
                    break;
                case "-":
                    operando = operandoAnterior - operando;
                    break;
                case "x":
                    operando = operandoAnterior * operando;
                    break;
                case "÷":
                    if (operando != 0) {
                        operando = operandoAnterior / operando;
                    }
                    break;
            }
        }
    }

    public void realizarOperacao(String op) {
        switch (op) {
            case "%":
                operando = (operandoAnterior * operando / 100);
                break;
            case "+/-":
                operando = -operando;
                break;
            case "C":
                operando = 0;
                memoria = 0;
                operadorAnterior = "";
                break;
            default:
                realizaOperacaoAnterior();
                operadorAnterior = op;
                operandoAnterior = operando;
                break;
        }
    }

    public void realizarOperacaoDeMemoria(String opm) {
        switch (opm) {
            case "mc":
                memoria = 0;
                break;
            case "m+":
                memoria += operando;
                break;
            case "m-":
                memoria -= operando;
                break;
            case "mr":
                operando = memoria;
                break;
        }
    }
}