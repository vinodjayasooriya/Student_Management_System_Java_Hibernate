package lk.cmjd.coursework.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import lk.cmjd.coursework.dto.*;
import lk.cmjd.coursework.service.ServiceFactory;
import lk.cmjd.coursework.service.custom.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.chart.PieChart;


@Component
public class StudentController {
    private CourseService courseService = (CourseService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.COURSE);
    private StudentService studentService =(StudentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT);
    private AcademicService academicService =(AcademicService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ACADEMIC);
    private StudentRegService studentregService = (StudentRegService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUREG);
    private StudentRegCourseService studentRegCourseService = (StudentRegCourseService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUREGCOURSE);

    @FXML
    private AnchorPane EnrollmentsPane;

    @FXML
    private AnchorPane registerstudentpane;

    @FXML
    private AnchorPane academicRecordsPane;

    @FXML
    private StackPane contentArea;

    @FXML
    private AnchorPane homePane;

    @FXML
    private TableView<AcademicDto> academictable;

    @FXML
    private TableColumn<AcademicDto, String> arstudent_id_col;

    @FXML
    private TableColumn<AcademicDto, String> arstudent_name_col;

    @FXML
    private TableColumn<AcademicDto, String> arstudent_program_col;

    @FXML
    private TableColumn<AcademicDto, String> arstudent_year_col;

    @FXML
    private TableColumn<AcademicDto, String> arstudentgpa_col;

    @FXML
    private TextField Saddress;

    @FXML
    private TextField Sal;

    @FXML
    private TextField Scity;

    @FXML
    private TextField Scontack;

    @FXML
    private ComboBox<String> Sdepartment;

    @FXML
    private DatePicker Sdob;

    @FXML
    private TextField Semail;

    @FXML
    private TextField Shome;

    @FXML
    private TextField Sid;

    @FXML
    private TextField Sname;

    @FXML
    private TextField Sol;

    @FXML
    private TextField Sschool;

    @FXML
    private TextField SstudentId;

    @FXML
    private ComboBox<String> Syear;

    @FXML
    private ComboBox<String> Sprograme;

    @FXML
    private AnchorPane academicpane;

    @FXML
    private TextField contactNumber11;

    @FXML
    private Label courseCount;

    @FXML
    private Label studentCount;

    @FXML
    private TextField studentEmail;

    @FXML
    private TextField studentName;

    @FXML
    private TextField studentProgram;

    @FXML
    private TableColumn<StudentregDto, String> studentaddresscol;

    @FXML
    private TableColumn<StudentregDto, String> studentalcol;

    @FXML
    private TableColumn<StudentregDto, String> studentcitycol;

    @FXML
    private TableColumn<StudentregDto, String> studentcontactcol;

    @FXML
    private TableColumn<StudentregDto, String> studentdepartmentcol;

    @FXML
    private TableColumn<StudentregDto, LocalDate> studentdobcol;

    @FXML
    private TableColumn<StudentregDto, String> studentemailcol;

    @FXML
    private TableColumn<StudentregDto, String> studenthomecol;

    @FXML
    private TableColumn<StudentregDto, String> studentidcol;

    @FXML
    private TableColumn<StudentregDto, String> studentnamecol;

    @FXML
    private TableColumn<StudentregDto, String> studentnidcol;

    @FXML
    private TableColumn<StudentregDto, String> studentolcol;

    @FXML
    private TableColumn<StudentregDto, String> studentschoolcol;

    @FXML
    private TableView<StudentregDto> studentsregTable;

    @FXML
    private TableColumn<StudentregDto, String> studentyearcol;

    @FXML
    private TableColumn<CourseDto, Integer> course_credit_hours_col;

    @FXML
    private TableColumn<CourseDto, Integer> course_department_col;

    @FXML
    private TableColumn<CourseDto, String> course_id_col;

    @FXML
    private TableColumn<CourseDto, Integer> course_max_capacity_col;

    @FXML
    private TableColumn<CourseDto, String> course_prerequistes_col;

    @FXML
    private TableColumn<CourseDto, String> course_title_col;

    @FXML
    private TableView<CourseDto> coursesTable;

    @FXML
    private TableView<StudentregcourseDto> studentregcourse;

    @FXML
    private TextField studentrc1;

    @FXML
    private TextField studentrc2;

