// Java program to create a file "data.txt"
// and add a new contact in the file

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

class AddFriend {

    public static String addFriend(String newName, String newNumberStr)
    {

        try {

            // Get the number to be updated
            // from the Command line argument
            long newNumber = Long.parseLong(newNumberStr);

            String nameNumberString;
            String name;
            long number;
            int index;

            // Using file pointer creating the file.
            File file = new File("data.txt");

            if (!file.exists()) {

                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.

            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Checking whether the name
            // of contact already exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // skip empty or malformed lines
                if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");

                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // if condition to find existence of record.
                if (name.equals(newName)
                    || number == newNumber) {
                    found = true;
                    break;
                }
            }

            if (found == false) {

                // Enter the if block when a record
                // is not already present in the file.
                nameNumberString
                    = newName + "!"
                      + String.valueOf(newNumber);

                // writeBytes function to write a string
                // as a sequence of bytes.
                raf.writeBytes(nameNumberString);

                // To insert the next record in new line.
                raf.writeBytes(System.lineSeparator());

                // Closing the resources.
                raf.close();

                // Return the message
                return " Friend added. ";
            }
            // The contact to be updated
            // could not be found
            else {

                // Closing the resources.
                raf.close();

                // Return the message
                return " Input name does not exists. ";
            }
        }

        catch (IOException ioe) {

            return ioe.toString();
        }
        catch (NumberFormatException nef) {

            return nef.toString();
        }
    }
}


// Java program to read from file "data.txt"
// and display the contacts
class DisplayFriends {

    public static List<String[]> displayFriends(String searchName)
    {

        List<String[]> results = new ArrayList<>();

        try {

            String nameNumberString;
            String name;
            long number;
            int index;

            // Using file pointer creating the file.
            File file = new File("data.txt");

            if (!file.exists()) {

                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.

            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");

            // Traversing the file
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // skip empty or malformed lines
                if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");

                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // Add contact to results if it matches the search
                if (searchName.isEmpty() || name.equals(searchName)) {
                    results.add(new String[]{ name, String.valueOf(number) });
                }
            }

            // Closing the resources.
            raf.close();
        }

        catch (IOException ioe) {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {

            System.out.println(nef);
        }

        return results;
    }
}


// Java program to update in the file "data.txt"
// and change the number of an old contact
class UpdateFriend {

    public static String updateFriend(String newName, String newNumberStr)
    {

        try {

            // Get the number to be updated
            // from the Command line argument
            long newNumber = Long.parseLong(newNumberStr);

            String nameNumberString;
            String name;
            long number;
            int index;

            // Using file pointer creating the file.
            File file = new File("data.txt");

            if (!file.exists()) {

                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Checking whether the name
            // of contact already exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // skip empty or malformed lines
                if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");

                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // if condition to find existence of record.
                if (name.equals(newName)
                    || number == newNumber) {
                    found = true;
                    break;
                }
            }

            // Update the contact if record exists.
            if (found == true) {

                // Creating a temporary file
                // with file pointer as tmpFile.
                File tmpFile = new File("temp.txt");

                // Opening this temporary file
                // in ReadWrite Mode
                RandomAccessFile tmpraf
                    = new RandomAccessFile(tmpFile, "rw");

                // Set file pointer to start
                raf.seek(0);

                // Traversing the data.txt file
                while (raf.getFilePointer()
                       < raf.length()) {

                    // Reading the contact from the file
                    nameNumberString = raf.readLine();

                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(
                        0, index);

                    // Check if the fetched contact
                    // is the one to be updated
                    if (name.equals(newName)) {

                        // Update the number of this contact
                        nameNumberString
                            = name + "!"
                              + String.valueOf(newNumber);
                    }

                    // Add this contact in the temporary
                    // file
                    tmpraf.writeBytes(nameNumberString);

                    // Add the line separator in the
                    // temporary file
                    tmpraf.writeBytes(
                        System.lineSeparator());
                }

                // The contact has been updated now
                // So copy the updated content from
                // the temporary file to original file.

                // Set both files pointers to start
                raf.seek(0);
                tmpraf.seek(0);

                // Copy the contents from
                // the temporary file to original file.
                while (tmpraf.getFilePointer()
                       < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }

                // Set the length of the original file
                // to that of temporary.
                raf.setLength(tmpraf.length());

                // Closing the resources.
                tmpraf.close();
                raf.close();

                // Deleting the temporary file
                tmpFile.delete();

                return " Friend updated. ";
            }

            // The contact to be updated
            // could not be found
            else {

                // Closing the resources.
                raf.close();

                // Return the message
                return " Input name does not exists. ";
            }
        }

        catch (IOException ioe) {
            return ioe.toString();
        }

        catch (NumberFormatException nef) {
            return nef.toString();
        }
    }
}


// Java program to delete a contact
// from the file "data.txt"
class DeleteFriend {

    public static String deleteFriend(String newName)
    {

        try {

            String nameNumberString;
            String name;
            long number;
            int index;

            // Using file pointer creating the file.
            File file = new File("data.txt");

            if (!file.exists()) {

                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Checking whether the name of contact exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // skip empty or malformed lines
                if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");

                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // if condition to find existence of record.
                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }

            // Delete the contact if record exists.
            if (found == true) {

                // Creating a temporary file
                // with file pointer as tmpFile.
                File tmpFile = new File("temp.txt");

                // Opening this temporary file
                // in ReadWrite Mode
                RandomAccessFile tmpraf
                    = new RandomAccessFile(tmpFile, "rw");

                // Set file pointer to start
                raf.seek(0);

                // Traversing the data.txt file
                while (raf.getFilePointer()
                       < raf.length()) {

                    // Reading the contact from the file
                    nameNumberString = raf.readLine();

                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(
                        0, index);

                    // Check if the fetched contact
                    // is the one to be deleted
                    if (name.equals(newName)) {

                        // Skip inserting this contact
                        // into the temporary file
                        continue;
                    }

                    // Add this contact in the temporary
                    // file
                    tmpraf.writeBytes(nameNumberString);

                    // Add the line separator in the
                    // temporary file
                    tmpraf.writeBytes(
                        System.lineSeparator());
                }

                // The contact has been deleted now
                // So copy the updated content from
                // the temporary file to original file.

                // Set both files pointers to start
                raf.seek(0);
                tmpraf.seek(0);

                // Copy the contents from
                // the temporary file to original file.
                while (tmpraf.getFilePointer()
                       < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }

                // Set the length of the original file
                // to that of temporary.
                raf.setLength(tmpraf.length());

                // Closing the resources.
                tmpraf.close();
                raf.close();

                // Deleting the temporary file
                tmpFile.delete();

                return " Friend deleted. ";
            }

            // The contact to be deleted
            // could not be found
            else {

                // Closing the resources.
                raf.close();

                // Return the message
                return " Input name does not exists. ";
            }
        }

        catch (IOException ioe) {
            return ioe.toString();
        }
    }
}
