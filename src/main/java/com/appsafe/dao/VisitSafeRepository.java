package com.appsafe.dao;

import com.appsafe.model.Stores;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitSafeRepository extends CrudRepository<Stores,Long> {


    @Query(value = "select num_of_people\n" +
            "from timings t\n" +
            "inner join stores_details s\n" +
            "on t.store_id = s.id\n" +
            "where store_name = :storeName AND store_location = :location AND start_hour = :startHr AND end_hour = :endHr",nativeQuery = true)
    Integer findNumOfPeople(@Param("storeName") String storeName, @Param("location") String storeLocation,
                            @Param("startHr") String startTime, @Param("endHr") String endTime);


}