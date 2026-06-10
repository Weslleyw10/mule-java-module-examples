package com.integradordedados.examples;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraFrete {

    private final String origem;
    private final String destino;
    private final double taxaPorKm;
    private final List<String> itens = new ArrayList<>();

    public CalculadoraFrete(String origem, String destino, double taxaPorKm) {
        if (taxaPorKm < 0) {
            throw new IllegalArgumentException("A taxa por km não pode ser negativa.");
        }
        this.origem = origem;
        this.destino = destino;
        this.taxaPorKm = taxaPorKm;
    }

    // Método de instância que altera o estado (não retorna nada)
    public void adicionarItem(String item) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("O item não pode ser vazio.");
        }
        itens.add(item.trim());
    }

    // Método de instância que usa o estado E recebe parâmetro
    public double calcularFrete(double distanciaKm) {
        if (distanciaKm < 0) {
            throw new IllegalArgumentException("A distância não pode ser negativa.");
        }
        double frete = distanciaKm * taxaPorKm;
        if (itens.size() > 3) {
            frete = frete * 0.9; // 10% de desconto para pedidos grandes
        }
        return frete;
    }

    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public int getQuantidadeItens() { return itens.size(); }

    // Métodos ESTÁTICOS: utilitários puros, não dependem de estado
    public static double gramasParaKg(double gramas) {
        return gramas / 1000.0;
    }

    public static double aplicarDesconto(double valor, double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("O percentual deve estar entre 0 e 100.");
        }
        return valor - (valor * percentual / 100.0);
    }
}