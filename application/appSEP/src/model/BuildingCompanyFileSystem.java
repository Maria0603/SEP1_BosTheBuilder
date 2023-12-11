package model;

import java.io.*;
import java.util.ArrayList;

/**
 * The {@code BuildingCompanyFileSystem} class handles the file system operations for a building company,
 * including creating a report file and updating ongoing and finished project lists in binary files.
 * It uses serialization to persist ongoing and finished project data.
 */
public class BuildingCompanyFileSystem implements Serializable {

    private static final String REPORT_FILE_PATH = "report.txt";
    private static final String ONGOING_FILE_PATH = "ongoing.bin";
    private static final String FINISHED_FILE_PATH = "finished.bin";

    /**
     * Creates a report file in plain text format based on the provided project list.
     *
     * @param projectListForReport The list of projects for which to generate the report.
     * @throws IllegalArgumentException If the project list is null or empty.
     */
    public void createReportTXTFile(ArrayList<Project> projectListForReport) {
        if (projectListForReport == null || projectListForReport.isEmpty()) {
            throw new IllegalArgumentException("Project list cannot not be null");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(REPORT_FILE_PATH))) {
            for (Project project : projectListForReport) {
                writer.println(project.toString());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error found in creating report file", e);
        }
    }

    /**
     * Updates the binary file containing the finished project list with the provided data.
     *
     * @param finishedList The finished project list to be serialized and saved to the file.
     * @throws IllegalArgumentException If the finished project list is null.
     */
    public void updateFinishedBINfile(FinishedProjectList finishedList) {
        if (finishedList == null) {
            throw new IllegalArgumentException("Finished project list cannot not be null");
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FINISHED_FILE_PATH))) {
            objectOutputStream.writeObject(finishedList);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error updating the finished file", e);
        }
    }

    /**
     * Reads the binary file containing the ongoing project list and returns it.
     *
     * @return The ongoing project list read from the file.
     * @throws IllegalArgumentException If an error occurs while reading from the file.
     */
    public FinishedProjectList readFromOngoingBINfile() {
        FinishedProjectList finishedList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ONGOING_FILE_PATH))) {
            finishedList = (FinishedProjectList) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException("Error reading from ongoing file", e);
        }
        return finishedList;
    }
}
