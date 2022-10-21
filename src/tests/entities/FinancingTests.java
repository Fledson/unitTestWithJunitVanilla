package src.tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.entities.Financing;
import src.tests.factory.FinancingFactory;

/**
 * Classe de testes
 */
public class FinancingTests {

    /**
     * Teste deve passar se o objeto instanciado for valido
     */
    @Test
    public void constructorShouldCreateObjectFinancingWhenDataIsValid(){

        var finance = FinancingFactory.createFinancing(100000.00, 2000.0, 80);


        Assertions.assertEquals(100000.00, finance.getTotalAmount());
        Assertions.assertEquals(2000.00, finance.getIncome());
        Assertions.assertEquals(80, finance.getMonths());
    }

    /**
     * Teste deve passar se for lançada uma exeção ao tentar criar um objeto com dados invalidos
     */
    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenCreateObjectWithInvalidData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FinancingFactory.createInvalidFinancing();
        });
    }

    /**
     * Teste deve passar caso o metodo setTotalAmount receba um valor valido para o financiamento
     */
    @Test
    public void methodSetTotalAmountShouldUpdatedValueWhenDataIsValid(){
        // arrange
        var finance = FinancingFactory.createValidFinancing();

        // action
        finance.setTotalAmount(90000.0);

        // assertions
        Assertions.assertEquals(90000.0, finance.getTotalAmount());
    }

    /**
     * Teste deve passar caso o metodo setTotalAmount receba um valor invalido para o financiamento
     * e apartir disso, lançe uma exeção IllegalArgumentException
     */
    @Test
    public void methodSetTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData(){
        // arrange
        var finance = FinancingFactory.createValidFinancing();

        // action
        //assertions
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            finance.setTotalAmount(1000000.00);
        });
    }

    /**
     * Teste deve atualizar o valor do income se receber um valor valido
     * a parcela deve ser menor que metade do income
     */
    @Test
    public void methodSetIncomeShouldUpdateValueWhenDataIsValid() {
        var finance = FinancingFactory.createValidFinancing(); // a parcela dá 1000.0

        finance.setIncome(3000.0); // metade 1500.0

        Assertions.assertEquals(3000.0, finance.getIncome());
    }

    /**
     * Deve lançar uma exceção se o valor do income não for valido
     * a parcela deve ser maior que metade do income
     */
    @Test
    public void methodSetIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {
        var finance = FinancingFactory.createValidFinancing();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            finance.setIncome(1800.0);
        });
    }

    /**
     * Deve atualizar o valor do Month se o valor for valido
     */
    @Test
    public void methodSetMonthsShouldUpdateValueWhenDataIsValid(){
        var finance = FinancingFactory.createValidFinancing();

        finance.setMonths(100);

        Assertions.assertEquals(100, finance.getMonths());
    }

    /**
     * Deve lançar uma exceção se o valor do Month for deixa a parcela menor que metade do income
     */
    @Test
    public void methodSetMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData(){
        var finance = FinancingFactory.createValidFinancing();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            finance.setMonths(5);
        });
    }

    /**
     * Deve calcular corretamente o valor da entrada, 20% do valor
     */
    @Test
    public void entryShouldCalculateCorrectlyTheInputValue(){

        double valueExpected = 20000.0; // totalAmount = 100000.0
        var finance = FinancingFactory.createValidFinancing();

        double entry = finance.entry();

        Assertions.assertEquals(valueExpected, entry);
    }

    /**
     * Deve calcular corretamente o valor da parcela
     */
    @Test
    public void quotaShouldCalculateCorrectlyTheQuotaValue(){
        double valueExpected = 1000.0; // (100000.0 - 20000.0) / 80
        var finance = FinancingFactory.createValidFinancing();

        double quota = finance.quota();

        Assertions.assertEquals(valueExpected, quota);
    }
}
