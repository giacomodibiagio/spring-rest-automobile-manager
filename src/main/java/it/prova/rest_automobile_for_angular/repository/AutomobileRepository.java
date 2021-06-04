package it.prova.rest_automobile_for_angular.repository;

import it.prova.rest_automobile_for_angular.model.Automobile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface AutomobileRepository extends PagingAndSortingRepository<Automobile, Long>, JpaSpecificationExecutor<Automobile>{

}
