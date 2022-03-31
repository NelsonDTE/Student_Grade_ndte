package es.ulpgc.eite.studentgrade.student;

import java.util.Objects;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentViewModel {

  // put the view state here
  public String data = "0";

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
