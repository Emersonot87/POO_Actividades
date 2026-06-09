import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


// Create a file "data.txt"
// Add a contact to the file "data.txt"
class AddFriend {

    public static void addFriend(String newName, String newNumberStr)
    {

        try {

            long newNumber = Long.parseLong(newNumberStr);

            String nameNumberString;
            String name;
            long number;

            File file = new File("data.txt");

            if (file.exists()==false) {

                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {

                nameNumberString = raf.readLine();

                if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                String[] lineSplit = nameNumberString.split("!");

                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                if (name.equals(newName) && number == newNumber) {
                    found = true;
                    JOptionPane.showMessageDialog(null, "Attention " + newName + " is already in the list.");
                    break;
                }
            }

            if (found == false) {

                nameNumberString = newName + "!" + String.valueOf(newNumber);

                raf.writeBytes(nameNumberString);
                raf.writeBytes(System.lineSeparator());
                JOptionPane.showMessageDialog(null, "The friend " + newName + " has been added.");
                raf.close();
            }

            else {

                raf.close();
            }
        }

        catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, ioe.toString());
        }
        catch (NumberFormatException nef) {

            JOptionPane.showMessageDialog(null, nef.toString());
        }
    }
}


//Read from file "data.txt"
class DisplayFriends {

    public static List<String[]> displayFriends(String searchName)
    {

        List<String[]> results = new ArrayList<>();

        try {

            String nameNumberString;
            String name;
            long number;
            File file = new File("data.txt");

            if (file.exists()==false) {

                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            while (raf.getFilePointer() < raf.length()) {

                nameNumberString = raf.readLine();

                if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                String[] lineSplit = nameNumberString.split("!");

                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                if (searchName.isEmpty() || name.equals(searchName)) {
                    results.add(new String[]{ name, String.valueOf(number) });
                }
            }

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


// Update in the file "data.txt"
class UpdateFriend {

    public static void updateFriend(String newName, String newNumberStr)
    {

        try {

            long newNumber = Long.parseLong(newNumberStr);
            String nameNumberString;
            String name;
            long number;
            int index;
            File file = new File("data.txt");

            if (file.exists() == false) {

                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {

                nameNumberString = raf.readLine();

                if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                String[] lineSplit = nameNumberString.split("!");
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                if (name.equals(newName) || number == newNumber) {
                    found = true;
                    break;
                }
            }

            if (found == true) {

                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

                raf.seek(0);

                boolean updated = false;

                while (raf.getFilePointer() < raf.length()) {

                    nameNumberString = raf.readLine();

                    if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(0, index);

                    if (name.equals(newName) && !updated) { 

                        nameNumberString = name + "!" + String.valueOf(newNumber);
                        updated = true;
                    }

                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes( System.lineSeparator());
                }

                raf.seek(0);
                tmpraf.seek(0);

                while (tmpraf.getFilePointer()< tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }

                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();

                JOptionPane.showMessageDialog(null, "The friend's number of " + newName + " has been updated.");
            }

            else {

                raf.close();
                
                JOptionPane.showMessageDialog(null, " Input name does not exists. ");
            }
        }

        catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.toString());
        }

        catch (NumberFormatException nef) {
            JOptionPane.showMessageDialog(null, nef.toString());
        }
    }
}


// Delete a contact from the file "data.txt"
class DeleteFriend {

    public static void deleteFriend(String newName)
    {
        try {

            String nameNumberString;
            String name;
            long number;
            int index;
            File file = new File("data.txt");

            if (file.exists() == false) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            while (raf.getFilePointer() < raf.length()) {

                nameNumberString = raf.readLine();

                if (nameNumberString == null || !nameNumberString.contains("!")) continue;

                String[] lineSplit = nameNumberString.split("!");

                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }

            if (found == true) {

                File tmpFile = new File("temp.txt");

                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

                raf.seek(0);

                while (raf.getFilePointer() < raf.length()) {

                    nameNumberString = raf.readLine();
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(0, index);

                    if (name.equals(newName)) {
                        continue;
                    }

                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(System.lineSeparator());
                }

                raf.seek(0);
                tmpraf.seek(0);

                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }

                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();

                JOptionPane.showMessageDialog(null, "The contact " + newName + " was removed from the data.");
            }

            else {

                raf.close();

                JOptionPane.showMessageDialog(null, "Input name does not exist in the data.");
            }
        }

        catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, ioe.toString());
        }
    }
}
