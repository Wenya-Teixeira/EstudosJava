package br.com.br.Lamdas1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lambdas1 {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 5, 8, 7, 4, 6, 3, 2, 1, 8, 5, 7, 4, 6, 10);
		filtrarNumeros(lista).forEach(System.out::println);
	}

	public static boolean numeroPar(int n) {
		return n % 2 == 0;
	}

	public static int multiplicacao(int n) {
		return n * 2;
	}

	public static Stream<Integer> filtrarNumeros(List<Integer> listaNumeros) {
		return listaNumeros.stream()
				.filter(Lambdas1::numeroPar)
				.map(Lambdas1::multiplicacao)
				.limit(7);
	}

}
