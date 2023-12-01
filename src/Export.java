

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Export extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showConsole();
    }
    private void showConsole() {
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));

        Label headerLabel = new Label("Effort Logger Console");
        headerLabel.setStyle("-fx-font-size: 24px;");

        Label instruction1 = new Label("1. When you start a new activity, press the \"Start an Activity\" button.");
        Button startActivityButton = new Button("Start an Activity");

        Label instruction2 = new Label("2. Select the project, life cycle step, effort category, and deliverable from the following lists:");
        ComboBox<String> projectComboBox = new ComboBox<>();
        projectComboBox.setPromptText("Development Project");
        projectComboBox.getItems().addAll(
        	"Plans", "Deliverables", "Defects", "Other"	);
        ComboBox<String> lifeCycleStepComboBox = new ComboBox<>();
        lifeCycleStepComboBox.setPromptText("Life Cycle Step:");
        lifeCycleStepComboBox.getItems().addAll("One cycle", "Two cycles", "Three cycles", "Multiple cycles");
        ComboBox<String> effortCategoryComboBox = new ComboBox<>();
        effortCategoryComboBox.setPromptText("Effort Category:");
        effortCategoryComboBox.getItems().addAll("Max", "Min", "Medium");

        Label instruction3 = new Label("3. Press the \"Stop this Activity\" to generate an effort log entry using the attributes above.");
        Button stopActivityButton = new Button("Stop this Activity");

        Label instruction4 = new Label("4. Unless you are done for the day, it is best to perform steps 1 and 2 above before resuming work.");

        Button defectConsoleButton = new Button("Defect Log Console");
        defectConsoleButton.setOnAction(e -> showDefectConsole());

        Button effortLogEditorButton = new Button("Effort Log Editor");
        effortLogEditorButton.setOnAction(e -> showEffortLogEditor()); // Call the showEffortLogEditor() method when pressed

        Button definitionsButton = new Button("Definitions");
        Button effortAndDefectLogsButton = new Button("Effort and Defect Logs");

        mainLayout.getChildren().addAll(headerLabel, instruction1, startActivityButton, instruction2, projectComboBox, lifeCycleStepComboBox, effortCategoryComboBox, instruction3, stopActivityButton, instruction4, defectConsoleButton, effortLogEditorButton, definitionsButton, effortAndDefectLogsButton);

        Scene consoleScene = new Scene(mainLayout, 600, 700);
        primaryStage.setTitle("Effort Logger Console");
        primaryStage.setScene(consoleScene);
        primaryStage.show();
    }

    private void showEffortLogEditor() {
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));

        // File Preview & Project Label
        Label filePreviewLabel = new Label("File Preview");
        Label projectLabel = new Label("Project in order to edit its Effort Log.");

        // Effort Log Entry
        Label effortLogLabel = new Label("One effort log entry for this project.");

        // Modify Current Entry Fields
        TextField dateField = new TextField("yyyy-mm-dd");
        TextField startTimeField = new TextField("hh:mm:ss");
        TextField stopTimeField = new TextField("hh:mm:ss");
        ComboBox<String> lifeCycleStepComboBox = new ComboBox<>();
        lifeCycleStepComboBox.setPromptText("Life Cycle Step");
        ComboBox<String> effortCategoryComboBox = new ComboBox<>();
        effortCategoryComboBox.setPromptText("Effort Category");
        ComboBox<String> plansComboBox = new ComboBox<>();
        plansComboBox.setPromptText("Plan");

        Button updateThisEntryButton = new Button("Update This Entry");
        Button deleteThisEntryButton = new Button("Delete This Entry");
        Button splitThisEntryButton = new Button("Split This Entry into Two Entries");

        // This button takes the user back to the console.
        Button proceedToEffortLogButton = new Button("Proceed to the Effort Log Console");
        proceedToEffortLogButton.setOnAction(e -> showConsole());  // Navigates back to the console when clicked

        // Add controls to layout
        mainLayout.getChildren().addAll(filePreviewLabel, projectLabel, effortLogLabel, dateField, startTimeField, stopTimeField, lifeCycleStepComboBox, effortCategoryComboBox, plansComboBox, updateThisEntryButton, deleteThisEntryButton, splitThisEntryButton, proceedToEffortLogButton);

        Scene editorScene = new Scene(mainLayout, 550, 500);
        primaryStage.setTitle("Effort Log Editor");
        primaryStage.setScene(editorScene);
    }

    private void showDefectConsole() {
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));

        Label headerLabel = new Label("Defect Console");
        headerLabel.setStyle("-fx-font-size: 24px;");

        Label instruction1 = new Label("1. Select the Project");
        ComboBox<String> projectComboBox = new ComboBox<>();
        projectComboBox.setPromptText("Business Project");

        Label noDefectLabel = new Label("No defects for this project.");
        ComboBox<String> defectsComboBox = new ComboBox<>();
        defectsComboBox.setPromptText("- no defect selected -");
        Label instruction2b = new Label("2.b. Select one of the following defects to make it the Current Defect or press \"Create a New Defect\".");
        Button createNewDefectButton = new Button("Create a New Defect");

        Label instruction3 = new Label("3. Define or update the following Current Defect attributes:");
        TextField defectNameTextField = new TextField();
        defectNameTextField.setPromptText("Defect Name");

        TextArea symptomsTextArea = new TextArea();
        symptomsTextArea.setPromptText("Defect Symptoms or Cause/Resolution");

        Label statusLabel = new Label("Status: Closed");
        Button closeDefectButton = new Button("Close");
        Button reopenDefectButton = new Button("Reopen");

        Label instruction4 = new Label("To insert a new line, press <ctrl + option + return>");
        ComboBox<String> whenInjectedComboBox = new ComboBox<>();
        whenInjectedComboBox.getItems().addAll("Planning", "Information Gathering", "Information Understanding", "Verifying", "Other");
        whenInjectedComboBox.setPromptText("Step when injected");
        ComboBox<String> whenRemovedComboBox = new ComboBox<>();
        whenRemovedComboBox.getItems().addAll("Planning", "Information Gathering", "Information Understanding", "Verifying", "Other");
        whenRemovedComboBox.setPromptText("Step when removed");

        ComboBox<String> defectCategoryComboBox = new ComboBox<>();
        defectCategoryComboBox.getItems().addAll("Not specified", "Not Documented", "Syntax", "Build, Package", "Assignment");
        defectCategoryComboBox.setPromptText("Defect Category");

        ComboBox<String> fixComboBox = new ComboBox<>();
        fixComboBox.setPromptText("Fix");
        fixComboBox.getItems().addAll("Do nothing", "Set up a sprint", "Go back to emergency code");

        Button updateDefectButton = new Button("Update the Current Defect");
        Button deleteDefectButton = new Button("Delete the Current Defect");
        Button proceedToLoggerConsoleButton = new Button("Proceed to the Effort Log Console");
        proceedToLoggerConsoleButton.setOnAction(e -> showConsole());

        mainLayout.getChildren().addAll(headerLabel, instruction1, projectComboBox, noDefectLabel, instruction2b, defectsComboBox, createNewDefectButton, instruction3, defectNameTextField, symptomsTextArea, statusLabel, closeDefectButton, reopenDefectButton, instruction4, whenInjectedComboBox, whenRemovedComboBox, defectCategoryComboBox, fixComboBox, updateDefectButton, deleteDefectButton, proceedToLoggerConsoleButton);

        Scene defectConsoleScene = new Scene(mainLayout, 600, 700);
        primaryStage.setTitle("Defect Console");
        primaryStage.setScene(defectConsoleScene);
        primaryStage.show();
    }

}
