import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.*;

class IFriend{
	public static int idCount = 0;
	public static String[] contactIdArray = new String[0];
	public static String[] nameArray = new String[0];
	public static String[] phoneNumberArray = new String[0];
	public static String[] companyNameArray = new String[0];
	public static double[] salaryArray = new double[0];
	public static String[] birthDayArray = new String[0];
	
	 
	//-------------------main method----------------------//
	public static void main(String args[]){
		homePage();
	}
	
	//-------------------homepage----------------------//
	public static void homePage(){
		Scanner input = new Scanner(System.in);
		
		while(true){
			
			System.out.println("\n");
			System.out.println("            /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$");
			System.out.println("           |__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$");
			System.out.println("            /$$| $$      | $$  \\ $$| | $$  | $$      | $$$$| $$| $$  \\ $$");
			System.out.println("           | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$");
			System.out.println("           | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$");
			System.out.println("           | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$");
			System.out.println("           | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/");
			System.out.println("           |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/");
			System.out.println("\n");
			System.out.println("   _____            _             _          ____                        _");
			System.out.println("  / ____|          | |           | |        / __ \\                      (_)");
			System.out.println(" | |     ___  _ __ | |_ __ _  ___| |_ ___  | |  | |_ __ __ _  __ _ _ __  _ _______ _ __");
			System.out.println(" | |    / _ \\| '_ \\| __/ _` |/ __| __/ __| | |  | | '__/ _` |/ _` | '_ \\| |_  / _ \\ '__|");
			System.out.println(" | |___| (_) | | | | || |_| | |__| |_\\__ \\ | |__| | | | |_| | |_| | | | | |/ /  __/ |");
			System.out.println("  \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/  \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|");
			System.out.println("                                                        __/ |");
			System.out.println("                                                       |___/");
			System.out.println("\n==========================================================================================");
			
			System.out.println("\n\n\t[01] ADD Contacts");
			System.out.println("\n\t[02] UPDATE Contacts");
			System.out.println("\n\t[03] DELETE Contacts");
			System.out.println("\n\t[04] SEARCH Contacts");
			System.out.println("\n\t[05] LIST Contacts");
			System.out.println("\n\t[06] Exit");
			
			System.out.print("\n\n Enter an option to continue -> ");
			int option = input.nextInt();
			
			switch(option){
				case 1:
					//------add contacts------//
					addContacts();
					break;
				case 2:
					//------update contacts------//
					updateContacts();
					break;
				case 3:
					//------delete contacts-------//
					deleteContacts();
					break;
				case 4:
					//------search contacts-------//
					searchContacts();
					break;
				case 5:
					//------list contacts-------//
					listContacts();
					break;
				case 6:
					//------exit-------//
					clearConsole();
					System.exit(0);
				default :
					//------invalid option-------//
					clearConsole();
					continue;
			}
		}
	}
	
