package untitled.aa.domain;

import untitled.aa.domain.E;
import untitled.aa.BoundedContext366Application;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="A_table")
@Data

public class A  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;

    @PostPersist
    public void onPostPersist(){


        E e = new E(this);
        e.publishAfterCommit();

    }

    public static ARepository repository(){
        ARepository aRepository = BoundedContext366Application.applicationContext.getBean(ARepository.class);
        return aRepository;
    }






}
