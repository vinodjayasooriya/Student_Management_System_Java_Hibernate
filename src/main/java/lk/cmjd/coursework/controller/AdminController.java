package lk.cmjd.coursework.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import lk.cmjd.coursework.dto.*;
import lk.cmjd.coursework.service.ServiceFactory;
import lk.cmjd.coursework.service.custom.*;
import java.time.LocalDate;
import java.util.*;

public class AdminController {

    private CourseService courseService = (CourseService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.COURSE);
    private StudentService studentService =(StudentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT);
    private AcademicService academicService =(AcademicService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ACADEMIC);
    private StudentRegService studentregService = (StudentRegService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUREG);
    private StudentRegCourseService studentRegCourseService = (StudentRegCourseService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUREGCOURSE);

    @FXML
    private TextField PreRequists;

    @FXML
    private StackPane contentArea;

    @FXML
    private Label courseCount;

    @FXML
    private TextField courseId;

    @FXML
    private TextField courseTitle;

    @FXML
    private AnchorPane coursesPane;

    @FXML
    private TableView<CourseDto> coursesTable;

    @FXML
    private TextField creditHours;

    @FXML
    private TextField studentId;

    @FXML
    public TextField studentEmail;

    @FXML
    private TextField studentName;

    @FXML
    private TextField StudentPassword;

    @FXML
    private TextField studentProgram;

    @FXML
    private DatePicker studentdob;
    @FXML
    public TextField studentyear;

    @FXML
    public TextField contactNumber;

    @FXML
    private ComboBox<String> department;

    @FXML
    private AnchorPane homePane;

    @FXML
    private TextField max_capacity;

    @FXML
    private Label studentCount;

    @FXML
    private AnchorPane studentsPane;

    @FXML
    private AnchorPane academicpane;

    @FXML
    private TextField arstudentName;

    @FXML
    private TextField arstudentProgram;

    @FXML
    private TableColumn<AcademicDto, String> arstudent_id_col;

    @FXML
    private TableColumn<AcademicDto, String> arstudent_name_col;

    @FXML
    private TableColumn<AcademicDto, String> arstudent_program_col;

    @FXML
    private TableColumn<AcademicDto, String> arstudent_year_col;

    @FXML
    private TextField arstudentgpa;

    @FXML
    private TableColumn<AcademicDto, String> arstudentgpa_col;

    @FXML
    private TextField arstudentid;

    @FXML
    private TextField arstudentyear;

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
    public TableColumn<StudentDto,String> student_id_col;

    @FXML
    private TableColumn<StudentDto,String> student_dob_col;

    @FXML
    private TableColumn<StudentDto,String> student_email_col;

    @FXML
    private TableColumn<StudentDto,String> student_name_col;

    @FXML
    private TableColumn<StudentDto,String> student_program_col;

    @FXML
    private TableColumn<StudentDto,String> student_year_col;

    @FXML
    private TableColumn<StudentDto,String> student_contact_col;

    @FXML
    private TableView<StudentDto> studentsTable;

    @FXML
    private TableView<AcademicDto> academictable;

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
    private TableColumn<StudentregcourseDto, String> studentregcourse1;

    @FXML
    private TableColumn<StudentregcourseDto, String> studentregcourse2;

    @FXML
    private TableColumn<StudentregcourseDto, String> studentregcourse3;

    @FXML
    private TableColumn<StudentregcourseDto, String> studentregcourseid;

    @FXML
    private TableView<StudentregcourseDto> studentregcourse;

    @FXML
    private BarChart<String, Number> home_totalEnrolledChart;

    @FXML
    private PieChart homecourseviewpie;

    @FXML
    private BarChart<String, Number> home_totalEnrolledChart2;

    @FXML
    private TextField searchFieldAdminCourse;

    @FXML
    private TextField searchFieldAcademic;

    private ObservableList<CourseDto> courseList;
    private FilteredList<CourseDto> courseDataad;
    private ObservableList<AcademicDto> academicListad;
    private FilteredList<AcademicDto> academicData;


