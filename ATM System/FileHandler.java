import java.io.*;
import java.util.*;

public class FileHandler {
	private static final String file_path = "users.txt";
	
	public static Map<Integer, String[]> readUsers() {
		Map<Integer, String[]> users = new HashMap<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file_path))) {
			String line;
			
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int userID = Integer.parseInt(data[0]);
				users.put(userID, new String[]{data[1], data[2], data[3]});
			}
		} catch (IOException e) {
			System.out.println("Error reading users!");
		}
		
		return users;
	}
	
	public static synchronized void updateBalance(int userID, double newBalance) {
		Map<Integer, String[]> users = readUsers();
		users.get(userID)[2] = String.valueOf(newBalance);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
			for (Map.Entry<Integer, String[]> entry : users.entrySet()) {
				writer.write(entry.getKey() + "," + entry.getValue()[0] + "," + entry.getValue()[1] + "," + entry.getValue()[2]);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error updating users file.");
		}
	}
	
	public static synchronized void logTransaction(int userID, String type, double amount) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {
			writer.write(userID + "," + type + "," + amount + new Date());
			writer.newLine();
		} catch (IOException e) {
			System.out.println("Error logging transaction.");
		}
	}
} 
