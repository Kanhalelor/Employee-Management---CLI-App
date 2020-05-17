import javax.swing.*;

class Employee {
	private static String firstName;
	private static String surname;
	private static int yearsToRetirement;
	private static int monthlySavings;
	private static int annualSavings;
	private static int totalSavings;

	public static int calculateAnnualSavings() {
		annualSavings = monthlySavings * 12;
		return annualSavings;
	}
	
	public static int calculateTotalSavings() {
		totalSavings = annualSavings * yearsToRetirement;
		return totalSavings;
	}

	public static void main(String[] args) {
		// creae a new employee
		Employee employee = new Employee();

		String[] textLabels = {"First Name", "Surname", "Years To Retirement", "Monthly Savings", "Annual Savings", "Total Savings"};
		System.out.println("");
		System.out.println("                             EMPLOYEES SAVINGS REPORT");
		System.out.println("");

		for (String str: textLabels) {
			System.out.print(str+"\t");
		}
		System.out.println();
		// separate fields from data with a line
		System.out.println("___________________________________________________________________________________________");
		// keep entering more details
		do {
			employee.firstName = JOptionPane.showInputDialog(null, "Please enter the employess's first name");
			employee.surname = JOptionPane.showInputDialog(null, "Please enter the employess's surname");
			String retirement;
			do {
				retirement = JOptionPane.showInputDialog(null, "Enter number of years before retirement");
			} while(Integer.parseInt(retirement) <= 0);
			if (Integer.parseInt(retirement) == 999) {
				break;
			}
			employee.yearsToRetirement = Integer.parseInt(retirement);
			String savings = JOptionPane.showInputDialog(null, "Please enter the employess's monthly savings");
			employee.monthlySavings = Integer.parseInt(savings);

			// call our methods
			employee.calculateAnnualSavings();
			employee.calculateTotalSavings();
			// create a 2D array with the employees's names as values
			String[][] names = {{employee.firstName}, {employee.surname}};
			// create a 2D array with the employess's financial record
			int[][] financials = {{employee.yearsToRetirement}, {employee.monthlySavings}, {employee.annualSavings}, {employee.totalSavings}};
			
			// loop through all 2D array and print the values to the console
			int i;
			int details;
			for (i= 0; i < names.length; i++) {
				for (details = 0; details < names[i].length; details++) {
					System.out.print(names[i][details]+"\t\t");
				}
			}
			int j;
			int e;
			for (j= 0; j < financials.length; j++) {
				for (e = 0; e < financials[j].length; e++) {
					System.out.print(financials[j][e]+"\t\t");
				}
			}
			System.out.println("");

		} while(yearsToRetirement != 999);
	}
}
