package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Antes de todos!!");
	}

	@Test
	void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoforRuim() {
		service.concederReajuste(funcionario, Desempenho.RUIM);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoforBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoforOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

	@AfterEach
	public void finalizar() {
		System.out.println("Fim");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Depois de todos!!");
	}
}
