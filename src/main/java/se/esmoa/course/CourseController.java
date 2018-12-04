package se.esmoa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.esmoa.topic.Topic;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
