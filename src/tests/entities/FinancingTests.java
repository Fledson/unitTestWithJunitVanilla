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
        Assertions.assertInstanceOf(Financing.class, FinancingFactory.createFinancing(100000.0, 2000.0,80));
    }

    /**
     * Teste deve passar se for lançada uma exeção ao tentar criar um objeto com dados invalidos
     */
    @Test
    public void constructorShouldThrowExceptionWhenCreateObjectWithInvalidData() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Assertions.assertInstanceOf(Financing.class, FinancingFactory.createFinancing(100000.0, 2000.0,20));
        });
    }

}
