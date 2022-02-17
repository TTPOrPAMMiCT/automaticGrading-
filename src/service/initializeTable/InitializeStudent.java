package service.initializeTable;

import dao.gradeDao.GradeDaoImpl;
import dao.studentDao.StudentDaoImpl;
import dao.studentGroupDao.StudentGroupDaoImpl;
import entity.model.Student;
import entity.view.StudentView;

import java.util.ArrayList;
import java.util.List;

public class InitializeStudent {

    public List<StudentView> initializeStudentView() {
        List<StudentView> studentViewList = new ArrayList<>();
        StudentDaoImpl studentDao = new StudentDaoImpl();
        GradeDaoImpl gradeDao = new GradeDaoImpl();
        List<Student> studentList = studentDao.findStudents();
        StudentGroupDaoImpl studentGroupDaoDaoImpl = new StudentGroupDaoImpl();
        int line = 1;
        for (int i = 0; i < studentList.size(); i++) {
            studentViewList.add(new StudentView(
                    studentList.get(i),
                    gradeDao.findGrade(studentList.get(i).getId()),
                    line,
                    studentGroupDaoDaoImpl.findGroupFromId(studentList.get(i).getIdGroup())));
            line++;
        }
        return studentViewList;
    }


    public void insertStudentDataBase(List<StudentView> studentViews) {
        
    }


    /*public static void main(String[] args) {
        InitializeStudentView initializeStudentView = new InitializeStudentView();
        initializeStudentView.initializeStudentView(0);
    }*/
}

