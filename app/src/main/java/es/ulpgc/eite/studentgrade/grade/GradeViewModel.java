package es.ulpgc.eite.studentgrade.grade;

import java.util.Objects;

import es.ulpgc.eite.studentgrade.student.StudentViewModel;

/**
 * Created by Luis on marzo, 2022
 */
public class GradeViewModel {

  // put the view state here
  public String data;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StudentViewModel that = (StudentViewModel) o;
    return Objects.equals(data, that.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }
}