    @FXML
    private TextField studentrc3;

    @FXML
    private TextField studentrcid;

    @FXML
    private TableColumn<StudentregcourseDto, String> studentregcourse1;

    @FXML
    private TableColumn<StudentregcourseDto, String> studentregcourse2;

    @FXML
    private TableColumn<StudentregcourseDto, String> studentregcourse3;

    @FXML
    private TableColumn<StudentregcourseDto, String> studentregcourseid;

    @FXML
    private BarChart<String, Number> home_totalEnrolledChart;

    @FXML
    private PieChart homecourseviewpie;

    @FXML
    private BarChart<String, Number> home_totalEnrolledChart2;

    @FXML
    private CategoryAxis coursetitle;

    @FXML
    private NumberAxis credithours;

    @FXML
    private TextField searchField;

    @FXML
    private TextField searchFieldreg;

    @FXML
    private TextField searchFieldStudentCourse;

    //seach box
    private ObservableList<AcademicDto> academicList;
    private FilteredList<AcademicDto> filteredData;
    private ObservableList<StudentregDto> studentList;
    private FilteredList<StudentregDto> studentData;
    private ObservableList<CourseDto> courseList;
    private FilteredList<CourseDto> courseData;


    @FXML
    void switchForm(ActionEvent event) {
        String userData = ((Button) event.getSource()).getUserData().toString();

        homePane.setVisible(userData.equals("home"));
        EnrollmentsPane.setVisible(userData.equals("Enrollments"));
        academicRecordsPane.setVisible(userData.equals("AcademmicRecords"));
        registerstudentpane.setVisible(userData.equals("RegisterStudent"));

    }

    @FXML
    public void Enrollment(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        System.out.println("Clicked: " + clickedButton.getText()); // Debugging output

        // Create a TextArea to display the button's text and some lorem ipsum text
        TextArea textArea = new TextArea();
        textArea.setEditable(false); // Make the text area non-editable
        textArea.setWrapText(true);  // Allow text to wrap

        // Set attractive styling
        textArea.setStyle("-fx-font-size: 16px; -fx-font-family: Arial; -fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-radius: 5px; -fx-padding: 10px;");

        // Set the text content to show the button's text and some lorem ipsum
        String buttonText = clickedButton.getText();
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi.";
        textArea.setText("You clicked: " + buttonText + "\n\n" + loremIpsum);

        // Create a VBox to hold the TextArea
        VBox layout = new VBox(10); // 10px gap between elements
        layout.getChildren().add(textArea);

        // Add the layout to the EnrollmentsPane
        EnrollmentsPane.getChildren().add(layout);  // Add the newly created layout with TextArea

        // Optionally, adjust the layout position if needed
        AnchorPane.setTopAnchor(layout, 250.0);  // Adjust the vertical position (Y)
        AnchorPane.setLeftAnchor(layout, 20.0);  // Adjust the horizontal position (X)
    }


