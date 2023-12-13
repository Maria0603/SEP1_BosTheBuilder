package model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Handles reading and writing project data to XML files and creating a report TXT file.
 */
public class FilePersistance {

  /**
   * Reads ongoing projects from the Ongoing XML file.
   *
   * @return The ongoing project list.
   */
  public OngoingProjectList readFromOngoingFXMLFile() {
    try {
      File file = new File("./Ongoing.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(OngoingProjectList.class, Project.class, Residential.class, Commercial.class, Industrial.class, Road.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      return (OngoingProjectList) jaxbUnmarshaller.unmarshal(file);
    } catch (JAXBException e) {
      e.printStackTrace();
      return new OngoingProjectList(); // return an empty list if an error occurs
    }
  }

  /**
   * Reads finished projects from the Finished XML file.
   *
   * @return The finished project list.
   */
  public FinishedProjectList readFromFinishedFXMLFile() {
    try {
      File file = new File("./Finished.xml");
      JAXBContext context = JAXBContext.newInstance(FinishedProjectList.class, Project.class, Residential.class, Commercial.class, Industrial.class, Road.class);
      Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
      return (FinishedProjectList) jaxbUnmarshaller.unmarshal(file);
    } catch (JAXBException e) {
      e.printStackTrace();
      return new FinishedProjectList(); // return an empty list if an error occurs
    }
  }

  /**
   * Writes the finished project list to the Finished XML file.
   *
   * @param finishedProjectList The finished project list to be written.
   */
  public static void writeToFinishedXMLFile(FinishedProjectList finishedProjectList) {
    try {
      JAXBContext context = JAXBContext.newInstance(FinishedProjectList.class, Project.class, Residential.class, Commercial.class, Industrial.class, Road.class);
      Marshaller mar = context.createMarshaller();
      mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      mar.marshal(finishedProjectList, new File("./Finished.xml"));
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

  /**
   * Writes the ongoing project list to the Ongoing XML file.
   *
   * @param ongoingProjectList The ongoing project list to be written.
   */
  public static void writeToOngoingXMLFile(OngoingProjectList ongoingProjectList) {
    try {
      JAXBContext context = JAXBContext.newInstance(OngoingProjectList.class, Project.class, Residential.class, Commercial.class, Industrial.class, Road.class);
      Marshaller mar = context.createMarshaller();
      mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      mar.marshal(ongoingProjectList, new File("./Ongoing.xml"));
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates a report TXT file with project details.
   *
   * @param projectListForReport The list of projects for the report.
   */
  public static void createReportTXTFile(ArrayList<Project> projectListForReport) {
    try (PrintWriter writer = new PrintWriter(new File("ProjectReport.txt"))) {
      for (Project project : projectListForReport) {
        writer.println(project.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Main method for testing purposes.
   *
   * @param args Command line arguments.
   * @throws JAXBException If there's an issue with JAXB.
   */
  public static void main(String[] args) throws JAXBException {
    FilePersistance fileSystem = new FilePersistance();

    // Read the finished projects from the XML file
    FinishedProjectList finishedProjects = fileSystem.readFromFinishedFXMLFile();
    System.out.println("\nFinished Projects:");
    for (Project project : finishedProjects.getFinishedProjects()) {
      System.out.println(project);
    }
    MyDate startDate = new MyDate(1, 1, 2020);
    MyDate endDate = new MyDate(31, 12, 2020);
    MyDate date1 = new MyDate(10, 2, 2020);
    MyDate date2 = new MyDate(15, 6, 2020);
    MyDate date3 = new MyDate(20, 10, 2020);
    // Create some sample projects
    Project residentialProject = new Residential(1, "Residential Project", 3000, 12, date1, endDate, 120, 1, 1, 1, true, 87);
    Project commercialProject = new Commercial(2, "Commercial Project", 6000, 24, date2, endDate, 240, 2, "Retail");
    Project industrialProject = new Industrial(3, "Industrial Project", 12000, 36, date3, endDate, 480, "Factory");
    // Add them to the finished project list
    FinishedProjectList finishedProjectList = new FinishedProjectList();
    finishedProjectList.addToFinishedList(residentialProject);
    finishedProjectList.addToFinishedList(commercialProject);
    finishedProjectList.addToFinishedList(industrialProject);

    writeToFinishedXMLFile(finishedProjectList);

    createReportTXTFile((ArrayList<Project>) finishedProjectList.getFinishedProjects());
  }
}
