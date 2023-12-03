/*
Implement a Student class with variables like name, age and cgpa.
Also, implement interface comparable for the Student class which allows comparing two instances of the class based on cgpa.
Also, implement toString method for the Student class which returns the student’s name, age and cgpa as a String.
Next, create a list of students using the MyArrayList class implemented above.
Check if the find method of MyArrayList is working correctly.
For this, insert a student with 3.5 cgpa in the list and find it using the find method.

3. Add a findMax method in the MyArrayList class. It will find the student with the best cgpa.
*/
class Student implements Comparable<Student>{
    String name;
    int age;
    double cgpa;

    Student(String name,int age, double cgpa){
        this.cgpa = cgpa; this.name = name; this.age = age;
    }
    public int compareTo(Student student){
        if(cgpa==student.cgpa)
            return 0;
        else if(cgpa>student.cgpa)
            return 1;
        else
            return-1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cgpa=" + cgpa +
                '}';
    }
}