package ie.gtludwig.citi.simpsons.service.generic;

import ie.gtludwig.citi.simpsons.persistence.model.BasePojo;

public interface CrudService<Pojo extends BasePojo> extends Service {

    // CRUD methods
    void create(Pojo pojo);

    Pojo retrieve(final String id);

    void update(Pojo pojo);

    void delete(Pojo pojo);
}