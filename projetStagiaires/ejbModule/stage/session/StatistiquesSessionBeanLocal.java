package stage.session;

import java.util.List;

import javax.ejb.Local;

@Local
public interface StatistiquesSessionBeanLocal {
	List<Long> getNombreStagiairesParStatut();
    List<Long> getNombreStagesParStatut();
    List<Long> getNombreEncadrantsParStatut();

}