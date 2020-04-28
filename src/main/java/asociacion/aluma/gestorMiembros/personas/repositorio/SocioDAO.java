package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import asociacion.aluma.gestorMiembros.personas.Socio;

//@Repository
@RepositoryRestResource(path="associates", itemResourceRel = "associate" , collectionResourceRel = "associates")
public interface SocioDAO extends JpaRepository<Socio , String>{

}
