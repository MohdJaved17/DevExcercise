package info.evolenthealth.InfoApi.dao;

import info.evolenthealth.InfoApi.model.Info;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoDao extends CrudRepository<Info, String> {

}