    public void initialize() throws Exception {

        // Set course count in the label
        int courseCountValue = courseService.getAll().size(); // Get the total course count
        courseCount.setText(String.valueOf(courseCountValue));  // Set the count as text

        int studentCountValue = studentService.getAll().size(); // Get the total student count
        studentCount.setText(String.valueOf(studentCountValue));

        coursesTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateFields(newSelection);
            }
        });

        studentsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateStudentFields(newSelection);
            }
        });

        academictable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateAcademicFields(newSelection);
            }
        });

        studentsregTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateStudentRegFields(newSelection);
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

        displayOrRefreshCourseTable();
        displayOrRefreshStudentsTable();
        displayOrRefreshAcademicTable();
        displayStudentRegTable();
        displaystudentregcourseTable();

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

        setupSearchcourseadFilter();
        setupSearchFilter();
    }


    ObservableList<StudentregDto> getStudentRegList() throws Exception{
        ObservableList<StudentregDto> studentreg = FXCollections.observableArrayList();
        ArrayList<StudentregDto> studentregDtos = studentregService.getAll();
        for(StudentregDto studentregDto : studentregDtos){
            studentreg.add(studentregDto);
        }

        return studentreg;
    }

    private void populateStudentFields(StudentDto selectedStudentDto){
        studentId.setText(selectedStudentDto.getStudentId());
        studentName.setText(selectedStudentDto.getStudentName());
        studentEmail.setText(selectedStudentDto.getEmail());
        studentProgram.setText(selectedStudentDto.getProgram());
        studentyear.setText(String.valueOf(selectedStudentDto.getYear()));
        contactNumber.setText(String.valueOf(selectedStudentDto.getContactNumber()));
        studentdob.setValue(selectedStudentDto.getDob());
    }

    private void populateFields(CourseDto selectedCourse) {
        courseId.setText(selectedCourse.getCourseId());
        courseTitle.setText(selectedCourse.getCourseName());
        creditHours.setText(String.valueOf(selectedCourse.getCreditHours()));  // Convert int to String
        max_capacity.setText(String.valueOf(selectedCourse.getMaximumCapacity()));
        PreRequists.setText(selectedCourse.getPrerequisites());

        int index = 0;
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
        Scity.setText(selectedStudentRegDto.getRprograme());
        Saddress.setText(selectedStudentRegDto.getRaddress());
    }


    private void populateAcademicFields(AcademicDto selecteAcademicDto){
        arstudentid.setText(selecteAcademicDto.getArstudentid());
        arstudentName.setText(selecteAcademicDto.getArstudentName());
        arstudentProgram.setText(selecteAcademicDto.getArstudentProgram());
        arstudentyear.setText(selecteAcademicDto.getArstudentyear());
        arstudentgpa.setText(selecteAcademicDto.getArstudentgpa());
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
            courseDataad = new FilteredList<>(courseList, p -> true); // Wrap the list for filtering
            coursesTable.setItems(courseDataad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setupSearchcourseadFilter() {
        searchFieldAdminCourse.textProperty().addListener((observable, oldValue, newValue) -> {
            courseDataad.setPredicate(course -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true; // Show all if search is empty
                }

                String lowerCaseFilter = newValue.toLowerCase();

                return course.getCourseId().toLowerCase().contains(lowerCaseFilter) ||
                        course.getDepartment().toLowerCase().contains(lowerCaseFilter) ||
                        course.getCourseName().toLowerCase().contains(lowerCaseFilter) ||
                        course.getCreditHours().toLowerCase().contains(lowerCaseFilter) ||
                        course.getPrerequisites().toLowerCase().contains(lowerCaseFilter);
            });
        });
    }

    private void displayOrRefreshStudentsTable() {
        student_id_col.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        student_name_col.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        student_program_col.setCellValueFactory(new PropertyValueFactory<>("program"));
        student_email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        student_contact_col.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        student_dob_col.setCellValueFactory(new PropertyValueFactory<>("dob"));
        student_year_col.setCellValueFactory(new PropertyValueFactory<>("year"));

        try {
            studentsTable.setItems(getStudentList());
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    //display adacemic table
    private void displayOrRefreshAcademicTable() {
        arstudent_id_col.setCellValueFactory(new PropertyValueFactory<>("arstudentid"));
        arstudent_name_col.setCellValueFactory(new PropertyValueFactory<>("arstudentName"));
        arstudent_program_col.setCellValueFactory(new PropertyValueFactory<>("arstudentProgram"));
        arstudent_year_col.setCellValueFactory(new PropertyValueFactory<>("arstudentyear"));
        arstudentgpa_col.setCellValueFactory(new PropertyValueFactory<>("arstudentgpa"));

        try {
            academicListad = getAcademicList();
            academicData = new FilteredList<>(academicListad, p -> true); // Wrap the list for filtering
            academictable.setItems(academicData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupSearchFilter() {
        searchFieldAcademic.textProperty().addListener((observable, oldValue, newValue) -> {
            academicData.setPredicate(academicad -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true; // Show all if search is empty
                }

                String lowerCaseFilter = newValue.toLowerCase();

                return academicad.getArstudentid().toLowerCase().contains(lowerCaseFilter) ||
                        academicad.getArstudentgpa().toLowerCase().contains(lowerCaseFilter) ||
                        academicad.getArstudentProgram().toLowerCase().contains(lowerCaseFilter) ||
                        academicad.getArstudentyear().toLowerCase().contains(lowerCaseFilter) ||
                        academicad.getArstudentName().toLowerCase().contains(lowerCaseFilter);
            });
        });
    }

    ObservableList<AcademicDto> getAcademicList() throws Exception {
        ObservableList<AcademicDto> academics = FXCollections.observableArrayList();
        ArrayList<AcademicDto> academicDtos = academicService.getAll();

        if (academicDtos != null) {
            academics.addAll(academicDtos);
        }

        return academics;
    }


    ObservableList<CourseDto> getCoursesList() throws Exception{
        ObservableList<CourseDto> courses = FXCollections.observableArrayList();
        ArrayList<CourseDto> courseDtos = courseService.getAll();
        for(CourseDto courseDto : courseDtos){
            courses.add(courseDto);
        }

        return courses;
    }

    ObservableList<StudentDto> getStudentList() throws Exception{
        ObservableList<StudentDto> students = FXCollections.observableArrayList();
        ArrayList<StudentDto> studentDtos = studentService.getAll();
        for(StudentDto studentDto : studentDtos){
            students.add(studentDto);
        }

        return students;
    }

    @FXML
    void addCourse(ActionEvent event) throws NumberFormatException, Exception {

        String output = courseService.save(new CourseDto(courseId.getText(),
                courseTitle.getText(), creditHours.getText(),
                department.getValue(), PreRequists.getText(),
                max_capacity.getText()));
        displayOrRefreshCourseTable();
    }

    @FXML
    void updateCourse(ActionEvent event) throws Exception {
        String output = courseService.update(new CourseDto(courseId.getText(), courseTitle.getText(), creditHours.getText(), department.getValue(), PreRequists.getText(), max_capacity.getText()));
        displayOrRefreshCourseTable();

    }

    @FXML
    public void deleteCourse(ActionEvent actionEvent) throws Exception {
        String Output = courseService.delete(courseId.getText());
        displayOrRefreshCourseTable();

    }

    @FXML
    void addStudent(ActionEvent event) throws Exception {
        studentService.save(new StudentDto(
                studentId.getText(),
                studentName.getText(),
                studentProgram.getText(),
                studentEmail.getText(),
                studentdob.getValue(),
                StudentPassword.getText(),
                Integer.parseInt(studentyear.getText()),
                Integer.parseInt(contactNumber.getText())));
        displayOrRefreshStudentsTable();
    }


    @FXML
    void updateStudent(ActionEvent event) throws Exception {
        String Output = studentService.update(new StudentDto(studentId.getText(),studentName.getText(),studentProgram.getText(),studentEmail.getText(),studentdob.getValue(),Integer.parseInt(studentyear.getText()),Integer.parseInt(contactNumber.getText())));
        displayOrRefreshStudentsTable();
    }

    @FXML
    public void deleteStudent(ActionEvent actionEvent) throws Exception {
        String Output = studentService.delete(studentId.getText());

        displayOrRefreshStudentsTable();

    }

    @FXML
    void addAcademic(ActionEvent event)throws Exception {
        academicService.save(
                new AcademicDto(
                        arstudentid.getText(),
                        arstudentName.getText(),
                        arstudentProgram.getText(),
                        arstudentyear.getText(),
                        arstudentgpa.getText())
        );
        displayOrRefreshAcademicTable();

    }



    @FXML
    void updateAcademic(ActionEvent event) throws Exception {
        String output = academicService.update(new AcademicDto(arstudentid.getText(), arstudentName.getText(), arstudentProgram.getText(), arstudentyear.getText(), arstudentgpa.getText()));
        displayOrRefreshAcademicTable();
    }

    @FXML
    void deleteAcademic(ActionEvent event) throws Exception {
        String Output = academicService.delete(arstudentid.getText());
        displayOrRefreshAcademicTable();
    }

    @FXML
    void switchForm(ActionEvent event) {
        String userData = ((Button) event.getSource()).getUserData().toString();

        homePane.setVisible(userData.equals("home"));
        coursesPane.setVisible(userData.equals("courses"));
        studentsPane.setVisible(userData.equals("students"));
        academicpane.setVisible(userData.equals("academic"));
    }


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
        studentcitycol.setCellValueFactory(new PropertyValueFactory<>("city"));
        studentaddresscol.setCellValueFactory(new PropertyValueFactory<>("raddress"));

        try {
            studentsregTable.setItems(getStudentRegList());
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    //display student table
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

}
