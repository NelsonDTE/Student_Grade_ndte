package es.ulpgc.eite.studentgrade.student;

import android.content.Intent;
import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.R;
import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;
import es.ulpgc.eite.studentgrade.grade.GradeActivity;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentPresenter implements StudentContract.Presenter {

  public static String TAG = "StudentGrade.StudentPresenter";

  private WeakReference<StudentContract.View> view;
  private StudentState state;
  private StudentContract.Model model;
  private AppMediator mediator;

  public StudentPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getStudentState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    model.getStoredData();
    // TODO: include code here if is necessary

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    GradeToStudentState savedState = getStateFromNextScreen();
    if (savedState != null) {
      mediator.setPreviousGradeScreenState(mediator.getNextStudentScreenState());
      model.onDataFromNextScreen(mediator.getNextStudentScreenState().data);
      // TODO: include code here if is necessary

    }
      view.get().injectPresenter(this);
    // TODO: include code here if is necessary

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
    this.onDestroy();
    // TODO: include code here if is necessary
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onOutstandingGradeBtnClicked() {
    state.equals(R.id.btnOutstandingGrade);
      StudentToGradeState newState = new StudentToGradeState();
      newState.data = state.data;
      passStateToNextScreen(newState);
      view.get().navigateToNextScreen();

    }

    // TODO: include code here if is necessary



  @Override
  public void onMentionGradeBtnClicked() {
    state.equals(R.id.btnMentionGrade);
    StudentToGradeState newState = new StudentToGradeState();
    newState.data = state.data;
    passStateToNextScreen(newState);
    view.get().navigateToNextScreen();
    // TODO: include code here if is necessary

  }

  @Override
  public void onPassGradeBtnClicked() {
    state.equals(R.id.btnPassGrade);
    StudentToGradeState newState = new StudentToGradeState();
    newState.data = state.data;
    passStateToNextScreen(newState);
    view.get().navigateToNextScreen();
    // TODO: include code here if is necessary

  }

  private GradeToStudentState getStateFromNextScreen() {
    return mediator.getNextStudentScreenState();
  }

  private void passStateToNextScreen(StudentToGradeState state) {
    mediator.setNextStudentScreenState(state);
  }


  @Override
  public void injectView(WeakReference<StudentContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(StudentContract.Model model) {
    this.model = model;
  }

}
