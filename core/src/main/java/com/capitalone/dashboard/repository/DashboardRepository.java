package com.capitalone.dashboard.repository;

import com.capitalone.dashboard.model.Dashboard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * {@link Dashboard} repository.
 */
public interface DashboardRepository extends PagingAndSortingRepository<Dashboard, ObjectId> {
	
	List<Dashboard> findByOwner(String owner);
	List<Dashboard> findByTitle(String title);

	@Query(value="{'type': {$in : [null, 'Team']}}")
	List<Dashboard> findTeamDashboards();

	@Query(value="{'widgets.options.teams.collectorItemId': ?0 }")
	List<Dashboard> findProductDashboardsByTeamDashboardCollectorItemId(String teamDashboardCollectorItemId);

}
