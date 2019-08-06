package com.sample.repository.backend;

import com.sample.entity.backend.UpdateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateRepository extends CrudRepository<UpdateEntity, Long> {

  @Query("select a from UpdateEntity a where a.id in ?1")
  List<UpdateEntity> findUpdateByIds(List<Long> updateIds);

  @Query("select a from UpdateEntity a where a.id in ?1")
  UpdateEntity findUpdateById(Long updateId);
}
