package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // para poder entrar com uma data

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();

		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();

		// instanciando um novo objeto. associado a esse objeto coloquei outro objeto.
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.print("How  many contracts to this worker?: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract); // associando o contrato com o funcionario.
		}

		System.out.println();
		System.out.print("Enter mouth and year to calcule income (MM/YYYY): ");
		String mouthAndYear = sc.next();
		// o integer para trasformar em um valor inteiro;
		int mouth = Integer.parseInt(mouthAndYear.substring(0, 2)); // recorta o string gerando com 2 digitos (sempre 1
																	// numero a mais)
		int year = Integer.parseInt(mouthAndYear.substring(3)); // recorta do 3 pra frente

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName()); // acessa o departamento e seu nome

		// exibindo o valor que o trabalhador ganhou com 2as casas dec.
		System.out.println("Imcome for " + mouthAndYear + ": " + String.format("%.2f", worker.income(year, mouth)));

		sc.close();

	}

}