    public void initialize() throws Exception {

        studentsregTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateStudentRegFields(newSelection);
            }
        });


        studentregcourse.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateStudentCourseRegFields(newSelection);
            }
        });


        // Create the BarChart data series for Total Students
        XYChart.Series<String, Number> totalStudentsSeries = new XYChart.Series<>();
        totalStudentsSeries.setName("Total Students");  // Set the name for the series

        // Get total student count and add to the series
        int totalStudents = studentService.getAll().size();
        totalStudentsSeries.getData().add(new XYChart.Data<>("Total Students", totalStudents));

        // Add the series to the BarChart
        home_totalEnrolledChart.getData().clear(); // Clear existing data
        home_totalEnrolledChart.getData().add(totalStudentsSeries);

        // Create the BarChart data series for Student GPA
        XYChart.Series<String, Number> gpaSeries = new XYChart.Series<>();
        gpaSeries.setName("Student GPA");  // Set the name for the series

        // AcademicService to fetch all academic data
        List<AcademicDto> academicData = academicService.getAll();

        // Add data to the GPA series
        for (AcademicDto academic : academicData) {
            gpaSeries.getData().add(new XYChart.Data<>(academic.getArstudentid(), Double.parseDouble(academic.getArstudentgpa())));
        }

        // Clear existing data and add the GPA series
        home_totalEnrolledChart.getData().clear();
        home_totalEnrolledChart.getData().add(gpaSeries);

        // Create the BarChart data series for Total Students
        XYChart.Series<String, Number> totalCourseSeries = new XYChart.Series<>();
        totalCourseSeries.setName("Total Courses");  // Set the name for the series

        // Get total student count and add to the series
        int totalCourses = courseService.getAll().size();
        totalCourseSeries.getData().add(new XYChart.Data<>("Total Students", totalCourses));

        // Add the series to the BarChart
        home_totalEnrolledChart2.getData().clear(); // Clear existing data
        home_totalEnrolledChart2.getData().add(totalCourseSeries);

        // Create the BarChart data series for Student GPA
        XYChart.Series<String, Number> credithoursSeries = new XYChart.Series<>();
        credithoursSeries.setName("All Courses");  // Set the name for the series

        // AcademicService to fetch all academic data
        List<CourseDto> courseData = courseService.getAll();

        // Add data to the GPA series
        for (CourseDto course : courseData) {
            credithoursSeries.getData().add(new XYChart.Data<>(course.getCourseName(), Double.parseDouble(course.getCreditHours())));
        }

        // Clear existing data and add the GPA series
        home_totalEnrolledChart2.getData().clear();
        home_totalEnrolledChart2.getData().add(credithoursSeries);

        displayOrRefreshAcademicTable();
        displayStudentRegTable();
        displayOrRefreshCourseTable();
        displaystudentregcourseTable();


        int courseCountValue = courseService.getAll().size(); // Get the total course count
        courseCount.setText(String.valueOf(courseCountValue));  // Set the count as text

        int studentCountValue = studentService.getAll().size(); // Get the total student count
        studentCount.setText(String.valueOf(studentCountValue));


        // Create PieChart Data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        // Get total number of students
        int totalcourses = studentService.getAll().size();
        pieChartData.add(new PieChart.Data("Total Students", totalcourses));

        // Get student GPA data
        List<AcademicDto> coursesData = academicService.getAll();
        int gpaAbove3 = 0, gpaBetween2And3 = 0, gpaBelow2 = 0;

        for (AcademicDto academic : coursesData) {
            double gpa = Double.parseDouble(academic.getArstudentgpa());
            if (gpa >= 3.0) {
                gpaAbove3++;
            } else if (gpa >= 2.0) {
                gpaBetween2And3++;
            } else {
                gpaBelow2++;
            }
        }

        // Add GPA categories to PieChart
        pieChartData.add(new PieChart.Data("GPA >= 3.0", gpaAbove3));
        pieChartData.add(new PieChart.Data("GPA 2.0 - 2.9", gpaBetween2And3));
        pieChartData.add(new PieChart.Data("GPA < 2.0", gpaBelow2));

        // Set data to PieChart
        homecourseviewpie.setData(pieChartData);


        setupSearchFilter();
        setupSearchStudentFilter();
        setupCourseSearchFilter();

    }


    private void displayOrRefreshCourseTable() {
        course_id_col.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
        course_title_col.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        course_prerequistes_col.setCellValueFactory(new PropertyValueFactory<>("prerequisites"));
        course_max_capacity_col.setCellValueFactory(new PropertyValueFactory<>("MaximumCapacity"));
        course_credit_hours_col.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));
        course_department_col.setCellValueFactory(new PropertyValueFactory<>("department"));

        try {
            courseList = getCoursesList();
            courseData = new FilteredList<>(courseList, p -> true); // Wrap the list for filtering
            coursesTable.setItems(courseData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setupCourseSearchFilter() {
        searchFieldStudentCourse.textProperty().addListener((observable, oldValue, newValue) -> {
            courseData.setPredicate(course -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true; // Show all if search is empty
                }

                String lowerCaseFilter = newValue.toLowerCase();

                return course.getCourseId().toLowerCase().contains(lowerCaseFilter) ||
                        course.getCourseName().toLowerCase().contains(lowerCaseFilter) ||

                        course.getDepartment().toLowerCase().contains(lowerCaseFilter);
            });
        });
    }

    ObservableList<CourseDto> getCoursesList() throws Exception{
        ObservableList<CourseDto> courses = FXCollections.observableArrayList();
        ArrayList<CourseDto> courseDtos = courseService.getAll();
        for(CourseDto courseDto : courseDtos){
            courses.add(courseDto);
        }

        return courses;
    }

    private void populateStudentCourseRegFields(StudentregcourseDto selectedStudentRegCourseDto){

        studentrcid.setText(selectedStudentRegCourseDto.getRcstudentid());
        studentrc1.setText(selectedStudentRegCourseDto.getRccourseid1());
        studentrc2.setText(selectedStudentRegCourseDto.getRccourseid2());
        studentrc3.setText(selectedStudentRegCourseDto.getRccourseid3());

    }



    private void populateStudentRegFields(StudentregDto selectedStudentRegDto){
        SstudentId.setText(selectedStudentRegDto.getRstudentid());
        Sname.setText(selectedStudentRegDto.getRname());
        Semail.setText(selectedStudentRegDto.getRemail());
        Sdepartment.setValue(selectedStudentRegDto.getRdepartment());
        Sdob.setValue(selectedStudentRegDto.getRdob());
        Syear.setValue(selectedStudentRegDto.getRyear());
        Scontack.setText(selectedStudentRegDto.getRcontack());
        Sid.setText(selectedStudentRegDto.getRnid());
        Shome.setText(selectedStudentRegDto.getRhcontack());
        Sschool.setText(selectedStudentRegDto.getRschool());
        Sol.setText(selectedStudentRegDto.getRol());
        Sal.setText(selectedStudentRegDto.getRal());
        Sprograme.setValue(selectedStudentRegDto.getRprograme());
        Saddress.setText(selectedStudentRegDto.getRaddress());



    }


    ObservableList<StudentregDto> getStudentRegList() throws Exception{
        ObservableList<StudentregDto> studentreg = FXCollections.observableArrayList();
        ArrayList<StudentregDto> studentregDtos = studentregService.getAll();
        for(StudentregDto studentregDto : studentregDtos){
            studentreg.add(studentregDto);
        }

        return studentreg;
    }


