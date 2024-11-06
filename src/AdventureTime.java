import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("testInputOneTwo.txt"));
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("testInputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("testInputThreeFour.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("testInputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));
        writeFileAllAnswers("AdventureTime.txt", challengeOne("inputOneTwo.txt"), challengeTwo("inputOneTwo.txt"), challengeThree("inputThreeFour.txt"), challengeFour("inputThreeFour.txt"));
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        // File f1 = new File(fileName);
        // int[] arr = new int[countLinesInFile(fileName)];
        // Scanner sc = new Scanner(f1);
        // int index = 0;
        // while (sc.hasNextLine()){
        //     arr[index++] = sc.nextInt();
        // }
        int[] arr = readFile(fileName);
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) count++;
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] arr = readFile(fileName);
        int[] arr2 = new int[arr.length - 2];
        for (int i = 0; i < arr.length - 2; i++) {
            arr2[i] = arr[i] + arr[i + 1] + arr[i + 2];
        }
        int count = 0;
        for (int i = 0; i < arr2.length - 1; i++) {
            if (arr2[i] < arr2[i + 1]) count++;
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] arr = readFile2(fileName);
        int[] coords = {0, 0};
        for (String arr1 : arr) {
            if (arr1.split(" ")[0].equals("forward")) {
                coords[0] += Integer.parseInt(arr1.split(" ")[1]);
            }
            if (arr1.split(" ")[0].equals("down")) {
                coords[1] += Integer.parseInt(arr1.split(" ")[1]);
            }
            if (arr1.split(" ")[0].equals("up")) {
                coords[1] -= Integer.parseInt(arr1.split(" ")[1]);
            }
        }
        return coords[0] * coords[1];
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] arr = readFile2(filename);
        int[] coords = {0, 0};
        int aim = 0;
        for (String arr1 : arr) {
            if (arr1.split(" ")[0].equals("forward")) {
                coords[0] += Integer.parseInt(arr1.split(" ")[1]);
                coords[1] += Integer.parseInt(arr1.split(" ")[1]) * aim;
            }
            if (arr1.split(" ")[0].equals("down")) {
                aim += Integer.parseInt(arr1.split(" ")[1]);
            }
            if (arr1.split(" ")[0].equals("up")) {
                aim -= Integer.parseInt(arr1.split(" ")[1]);
            }
        }
        return coords[0] * coords[1];
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFile2(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}