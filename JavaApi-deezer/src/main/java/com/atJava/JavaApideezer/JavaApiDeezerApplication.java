package com.atJava.JavaApideezer;

import com.atJava.JavaApideezer.util.ArtistaUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaApiDeezerApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavaApiDeezerApplication.class, args);

//		System.out.println(("Seja bem vindo a API do Deezer"));
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Digite a opção desejada");
//		System.out.println("1 - Buscar artista pelo id");
//		int opcaoUsuario = scanner.nextInt();
//		switch (opcaoUsuario){
//			case 1: {
//				ArtistaUtil artistaUtil = new ArtistaUtil();
//				System.out.println("Digite o ID do artista");
//				int artistaId = scanner.nextInt();
//				System.out.println(artistaUtil.getById(artistaId));
//			}
//		}
	}

}
