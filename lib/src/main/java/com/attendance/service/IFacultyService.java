package com.attendance.service;
import java.util.List;



import com.attendance.entities.Faculty;

 

public interface IFacultyService {
    public Faculty saveFaculty(Faculty faculty);
    public  List<Faculty> getFaculties();
     public  Faculty updateFaculty(Faculty faculty);
     public Faculty  deleteFaculty(int id);
     public Faculty getFaculty(int id);
}
 