package ie.gtludwig.simpsons.service.generic;

import ie.gtludwig.simpsons.persistence.model.BasePojo;

public interface CrudService<Pojo extends BasePojo> extends Service {

    // CRUD methods
    void create(Pojo pojo);

    Pojo retrieve(final String id);

    void update(Pojo pojo);

    void delete(Pojo pojo);
}