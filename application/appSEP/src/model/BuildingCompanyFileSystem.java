package model;

import java.io.*;
import java.util.ArrayList;
public class BuildingCompanyFileSystem implements Serializable {

    private static final String REPORT_FILE_PATH = "report.txt";
    private static final String ONGOING_FILE_PATH = "ongoing.bin";
    private static final String FINISHED_FILE_PATH = "finished.bin";

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

    public void updateOngoingBINfile(OngoingProjectList ongoingList) {if (ongoingList == null) {
     throw new IllegalArgumentException("Ongoing project list cannot not be null");
     }

     try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ONGOING_FILE_PATH))) {
          objectOutputStream.writeObject(ongoingList);      } catch (IOException e) {
           throw new IllegalArgumentException("Error updating  the ongoing file", e);
       }
    }

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

//    public OngoingProjectList readFromFinishedBINfile() {
//        OngoingProjectList ongoingList = null;
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FINISHED_FILE_PATH))) {
//            ongoingList = (OngoingProjectList) objectInputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            throw new IllegalArgumentException("Error reading from the  finished file", e);
//        }
//        return ongoingList;
//    }

    public FinishedProjectList readFromOngoingBINfile() {
        FinishedProjectList finishedList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ONGOING_FILE_PATH))) {
            finishedList = (FinishedProjectList) ois.readObject();
        } catch (IOException |  ClassNotFoundException e) {
            throw new IllegalArgumentException("Error reading from ongoing file", e);
        }
        return finishedList;
    }

}

