package de.hbrs.HighPerformance.shell;


import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.entities.SalesMan;
import de.hbrs.HighPerformance.factory.EvaluationRecords;
import de.hbrs.HighPerformance.factory.Salesmen;
import de.hbrs.HighPerformance.service.ManagePersonalImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Component;

import java.util.List;

@ShellComponent
@Component
@Data
@Slf4j
public class CommandImpl implements Command {

    private final ManagePersonalImpl managePersonal;
    private final String DATABASE = "Database";
    private final String SALESMAN = "Salesman";
    private final String RECORDS = "Records";

    @ShellMethod(
            key = "init",
            value = "Initialize the database with [--salesmen] Salesmen and [--records] Records",
            group = DATABASE
    )
    @Override
    public void init(@ShellOption(defaultValue = "5", help = "Number of Salesmen to be created") int salesmen,
                     @ShellOption(defaultValue = "2", help = "Number of Records for each Salesman") int records) {
        log.info("Initializing the database...");
        List<SalesMan> salesMen = Salesmen.generateSalesMen(salesmen, records);
        managePersonal.deleteAllSalesMen();
        List<SalesMan> allSalesMen = managePersonal.createAllSalesMen(salesMen);
        log.info("Database initialized with " + allSalesMen.size() + " Salesmen");
    }

    @ShellMethod(key = "get", value = "Get the Salesman with the ID [--employeeId].", group = SALESMAN)
    @Override
    public void readSalesMan(int employeeId) {
        log.info("Getting the Salesman with ID " + employeeId + "...");
        SalesMan salesMan = managePersonal.readSalesMan(employeeId);
        log.info("Result: " + salesMan);
    }

    @ShellMethod(key = "get-all", value = "Get all Salesmen.", group = SALESMAN)
    @Override
    public void readAllSalesMen() {
        log.info("Getting All Salesmen...");
        List<SalesMan> salesMen = managePersonal.readAllSalesMen();
        log.info("Result: " + salesMen);
    }

    @ShellMethod(key = "create", value = "Create a new Salesman.", group = SALESMAN)
    @Override
    public void createSalesMan(Integer employeeId,
                               @ShellOption(defaultValue = "first-name") String firstName,
                               @ShellOption(defaultValue = "middle-name") String middleName,
                               @ShellOption(defaultValue = "last-name") String lastName,
                               @ShellOption(defaultValue = "full-name") String fullName,
                               @ShellOption(defaultValue = "job") String jobTitle,
                               @ShellOption(defaultValue = "") List<EvaluationRecord> records) {
        log.info("Creating a new Salesman...");
        SalesMan salesMan = Salesmen.create(employeeId, firstName, middleName, lastName, fullName, jobTitle, records);
        salesMan = managePersonal.createSalesMan(salesMan);
        log.info("Successfully created");
        log.info("Created Salesman: " + salesMan);
    }

    @ShellMethod(key = "update", value = "Update an existing Salesman.", group = SALESMAN)
    @Override
    public void updateSalesMan(Integer employeeId,
                               @ShellOption(defaultValue = "first-name") String firstName,
                               @ShellOption(defaultValue = "middle-name") String middleName,
                               @ShellOption(defaultValue = "last-name") String lastName,
                               @ShellOption(defaultValue = "full-name") String fullName,
                               @ShellOption(defaultValue = "job") String jobTitle,
                               @ShellOption(defaultValue = "") List<EvaluationRecord> records) {
        log.info("Updating the Salesman with ID " + employeeId + "...");
        SalesMan salesMan = Salesmen.create(employeeId, firstName, middleName, lastName, fullName, jobTitle, records);
        salesMan = managePersonal.updateSalesMan(salesMan);
        log.info("Successfully updated");
        log.info("Updated Salesman: " + salesMan);
    }

    @ShellMethod(key = "delete", value = "Delete an existing Salesman by ID.", group = SALESMAN)
    @Override
    public void deleteSalesMan(int employeeId) {
        log.info("Deleting the Salesman with ID " + employeeId + "...");
        managePersonal.deleteSalesMan(employeeId);
        log.info("Successfully deleted");
    }

    @ShellMethod(key = "get-record", value = "Get all record related to the Salesman having the ID [--employeeId].",
            group = RECORDS)
    @Override
    public void readEvaluationRecords(int employeeId) {
        log.info("Getting Records for the Salesman with ID " + employeeId + "...");
        List<EvaluationRecord> records = managePersonal.readEvaluationRecords(employeeId);
        log.info("Result: " + records);
    }

    @ShellMethod(key = "add-record", value = "Add record to the Salesman having the ID [--employeeId].",
            group = RECORDS)
    @Override
    public void addPerformanceRecord(Integer goalId,
                                     @ShellOption(defaultValue = "Here is a goal description") String goalDescription,
                                     @ShellOption(defaultValue = "100") Integer targetValue,
                                     @ShellOption(defaultValue = "100") Integer actualValue,
                                     @ShellOption(defaultValue = "2022") Integer year,
                                     int employeeId) {
        log.info("Adding a record to the Salesman with ID " + employeeId + "...");
        EvaluationRecord record = EvaluationRecords.create(goalId, goalDescription, targetValue, actualValue, year);
        long records = managePersonal.addPerformanceRecord(record, employeeId);
        log.info(records + " Records added successfully");
    }

    @ShellMethod(key = "update-record", value = "Update record to the Salesman having the ID [--employeeId].",
            group = RECORDS)
    @Override
    public void updatePerformanceRecord(Integer goalId,
                                        @ShellOption(defaultValue = "Here is a goal description") String goalDescription,
                                        @ShellOption(defaultValue = "100") Integer targetValue,
                                        @ShellOption(defaultValue = "100") Integer actualValue,
                                        @ShellOption(defaultValue = "2022") Integer year,
                                        int employeeId) {
        log.info("Updating the record having the ID " + goalId + " for the Salesman with ID " + employeeId + "...");
        EvaluationRecord record = EvaluationRecords.create(goalId, goalDescription, targetValue, actualValue, year);
        long records = managePersonal.updatePerformanceRecord(record, employeeId);
        log.info(records + " Records updated successfully");
    }

    @ShellMethod(
            key = "delete-record",
            value = "Delete the record having the ID [--goalId] belonging to the salesman with the ID [--employeeId].",
            group = RECORDS
    )
    @Override
    public void deletePerformanceRecord(int goalId, int employeeId) {
        log.info("Deleting the record with ID " + goalId + " belonging to the Salesman with ID " + employeeId + "...");
        managePersonal.deletePerformanceRecord(goalId, employeeId);
        log.info("Record deleted successfully");
    }

    @ShellMethod(
            key = "query",
            value = "Get all Salesmen having an Attribute [--attribute] corresponding to the Key [--key].",
            group = SALESMAN)
    @Override
    public void querySalesMan(String attribute, String key) {
        log.info("Getting a Salesman having a \"" + attribute + "\" like \"" + key + "\"...");
        List<SalesMan> salesMen = managePersonal.querySalesMan(attribute, key);
        log.info("Result: " + salesMen);
    }
}
