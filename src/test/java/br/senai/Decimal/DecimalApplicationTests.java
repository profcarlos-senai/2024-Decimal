package br.senai.Decimal;

import br.senai.Decimal.model.Dados;
import br.senai.Decimal.repo.DadosRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DecimalApplicationTests {

	@Autowired
	DadosRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	void TestaSalvas(){
		BigDecimal valor = new BigDecimal("12345.67").setScale(2, RoundingMode.HALF_EVEN);
		Dados dados = new Dados();
		dados.setValor(valor);
		dados.setDescricao("Compras");

		Dados salvo = repo.save(dados);
		assertNotNull(salvo);
		assertEquals(salvo.getValor(), dados.getValor());
		assertEquals(salvo.getDescricao(), dados.getDescricao());
	}

	@Test
	void PegaDados(){
		Optional<Dados> opt = repo.findById(1L);
		assertTrue(opt.isPresent());
		Dados dados = opt.get();
		BigDecimal valor = dados.getValor();
		System.out.println(valor);
	}

}
