package stage.session;

import java.util.List;

import javax.ejb.Local;

import stage.entities.Cadre;
import stage.entities.Stage;

@Local
public interface StageSessionLocal {
	public void addStage(Stage a);
	public void deleteStage(int Id);
	public void updateStage(Stage a);
	public List<Stage> getallStage();
	public Stage getStageById(int stageId);
	List<Stage> getallStageNonAffecter();
}
