package com.ledger.emi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.ledger.emi.loan.LedgerCommandDelegation;

@SpringBootApplication
public class EmiApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = SpringApplication.run(EmiApplication.class, args);
		LedgerCommandDelegation ledgerCommandDelegation = applicationContext.getBean(LedgerCommandDelegation.class);
		EmiApplication.load(ledgerCommandDelegation);
	}
	
	public static void load(LedgerCommandDelegation ledgerCommandDelegation) {
		Scanner scanner = new Scanner(System.in);
		String path = scanner.next();
//		String path = ".\\src\\main\\java\\com\\ledger\\emi\\inputfile.txt";
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(path));
			String s = null;
			while ((s = bufferedReader.readLine()) != null) {
				ledgerCommandDelegation.commandExecution(s);
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		scanner.close();
	}

}
