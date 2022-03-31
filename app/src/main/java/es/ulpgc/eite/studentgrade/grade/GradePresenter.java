package es.ulpgc.eite.studentgrade.grade;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.R;
import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;

/**
 * Created by Luis on marzo, 2022
 */
public class GradePresenter implements GradeContract.Presenter {

  public static String TAG = "StudentGrade.GradePresenter";

  private WeakReference<GradeContract.View> view;
  private GradeState state;
  private GradeContract.Model model;
  private AppMediator mediator;

  public GradePresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getGradeState();
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // TODO: include code here if is necessary
    model.getStoredData();
    // use passed state if is necessary
    StudentToGradeState savedState = getStateFromPreviousScreen();

    if (savedState != null) {
      state.data =  mediator.getNextStudentScreenState().data;
      // TODO: include code here if is necessary

    }
      state.grade = "0";
    // TODO: include code here if is necessary

  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // TODO: include code here if is necessary
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");
    view.get().onDataUpdated(mediator.getGradeState());
    // TODO: include code here if is necessary

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
    passStateToPreviousScreen(mediator.getNextStudentScreenState());
    view.get().navigateToPreviousScreen();
    // TODO: include code here if is necessary
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
    mediator.getNextStudentScreenState();
    // TODO: include code here if is necessary
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");

    // TODO: include code here if is necessary
  }


  @Override
  public void onHigherGradeBtnClicked() {


    if (mediator.getStudentState().equals(R.id.btnOutstandingGrade)){
      state.grade = "10";

    }else if (mediator.getStudentState().equals(R.id.btnMentionGrade)){
      state.grade = "8";

    }else if (mediator.getStudentState().equals(R.id.btnPassGrade)){
      state.grade = "6";
    }

    // TODO: include code here if is necessary

  }

  @Override
  public void onLowerGradeBtnClicked() {
    if (mediator.getStudentState().equals(R.id.btnOutstandingGrade)){
      state.grade = "9";

    }else if (mediator.getStudentState().equals(R.id.btnMentionGrade)){
      state.grade = "7";

    }else if (mediator.getStudentState().equals(R.id.btnPassGrade)){
      state.grade = "5";
    }
    // TODO: include code here if is necessary

  }

  private void passStateToPreviousScreen(GradeToStudentState state) {
    mediator.setPreviousGradeScreenState(state);
  }

  private StudentToGradeState getStateFromPreviousScreen() {
    return mediator.getPreviousGradeScreenState();
  }

  @Override
  public void injectView(WeakReference<GradeContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(GradeContract.Model model) {
    this.model = model;
  }

}
