package src.tests.factory;

import src.entities.Financing;

/**
 * Padrão Factory
 * Fabrica do objeto Financing
 */
public class FinancingFactory {

    /**
     * Criação de objetos vazios
     * @return retorna um objeto vazio
     */
    public Financing createEmptyFinancing(){
        return new Financing();
    }

    /**
     * Criação um financing completo
     * @param totalAmount total do financiamento
     * @param income renda do cliente
     * @param months numeros de meses a parcelar
     * @return retorna a instância de um objeto financing
     */
    public static Financing createFinancing(Double totalAmount, Double income, Integer months) {
        return new Financing(totalAmount, income, months);
    }

    public static Financing createValidFinancing() {
        return createFinancing(100000.0, 2000.00, 80);
    }

    public static Financing createInvalidFinancing() {
        return createFinancing(100000.00, 2000.00, 20);
    }
}