//academic
    private void displayOrRefreshAcademicTable() {
        arstudent_id_col.setCellValueFactory(new PropertyValueFactory<>("arstudentid"));
        arstudent_name_col.setCellValueFactory(new PropertyValueFactory<>("arstudentName"));
        arstudent_program_col.setCellValueFactory(new PropertyValueFactory<>("arstudentProgram"));
        arstudent_year_col.setCellValueFactory(new PropertyValueFactory<>("arstudentyear"));
        arstudentgpa_col.setCellValueFactory(new PropertyValueFactory<>("arstudentgpa"));

        try {
            academicList = getAcademicList();
            filteredData = new FilteredList<>(academicList, p -> true); // Wrap the list for filtering
            academictable.setItems(filteredData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupSearchFilter() {
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(academic -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true; // Show all if search is empty
                }

                String lowerCaseFilter = newValue.toLowerCase();

                return academic.getArstudentid().toLowerCase().contains(lowerCaseFilter) ||
                        academic.getArstudentName().toLowerCase().contains(lowerCaseFilter) ||
                        academic.getArstudentProgram().toLowerCase().contains(lowerCaseFilter) ||
                        academic.getArstudentyear().toLowerCase().contains(lowerCaseFilter) ||
                        academic.getArstudentgpa().toLowerCase().contains(lowerCaseFilter);
            });
        });
    }

    //student reg

    private void displayStudentRegTable() {
        studentidcol.setCellValueFactory(new PropertyValueFactory<>("rstudentid"));
        studentnamecol.setCellValueFactory(new PropertyValueFactory<>("rname"));
        studentemailcol.setCellValueFactory(new PropertyValueFactory<>("remail"));
        studentdepartmentcol.setCellValueFactory(new PropertyValueFactory<>("rdepartment"));
        studentdobcol.setCellValueFactory(new PropertyValueFactory<>("rdob"));
        studentyearcol.setCellValueFactory(new PropertyValueFactory<>("ryear"));
        studentcontactcol.setCellValueFactory(new PropertyValueFactory<>("rcontack"));
        studentnidcol.setCellValueFactory(new PropertyValueFactory<>("rnid"));
        studenthomecol.setCellValueFactory(new PropertyValueFactory<>("rhcontack"));
        studentschoolcol.setCellValueFactory(new PropertyValueFactory<>("rschool"));
        studentolcol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        studentalcol.setCellValueFactory(new PropertyValueFactory<>("ral"));
        studentcitycol.setCellValueFactory(new PropertyValueFactory<>("rprograme"));
        studentaddresscol.setCellValueFactory(new PropertyValueFactory<>("raddress"));



        try {
            studentList = getStudentRegList();
            studentData = new FilteredList<>(studentList, p -> true); // Wrap the list for filtering
            studentsregTable.setItems(studentData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setupSearchStudentFilter() {
        searchFieldreg.textProperty().addListener((observable, oldValue, newValue) -> {
            studentData.setPredicate(register -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true; // Show all if search is empty
                }

                String lowerCaseFilter = newValue.toLowerCase();

                return register.getRstudentid().toLowerCase().contains(lowerCaseFilter) ||
                        register.getRname().toLowerCase().contains(lowerCaseFilter) ||
                        register.getRemail().toLowerCase().contains(lowerCaseFilter) ||
                        register.getRdepartment().toLowerCase().contains(lowerCaseFilter);
            });
        });
    }


    private ObservableList<AcademicDto> getAcademicList() throws Exception {
        ObservableList<AcademicDto> academics = FXCollections.observableArrayList();
        ArrayList<AcademicDto> academicDtos = academicService.getAll();

        if (academicDtos != null) {
            academics.addAll(academicDtos);
        }

        return academics;
    }


    private void displaystudentregcourseTable() {
        studentregcourseid.setCellValueFactory(new PropertyValueFactory<>("rcstudentid"));
        studentregcourse1.setCellValueFactory(new PropertyValueFactory<>("rccourseid1"));
        studentregcourse2.setCellValueFactory(new PropertyValueFactory<>("rccourseid2"));
        studentregcourse3.setCellValueFactory(new PropertyValueFactory<>("rccourseid3"));

        try {
            studentregcourse.setItems(getstudentcourseList());
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    ObservableList<StudentregcourseDto> getstudentcourseList() throws Exception {
        ObservableList<StudentregcourseDto> studetcourse = FXCollections.observableArrayList();
        ArrayList<StudentregcourseDto> StudentregcourseDtos = studentRegCourseService.getAll();

        if (StudentregcourseDtos != null) {
            studetcourse.addAll(StudentregcourseDtos);
        }

        return studetcourse;
    }

    //Student Button Section
    @FXML
    private void addStudent(ActionEvent event)throws  Exception {
        System.out.println("Student added!");
        studentregService.save(new StudentregDto(
                SstudentId.getText(),
                Sname.getText(), Semail.getText(),
                Sdepartment.getValue(), Sdob.getValue(),Syear.getValue(),Scontack.getText(),
                Sid.getText(),Shome.getText(),Sschool.getText(),Sol.getText(),Sal.getText(),
                Sprograme.getValue(),Saddress.getText()));
        displayStudentRegTable();

    }

    public void updateStudent(ActionEvent event) throws Exception {
        String Output= studentregService.update(new StudentregDto(
                SstudentId.getText(),
                Sname.getText(), Semail.getText(),
                Sdepartment.getValue(), Sdob.getValue(),Syear.getValue(),Scontack.getText(),
                Sid.getText(),Shome.getText(),Sschool.getText(),Sol.getText(),Sal.getText(),
                Sprograme.getValue(),Saddress.getText()));
        displayStudentRegTable();
    }

    @FXML
    void deleteStudent(ActionEvent event) throws Exception {
        String Output = studentregService.delete(SstudentId.getText());
        displayStudentRegTable();


    }
    
//Student Course Button Section
    @FXML
    private void addStudentCourse(ActionEvent event)throws  Exception {
        System.out.println("Student added!");
        studentRegCourseService.save(new StudentregcourseDto(
                studentrcid.getText(),
                studentrc1.getText(),
                studentrc2.getText(),
                studentrc3.getText()));
        displaystudentregcourseTable();

    }

    public void updateStudentCourse(ActionEvent event) throws Exception {
        studentRegCourseService.update(new StudentregcourseDto(
                studentrcid.getText(),
                studentrc1.getText(),
                studentrc2.getText(),
                studentrc3.getText()));
        displaystudentregcourseTable();
    }

    @FXML
    void deleteStudentCourse(ActionEvent event) throws Exception {
        String Output = studentRegCourseService.delete(studentrcid.getText());
        displaystudentregcourseTable();

    }
}