	//-------------------add contacts----------------------//
	public static void addContacts(){
		Scanner input = new Scanner(System.in);

		while(true){
			clearConsole();
			
			System.out.println("  +-----------------------------------------------------+");
			System.out.println("  |\t\tAdd Contact to the list\t\t\t|");
			System.out.println("  +-----------------------------------------------------+");
			
			String contactId = generateContactId();
			System.out.printf("\n\n   %s\n  =======\n\n", contactId);
			
			System.out.print("  Name\t\t\t: ");
			String name = input.nextLine().toLowerCase();
			
			//-------------is name valid?-------------//
			while(!isValidName(name)){
				System.out.println("\n\tEmpty name...");
				
				System.out.print("\n  Do you want to add name again (Y/N): ");
				char ch = input.next().charAt(0);
				
				input.nextLine();
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					idCount--;
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("  Name\t\t\t: ");
				name = input.nextLine();
			}
			
			System.out.print("  Phone Number\t\t: ");
			String phoneNumber = input.nextLine();
			
			//-----------is phone number valid?---------------//
			while(!isValidPhoneNumber(phoneNumber)){
				System.out.println("\n\tInvalid phone number...");
				
				System.out.print("\n  Do you want to add phone number again (Y/N): ");
				char ch = input.next().charAt(0);
				
				input.nextLine();
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					idCount--;
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("  Phone Number\t\t: ");
				phoneNumber = input.nextLine();
			}
			
			//-----------is phone number duplicate?---------------//
			while(isDuplicate(phoneNumber)){
				System.out.println("\n\tDuplicate phone number...");
				
				System.out.print("\n  Do you want to add phone number again (Y/N): ");
				char ch = input.next().charAt(0);
				
				input.nextLine();
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					idCount--;
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("  Phone Number\t\t: ");
				phoneNumber = input.nextLine();
			}

			System.out.print("  Company Name\t\t: ");
			String companyName = input.nextLine();
			
			//-----------is company name valid?---------------//
			while(!isValidCompanyName(companyName)){
				System.out.println("\n\tEmpty company name...");
				
				System.out.print("\n  Do you want to add company name again (Y/N): ");
				char ch = input.next().charAt(0);
				
				input.nextLine();
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					idCount--;
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("  Company Name\t\t: ");
				companyName = input.nextLine();
			}
			
			System.out.print("  Salary\t\t: ");
			double salary = input.nextDouble();
			
			//-----------is salary valid?---------------//
			while(!isValidSalary(salary)){
				System.out.println("\n\tInvalid salary...");
				
				System.out.print("\n  Do you want to add salary again (Y/N): ");
				char ch = input.next().charAt(0);
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					idCount--;
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("  Salary\t\t: ");
				salary = input.nextDouble();
			}
			
			input.nextLine();
			
			System.out.print("  B'day(YYYY-MM-DD)\t: ");
			String birthDay = input.nextLine();
			
			//-----------is birthday valid?---------------//
			while(!isValidBirthDay(birthDay)){
				System.out.println("\n\tInvalid birthday...");
				
				System.out.print("\n  Do you want to add birthday again (Y/N): ");
				char ch = input.next().charAt(0);
				
				input.nextLine();
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					idCount--;
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("  B'day(YYYY-MM-DD)\t: ");
				birthDay = input.nextLine();
			}
			
			//-----------extend arrays and add to the arrays---------------//
			extendArrays();
			
			contactIdArray[contactIdArray.length - 1] = contactId;
			nameArray[nameArray.length - 1] = name;
			phoneNumberArray[phoneNumberArray.length - 1] = phoneNumber;
			companyNameArray[companyNameArray.length - 1] = companyName;
			salaryArray[salaryArray.length - 1] = salary;
			birthDayArray[birthDayArray.length - 1] = birthDay;
			
			System.out.println("\n\tContact has been added successfully...");
			
			System.out.print("\n\n  Do you want to add another contact(Y/N): ");
			char ch = input.next().charAt(0);

			input.nextLine();
				
			if(ch == 'Y' || ch == 'y'){
				continue;
			}else if(ch == 'N' || ch == 'n'){
				clearConsole();
				homePage();
				return;
			}
		}
	}
	
