package untitled.aa.domain;

import untitled.aa.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="as", path="as")
public interface ARepository extends PagingAndSortingRepository<A, Long>{

}
