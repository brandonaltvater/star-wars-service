package starwars.utils.trim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import starwars.exceptions.RestException;

import java.util.Arrays;
import java.util.List;

/**
 * @author Brandon.Altvater
 */
class TrimUtility {

	private static final Logger logger = LoggerFactory.getLogger(TrimUtility.class);
	private static final String TRIMMING_SUCCESSFUL = "String trimming successful";

	private TrimUtility() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Takes in an object as a parameter and trims whitespace from all of
	 * its String fields.
	 *
	 * @param object an object containing String fields in need of trimming
	 */
	static void trim(Object object) {

		trimObject(object);
		logger.debug(TRIMMING_SUCCESSFUL);
	}

	/**
	 * Takes in a list as a parameter and trims whitespace from all of
	 * its objects' String fields.
	 *
	 * @param list a list containing objects with String fields in need of trimming
	 */
	static void trim(List<?> list) {

		list.forEach(TrimUtility::trimObject);
		logger.debug(TRIMMING_SUCCESSFUL);
	}

	/**
	 * For loop used to perform whitespace trimming on an object's String
	 * fields
	 *
	 * @param object an object containing String fields which will be trimmed
	 */
	private static void trimObject(Object object) {

		if (object instanceof List<?> && !CollectionUtils.isEmpty((List<?>) object)) {
			trim((List<?>) object);
		}

		Arrays.stream(object.getClass().getDeclaredFields()).forEach(field -> {
			try {
				field.setAccessible(true);
				Object value = field.get(object);

				if (value instanceof String) {
					String text = (String) value;
					field.set(object, text.trim());
				} else if (value != null && !ClassUtils.isPrimitiveOrWrapper(value.getClass())) {
					trim(value);
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage());
				throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
			}
		});
	}
}
