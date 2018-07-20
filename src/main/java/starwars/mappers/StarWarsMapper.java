package starwars.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StarWarsMapper {

	void insertPlanetDetails(@Param("planetName") String planetName, @Param("postingOperatorId") String postingOperatorId);
}