	//-------------------update contacts----------------------//
	public static void updateContacts(){
		Scanner input = new Scanner(System.in);

		while(true){
			clearConsole();
				
			System.out.println("  +-----------------------------------------------------+");
			System.out.println("  |\t\t\tUpdate contact\t\t\t|");
			System.out.println("  +-----------------------------------------------------+");
			
			System.out.print("\n\n  Search contact by name or phone number -  ");
			String query = input.nextLine().toLowerCase();
			
			//-----------------is valid name or phone number?-----------------//
			while(!isValidName(query) && !isValidPhoneNumber(query)){
				System.out.println("\n\tNot a valid name or phone number...");
				
				System.out.print("\n  Do you want to search again (Y/N): ");
				char ch = input.next().charAt(0);
				
				input.nextLine();
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[7A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("\n\n  Search contact by name or phone number -  ");
				query = input.nextLine().toLowerCase();
			}
			
			//-----------------is there any matching name or phone nnumber?-----------------//
			if(search(query) == -1){
				//------------no match found-----------//
				System.out.println("\n\tThere is no matching name or phone number...");
			}else{
				//--------matching contact found-------//
				printArray(query);
				System.out.println("\n\n");
				
				L1:while(true){
					System.out.println("  What do you want update...");
				
					System.out.println("\n\t[01] Name");
					System.out.println("\t[02] Phone Number");
					System.out.println("\t[03] Company Name");
					System.out.println("\t[04] Salary");
					
				
					System.out.print("\n\n  Enter an option to continue -> ");
					int option = input.nextInt();

					input.nextLine();

					System.out.print("\033[9A");
					System.out.print("\033[0J");
				
					switch(option){
						case 1:
							//-------------update name--------------//
							System.out.println("   Update Name\n  =============");
							
							System.out.print("\n Input new name - ");
							String name = input.nextLine().toLowerCase();
							
							//-------------is name valid?-------------//
							while(!isValidName(name)){
								System.out.println("\n\tEmpty name...");
								
								System.out.print("\n  Do you want to update name again (Y/N): ");
								char ch = input.next().charAt(0);
								
								input.nextLine();
								
								if(ch == 'Y' || ch == 'y'){
									System.out.print("\033[6A");
									System.out.print("\033[0J");
								}else if(ch == 'N' || ch == 'n'){
									clearConsole();
									homePage();
									return;
								}
								
								System.out.print("\n Input new name - ");
								name = input.nextLine().toLowerCase();
							}

							nameArray[search(query)] = name;
							break L1;

						case 2:
							//-------------update phone number--------------//
							System.out.println("   Update Phone Number\n  =====================");
							
							System.out.print("\n Input new phone number - ");
							String phoneNumber = input.nextLine();
							
							//-----------is phone number valid?---------------//
							while(!isValidPhoneNumber(phoneNumber)){
								System.out.println("\n\tInvalid phone number...");
								
								System.out.print("\n  Do you want to update phone number again (Y/N): ");
								char ch = input.next().charAt(0);
								
								input.nextLine();
								
								if(ch == 'Y' || ch == 'y'){
									System.out.print("\033[6A");
									System.out.print("\033[0J");
								}else if(ch == 'N' || ch == 'n'){
									clearConsole();
									homePage();
									return;
								}
								
								System.out.print("\n Input new phone number - ");
								phoneNumber = input.nextLine();
							}

							//-----------is phone number duplicate?---------------//
							while(isDuplicate(phoneNumber)){
								System.out.println("\n\tDuplicate phone number...");
								
								System.out.print("\n  Do you want to update phone number again (Y/N): ");
								char ch = input.next().charAt(0);
								
								input.nextLine();
								
								if(ch == 'Y' || ch == 'y'){
									System.out.print("\033[6A");
									System.out.print("\033[0J");
								}else if(ch == 'N' || ch == 'n'){
									clearConsole();
									homePage();
									return;
								}
								
								System.out.print("\n Input new phone number - ");
								phoneNumber = input.nextLine();
							}

							phoneNumberArray[search(query)] = phoneNumber;
							break L1;

						case 3:
							//-------------update company name--------------//
							System.out.println("   Update Company Name\n  =====================");
							
							System.out.print("\n Input new company name - ");
							String companyName = input.nextLine();
							
							//-----------is company name valid?---------------//
							while(!isValidCompanyName(companyName)){
								System.out.println("\n\tEmpty company name...");
								
								System.out.print("\n  Do you want to update company name again (Y/N): ");
								char ch = input.next().charAt(0);
								
								input.nextLine();
								
								if(ch == 'Y' || ch == 'y'){
									System.out.print("\033[6A");
									System.out.print("\033[0J");
								}else if(ch == 'N' || ch == 'n'){
									clearConsole();
									homePage();
									return;
								}
								
								System.out.print("\n Input new company name - ");
								companyName = input.nextLine();
							}

							companyNameArray[search(query)] = companyName;
							break L1;

						case 4:
							//-------------update salary--------------//
							System.out.println("   Update Salary\n  ===============");
							
							System.out.print("\n Input new salary - ");
							int salary = input.nextInt();
							
							//-----------is salary valid?---------------//
							while(!isValidSalary(salary)){
								System.out.println("\n\tInvalid salary...");
								
								System.out.print("\n  Do you want to update salary again (Y/N): ");
								char ch = input.next().charAt(0);
								
								if(ch == 'Y' || ch == 'y'){
									System.out.print("\033[6A");
									System.out.print("\033[0J");
								}else if(ch == 'N' || ch == 'n'){
									clearConsole();
									homePage();
									return;
								}
								
								System.out.print("\n Input new salary - ");
								salary = input.nextInt();
							}

							salaryArray[search(query)] = salary;
							break L1;

						default:
							//------invalid option-------//
							continue;
					}
				}
				System.out.println("\n\tContact has been updated successfully...");
			}
			
			System.out.print("\n\n  Do you want to update another contact(Y/N): ");
			char ch = input.next().charAt(0);

			input.nextLine();
				
			if(ch == 'Y' || ch == 'y'){
				continue;
			}else if(ch == 'N' || ch == 'n'){
				clearConsole();
				homePage();
				return;
			}
		}
	}
	
	//-------------------delete contacts----------------------//
	public static void deleteContacts(){
		Scanner input = new Scanner(System.in);

		while(true){
			clearConsole();
				
			System.out.println("  +-----------------------------------------------------+");
			System.out.println("  |\t\t\tDelete contact\t\t\t|");
			System.out.println("  +-----------------------------------------------------+");
			
			System.out.print("\n\n  Search contact by name or phone number -  ");
			String query = input.nextLine().toLowerCase();
			
			//-----------------is valid name or phone number?-----------------//
			while(!isValidName(query) && !isValidPhoneNumber(query)){
				System.out.println("\n\tNot a valid name or phone number...");
				
				System.out.print("\n  Do you want to search again (Y/N): ");
				char ch = input.next().charAt(0);
				
				input.nextLine();
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[7A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("\n\n  Search contact by name or phone number -  ");
				query = input.nextLine().toLowerCase();
			}
			
			//-----------------is there any matching name or phone number?-----------------//
			if(search(query) == -1){
				//------------no match found-----------//
				System.out.printf("\n\tNo contacts found for %s...", query);
			}else{
				//------matching contact found------//
				printArray(query);
				
				System.out.print("\n\n  Do you want to delete this contact (Y/N): ");
				char ch = input.next().charAt(0);
				
				if(ch == 'Y' || ch == 'y'){

					deleteElements(search(query));    //delete the element
					System.out.println("\n\tContact has been deleted successfully...");

				}else if(ch == 'N' || ch == 'n'){
					clearConsole();
					homePage();
					return;
				}
			}
			
			System.out.print("\n\n  Do you want to delete another contact(Y/N): ");
			char ch = input.next().charAt(0);

			input.nextLine();
				
			if(ch == 'Y' || ch == 'y'){
				continue;
			}else if(ch == 'N' || ch == 'n'){
				clearConsole();
				homePage();
				return;
			}
		}
	}

	//-------------------search contacts----------------------//
	public static void searchContacts(){
		Scanner input = new Scanner(System.in);

		while(true){
			clearConsole();
				
			System.out.println("  +-----------------------------------------------------+");
			System.out.println("  |\t\t\tSearch contact\t\t\t|");
			System.out.println("  +-----------------------------------------------------+");
			
			System.out.print("\n\n  Search contact by name or phone number -  ");
			String query = input.nextLine().toLowerCase();
			
			//-----------------is valid name or phone number?-----------------//
			while(!isValidName(query) && !isValidPhoneNumber(query)){
				System.out.println("\n\tNot a valid name or phone number...");
				
				System.out.print("\n  Do you want to search again (Y/N): ");
				char ch = input.next().charAt(0);
				
				input.nextLine();
				
				if(ch == 'Y' || ch == 'y'){
					System.out.print("\033[7A");
					System.out.print("\033[0J");
				}else if(ch == 'N' || ch == 'n'){
					clearConsole();
					homePage();
					return;
				}
				
				System.out.print("\n\n  Search contact by name or phone number -  ");
				query = input.nextLine().toLowerCase();
			}
			
			//-----------------is there any matching name or phone number?-----------------//
			if(search(query) == -1){
				//------------no match found-----------//
				System.out.printf("\n\tNo contacts found for %s...", query);
			}else{
				//------matching contact found------//
				//------show matching contacts------//
				printArray(query);
			}
			
			System.out.print("\n\n  Do you want to search another contact(Y/N): ");
			char ch = input.next().charAt(0);

			input.nextLine();
				
			if(ch == 'Y' || ch == 'y'){
				continue;
			}else if(ch == 'N' || ch == 'n'){
				clearConsole();
				homePage();
				return;
			}
		}
	}

	//-------------------list contacts----------------------//
	public static void listContacts(){
		Scanner input = new Scanner(System.in);

		L1:while(true){
			clearConsole();
			
			System.out.println("  +-----------------------------------------------------+");
			System.out.println("  |\t\t\tSort contact\t\t\t|");
			System.out.println("  +-----------------------------------------------------+");
			
			System.out.println("\n\t[01] Sorting by Name");
			System.out.println("\n\t[02] Sorting by Salary");
			System.out.println("\n\t[03] Sorting by Birthday");

			System.out.print("\n\n  Enter an option to continue -> ");
			int option = input.nextInt();
				
			switch(option){
				case 1:
					//---------sorting by name---------//
					clearConsole();
					sortByName();
					printTable("name");
					break L1;
					
				case 2:
					//----------sorting by salary----------//
					clearConsole();
					sortBySalary();
					printTable("salary");
					break L1;
					
				case 3:
					//-----------sorting by birthday----------//
					clearConsole();
					sortByBirthday();
					printTable("b'day");
					break L1;
					
				default:
					//--------invalid option--------//
					continue;
			}
		}
		
		while(true){
			System.out.print("\n  Do you want to go to Home Page (Y/N): ");
			char ch = input.next().charAt(0);

			input.nextLine();
			
			if(ch == 'Y' || ch == 'y'){
				clearConsole();
				homePage();
				return;
			}else if(ch == 'N' || ch == 'n'){
				System.out.print("\033[2A");
				System.out.print("\033[0J");
				continue;
			}
		}
	}

	//-------------------check validity of the name----------------------//
    public static boolean isValidName(String name) {
		return name.length() != 0; 
    }

    //-------------------check validity of the phone number----------------------//
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return !phoneNumber.isEmpty() && Pattern.matches("0\\d{9}", phoneNumber);
    }

    //-------------------check validity of company name----------------------//
    public static boolean isValidCompanyName(String companyName) {
		return companyName.length() != 0; 
    }
    
    //-------------------check validity of salary----------------------//
    public static boolean isValidSalary(double salary) {
		return salary >= 0; 
    }
    
    //-------------------check validity of birthday----------------------//
    public static boolean isValidBirthDay(String birthDay) {
        try {
            LocalDate date = LocalDate.parse(birthDay);
            LocalDate currentDate = LocalDate.now();
            
            if (date.isAfter(currentDate)) {
                return false; //Birth date is in the future
            }
            return true; //Date is valid
            
        } catch (DateTimeParseException e) {
            return false;   //Invalid date format
        }
    }

	//-------------------clear console----------------------//
	public final static void clearConsole(){
		try {   
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			}else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	//-------------------generate contact ids----------------------//
	public static String generateContactId() {
        idCount++;
        String contactId = String.format("C%04d", idCount);
        return contactId;
    }
    
    //-------------------extend arrays----------------------//
    public static void extendArrays() {
        String[] tempContactIdArray = new String[contactIdArray.length + 1];
		String[] tempNameArray = new String[nameArray.length + 1];
		String[] tempPhoneNumberArray = new String[phoneNumberArray.length + 1];
		String[] tempCompanyNameArray = new String[companyNameArray.length + 1];
		double[] tempSalaryArray = new double[salaryArray.length + 1];
		String[] tempBirthDayArray = new String[birthDayArray.length + 1]; 
		
		for(int i = 0; i < contactIdArray.length; i++){
			tempContactIdArray[i] = contactIdArray[i];
			tempNameArray[i] = nameArray[i];
			tempPhoneNumberArray[i] = phoneNumberArray[i];
			tempCompanyNameArray[i] = companyNameArray[i];
			tempSalaryArray[i] = salaryArray[i];
			tempBirthDayArray[i] = birthDayArray[i];
		}
		
		contactIdArray = tempContactIdArray;
		nameArray = tempNameArray;
		phoneNumberArray = tempPhoneNumberArray;
		companyNameArray = tempCompanyNameArray;
		salaryArray = tempSalaryArray;
		birthDayArray = tempBirthDayArray;
    }
    
    //-------------------delete elements----------------------//
    public static void deleteElements(int x) {
        String[] tempContactIdArray = new String[contactIdArray.length - 1];
		String[] tempNameArray = new String[nameArray.length - 1];
		String[] tempPhoneNumberArray = new String[phoneNumberArray.length - 1];
		String[] tempCompanyNameArray = new String[companyNameArray.length - 1];
		double[] tempSalaryArray = new double[salaryArray.length - 1];
		String[] tempBirthDayArray = new String[birthDayArray.length - 1];
		
		for (int i = 0, j = 0; i < contactIdArray.length; i++) {
			if(i == x){
				continue;
			}
			tempContactIdArray[j] = contactIdArray[i];
			tempNameArray[j] = nameArray[i];
			tempPhoneNumberArray[j] = phoneNumberArray[i];
			tempCompanyNameArray[j] = companyNameArray[i];
			tempSalaryArray[j] = salaryArray[i];
			tempBirthDayArray[j] = birthDayArray[i];
			j++;
		}
		
		contactIdArray = tempContactIdArray;
		nameArray = tempNameArray;
		phoneNumberArray = tempPhoneNumberArray;
		companyNameArray = tempCompanyNameArray;
		salaryArray = tempSalaryArray;
		birthDayArray = tempBirthDayArray;
    }
    
    //-------------------search name or phone number existance----------------------//
    public static int search(String query){
		for(int i = 0; i < contactIdArray.length; i++){
			if(nameArray[i].equals(query) || phoneNumberArray[i].equals(query)){
				return i;
			}
		}
		return -1;
	}

	//-------------------search phone number duplicate or not----------------------//
    public static boolean isDuplicate(String phoneNumber){
		for(int i = 0; i < contactIdArray.length; i++){
			if(phoneNumberArray[i].equals(phoneNumber)){
				return true;
			}
		}
		return false;
	}

	//-------------------sort by name----------------------//
    public static void sortByName(){
        for(int i = 0; i < nameArray.length - 1; i++) {
            for(int j = 0; j < nameArray.length - 1 - i; j++){
                if(nameArray[j].compareTo(nameArray[j + 1]) > 0){       //compares two strings lexicographically

                    String temp1 = nameArray[j];
                    nameArray[j] = nameArray[j + 1];
                    nameArray[j + 1] = temp1;

					String temp2 = contactIdArray[j];
                    contactIdArray[j] = contactIdArray[j + 1];
                    contactIdArray[j + 1] = temp2;

					String temp3 = phoneNumberArray[j];
                    phoneNumberArray[j] = phoneNumberArray[j + 1];
                    phoneNumberArray[j + 1] = temp3;

					String temp4 = companyNameArray[j];
                    companyNameArray[j] = companyNameArray[j + 1];
                    companyNameArray[j + 1] = temp4;

					double temp5 = salaryArray[j];
                    salaryArray[j] = salaryArray[j + 1];
                    salaryArray[j + 1] = temp5;

					String temp6 = birthDayArray[j];
                    birthDayArray[j] = birthDayArray[j + 1];
                    birthDayArray[j + 1] = temp6;
                }
            }
        }
    }

	//------------------sort by salary----------------------//
    public static void sortBySalary(){
        for(int i = 0; i < salaryArray.length - 1; i++) {
            for(int j = 0; j < salaryArray.length - 1 - i; j++){
                if(salaryArray[j] > salaryArray[j + 1]){           //compare salary numerically

					double temp1 = salaryArray[j];
                    salaryArray[j] = salaryArray[j + 1];
                    salaryArray[j + 1] = temp1;

					String temp2 = contactIdArray[j];
                    contactIdArray[j] = contactIdArray[j + 1];
                    contactIdArray[j + 1] = temp2;

                    String temp3 = nameArray[j];
                    nameArray[j] = nameArray[j + 1];
                    nameArray[j + 1] = temp3;

					String temp4 = phoneNumberArray[j];
                    phoneNumberArray[j] = phoneNumberArray[j + 1];
                    phoneNumberArray[j + 1] = temp4;

					String temp5 = companyNameArray[j];
                    companyNameArray[j] = companyNameArray[j + 1];
                    companyNameArray[j + 1] = temp5;

					String temp6 = birthDayArray[j];
                    birthDayArray[j] = birthDayArray[j + 1];
                    birthDayArray[j + 1] = temp6;
                }
            }
        }
    }

	//-----------------sort by birthday----------------------//
    public static void sortByBirthday(){
        for(int i = 0; i < birthDayArray.length - 1; i++) {
            for(int j = 0; j < birthDayArray.length - 1 - i; j++){
                if(birthDayArray[j].compareTo(birthDayArray[j + 1]) > 0){        //comparing the dates chronologically.

					String temp1 = birthDayArray[j];
                    birthDayArray[j] = birthDayArray[j + 1];
                    birthDayArray[j + 1] = temp1;

					String temp2 = contactIdArray[j];
                    contactIdArray[j] = contactIdArray[j + 1];
                    contactIdArray[j + 1] = temp2;

                    String temp3 = nameArray[j];
                    nameArray[j] = nameArray[j + 1];
                    nameArray[j + 1] = temp3;

					String temp4 = phoneNumberArray[j];
                    phoneNumberArray[j] = phoneNumberArray[j + 1];
                    phoneNumberArray[j + 1] = temp4;

					String temp5 = companyNameArray[j];
                    companyNameArray[j] = companyNameArray[j + 1];
                    companyNameArray[j + 1] = temp5;

					double temp6 = salaryArray[j];
                    salaryArray[j] = salaryArray[j + 1];
                    salaryArray[j + 1] = temp6;
                }
            }
        }
    }
    
    //----------------print array-------------------//
    public static void printArray(String query){
		System.out.printf("\n\n\tContact ID\t\t: %s", contactIdArray[search(query)]);
		System.out.printf("\n\tName\t\t\t: %s", nameArray[search(query)]);
		System.out.printf("\n\tPhone Number\t\t: %s", phoneNumberArray[search(query)]);
		System.out.printf("\n\tCompany Name\t\t: %s", companyNameArray[search(query)]);
		System.out.printf("\n\tSalary\t\t\t: %s", salaryArray[search(query)]);
		System.out.printf("\n\tB'Day(YYYY-MM-DD)\t: %s", birthDayArray[search(query)]);
	}

	//----------------print contacts table-------------------//
	public static void printTable(String str){
		System.out.println("                  +-------------------------------------------------------------+");
		System.out.printf("                  |\t\t\tList contact by %s\t\t\t|\n", str);
		System.out.println("                  +-------------------------------------------------------------+");
		System.out.println();
		System.out.println(" +-----------------------------------------------------------------------------------------------+");
		System.out.println(" | Contact ID  |     Name     |  Phone Number  |    Company    |     Salary     |    Birthday    |");
		System.out.println(" +-----------------------------------------------------------------------------------------------+");

		for(int i = 0; i < contactIdArray.length; i++){
			System.out.printf(" | %-12s| %-13s|   %-13s|  %-13s|%,13.2f   |  %-14s|\n", contactIdArray[i], nameArray[i], phoneNumberArray[i], companyNameArray[i], salaryArray[i], birthDayArray[i]);	
		}
		System.out.println(" +-----------------------------------------------------------------------------------------------+");
	}
}
	



