package br.com.wenya.Lamdas1.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.br.Lamdas1.Lambdas1;

public class Lambdas1Test {

	@Test
	@DisplayName("Teste que retorna numero par")
	public void test() {
		assertTrue(Lambdas1.numeroPar(4));
		assertTrue(Lambdas1.numeroPar(6));
	}

	@Test
	@DisplayName("Teste que retorna numero impar")
	public void test1() {
		assertFalse(Lambdas1.numeroPar(5));
		assertFalse(Lambdas1.numeroPar(7));
	}

	@Test
	@DisplayName("Teste para multiplicação de um numero * 2")
	public void test2() {
		assertEquals(16, Lambdas1.multiplicacao(8));
		assertEquals(8, Lambdas1.multiplicacao(4));
		assertEquals(12, Lambdas1.multiplicacao(6));
	}

	@Test
	@DisplayName("Teste para numeros impares")
	public void teste3() {
		assertEquals(6, Lambdas1.multiplicacao(3));
		assertEquals(14, Lambdas1.multiplicacao(7));
	}

	@Test
	@DisplayName("Teste de multiplicação com número negativo")
	public void test4() {
		int numeroNegativo = -10;
		int resultadoEsperado = numeroNegativo * 2;
		int resultadoReal = Lambdas1.multiplicacao(numeroNegativo);

		assertEquals(resultadoEsperado, resultadoReal, "Multiplicação incorreta para um número negativo.");

	}

	@Test
	@DisplayName("Teste com lista vazia")
	public void test5() {
		List<Integer> listaNumerosVazia = Collections.emptyList();

		List<Integer> numerosFiltradosEMultiplicados = Lambdas1.filtrarNumeros(listaNumerosVazia)
				.collect(Collectors.toList());

		assertTrue(numerosFiltradosEMultiplicados.isEmpty(), "A lista deve estar vazia");
	}

	@Test
	@DisplayName("Teste de filtragem de números pares e multiplicação")
	public void test6() {
		List<Integer> listaNumeros = Arrays.asList(1, 5, 8, 7, 4, 6, 3, 2, 1, 8, 5, 7, 4);

		List<Integer> numerosFiltradosEMultiplicados = Lambdas1.filtrarNumeros(listaNumeros)
				.collect(Collectors.toList());

		List<Integer> numerosEsperados = listaNumeros.stream()
				.filter(Lambdas1::numeroPar)
				.map(Lambdas1::multiplicacao)
				.limit(7)
				.collect(Collectors.toList());

		assertEquals(numerosEsperados, numerosFiltradosEMultiplicados, "Filtragem e multiplicação não estão corretas");
	}

}
