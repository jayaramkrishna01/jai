package package1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LockMe {
	static final String errorMessage = "Oops!!! Sorry we are facing an issue. Please contact admin: admin@LockedMe.Com";
	static final String projectFilesPath ="D:\\Phase1\\Jairam";
	static Scanner obj = new Scanner(System.in);
	public static void main(String[]args) throws IOException
	{
	int ch;
	do
	{
	displayMenu();
	System.out.println("Enter your choice");
	ch=Integer.parseInt(obj.next());
	switch(ch)
	{
	case 1:
	getAllFiles();
	break;
	case 2:createFiles();
	break;
	case 3: deleteAllFiles();
	break;
	case 4: searchFiles();
	break;
	case 5: System.exit(0);
	break;
	default:System.out.println("Invalid option");
	}
	}
	while(ch>0);
	obj.close();
	}
public static void displayMenu()
{
	System.out.println("\t=================================");
	System.out.println("\tWelcome to LockMe.com");
	System.out.println("\t=================================");
	System.out.println("\t This Site is Built and Designed by Jairam");
	System.out.println("\t1. Display all the files");
	System.out.println("\t2. Add a new file");
	System.out.println("\t3. Delete a file");
	System.out.println("\t4. Search a file");
	System.out.println("\t5. Exit");

	}
public static void getAllFiles()
{
try {
File folder = new File(projectFilesPath);
File[] listOfFiles = folder.listFiles();
if(listOfFiles.length==0)
{
System.out.println("No Files exist");
}
else
{
for(var l:listOfFiles)
{
System.out.println(l.getName());
}
}
}
catch(Exception Ex)
{
System.out.println(errorMessage);
}
}
public static void createFiles() throws IOException
{
try
{

String fileName;
System.out.println("Enter the filename: ");
fileName = obj.next();
int linesCount;
System.out.println("Enter how many lines in the file");
linesCount = Integer.parseInt(obj.next());
FileWriter myWriter = new
FileWriter(projectFilesPath+"\\"+fileName);
for(int i=1;i<=linesCount;i++)
{

System.out.println("Enter the file line : ");

myWriter.write(obj.next()+"\n");
}
System.out.println("File has been created successfully.");
myWriter.close();   
}
catch(Exception ex)
{
System.out.println("Some error has occcured");
}
}
/*This method will delete the file based on the user input if it exists*/
public static void deleteAllFiles()
{

try
{
String fileName;
System.out.println("Enter the file name to be deleted");
fileName = obj.next();
File file = new File(projectFilesPath+"\\"+fileName);
if(file.exists())
{
file.delete();
System.out.println("File deleted SuccessFully : "+fileName);
}
else
System.out.println("File do not exists");
}
catch(Exception ex)
{
System.out.println(errorMessage);
}
finally
{
obj.close();
}
}
/*This method will search the files from the directory*/
public static void searchFiles()
{
try
{
String fileName;

System.out.println("Enter the file name to be Searched");
fileName = obj.next();
File folder = new File(projectFilesPath);
File[] listOfFiles = folder.listFiles();
LinkedList<String> filenames = new LinkedList<String>();
for(var l:listOfFiles)
filenames.add(l.getName());
if(filenames.contains(fileName))
System.out.println("File is available");
else
System.out.println("File is not available");
}
catch(Exception ex)
{
System.out.println(errorMessage);
} finally
{
obj.close();
}
}
}







