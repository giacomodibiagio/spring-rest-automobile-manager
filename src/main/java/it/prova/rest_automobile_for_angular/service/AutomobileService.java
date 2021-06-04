package it.prova.rest_automobile_for_angular.service;

import java.util.List;

import it.prova.rest_automobile_for_angular.model.Automobile;
import org.springframework.data.domain.Page;



public interface AutomobileService {

	List<Automobile> listAll();

	Page<Automobile> searchAndPaginate(Automobile automobileExample, Integer pageNo, Integer pageSize, String sortBy);

	Automobile get(Long idInput);

	Automobile save(Automobile input);

	void delete(Automobile input);

}
