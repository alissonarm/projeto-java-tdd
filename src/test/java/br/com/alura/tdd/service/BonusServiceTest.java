package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void naoDeveriaGerarBonusParaSalarioMuitoAlto() {
		BonusService service = new BonusService();
	
		// Testar a exceção -  via assert
//		assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Alisson", LocalDate.now(), new BigDecimal("25000.00"))));
		
		
		// testar a exceção via Try - catch
		try {
			service.calcularBonus(new Funcionario("Alisson", LocalDate.now(), new BigDecimal("25000.00")));
			fail("Não aconteceu a exception");
		} catch (Exception e) {
			assertEquals("Funcionario nao pode receber este bonus", e.getMessage()); // Aqui testa a mensagem esperada
		}
		
	}
	
	@Test
	void bonusDeveriaSerDezPorcentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Alisson", LocalDate.now(), new BigDecimal("2500.00")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
		
	}
	
	@Test
	void bonusDeveriaSerDezPorcentoParaSalarioDeDezMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Alisson", LocalDate.now(), new BigDecimal("10000.00")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
		
	}

}
