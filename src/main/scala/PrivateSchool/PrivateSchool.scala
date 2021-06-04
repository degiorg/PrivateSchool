package PrivateSchool

object PrivateSchool {

  case class Student(name: String)
  case class Teacher(name: String)
  case class Course(name: String, price: BigDecimal, maxStudent: Int)

  case class SchoolClass(course: Course, students: List[Student], teachers: List[Teacher])

  case class CoursesList(coursesList: List[Course])

  case class School(schoolClasses: List[SchoolClass])


  val studentList = List(Student("Giorgio"), Student("Tina"), Student("Stan"))
  val teacherList = List(Teacher("Aldo"))
  val courseCG: Course = Course("CG", 100, 3)
  val coursesList: CoursesList = CoursesList(List(courseCG))
  val schoolClass: SchoolClass = SchoolClass(courseCG, List(Student("")), teacherList)
  val school: School = School(List(schoolClass))



  def book(student: Student, course: String): String = {
    val findCourse : List[Course] = coursesList.coursesList.filter(x => x.name == course)
    if (findCourse.nonEmpty) {
      val findClass: List[SchoolClass] = school.schoolClasses.filter(x => x.course.name == course)
      if (findClass.nonEmpty) {
        if (findCourse.head.maxStudent > findClass.head.students.length) {
          val bookMsg = "Prenotato " + student
          bookMsg
        } else {
          val bookMsg = "Classe non trovata"
          bookMsg
        }
        } else {
        val bookMsg = "Corso non trovato"
        bookMsg
      }
    }
  }

}
