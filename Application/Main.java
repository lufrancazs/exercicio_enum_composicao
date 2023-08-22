package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Entities.Enum.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Enter department's name:");
		String departmentName = sc.nextLine();
		
		System.out.print("Enter worker data:");
		
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker?");
		int n = sc.nextInt();
		
		for(int i = 1; i < n; i++) {
			System.out.println("Enter contract #" + i + "data");
			
			System.out.print("DATE (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			
			System.out.print("Value Per Hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		
		
		sc.close();
	}

}
